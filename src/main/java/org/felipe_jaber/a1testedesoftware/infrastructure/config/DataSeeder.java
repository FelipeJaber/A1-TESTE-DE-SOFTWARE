package org.felipe_jaber.a1testedesoftware.infrastructure.config;

import org.felipe_jaber.a1testedesoftware.domain.entity.*;
import org.felipe_jaber.a1testedesoftware.domain.repository.*;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.PhoneNumber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final EmployeeRepository employeeRepository;
    private final StockRepository stockRepository;
    private final SellRepository sellRepository;

    public DataSeeder(CustomerRepository customerRepository, AuthorRepository authorRepository,
                      BookRepository bookRepository, EmployeeRepository employeeRepository,
                      StockRepository stockRepository, SellRepository sellRepository) {
        this.customerRepository = customerRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.employeeRepository = employeeRepository;
        this.stockRepository = stockRepository;
        this.sellRepository = sellRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authorRepository.findAll(org.springframework.data.domain.Pageable.unpaged()).isEmpty()) {
            
            Author author1 = new Author();
            author1.setId(UUID.randomUUID());
            author1.setName("J.K. Rowling");
            author1.setNationality("British");
            authorRepository.save(author1);

            Author author2 = new Author();
            author2.setId(UUID.randomUUID());
            author2.setName("J.R.R. Tolkien");
            author2.setNationality("British");
            authorRepository.save(author2);

            Book book1 = new Book();
            book1.setId(UUID.randomUUID());
            book1.setTitle("Harry Potter and the Sorcerer's Stone");
            book1.setIsbn("9780590353427");
            book1.setAuthor(author1);
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setId(UUID.randomUUID());
            book2.setTitle("The Hobbit");
            book2.setIsbn("9780547928227");
            book2.setAuthor(author2);
            bookRepository.save(book2);

            Stock stock1 = new Stock();
            stock1.setId(UUID.randomUUID());
            stock1.setBook(book1);
            stock1.setQuantity(50);
            stockRepository.save(stock1);

            Stock stock2 = new Stock();
            stock2.setId(UUID.randomUUID());
            stock2.setBook(book2);
            stock2.setQuantity(30);
            stockRepository.save(stock2);

            Employee employee = new Employee();
            employee.setId(UUID.randomUUID());
            employee.setName("Admin User");
            employee.setRegistration("EMP001");
            employee.setPosition("Librarian");
            employeeRepository.save(employee);

            Customer customer = new Customer();
            customer.setId(UUID.randomUUID());
            customer.setName("John Doe");
            customer.setCpf(new CPF("12345678901"));
            customer.setEmail(new Email("john.doe@example.com"));
            customer.setNumber(new PhoneNumber("11999999999"));
            customerRepository.save(customer);

            Sell sell = new Sell();
            sell.setId(UUID.randomUUID());
            sell.setBook(book1);
            sell.setCustomer(customer);
            sell.setEmployee(employee);
            sell.setQuantity(1);
            sell.setPrice(new BigDecimal("39.90"));
            sell.setSellDate(LocalDateTime.now());
            sellRepository.save(sell);
        }
    }
}
