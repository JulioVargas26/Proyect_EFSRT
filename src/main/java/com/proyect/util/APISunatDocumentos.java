package com.proyect.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class APISunatDocumentos {
    @PostMapping("/consultaSunat")
	public ResponseEntity<?> procesarBoton(/*@RequestParam("tipo_documento") Integer tipoDocumento,*/
			@RequestParam("numero_documento") String numeroDocumento, Model model) {
		/*String tipoConsulta = (tipoDocumento == 6 ? "ruc" : "dni");*/
		String apiUri = "https://api.apis.net.pe/v2/sunat/ruc/" ;/*+ (tipoDocumento == 6 ? "sunat/" : "/reniec/");*/
		String apiConsulta = apiUri /*+ tipoConsulta */+ "?numero=" + numeroDocumento;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + "apis-token-7967.jnTYhcOrD2QCmx87khoUgnFWgfBhJ7-J");
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		ResponseEntity<String> response = new RestTemplate().exchange(apiConsulta, HttpMethod.GET, entity,
				String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			String responseData = response.getBody();
			System.out.println("Respuesta de la API: " + responseData);
			return ResponseEntity.ok(responseData);
		} else {
			return ResponseEntity.status(response.getStatusCode()).body("Error al procesar la solicitud");
		}
	}
}
