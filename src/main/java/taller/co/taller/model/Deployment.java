package taller.co.taller.model;

public class Deployment {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String fecha;
    private String autor;
    private String status;
    private String version;
    private String logs;
    private String tiempo;

    
    public Deployment() {
    }
    
    public Deployment(String titulo, String descripcion, String imagen, String fecha, String autor, String status,
            String version, String logs, String tiempo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha = fecha;
        this.autor = autor;
        this.status = status;
        this.version = version;
        this.logs = logs;
        this.tiempo = tiempo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getLogs() {
        return logs;
    }
    public void setLogs(String logs) {
        this.logs = logs;
    }
    public String getTiempo() {
        return tiempo;
    }
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    
    
    
}
