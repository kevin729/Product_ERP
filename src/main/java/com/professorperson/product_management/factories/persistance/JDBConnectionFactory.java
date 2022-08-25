package com.professorperson.product_management.factories.persistance;

import com.professorperson.product_management.services.persistance.Persistance;
import com.professorperson.product_management.services.persistance.users.JDBConnection;

public class JDBConnectionFactory implements PersistanceAbstractFactory {
    @Override
    public Persistance createRepo() {
        return new JDBConnection();
    }
}
