package Entidades;

import Interfaces.Movimiento;

public class Producto implements Movimiento {
    private String nombre;
    private double precio;
    private int referencia;
    private String categoria;
    private int cantidad;

    // Constructor
    public Producto(int reference, String name) {
        this.referencia = reference;
        setNombre(name);
    }

    // Renombrar producto
    public void setNombre(String name) {
        this.nombre = name;
    }

    // Cambiar precio
    public void setPrecio(double price) {
        this.precio = price;
    }

    // Asignar categoría
    public void setCategoria(String category) {
        this.categoria = category;
    }

    // mostrar nombre
    public String getNombre() {
        return this.nombre;
    }

    // Mostrar precio
    public double getPrecio() {
        return this.precio;
    }

    // Mostrar referencia
    public int getReferencia() {
        return this.referencia;
    }

    // Mostrar categoría
    public String getCategoria() {
        return this.categoria;
    }

    // Mostrar cantidad
    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public void setSalida(int cant) {
        this.cantidad -= cant;
    }

    @Override
    public void setIngreso(int cant) {
        this.cantidad += cant;
    }
}
