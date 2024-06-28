<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Expires" content="-1"/>
    <meta http-equiv="Cache-Control" content="private"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrapValidator.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <script src="https://npmcdn.com/flatpickr/dist/l10n/es	.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

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

        input[type="checkbox"] {
            height: 2em; /* Aumenta la altura del checkbox */
            width: 2em; /* Aumenta el ancho del checkbox */
        }
    </style>
</head>
<body>
<header>
    <jsp:include page="intranetCabecera.jsp"/>
</header>


<div class="container" style="margin-top: 4%">
    <!-- Agregar aqu -->
    <h3>Gesti&oacute;n Productos</h3>

    <div class=" col-md-12 ">

        <div class="row">
            <div class="row form-group ">
                <div class="col-lg-6">
                    <div class="input-group col-lg-12 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span>
                        <input
                                class="form-control input-sm" type="text"
                                id="id_txt_codigo" name="filtro" maxlength="10"
                                autocomplete="off" placeholder="Ingrese el codigo">
                    </div>
                </div>
                <div class=" col-lg-6">
                    <div class="input-group col-lg-12 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span>
                        <input
                                class="form-control input-sm" type="text"
                                id="id_txt_nombre" name="filtro" maxlength="30"
                                autocomplete="off" placeholder="Ingrese el nombre">
                    </div>
                </div>
            </div>
            <div class="row form-group ">
                <div class="col-sm-6  ">
                    <div class="input-group col-lg-12 ">
														<span class="input-group-addon"><i
                                                                class="bi bi-boxes"></i></span><input
                            class="form-control input-sm" type="text" maxlength="30"
                            id="id_txt_descripcion" name="filtro" autocomplete="off"
                            placeholder="Ingrese la descripcion">
                    </div>
                </div>
                <%--<div class="col-sm-6 ">
                    <div class="input-group col-lg-12 ">
                        <input type="checkbox" id="id_txt_activo" class="filter-checkbox" data-product-id="123">
                        <label class="col-lg-3 control-label" for="id_txt_activo"> Ver Inactivos </label>

                    </div>
                </div>--%>
            </div>

            <div class="form-group">
                <div class="col-md-3 col-sm-6 col-mb-3">
                    <button type="button" class="btn btn-primary btn-block "
                            id="id_btn_filtrar"><i class="bi bi-search"></i> Buscar
                    </button>
                </div>

                <div class="col-md-3 col-sm-6 col-mb-3">
                    <button type="button" data-toggle='modal'
                            data-target="#id_div_modal_registra"
                            class='btn btn-success btn-block '><i class="bi bi-plus-square"></i> Nuevo
                    </button>
                </div>
            </div>
        </div>

        <div class="row" style="padding-top: 3rem;">
            <div class="col-md-12">
                <div class="content table-responsive-md">
                    <table id="id_table" class="table  table-hover  table-dark dt-responsive nowrap" style="width:100%">
                        <thead>
                        <tr>
                            <th style="width: 5%">ID</th>
                            <th style="width: 25%">Codigo</th>
                            <th style="width: 3%">Nombre</th>
                            <th style="width: 5%">Descripcion</th>
                            <th style="width: 10%">Precio Total</th>
                            <th style="width: 22%">Stock</th>
                            <th style="width: 10%">Nro Documento</th>
                            <th style="width: 10%">Tipo</th>
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

    <jsp:include page="model.jsp"/>

