package ak88.service;


import ak88.model.Product;

import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Optional<Product> save(T t);
    void remove(Long id);
}
