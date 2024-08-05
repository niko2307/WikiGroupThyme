package taller.co.taller.controllers;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import taller.co.taller.model.TeamMember;

@Controller
@RequestMapping("/controllers")
public class controller {
    @GetMapping("/wikigroup")
    public String getTeamPage(Model model) {
        List<TeamMember> teamMembers = new ArrayList<>();
        
        // Añadir miembros del equipo
        teamMembers.add(new TeamMember("Juan Pérez", "Desarrollador", "Experto en Java y Spring."));
        teamMembers.add(new TeamMember("María García", "Diseñadora", "Especialista en UI/UX."));
        teamMembers.add(new TeamMember("Carlos López", "Gerente de Proyecto", "Liderando proyectos de software."));
        teamMembers.add(new TeamMember("Carlos López", "Gerente de Proyecto", "Liderando proyectos de software."));

        model.addAttribute("teamMembers", teamMembers);

        return "wikigroup"; 
    }


    
}
