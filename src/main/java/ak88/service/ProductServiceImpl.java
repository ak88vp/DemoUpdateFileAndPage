package ak88.service;

import ak88.model.Product;
import ak88.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Optional<Product> save(Product product) {
        iProductRepository.save(product);
        return null;
    }
    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }
    @Override
    public Page<Product> findByNameContaining(String name, Pageable pageable) {
        return iProductRepository.findByNameContaining(name, pageable);
    }
    @Override
    public Page<Product> findAllByOrderByPriceDesc() {
        return (Page<Product>) iProductRepository.findAllByOrderByPriceDesc();
    }

}
