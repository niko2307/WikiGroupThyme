package taller.co.taller.modelo;

public class Estudiante {
    private String name;
    private String lastname;
    private String email;
    private int semester;
    private String description;

    
    public Estudiante(String name, String lastname, String email, int semester, String description) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.semester = semester;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    

}