</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
    <!-- Agregar aqu� -->
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.stopPropagation()
                }
                // Prevenir la recarga de la página
                event.preventDefault()

                form.classList.add('was-validated')
            }, false)
        })
    })()

    $(document).ready(function () {
        listarProductos();
        buscarPorFiltrosGestionProductos();
        // Realiza la solicitud para obtener la lista de nacionalidades
        $.getJSON("listaTipoDocumento", {})
            .done(function (data) {
                // Limpiar el select antes de agregar las nuevas opciones
                $("#id_act_tipo_documento").empty();

                // Iterar sobre los datos obtenidos
                $.each(data, function (index, item) {
                    // Crear una nueva opción
                    var option = $('<option>', {
                        value: index,
                        text: item
                    });

                    // Agregar la opción al select
                    $("#id_act_tipo_documento").append(option);
                });
            })
            .fail(function (jqxhr, textStatus, error) {
                // Manejar errores de la solicitud
                var err = textStatus + ", " + error;
                console.log("Fallo en la solicitud: " + err);
                // Puedes agregar aquí tu propia lógica para mostrar un mensaje de error al usuario
            });

        //registrar lista tipo documento
        $.getJSON("listaTipoDocumento", {}, function (data) {
            $.each(data, function (index, item) {
                $("#id_reg_tipo_documento").append(
                    $('<option>', {
                        value: index,
                        text: item
                    }));
            });
        });

        $.getJSON("listarPorCatalogo", {}, function (data) {
            $.each(data, function (index, item) {
                $("#id_act_catalogo").append(
                    $('<option>', {
                        value: index,
                        text: item
                    }));
                $("#id_reg_catalogo").append(
                    $('<option>', {
                        value: index,
                        text: item
                    }));
            });
        });

        $("#id_btn_filtrar").click(function () {
            buscarPorFiltrosGestionProductos();
        });

        $("#id_txt_filtro").on('keypress', function (e) {
            if (e.which == 13) {
                var fil = $("#id_txt_filtro").val();
                $.getJSON("buscarProductoPorNombre", {
                    "filtro": fil
                }, function (lista) {
                    agregarGrilla(lista);
                });
            }
        });


    });

    function limpiarFormularioRegistro() {
        $("#id_reg_codigo").val("")
        $("#id_reg_nombre").val("")
        $("#id_reg_descripcion").val("")
        $("#id_reg_precio").val("")
        $("#id_reg_stock").val("")
        $("#id_reg_nro_documento").val("")
        $("#id_reg_tipo_documento").val("")
        $("#id_reg_tipo").val("")
    }

    $("#id_btn_registra").click(function () {
//
        //$('#id_form_registra').bootstrapValidator('validate');
        //var validator = $('#id_form_registra').data('bootstrapValidator');
        //validator.validate();

        //if (validator.isValid()) {
        $.ajax({
            type: "POST",
            url: "insertProducto",
            data: $('#id_form_registra').serialize(),
            success: function (data) {
                if (data.MSG_OK == null) {
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
                } else {
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
                    window.location.reload();
                    //validator.resetForm();
                }
            },
            error: function () {
                Swal.fire({
                    title: "Oops...?",
                    text: MSG_ERROR,
                    icon: "error"
                });
            }
        });
        //}
    });

    $("#id_btn_actualiza").click(function () {
        //	var validator = $('#id_form_actualiza').data('bootstrapValidator');
        //	validator.validate();
        //	if (validator.isValid()) {
        $.ajax({
            type: "PUT",
            url: "actualizarProducto",
            data: $('#id_form_actualiza').serialize(),
            success: function (data) {
                if (data.MSG_OK == null) {
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
                } else {
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
                    window.location.reload();
                    //validator.resetForm();
                }
            },
            error: function () {
                Swal.fire({
                    title: "Oops...?",
                    text: MSG_ERROR,
                    icon: "error"
                });
            }
        });
        //}
    });

    function listarProductos() {
        $.getJSON("listarRegistrosActivoTrue", {
                "filtro": ''
            },
            function (data) {
                console.log(data)
                if (data == null) {
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
                    agregarGrilla(data);
                }
            });
    }

    function buscarPorFiltrosGestionProductos() {

        var cod_nom = $("#id_txt_codigo").val();
        var cod_pro = BigInt(cod_nom)
        var nom_pro = $("#id_txt_nombre").val();
        var des_pro = $("#id_txt_descripcion").val();
        $.getJSON("buscarPorFiltrosGestionProducto", {
            "cod_prod": cod_pro,
            "nom_prod": nom_pro,
            "des_prod": des_pro
        }, function (data) {
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
                    data: lista,
                    searching: false,
                    ordering: true,
                    processing: true,
                    pageLength: 10,
                    lengthChange: false,
                    columns: [
                        {
                            data: "id_producto"
                        },
                        {
                            data: "codigo_producto"
                        },
                        {
                            data: "nombre_producto"
                        },
                        {
                            data: "descripcion_producto"
                        },
                        {
                            data: function (row) {
                                if (row.stock_producto != '' && row.precio_producto != '') {
                                    total = row.precio_producto * row.stock_producto;
                                    precio = total.toFixed(2);
                                }
                                return precio // Verificamos si hay un objeto "contacto" y accedemos al atributo  "Fijo"
                            }
                            //data: "precio_producto"
                        },
                        {
                            data: "stock_producto"
                        },
                        {
                            data: function (row) {
                                if (row.documento_producto != '') {
                                    doc = row.tipo_documento.toString().substring(0, 3) + " - " + row.documento_producto;
                                }
                                return doc // Verificamos si hay un objeto "contacto" y accedemos al atributo  "Fijo"
                            }
                            //data: "documento_producto"
                        },
                        {
                            data: function (row) {
                                if (row.data_catalogo.descripcion != "") {
                                    sub = row.data_catalogo.catalogo.descripcion+" " + row.data_catalogo.descripcion;
                                }
                                return sub // Verificamos si hay un objeto "contacto" y accedemos al atributo  "Fijo"
                            }
                           // data: "data_catalogo.descripcion"
                        },
                        {
                            data: function (row, type, val,
                                            meta) {
                                var salida = '<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''
                                    + row.id_producto
                                    + '\',\''
                                    + row.codigo_producto
                                    + '\',\''
                                    + row.nombre_producto
                                    + '\',\''
                                    + row.descripcion_producto
                                    + '\',\''
                                    + row.precio_producto
                                    + '\',\''
                                    + row.stock_producto
                                    + '\',\''
                                    + row.tipo_documento
                                    + '\',\''
                                    + row.documento_producto
                                    + '\',\''
                                    + row.data_catalogo.idDataCatalogo
                                    + '\')">Editar</button>';
                                return salida;
                            },
                            className: 'text-center'
                        },
                        {
                            data: function (row, type, val,
                                            meta) {
                                var salida = '<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\''
                                    + row.id_producto
                                    + '\')">'
                                    + (row.registros.activo == 1 ? 'Activo'
                                        : 'Inactivo')
                                    + '</button>';
                                return salida;
                            },
                            className: 'text-center'
                        },]
                });

    }

    function editar(id, cod_prod, nom_prod, des_prod, pre_prod, sto_prod,
                    tipo_documento, nro_doc_prod, data_catalogo, catalogo) {
        $('#id_act_ID').val(id);
        $('#id_act_cod_prod').val(cod_prod);
        $('#id_act_nom_prod').val(nom_prod);
        $('#id_act_pre_prod').val(pre_prod);
        $('#id_act_sto_prod').val(sto_prod);
        $('#id_act_tipo_documento').val(tipo_documento);
        $('#id_act_nro_doc_prod').val(nro_doc_prod);
        $('#id_act_des_prod').val(des_prod);
        $('#id_act_data_catalogo').val(data_catalogo);
        $('#id_act_catalogo').val(catalogo);
        $('#id_div_modal_actualiza').modal("show");
    }

    function accionEliminar(id_producto) {
        $.ajax({
            type: "POST",
            url: "cambiarEstadoProductoCrud",
            data: {
                "id_producto": id_producto
            },
            success: function (data) {
                agregarGrilla(data.lista);
            },
            error: function () {
                mostrarMensaje(MSG_ERROR);
            }
        });
    }

