package com.proyect.controller;

import com.proyect.entity.DataCatalogo;
import com.proyect.entity.Producto;
import com.proyect.entity.Proveedor;
import com.proyect.service.CatalogoService;
import com.proyect.service.DataCatalogoService;
import com.proyect.service.ProductoService;
import com.proyect.service.ProveedorService;
import com.proyect.util.TipoContacto;
import com.proyect.util.TipoDocumento;
import com.proyect.util.TipoMoneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Controller
public class UtilController {

	@Autowired
	private DataCatalogoService dataCatalogoService;
	@Autowired
	private ProductoService productoService;
	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private CatalogoService catalogoService;

	@GetMapping("/")
	public String verProducto(Model model) {
		//crear atributos
		model.addAttribute("catalogos", catalogoService.findAll());
		return "productos";
	}

	@GetMapping("/listarProductoActivoTrue")
	@ResponseBody
	public List<Producto> listarProducto() {
		return productoService.listarRegistrosActivoTrue();
	}

	@GetMapping("/listarProveedorActivoTrue")
	@ResponseBody
	public List<Proveedor> listarProveedor() {
		return proveedorService.listarRegistrosActivoTrue();
	}



	@GetMapping("/listaTipoContacto")
	@ResponseBody
	public HashMap<String, String> listaTipoContacto() {
		TipoContacto[] tipoContactos = TipoContacto.values();
		HashMap<String, String> map = new HashMap<String, String>();
		for (TipoContacto item : tipoContactos) {
			map.put(item.toString().substring(0, item.toString().length()), item.toString());
		}
		System.out.println("listar tipo documento " + map);
		return map;
	}

	@GetMapping("/listaTipoDocumento")
	@ResponseBody
	public HashMap<String, String> listaTipoDocumento() {
		TipoDocumento[] tipoDocumentos = TipoDocumento.values();
		HashMap<String, String> map = new HashMap<String, String>();
		for (TipoDocumento item : tipoDocumentos) {
			map.put(item.toString().substring(0, item.toString().length()), item.toString());
		}
		System.out.println("listar tipo documento " + map);
		return map;
	}

	@GetMapping("/listaTipoMoneda")
	@ResponseBody
	public HashMap<String, String> listaTipoMoneda() {
		TipoMoneda[] monedas = TipoMoneda.values();
		HashMap<String, String> map = new HashMap<String, String>();
		for (TipoMoneda item : monedas) {
			map.put(item.toString().substring(0, 3), item.toString().substring(4, item.toString().length()));
		}
		System.out.println("listar tipo moneda " + map);
		return map;
	}

	@GetMapping("/listarPorDataCatalogo/{catalogoId}")
	@ResponseBody
	public List<DataCatalogo> dataCatalogoList(@PathVariable Long catalogoId) {
		return dataCatalogoService.listarPorCatalogo(catalogoId);
	}



}
