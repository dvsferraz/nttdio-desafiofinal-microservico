package com.ntt.dio.productcatalog.service;

import com.ntt.dio.productcatalog.dto.ProductDTO;
import com.ntt.dio.productcatalog.model.Product;
import com.ntt.dio.productcatalog.repository.ProductRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    private List<ProductDTO> convertToDTOList(List<Product> products) {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(convertToDTO(product));
        }
        return productDTOs;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        product = productRepository.save(product);

        productDTO.setId(product.getId());

        return productDTO;
    }

    @Override
    public List<ProductDTO> listAll(){
        var products = productRepository.findAll();
        return convertToDTOList(products);
    }

    @Override
    public List<ProductDTO> findByName(String name){
        var products = productRepository.findByNameContaining(name);
        return convertToDTOList(products);
    }

    @Override
    public List<ProductDTO> findByDescription(String description){
        var products = productRepository.findByDescriptionContaining(description);
        return convertToDTOList(products);
    }

    @Override
    public List<ProductDTO> findByPrice(Double price){
        var products = productRepository.findByPrice(price);
        return convertToDTOList(products);
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        var product =productRepository.findById(id);
        return product.map(this::convertToDTO);
    }
}
