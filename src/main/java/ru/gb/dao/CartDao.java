package ru.gb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.gb.model.Cart;

public interface CartDao extends MongoRepository<Cart, String> {
}