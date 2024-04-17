package models;

public class Producto {
   private String name;
   private String modelo;
   private Integer cantidad;
   private Integer precio;

   public Producto(String name, String modelo, Integer cantidad, Integer precio) {
      this.name = name;
      this.modelo = modelo;
      this.cantidad = cantidad;
      this.precio = precio;
   }

   public Integer getPrecio() {
      return precio;
   }

   public Integer getCantidad() {
      return cantidad;
   }

   public String getName() {
      return name;
   }

   public String getModelo() {
      return modelo;
   }

   @Override
   public String toString() {
      return "Producto{" +
              "name='" + name + '\'' +
              ", modelo='" + modelo + '\'' +
              ", cantidad=" + cantidad +
              ", precio=" + precio +
              '}';
   }
}
