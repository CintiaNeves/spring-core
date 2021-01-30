package br.com.pdi.springcore.controller;

import br.com.pdi.springcore.domain.Customer;
import br.com.pdi.springcore.domain.Product;
import br.com.pdi.springcore.service.ProductService;
import br.com.pdi.springcore.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/productForm";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("product", new Product());
        return "product/productForm";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Product product){
        Product productSaved = productService.saveOrUpdate(product);
        return "redirect:/product/show/" + productSaved.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}
