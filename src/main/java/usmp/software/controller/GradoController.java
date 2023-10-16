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

import usmp.software.model.Grado;
import usmp.software.service.IGradoService;

@Controller
@RequestMapping(value = "/grado")
public class GradoController {
    
    @Autowired
    private IGradoService serviceGrado;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Grado> lista = serviceGrado.buscarTodas();
        model.addAttribute("grados", lista);
        return "grado/listGrado";
    }

    @GetMapping("/create")
    public String crear(Grado grado) {
        return "grado/formGrado";
    }

    @PostMapping("/save")
    public String guardar(Grado grado, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "grado/formGrado";
        }
        serviceGrado.guardar(grado);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/grado/index";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCat(@PathVariable("id") Long idGrado, RedirectAttributes attributes) {
        serviceGrado.eliminar(idGrado);
        attributes.addFlashAttribute("msg", "Registro Eliminado");
        return "redirect:/grado/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idGrado, Model model) {
        Grado grado = serviceGrado.buscarPorId(idGrado);
        model.addAttribute("grado", grado);
        return "grado/formGrado";
    }
}
