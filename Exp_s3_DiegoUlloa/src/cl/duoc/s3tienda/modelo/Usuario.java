package cl.duoc.s3tienda.modelo;

import java.util.Objects;

public class Usuario {
    private final String id;
    private String nombre;
    private Rol rol;

    public Usuario(String id, String nombre, Rol rol) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id no puede ser vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre no puede ser vacío");
        if (rol == null) throw new IllegalArgumentException("rol no puede ser null");
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
