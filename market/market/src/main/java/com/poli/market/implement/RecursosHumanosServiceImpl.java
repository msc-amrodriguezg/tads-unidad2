package com.poli.market.implement;
import com.poli.market.facade.RecursosHumanosService;
import org.springframework.stereotype.Service;

@Service
public class RecursosHumanosServiceImpl implements RecursosHumanosService {

    @Override
    public boolean autorizarVendedor(String vendedorId) {
        return vendedorId != null && !vendedorId.isEmpty();
    }
}
