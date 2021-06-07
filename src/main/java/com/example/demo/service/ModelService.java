package com.example.demo.service;

import com.example.demo.model.NewTaxi.TaxiDriver;

import java.util.List;

public interface ModelService <T> {
    T getByIDOrNull(int id);
    void insert(T item);
    boolean update(T item);
    boolean delete(T id);
    List<T> getList();
}
