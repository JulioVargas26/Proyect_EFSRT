package com.proyect.controller;

import com.proyect.entity.Producto;
import com.proyect.entity.Tipo;
import com.proyect.service.ProductoService;
import com.proyect.service.TipoService;
import com.proyect.util.AppSettings;
import com.proyect.util.FunctionUtil;
import com.proyect.util.TipoDocumento;
import com.proyect.util.ValidacionesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.proyect.util.FunctionUtil.*;

@Controller
public class ProductoController {

	@Autowired
	TipoService tipoService;
	@Autowired
	ProductoService productoService;

	private final static String DEFAULT_PARAM_VALUE = "-1";
	private final static String DEFAULT_MESSAGE_KEY = "MSG_OK";
	private final static String DEFAULT_MESSAGE_ERROR_KEY = "MSG_ERROR";
	private final static String DEFAULT_LIST_KEY = "LIST";

	@GetMapping("/")
	public String verProducto() {	return "productos";  }

/*
	@RequestMapping("/")
	public String index(Model model) {

		List<DTOTipoList> tipoLists = tipoRepository.findAll().stream().map(DTOTipoList::new).toList();
		model.addAttribute("tipos", tipoLists);
		List<DTOProductoList> productoLists = productoRepository.listarRegistrosActivoTrue();
		model.addAttribute("productos", productoLists);

		System.out.println(productoLists);
		return "index";
	}
*/



	@GetMapping("/buscarProductoPorNombre")
	@ResponseBody
	public List<Producto> consultaProducto(@RequestParam String filtro) {
		return productoService.buscarPorNombre(FunctionUtil.stringToLikeAll(filtro));
	}

	@GetMapping("/buscarPorFiltrosGestionProducto")
	@ResponseBody
	public Map<String, Object> listaComplejo(@RequestParam Long cod_prod,
											 @RequestParam String nom_prod,
											 @RequestParam String des_prod) {
		try {
			List<Producto> productos = productoService.buscarPorFiltrosGestionProducto(
					longToLikeAll(cod_prod),
					stringToLikeAll(nom_prod),
					stringToLikeAll(des_prod));

			return productos.isEmpty()
					? Collections.singletonMap(DEFAULT_MESSAGE_KEY, "No se encontraron resultados")
					: Collections.singletonMap(DEFAULT_LIST_KEY, productos);
		} catch (Exception e) {
			// log.error("Error al procesar la solicitud: " + e.getMessage(), e);
			return Collections.singletonMap(DEFAULT_MESSAGE_KEY, "Ocurrió un error al procesar la solicitud.");
		}
	}

