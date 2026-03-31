package com.poli.market.implement;

import com.poli.market.facade.ProveedoresService;
import org.springframework.stereotype.Service;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
    @Override
    public void solicitarProducto(String producto) {
        System.out.println("Solicitando producto a proveedor: " + producto);
    }

    @Override
    public String obtenerProveedor(String producto) {
        return "ProveedorX";
    }
}
