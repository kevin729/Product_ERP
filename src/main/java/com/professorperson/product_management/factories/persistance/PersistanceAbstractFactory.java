package com.professorperson.product_management.factories.persistance;

import com.professorperson.product_management.services.persistance.Persistance;

public interface PersistanceAbstractFactory {
    Persistance createRepo();
}
