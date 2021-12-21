package ak88.service;

import ak88.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService extends IGeneralService<Product>{
    Page<Product> findByNameContaining( String name, Pageable pageable);
    Page<Product> findAllByOrderByPriceDesc();
    Page<Product> findAll(Pageable pageable);
}
