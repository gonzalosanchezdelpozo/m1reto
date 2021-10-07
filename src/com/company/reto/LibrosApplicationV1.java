package com.company.reto;

import java.util.*;


public class LibrosApplicationV1 {

    public static void main(String[] args) {

        // 1. Crear el objeto scanner
        Scanner scanner = new Scanner(System.in);
        // empleados
        List<Libro> libros = new ArrayList<>();
        // crear datos demo

        libros.add(new Libro("El italiano", 400, "Alfaguara", "ES", "9788420460499", 2021, "Barcelona"), new ArrayList<>());

        // List<String> phones = new ArrayList<>();
        // phones.add("555444333");
        Libro libroDemo = new Libro("Miss Merkel: el caso de la canciller jubilada",  344, "Seix Barral", "Castellano", "9788432239205", 2021, "Barcelona");
        libros.add(libroDemo);

        while(true) {

            System.out.println("Selecciona una opción:");
            System.out.println("1 - Ver todos los libros"); // Hecho
            System.out.println("2 - Ver un libro(por ISBN)"); // Hecho
            System.out.println("3 - Crear un nuevo libro"); // hecho
            System.out.println("4 - Modificar un libro (por ISBN)");
            System.out.println("5 - Borrar un libro (por ISBN)");
            System.out.println("6 - Borrar todos los libros");
            System.out.println("7 - Salir"); // hecho

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Has seleccionado la opción 1 - Ver todos los libros");

                if (libros.isEmpty()){
                    System.out.println("No hay libros.");
                }else{
                    System.out.println(libros);
                    System.out.println("El número de empleados es: " + libros.size());
                }
            } else if (opcion == 2) {
                System.out.println("Has seleccionado la opción 2 - Ver un libro por ISBN ");

                System.out.println("Introduce el ISBN del libro a consultar");
                String isbn = scanner.next();

                /*
                    Bucle que itera sobre la lista de empleados, comprobando si el DNI de cada empleado es igual al DNI
                    leído por consola.
                        1 - En caso de que coincida entonces hemos encontrado el empleado, por tanto lo imprimimos
                           por consola.
                        2 - En caso de que no haya ninguno se muestra un texto que diga No existe el empleado para el DNI solicitado
                 */
                boolean exists = false;
                for(Libro libro : libros){
                    if (libro.isbn.equals(isbn)){
                        exists = true;
                        System.out.println(libro);
                        break;
                    }
                }
                if (!exists){
                    System.out.println("No existe el libro con isbn: " + isbn);
                }

            }else if (opcion == 3) {
                System.out.println("Has seleccionado la opción 3 - Crear un nuevo libro ");

                // 2. leer datos de la consola
                System.out.println("Introduce el ISBN");
                String isbn = scanner.next();

                // comprobar si existe un empleado con ese dni
                // si existe entonces no permitimos crear, volvemos principal
                // si no existe entonces permitimos crear
                boolean isbnOcupado = false;
                for(Libro libro : libros){
                    if (libro.isbn.equals(isbn)){
                        // ya existe un empleado con este dni, no permitimos crear
                        isbnOcupado = true;
                        break;
                    }
                }

                // si dniOcupado es verdadero entonces no continuamos el proceso de creación del empleado
                // si dniOcupado es true entonces pasamos a la siguiente iteración del bucle while
                if(isbnOcupado){
                    System.out.println("El ISBN ya existe, por favor utilice otro ISBN.");
                    continue;
                }


                System.out.println("Introduce el título del libro: ");
                String titulo = scanner.next();

                System.out.println("Introduce el número de páginas: ");
                int num_paginas = scanner.nextInt();

                System.out.println("Introduce el idioma: ");
                String idioma = scanner.next();

                System.out.println("Introduce el ISBN: ");
                String isbn = scanner.next();

                System.out.println("Introduce el año de publicacion: ");
                int anio = scanner.nextInt();

                System.out.println("Introduce la plaza de edicion: ");
                String plaza_edicion = scanner.next();

                System.out.println("¿Tiene teléfono? (true o false)");
                boolean hasPhone = scanner.nextBoolean();
                List<String> telefonos = new ArrayList<>();
                if (hasPhone) {
                    System.out.println("¿Cuántos teléfonos tiene?");
                    int numPhones = scanner.nextInt();
                    for(int i = 0; i < numPhones; i++){
                        System.out.println("Introduce el teléfono " + (i + 1));
                        String telefono = scanner.next();
                        telefonos.add(telefono);
                    }

                }


                // 3. Crear objeto con los datos de la entrada

                Libro libro = new Libro(titulo,num_paginas, idioma, isbn, anio, plaza_edicion);
                System.out.println(libro);
                libros.add(libro);

            } else if (opcion == 4) {
                System.out.println("Has seleccionado la opción 4 - Modificar libro por ISBN");

                // 1. Buscar el empleado
                System.out.println("Introduce el ISBN de libro a modificar");
                String isbn = scanner.next();

                boolean found = false;
                for(Libro libro : libros){
                    if (libro.isbn.equals(isbn)){

                        System.out.println("Introduce el título del libro: ");
                        String titulo = scanner.next();

                        System.out.println("Introduce el número de páginas: ");
                        int num_paginas = scanner.nextInt();

                        System.out.println("Introduce el idioma: ");
                        String idioma = scanner.next();

                        System.out.println("Introduce el año de publicacion: ");
                        int anio = scanner.nextInt();

                        System.out.println("Introduce la plaza de edicion: ");
                        String plaza_edicion = scanner.next();
                        found = true;
                        System.out.println("Libro modificado correctamente!");
                        break;
                    }
                }
                if(!found)
                    System.out.println("No existe un libro con ese ISBN: " + isbn);


            }  else if (opcion == 5) {
                System.out.println("Has seleccionado la opción 5 - Borrar un libro por ISBN");

                // 1. Buscar el empleado
                System.out.println("Introduce el ISBN del libro");
                String isbn = scanner.next();

                // Opcion 1
                boolean exists = false;
//                for(Empleado empleado : empleados){
//                    if (empleado.dni.equals(dni)){
//                        empleados.remove(empleado);
//                        exists = true;
//                        System.out.println("Empleado borrado correctamente!");
//                        break;
//                    }
//                }

                // Opcion 2 Opción más correcta
                Iterator<Libro> iter = libros.iterator();
                while (iter.hasNext()) {
                    Libro libro = iter.next();
                    if (libro.isbn.equals(isbn)){
                        iter.remove();
                        exists = true;
                        System.out.println("Libro borrado correctamente!");
                        break;
                    }
                }

                // Opcion 3
                // empleados.removeIf((empleado) -> empleado.dni.equals(dni));


                if (!exists){
                    System.out.println("No existe ningun libro con ese ISBN: " + isbn);
                }

                // 2. Borrarlo de la lista
                // empleados.remove()
            } else if (opcion == 6) {
                System.out.println("Has seleccionado la opción 6 - Borrar todos los libros");
                libros.clear();

            }   else if (opcion == 7) {
                System.out.println("Has seleccionado la opción 7 - Salir de la aplicación");

                break;
            } else{
                System.out.println("La opción seleccionada no es una opción válida, por favor introduce una opción");
            }
            System.out.println("\n\n");
        }
        System.out.println("Hasta luego lucas!");


        // Paso final: cerrar el scanner
        scanner.close();

    }


}
