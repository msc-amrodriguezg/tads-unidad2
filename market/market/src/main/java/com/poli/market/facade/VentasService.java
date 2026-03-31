package com.poli.market.facade;

import java.util.List;

public interface VentasService {
    List<String> obtenerClientes();
    List<String> obtenerProductos();
    void realizarVenta(String producto, String cliente);
}
