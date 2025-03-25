package br.com.bookloop.bookloop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookloop.bookloop.entities.CartItem;
import br.com.bookloop.bookloop.repository.CartItemRepository;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> findById(Integer id) {
        return cartItemRepository.findById(id);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem update(Integer id, CartItem cartItem) {
        if (cartItemRepository.existsById(id)) {
            cartItem.setId(id);
            return cartItemRepository.save(cartItem);
        }
        return null;
    }

    public void delete(Integer id) {
        cartItemRepository.deleteById(id);
    }
}
