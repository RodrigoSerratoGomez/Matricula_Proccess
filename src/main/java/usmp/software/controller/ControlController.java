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

import usmp.software.model.Control;
import usmp.software.service.IControlService;
import usmp.software.service.IEstudianteService;

@Controller
@RequestMapping(value="/controles")
public class ControlController {
    
    @Autowired
	private IControlService serviceControl;
	
	@Autowired
	private IEstudianteService serviceEstudiante;
		
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Control> lista = serviceControl.buscarTodas();
	    model.addAttribute("controles", lista);
	    return"controles/listControl";
	}
	
	@GetMapping("/create")
	public String crear(Control control){
	    return"controles/formControl";
	}
	
	@PostMapping("/save")
	public String guardar(Control control, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()){
				   System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return"controles/formControl";
		}
		serviceControl.guardar(control);
		attributes.addFlashAttribute("msg","Registro Guardado");
		System.out.println("Control: " + control);
		return"redirect:/controles/index";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarIns(@PathVariable("id") Long idControl, RedirectAttributes attributes) {
		serviceControl.eliminar(idControl);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/controles/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idControl, Model model){
		Control control = serviceControl.buscarPorId(idControl);
	    model.addAttribute("control", control);
	    return"controles/formControl";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("estudiantes", serviceEstudiante.buscarTodas());
	}

}
