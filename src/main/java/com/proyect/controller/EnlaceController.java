package com.proyect.controller;

import com.proyect.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnlaceController {

	/*@Autowired
	private CatalogoService catalogoService;

	@GetMapping("/")
	public String verProducto(Model model) {
		//crear atributos
		model.addAttribute("catalogos", catalogoService.findAll());
		return "productos";
	}*/

	@GetMapping("/proveedor")
	public String verProveedor() {
		return "proveedores";
	}

	/*@GetMapping("/")
	public String verInicio() {
		return "intranetLogin";
	}

	@GetMapping("/home")
	public String verIntegraHome() {
		return "integraHome";
	}

	@GetMapping("/integraRegistrarLogin")
	public String verIntegraLoginRegistra() {
		return "integraRegistrarLogin";
	}

	// ADMIN
	@GetMapping("/verAsignacionRol")
	public String VerAsignacionRol() {
		return "integraTransaccionAsignacionRol";
	}

	@GetMapping("/verAsignacionOpcion")
	public String verAsignacionOpcion() {
		return "integraTransaccionAsignacionOpcion";
	}

	// JEFE PRESTAMISTA
	@GetMapping("/verGestionPrestamista")
	public String verGestionPrestamista() {
		return "GestionPrestamista";
	}

	// INVERSIONISTA
	@GetMapping("/verGestionJefePrestamista")
	public String verGestionJefePrestamista() {
		return "GestionJefePrestamista";
	}

	// PRESTATARIO
	@GetMapping("/verSolicitudPrestamo")
	public String verSolicitudPrestamo() {
		return "integraSolicitudPrestamo";
	}

	@GetMapping("/verListaPrestamos")
	public String verAprobacionPrestamo() {
		return "AprobacionPrestamo";
	}

	// PRESTAMISTA
	@GetMapping("/verGestionPrestatario")
	public String verGestionPrestatario() {
		return "GestionPrestatario";
	}

	@GetMapping("/verGenerarPrestamo")
	public String verGenerarPrestamo() {
		return "integraGenerarPrestamo";
	}*/

}
