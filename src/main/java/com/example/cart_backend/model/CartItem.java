package com.example.cart_backend.model;

import com.example.cart_backend.model.Cart;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;
    private int quantity;
    private Double price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_user_id")
    private Cart cart;

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}