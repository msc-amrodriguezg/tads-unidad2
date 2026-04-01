package com.poli.market.rest;

import com.poli.market.facade.RecursosHumanosService;
import com.poli.market.facade.VentasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@Tag(name = "Ventas", description = "Operaciones para la gestión y procesamiento de ventas")
public class VentasController {

    @Autowired
    private RecursosHumanosService rrhhService;

    @Autowired
    private VentasService ventasService;

    @PostMapping("/realizar")
    @Operation(
            summary = "Realizar una venta",
            description = "Procesa una venta verificando que el vendedor esté autorizado y que el producto esté disponible en bodega. Retorna el resultado de la operación."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venta procesada exitosamente o vendedor no autorizado"),
            @ApiResponse(responseCode = "400", description = "Parámetros inválidos o faltantes")
    })
    public ResponseEntity<String> realizarVenta(
            @Parameter(description = "Identificador único del vendedor", required = true, example = "VND-001")
            @RequestParam String vendedorId,
            @Parameter(description = "Nombre del producto a vender", required = true, example = "Manzanas")
            @RequestParam String producto,
            @Parameter(description = "Nombre del cliente comprador", required = true, example = "Juan Pérez")
            @RequestParam String cliente) {

        if (!rrhhService.autorizarVendedor(vendedorId)) {
            return ResponseEntity.ok("Vendedor no autorizado");
        }

        ventasService.realizarVenta(producto, cliente);
        return ResponseEntity.ok("Venta procesada");
    }
}

