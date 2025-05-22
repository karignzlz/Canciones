package com.karimegonzalez.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karimegonzalez.modelos.Artista;
import com.karimegonzalez.modelos.Cancion;
import com.karimegonzalez.servicios.ServicioArtistas;
import com.karimegonzalez.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/canciones")
public class ControladorCanciones {
	@Autowired
	private final ServicioCanciones servicioCanciones;
	private final ServicioArtistas servicioArtistas;
	
	public ControladorCanciones(ServicioCanciones servicioCanciones,
								ServicioArtistas servicioArtistas) {
		this.servicioCanciones = servicioCanciones;
		this.servicioArtistas = servicioArtistas;
	}
	
	@GetMapping("")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> listaCanciones = this.servicioCanciones.obtenerTodasLasCanciones();
		modelo.addAttribute("listaCanciones", listaCanciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/detalle/{idCancion}")
	public String detallePelicula(@PathVariable("idCancion") Long idCancion,
								  Model modelo) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		
		if(cancionActual == null) {
			return "redirect:/canciones";
		}
		modelo.addAttribute("cancion", cancionActual);
		return "detalleCancion.jsp";
	}
	
	//model para la ruta variable
	@GetMapping("/formulario/agregar/{idCancion}")
	public String agregarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		List<Artista> artistas = this.servicioArtistas.obtenerTodosLosArtistas();
		model.addAttribute("artistas", artistas);
		model.addAttribute("cancion", new Cancion());
		return "agregarCancion.jsp";
	}
	
	@GetMapping("/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
		
		if(cancionActual == null) {
			return "redirect:/canciones";
		}
		model.addAttribute("cancion", cancionActual);
		model.addAttribute("artistas", artistas);
		return "editarCancion.jsp";
	}
	
	@PostMapping("/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion nuevaCancion,
										 BindingResult validaciones,
										 @RequestParam("idArtista") Long idArtista) {
		if(validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		Artista artista = this.servicioArtistas.obtenerArtistaPorId(idArtista);
		nuevaCancion.setArtista(artista);
		this.servicioCanciones.agregarCancion(nuevaCancion);
		return "redirect:/canciones";
	}
	
	@PutMapping("/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@ModelAttribute("cancion") Cancion cancion,
										BindingResult validaciones,
										@PathVariable("idCancion") Long idCancion,
										Model model) {
		if(validaciones.hasErrors()) {
			model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
			return "editarCancion.jsp";
		}
		//se obtiene por id
		Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);
		cancion.setId(cancionActual.getId());
		
		Artista artistaActual = this.servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
		cancion.setArtista(artistaActual);
		
		this.servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
	}
	
	@DeleteMapping("/eliminar/{idCancion}")
		public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
		this.servicioCanciones.eliminaCancion(idCancion);
		return "redirect:/canciones";
	}
	
}
