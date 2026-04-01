package com.poli.market.facade;

public interface BodegaService {
    boolean verificarDisponibilidad(String producto);
    void registrarSalida(String producto);
    void registrarEntrada(String producto);
}
