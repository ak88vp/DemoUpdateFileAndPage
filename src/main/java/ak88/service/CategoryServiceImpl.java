package ak88.service;

import ak88.model.Category;
import ak88.model.Product;
import ak88.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
    @Override
    public Optional<Product> save(Category category) {
        categoryRepository.save(category);
        return Optional.empty();
    }
    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
