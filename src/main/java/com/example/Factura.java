package com.example;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.time.LocalDate;


public class Factura {
    private String IDfactura;
    private String Descripcion;
    private int Importe;
    private ZonedDateTime Fecha;
    private int Cantidad;


    public Factura(String Descripcion,int Importe, int Cantidad){
        this();
        this.Descripcion=Descripcion;
        this.Importe=Importe;
        this.Cantidad = Cantidad;
    }

    public Factura(){
        this.Fecha = ZonedDateTime.now(
                ZoneId.of("America/Bogota"));
        this.IDfactura = String.format("FACTURA#_%s", UUID.randomUUID().toString());
    }
    
    int importe(){
        return Importe;
    }

    public String iDfactura() {
        return IDfactura;
    }

    public int cantidad() {
        return Cantidad;
    }

    public String descripcion() {
        return Descripcion;
    }

    public String fecha() {
        return Fecha.format(DateTimeFormatter.ofPattern( "MM/dd/uuuu HH:mm"));
    }

    @Override
    public String toString() {
        return "===> Factura{ " +
                "IDfactura='" + IDfactura + '\'' +
                "\n Descripcion='" + Descripcion + '\'' +
                "\n Importe=" + Importe +
                "\n Fecha=" + fecha() +
                "\n Cantidad=" + Cantidad +
                '}';
    }
}
