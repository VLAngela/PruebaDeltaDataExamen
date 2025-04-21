
package com.AVazquez.PruebaDeltaData.ML;


public class CreditoRangos {
    private String rango_monto;
    private int cantidad_creditos;
    
    public CreditoRangos(String rango_monto, int cantidad_creditos){
    this.rango_monto = rango_monto;
    this.cantidad_creditos = cantidad_creditos;
    }
    
    public CreditoRangos(){}

    public String getRango_monto() {
        return rango_monto;
    }

    public void setRango_monto(String rango_monto) {
        this.rango_monto = rango_monto;
    }

    public int getCantidad_creditos() {
        return cantidad_creditos;
    }

    public void setCantidad_creditos(int cantidad_creditos) {
        this.cantidad_creditos = cantidad_creditos;
    }
    
    
}
