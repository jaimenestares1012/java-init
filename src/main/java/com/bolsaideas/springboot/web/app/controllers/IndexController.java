package com.bolsaideas.springboot.web.app.controllers;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexController.index.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexController.index.titulo}")
	private String textoListar;

	// @RequestMapping(value="/index", method=RequestMethod.GET)
	@GetMapping({ "/index", "/", "", "/home" })
	public String index(ModelMap model) {
		model.addAttribute("titulo", textoIndex);

		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jaime");
		usuario.setApellido("Nestares");
		usuario.setEmail("JaimeNestares1012@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", textoPerfil);

		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Jaime", "Nestares", "jaimenestares1012@gmail.com"),
				new Usuario("Cesar", "Nestares", "cesarnestares1012@gmail.com"),
				new Usuario("Joel", "Nestares", "scesarnestares1012@gmail.com"));

		return usuarios;
	}
}
