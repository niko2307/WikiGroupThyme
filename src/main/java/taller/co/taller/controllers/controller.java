package taller.co.taller.controllers;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import taller.co.taller.model.Arquitecture;
import taller.co.taller.model.Deployment;
import taller.co.taller.model.Form;
import taller.co.taller.model.Tests;
import taller.co.taller.model.TeamMember;
import taller.co.taller.repositories.formRepository;

@Controller
@RequestMapping("/controllers")
public class controller {

    // controlador para la plantilla de wikigroup
    @GetMapping("/wikigroup")
    public String getTeamPage(Model model) {
        List<TeamMember> teamMembers = new ArrayList<>();
        
        // Añadir miembros del equipo
        teamMembers.add(new TeamMember("Nicolas Aguilar", "Desarrollador", "Experto en Java y Spring.", "../images/pfp/pfpNicolas.jpeg"));
        teamMembers.add(new TeamMember("Juan Torres", "Diseñador", "Especialista en UI/UX.", "../images/pfp/pfpJuan.jpeg"));
        teamMembers.add(new TeamMember("Gustavo Parra", "Gerente de Proyecto", "Liderando proyectos de software.", "../images/pfp/pfpGustavo.jpeg"));
        teamMembers.add(new TeamMember("Sebastian Nariño", "Gerente de Proyecto", "Liderando proyectos de software.", "../images/pfp/pfpSebastian.jpeg"));

        model.addAttribute("teamMembers", teamMembers);

        return "wikigroup"; 
    }

    @GetMapping("/description")
    public String getDescriptionPage(Model model) {

        return "description"; 
    }
    // controlador para la plantilla de arquitectura
    @GetMapping("/arquitecture")
    public String getArchitecturePage(Model model) {
        String contextDiagramUrl = "../images/arquitecture/contextDiagram.jpeg";
        String containerDiagramUrl = "../images/arquitecture/containerDiagram.jpeg";
        String componentDiagramUrl = "../images/arquitecture/componentDiagram.jpeg";
        String entityRelationModelUrl = "../images/arquitecture/entityRelationModel.jpeg";
        String deploymentDiagramUrl = "../images/arquitecture/deploymentDiagram.jpeg";

        Arquitecture arq = new Arquitecture(
        contextDiagramUrl, 
        containerDiagramUrl, 
        componentDiagramUrl, 
        entityRelationModelUrl, 
        deploymentDiagramUrl);

        model.addAttribute("arq", arq);

        return "arquitecture"; 
    }


    @Autowired
    private formRepository formRepository;
    
    // Ruta para mostrar el form de contacto
    @GetMapping("/form")
    public String showform(Model model) {
        model.addAttribute("form", new Form());
        return "form";
    }

    // Ruta para manejar el envío del form de contacto
    @PostMapping("/form")
    public String submitform(@ModelAttribute Form form, Model model) {
        formRepository.save(form);
        model.addAttribute("message", "form enviado correctamente");
        System.out.println("se envio en form");
        return "form";
    }


    // controlador para la plantilla de pruebas
    @GetMapping("/pruebas")
    public String mostrarPruebas(Model model) {
        // Datos de ejemplo para pruebas de frontend
        List<Tests> pruebasFrontend = Arrays.asList(
            new Tests("Prueba de Página de Inicio", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque facilis aspernatur, id impedit repellat consequatur porro, ipsam eveniet iste eius quae a minus corrupti itaque nostrum fugiat obcaecati dicta aliquid!", "../images/pruebas/frontuno.png"),
            new Tests("Prueba de form de Contacto", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque facilis aspernatur, id impedit repellat consequatur porro, ipsam eveniet iste eius quae a minus corrupti itaque nostrum fugiat obcaecati dicta aliquid!", "../images/pruebas/frontdos.png")
        );

        // Datos de ejemplo para pruebas de backend
        List<Tests> pruebasBackend = Arrays.asList(
            new Tests("Prueba de API de Usuarios", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque facilis aspernatur, id impedit repellat consequatur porro, ipsam eveniet iste eius quae a minus corrupti itaque nostrum fugiat obcaecati dicta aliquid!", "../images/pruebas/backuno.png"),
            new Tests("Prueba de Autenticación", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque facilis aspernatur, id impedit repellat consequatur porro, ipsam eveniet iste eius quae a minus corrupti itaque nostrum fugiat obcaecati dicta aliquid!", "../images/pruebas/backdos.png")
        );

        model.addAttribute("pruebasFrontend", pruebasFrontend);
        model.addAttribute("pruebasBackend", pruebasBackend);

        return "pruebas";
    }

    // parte para la seccion de deployment
    @GetMapping("/deployment")
    public String mostrarDeployment(Model model) {
        List<Deployment> deployments = Arrays.asList(
            new Deployment("Despliegue Inicial", "Descripción del despliegue inicial", "../images/deployment/deployone.png", "2024-08-01", "Gustabo", "Exitoso", "v1.0", "Logs del despliegue inicial", "30 mins"),
            new Deployment("Actualización 1.1", "Descripción de la actualización 1.1", "../images/deployment/deploytow.png", "2024-08-15", "Juan", "Fallido", "v1.1", "Logs de la actualización 1.1", "45 mins")
            // Agregar más elementos de despliegue según sea necesario
        );

        model.addAttribute("deployments", deployments);
        return "deployment";
    }

    
}
