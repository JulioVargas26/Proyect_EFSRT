package com.proyect.controller;

import com.proyect.entity.Producto;
import com.proyect.service.DataCatalogoService;
import com.proyect.service.ProductoService;
import com.proyect.util.AppSettings;
import com.proyect.util.FunctionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
/*
import static com.proyect.util.FunctionUtil.longToLikeAll;
import static com.proyect.util.FunctionUtil.stringToLikeAll;*/
import static com.proyect.util.MessagesUtil.*;

@Controller
public class ProductoController {

	@Autowired
	DataCatalogoService dataCatalogoService;
	@Autowired
	ProductoService productoService;

	private final static String DEFAULT_PARAM_VALUE = "-1";
	private final static String DEFAULT_MESSAGE_KEY = "MSG_OK";
	private final static String DEFAULT_MESSAGE_EMPTY_KEY = "MSG_EMPTY";
	private final static String DEFAULT_MESSAGE_ERROR_KEY = "MSG_ERROR";
	private final static String DEFAULT_LIST_KEY = "LIST";



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



	/*@GetMapping("/buscarProductoPorNombre")
	@ResponseBody
	public List<Producto> consultaProducto(@RequestParam String filtro) {
		return productoService.buscarPorNombre(FunctionUtil.stringToLikeAll(filtro));
	}*/

	/*@GetMapping("/consultaSalaPorParametros")
	@ResponseBody
	public List<Sala> listaConsultaSala(
			@RequestParam(name = "numero" , required = false, defaultValue = "") String numero,
			@RequestParam(name = "piso" , required = false, defaultValue = "0") int piso,
			@RequestParam(name = "recursos" , required = false, defaultValue = "") String recursos,
			@RequestParam(name = "estado" , required = true, defaultValue = "1") int estado,
			@RequestParam(name = "idTipoSala" , required = false, defaultValue = "-1") int idTipoSala,
			@RequestParam(name = "idSede" , required = false, defaultValue = "-1") int idSede){

		List<Sala> lstSalida = service.listaConsultaDinamica("%"+ numero + "%", piso, "%"+ recursos + "%",estado, idTipoSala, idSede);

		return lstSalida;
	}*/

	@GetMapping("/buscarPorGestionProducto")
	@ResponseBody
	public Map<String, Object> listaComplejo(
			@RequestParam(name = "cod_prod" , required = false, defaultValue = "") String cod_prod,
			@RequestParam(name = "des_prod" , required = false, defaultValue = "") String des_prod) {
		try {
			List<Producto> productos = productoService.buscarPorFiltrosGestionProducto("%" +
					cod_prod + "%", "%" + des_prod + "%");

			return productos.isEmpty()
					? Collections.singletonMap(DEFAULT_MESSAGE_EMPTY_KEY, MESSAGE_LIST_EMPTY)
					: Collections.singletonMap(DEFAULT_LIST_KEY, productos);
		} catch (Exception e) {
			// log.error("Error al procesar la solicitud: " + e.getMessage(), e);
			return Collections.singletonMap(DEFAULT_MESSAGE_KEY, MSG_ERROR_DEFAULT);
		}

	}

	@PostMapping("/insertProducto")
	@ResponseBody
	public Map<?, ?> registrarProducto( Producto obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		System.out.println("CODIGO PRODUCTO : " + obj.getCod_prod());
		System.out.println("DESCRIPCION PRODUCTO : " + obj.getDes_prod());
		System.out.println("TIPO MONEDA : " + obj.getTip_mone());
		System.out.println("PRECIO PRODUCTO : " + obj.getPre_prod());
		System.out.println("STOCK PRODUCTO : " + obj.getSto_prod());
		System.out.println("TIPO DOCUMENTO : " + obj.getTip_docu());
		System.out.println("DOCUMENTO PRODUCTO : " + obj.getDoc_prod());
		System.out.println("DATA CATALOGO : " + obj.getDataCatalogo().getIdDataCatalogo());
		System.out.println("REGISTROS : " + obj.getRegistros().getActivo() + " " + obj.getRegistros().getCreation_date() + " " + obj.getRegistros().getModification_date());


		Producto objSalida = productoService.insertar(obj);
		System.out.println("ID NUEVO PRODUCTO : " + objSalida.getId_prod());

		if (objSalida == null) {
			System.out.println("ERROR AL REGISTRAR PRODUCTO");
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Producto> list = new ArrayList<>();
			list.add(productoService.buscarPorId(objSalida.getId_prod()).get());
			System.out.print("ID NUEVO PRESTATARIO : " + obj.getId_prod());
			map.put(DEFAULT_LIST_KEY, list);
			map.put(DEFAULT_MESSAGE_KEY, MSG_REGISTRO_OK);
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

		/*DataCatalogo dataCatalogo= dataCatalogoService.getFindById(obj.getData_catalogo().getIdDataCatalogo());
		if (dataCatalogo == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_TIPO_ERROR);
			return map;
		}
		obj.setData_catalogo(dataCatalogo);*/
		obj.getRegistros().setActivo(AppSettings.ACTIVO);
		obj.getRegistros().setModification_date(new Date());
		Producto objSalida = productoService.actualizar(obj);
		if (objSalida == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Producto> list = new ArrayList<>();
			list.add(productoService.buscarPorId(objSalida.getId_prod()).get());
			map.put(DEFAULT_LIST_KEY, list);
			map.put(DEFAULT_MESSAGE_KEY, MSG_ACTUALIZACION_OK);
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
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Producto> listProducto = new ArrayList<>();
			listProducto.add(productoService.buscarPorId(objSalida.getId_prod()).get());
			map.put(DEFAULT_LIST_KEY, listProducto);
		}
		return map;
	}

}
