package edu.pe.cibertec.DAWI_CL1_1.controller;

import edu.pe.cibertec.DAWI_CL1_1.model.IngresarNumero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class formIngresarNumero {
    @GetMapping("/index")
    public  String index(Model model){
        model.addAttribute("frm",new IngresarNumero());

        return  "frmnumero";
    }
    @PostMapping("/index")
    public String imprimeNumero(Model model, @ModelAttribute("frm") IngresarNumero num){
        String numcubos="";
        String numCuartas="";
        String numconsecu="";

        for (int i=0;i<num.getNumero();i++){
numconsecu=numconsecu+" ;"+(i+1);
numcubos=numcubos+" ;"+(i+1)*(i+1)*(i+1);
numCuartas=numCuartas+" ;"+(i+1)*(0.25);
        }
        model.addAttribute("verResConsecu","Secuecia del Numero"+ numconsecu);
        model.addAttribute("verResCubos","Numeros Cubicos"+numcubos);
        model.addAttribute("verResCuartas","Numeros de cuarta parte"+numCuartas);
        return "frmnumero";
    }
}
