/**
 * Clase Validar que gestiona los métodos de validación solicitados
 * para la creación de un vehículo en la clase Principal
 * @author Raquel Sánchez Guirado
 */
package com.ut5.ejerc.utils;

import java.time.LocalDate;

public class Validar {
    /**
     * Método para validar la fecha de matriculación del vehículo
     * @param fechaMatricula
     * @return true si la fecha de matriculación es anterior a la fecha actual
     */
    public boolean fechaMatriculacionValida(LocalDate fechaMatricula) {
        LocalDate fechaActual = LocalDate.now();
        return fechaMatricula.isBefore(fechaActual);
    }

    /**
     * Método para validar los km del vehículo
     * @param km
     * @return true si se introduce un número superior a 0
     */
    public boolean validarKM(int km) {
        return km > 0;
    }

    /**
     * Método para validar el DNI introducido mediannte un patrón
     * que arroja una excepción personalizada
     * @param dni
     * @throws InvalidDNI
     */
    public void validarDNI(String dni) throws InvalidDNI {
        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new InvalidDNI("Debe introducir un DNI válido");
        }
    }

    /**
     * Se crea una excepción personalizada para arrojar el mensaje de error
     * al introducir un DNI no válido, que hereda de la clase Exception
     */
    public static class InvalidDNI extends Exception {
        public InvalidDNI(String mensaje) {
            super(mensaje);
        }
    }
}


