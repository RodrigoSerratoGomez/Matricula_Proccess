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

import usmp.software.model.Matricula;
import usmp.software.service.IEstudianteService;
import usmp.software.service.IGradoService;
import usmp.software.service.IMatriculaService;
import usmp.software.service.ISeccionService;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService serviceMatricula;

	@Autowired
	private IEstudianteService serviceEstudiante;

	@Autowired
	private IGradoService serviceGrado;

	@Autowired
	private ISeccionService serviceSeccion;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Matricula> lista = serviceMatricula.buscarTodas();
		model.addAttribute("matriculas", lista);
		return "matriculas/listMatricula";
	}

	@GetMapping("/create")
	public String crear(Matricula matricula) {
		return "matriculas/formMatricula";
	}

	@PostMapping("/save")
	public String guardar(Matricula matricula, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "matriculas/formMatricula";
		}
		serviceMatricula.guardar(matricula);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/matriculas/index";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idMatricula, RedirectAttributes attributes) {
		serviceMatricula.eliminar(idMatricula);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return "redirect:/matriculas/index";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idMatricula, Model model) {
		Matricula matricula = serviceMatricula.buscarPorId(idMatricula);
		model.addAttribute("matricula", matricula);
		return "matriculas/formMatricula";
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("estudiantes", serviceEstudiante.buscarTodas());
		model.addAttribute("grados", serviceGrado.buscarTodas());
		model.addAttribute("secciones", serviceSeccion.buscarTodas());
	}

}
