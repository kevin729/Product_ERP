import static org.junit.jupiter.api.Assertions.*;

import com.professorperson.product_management.factories.communication.CommunicationFactory;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import com.professorperson.product_management.factories.communication.RESTFactory;
import com.professorperson.product_management.factories.communication.SOAPFactory;
import com.professorperson.product_management.models.Product;
import com.professorperson.product_management.services.communication.Communication;

class CommunicationTests {

	@Test
	void restTest() {
		Communication connection = CommunicationFactory.get(new RESTFactory());
		String json = connection.send("https://lukemind.herokuapp.com/api/get_products/1", "GET", "text/plain", "");
		Gson gson = new Gson();
		
		Product[] product = gson.fromJson(json, Product[].class);
		assertEquals("LukeMind", product[0].getProductTitle());
	}
	
	@Test
	void soapTest() {
		Communication connection = CommunicationFactory.get(new SOAPFactory());
		String data = connection.send("https://lukemind.herokuapp.com/api/get_products/1", "GET", "text/plain", "");
		assertEquals("SOAP", data);
	}
}
