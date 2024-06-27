<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
                                                                   autocomplete="off"
                                                                   placeholder="Ingrese piso 1,2,...,21">
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <div class="col-md-12" align="center">
                                                <button type="button" class="btn btn-primary btn-lg"
                                                        id="id_btn_registra">Guardar
                                                </button>
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

            <div class="modal-header" style="padding: 23px 25px">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h1>
                    <span class="glyphicon glyphicon-ok-sign"></span> Actualizar ::
                    DATOS PRODUCTO
                </h1>
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
                                                   readonly="readonly" name="id_producto" type="text"
                                                   maxlength="8"/>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_numeroSala">Codigo </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_cod_prod" name="codigo_producto"
                                                    autocomplete="off" placeholder="Ingrese el codigo">
                                            </div>
                                        </div>
                                        <div class=" col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_numeroSala">Nombre </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_nom_prod" name="nombre_producto"
                                                    autocomplete="off" placeholder="Ingrese el nombre">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_numeroSala">Cantidad </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_sto_prod" name="stock_producto" autocomplete="off"
                                                    placeholder="Ingrese el Stock">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_numeroSala">Precio </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_pre_prod" name="precio_producto" autocomplete="off"
                                                    placeholder="Ingrese el Precio">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-lg-6">

                                            <label class="col-lg-4 control-label" for="id_reg_tipoSala">Tipo
                                                Documento </label>
                                            <div class="input-group col-lg-8">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-box2-heart-fill"></i></span>
                                                <select id="id_act_tipo_documento" name="tipo_documento"
                                                        class="form-control">
                                                    <option value="">[Seleccione]</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_numeroSala">Nro. Documento </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_nro_doc_prod" name="documento_producto"
                                                    autocomplete="off" placeholder="Ingrese el Nro de Documento">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label class="col-lg-3 control-label"
                                               for="id_reg_numeroSala">Descripcion Producto </label>
                                        <div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
                                                            class="bi bi-boxes"></i></span><textarea
                                                class="form-control input-sm" type="text"
                                                id="id_act_des_prod" name="descripcion_producto" autocomplete="off"
                                                placeholder="Ingrese la Descripcion del Producto"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_tipoSala">Tipo
                                            Producto </label>
                                        <div class="input-group col-lg-8">
                                            <span class="input-group-addon"><i class="bi bi-box2-heart-fill"></i></span>
                                            <select id="id_act_tipo" name="tipo" class="form-control">
                                                <option value="">[Seleccione]</option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <div class="col-md-12" align="center">
                                                <button type="button" class="btn btn-primary btn-lg"
                                                        id="id_btn_actualiza">Actualizar
                                                </button>
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