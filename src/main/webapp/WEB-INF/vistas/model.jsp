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
                    DATOS PRODUCTO
                </h4>
            </div>
            <div class="modal-body" style="padding: 20px 10px;">
                <form id="id_form_registra" accept-charset="UTF-8" class="form-horizontal" method="post">
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
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_cod_prod">Codigo </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_cod_prod" name="cod_prod"
                                                    autocomplete="off" placeholder="Ingrese el codigo">
                                            </div>
                                        </div>
                                        <div class=" col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_nom_prod">Nombre </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_nom_prod" name="nom_prod"
                                                    autocomplete="off" placeholder="Ingrese el nombre">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_sto_prod">Cantidad </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_sto_prod" name="sto_prod" autocomplete="off"
                                                    placeholder="Ingrese el Stock">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_pre_prod">Precio Unitario</label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_pre_prod" name="pre_prod" autocomplete="off"
                                                    placeholder="Ingrese el Precio">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-lg-6">

                                            <label class="col-lg-4 control-label" for="id_reg_tipo_documento">Tipo
                                                Documento </label>
                                            <div class="input-group col-lg-8">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-box2-heart-fill"></i></span>
                                                <select id="id_reg_tipo_documento" name="tip_docu"
                                                        class="form-control">
                                                    <option value="">[Seleccione]</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_reg_nro_doc_prod">Nro. Documento </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_reg_nro_doc_prod" name="doc_prod"
                                                    autocomplete="off" placeholder="Ingrese el Nro de Documento">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label class="col-lg-3 control-label"
                                               for="id_reg_des_prod">Descripcion Producto </label>
                                        <div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
                                                            class="bi bi-boxes"></i></span><textarea
                                                class="form-control input-sm" type="text"
                                                id="id_reg_des_prod" name="des_prod" autocomplete="off"
                                                placeholder="Ingrese la Descripcion del Producto"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_catalogo">Tipo
                                            Producto </label>
                                        <div class="input-group col-lg-8">
                                            <span class="input-group-addon"><i class="bi bi-box2-heart-fill"></i></span>
                                            <select id="id_reg_catalogo" name="catalogo" class="form-control">
                                                <option value="">[Seleccione Tipo]</option>
                                                <c:forEach items="${catalogos}" var="item">
                                                    <option value="${item.idCatalogo}">${item.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_data_catalogo">Sub Tipo
                                            Producto </label>
                                        <div class="input-group col-lg-8">
                                            <span class="input-group-addon"><i class="bi bi-box2-heart-fill"></i></span>
                                            <select id="id_reg_data_catalogo" name="dataCatalogo" class="form-control">
                                            </select>
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
                                       href="#stepOne_act">Datos de Productos</a>
                                </h4>
                            </div>

                            <div id="stepOne_act" class="panel-collapse collapse in">
                                <div class="panel-body">

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_ID">ID</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" id="id_act_ID"
                                                   readonly="readonly" name="id_prod" type="text"
                                                   maxlength="8"/>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_cod_prod">Codigo </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_cod_prod" name="cod_prod"
                                                    autocomplete="off" placeholder="Ingrese el codigo">
                                            </div>
                                        </div>
                                        <div class=" col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_nom_prod">Nombre </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_nom_prod" name="nom_prod"
                                                    autocomplete="off" placeholder="Ingrese el nombre">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_sto_prod">Cantidad </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_sto_prod" name="sto_prod" autocomplete="off"
                                                    placeholder="Ingrese el Stock">
                                            </div>
                                        </div>
                                        <div class="col-sm-6  ">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_pre_prod">Precio Unitario</label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_pre_prod" name="pre_prod" autocomplete="off"
                                                    placeholder="Ingrese el Precio">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row form-group ">
                                        <div class="col-lg-6">

                                            <label class="col-lg-4 control-label" for="id_act_tipo_documento">Tipo
                                                Documento </label>
                                            <div class="input-group col-lg-8">
                                                <span class="input-group-addon"><i
                                                        class="bi bi-box2-heart-fill"></i></span>
                                                <select id="id_act_tipo_documento" name="tip_docu"
                                                        class="form-control">
                                                    <option value="">[Seleccione]</option>
                                                </select>

                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <label class="col-lg-4 control-label"
                                                   for="id_act_nro_doc_prod">Nro. Documento </label>
                                            <div class="input-group col-lg-8 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                                                    class="form-control input-sm" type="text"
                                                    id="id_act_nro_doc_prod" name="doc_prod"
                                                    autocomplete="off" placeholder="Ingrese el Nro de Documento">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group ">
                                        <label class="col-lg-3 control-label"
                                               for="id_act_des_prod">Descripcion Producto </label>
                                        <div class="input-group col-lg-8 ">
													<span class="input-group-addon"><i
                                                            class="bi bi-boxes"></i></span><textarea
                                                class="form-control input-sm" type="text"
                                                id="id_act_des_prod" name="des_prod" autocomplete="off"
                                                placeholder="Ingrese la Descripcion del Producto"></textarea>
                                        </div>
                                    </div>

                                   <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_data_catalogo">Tipo
                                            Producto </label>
                                        <div class="input-group col-lg-8">
                                            <span class="input-group-addon"><i class="bi bi-box2-heart-fill"></i></span>
                                            <select id="id_act_data_catalogo" name="idDataCatalogo" class="form-control">
                                                <option value="">[Seleccione Tipo]</option>
                                            </select>
                                        </div>
                                    </div>

                                   <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_catalogo">Sub
                                            tipo </label>
                                        <div class="input-group col-lg-8">
                                            <span class="input-group-addon"><i class="bi bi-box2-heart-fill"></i></span>
                                            <select id="id_act_catalogo" name="dataCatalogo.idCatalogo" class="form-control">
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