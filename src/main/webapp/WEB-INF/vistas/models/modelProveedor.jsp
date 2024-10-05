<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="modal animate__animated animate__bounceIn"
     id="id_div_modal_reg_prov">
    <div class="modal-dialog" style="width: 60%">
        <div class="modal-content">
            <div class="modal-header" style="padding: 35px 50px">
                <button type="button" class="close" data-dismiss="modal">&times;
                </button>
                <h4 class="text-center">
                    <span class="glyphicon glyphicon-ok-sign"></span> Registro -
                    DATOS PROVEEDOR
                </h4>
            </div>
            <div class="modal-body" style="padding: 20px 10px;">
                <form id="id_form_reg_prov" accept-charset="UTF-8" class="form-horizontal" method="post">
                    <div class="panel-group" id="steps_reg">
                        <!-- Step 1 -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title text-center">
                                    <a data-toggle="collapse" data-parent="#steps"
                                       href="#stepOne">Datos de Productos</a>
                                </h4>
                            </div>

                            <div id="stepOne_reg" class="panel-collapse collapse in">
                                <div class="panel-body">

                                    <div class="row form-group ">
                                        <!-- INICIO PANEL BUSCAR POR DOCUMENTO -->
                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_buscar_api_numero_documento"> Numero RUC </label>
                                            <div class="input-group col-lg-8 ">
                                                <input class="form-control input-sm" type="text" maxlength="11"
                                                       id="id_buscar_api_numero_documento" name="ruc"
                                                       autocomplete="off" placeholder="ingrese el numero de documento">
                                                <span class="input-group-addon" type="button" id="btnConsultaSunat"><i
                                                        class="bi bi-search"></i></span>
                                            </div>
                                            <h6 id="id_msg_error_api_dni" style="display: none;color:red;">ERROR AL
                                                CONSULTAR EL DOCUMENTO
                                                -
                                                INTENTAR NUEVAMENTE</h6>
                                            <h6 id="id_msg_success_api_dni"
                                                style="display: none;color:rgb(36, 255, 94);">SE ENCONTRARON
                                                DATOS
                                            </h6>
                                        </div>
                                        <!-- FIN PANEL BUSCAR POR DOCUMENTO -->
                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_razon_social">Razon social </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_razon_social" name="razon_social"
                                                    autocomplete="off" placeholder="Razon Social">
                                            </div>
                                        </div>

                                    </div>

                                    <div class="form-group ">
                                        <label class="col-lg-2 control-label"
                                               for="id_reg_direccion_fiscal">Direccion </label>
                                        <div class="input-group col-lg-9 ">
													<span class="input-group-addon"><i
                                                            class="bi bi-boxes"></i></span>
                                            <input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_direccion_fiscal" name="direccion_fiscal"
                                                    autocomplete="off" placeholder="Direccion Fiscal">
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_condicion_ruc">Condicion </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_condicion_ruc" name="condicion_ruc"
                                                    autocomplete="off" placeholder="Condicion">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_estado_ruc">Estado </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_estado_ruc" name="estado_ruc" autocomplete="off"
                                                    placeholder="Estado">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label" for="id_reg_tipo_contacto">Tipo
                                                Contacto </label>
                                            <div class="input-group col-lg-8">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-box2-heart-fill"></i></span>
                                                <select id="id_reg_tipo_contacto" name="tipo_contacto"
                                                        class="form-control">
                                                    <option value="">[Seleccione]</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_nombre_contacto"> Nombre </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_nombre_contacto" name="nombre_contacto" autocomplete="off"
                                                    placeholder="Ingrese Nombre Contacto">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_telefono_prov">Telefono/Celular </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_telefono_prov" name="telefono_contacto"
                                                    autocomplete="off" placeholder="Ingrese Telefono">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_email_prov">E-mail </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_email_prov" name="email_contacto" autocomplete="off"
                                                    placeholder="Ingrese Correo Electronico">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <div class="col-md-12" align="center">
                                                <button type="button" class="btn btn-primary btn-lg"
                                                        id="id_btn_reg_prov">Guardar
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

<!--MODAL INICIO ACTUALIZA Prestatario-->
<div class="modal animate__animated animate__bounceIn"
     id="id_div_modal_act_prov">
    <div class="modal-dialog" style="width: 60%">

        <div class="modal-content">

            <div class="modal-header" style="padding: 23px 25px">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h1>
                    <span class="glyphicon glyphicon-ok-sign"></span> Actualizar ::
                    DATOS PROVEEDOR
                </h1>
            </div>

            <div class="modal-body" style="padding: 20px 10px">
                <form id="id_form_act_prov" accept-charset="UTF-8"
                      class="form-horizontal" method="post">
                    <div class="panel-group" id="steps_act">
                        <!-- Step 1 -->
                        <div class="panel panel-default">

                            <div class="panel-heading">
                                <h4 class="panel-title text-center">
                                    <a data-toggle="collapse" data-parent="#steps"
                                       href="#stepOne_act">Datos de Proveedor</a>
                                </h4>
                            </div>

                            <div id="stepOne_act" class="panel-collapse collapse in">
                                <div class="panel-body">

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_id_prov">ID</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" id="id_act_id_prov"
                                                   readonly="readonly" name="id_prov" type="text"
                                                   maxlength="8"/>
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_ruc"> Numero RUC </label>
                                            <div class="input-group col-lg-8 ">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-boxes"></i></span><input class="form-control input-sm" type="text" maxlength="11"
                                                       id="id_act_ruc" name="ruc"
                                                       autocomplete="off" placeholder="ingrese el numero de documento">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_razon_social">Razon social </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_razon_social" name="razon_social"
                                                    autocomplete="off" placeholder="Razon Social">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label class="col-lg-2 control-label"
                                               for="id_act_direccion_fiscal">Direccion </label>
                                        <div class="input-group col-lg-9 ">
													<span class="input-group-addon"><i
                                                            class="bi bi-boxes"></i></span>
                                            <input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_direccion_fiscal" name="direccion_fiscal"
                                                    autocomplete="off" placeholder="Direccion Fiscal">
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_condicion_ruc">Condicion </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_condicion_ruc" name="condicion_ruc"
                                                    autocomplete="off" placeholder="Condicion">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_estado_ruc">Estado </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_estado_ruc" name="estado_ruc" autocomplete="off"
                                                    placeholder="Estado">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label" for="id_act_tipo_contacto">Tipo
                                                Contacto </label>
                                            <div class="input-group col-lg-8">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-box2-heart-fill"></i></span>
                                                <select id="id_act_tipo_contacto" name="tipo_contacto"
                                                        class="form-control">
                                                    <option value="">[Seleccione]</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_nombre_contacto"> Nombre </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_nombre_contacto" name="nombre_contacto" autocomplete="off"
                                                    placeholder="Ingrese Nombre Contacto">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">

                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_telefono_prov">Telefono/Celular </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_telefono_prov" name="telefono_contacto"
                                                    autocomplete="off" placeholder="Ingrese Telefono">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_email_prov">E-mail </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_email_prov" name="email_contacto" autocomplete="off"
                                                    placeholder="Ingrese Correo Electronico">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="form-group col-md-12">
                                            <div class="col-md-12" align="center">
                                                <button type="button" class="btn btn-primary " id="id_btn_act_prov">
                                                    Actualizar
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
<!--MODAL FIN ACTUALIZA Prestatario-->

