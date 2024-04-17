package models;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public boolean addUsuario(Usuario usuario){
        return usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean addProducto(Producto producto){
        return productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "productos=" + productos +
                '}';
    }
}
