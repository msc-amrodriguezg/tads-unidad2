package com.poli.market.rest;

import com.poli.market.facade.RecursosHumanosService;
import com.poli.market.facade.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private RecursosHumanosService rrhhService;
    @Autowired
    private VentasService ventasService;
    @PostMapping("/realizar")
    public String realizarVenta(@RequestParam String vendedorId,
                                @RequestParam String producto,
                                @RequestParam String cliente) {

        if (!rrhhService.autorizarVendedor(vendedorId)) {
            return "Vendedor no autorizado";
        }

        ventasService.realizarVenta(producto, cliente);
        return "Venta procesada";
    }
}
