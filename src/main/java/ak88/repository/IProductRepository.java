package ak88.repository;

import ak88.model.Category;
import ak88.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    Iterable<Product> findAllByOrderByPriceDesc();
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByOrderByPriceDesc(Pageable pageable);
    Page<Product> findAllByCategory(Category category, Pageable pageable);
}
