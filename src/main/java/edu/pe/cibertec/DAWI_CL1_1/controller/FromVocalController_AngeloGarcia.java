package edu.pe.cibertec.DAWI_CL1_1.controller;

import edu.pe.cibertec.DAWI_CL1_1.model.NumeroModel_AngeloGarcia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FromVocalController_AngeloGarcia {

    @GetMapping("/validarvocal")
    public String index(Model model){
        model.addAttribute("numeromodel", new NumeroModel_AngeloGarcia());
        model.addAttribute("verresultado", false);

        return "formvocal_AngeloGarcia";
    }

    @PostMapping("/validarvocal")
    public String calcularvocal(
            @ModelAttribute("numeromodel")
            NumeroModel_AngeloGarcia numeroModel ,
            Model model
    ){
        int numero= numeroModel.getNumero();
        switch (numero) {
            case 1:
                model.addAttribute( "resultado","La vocal corresponde A");
                break;
            case 2:
                model.addAttribute( "resultado","La vocal corresponde E");
                break;
            case 3:
                model.addAttribute( "resultado","La vocal corresponde I");
                break;
            case 4:
                model.addAttribute( "resultado","La vocal corresponde O");
                break;
            case 5:
                model.addAttribute( "resultado","La vocal corresponde U");
                break;
            default:
                model.addAttribute( "resultado","Numero fuera de Rango");
        }
        model.addAttribute("verresultado", true);
        model.addAttribute("numeromodel", new NumeroModel_AngeloGarcia());

        return "formvocal_AngeloGarcia";
    }
}
