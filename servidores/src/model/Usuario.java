package model;

/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Usuario.
 *
 */
public class Usuario {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Usuario en la base de datos    
     */
    private int id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private String perfil;
    private String estado = "activo";

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", username=" + username + ", password=" + password + ", perfil=" + perfil + ", estado=" + estado + '}';
    }

}
