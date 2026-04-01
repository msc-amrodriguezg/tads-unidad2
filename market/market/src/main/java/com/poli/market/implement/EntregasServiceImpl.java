package com.poli.market.implement;

import com.poli.market.facade.BodegaService;
import com.poli.market.facade.EntregasService;
import com.poli.market.facade.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregasServiceImpl implements EntregasService {

    @Autowired
    private VentasService ventasService;

    @Autowired
    private BodegaService bodegaService;

    @Override
    public void generarEntrega(String producto, String cliente) {
        System.out.println("Entrega generada para " + cliente);
        bodegaService.registrarSalida(producto);
    }
}
