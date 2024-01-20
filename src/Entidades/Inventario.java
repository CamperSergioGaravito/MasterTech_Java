package Entidades;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.AsignarBodega;
import Interfaces.CrearProd;
import Interfaces.Movimiento;

public class Inventario implements AsignarBodega, CrearProd, Movimiento {
    private String almacen;
    private Map<Integer,String> referencias = new HashMap<>();
    private Map<String,List<Producto>> productosXcategoria = new HashMap<>();
    private Set<String> categorias = new LinkedHashSet<>(
                                                            Arrays.asList(
                                                                "Computadores",
                                                                "Celulares",
                                                                "Electrodomésticos",
                                                                "TV",
                                                                "Accesorios",
                                                                "Videojuegos",
                                                                "Audio y video"
                                                            )
                                                        );

    // Constructor
    public Inventario(String bodega) {
        setBodega(bodega);
    }

    // Asignar bodega
    @Override
    public void setBodega(String bodega) {
        this.almacen = bodega;
    }

    // Mostrar bodega
    public String getBodega() {
        return this.almacen;
    }

    // Crear producto
    @Override
    public void setAsignarReferencia(int ref) {
        // validar duplicidad
        
    }

    // Ingreso de productos
    @Override
    public void setIngreso(int cant) {

    }

    // Salida de productos
    @Override
    public void setSalida(int cant) {

    }

    // Mostrar categorías
    public void getCategorias(boolean salir) {
        System.out.println(
            "\n##################################################\n" +
            "#                     Categorías                 #\n" +
            "##################################################" 
        );

        int contador = 0;

        for (String categoria : categorias) {
            ++contador;
            System.out.println("# " + (contador) + ") " + categoria);
        }
        
        if(salir) {
            System.out.println(
                "# " + (categorias.size() + 1) + ") Regresar"
            );
        }
        else {}
        System.out.println("\n##################################################");
    }

    // Obtener conjunto categorías
    public int getCantCategorias() {
        return this.categorias.size();
    }

    // Modificar categorías
    public boolean setCategorias(String category) {
        return this.categorias.add(category);
    }

    // Buscar categoría
    private String getBuscarCategoria(int value) {
        String cat = "No encontrado";
        int contador = 0;
        for (String categoria : categorias) {
            ++contador;
            if(contador == value) {
                cat = categoria;
                break;
            }
            else {}
        }
        return cat;
    }

    // Crear estante
    public boolean setCrearEstante(int posicion) {
        List<Producto> productos = new ArrayList<>();
        String categoria = getBuscarCategoria(posicion);
        if(!getValidarCategoria(categoria)) {
            return false;
        }
        else {
            productosXcategoria.put(categoria, productos);
            return true;
        }
    }

    // Validar categorías
    public boolean getValidarCategoria(String categoria) {
        if(productosXcategoria.containsKey(categoria)) {
            return false;
        }
        else {
            return true;
        }
    }

    // Validar estante
    public boolean getValidarEstante() {
        return productosXcategoria.size() == 0 ? false : true;
    }

    // Mostrar estante
    public void getMostrarEstante(boolean categoria, boolean productos) {
        System.out.println(
            "\n##################################################\n" +
            " * " + getBodega() + "\n" +
            "##################################################\n" 
        );

        for (Map.Entry<String,List<Producto>> entry: productosXcategoria.entrySet()) {
            if(categoria) {
                System.out.println("\n[*] " + entry.getKey());
            }
            else {}
            if(productos) {
                System.out.println("\n ---------------------- Productos ---------------------- ");
                if(entry.getValue().size() == 0 && categoria) {
                    System.out.println("\nSin productos asignados al estante.");
                }
                else {
                    for(int x = 0; x < entry.getValue().size(); x++) {
                        System.out.println((x+1) + ") " + entry.getValue().get(x));
                    }
                }

                System.out.println("\n-------------------------------------------------------- ");
            }
            else {}
        }

        System.out.println(
            "\n##################################################"
        );
    }
}
