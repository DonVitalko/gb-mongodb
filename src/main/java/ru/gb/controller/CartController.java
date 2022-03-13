package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Cart;
import ru.gb.service.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<Cart> showAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> showCart(@PathVariable("cartId") String id) {
        Cart cart;
        if (id != null) {
            cart = cartService.findById(id);
            if (cart != null) {
                return new ResponseEntity<>(cart, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewCart(Cart cart) {
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{cartId}")
    public ResponseEntity<?> addProductToCart(@PathVariable("cartId") String cartId, @RequestBody String productId) {
        cartService.addProductToCartByProductId(cartId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{cartId}/delete")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable("cartId") String cartId, @RequestBody String productId) {
        cartService.deleteProductFromCartByProductId(cartId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCart(@RequestParam String id) {
        cartService.deleteCartById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}