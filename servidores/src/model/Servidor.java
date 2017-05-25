package model;

import java.util.Date;
/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Servidor.
 *
 */
public class Servidor {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Servidor en la base de datos    
     */
    private int id;
    private Date fechaPublicacion;
    private String nombre;
    private String descripcion;
    private String detalle;

    public Servidor(int id) {
        // La fecha de publicacion es la fecha del servidor
        this.fechaPublicacion = new Date();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Servidor{" + "id=" + id + ", fechaPublicacion=" + fechaPublicacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", detalle=" + detalle + '}';
    }

}
