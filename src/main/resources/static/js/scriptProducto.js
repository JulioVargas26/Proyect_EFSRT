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
            $("#id_act_data_catalogo").append(
                $('<option>', {
                    value: index,
                    text: item
                }));
            $("#id_reg_data_catalogo").append(
                $('<option>', {
                    value: index,
                    text: item
                }));
        });
    });

    $("#id_act_data_catalogo").change(function () {
        var catalogoId = $(this).val();
        $("#id_act_catalogo").empty().append("<option>[Seleccione un Sub Tipo]</option>")
        $.ajax({
            url: "/listarPorDataCatalogo/" + catalogoId,
            method: "GET",
            success: function (data) {
                $.each(data, function (index, item) {
                    $("#id_act_catalogo").append(
                        $('<option>', {
                            value: index,
                            text: item
                        }));
                });
            }
        });

    });
    $("#id_reg_data_catalogo").change(function () {
        var catalogoId = $(this).val();
        $("#id_reg_catalogo").empty().append("<option>[Seleccione un Sub Tipo]</option>")
        $.ajax({
            url: "/listarPorDataCatalogo/" + catalogoId,
            method: "GET",
            success: function (data) {
                $.each(data, function (index, item) {
                    $("#id_reg_catalogo").append(
                        $('<option>', {
                            value: index,
                            text: item
                        }));
                });
            }
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

/*
$('#saveButton').click(function() {
    var brandId = $('#brandSelect').val();
    var categoryId = $('#categorySelect').val();
    var productName = $('#productName').val();

    var product = {
        name: productName,
        brand: { id: brandId },
        category: { id: categoryId }
    };

    $.ajax({
        url: '/products/save',
        method: 'POST',
        data: JSON.stringify(product),
        contentType: 'application/json',
        success: function(data) {
            alert('Product saved successfully!');
        }
    });
});
*/

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
                    },
                    {
                        data: function (row) {
                            if (row.dataCatalogo.descripcion != "") {
                                sub = row.dataCatalogo.catalogo.descripcion + " " + row.dataCatalogo.descripcion;
                            }
                            return sub // Verificamos si hay un objeto "contacto" y accedemos al atributo  "Fijo"
                        }
                        //data: "dataCatalogo.descripcion"
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
                                + row.dataCatalogo.idDataCatalogo
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
                tipo_documento, nro_doc_prod, idDataCatalogo) {
    $('#id_act_ID').val(id);
    $('#id_act_cod_prod').val(cod_prod);
    $('#id_act_nom_prod').val(nom_prod);
    $('#id_act_pre_prod').val(pre_prod);
    $('#id_act_sto_prod').val(sto_prod);
    $('#id_act_tipo_documento').val(tipo_documento);
    $('#id_act_nro_doc_prod').val(nro_doc_prod);
    $('#id_act_des_prod').val(des_prod);
    $('#id_act_data_catalogo').val(idDataCatalogo);
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
            window.location.reload();
        },
        error: function () {
            mostrarMensaje(MSG_ERROR);
        }
    });
}

/*

$('#id_form_actualiza')
    .
    bootstrapValidator(
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
    })
;*/
