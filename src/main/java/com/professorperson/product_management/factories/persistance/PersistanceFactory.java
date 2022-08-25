package com.professorperson.product_management.factories.persistance;

import com.professorperson.product_management.factories.persistance.PersistanceAbstractFactory;
import com.professorperson.product_management.services.persistance.Persistance;

public class PersistanceFactory {
    public static Persistance getRepo(PersistanceAbstractFactory factory) {
        return factory.createRepo();
    }

    public Persistance findRepo(PersistanceAbstractFactory factory) {
        return factory.createRepo();
    }
}
