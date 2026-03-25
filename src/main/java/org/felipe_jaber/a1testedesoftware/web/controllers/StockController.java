package org.felipe_jaber.a1testedesoftware.web.controllers;

import org.felipe_jaber.a1testedesoftware.application.use_case.stock.UpdateStockUseCase;
import org.felipe_jaber.a1testedesoftware.web.records.in.StockRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.StockResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    private final UpdateStockUseCase updateStockUseCase;

    public StockController(UpdateStockUseCase updateStockUseCase) {
        this.updateStockUseCase = updateStockUseCase;
    }

    @PostMapping("/update")
    public ResponseEntity<StockResponse> updateStock(@RequestBody StockRequest request) {
        return ResponseEntity.ok(updateStockUseCase.execute(request));
    }
}
