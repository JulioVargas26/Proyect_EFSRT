package com.proyect.controller;

import com.proyect.entity.DataCatalogo;
import com.proyect.entity.Producto;
import com.proyect.service.CatalogoService;
import com.proyect.service.DataCatalogoService;
import com.proyect.service.ProductoService;
import com.proyect.util.TipoDocumento;
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
	private CatalogoService catalogoService;


	@GetMapping("/")
	public String verProducto(Model model) {
		//crear atributos
		model.addAttribute("catalogos", catalogoService.findAll());

		return "productos";
	}

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

	/*@GetMapping("/listarPorCatalogo")
	@ResponseBody
	public List<Catalogo> catalogoList() {
		return catalogoService.findAll();
	}
*/
	@GetMapping("/listarPorDataCatalogo/{catalogoId}")
	@ResponseBody
	public List<DataCatalogo> dataCatalogoList(@PathVariable Long catalogoId) {
		return dataCatalogoService.listarPorCatalogo(catalogoId);
	}

	/*@GetMapping("/listarPorCatalogo")
	@ResponseBody
	public HashMap<?, ?> listarPorCatalogo() {
		System.out.println("listar Catalogo ");

		return catalogoService.findAll().stream().collect(HashMap::new, (m, v) -> m.put(v.getIdCatalogo().toString(), v.getDescripcion()), HashMap::putAll);
	}*/

	/*@GetMapping("/listarPorDataCatalogo/{catalogoId}")
	@ResponseBody
	public HashMap<?, ?> listarPorDataCatalogo(@PathVariable Long catalogoId) {
		System.out.println("listar Data Catalogo "+catalogoId);
		return dataCatalogoService.listarPorCatalogo(catalogoId).stream().collect(HashMap::new, (m, v) -> m.put(v.getIdDataCatalogo().toString(), v.getDescripcion()), HashMap::putAll);
	}*/

}