	@PostMapping("/insertProducto")
	@ResponseBody
	public Map<?, ?> registrarProducto(Producto obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		/*if (ValidacionesUtil.esVacioInt(obj.getCodigo_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo Codigo no puede ser CERO");
			return map;
		}
		if (ValidacionesUtil.esVacio(obj.getNombre_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido paterno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getStock_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido materno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getPrecio_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo salario aprox. vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(String.valueOf(obj.getTipo_documento()))) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de documento");
			return map;
		}
		TipoDocumento[] tipoDocumentos = TipoDocumento.values();
		boolean coincidenciatipoDocumentos = false;
		for (TipoDocumento item : tipoDocumentos) {
			if (obj.getTipo_documento().equalsIgnoreCase(item.toString().substring(0, 3))) {
				obj.setTipo_documento(item.toString());
				coincidenciatipoDocumentos = true;
			}
		}
		if (!coincidenciatipoDocumentos) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Valor de Tipo Documento no valido");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getDocumento_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo número documento vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getDescripcion_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo descripcion vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getTipo().getDescripcion())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de producto");
			return map;
		}*/

		Tipo objTipo= tipoService.getReferenceById(obj.getTipo().getId_tipo());
		if (objTipo == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Tipo de Producto no encontrado");
			return map;
		}
		obj.setTipo(objTipo);
		Producto objSalida = productoService.insertar(obj);
		if (objSalida == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "ERROR AL REGISTRAR");
		} else {
			List<Producto> list = new ArrayList<>();
			list.add(productoService.buscarPorId(objSalida.getId_producto()).get());
			System.out.print("ID NUEVO PRESTATARIO : " + obj.getId_producto());
			map.put(DEFAULT_LIST_KEY, list);
			map.put(DEFAULT_MESSAGE_KEY, "EL REGISTRO FUE EXITOSO!");
		}
		return map;
	}

	@PutMapping("/actualizarProducto")
	@ResponseBody
	public Map<?, ?> updateProducto(Producto obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*if (ValidacionesUtil.esVacioInt(obj.getCodigo_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo Codigo no puede ser CERO");
			return map;
		}
		if (ValidacionesUtil.esVacio(obj.getNombre_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido paterno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getStock_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido materno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getPrecio_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo salario aprox. vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(String.valueOf(obj.getTipo_documento()))) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de documento");
			return map;
		}
		TipoDocumento[] tipoDocumentos = TipoDocumento.values();
		boolean coincidenciatipoDocumentos = false;
		for (TipoDocumento item : tipoDocumentos) {
			if (obj.getTipo_documento().equalsIgnoreCase(item.toString().substring(0, 3))) {
				obj.setTipo_documento(item.toString());
				coincidenciatipoDocumentos = true;
			}
		}
		if (!coincidenciatipoDocumentos) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Valor de Tipo Documento no valido");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getDocumento_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo número documento vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getDescripcion_producto())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo descripcion vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getTipo().getDescripcion())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de producto");
			return map;
		}*/

		Tipo objTipo= tipoService.getReferenceById(obj.getTipo().getId_tipo());
		if (objTipo == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Tipo de Producto no encontrado");
			return map;
		}

		obj.getRegistros().setActivo(AppSettings.ACTIVO);
		obj.getRegistros().setModification_date(new Date());
		obj.setTipo(objTipo);
		Producto objSalida = productoService.actualizar(obj);
		if (objSalida == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "ERROR AL REGISTRAR");
		} else {
			List<Producto> list = new ArrayList<>();
			list.add(productoService.buscarPorId(objSalida.getId_producto()).get());
			map.put(DEFAULT_LIST_KEY, list);
			map.put("MSG_OK", "LA ACTUALIZACION FUE EXITOSA!");
		}
		return map;
	}

	@PostMapping("/cambiarEstadoProductoCrud")
	@ResponseBody
	public Map<?, ?> changeEstadoProductoCrud(Long id_producto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//Buscar Sala Por ID
		Producto objProducto = productoService.buscarPorId(id_producto).get(); //Update new data
		objProducto.getRegistros().setModification_date(new Date());
		objProducto.getRegistros().setActivo(objProducto.getRegistros().getActivo() == AppSettings.ACTIVO ? AppSettings.INACTIVO : AppSettings.ACTIVO);
		Producto objSalida =  productoService.actualizar(objProducto);
		if (objSalida == null) {
			map.put("MSG", "ERROR AL REGISTRA");
		} else {
			List<Producto> listProducto = new ArrayList<>();
			listProducto.add(productoService.buscarPorId(objSalida.getId_producto()).get());
			map.put("lista", listProducto);
		}
		return map;
	}

