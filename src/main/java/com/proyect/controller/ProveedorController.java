package com.proyect.controller;

import com.proyect.entity.Proveedor;
import com.proyect.service.DataCatalogoService;
import com.proyect.service.ProveedorService;
import com.proyect.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.proyect.util.MessagesUtil.*;

@Controller
public class ProveedorController {

	@Autowired
	DataCatalogoService dataCatalogoService;
	@Autowired
	ProveedorService ProveedorService;

	private final static String DEFAULT_PARAM_VALUE = "-1";
	private final static String DEFAULT_MESSAGE_KEY = "MSG_OK";
	private final static String DEFAULT_MESSAGE_EMPTY_KEY = "MSG_EMPTY";
	private final static String DEFAULT_MESSAGE_ERROR_KEY = "MSG_ERROR";
	private final static String DEFAULT_LIST_KEY = "LIST";

	@GetMapping("/buscarPorGestionProveedor")
	@ResponseBody
	public Map<String, Object> listaComplejo(
			@RequestParam(name = "ruc" , required = false, defaultValue = "") String ruc,
			@RequestParam(name = "razon_social" , required = false, defaultValue = "") String razon_social) {
		try {
			List<Proveedor> Proveedors = ProveedorService.buscarPorFiltrosGestionProveedor("%" +
					ruc + "%", "%" + razon_social + "%");

			return Proveedors.isEmpty()
					? Collections.singletonMap(DEFAULT_MESSAGE_EMPTY_KEY, MESSAGE_LIST_EMPTY)
					: Collections.singletonMap(DEFAULT_LIST_KEY, Proveedors);
		} catch (Exception e) {
			// log.error("Error al procesar la solicitud: " + e.getMessage(), e);
			return Collections.singletonMap(DEFAULT_MESSAGE_KEY, MSG_ERROR_DEFAULT);
		}

	}

	@PostMapping("/insertProveedor")
	@ResponseBody
	public Map<?, ?> registrarProveedor( Proveedor obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		System.out.println("CODIGO Proveedor : " + obj.getId_prov());
		System.out.println("NOMBRE Proveedor : " + obj.getRazon_social());
		System.out.println("DIRECCION Proveedor : " + obj.getDireccion_fiscal());
		System.out.println("TELEFONO Proveedor : " + obj.getTelefono_contacto());
		System.out.println("CONTACTO Proveedor : " + obj.getTipo_contacto());
		System.out.println("NOMBRE Proveedor : " + obj.getNombre_contacto());
		System.out.println("EMAIL Proveedor : " + obj.getEmail_contacto());

		System.out.println("REGISTROS : " + obj.getRegistros().getActivo() + " " + obj.getRegistros().getCreation_date() + " " + obj.getRegistros().getModification_date());

		Proveedor objSalida = ProveedorService.insertar(obj);
		System.out.println("ID NUEVO PROVEEDOR : " + objSalida.getId_prov());

		if (objSalida == null) {
			System.out.println("ERROR AL REGISTRAR PROVEEDOR");
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Proveedor> list = new ArrayList<>();
			list.add(ProveedorService.buscarPorId(objSalida.getId_prov()).get());
			System.out.print("ID NUEVO PROVEEDOR : " + obj.getId_prov());
			map.put(DEFAULT_LIST_KEY, list);
			map.put(DEFAULT_MESSAGE_KEY, MSG_REGISTRO_OK);
		}
		return map;
	}

	@PutMapping("/actualizarProveedor")
	@ResponseBody
	public Map<?, ?> updateProveedor(Proveedor obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*if (ValidacionesUtil.esVacioInt(obj.getCodigo_Proveedor())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo Codigo no puede ser CERO");
			return map;
		}
		if (ValidacionesUtil.esVacio(obj.getNombre_Proveedor())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido paterno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getStock_Proveedor())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido materno vacío");
			return map;
		}
		if (ValidacionesUtil.esVacioDouble(obj.getPrecio_Proveedor())) {
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

		if (ValidacionesUtil.esVacio(obj.getDocumento_Proveedor())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo número documento vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getDescripcion_Proveedor())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo descripcion vacío");
			return map;
		}

		if (ValidacionesUtil.esVacio(obj.getTipo().getDescripcion())) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de Proveedor");
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
		Proveedor objSalida = ProveedorService.actualizar(obj);
		if (objSalida == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Proveedor> list = new ArrayList<>();
			list.add(ProveedorService.buscarPorId(objSalida.getId_prov()).get());
			map.put(DEFAULT_LIST_KEY, list);
			map.put(DEFAULT_MESSAGE_KEY, MSG_ACTUALIZACION_OK);
		}
		return map;
	}

	@PostMapping("/cambiarEstadoProveedorCrud")
	@ResponseBody
	public Map<?, ?> changeEstadoProveedorCrud(Long id_prov) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//Buscar Sala Por ID
		Proveedor objProveedor = ProveedorService.buscarPorId(id_prov).get(); //Update new data
		objProveedor.getRegistros().setModification_date(new Date());
		objProveedor.getRegistros().setActivo(objProveedor.getRegistros().getActivo() == AppSettings.ACTIVO ? AppSettings.INACTIVO : AppSettings.ACTIVO);
		Proveedor objSalida =  ProveedorService.actualizar(objProveedor);
		if (objSalida == null) {
			map.put(DEFAULT_MESSAGE_ERROR_KEY, MSG_ERROR_REGISTRO);
		} else {
			List<Proveedor> listProveedor = new ArrayList<>();
			listProveedor.add(ProveedorService.buscarPorId(objSalida.getId_prov()).get());
			map.put(DEFAULT_LIST_KEY, listProveedor);
		}
		return map;
	}

}
