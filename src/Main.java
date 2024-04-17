import models.Carrito;
import models.Tienda;
import models.Producto;
import models.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        boolean bandera = true;
        Tienda inventario=new Tienda();
        Carrito carrito=new Carrito();
        boolean validarCompra=false;
        Integer generarId=1000;
        ArrayList<Integer> guardarId = new ArrayList<Integer>();

        do {
            System.out.println("---------------------CARRITO DE COMPRAS------------------------");
            System.out.println("1.Registrate");
            System.out.println("2.Iniciar sesion");
            System.out.println("3.Acceder como admistrador");
            System.out.println("4.Salir");
            System.out.println("---------------------------------------------");
            System.out.println("Seleccione");
            int opcion=teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese su nombre: ");
                    String nombre=teclado.next();
                    System.out.println("Ingrese su apellido: ");
                    String apellido=teclado.next();
                    System.out.println("Cree una contraseña: ");
                    String contrasenia=teclado.next();
                    Usuario usuario=new Usuario(nombre,apellido,contrasenia);
                    inventario.addUsuario(usuario);
                    System.out.println("Bienvenido a CARRITO "+nombre);

                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("Ingrese su nombre");
                    String nombre1=teclado.next();
                    System.out.println("Ingrese su apellido");
                    String apellido1=teclado.next();
                    System.out.println("Ingrese su contraseña");
                    String contraseña1=teclado.next();
                    for (Usuario usuario2:inventario.getUsuarios()){
                        if (nombre1.equals(usuario2.getNombre())&&apellido1.equals(usuario2.getApellido())&&contraseña1.equals(usuario2.getContrasenia())) {}
                        boolean bandera2 = true;
                        do {
                            System.out.println("---------------------------CARRITO DE COMPRAS-------------------------");
                            System.out.println("------------------------------------------------PRODUCTOS-------------");
                            System.out.println("1.Productos");
                            System.out.println("2.Ver compras");
                            System.out.println("3.Salir");
                            int opcion2 = teclado.nextInt();
                            switch (opcion2){
                                case 1:
                                    if (!inventario.getProductos().isEmpty()) {
                                        System.out.println("------------------------PRODUCTOS-------------------------------");
                                        for (Producto pds : inventario.getProductos()) {
                                            System.out.println(pds.toString());
                                        }
                                        System.out.println("1.agregar productos a mi carrito");
                                        System.out.println("2.ver carrito");
                                        System.out.println("3.Salir");
                                        int desicion= teclado.nextInt();
                                        switch (desicion){
                                            case 1:
                                                System.out.println("Nombre de producto a agregar:");
                                                String namePr = teclado.next();
                                                System.out.println("Modelo de producto a agregar:");
                                                String model = teclado.next();
                                                System.out.println("Cantidad a agregar:");
                                                Integer cantidad = teclado.nextInt();
                                                for (Producto producto: inventario.getProductos()){
                                                    if (namePr.equals(producto.getName()) &&model.equals(producto.getModelo())){
                                                        Integer precio = producto.getPrecio();
                                                        Producto producto1 = new Producto(namePr, model, cantidad, precio);
                                                        if (cantidad <= producto.getCantidad()) {
                                                            carrito.addProducto(producto1);
                                                        } else {
                                                            System.out.println("No hay suficiente cantidad en el inventario.");
                                                        }
                                                    }else{
                                                        System.out.println("Producto no existe");
                                                    }
                                                }


                                                break;
                                            case 2:
                                                boolean aprobacion=true;
                                                if (!carrito.getProductos().isEmpty()) {
                                                    System.out.println("------------------------MI CARRITO-------------------------------");
                                                    for (Producto pds : carrito.getProductos()) {
                                                        System.out.println(pds.toString());

                                                    }
                                                    do {
                                                        System.out.println("1.COMPRAR PRODUCTOS DEL CARRITO");
                                                        System.out.println("2.Salir");
                                                        int accion= teclado.nextInt();
                                                        switch (accion){
                                                            case 1:
                                                                System.out.println("-------------------------------------------------------");
                                                                System.out.println("---------------------------------------REALIZAR COMPRA");
                                                                for (Producto productoCarrito: carrito.getProductos()){
                                                                    System.out.println(productoCarrito.toString());
                                                                    Integer total=productoCarrito.getCantidad()*productoCarrito.getPrecio();
                                                                    System.out.println("--------------------------------------------------");
                                                                    System.out.println("El total de su compra es: "+total);
                                                                }
                                                                System.out.println("Precione 1 para confirmar compra");
                                                                int confirmacion= teclado.nextInt();
                                                                if (confirmacion==1){
                                                                    generarId++;
                                                                    System.out.println("Gracias por su compra esta en proceso de validacion");
                                                                    System.out.println("Su compra genero el ID"+generarId);
                                                                    guardarId.add(generarId);

                                                                }else {
                                                                    System.out.println("cancelando compra");
                                                                }

                                                                break;
                                                            case 2:
                                                                aprobacion=false;
                                                                break;
                                                        }

                                                    }while (aprobacion);

                                                }else {
                                                    System.out.println("No hay productos");
                                                }
                                                break;

                                            case 3:
                                                bandera2=false;
                                                break;
                                        }
                                    }else {
                                        System.out.println("No hay productos");
                                    }

                                    break;
                                case 2:
                                    if (!guardarId.isEmpty()){
                                        System.out.println("-----------------------MIS COMPRAS--------------------------");

                                    for (Producto productoCarrito: carrito.getProductos()){
                                        System.out.println(productoCarrito.toString());
                                        System.out.println("--------------------------------------------------");
                                        if (validarCompra==true){
                                            System.out.println("Su compra sea validado llegara pronto :)");
                                        }else {
                                            System.out.println("Compra en proceso");
                                        }
                                    }
                                    }else {
                                        System.out.println("No ha realizado compras");
                                    }
                                    break;
                                case 3:
                                    bandera2=false;
                                    break;
                            }
                        }while (bandera2);
                    }
                    break;
                case 3:
                    Usuario admin=new Usuario("admin","","123456");
                    inventario.addUsuario(admin);
                    System.out.println("Ingrese su usuario");
                    String usuario2= teclado.next();
                    System.out.println("Ingrese su contraseña");
                    String contraseña2=teclado.next();
                    if (usuario2.equals(admin.getNombre())&&contraseña2.equals(admin.getContrasenia())) {
                        boolean flag2 = true;
                        do {
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("Bienvenido jefe");
                            System.out.println("QUE HAREMOS HOY?");
                            System.out.println("1.Agregar productos");
                            System.out.println("2.Validar compra");
                            System.out.println("3.Ver productos");
                            System.out.println("4.Salir");
                            System.out.println("-----------------------------------------------------------------");
                            int opcion3 = teclado.nextInt();
                            switch (opcion3){
                                case 1:
                                    System.out.println("Nombre producto: ");
                                    String nombreP= teclado.next();
                                    System.out.println("Modelo producto: ");
                                    String modeloP=teclado.next();
                                    System.out.println("Cantidad de producto");
                                    Integer cantidad=teclado.nextInt();
                                    System.out.println("Precio: ");
                                    Integer precio= teclado.nextInt();
                                    System.out.println("Producto registrado con exito");
                                    Producto producto=new Producto(nombreP,modeloP,cantidad,precio);

                                    inventario.addProducto(producto);
                                    break;
                                case 2:
                                    System.out.println("Ingrese ID de compra a buscar");
                                    Integer encontrarId= teclado.nextInt();
                                    for (Integer ids:guardarId){
                                    if (ids.equals(encontrarId)){
                                        System.out.println("Precione 1 para validar compra");
                                        Integer desicion= teclado.nextInt();
                                        if (desicion==1){
                                            validarCompra=true;
                                        }
                                    }else {
                                        System.out.println("No existe ID");
                                    }
                                    }
                                    break;
                                case 3:
                                    if (!inventario.getProductos().isEmpty()) {
                                        System.out.println("------------------------PRODUCTOS-------------------------------");
                                        for (Producto pds : inventario.getProductos()) {
                                            System.out.println(pds.toString());

                                        }
                                    }else {
                                        System.out.println("No hay productos");
                                    }
                                    break;
                                case 4:
                                    flag2=false;
                                    break;
                            }
                        } while (flag2);
                    }
                    break;
                case 4:
                    bandera=false;
                    break;
            }

     }while (bandera);

    }
}