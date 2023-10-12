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

import usmp.software.model.Pais;
import usmp.software.service.IPaisService;

@Controller
@RequestMapping(value = "/pais")
public class PaisController {

    @Autowired
    private IPaisService servicePais;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Pais> lista = servicePais.buscarTodas();
        model.addAttribute("paises", lista);
        return "pais/listPais";
    }

    @GetMapping("/create")
    public String crear(Pais pais) {
        return "pais/formPais";
    }

    @PostMapping("/save")
    public String guardar(Pais pais, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "pais/formPais";
        }
        servicePais.guardar(pais);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/pais/index";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCat(@PathVariable("id") Long idCategoria, RedirectAttributes attributes) {
        servicePais.eliminar(idCategoria);
        attributes.addFlashAttribute("msg", "Registro Eliminado");
        return "redirect:/pais/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idPais, Model model) {
        Pais pais = servicePais.buscarPorId(idPais);
        model.addAttribute("pais", pais);
        return "pais/formPais";
    }

}
