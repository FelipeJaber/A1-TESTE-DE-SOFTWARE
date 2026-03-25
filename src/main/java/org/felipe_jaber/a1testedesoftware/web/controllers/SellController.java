package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.sells.ProcessSellUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.SellRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.SellResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sells")
public class SellController {
    private final ProcessSellUseCase processSellUseCase;

    public SellController(ProcessSellUseCase processSellUseCase) {
        this.processSellUseCase = processSellUseCase;
    }

    @PostMapping("/process")
    public ResponseEntity<SellResponse> processSell(@RequestBody SellRequest request) {
        return ResponseEntity.ok(processSellUseCase.execute(request));
    }
}
