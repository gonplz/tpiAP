package org.repository;

public interface CrudRepositorie<T> {

        void create(T t);
        void update(T t);
        void delate(T t);
        T retrive(int id);
        T retriveAll();
}
