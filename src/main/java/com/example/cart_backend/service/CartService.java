package com.example.cart_backend.service;

import com.example.cart_backend.model.Cart;
import com.example.cart_backend.model.CartItem;
import com.example.cart_backend.dto.CartItemDto;
import com.example.cart_backend.dto.CartDto;
import com.example.cart_backend.repository.CartRepository;
import com.example.cart_backend.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public CartDto getCartByUserId(Long userId) {
        return cartRepository.findById(userId)
                .map(cart -> {
                    CartDto dto = new CartDto();
                    dto.setItems(cart.getItems().stream().map(item -> {
                        CartItemDto ci = new CartItemDto();
                        ci.setProductId(item.getProductId());
                        ci.setQuantity(item.getQuantity());
                        return ci;
                    }).collect(Collectors.toList()));
                    return dto;
                }).orElse(new CartDto());
    }

    public Cart addItem(Long userId, CartItemDto itemDto) {
        Cart cart = cartRepository.findById(userId).orElse(new Cart());
        cart.setUserId(userId);

        CartItem item = new CartItem();
        item.setProductId(itemDto.getProductId());
        item.setQuantity(itemDto.getQuantity());
        item.setPrice(itemDto.getPrice());
        item.setCart(cart);

        cart.getItems().add(item);

        cartRepository.save(cart);
        System.out.println("UserId: " + userId);
        System.out.println("CartItemDto: " + itemDto);
        System.out.println("CartRepository: " + cartRepository);
        return cart;
    }

    public void clearCart(Long userId) {
        cartRepository.deleteById(userId);
    }
}