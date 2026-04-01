package com.poli.market.rest;

import com.poli.market.facade.BodegaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bodega")
@Tag(name = "Bodega", description = "Operaciones relacionadas con el inventario y la bodega del mercado")
public class BodegaController {

    @Autowired
    private BodegaService bodegaService;

    @PostMapping("/listaProductos")
    @Operation(
            summary = "Listar productos disponibles",
            description = "Consulta la disponibilidad de un producto en la bodega e imprime el listado de productos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Parámetro de producto inválido")
    })
    public ResponseEntity<String> listaProducto(
            @Parameter(description = "Nombre del producto a consultar", required = true, example = "Manzanas")
            @RequestParam String producto) {
        System.out.println("listado productos");
        boolean disponible = bodegaService.verificarDisponibilidad(producto);
        return ResponseEntity.ok("Producto: " + producto + " - Disponible: " + disponible);
    }
}
