package ru.netology.manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    @Test
    public void addOneBook (){
        Book book1 = new Book(1, "book1", 450, "Author1");
        Book book2 = new Book(2, "book2", 300, "Author2");

        manager.add(book1);

        Product [] expected = {book1};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void addTwoBook (){
        Book book1 = new Book(1, "book1", 450, "Author1");
        Book book2 = new Book(2, "book2", 300, "Author2");

        manager.add(book1);
        manager.add (book2);

        Product [] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }
    @Test
    public void addTwoSmartphones (){
        Smartphone phone1 = new Smartphone(1,"Smart1",30000, "Factory1");
        Smartphone phone2 = new Smartphone(2, "Phone2", 45000, "Factory2" );

        manager.add(phone1);
        manager.add (phone2);

        Product [] expected = {phone1, phone2};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }
    @Test
    public void addOneSmartphones (){
        Smartphone phone1 = new Smartphone(1,"Smart1",30000, "Factory1");
        Smartphone phone2 = new Smartphone(2, "Phone2", 45000, "Factory2" );

        manager.add(phone1);

        Product [] expected = {phone1};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }
    @Test
    public  void findByNameBook(){
        Book book1 = new Book(1, "book1", 302,"Author1");
        Book book2 = new Book(2, "book2", 300, "Author2");
        Book book3 = new Book(3, "book3", 400, "Author1");
        Book book4 = new Book(4, "book4", 450, "Author2");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);


        Product [] expected = {book2};


        Assertions.assertArrayEquals(expected,  manager.searchBy("book2"));
    }
    @Test
    public void findSmartphone (){
        Smartphone phone1 = new Smartphone(1,"Smart1",30000, "Factory1");
        Smartphone phone2 = new Smartphone(2, "Phone2", 45000, "Factory2" );

        manager.add(phone1);
        manager.add(phone2);

        Product [] expected = {phone1};

        Assertions.assertArrayEquals(expected, manager.searchBy("Smart1") );
    }


}
