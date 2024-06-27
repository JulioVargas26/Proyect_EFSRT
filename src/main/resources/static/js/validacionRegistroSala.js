$(function() {

	$("#id_recursos").attr("maxlength", 45);
	$("#id_piso").attr("maxlength", 2);
	$("#id_nroAlumnos").attr("maxlength", 2);

	$("#id_numeroSala").on("input", function() {
		var maxLength = 4;
		var textarea = $("#id_numeroSala");

		var text = textarea.val();

		var alphanumericText = text.replace(/[^a-zA-Z0-9\s]/g, "");

		if (alphanumericText.length >= maxLength) {

			textarea.val(alphanumericText.slice(0, maxLength));
		}
	});


	$("#id_recursos").on("input", function() {
		var maxLength = 45; // Cambia esto al número máximo de caracteres permitidos
		var textarea = $("#id_recursos");

		var text = textarea.val();
		var alphanumericText = text.replace(/[^a-zA-Z0-9\s]/g, "");

		textarea.val(alphanumericText);
		if (alphanumericText.length >= maxLength ) {
		
			textarea.val(alphanumericText.slice(0, maxLength));
		}
		var remainingChars = maxLength - text.length;
		$("#txaCount").text(remainingChars + " caracteres restantes"); // Actualizar el contador
	});


});