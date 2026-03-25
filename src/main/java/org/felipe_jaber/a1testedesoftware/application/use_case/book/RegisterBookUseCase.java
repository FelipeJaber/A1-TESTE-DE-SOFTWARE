package org.felipe_jaber.a1testedesoftware.application.use_case.book;

import org.felipe_jaber.a1testedesoftware.application.mapper.BookMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.domain.repository.AuthorRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.BookRepository;
import org.felipe_jaber.a1testedesoftware.web.records.in.BookRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.BookResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class RegisterBookUseCase {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    public RegisterBookUseCase(BookRepository repository, AuthorRepository authorRepository, BookMapper mapper) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public BookResponse execute(BookRequest request) {
        if (repository.findByIsbn(request.isbn()).isPresent()) {
            throw new RuntimeException("Book with ISBN " + request.isbn() + " already exists");
        }

        Author author = authorRepository.findById(request.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = mapper.toEntity(request);
        book.setId(UUID.randomUUID());
        book.setAuthor(author);
        repository.save(book);

        return mapper.toResponse(book);
    }
}
