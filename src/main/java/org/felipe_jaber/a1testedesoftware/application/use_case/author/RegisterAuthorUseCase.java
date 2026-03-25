package org.felipe_jaber.a1testedesoftware.application.use_case.author;

import org.felipe_jaber.a1testedesoftware.application.mapper.AuthorMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.felipe_jaber.a1testedesoftware.domain.repository.AuthorRepository;
import org.felipe_jaber.a1testedesoftware.web.records.in.AuthorRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.AuthorResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class RegisterAuthorUseCase {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    public RegisterAuthorUseCase(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AuthorResponse execute(AuthorRequest request) {
        Author author = mapper.toEntity(request);
        author.setId(UUID.randomUUID());
        repository.save(author);
        return mapper.toResponse(author);
    }
}
