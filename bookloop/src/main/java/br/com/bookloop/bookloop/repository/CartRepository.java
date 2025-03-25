package br.com.bookloop.bookloop.repository;

import br.com.bookloop.bookloop.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Aqui você pode adicionar métodos customizados, se necessário
}
