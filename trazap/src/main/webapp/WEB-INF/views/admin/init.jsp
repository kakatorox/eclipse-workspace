<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Dependencias CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!-- Dependencias Jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Dependencias Popper -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <!-- Dependencias bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
        <!--fontawesome-->
        <script src="https://kit.fontawesome.com/b279ed8e94.js" crossorigin="anonymous"></script>   

    <link rel="stylesheet" href="assets/css/Diseno.css">
    <script src="assets/js/trazap.js"></script>
    <title>Administrador</title>
</head>
<body>
    <nav class="menu">
        <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" />
        <label class="menu-open-button" for="menu-open">
            <span class="lines line-1"></span>
            <span class="lines line-2"></span>
            <span class="lines line-3"></span>
        </label>
        <a href="admin/CategoriaProducto" class="tooltipped menu-item blue" title="Categoria Producto"> <i class="fa-solid fa-shopping-basket" ></i></a>
        <a href="admin/Proveedores" class="tooltipped menu-item green" title="Proveedores"> <i class="fa-solid fa-cart-arrow-down" ></i> </a>
        <a href="admin/EstadoTrazabilidad" class="tooltipped menu-item red" title="Estado Trazabilidad"> <i class="fa-solid fa-plane"></i> </a>
        <a href="admin/TipoProducto" class="tooltipped menu-item purple" title="Tipo Producto"> <i class="fa-solid fa-barcode"></i> </a>
        <a href="admin/Bodega" class="tooltipped menu-item orange" title="Bodega"> <i class="fa-solid fa-warehouse" ></i> </a>
        <a href="admin/Usuarios" class="tooltipped menu-item lightblue" title="Usuarios"> <i class="fa-solid fa-user-astronaut" ></i> </a>
    </nav>

</body>
</html>