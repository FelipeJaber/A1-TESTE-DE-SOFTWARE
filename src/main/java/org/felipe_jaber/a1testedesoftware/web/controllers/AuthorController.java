package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.author.RegisterAuthorUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.AuthorRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.AuthorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final RegisterAuthorUseCase registerAuthorUseCase;

    public AuthorController(RegisterAuthorUseCase registerAuthorUseCase) {
        this.registerAuthorUseCase = registerAuthorUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthorResponse> register(@RequestBody AuthorRequest request) {
        return ResponseEntity.ok(registerAuthorUseCase.execute(request));
    }
}
