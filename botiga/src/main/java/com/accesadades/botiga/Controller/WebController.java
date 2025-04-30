package com.accesadades.botiga.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Service.ProductServiceImpl; 

@Controller
public class WebController {

    @Autowired
    private ProductServiceImpl productService; 

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        List<ProductDTO> productDTOs = productService.findAll();
        model.addAttribute("products", productDTOs);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            ProductDTO productDTO = productService.findByName(name); 
            model.addAttribute("product", productDTO);
        }
        return "search";
    }

    
    @GetMapping("/newproduct")
        public String mostrarFormularioNuevoProducto(Model model) {
            model.addAttribute("product", new ProductDTO());
            return "newproduct";  
    }

    @PostMapping("/inserirProducte")
        public String inserirProducte(@ModelAttribute ProductDTO productDTO) {
        productService.save(productDTO); 
        return "redirect:/catalog";  
    }

}
