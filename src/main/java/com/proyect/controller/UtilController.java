package com.proyect.controller;

import com.proyect.entity.*;
import com.proyect.service.*;
import com.proyect.util.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@Controller
public class UtilController {

/*
	@Autowired
	private TipoService tipoService;
*/

	@Autowired
	private DataCatalogoService dataCatalogoService;
	@Autowired
	private ProductoService productoService;
    @Autowired
    private CatalogoService catalogoService;

	@GetMapping("/")
	public String verProducto() {	return "productos";  }

	@GetMapping("/listarRegistrosActivoTrue")
	@ResponseBody
	public List<Producto> listarProducto() {
		return productoService.listarRegistrosActivoTrue();
	}

	@GetMapping("/listaTipoDocumento")
	@ResponseBody
	public HashMap<String, String> listaTipoDocumento() {
		TipoDocumento[] nacion = TipoDocumento.values();
		HashMap<String, String> map = new HashMap<String, String>();
		for (TipoDocumento item : nacion) {
			map.put(item.toString().substring(0, 3), item.toString());
		}
		System.out.println("listar tipo documento "+map);
		return map;
	}

	@GetMapping("/listarPorCatalogo")
	@ResponseBody
	public HashMap<?, ?> listarPorCatalogo() {
		System.out.println("listar Data Catalogo ");

		return catalogoService.findAll().stream().collect(HashMap::new, (m, v) -> m.put(v.getIdCatalogo().toString(), v.getDescripcion()), HashMap::putAll);
	}


	@GetMapping("/listarPorDataCatalogo/{catalogoId}")
	@ResponseBody
	public HashMap<?, ?> listarPorDataCatalogo(@PathVariable Long catalogoId) {
		System.out.println("listar Data Catalogo "+catalogoId);
		return dataCatalogoService.listarPorCatalogo(catalogoId).stream().collect(HashMap::new, (m, v) -> m.put(v.getIdDataCatalogo().toString(), v.getDescripcion()), HashMap::putAll);
	}

}
