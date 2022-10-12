package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class RepositoryTest {
    ProductRepository repo = new ProductRepository();

    @Test
    public void removeOneBook() {
        Book book1 = new Book(1, "book1", 200, "Author1");
        Book book2 = new Book(2, "book2", 250, "Author2");
        Book book3 = new Book(3, "book3", 300, "Author1");
        Book book4 = new Book(4, "book4", 350, "Author2");

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.removeById(3);

        Product[] expected = {book1, book2, book4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOneSmartphone() {
        Smartphone phone1 = new Smartphone(1, "Smart1", 30000, "Factory1");
        Smartphone phone2 = new Smartphone(2, "Phone2", 45000, "Factory2");

        repo.save(phone1);
        repo.save(phone2);
        repo.removeById(2);

        Product[] expected = {phone1};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }
}


