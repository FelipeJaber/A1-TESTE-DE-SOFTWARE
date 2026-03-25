package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.book.RegisterBookUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.BookRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.BookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final RegisterBookUseCase registerBookUseCase;

    public BookController(RegisterBookUseCase registerBookUseCase) {
        this.registerBookUseCase = registerBookUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<BookResponse> register(@RequestBody BookRequest request) {
        return ResponseEntity.ok(registerBookUseCase.execute(request));
    }
}
