package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.customer.RegisterUseCase;
import org.felipe_jaber.a1testedesoftware.application.use_case.sells.ProcessSellUseCase;
import org.felipe_jaber.a1testedesoftware.domain.repository.BookRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.EmployeeRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.SellRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.StockRepository;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerRegistrationRequest;
import org.felipe_jaber.a1testedesoftware.web.records.in.SellRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final SellRepository sellRepository;
    private final StockRepository stockRepository;
    private final EmployeeRepository employeeRepository;
    private final RegisterUseCase registerCustomerUseCase;
    private final ProcessSellUseCase processSellUseCase;

    public DashboardController(
            BookRepository bookRepository,
            CustomerRepository customerRepository,
            SellRepository sellRepository,
            StockRepository stockRepository,
            EmployeeRepository employeeRepository,
            RegisterUseCase registerCustomerUseCase,
            ProcessSellUseCase processSellUseCase
    ) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.sellRepository = sellRepository;
        this.stockRepository = stockRepository;
        this.employeeRepository = employeeRepository;
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.processSellUseCase = processSellUseCase;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("bookCount", bookRepository.findAll(Pageable.unpaged()).getTotalElements());
        model.addAttribute("customerCount", customerRepository.findAll(Pageable.unpaged()).getTotalElements());
        model.addAttribute("sellCount", sellRepository.findAll(Pageable.unpaged()).getTotalElements());
        model.addAttribute("stockCount", stockRepository.findAll(Pageable.unpaged()).getTotalElements());
        return "index";
    }

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookRepository.findAll(Pageable.unpaged()).getContent());
        return "books";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerRepository.findAll(Pageable.unpaged()).getContent());
        return "customers";
    }

    @GetMapping("/sells")
    public String sells(Model model) {
        model.addAttribute("sells", sellRepository.findAll(Pageable.unpaged()).getContent());
        model.addAttribute("books", bookRepository.findAll(Pageable.unpaged()).getContent());
        model.addAttribute("customers", customerRepository.findAll(Pageable.unpaged()).getContent());
        model.addAttribute("employees", employeeRepository.findAll(Pageable.unpaged()).getContent());
        return "sells";
    }

    @GetMapping("/stock")
    public String stock(Model model) {
        model.addAttribute("stocks", stockRepository.findAll(Pageable.unpaged()).getContent());
        return "stock";
    }

    @PostMapping("/customers/register")
    public String registerCustomer(@ModelAttribute CustomerRegistrationRequest request) {
        registerCustomerUseCase.execute(request);
        return "redirect:/customers";
    }

    @PostMapping("/sells/process")
    public String processSell(@ModelAttribute SellRequest request) {
        processSellUseCase.execute(request);
        return "redirect:/sells";
    }
}
