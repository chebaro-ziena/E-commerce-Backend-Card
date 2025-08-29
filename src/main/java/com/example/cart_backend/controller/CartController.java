package com.example.cart_backend.controller;

import com.example.cart_backend.dto.CartDto;
import com.example.cart_backend.dto.CartItemDto;
import com.example.cart_backend.model.Cart;
import com.example.cart_backend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public CartDto getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/add")
    public Cart addItem(@PathVariable Long userId, @RequestBody CartItemDto itemDto) {
        return cartService.addItem(userId, itemDto);
    }

    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}