package br.com.bookloop.bookloop.repository;

import br.com.bookloop.bookloop.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // Aqui dá pra adicionar métodos customizados se quiser buscar por Cart ou Book depois
}
