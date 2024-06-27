<%--
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="private" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/es	.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<title>Intranet</title>
<style>
.navbar {
	
}

.close {
	padding: 1rem;
}

.input-sm {
	height: 30px; /* Ajusta la altura seg�n tus preferencias */
}

.close:hover {
	background: rgba(255, 255, 255, 0.56);
	border-radius: 1rem;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="intranetCabecera.jsp" />
	</header>


	<div class="container" style="margin-top: 4%">
		<!-- Agregar aqu -->
		<h3>Gesti&oacute;n Prestatarios</h3>
		<div class=" col-md-12 ">

			<div class="row">

				<div class="col-md-6 col-sm-12 col-mb-3">
					<input class="form-control" id="id_txt_nombres" name="filtro"
						placeholder="Nombres" type="text" maxlength="30" />
				</div>
				<div class="col-md-6 col-sm-12 col-mb-3">
					<input class="form-control" id="id_txt_ape_p" name="filtro"
						placeholder="Apellido paterno" type="text" maxlength="30" />
				</div>
				<div class="col-md-6 col-sm-12 col-mb-3">
					<input class="form-control" id="id_txt_ape_m" name="filtro"
						placeholder="Apellido materno" type="text" maxlength="30" />
				</div>
				<div class="col-md-6 col-sm-12 col-mb-3">
					<input class="form-control" id="id_txt_dni" name="filtro"
						placeholder="N&uacute;mero de Documento" type="text"
						maxlength="30" />
				</div>
				<div class="col-md-3 col-sm-6 col-mb-3">
					<button type="button" class="btn btn-primary btn-block "
						id="id_btn_filtrar">Buscar</button>
				</div>

				<div class="col-md-3 col-sm-6 col-mb-3">
					<button type="button" data-toggle='modal'
						data-target="#id_div_modal_registra"
						class='btn btn-success btn-block '>+Nuevo</button>
				</div>
			</div>
			<div class="row" style="padding-top: 3rem;">
				<div class="col-md-12">
					<div class="content table-responsive-md">
						<table id="id_table" class="table  table-hover  table-dark ">
							<thead>
								<tr>
									<th style="width: 5%">ID</th>
									<th style="width: 25%">Nombres</th>
									<th style="width: 3%">A. Paterno</th>
									<th style="width: 5%">A. Materno</th>
									<th style="width: 10%">Dni</th>
									<th style="width: 22%">Tel&eacute;fono</th>
									<th style="width: 10%">Genero</th>
									<th style="width: 10%"></th>
									<th style="width: 10%"></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<div class="modal animate__animated animate__bounceIn"
			id="id_div_modal_registra">
			<div class="modal-dialog" style="width: 60%">
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;
						</button>
						<h4 class="text-center">
							<span class="glyphicon glyphicon-ok-sign"></span> Registro -
							Prestatario
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8"
							class="form-horizontal" method="post">
							<div class="panel-group" id="steps_reg">
								<!-- Step 1 -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title text-center">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos de Prestatario</a>
										</h4>
									</div>
									<div id="stepOne_reg" class="panel-collapse collapse in">
										<div class="panel-body">

											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Nombres</label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_reg_numeroSala" name="nombres" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>

											<div class="row form-group ">
												<div class="col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Apellido Paterno</label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_reg_numeroSala" name="apellido_paterno"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
												<div class=" col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Apellido Materno </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_reg_numeroSala" name="apellido_materno"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>
											<div class="row form-group ">
												<div class="col-sm-6  ">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Celular </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_reg_numeroSala" name="celular" autocomplete="off"
															placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
												<div class="col-sm-6  ">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Tel&eacute;fono Fijo </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_reg_numeroSala" name="fijo" autocomplete="off"
															placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_tipoSala">Genero</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"><i
														class="bi bi-box2-heart-fill"></i></span> <select
														id="id_reg_tipoSala" name="genero"
														class='form-control input-sm'>
														<option value="">[Seleccione]</option>
														<option value="g_1">Masculino</option>
														<option value="g_2">Femenino</option>
													</select>
												</div>
											</div>

											<div class="row form-group ">
												<div class="form-group col-lg-6">
													<label class="col-lg-3 control-label" for="id_reg_tipoSala">Tipo
														Documento</label>
													<div class="input-group col-lg-8">
														<span class="input-group-addon"><i
															class="bi bi-box2-heart-fill"></i></span> <select
															id="id_reg_tipoSala" name="tipoDocumento"
															class='form-control input-sm'>
															<option value="">[Seleccione]</option>
															<option value="td_1">DNI</option>
															<option value="td_2">CE</option>
															<option value="td_3">RUC</option>
															<option value="td_4">Pasaporte</option>
														</select>
													</div>
												</div>
												<div class="form-group col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Nro. Documento </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_reg_numeroSala" name="nroDocumento"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>
											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Direccion </label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_reg_numeroSala" name="direccion" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>
											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">E-mail </label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_reg_numeroSala" name="email" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>

											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Salario Mensual Aprox.</label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_reg_numeroSala" name="salarioMensual"
														autocomplete="off" placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_tipoSala">Estado
													Civil</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"><i
														class="bi bi-box2-heart-fill"></i></span> <select
														id="id_reg_tipoSala" name="estadoCivil"
														class='form-control input-sm'>
														<option value="">[Seleccione]</option>
														<option value="so_o">Soltero/a</option>
														<option value="ca_o">Casado/a</option>
														<option value="vi_o">Viudo/a</option>
														<option value="di_o">Divorciado/a</option>
														<option value="se_o">Separado/a</option>
														<option value="co_e">Conviviente</option>
													</select>
												</div>
											</div>

											<div class="form-group ">
												<label class="control-label col-lg-3" for="id_reg_piso">Fecha
													Nacimiento</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"> <i
														class="bi bi-bar-chart-steps"></i>
													</span> <input class="form-control input-sm" type="date"
														id="fechaNacimientoRegistro" name="fechaNacimiento"
														autocomplete="off" placeholder="Ingrese piso 1,2,...,21">
												</div>
											</div>


											<div class="row">
												<div class="form-group col-md-12">
													<div class="col-md-12" align="center">
														<button type="button" class="btn btn-primary btn-lg"
															id="id_btn_registra">Guardar</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>

		<div class="modal animate__animated animate__bounceIn"
			id="id_div_modal_actualiza">
			<div class="modal-dialog" style="width: 60%">

				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> ActualizaR ::
							DATOS PRESTATARIO
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							class="form-horizontal" method="post">
							<div class="panel-group" id="steps_act">
								<!-- Step 1 -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title text-center">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne_act">Datos de Prestatario</a>
										</h4>
									</div>
									<div id="stepOne_act" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_ID">ID</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_ID"
														readonly="readonly" name="idSala" type="text"
														maxlength="8" />
												</div>
											</div>
											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Nombres</label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_act_nombres" name="nombres" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>

											<div class="row form-group ">
												<div class="col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Apellido Paterno</label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_act_ape_p" name="apellido_paterno"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
												<div class=" col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Apellido Materno </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_act_ape_m" name="apellido_materno"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>
											<div class="row form-group ">
												<div class="col-sm-6  ">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Celular </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_act_celular" name="celular" autocomplete="off"
															placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
												<div class="col-sm-6  ">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Tel&eacute;fono Fijo </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_act_fijo" name="fijo" autocomplete="off"
															placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_tipoSala">Genero</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"><i
														class="bi bi-box2-heart-fill"></i></span> <select
														id="id_act_genero" name="genero"
														class='form-control input-sm'>
														<option value="">[Seleccione]</option>
														<option value="g_1">Masculino</option>
														<option value="g_2">Femenino</option>
													</select>
												</div>
											</div>

											<div class="row form-group ">
												<div class="form-group col-lg-6">
													<label class="col-lg-3 control-label" for="id_reg_tipoSala">Tipo
														Documento</label>
													<div class="input-group col-lg-8">
														<span class="input-group-addon"><i
															class="bi bi-box2-heart-fill"></i></span> <select
															id="id_act_tipo_documento" name="tipoDocumento"
															class='form-control input-sm'>
															<option value="">[Seleccione]</option>
															<option value="td_1">DNI</option>
															<option value="td_2">CE</option>
															<option value="td_3">RUC</option>
															<option value="td_4">Pasaporte</option>
														</select>
													</div>
												</div>
												<div class="form-group col-lg-6">
													<label class="col-lg-3 control-label"
														for="id_reg_numeroSala">Nro. Documento </label>
													<div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
															class="bi bi-boxes"></i></span><input
															class="form-control input-sm" type="text"
															id="id_act_nro_documento" name="nroDocumento"
															autocomplete="off" placeholder="Ingrese el n&uacute;mero">
													</div>
												</div>
											</div>
											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Direccion </label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_act_direccion" name="direccion" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>
											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">E-mail </label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_act_email" name="email" autocomplete="off"
														placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>

											<div class="form-group ">
												<label class="col-lg-3 control-label"
													for="id_reg_numeroSala">Salario Mensual Aprox.</label>
												<div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
														class="bi bi-boxes"></i></span><input
														class="form-control input-sm" type="text"
														id="id_act_salario" name="salarioMensual"
														autocomplete="off" placeholder="Ingrese el n&uacute;mero">
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_tipoSala">Estado
													Civil</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"><i
														class="bi bi-box2-heart-fill"></i></span> <select
														id="id_act_estado_civil" name="estadoCivil"
														class='form-control input-sm'>
														<option value="">[Seleccione]</option>
														<option value="so_o">Soltero/a</option>
														<option value="ca_o">Casado/a</option>
														<option value="vi_o">Viudo/a</option>
														<option value="di_o">Divorciado/a</option>
														<option value="se_o">Separado/a</option>
														<option value="co_e">Conviviente</option>
													</select>
												</div>
											</div>

											<div class="form-group ">
												<label class="control-label col-lg-3" for="id_reg_piso">Fecha
													Nacimiento</label>
												<div class="input-group col-lg-8">
													<span class="input-group-addon"> <i
														class="bi bi-bar-chart-steps"></i>
													</span> <input class="form-control input-sm" type="date"
														id="fechaNacimientoRegistro" name="fechaNacimiento"
														autocomplete="off" placeholder="Ingrese piso 1,2,...,21">
												</div>
											</div>


											<div class="row">
												<div class="form-group col-md-12">
													<div class="col-md-12" align="center">
														<button type="button" class="btn btn-primary btn-lg"
															id="id_btn_actualiza">Actualizar</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>


	<script type="text/javascript">
	<!-- Agregar aqu� -->
		$(function() {
			$("#fechaNacimientoRegistro").flatpickr({
		        // Opciones de configuraci�n de Flatpickr
		        dateFormat: 'Y-m-d', // Formato de fecha
		        locale: 'es'
		        // Otras opciones que desees configurar
		    });
			buscarPorFiltrosGestionPrestatario()
		});



		$("#id_btn_filtrar").click(function() {
			buscarPorFiltrosGestionPrestatario();
		});

		$("#id_txt_filtro").on('keypress', function(e) {
			if (e.which == 13) {
				var fil = $("#id_txt_filtro").val();
				$.getJSON("buscarNumeroOrRecursosSalaCrud", {
					"filtro" : fil
				}, function(lista) {
					agregarGrilla(lista);
				});
			}
		});

		function limpiarFormularioRegistro() {
			$("#id_reg_numeroSala").val("")
			$("#id_reg_piso").val("")
			$("#id_reg_recursos").val("")
			$("#id_reg_nroAlumnos").val("")
			$("#id_reg_sede").val("")
			$("#id_reg_tipoSala").val("")
		}

		$("#id_btn_registra").click(function() {
//
			//$('#id_form_registra').bootstrapValidator('validate');
			//var validator = $('#id_form_registra').data('bootstrapValidator');
			//validator.validate();

			//if (validator.isValid()) {
				$.ajax({
					type : "POST",
					url : "insertPrestatario",
					data : $('#id_form_registra').serialize(),
					success : function(data) {
						if(data.MSG_OK == null ){
						const Toast = Swal.mixin({
							  toast: true,
							  position: "top-end",
							  showConfirmButton: false,
							  timer: 3000,
							  timerProgressBar: true,
							  didOpen: (toast) => {
							    toast.onmouseenter = Swal.stopTimer;
							    toast.onmouseleave = Swal.resumeTimer;
							  }
							});
							Toast.fire({
							  icon: "error",
							  title: data.MSG_ERROR
							});
							}else{
								const Toast = Swal.mixin({
									  toast: true,
									  position: "top-end",
									  showConfirmButton: false,
									  timer: 3000,
									  timerProgressBar: true,
									  didOpen: (toast) => {
									    toast.onmouseenter = Swal.stopTimer;
									    toast.onmouseleave = Swal.resumeTimer;
									  }
									});
									Toast.fire({
									  icon: "success",
									  title: data.MSG_OK
									});
						$('#id_div_modal_registra').modal("hide");
						limpiarFormularioRegistro();
						agregarGrilla(data.LIST);
						//validator.resetForm();
					}
						},
					error : function() {
						Swal.fire({
							  title: "Oops...?",
							  text: MSG_ERROR,
							  icon: "error"
							});
					}
				});
			//}
		});

		$("#id_btn_actualiza").click(function() {
		//	var validator = $('#id_form_actualiza').data('bootstrapValidator');
	//	validator.validate();
		//	if (validator.isValid()) {
				$.ajax({
					type : "POST",
					url : "actualizarPrestatario",
					data : $('#id_form_actualiza').serialize(),
					success : function(data) {
						if(data.MSG_OK == null ){
						const Toast = Swal.mixin({
							  toast: true,
							  position: "top-end",
							  showConfirmButton: false,
							  timer: 3000,
							  timerProgressBar: true,
							  didOpen: (toast) => {
							    toast.onmouseenter = Swal.stopTimer;
							    toast.onmouseleave = Swal.resumeTimer;
							  }
							});
							Toast.fire({
							  icon: "error",
							  title: data.MSG_ERROR
							});
							}else{
								const Toast = Swal.mixin({
									  toast: true,
									  position: "top-end",
									  showConfirmButton: false,
									  timer: 3000,
									  timerProgressBar: true,
									  didOpen: (toast) => {
									    toast.onmouseenter = Swal.stopTimer;
									    toast.onmouseleave = Swal.resumeTimer;
									  }
									});
									Toast.fire({
									  icon: "success",
									  title: data.MSG_OK
									});
						$('#id_div_modal_registra').modal("hide");
						limpiarFormularioRegistro();
						agregarGrilla(data.LIST);
						//validator.resetForm();
					}
						},
					error : function() {
						Swal.fire({
							  title: "Oops...?",
							  text: MSG_ERROR,
							  icon: "error"
							});
					}
				});
			//}
		});

		function buscarPorFiltrosGestionPrestatario() {

			var nombres = $("#id_txt_nombres").val();
			var ape_p = $("#id_txt_ape_p").val();
			var ape_m = $("#id_txt_ape_m").val();
			var dni = $("#id_txt_dni").val();
			$.getJSON("buscarPorFiltrosGestionPrestatario", {
				"nombres" : nombres,
				"ape_m" : ape_m,
				"ape_p" : ape_p,
				"dni" : dni
			}, function(data) {
				if (data.LIST == null) {
					const Toast = Swal.mixin({
						  toast: true,
						  position: "top-end",
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    toast.onmouseenter = Swal.stopTimer;
						    toast.onmouseleave = Swal.resumeTimer;
						  }
						});
						Toast.fire({
						  icon: "info",
						  title: data.MSG
						});
				} else {
					agregarGrilla(data.LIST);
				}
			});
		}


		function agregarGrilla(lista) {
			
			$('#id_table').DataTable().clear();
			$('#id_table').DataTable().destroy();
			$('#id_table')
					.DataTable(
							{
								data : lista,
								searching : false,
								ordering : true,
								processing : true,
								pageLength : 10,
								lengthChange : false,
								columns : [
										{
											data : "id"
										},
										{
											data : "nombres"
										},
										{
											data : "apellido_paterno"
										},
										{
											data : "apellido_materno"
										},
										{
											data : "nroDocumento"
										},
										{
										
											 data: "contacto"
										},
										{
											data : "genero"
										},
										{
											data : function(row, type, val,
													meta) {
																		var salida = '<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''
														+ row.id
														+ '\',\''
														+ row.nombres
														+ '\',\''
														+ row.apellido_paterno
														+ '\',\''
														+ row.apellido_materno
														+ '\',\''
														+ row.contacto
														+ '\',\''
														+ row.genero
														+ '\',\''
														+ row.tipoDocumento
														+ '\',\''
														+ row.nroDocumento
														+ '\',\''
														+ row.direccion
														+ '\',\''
														+ row.email
														+ '\',\''
														+ row.salario
														+ '\',\''
														+ row.estadoCivil
														+ '\',\''
														+ row.fechaNacimiento
														+ '\')">Editar</button>';
												return salida;
											},
											className : 'text-center'
										},
										{	
											data : function(row, type, val,
													meta) {
											//	var salida = '<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\''
												//		+ row.idSala
													//	+ '\')">'
														//+ (row.estado == 1 ? 'Activo'
															//	: 'Inactivo')
													//	+ '</button>';
												//return salida;
											},
											className : 'text-center'
										}, ],
								createdRow : function(row) {
									var numeroCell = $('td:eq(2)', row);
									numeroCell.text(numeroCell.text()
											.toUpperCase());
								}
							});
		}

		function editar(id, nombres, ape_p,ape_m, celular, fijo, genero,
		tipo_documento,nro_documento,direccion,email,salario,estado_civil,
		fecha_nacimiento) {
			$('#id_act_ID').val(id);
			$('#id_act_nombres').val(nombres);
			$('#id_act_ape_p').val(ape_p);
			$('#id_act_ape_m').val(ape_m);
			$('#id_act_celular').val(celular);
			$('#id_act_fijo').val(fijo);
			$('#id_act_genero').val(genero);
			$('#id_act_tipo_documento').val(tipo_documento);
			$('#id_act_nro_documento').val(nro_documento);
			$('#id_act_direccion').val(direccion);
			$('#id_act_email').val(email);
			$('#id_act_salario').val(salario);
			$('#id_act_estado_civil').val(estado_civil);
			$('#fechaNacimientoRegistro').val(fecha_nacimiento);
			$('#id_div_modal_actualiza').modal("show");
		}

		function accionEliminar(id) {
			$.ajax({
				type : "POST",
				url : "cambiarEstadoSalaCrud",
				data : {
					"idSala" : id
				},
				success : function(data) {
					agregarGrilla(data.lista);
				},
				error : function() {
					mostrarMensaje(MSG_ERROR);
				}
			});
		}

	</script>

	<script type="text/javascript">
		/**$('#id_form_registra')
				.bootstrapValidator(
						{
							message : 'El valor no es valido',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								numeroSala : {
									selector : '#id_reg_numeroSala',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										regexp : {
											regexp : '^[a-zA-Z]{1}[0-9]{3}$',
											message : 'Ejm: B393, a989, ... '
										},
										remote : {
											delay : 600,
											url : 'buscarNumeroSalaCrud',
											message : 'El n&uacute;mero ya existe'
										}
									}
								},
								numAlumnos : {
									selector : '#id_reg_nroAlumnos',
									validators : {
										notEmpty : {
											message : 'Campo obligatorio'
										},
										integer : {
											message : 'El valor no es v&aacute;lido'
										},
										between : {
											message : 'Cantidad de alumnos permitidos 1(min.) a 99(m&aacute;x.)',
											min : 1,
											max : 99
										}
									}
								},
								piso : {
									selector : '#id_reg_piso',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										between : {
											message : 'Pisos permitidos 1(min.) a 99 (m&aacute;x.)',
											min : 1,
											max : 99
										},
										integer : {
											message : 'El valor no es v&aacute;lido'
										},
									}
								},
								recursos : {
									selector : '#id_reg_recursos',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										stringLength : {
											max : 45,
											min : 2,
											message : 'Caracteres permitidos 2(min.) a 45 (max.)'
										}
									}
								},
								sede : {
									selector : '#id_reg_sede',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										}
									}
								},
								tipoSala : {
									selector : '#id_reg_tipoSala',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										}
									}
								}
							}
						});**/
	</script>
	<script type="text/javascript">
		/**$('#id_form_actualiza')
				.bootstrapValidator(
						{
							message : 'El valor no es valido',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								numeroSala : {
									selector : '#id_act_numeroSala',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										regexp : {
											regexp : '^[a-zA-Z]{1}[0-9]{3}$',
											message : 'Ejm: B393, a989, ... '
										}
									}
								},
								numAlumnos : {
									selector : '#id_act_nroAlumnos',
									validators : {
										notEmpty : {
											message : 'Campo obligatorio'
										},
										integer : {
											message : 'El valor no es v&aacute;lido'
										},
										between : {
											message : 'Cantidad de alumnos permitidos 1(min.) a 99(m&aacute;x.)',
											min : 1,
											max : 99
										}
									}
								},
								piso : {
									selector : '#id_act_piso',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										between : {
											message : 'Pisos permitidos 1(min.) a 99 (m&aacute;x.)',
											min : 1,
											max : 99
										},
										integer : {
											message : 'El valor no es v&aacute;lido'
										},
									}
								},
								recursos : {
									selector : '#id_act_recursos',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										},
										stringLength : {
											max : 45,
											min : 2,
											message : 'Caracteres permitidos 2(min.) a 45 (max.)'
										}
									}
								},
								sede : {
									selector : '#id_act_sede',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										}
									}
								},
								tipoSala : {
									selector : '#id_act_tipoSala',
									validators : {
										notEmpty : {
											message : 'Campo Obligatorio'
										}
									}
								}
							}
						});**/
	</script>
</body>
</html>--%>
