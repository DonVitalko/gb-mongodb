package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.dao.CartDao;
import ru.gb.model.Cart;
import ru.gb.model.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartDao cartDao;
    private final ProductService productService;

    public void save(Cart cart) {
        Cart savedCart;
        savedCart = (cart == null) ? new Cart() : cart;
        cartDao.save(savedCart);
    }

    public Cart findById(String id) {
        return cartDao.findById(id).orElse(null);
    }

    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    public void addProductToCartByProductId(String cartId, String productId) {
        Cart cart;
        if (cartId != null) {
            cart = findById(cartId);
        } else {
            throw new NoSuchElementException();
        }
        if (cart == null) {
            throw new NoSuchElementException();
        }
        if (productId != null) {
            Product product = productService.findById(productId);
            if (product != null) {
                cart.setProducts(Set.of(product));
            }
        }
        save(cart);
    }

    public void deleteProductFromCartByProductId(String cartId, String productId) {
        Cart cart;
        if (cartId != null) {
            cart = findById(cartId);
        } else {
            return;
        }
        Set<Product> products = cart.getProducts();
        products.removeIf(p -> p.getId().equals(productId));
        cart.setProducts(products);
        save(cart);
    }

    public void deleteCartById(String id){
        if (id != null){
            cartDao.deleteById(id);
        }
    }
}