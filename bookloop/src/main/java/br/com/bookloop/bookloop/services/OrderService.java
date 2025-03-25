package br.com.bookloop.bookloop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookloop.bookloop.entities.Order;
import br.com.bookloop.bookloop.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Encontrar todos os pedidos
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    // Encontrar pedido por ID
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    // Criar um novo pedido
    public Order save(Order order) {
        // Aqui você pode adicionar lógicas adicionais antes de salvar, como validações
        return orderRepository.save(order);
    }

    // Atualizar um pedido existente
    public Order update(Integer id, Order order) {
        // Verificar se o pedido já existe
        if (orderRepository.existsById(id)) {
            order.setId(id);  // Garantir que o ID seja o do pedido a ser atualizado
            return orderRepository.save(order);
        }
        // Caso o pedido não seja encontrado, retornar null (ou pode lançar exceção personalizada)
        return null;
    }

    // Excluir um pedido pelo ID
    public boolean delete(Integer id) {
        // Verificar se o pedido existe antes de deletar
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
