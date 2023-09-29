package edu.pe.cibertec.DAWI_CL1_1.controller;

import edu.pe.cibertec.DAWI_CL1_1.model.prestamoModel_MOSCOLGONZALESJULIOALEXANDER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formPrestamoController_MOSCOLGONZALESJULIOALEXANDER {

    @GetMapping("/CalcularCuotas")
    public String index(Model model){
        model.addAttribute("prestamoModel", new prestamoModel_MOSCOLGONZALESJULIOALEXANDER());
        model.addAttribute("verResultado", false);
        return "formPrestamo";
    }

    @PostMapping("/CalcularCuotas")
    public String calcularCuotas(@ModelAttribute("prestamoModel") prestamoModel_MOSCOLGONZALESJULIOALEXANDER prestamoModel, Model model){
        Double montoPrestamo = prestamoModel.getMontoPrestamo();
        Integer cuotas = 0;
        double interes = 0;
        double valorTotal = 0;

        if(montoPrestamo < 1000){
            cuotas = 1;
        } else if (montoPrestamo >= 2000 && montoPrestamo <= 3000) {
            cuotas = 2;
        } else if (montoPrestamo >5000) {
            cuotas = 3;
        } else{
            cuotas = 5;
        }

        if(montoPrestamo < 4000){
            interes = 0.12;
        } else {
            interes = 0.10;
        }

        double porcentajeInteres = (double) (interes * 100);
        valorTotal = (montoPrestamo * (1 + interes));
        double montocuota = valorTotal / cuotas;

        model.addAttribute("resultado1", "El Prestamo es: " + montoPrestamo + " y su porcentaje de interes es: " + porcentajeInteres + "%");
        model.addAttribute("resultado2", "El Prestamo con interes es: " + String.format("%.2f", valorTotal));
        model.addAttribute("resultado3", "El prestamo se pagará en " + cuotas + " Cuota(s)");
        model.addAttribute("resultado4","El monto de cada cuota es: " + String.format("%.2f", montocuota));
        model.addAttribute("verResultado", true);
        model.addAttribute("prestamoModel", new prestamoModel_MOSCOLGONZALESJULIOALEXANDER());
        return "formPrestamo";
    }
}
