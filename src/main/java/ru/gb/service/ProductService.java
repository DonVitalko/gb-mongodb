package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.gb.dao.ProductDao;
import ru.gb.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public Product save(final Product product){
        return productDao.save(product);
    }

    public Product findById(String id){
        return productDao.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public void deleteById(String id){
        try{
            productDao.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            e.getMessage();
        }
    }
}