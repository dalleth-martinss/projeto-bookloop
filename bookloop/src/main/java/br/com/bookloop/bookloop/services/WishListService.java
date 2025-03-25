package br.com.bookloop.bookloop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookloop.bookloop.entities.WishList;
import br.com.bookloop.bookloop.repository.WishListRepository;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    public List<WishList> findAll() {
        return wishListRepository.findAll();
    }

    public Optional<WishList> findById(Integer id) {
        return wishListRepository.findById(id);
    }

    public WishList save(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    public WishList update(Integer id, WishList wishList) {
        if (wishListRepository.existsById(id)) {
            wishList.setId(id); // garante que está atualizando o ID correto
            return wishListRepository.save(wishList);
        }
        return null;
    }

    public void delete(Integer id) {
        wishListRepository.deleteById(id);
    }
}
