package com.professorperson.product_management.servlets;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.professorperson.product_management.factories.communication.CommunicationFactory;
import com.professorperson.product_management.factories.persistance.JDBConnectionFactory;
import com.professorperson.product_management.factories.persistance.PersistanceFactory;
import com.professorperson.product_management.services.persistance.Persistance;
import com.professorperson.product_management.services.persistance.users.JDBConnection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.professorperson.product_management.factories.communication.RESTFactory;
import com.professorperson.product_management.models.Log;
import com.professorperson.product_management.services.communication.Communication;


@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static HashMap<Object, Object> context = new HashMap();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context.clear();
		
		LinkedHashMap<String, String> pages = new LinkedHashMap();
		
		String path = request.getPathInfo();
		if (path != null) {
			path = path.replaceAll("/", "");
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/controller.xml");
			
			Document doc = builder.parse(is);
			
			Element screensElement = doc.getDocumentElement();
			NodeList screenNodeList = screensElement.getElementsByTagName("screen");
			
			for (int i = 0; i < screenNodeList.getLength(); i++) {
				Element screenElement = (Element) screenNodeList.item(i);
				
				String screenName = screenElement.getAttribute("name");
				
				//put uppercase and lowecase page name
				pages.put(screenName.substring(0, 1).toUpperCase().concat(screenName.substring(1)), screenName);
				
				if (screenName.equals(path)) {
					NodeList models = screenElement.getElementsByTagName("model");
					
					for (int m = 0; m < models.getLength(); m++) {
						Element modelElement = (Element) models.item(m);
						String script = modelElement.getTextContent();
						
						getClass().getMethod(script).invoke(this);
					}
					
					Element viewElement = (Element) screenElement.getElementsByTagName("view").item(0);
					String view = viewElement.getTextContent();
					
					request.setAttribute("context", context);
					request.getRequestDispatcher("/index.jsp").include(request, response);
					request.getRequestDispatcher(view).include(request, response);
					return;
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("/index.jsp").include(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void getEmployees() {
		Persistance repo = PersistanceFactory.getRepo(new JDBConnectionFactory());
		List<Object> employees = repo.getAll();
		context.put("employees", employees);
	}
	
	public void getLogs() {
		Communication rest = CommunicationFactory.get(new RESTFactory());
		String json = rest.send("https://lukemind.herokuapp.com/api/get_logs/1", "GET", "application/json", null);
		Log[] logs = new Gson().fromJson(json, Log[].class);
		context.put("logs", logs);
	}
	
	public void getProducts() {
		Communication rest = CommunicationFactory.get(new RESTFactory());
		String json = rest.send("https://lukemind.herokuapp.com/api/get_task_titles/1", "GET", "application/json", null);
		Map<String, double[]> products = new Gson().fromJson(json, Map.class);
		context.put("products", products);
	}
}
