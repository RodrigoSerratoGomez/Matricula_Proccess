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

import usmp.software.model.Seccion;
import usmp.software.service.ISeccionService;

@Controller
@RequestMapping(value = "/seccion")
public class SeccionController {
    
    @Autowired
    private ISeccionService serviceSeccion;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Seccion> lista = serviceSeccion.buscarTodas();
        model.addAttribute("secciones", lista);
        return "seccion/listSeccion";
    }

    @GetMapping("/create")
    public String crear(Seccion seccion) {
        return "seccion/formSeccion";
    }

    @PostMapping("/save")
    public String guardar(Seccion seccion, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "seccion/formSeccion";
        }
        serviceSeccion.guardar(seccion);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/seccion/index";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idSeccion, RedirectAttributes attributes) {
        serviceSeccion.eliminar(idSeccion);
        attributes.addFlashAttribute("msg", "Registro Eliminado");
        return "redirect:/seccion/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idSeccion, Model model) {
        Seccion seccion = serviceSeccion.buscarPorId(idSeccion);
        model.addAttribute("seccion", seccion);
        return "seccion/formSeccion";
    }

}