/*
	@RequestMapping("/grabar")
	public String grabarModel(@ModelAttribute @Valid DTOProductoSave dtoProductoSave, RedirectAttributes redirect) {
		System.out.println("Registrar grabarModel "+dtoProductoSave.toString());
		try {
			Tipo tipo = tipoRepository.getReferenceById(dtoProductoSave.tipo());
			System.out.println("seleccionar tipo "+tipo);
			Producto producto = productoRepository.save(new Producto(dtoProductoSave,tipo));
			System.out.println("insertar producto "+producto);

			if (producto==null) {
				redirect.addFlashAttribute("MENSAJE", "Error en el Registro");
			} else {
				redirect.addFlashAttribute("MENSAJE", "Se actualizo el Producto con ID=>" + producto.getId_producto());
				System.out.println(dtoProductoSave);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/";

	}

	@RequestMapping("/actualizar")
	public String actualizarModel(@ModelAttribute @Valid DTOProductoUpdate dtoProductoUpdate, RedirectAttributes redirect) {
		System.out.println("Registrar actualizarModel " + dtoProductoUpdate.toString());
		try {
			Producto producto = productoRepository.getReferenceById(dtoProductoUpdate.id_producto());
			System.out.println("seleccionar producto " + producto);

			producto.getRegistros().setModification_date(new Date());
			System.out.println("modificara fecha actualizacion " + producto.getRegistros());

			producto.updateData(dtoProductoUpdate);
			System.out.println("actualizar producto " + producto);

			if (producto == null) {
				redirect.addFlashAttribute("MENSAJE", "Error en Actualizar");
			} else {
				redirect.addFlashAttribute("MENSAJE", "Se actualizo el Producto con ID=>" + producto.getId_producto());
				System.out.println(dtoProductoUpdate);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/";

	}

	@RequestMapping("/buscar")
	@ResponseBody
	public Producto buscar(@RequestParam("id_producto") Long cod) {
		System.out.println("buscar id_producto de Producto "+cod.toString());
		return productoRepository.findById(cod).orElse(null);
	}
	
	@RequestMapping("/eliminar/{cod}")
	public String eliminar(@PathVariable Long cod,RedirectAttributes redirect) {
		System.out.println("Eliminar Producto");
		try {
			Producto producto = productoRepository.getReferenceById(cod);
			System.out.println("seleccionar producto "+producto.getId_producto());

			producto.getRegistros().setModification_date(new Date());
			System.out.println("modificara fecha actualizacion "+producto.getRegistros().getModification_date());

			if(producto.getRegistros().getActivo()==false) {
				productoRepository.deleteById(cod);
				redirect.addFlashAttribute("MENSAJE","El Producto "+ producto.getId_producto() +" ha sido eliminado totalmente");
			}else {
				productoRepository.getReferenceById(cod).desactivarProducto();
				System.out.println("desactivar producto "+producto.getRegistros().getReporteEstado());
				System.out.println("desactivar producto "+producto.toString());
				redirect.addFlashAttribute("MENSAJE","El Producto "+ producto.getId_producto() +" ha sido desactivado logicamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
		}
		return "redirect:/";
	}



	@RequestMapping("/insumo")
	public String grabarInsumo(@ModelAttribute @Valid DTOTipoSave dtoTipoSave, RedirectAttributes redirect) {
		try {
			Tipo tipo = tipoRepository.save(new Tipo(dtoTipoSave));
			System.out.println("insertar producto "+tipo);

			if (tipo==null) {
				redirect.addFlashAttribute("mensaje", "Error en el Registro");
			} else {
				if (tipo.getId_tipo()==0) {
					tipoRepository.save(tipo);
					redirect.addFlashAttribute("MENSAJE", "Se registro el Insumo con ID=>" + tipo.getId_tipo());
				} else {
					tipoRepository.save(tipo);
					redirect.addFlashAttribute("MENSAJE", "Se actualizo el Insumo con ID=>" + tipo.getId_tipo());
				}
				redirect.addFlashAttribute("MENSAJE", "Se actualizo el Insumo con ID=>" + tipo.getId_tipo());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/";

	}

	@RequestMapping("/buscarIns")
	@ResponseBody
	public Tipo buscarIns(@RequestParam("CodigoIns") Long cod) {
		return tipoRepository.findById(cod).orElse(null);
	}

	@RequestMapping("/eliminarIns")
	public String eliminarIns(@RequestParam("CodigoIns") Long cod,RedirectAttributes redirect) {

		try {

			Tipo tipo = tipoRepository.findById(cod).orElse(null);
			tipo.getRegistros().setModification_date(new Date());

			if(tipo.getRegistros().getActivo()==false) {
				tipoRepository.deleteById(cod);
				redirect.addFlashAttribute(
						"MENSAJE",
						"El Insumo " + tipo.getId_tipo() + " ha sido eliminado totalmente");
			}else {
				tipoRepository.getReferenceById(cod).desactivarTipo();
				redirect.addFlashAttribute(
						"MENSAJE",
						"El Insumo "+ tipo.getId_tipo() +" ha sido desactivado logicamente");
			}

		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/";
	}
*/

}
