package com.professorperson.product_management.factories.persistance;

import com.professorperson.product_management.services.persistance.Persistance;
import com.professorperson.product_management.services.persistance.users.EntityConnection;

public class EntityConnectionFactory implements PersistanceAbstractFactory {
    @Override
    public Persistance createRepo() {
        return new EntityConnection();
    }
}
