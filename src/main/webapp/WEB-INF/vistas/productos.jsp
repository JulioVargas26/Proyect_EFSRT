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

<script src="../js/scriptProducto.js"></script>
</body>
</html>