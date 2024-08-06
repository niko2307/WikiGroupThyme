package taller.co.taller.controllers;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import taller.co.taller.model.Formulario;
import taller.co.taller.model.TeamMember;
import taller.co.taller.repositories.FormularioRepository;

@Controller
@RequestMapping("/controllers")
public class controller {
    @GetMapping("/wikigroup")
    public String getTeamPage(Model model) {
        List<TeamMember> teamMembers = new ArrayList<>();
        
        // Añadir miembros del equipo
        teamMembers.add(new TeamMember("Nicolas Aguilar", "Desarrollador", "Experto en Java y Spring.", "../images/pfp/pfpNicolas.jpeg"));
        teamMembers.add(new TeamMember("Juan Torres", "Diseñadora", "Especialista en UI/UX.", "../images/pfp/pfpJuan.jpeg"));
        teamMembers.add(new TeamMember("Gustavo Parra", "Gerente de Proyecto", "Liderando proyectos de software.", "../images/pfp/pfpGustavo.jpeg"));
        teamMembers.add(new TeamMember("Sebastian Nariño", "Gerente de Proyecto", "Liderando proyectos de software.", "../images/pfp/pfpSebastian.jpeg"));

        model.addAttribute("teamMembers", teamMembers);

        return "wikigroup"; 
    }

    @Autowired
    private FormularioRepository formularioRepository;
    
    // Ruta para mostrar el formulario de contacto
    @GetMapping("/formulario")
    public String showFormulario(Model model) {
        model.addAttribute("formulario", new Formulario());
        return "formulario";
    }

    // Ruta para manejar el envío del formulario de contacto
    @PostMapping("/formulario")
    public String submitFormulario(Formulario formulario, Model model) {
        
        formularioRepository.save(formulario);
        model.addAttribute("message", "Formulario enviado por: " + formulario.getName() + " " + formulario.getLastname());
        System.out.println("Formulario recibido: " + formulario.getName() + " " + formulario.getLastname() + " " + formulario.getEmail() + " " + formulario.getPhone() + " " + formulario.getCity());
        return "formulario";
    }


    
}
