package ru.gb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.gb.model.Product;

public interface ProductDao extends MongoRepository<Product, String> {
}