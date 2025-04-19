package com.AVazquez.PruebaDeltaData.ML;

public class CreditoPorMes {
    private String mes;
    private int totalCreditos;

    public CreditoPorMes(String mes , int totalCreditos) {
        this.mes = mes;
        this.totalCreditos = totalCreditos;
    }

  public CreditoPorMes(){}

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(int totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

}
