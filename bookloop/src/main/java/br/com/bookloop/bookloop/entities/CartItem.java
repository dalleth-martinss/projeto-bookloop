package br.com.bookloop.bookloop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Renomeado de cartItem_id para seguir convenção

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    // Removido o campo cartCartId que parecia redundante

    // Corrigido relacionamento com Cart
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    // Corrigido relacionamento com Book
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}