package ruh.ac.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ruh.ac.products.entity.Product;
import ruh.ac.products.service.ProductService;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listproducts = productService.getProducts();
        model.addAttribute("listproducts", listproducts);
        return "index";

    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";

    }

    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";

    }

    @RequestMapping("/edit/{id}")
        public ModelAndView showEditProductPage(@PathVariable(name = "id") long id){
            ModelAndView mav = new ModelAndView("edit_product");
            Product product = productService.getProductById(id);
            mav.addObject("product", product);
            return mav;
        }

    @RequestMapping("/delete/{id}")
        public String deleteProduct(@PathVariable(name = "id") long id){
          productService.delete(id);
          return "redirect:/";
    }

    }
