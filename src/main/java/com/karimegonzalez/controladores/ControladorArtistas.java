package com.karimegonzalez.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.karimegonzalez.modelos.Artista;
import com.karimegonzalez.servicios.ServicioArtistas;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/artistas")
public class ControladorArtistas {
	
	private final ServicioArtistas servicioArtistas;
	
	public ControladorArtistas(ServicioArtistas servicioArtistas) {
		this.servicioArtistas =servicioArtistas;
	}
	
	@GetMapping("")
	public String desplegarArtistas(Model modelo) {
		List<Artista> listaArtistas = this.servicioArtistas.obtenerTodosLosArtistas();
		modelo.addAttribute("listaArtistas", listaArtistas);
		return "artistas.jsp";
	}
	
	@GetMapping("/detalle/{idArtista}")
	public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista,
								  		  Model modelo) {
		Artista artistaActual = this.servicioArtistas.obtenerArtistaPorId(idArtista);
		
		if(artistaActual == null) {
			return "redirect:/artistas";
		}
		modelo.addAttribute("artista", artistaActual);
		return "detalleArtista.jsp";
	}
	
	@GetMapping("/formulario/agregar/{idArtista}")
	public String formularioAgregarArtista(@PathVariable("idArtista") Long idArtista, 
											Model model) {
		model.addAttribute("artista", new Artista());
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/procesa/agregar")
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista nuevoArtista,
										 BindingResult validaciones) {
		if(validaciones.hasErrors()) {
			return "agregarArtista.jsp";
		}
		this.servicioArtistas.agregarArtista(nuevoArtista);
		return "redirect:/artistas";
	}
	
}
