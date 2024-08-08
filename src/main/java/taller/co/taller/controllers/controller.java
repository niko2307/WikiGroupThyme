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
import taller.co.taller.model.EndPoint;
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
        teamMembers.add(new TeamMember("Nicolas Aguilar", "Desarrollador", "Experto en Java y Spring.", "Desarrollador con más de 5 años de experiencia en aplicaciones web y empresariales. Especialista en Java y Spring, apasionado por las metodologías ágiles y la mejora continua.", "../images/pfp/pfpNicolas.jpeg"));

        teamMembers.add(new TeamMember("Juan Torres", "Diseñador", "Especialista en UI/UX.", "Diseñador con amplia experiencia en la creación de interfaces de usuario intuitivas y atractivas. Apasionado por mejorar la experiencia del usuario y la estética visual.", "../images/pfp/pfpJuan.jpeg"));

        teamMembers.add(new TeamMember("Gustavo Parra", "Gerente de Proyecto", "Liderando proyectos de software.", "Gerente de proyecto con experiencia en liderar equipos de desarrollo de software. Enfocado en la entrega puntual y la calidad del producto.", "../images/pfp/pfpGustavo.jpeg"));
        
        teamMembers.add(new TeamMember("Sebastian Nariño", "Gerente de Proyecto", "Liderando proyectos de software.", "Gerente de proyecto con sólida experiencia en dirigir equipos de desarrollo. Comprometido con la entrega de proyectos exitosos y la satisfacción del cliente.", "../images/pfp/pfpSebastian.jpeg"));


        model.addAttribute("teamMembers", teamMembers);

        return "wikigroup"; 
    }

    @GetMapping("/description")
    public String getDescriptionPage(Model model) {

        return "description"; 
    }

    @GetMapping("/requi")
    public String getRequiPage(Model model) {

        return "requi"; 
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

    @GetMapping("/endpoint")
    public String mostrarEndpoints(Model model) {
/*          List<EndPoint> endpoints = Arrays.asList(
            new EndPoint(
                "Obtener Usuarios", 
                "GET", 
                "/api/users", 
                "Obtiene la lista de usuarios.", 
                Arrays.asList(new EndPoint.Parameter("page", "int", false, "Número de la página")),
                null, 
                Arrays.asList(new EndPoint.Header("Authorization", "Bearer token")),
                "{ \"users\": [...] }",
                Arrays.asList(new EndPoint.StatusCode(200, "OK"), new EndPoint.StatusCode(401, "Unauthorized")),
                true,
                "curl -H 'Authorization: Bearer token' https://example.com/api/users",
                "Este endpoint es para uso interno."
            )
            // Agregar más endpoints aquí
        ); */
        //model.addAttribute("endpoints", endpoints);
        return "endpoint";
    }

    
}
