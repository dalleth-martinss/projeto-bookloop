package br.com.bookloop.bookloop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookloop.bookloop.entities.Payment;
import br.com.bookloop.bookloop.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Retornar todos os pagamentos
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    // Encontrar pagamento por ID
    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }

    // Criar um novo pagamento
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Atualizar um pagamento
    public Payment update(Integer id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);  // Definir o ID do pagamento para garantir a atualização
            return paymentRepository.save(payment);
        }
        return null;
    }

    // Excluir um pagamento
    public boolean delete(Integer id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
