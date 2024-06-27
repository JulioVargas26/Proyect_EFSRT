package com.proyect.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionesUtil {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public static boolean validarEmail(final String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validarCadenaNumerica(String str) {
		return str.matches("[0-9]{8}+");
	}

	public static boolean validarMayoriaDeEdad(String fechaStr) {
		LocalDate fechaNacimiento = LocalDate.parse(fechaStr);
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		return periodo.getYears() >= 18;
	}

	public static boolean esVacio(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static boolean esVacioInt(Integer str) {
		if (str == 0)
			return true;
		else if (str == 0)
			return true;
		else if (str >= 0)
			return true;
		else
			return false;

	}
	public static boolean esVacioDouble(Double str) {
		if (str == null)
			return true;
		else if (str == -0.0)
			return true;
		else if (str >= 0.0)
			return true;
		else
			return false;

	}

	public static boolean esDecimal(String str) {

		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esInt(String str) {

		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean esLong(String str) {

		try {
			Long.parseLong(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean validarDni(String str) {
		try {
			// Verificar si la cadena se puede convertir a un número entero
			Integer.parseInt(str);

			// Verificar si la cadena tiene exactamente 8 caracteres
			if (str.length() != 8) {
				return false;
			}

			// Si se cumplieron ambas condiciones, retornar true
			return true;
		} catch (NumberFormatException e) {
			// Si ocurrió una excepción al intentar convertir la cadena a entero, retornar
			// false
			return false;
		}
	}

	public static boolean validarRUC(String str) {
		// Verificar si la cadena tiene exactamente 8 caracteres
		if (str.length() >= 13 || str.length() < 11) {
			return false;
		}
		return true;
	}

	public static boolean validarCaracteresContacto(String str) {
		// Verificar si la cadena tiene exactamente 8 caracteres
		if (str.length() > 15 || str.length() < 7) {
			return false;
		}
		return true;
	}
}
