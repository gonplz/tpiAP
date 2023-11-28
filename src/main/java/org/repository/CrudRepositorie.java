package org.repository;

import java.util.List;

public interface CrudRepositorie<T> {

        void create(T t);
        void update(T t);
        void delete(T t);
        T findById(int id);
         List<T>findAll();
}

