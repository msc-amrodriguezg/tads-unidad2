package com.poli.market.implement;

import com.poli.market.facade.BodegaService;
import com.poli.market.facade.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private BodegaService bodegaService;

    @Override
    public void realizarVenta(String producto, String cliente) {
        if (bodegaService.verificarDisponibilidad(producto)) {
            bodegaService.registrarSalida(producto);
            System.out.println("Venta realizada a " + cliente);
        } else {
            System.out.println("Producto no disponible");
        }
    }

    @Override
    public List<String> obtenerClientes() {
        return List.of();
    }

    @Override
    public List<String> obtenerProductos() {
        return List.of();
    }


}
