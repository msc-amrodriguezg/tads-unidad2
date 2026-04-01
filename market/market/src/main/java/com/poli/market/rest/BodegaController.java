package com.poli.market.rest;


import com.poli.market.facade.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private BodegaService bodegaService;
    @PostMapping("/listaProductos")
    public void listaProducto(@RequestParam String producto) {
        System.out.println("listado productos");

    }
}
