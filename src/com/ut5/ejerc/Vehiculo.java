/**
 * Clase Vehículo que gestiona los métodos y atributos del objeto
 * @author Raquel Sánchez Guirado
 */
package com.ut5.ejerc;

import java.time.LocalDate;

public class Vehiculo {
    private String marca;
    private String matricula;
    private int kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private Double precio;
    private String nombrePropietario;
    private String dniPropietario;
    private int anniosMatriculado;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public int getAnnio() {
        return LocalDate.now().getYear() - fechaMatriculacion.getYear();
    }

    public Vehiculo(String marca,
                    String matricula,
                    int kilometros,
                    LocalDate fechaMatriculacion,
                    String descripcion,
                    Double precio,
                    String nombrePropietario,
                    String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaMatriculacion = fechaMatriculacion;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

}
