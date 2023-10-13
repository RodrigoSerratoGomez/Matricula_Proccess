package usmp.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import usmp.software.model.Padres;
import usmp.software.service.IPadresService;

@Controller
@RequestMapping(value="/padres")
public class PadresController {

    @Autowired
	private IPadresService servicePadres;
		
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Padres> lista = servicePadres.buscarTodas();
	    model.addAttribute("padress", lista);
	    return"padres/listPadres";
	}
	
	@GetMapping("/create")
	public String crear(Padres padres){
	    return"padres/formPadres";
	}
	
	@PostMapping("/save")
	public String guardar(Padres padres, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()){
				   System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return"padres/formPadres";
		}
		servicePadres.guardar(padres);
		attributes.addFlashAttribute("msg","Registro Guardado");
		return"redirect:/padres/index";
	}
	   
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idPadres, Model model){
		Padres padres = servicePadres.buscarPorId(idPadres);
	    model.addAttribute("padres", padres);
	    return"padres/formPadres";
	}
}