</script>

<script>
    /*$(document).ready(function() {

        $("#id_act_catalogo").change(function() {
            var catalogoId = $(this).val();

            $.ajax({
                url: "/listarPorCatalogo/" + catalogoId,
                type: "GET",
                success: function(data) {
                    $("#id_act_data_catalogo").empty();

                    c

                }
            });
        });
    });*/

    /*//asignar evento change al select con ID "idLaboratorio"
    $(document).on("change","#idLaboratorio",function(){
        //variable
        let cod;
        cod=$(this).val();
        //limpiar combo de tipo
        $("#idTipo").empty().append("<option>[Seleccione Tipo de Medicamento]</option>")
        $.get("/medicamento/listarPorLaboratorio?codigo="+cod,function(response){
            //bucle
            $.each(response,function(index,item){
                $("#idTipo").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
            })
            $("#idTipo").val(codTipo);

        })
    })
    */
    $(document).ready(function() {
        $("#id_act_catalogo").change(function() {
            var catalogoId = $(this).val();
            $("#id_act_data_catalogo").empty().append("<option>[Seleccione un Sub Tipo]</option>")
            $.ajax({
                url: "/listarPorDataCatalogo/" + catalogoId,
                method: "GET",
                success: function(data) {
                    $.each(data, function(index, item) {
                        $("#id_act_data_catalogo").append(
                            $('<option>', {
                                value: item,
                                text: item
                            }));
                        //$("#id_act_data_catalogo").append("<option value='" + index + "'>" + item + "</option>");
                    });
                }
            });
        });
    });
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
</html>