
package br.com.bookloop.bookloop.controllers;

import br.com.bookloop.bookloop.entities.WishList;
import br.com.bookloop.bookloop.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishLists() {
        return ResponseEntity.ok(wishListService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishList> getWishListById(@PathVariable Integer id) {
        return wishListService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WishList> createWishList(@RequestBody WishList wishList) {
        return ResponseEntity.ok(wishListService.save(wishList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishList> updateWishList(@PathVariable Integer id, @RequestBody WishList wishList) {
        WishList updated = wishListService.update(id, wishList);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishList(@PathVariable Integer id) {
        wishListService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
