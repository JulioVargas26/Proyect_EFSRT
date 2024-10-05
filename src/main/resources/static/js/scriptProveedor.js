let idDataCatalogo = -1;

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

    // Realiza la solicitud para obtener la lista de monedas
    $.getJSON("listaTipoContacto", {})
        .done(function (data) {
            // Limpiar el select antes de agregar las nuevas opciones
            $("#id_act_tipo_contacto").empty();

            // Iterar sobre los datos obtenidos
            $.each(data, function (index, item) {
                // Crear una nueva opción
                var option = $('<option>', {
                    value: index,
                    text: item
                });

                // Agregar la opción al select
                $("#id_act_tipo_contacto").append(option);
            });
        })
        .fail(function (jqxhr, textStatus, error) {
            // Manejar errores de la solicitud
            var err = textStatus + ", " + error;
            console.log("Fallo en la solicitud: " + err);
            // Puedes agregar aquí tu propia lógica para mostrar un mensaje de error al usuario
        });

    //registrar lista tipo moneda
    $.getJSON("listaTipoContacto", {}, function (data) {
        $.each(data, function (index, item) {
            $("#id_reg_tipo_contacto").append(
                $('<option>', {
                    value: index,
                    text: item
                }));
        });
    });

    $("#id_btn_filtrar_prov").click(function () {
        buscarPorFiltrosGestionProductos();
    });

    /*$("#id_txt_filtro").on('keypress', function (e) {
        if (e.which == 13) {
            var fil = $("#id_txt_filtro").val();
            $.getJSON("buscarProductoPorNombre", {
                "filtro": fil
            }, function (lista) {
                agregarGrilla(lista);
            });
        }
    });*/

});

$("#btnConsultaSunat").click(function () {
    $('#id_msg_error_api_dni').css('display', 'none');
    $('#id_msg_success_api_dni').css('display', 'none');
    var numeroDocumento = $("#id_buscar_api_numero_documento").val();

    $.ajax({
        type: "POST",
        url: "/consultaSunat",
        data: {
            numero_documento: numeroDocumento,
        },
        success: function (response) {
            console.log(response);
            var jsonData = JSON.parse(response);
            $("#id_buscar_api_numero_documento").val(jsonData.numeroDocumento).prop('readonly', true);
            $('#id_reg_direccion_fiscal').val(jsonData.direccion).prop('readonly', true);
            $("#id_reg_razon_social").val(jsonData.razonSocial).prop('readonly', true);
            $("#id_reg_condicion_ruc").val(jsonData.condicion).prop('readonly', true);
            $("#id_reg_estado_ruc").val(jsonData.estado).prop('readonly', true);

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
                title: "Se encontraron coincidencias"
            });
        },
        error: function (xhr, status, error) {
            console.error("Error al obtener datos de la api", error);
            $('#id_msg_error_api_dni').css('display', 'block');
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
                title: "Verifica los datos del Documento"
            });
        }
    })
})

function limpiarFormularioRegistro() {
    $("#id_reg_cod_prod").val("")
    $("#id_reg_sto_prod").val("")
    $("#id_reg_pre_prod").val("")
    $("#id_reg_tipo_documento").val("")
    $("#id_reg_nro_doc_prod").val("")
    $("#id_reg_des_prod").val("")
    $("#id_reg_catalogo").val("")
    $("#id_reg_data_catalogo").val("")

}

$("#id_btn_reg_prov").click(function () {
//
    //$('#id_form_registra').bootstrapValidator('validate');
    //var validator = $('#id_form_registra').data('bootstrapValidator');
    //validator.validate();
    //if (validator.isValid()) {
    $.ajax({
        type: "POST",
        url: "insertProveedor",
        data: $('#id_form_reg_prov').serialize(),
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
                $('#id_div_modal_reg_prov').modal("hide");
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

$("#id_btn_act_prov").click(function () {
    //	var validator = $('#id_form_actualiza').data('bootstrapValidator');
    //	validator.validate();
    //	if (validator.isValid()) {
    $.ajax({
        type: "PUT",
        url: "actualizarProveedor",
        data: $('#id_form_act_prov').serialize(),
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
                $('#id_div_modal_act_prov').modal("hide");
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
    $.getJSON("listarProveedorActivoTrue", {
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
                    title: data.MSG_EMPTY
                });
            } else {
                agregarGrilla(data);
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
                    title: "Se encontraron coincidencias"
                });
            }
        });
}

function buscarPorFiltrosGestionProductos() {
    var ruc = $("#id_txt_ruc").val();
    var razon_social = $("#id_txt_raz_soc").val();
    $.getJSON("buscarPorGestionProveedor", {
        "ruc": ruc,
        "razon_social": razon_social
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
                title: data.MSG_EMPTY
            });
        } else {
            agregarGrilla(data.LIST);
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
                title: "Se encontraron coincidencias"
            });
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
                        data: "id_prov"
                    },
                    {
                        data: "ruc"
                    },
                    {
                        data: "razon_social"
                    },
                    {
                        data: "direccion_fiscal"
                    },
                    {
                        data: "condicion_ruc"
                    },
                    {
                        data: "estado_ruc"
                    },
                    {
                        data: "tipo_contacto"
                    },
                    {
                        data: "nombre_contacto"
                    },
                    {
                        data: "telefono_contacto"
                    },
                    {
                        data: "email_contacto"
                    },
                    {
                        data: function (row, type, val,
                                        meta) {
                            var salida = '<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''
                                + row.id_prov
                                + '\',\''
                                + row.ruc
                                + '\',\''
                                + row.razon_social
                                + '\',\''
                                + row.direccion_fiscal
                                + '\',\''
                                + row.condicion_ruc
                                + '\',\''
                                + row.estado_ruc
                                + '\',\''
                                + row.tipo_contacto
                                + '\',\''
                                + row.nombre_contacto
                                + '\',\''
                                + row.telefono_contacto
                                + '\',\''
                                + row.email_contacto
                                + '\')">Editar</button>';
                            return salida;
                        },
                        className: 'text-center'
                    },
                    {
                        data: function (row, type, val,
                                        meta) {
                            var salida = '<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\''
                                + row.id_prov
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

function editar(id_prov, ruc, razon_social, direccion_fiscal, condicion_ruc,
                estado_ruc, tipo_contacto, nombre_contacto, telefono_contacto, email_contacto) {
    $('#id_act_id_prov').val(id_prov).prop('readonly', true);
    $('#id_act_ruc').val(ruc).prop('readonly', true);
    $('#id_act_razon_social').val(razon_social).prop('readonly', true);
    $('#id_act_direccion_fiscal').val(direccion_fiscal).prop('readonly', true);
    $('#id_act_condicion_ruc').val(condicion_ruc).prop('readonly', true);
    $('#id_act_estado_ruc').val(estado_ruc).prop('readonly', true);
    $('#id_act_tipo_contacto').val(tipo_contacto);
    $('#id_act_nombre_contacto').val(nombre_contacto);
    $('#id_act_telefono_prov').val(telefono_contacto);
    $('#id_act_email_prov').val(email_contacto);

    $('#id_div_modal_act_prov').modal("show");

}

function accionEliminar(id_prov) {
    $.ajax({
        type: "POST",
        url: "cambiarEstadoProveedorCrud",
        data: {
            "id_prov": id_prov
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
