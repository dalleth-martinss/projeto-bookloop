package br.com.bookloop.bookloop.repository;

import br.com.bookloop.bookloop.entities.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {
    // Aqui você pode adicionar métodos customizados depois, se quiser.
}
