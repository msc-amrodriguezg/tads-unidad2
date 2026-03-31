package com.poli.market.implement;

import com.poli.market.facade.BodegaService;
import com.poli.market.facade.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodegaServiceImpl implements BodegaService {
    @Autowired
    private ProveedoresService proveedoresService;

    @Override
    public boolean verificarDisponibilidad(String producto) {
        return true;
    }

    @Override
    public void registrarSalida(String producto) {
        System.out.println("Salida de producto: " + producto);
    }

    @Override
    public void registrarEntrada(String producto) {
        System.out.println("Entrada de producto: " + producto);
    }
}
