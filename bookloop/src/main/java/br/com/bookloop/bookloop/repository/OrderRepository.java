package br.com.bookloop.bookloop.repository;

import br.com.bookloop.bookloop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Aqui você pode adicionar métodos específicos se quiser futuramente
}
