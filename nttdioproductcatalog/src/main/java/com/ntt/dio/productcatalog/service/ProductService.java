package com.ntt.dio.productcatalog.service;

import com.ntt.dio.productcatalog.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);

    List<ProductDTO> listAll();

    List<ProductDTO> findByName(String name);

    List<ProductDTO> findByDescription(String description);

    List<ProductDTO> findByPrice(Double price);

    Optional<ProductDTO> findById(Long id);
}
