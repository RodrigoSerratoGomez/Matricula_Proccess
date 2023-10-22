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

import usmp.software.model.Parentesco;
import usmp.software.model.ParentescoPK;
import usmp.software.service.IEstudianteService;
import usmp.software.service.IPadresService;
import usmp.software.service.IParentescoService;

@Controller
@RequestMapping(value="/parentescos")
public class ParentescoController {
    
    @Autowired
	private IParentescoService serviceParentesco;
	
	@Autowired
	private IEstudianteService serviceEstudiante;
	
	@Autowired
	private IPadresService servicePadres;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Parentesco> lista = serviceParentesco.buscarTodas();
		model.addAttribute("parentescos", lista);
		return"parentescos/listParentescos";
	}
	
	@GetMapping("/create")
	public String crear(Parentesco parentesco){
	    return"parentescos/formParentesco";
	}
		
	@PostMapping("/save")
	public String guardar(Parentesco parentesco, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()){
				   System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return"parentescos/formParentesco";
		}
		ParentescoPK parentescoPK = new ParentescoPK();
		parentescoPK.setDNIEST(parentesco.getEstudiante().getDNIEST());
		parentescoPK.setDNIPAD(parentesco.getPadres().getDNIPAD());
		parentesco.setID(parentescoPK);
		serviceParentesco.guardar(parentesco);
		attributes.addFlashAttribute("msg","Registro Guardado");
		return"redirect:/parentescos/index";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") ParentescoPK parentescoPK, RedirectAttributes attributes) {
		Parentesco parentesco = new Parentesco();
		parentescoPK = parentesco.getID();
		serviceParentesco.eliminar(parentescoPK);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return"redirect:/parentescos/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") ParentescoPK idParentesco, Model model){
		Parentesco parentesco = serviceParentesco.buscarPorId(idParentesco);
	    model.addAttribute("parentesco", parentesco);
	    return"parentescos/formParentesco";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("estudiantes", serviceEstudiante.buscarTodas());
		model.addAttribute("padres", servicePadres.buscarTodas());
	}

}
