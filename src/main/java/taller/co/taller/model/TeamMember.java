package taller.co.taller.model;

public class TeamMember {
    private String name;
    private String role;
    private String bio;
    private String description;
    private String imageUrl;

    // Constructores, getters y setters

    public TeamMember(String name, String role, String bio, String description, String imageUrl) {
        this.name = name;
        this.role = role;
        this.bio = bio;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
