package br.com.bookloop.bookloop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // Alterado para plural como convenção
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Renomeado de user_id para seguir convenção

    @Column(name = "cpf", length = 12, nullable = false, unique = true)
    private String cpf;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @Column(name = "gender", length = 45)
    private String gender;

    @Column(name = "phone_number", length = 45)
    private String phoneNumber;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 60) // Aumentado para comportar senha hash
    private String password;

    @Column(name = "role", length = 45)
    private String role;

    // Corrigido relacionamento com Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    // Corrigido relacionamento com Cart
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    // Corrigido - removido relacionamento direto com CartItem que é redundante
    // (acessível via Cart)

    // Adicionamos aqui o relacionamento com Payment que estava declarado mas a entidade não foi fornecida
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    // Corrigido relacionamento com WishList
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishList> wishlists = new ArrayList<>();

    // Adicionado relacionamento com Books
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();
}
