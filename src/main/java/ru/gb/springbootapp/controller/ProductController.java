package ru.gb.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.springbootapp.dto.ProductDto;
import ru.gb.springbootapp.model.Product;
import ru.gb.springbootapp.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAllProduct(Model model){
        model.addAttribute("products",productService.getAll());
        return "product_list";
    }

    @GetMapping("/info/{id}")
    public String getProductInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findId(id));
        return "product_info";
    }

    @GetMapping("/add")
    public String getProductAddForm(){
        return "product_form";
    }

    @PostMapping("/add")
    public String saveProduct(Product product){
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String saveProduct(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/";
    }
}
