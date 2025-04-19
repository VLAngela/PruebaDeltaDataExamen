package com.AVazquez.PruebaDeltaData.ML;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Credito {

    private int id;
    private String cliente;
    private double monto;
    private double tasa_interes;
    private int plazo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_otorgamiento;

    public Credito(int id, String cliente, double monto, double tasa_interes, int plazo, Date fecha_otorgamiento) {
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.tasa_interes = tasa_interes;
        this.plazo = plazo;
        this.fecha_otorgamiento = fecha_otorgamiento;
    }

    public Credito() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasa_interes() {
        return tasa_interes;
    }

    public void setTasa_interes(double tasa_interes) {
        this.tasa_interes = tasa_interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Date getFecha_otorgamiento() {
        return fecha_otorgamiento;
    }

    public void setFecha_otorgamiento(Date fecha_otorgamiento) {
        this.fecha_otorgamiento = fecha_otorgamiento;
    }

}
