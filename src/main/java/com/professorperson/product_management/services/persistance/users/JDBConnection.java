package com.professorperson.product_management.services.persistance.users;

import com.professorperson.product_management.models.User;
import com.professorperson.product_management.services.persistance.Persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBConnection implements Persistance {
    Connection connection;

    public JDBConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lukesmindb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Chbiph7297#");
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public Object getById(int id) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE id = " + id);

            while (rs.next()) {
                User user = new User(rs.getString("username"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Object> getAll() {
        List<Object> users = new ArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                User user = new User(rs.getString("username"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
