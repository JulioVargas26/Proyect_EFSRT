package com.proyect.controller;
/*
import com.cibertec.entity.Prestatario;
import com.cibertec.service.PrestatarioService;
import com.cibertec.util.AppSettings;
import com.cibertec.util.FunctionUtil;
import com.cibertec.util.ValidacionesUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.cibertec.util.FunctionUtil.stringToLikeAll;

@Controller
public class GestionPrestatarioController {
    @Autowired
    PrestatarioService prestatarioService;

    private final static String DEFAULT_PARAM_VALUE = "-1";
    private final static String DEFAULT_MESSAGE_KEY = "MSG_OK";
    private final static String DEFAULT_MESSAGE_ERROR_KEY = "MSG_ERROR";
    private final static String DEFAULT_LIST_KEY = "LIST";

    @GetMapping("/")
    public String verLogin() {	return "intranet";  }

    @GetMapping("/buscarPrestatariosPorDni")
    @ResponseBody
    public List<Prestatario> consultaSalaCrud(@RequestParam String filtro) {
        return prestatarioService.buscarPorDni(FunctionUtil.stringToLikeAll(filtro));
    }

    @GetMapping("/buscarPorFiltrosGestionPrestatario")
    @ResponseBody
    public Map<String, Object> listaComplejo(@RequestParam String nombres, @RequestParam String ape_p,
                                             @RequestParam String ape_m, @RequestParam String dni

    ) {
        try {
            List<Prestatario> prestatarios = prestatarioService.buscarPorFiltrosGestionPrestatario(stringToLikeAll(dni),
                    stringToLikeAll(nombres), stringToLikeAll(ape_p), stringToLikeAll(ape_m));

            return prestatarios.isEmpty()
                    ? Collections.singletonMap(DEFAULT_MESSAGE_KEY, "No se encontraron resultados")
                    : Collections.singletonMap(DEFAULT_LIST_KEY, prestatarios);
        } catch (Exception e) {
            // log.error("Error al procesar la solicitud: " + e.getMessage(), e);
            return Collections.singletonMap(DEFAULT_MESSAGE_KEY, "Ocurrió un error al procesar la solicitud.");
        }
    }
/*
    @PostMapping("/insertPrestatario")
    @ResponseBody
    public Map<?, ?> registrarPrestatario(Prestatario obj) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (ValidacionesUtil.esVacio(obj.getNombres())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo nombre vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getApellido_paterno())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido paterno vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getApellido_materno())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido materno vacío");
            return map;
        }
        if (!ValidacionesUtil.esVacio(obj.getContacto())) {
             map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo Contacto Incorrecto ");
                return map;

        }
        if (ValidacionesUtil.esVacio(obj.getGenero())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un genero");
            return map;
        }
        switch (obj.getGenero().toLowerCase()) {
            case "g_1":
                obj.setGenero("Masculino");
                break;
            case "g_2":
                obj.setGenero("Femenino");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un género válido");
                return map;
        }
        if (ValidacionesUtil.esVacio(obj.getTipoDocumento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de documento");
            return map;
        }
        switch (obj.getTipoDocumento().toLowerCase()) {
            case "td_1":
                obj.setTipoDocumento("DNI");
                break;
            case "td_2":
                obj.setTipoDocumento("CE");
                break;
            case "td_3":
                obj.setTipoDocumento("RUC");
                break;
            case "td_4":
                obj.setTipoDocumento("Pasaporte");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un documento válido");
                return map;
        }

        if (ValidacionesUtil.esVacio(obj.getNroDocumento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo número documento vacío");
            return map;
        }
        if (obj.getTipoDocumento().equalsIgnoreCase("dni")) {
            if (!ValidacionesUtil.validarDni(obj.getNroDocumento())) {
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Número de dni Incorrecto");
                return map;
            }
        }
        if (obj.getTipoDocumento().equalsIgnoreCase("ruc")) {
            if (!ValidacionesUtil.validarRUC(obj.getNroDocumento())) {
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Número de Ruc Incorrecto");
                return map;
            }
        }
        if (ValidacionesUtil.esVacio(obj.getDireccion())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo dirección vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getEmail())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo E-mail vacío");
            return map;
        }
        if (!ValidacionesUtil.validarEmail(obj.getEmail())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Email Incorrecto");
            return map;
        }

        if (ValidacionesUtil.esVacio(obj.getSalarioMensual())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo salario aprox. vacío");
            return map;
        }

        if (!ValidacionesUtil.esDecimal(obj.getSalarioMensual())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Salario aprox. incorrecto");
            return map;
        }

        if (ValidacionesUtil.esVacio(obj.getEstadoCivil())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un Estado Civil");
            return map;
        }
        switch (obj.getEstadoCivil().toLowerCase()) {
            case "so_o":
                obj.setEstadoCivil("Soltero");
                break;
            case "ca_o":
                obj.setEstadoCivil("Casado");
                break;
            case "vi_o":
                obj.setEstadoCivil("Viudo");
                break;
            case "di_o":
                obj.setEstadoCivil("Divorciado");
                break;
            case "se_o":
                obj.setEstadoCivil("Separado");
                break;
            case "co_e":
                obj.setEstadoCivil("Conviviente");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un documento válido");
                return map;
        }
        if (ValidacionesUtil.esVacio(obj.getFechaNacimiento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Selecciona la fecha de nacimiento");
            return map;
        }
        if (!ValidacionesUtil.validarMayoriaDeEdad(obj.getFechaNacimiento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "El Prestatario debe ser mayor de edad +18");
            return map;
        }

        obj.setActivo(AppSettings.ACTIVO);
        obj.setFechaRegistro(new Date());
        obj.setFechaActualizacion(new Date());

        Prestatario objSalida = prestatarioService.insertar(obj);
        if (objSalida == null) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "ERROR AL REGISTRAR");
        } else {
            List<Prestatario> list = new ArrayList<>();
            list.add(prestatarioService.buscarPorId(objSalida.getId()).get());
            System.out.print("ID NUEVO PRESTATARIO : " + obj.getId());
            map.put(DEFAULT_LIST_KEY, list);
            map.put(DEFAULT_MESSAGE_KEY, "Tu registro fue exitoso!");
        }
        return map;
    }

    @PostMapping("/actualizarPrestatario")
    @ResponseBody
    public Map<?, ?> updatePrestatario(Prestatario obj) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (ValidacionesUtil.esVacio(obj.getNombres())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo nombre vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getApellido_paterno())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido paterno vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getApellido_materno())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo apellido materno vacío");
            return map;
        }

        if (!ValidacionesUtil.esVacio(obj.getContacto())) {
            if (!ValidacionesUtil.validarCaracteresContacto(obj.getContacto())) {

                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo Contacto Incorrecto ");
                return map;
            }
        }


        if (ValidacionesUtil.esVacio(obj.getGenero())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un genero");
            return map;
        }
        switch (obj.getGenero().toLowerCase()) {
            case "g_1":
                obj.setGenero("Masculino");
                break;
            case "g_2":
                obj.setGenero("Femenino");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un género válido");
                return map;
        }
        if (ValidacionesUtil.esVacio(obj.getTipoDocumento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un tipo de documento");
            return map;
        }

        switch (obj.getTipoDocumento().toLowerCase()) {
            case "td_1":
                obj.setTipoDocumento("DNI");
                break;
            case "td_2":
                obj.setTipoDocumento("CE");
                break;
            case "td_3":
                obj.setTipoDocumento("RUC");
                break;
            case "td_4":
                obj.setTipoDocumento("Pasaporte");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un documento válido");
                return map;
        }
        if (ValidacionesUtil.esVacio(obj.getNroDocumento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo número documento vacío");
            return map;
        }
        if (obj.getTipoDocumento().equalsIgnoreCase("dni")) {
            if (!ValidacionesUtil.validarDni(obj.getNroDocumento())) {
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Número de dni Incorrecto");
                return map;
            }
        }
        if (obj.getTipoDocumento().equalsIgnoreCase("ruc")) {
            if (!ValidacionesUtil.validarRUC(obj.getNroDocumento())) {
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Número de Ruc Incorrecto");
                return map;
            }
        }
        if (ValidacionesUtil.esVacio(obj.getDireccion())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo dirección vacío");
            return map;
        }
        if (ValidacionesUtil.esVacio(obj.getEmail())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo E-mail vacío");
            return map;
        }
        if (!ValidacionesUtil.validarEmail(obj.getEmail())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Email Incorrecto");
            return map;
        }

        if (ValidacionesUtil.esVacio(obj.getSalarioMensual())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Campo salario aprox. vacío");
            return map;
        }

        if (!ValidacionesUtil.esDecimal(obj.getSalarioMensual())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Salario aprox. incorrecto");
            return map;
        }

        if (ValidacionesUtil.esVacio(obj.getEstadoCivil())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un Estado Civil");
            return map;
        }
        switch (obj.getEstadoCivil().toLowerCase()) {
            case "so_o":
                obj.setEstadoCivil("Soltero");
                break;
            case "ca_o":
                obj.setEstadoCivil("Casado");
                break;
            case "vi_o":
                obj.setEstadoCivil("Viudo");
                break;
            case "di_o":
                obj.setEstadoCivil("Divorciado");
                break;
            case "se_o":
                obj.setEstadoCivil("Separado");
                break;
            case "co_e":
                obj.setEstadoCivil("Conviviente");
                break;
            default:
                map.put(DEFAULT_MESSAGE_ERROR_KEY, "Escoge un documento válido");
                return map;
        }
        if (ValidacionesUtil.esVacio(obj.getFechaNacimiento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "Selecciona la fecha de nacimiento");
            return map;
        }
        if (!ValidacionesUtil.validarMayoriaDeEdad(obj.getFechaNacimiento())) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "El Prestatario debe ser mayor de edad +18");
            return map;
        }
       

        obj.setActivo(AppSettings.ACTIVO);
        obj.setFechaRegistro(new Date());
        obj.setFechaActualizacion(new Date());

        Prestatario objSalida = prestatarioService.insertar(obj);
        if (objSalida == null) {
            map.put(DEFAULT_MESSAGE_ERROR_KEY, "ERROR AL REGISTRAR");
        } else {
            List<Prestatario> list = new ArrayList<>();
            list.add(prestatarioService.buscarPorId(objSalida.getId()).get());
            map.put(DEFAULT_LIST_KEY, list);
            map.put("MSG_OK", "Tu registro fue exitoso!");
        }
        return map;
    }

    @PostMapping("/cambiarEstadoSalaCrud")
    @ResponseBody
    public Map<?, ?> changeEstadoSalaCrud(int idSala, HttpSession session) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //Buscar Sala Por ID Sala objSala =
        serviceSala.buscaSala(idSala).get(); //Update new data
        objSala.setFechaActualizacion(new Date());
        objSala.setEstado(objSala.getEstado() == AppSettings.ACTIVO ? AppSettings.INACTIVO : AppSettings.ACTIVO);
        Sala objSalida =  serviceSala.actualizaSala(objSala);
        if (objSalida == null) {
            map.put("MSG", "ERROR AL REGISTRA");
        } else {
            List<Sala> listSala = new ArrayList<>();
            listSala.add(serviceSala.buscaSala(objSalida.getIdSala()).get());
            map.put("lista", listSala);
        }
        return map;
    }

    @GetMapping("/buscarNumeroSalaCrud")
    @ResponseBody
    public String validarNumeroSalaCrud(String numeroSala) {

        List<Sala> listNroSala =
                serviceSala.buscarNumeroSala(numeroSala);

        if (CollectionUtils.isEmpty(listNroSala)) {
            return "{\"valid\"
	                :true
        } "; } else { return " {\"valid\" : false }";
        }
    }
*
}
*/