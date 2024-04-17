package models;

import java.util.ArrayList;

public class Carrito {
   private   ArrayList<Producto> productos = new ArrayList<Producto>();

   public ArrayList<Producto> getProductos() {
      return productos;
   }

   public boolean addProducto(Producto producto){
      return productos.add(producto);
   }
}
