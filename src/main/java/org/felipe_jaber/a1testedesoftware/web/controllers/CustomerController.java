package org.felipe_jaber.a1testedesoftware.web.controllers;

import jakarta.validation.Valid;
import org.felipe_jaber.a1testedesoftware.application.use_case.customer.GetAllUseCase;
import org.felipe_jaber.a1testedesoftware.application.use_case.customer.GetUseCase;
import org.felipe_jaber.a1testedesoftware.application.use_case.customer.RegisterUseCase;
import org.felipe_jaber.a1testedesoftware.application.use_case.customer.UpdateUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerRegistrationRequest;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerUpdateRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final RegisterUseCase registerUseCase;
    private final UpdateUseCase updateUseCase;
    private final GetUseCase getUseCase;
    private final GetAllUseCase getAllUseCase;

    public CustomerController(RegisterUseCase registerUseCase, UpdateUseCase updateUseCase, GetUseCase getUseCase, GetAllUseCase getAllUseCase) {
        this.registerUseCase = registerUseCase;
        this.updateUseCase = updateUseCase;
        this.getUseCase = getUseCase;
        this.getAllUseCase = getAllUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> registerCustomer(@RequestBody @Valid CustomerRegistrationRequest request){
        return ResponseEntity.ok(registerUseCase.execute(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable UUID id, @RequestBody @Valid CustomerUpdateRequest request){
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable UUID id){
        return ResponseEntity.ok(getUseCase.execute(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<CustomerResponse>> getCustomers(Pageable pageable){
        return ResponseEntity.ok(getAllUseCase.execute(pageable));
    }

}
