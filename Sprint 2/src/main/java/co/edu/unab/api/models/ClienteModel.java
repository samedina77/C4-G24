package co.edu.unab.api.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;


public class ClienteModel {
    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fRegistro;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nombre, String apellido, String telefono, LocalDate fRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fRegistro = fRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getfRegistro() {
        return fRegistro;
    }

    public void setfRegistro(LocalDate fRegistro) {
        this.fRegistro = fRegistro;
    }

    

    
}

