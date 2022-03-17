package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class App 
{
    public static void main( String[] args )
    {
// ------------------------------- Variables y creacion lista facturas  --------------------------------------

        // registros de la data
        Factura f=new Factura("ordenador",1000, 20);
        Factura f2=new Factura("movil",300, 10);
        Factura f3=new Factura("imporesora",200, 5);
        Factura f4=new Factura("imac",1500, 7);
        Factura f5=new Factura("imac PRO",10500, 19);
        Factura f8=new Factura("imac PRO XD",150000, 1);
        Factura f6=new Factura("imac otro PRO",15500, 400);
        Factura f7=new Factura("imac (not)PRO",1500000, 1);
        
        // generar una lista
        List<Factura> lista=new ArrayList<Factura>();
        
        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        // Formato para horas = MM/dd/uuuu HH:mm = 03/16/2020
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:mm");

        


// ------------------------------- Creacion predicamentos  --------------------------------------

        // Predicado factura con fecha mayor a
        LocalDateTime horaMayorA = LocalDateTime.parse("03/16/2022 20:20", formatter);
        Predicate<Factura> predicadoFechaMayor= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {

                return LocalDateTime.parse(t.fecha(), formatter).isAfter(horaMayorA);
            }
        };

        // Predicado es menor a
        LocalDateTime horaMenorA = LocalDateTime.parse("10/16/2023 20:20", formatter);

        Predicate<Factura> predicadoFechaMenor= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return LocalDateTime.parse(t.fecha(), formatter).isBefore(horaMenorA);
            }
        };

        // Predicado es mayor a numero requerido
        int precioABuscar1 = 400;

        Predicate<Factura> predicadoPrecioMayorA= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.importe()>precioABuscar1;
            }
        };

        // Predicado encontrar ID igual

        String factura4ID = f4.iDfactura();

        Predicate<Factura> predicadoMismoID= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.iDfactura().equals(factura4ID);
            }
        };

        // Predicado encontrar ID igual
        int CantidadIgual = 200;
        Predicate<Factura> predicadoIgualCantidad= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.cantidad() == CantidadIgual;
            }
        };

        // Predicado encontrar ID igual
        int CantidadMayor = 9;
        Predicate<Factura> predicadoMayorCantidad= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.cantidad() > CantidadMayor;
            }
        };

        // Predicado encontrar ID igual
        int CantidadMenor = 20;
        Predicate<Factura> predicadoMenorCantidad= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                return t.cantidad() < CantidadMenor;
            }
        };


        List<Factura> facturaFiltro=lista.stream()
                .filter(predicadoMayorCantidad).collect(Collectors.toList());

        if(facturaFiltro.isEmpty()) System.out.println(
                "__ERROR: No se encontraron Facturas con cantidades iguales a 200");
        else facturaFiltro.forEach(factura -> System.out.println(factura.toString()));


        /*
        // filtraje funcional con streams
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println(facturaFiltro.getImporte());
        */
    }
}
