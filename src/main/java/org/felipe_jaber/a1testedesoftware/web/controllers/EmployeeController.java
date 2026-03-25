package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.employee.RegisterEmployeeUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.EmployeeRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    public EmployeeController(RegisterEmployeeUseCase registerEmployeeUseCase) {
        this.registerEmployeeUseCase = registerEmployeeUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeResponse> register(@RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(registerEmployeeUseCase.execute(request));
    }
}
