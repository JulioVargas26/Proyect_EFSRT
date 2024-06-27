package com.proyect.controller;

import com.proyect.entity.Producto;
import com.proyect.entity.Tipo;
import com.proyect.service.ProductoService;
import com.proyect.service.TipoService;
import com.proyect.util.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Controller
public class UtilController {

	@Autowired
	private TipoService tipoService;

	@Autowired
	private ProductoService productoService;

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

	@GetMapping("/listaTipo")
	@ResponseBody
	public HashMap<String, String> listaTipo() {
		return tipoService.listaTodos().stream().collect(HashMap::new, (m, v) -> m.put(v.getId_tipo().toString(), v.getDescripcion()), HashMap::putAll);
	}
}
