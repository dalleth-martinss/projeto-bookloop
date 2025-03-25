package br.com.bookloop.bookloop.repository;

import br.com.bookloop.bookloop.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Aqui você pode adicionar métodos personalizados se necessário no futuro.
}
