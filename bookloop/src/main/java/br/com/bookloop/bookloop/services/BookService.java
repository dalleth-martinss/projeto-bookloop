package br.com.bookloop.bookloop.services;

import br.com.bookloop.bookloop.entities.Book;
import br.com.bookloop.bookloop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book partialUpdate(Integer id, Map<String, Object> updates) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "title":
                    book.setTitle((String) value);
                    break;
                case "synopsis":
                    book.setSynopsis((String) value);
                    break;
                case "price":
                    book.setPrice(new BigDecimal(value.toString()));
                    break;
                case "category":
                    book.setCategory((String) value);
                    break;
                case "condition":
                    book.setCondition((String) value);
                    break;
                case "observations":
                    book.setObservations((String) value);
                    break;
                case "owner":
                    book.setOwner((String) value);
                    break;
                case "bookCover":
                    book.setBookCover((String) value);
                    break;
                case "availableForTrade":
                    book.setAvailableForTrade((Boolean) value);
                    break;
                case "availableForSale":
                    book.setAvailableForSale((Boolean) value);
                    break;
            }
        });

        return bookRepository.save(book);
    }

    public void deleteById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}