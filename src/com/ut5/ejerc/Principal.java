/**
 * Clase Principal que ejecuta el programa mostrando un menú
 * para la interacción del usuario con la gestión de un vehículo
 *
 * @author Raquel Sánchez Guirado
 */
package com.ut5.ejerc;

import com.ut5.ejerc.utils.Validar;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    /**
     * Definición de constantes que preferiblemente se declararían
     * en una clase aparte para mantener un código más limpio.
     */
    public static final String NO_VEHICULO = "No se ha introducido ningún vehículo";
    public static final String SALTO_LINEA = "\n";
    public static final String SEPARADOR = " - ";
    public static final String MENSAJE_KM = "Debe introducir más de 0 kilómetros";
    public static final String MENSAJE_FECHA = "Debe introducir una fecha anterior a la actual";
    public static final String OPCION_1 = "1. Nuevo Vehículo";
    public static final String OPCION_2 = "2. Ver Matrícula";
    public static final String OPCION_3 = "3. Ver Número de Kilómetros";
    public static final String OPCION_4 = "4. Actualizar Kilómetros";
    public static final String OPCION_5 = "5. Ver años de antigüedad";
    public static final String OPCION_6 = "6. Mostrar propietario";
    public static final String OPCION_7 = "7. Mostrar descripción";
    public static final String OPCION_8 = "8. Mostrar Precio";
    public static final String OPCION_9 = "9. Salir";

    /**
     * Método centralizado para mostrar el menú
     */
    private static void mostrarMenu() {
        System.out.println("Seleccione una opción: "
                + SALTO_LINEA +
                OPCION_1 + SALTO_LINEA +
                OPCION_2 + SALTO_LINEA +
                OPCION_3 + SALTO_LINEA +
                OPCION_4 + SALTO_LINEA +
                OPCION_5 + SALTO_LINEA +
                OPCION_6 + SALTO_LINEA +
                OPCION_7 + SALTO_LINEA +
                OPCION_8 + SALTO_LINEA +
                OPCION_9);
    }

    /**
     * Método principal que ejecuta el programa
     *
     * @param args
     */
    public static void main(String[] args) {
        mostrarMenu();
        Validar validador = new Validar();
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        Vehiculo vehiculo1 = null;

        do {
            switch (entrada) {
                case 1:
                    System.out.println(OPCION_1 + SALTO_LINEA);
                    sc.nextLine();
                    System.out.println("Introduzca marca: ");
                    String entradaMarca = sc.nextLine();

                    System.out.println("Introduzca matrícula: ");
                    String entradaMatricula = sc.nextLine();

                    System.out.println("Introduzca nº de kilómetros: ");

                    int entradaKm;
                    boolean kmValidos;

                    do {
                        entradaKm = sc.nextInt();
                        kmValidos = validador.validarKM(entradaKm);
                        if (!kmValidos) {
                            System.out.println(MENSAJE_KM);
                        }
                    } while (!kmValidos);

                    System.out.println("Introduzca fecha matriculación: ");
                    int entradaDia;
                    int entradaMes;
                    int entradaAnnio;
                    boolean fechaValida;
                    LocalDate fecha;

                    do {
                        System.out.println("Día: ");
                        entradaDia = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Mes: ");
                        entradaMes = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Año: ");
                        entradaAnnio = sc.nextInt();

                        fecha = LocalDate.of(entradaAnnio, entradaMes, entradaDia);
                        fechaValida = validador.fechaMatriculacionValida(fecha);
                        if (!fechaValida) {
                            System.out.println(MENSAJE_FECHA);
                        }
                    } while (!fechaValida);
                    sc.nextLine();

                    System.out.println("Introduzca descripción: ");
                    String entradaDescripcion = sc.nextLine();

                    System.out.println("Introduzca precio: ");
                    Double entradaPrecio = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Introduzca nombre del propietario: ");
                    String entradaNombre = sc.nextLine();

                    System.out.println("Introduzca DNI del propietario: ");
                    String entradaDNI = "";
                    boolean dniValido = false;
                    while (!dniValido) {
                        entradaDNI = sc.nextLine();
                        try {
                            validador.validarDNI(entradaDNI);
                            dniValido = true;
                        } catch (Validar.InvalidDNI e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    vehiculo1 = new Vehiculo(entradaMarca, entradaMatricula, entradaKm, fecha, entradaDescripcion, entradaPrecio, entradaNombre, entradaDNI);
                    System.out.println(SALTO_LINEA + "Vehículo creado correctamente" + SALTO_LINEA);

                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 2:
                    System.out.println(OPCION_2 + SALTO_LINEA + "Matrícula: ");
                    if (vehiculo1 != null) {
                        System.out.println(vehiculo1.getMatricula() + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }
                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 3:
                    System.out.println(OPCION_3);
                    if (vehiculo1 != null) {
                        System.out.println(vehiculo1.getKilometros() + " km" + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }
                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 4:
                    System.out.println(OPCION_4 + SALTO_LINEA + "Introduzca Kilómetros: ");
                    if (vehiculo1 != null) {
                        int km;
                        boolean kmValido;
                        do {
                            km = sc.nextInt();
                            kmValido = validador.validarKM(km);
                            if (!kmValido) {
                                System.out.println(MENSAJE_KM);
                            }
                        } while (!kmValido);
                        vehiculo1.setKilometros(km + vehiculo1.getKilometros());
                        System.out.println("Kilómetros actualizados: "
                                + vehiculo1.getKilometros()
                                + " km"
                                + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    } else {
                        System.out.println(NO_VEHICULO + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                    }
                    break;

                case 5:
                    System.out.println(OPCION_5);

                    if (vehiculo1 != null) {
                        System.out.println(vehiculo1.getAnnio() + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }

                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 6:
                    System.out.println(OPCION_6);

                    if (vehiculo1 != null) {
                        String propietarioConDni = vehiculo1.getNombrePropietario()
                                + SEPARADOR
                                + vehiculo1.getDniPropietario();
                        System.out.println(propietarioConDni + SALTO_LINEA);

                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }
                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 7:
                    System.out.println(OPCION_7);

                    if (vehiculo1 != null) {

                        System.out.println("Descripción: "
                                + vehiculo1.getDescripcion()
                                + SEPARADOR
                                + "Matrícula: "
                                + vehiculo1.getMatricula()
                                + SEPARADOR
                                + "Kilómetros: "
                                + vehiculo1.getKilometros()
                                + SALTO_LINEA);

                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }

                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 8:
                    System.out.println(OPCION_8);
                    if (vehiculo1 != null) {
                        System.out.println(vehiculo1.getPrecio() + SALTO_LINEA);
                        mostrarMenu();
                        entrada = sc.nextInt();
                        break;
                    }

                    System.out.println(NO_VEHICULO + SALTO_LINEA);
                    mostrarMenu();
                    entrada = sc.nextInt();
                    break;

                case 9:
                    System.out.println(OPCION_9);
                    break;

                default:
                    mostrarMenu();
                    entrada = sc.nextInt();
            }
        } while (entrada != 9);
    }
}
