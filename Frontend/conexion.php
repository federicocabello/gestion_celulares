<?php
include 'estilo.php';
$servername = "localhost";
$database = "gestion_celulares";
$username = "root";
//$username = "root";
$password = "1508";
//$password = "";
$codigo=$_POST['codigo'];
// Crear la conexion
$conn = mysqli_connect($servername, $username, $password, $database);
// Autenticación de la conexión
if (!$conn) {
    die("Servicio suspendido: " . mysqli_connect_error());
};
// Crear consulta SQL
$consulta="SELECT celulares.id, celulares.marca, celulares.modelo, celulares.problema, celulares.ingreso, celulares.monto, celulares.entrega, clientes.dni, clientes.nombre, tecnicos.nombre AS nombre_tecnico, estados.estado FROM celulares JOIN clientes ON clientes.id=celulares.cliente JOIN tecnicos ON tecnicos.id=celulares.tecnico JOIN estados ON estados.id=celulares.estado WHERE celulares.id = $codigo;";
$resultado=mysqli_query($conn,$consulta);
$filas=mysqli_fetch_array($resultado);
//$valoresarray=intval(count($filas));
//$valoresarray=count($filas);
if($codigo>=1){
if(is_array($filas)){
    $i=0;
while($i<1){
    ?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Barlow+Semi+Condensed:wght@500&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="iconosistemaok.png">
    <title>Gestión de dispositivos | Estado del dispositivo</title>
</head>
<body>
<div class="tituloconexion">Seguimiento de estado del dispositivo N°: <?php echo $filas['registro']?></div>
<br>
<div class="div1">
    <table>
            <tr>
                <th>Registro</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Problema</th>
                <th>Fecha de ingreso</th>
            </tr>
            <tr>
                <td><?php echo $filas['id'] ?></td>
                <td><?php echo $filas['marca'] ?></td>
                <td><?php echo $filas['modelo'] ?></td>
                <td><?php echo $filas['problema'] ?></td>
                <td><?php echo $filas['ingreso'] ?></td>
            </tr>
            <tr>
                <th>ID del estado del dispositivo</th>
                <th>Descripción</th>
                <th>Monto</th>
                <th>Fecha de entrega</th>
            </tr>
            <tr>
                <td><?php echo $filas['estado'] ?></td>
                <td><?php echo $filas['monto'] ?></td>
                <td><?php echo $filas['entrega'] ?></td>
            </tr>
            <tr>
                <th>DNI del cliente</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
            <tr>
                <td><?php echo $filas['dni'] ?></td>
                <td><?php echo $filas['nombre'] ?></td>
            </tr>
            <tr>
                <th>ID del técnico a cargo</th>
            </tr>
            <tr>
                <td><?php echo $filas['nombre_tecnico'] ?></td>
            </tr>
    </table>
</div>
<?php
$i++;
}
}else{
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Barlow+Semi+Condensed:wght@500&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="iconosistemano.png">
    <title>Gestión de dispositivos | Estado del dispositivo</title>
    </head>
    <style>
    .logodeno {
    margin: 25px auto;
    padding: 100px 50px;
    border: 2px solid black;
    border-radius: 10px;
    font-size: 35px;
    box-shadow: 5px 5px 5px black;
    background-image: url(gifdeno.gif);
    background-size: cover;
    background-position: center;
    background-color: white;
    width: 200px;
    height: 100px;
    display: flex;
    }
    .codigonoencontrado{
        text-align: center;
        margin: 25px auto;
        font-size: 35px;
        color: red;
        text-decoration: underline red;
    }
    </style>
    <body>
    <div class="tituloconexion">Seguimiento de estado del dispositivo N°: <?php echo $codigo?></div>
    <div class="codigonoencontrado">EL CÓDIGO DE SEGUIMIENTO INGRESADO NO SE ENCUENTRA EN EL SISTEMA.</div>
    <div class="logodeno"></div>
    </body>
    </html>
    <?php
}
}else{
     ?>
     <script>
        window.location.replace("index.html");
     </script>
     <?php
     
}
?>
<?php
mysqli_close($conn);
?>
<br>
<footer><a href="contacto.html">Contacto</a></footer>
<br>
<footer><a href="index.html">Volver a la página principal</a></footer>
</body>
</html>