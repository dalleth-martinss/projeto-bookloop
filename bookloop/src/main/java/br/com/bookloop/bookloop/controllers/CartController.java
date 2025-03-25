package br.com.bookloop.bookloop.controllers;

import br.com.bookloop.bookloop.entities.Cart;
import br.com.bookloop.bookloop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // GET - Listar todos os carrinhos
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.findAll();
        return ResponseEntity.ok(carts);
    }

    // GET - Buscar carrinho por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
        return cartService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - Criar novo carrinho
    @PostMapping
    public ResponseEntity<Cart> createCart(@Validated @RequestBody Cart cart) {
        Cart savedCart = cartService.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    // PUT - Atualizar carrinho
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Integer id,
                                           @RequestBody Cart cart) {
        Cart updatedCart = cartService.update(id, cart);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Deletar carrinho
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
        try {
            cartService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
