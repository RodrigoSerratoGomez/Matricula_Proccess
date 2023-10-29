package usmp.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
	public String mostrarHome() {
		return "home";
	}

	@GetMapping("/reportesMatricula")
	public String mostrarReporteMatricula() {
		return "reportesMatricula/listReporteMatricula";
	}

	@GetMapping("/reportesVacante")
	public String mostrarReporteVacante() {
		return "reportesVacante/listReporteVacante";
	}
}
