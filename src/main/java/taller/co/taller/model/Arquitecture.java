package taller.co.taller.model;

public class Arquitecture {
    private String contextDiagramUrl;
    private String containerDiagramUrl;
    private String componentDiagramUrl;
    private String entityRelationModelUrl;
    private String deploymentDiagramUrl;

    
    public Arquitecture(String contextDiagramUrl, String containerDiagramUrl, String componentDiagramUrl,
            String entityRelationModelUrl, String deploymentDiagramUrl) {
        this.contextDiagramUrl = contextDiagramUrl;
        this.containerDiagramUrl = containerDiagramUrl;
        this.componentDiagramUrl = componentDiagramUrl;
        this.entityRelationModelUrl = entityRelationModelUrl;
        this.deploymentDiagramUrl = deploymentDiagramUrl;
    }
    public String getContextDiagramUrl() {
        return contextDiagramUrl;
    }
    public void setContextDiagramUrl(String contextDiagramUrl) {
        this.contextDiagramUrl = contextDiagramUrl;
    }
    public String getContainerDiagramUrl() {
        return containerDiagramUrl;
    }
    public void setContainerDiagramUrl(String containerDiagramUrl) {
        this.containerDiagramUrl = containerDiagramUrl;
    }
    public String getComponentDiagramUrl() {
        return componentDiagramUrl;
    }
    public void setComponentDiagramUrl(String componentDiagramUrl) {
        this.componentDiagramUrl = componentDiagramUrl;
    }
    public String getEntityRelationModelUrl() {
        return entityRelationModelUrl;
    }
    public void setEntityRelationModelUrl(String entityRelationModelUrl) {
        this.entityRelationModelUrl = entityRelationModelUrl;
    }
    public String getDeploymentDiagramUrl() {
        return deploymentDiagramUrl;
    }
    public void setDeploymentDiagramUrl(String deploymentDiagramUrl) {
        this.deploymentDiagramUrl = deploymentDiagramUrl;
    }

    
}
