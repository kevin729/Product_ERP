package com.professorperson.product_management.services.persistance;

import java.util.List;

public interface Persistance {
    Object getById(int id);
    List<Object> getAll();
}
