package com.example.cart_backend.dto;


import com.example.cart_backend.dto.CartItemDto;
import java.util.List;

public class CartDto {
    private List<CartItemDto> items;

    public List<CartItemDto> getItems() { return items; }
    public void setItems(List<CartItemDto> items) { this.items = items; }
}