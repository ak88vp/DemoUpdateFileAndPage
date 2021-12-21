package ak88.controller;

import ak88.model.Category;
import ak88.model.Product;
import ak88.model.Update;
import ak88.service.CategoryService;
import ak88.service.ProductService;
import ak88.service.UpdateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }


    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable, String key) {
        Page<Product> products;
        if (key != null) {
            model.addAttribute("products", productService.findByNameContaining(key, pageable));
            model.addAttribute("key",key);
        } else {
            products = productService.findAll(pageable);
            model.addAttribute("products", products);
            model.addAttribute("key",key);
        }
        return "/list";
    }
    @PostMapping("save")
    public String updateFile(Update update) throws IOException {
        UpdateFileService updateFileService=new UpdateFileService();
        updateFileService.UpdateFile(update.getMultipartFile());
        return "redirect:/products";
    }

    @GetMapping("create")
    public String showCreate() {
        return "/create";
    }

    @PostMapping("create")
    public String createProduct(Product product, Long idCategory) {
        Optional<Category> category = categoryService.findById(idCategory);
        product.setCategory(category.get());
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/products";
    }

    @GetMapping("edit/{id}")
    public String showEdit(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public String editProduct(Long idCategory, Product product) {
        Optional<Category> category = categoryService.findById(idCategory);
        product.setCategory(category.get());
        productService.save(product);
        return "redirect:/products";
    }
}
