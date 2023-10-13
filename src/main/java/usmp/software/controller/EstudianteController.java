package usmp.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import usmp.software.model.Estudiante;
import usmp.software.service.IEstudianteService;
import usmp.software.service.IPaisService;

@Controller
@RequestMapping(value="/estudiantes")
public class EstudianteController {
    
    @Autowired
	private IEstudianteService serviceEstudiante;
	
	@Autowired
	private IPaisService servicePais;
		
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Estudiante> lista = serviceEstudiante.buscarTodas();
	    model.addAttribute("estudiantes", lista);
	    return"estudiantes/listEstudiante";
	}
	
	@GetMapping("/create")
	public String crear(Estudiante estudiante){
	    return"estudiantes/formEstudiante";
	}
	
	@PostMapping("/save")
	public String guardar(Estudiante estudiante, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()){
				   System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return"estudiantes/formEstudiante";
		}
		serviceEstudiante.guardar(estudiante);
		attributes.addFlashAttribute("msg","Registro Guardado");
		return"redirect:/estudiantes/index";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idEstudiante, RedirectAttributes attributes) {
		serviceEstudiante.eliminar(idEstudiante);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/estudiantes/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idEstudiante, Model model){
		Estudiante estudiante = serviceEstudiante.buscarPorId(idEstudiante);
	    model.addAttribute("estudiante", estudiante);
	    return"estudiantes/formEstudiante";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("paises", servicePais.buscarTodas());
	}

}
