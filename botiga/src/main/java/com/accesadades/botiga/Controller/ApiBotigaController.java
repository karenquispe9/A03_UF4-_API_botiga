package com.accesadades.botiga.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DTO.SubCategoriaDTO;
import com.accesadades.botiga.Service.CategoriaServiceImpl;
import com.accesadades.botiga.Service.ProductServiceImpl;
import com.accesadades.botiga.Service.SubCategoriaServiceImpl;

@RestController
@RequestMapping("/api/botiga")
public class ApiBotigaController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @Autowired
    private SubCategoriaServiceImpl subCategoriaService;

    @GetMapping("/LlistarProductes")
    public List<ProductDTO> llistarProductes() {
        return productService.findAll();
    }
    @PostMapping("/inserirProducte")
    public ResponseEntity<String> inserirProducte(@RequestBody ProductDTO productDTO) {
        if (productDTO.getDesccategoria() == null || productDTO.getDescsubcategoria() == null) {
            return ResponseEntity.badRequest().body("El producto debe tener categoría y subcategoría válidas.");
        }
        productService.save(productDTO);
        return ResponseEntity.ok("Producto insertado exitosamente");
    }
    


    @GetMapping("/CercaProductes")
    public ProductDTO cercaProducte(@RequestParam String name) {
        return productService.findByName(name);
    }

    @PutMapping("/ModificarPreu")
    public void modificarPreu(@RequestParam Long id, @RequestParam Double newPrice) {
        ProductDTO productDTO = productService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Producte no trobat amb ID: " + id));
            productDTO.setPrice(newPrice.floatValue());
            productService.save(productDTO);
    }

    @GetMapping("/LlistarCategories")
    public List<CategoriaDTO> llistarCategories() {
        return categoriaService.findAll();
    }

    @PostMapping("/inserirCategoria")
    public void inserirCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.save(categoriaDTO);
    }

    @GetMapping("/LlistarSubcategories")
    public List<SubCategoriaDTO> llistarSubcategories() {
        return subCategoriaService.findAll();
    }

    @PostMapping("/inserirSubcategoria")
    public void inserirSubcategoria(@RequestBody SubCategoriaDTO subCategoriaDTO) {
        subCategoriaService.save(subCategoriaDTO);
    }

        @DeleteMapping("/eliminarProducte")
    public void eliminarProducte(@RequestParam Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/cercarProducteId")
    public ResponseEntity<ProductDTO> cercarProducteId(@RequestParam Long id) {
        return productService.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/modificarNom")
        public void modificarNom(@RequestParam Long id, @RequestParam String nouNom) {
        ProductDTO productDTO = productService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Producte no trobat amb ID: " + id));
        productDTO.setName(nouNom);
        productService.save(productDTO);
    }


}
