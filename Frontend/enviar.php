<?php

require "PHPMailer/Exception.php";
require "PHPMailer/PHPMailer.php";
require "PHPMailer/SMTP.php";

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

$oMail=new PHPMailer();
$oMail->isSMTP();
$oMail->Host="smtp.gmail.com";
$oMail->Port=587;
$oMail->SMTPSecure="tls";
$oMail->SMTPAuth=true;
$oMail->Usermail="cadpotorneos@gmail.com";
$oMail->Password="Losredondos#123";
$oMail->setFrom("cadpotorneos@gmail.com","CADPO TORNEOS");

$oMail->addAddress("fede.cabello@hotmail.com","Federico");
$oMail->Subject="Prueba";
$oMail->msgHTML("1324657984865");

if(!$oMail->send()){
    echo $oMail->ErrorInfo;
};

/*ini_set("SMTP", "aspmx.l.google.com");
ini_set("sendmail_from", "cadpotorneos@gmail.com");
$destinatario = "fede.cabello@hotmail.com.com"; 
$asunto = "Este mensaje es de prueba"; 
$cuerpo = ' 
<html> 
<head> 
   <title>Prueba de correo</title> 
</head> 
<body> 
<h1>Hola amigos!</h1> 
<p> 
<b>Bienvenidos a mi correo electrónico de prueba</b>. Estoy encantado de tener tantos lectores. Este cuerpo del mensaje es del artículo de envío de mails por PHP. Habría que cambiarlo para poner tu propio cuerpo. Por cierto, cambia también las cabeceras del mensaje. 
</p> 
</body> 
</html> 
'; 

//para el envío en formato HTML 
$headers = "MIME-Version: 1.0\r\n"; 
$headers .= "Content-type: text/html; charset=iso-8859-1\r\n"; 

//dirección del remitente 
$headers .= "From: CADPO TORNEOS <cadpotorneos@gmail.com>\r\n"; 

//dirección de respuesta, si queremos que sea distinta que la del remitente 
$headers .= "Reply-To: cadpotorneos@gmail.com\r\n"; 

//ruta del mensaje desde origen a destino 
$headers .= "Return-path: cadpotorneos@gmail.com\r\n"; 

//direcciones que recibián copia 
$headers .= "Cc: cadpotorneos@gmail.com\r\n"; 

//direcciones que recibirán copia oculta 
$headers .= "Bcc: cadpotorneos@gmail.com\r\n"; 

mail($destinatario,$asunto,$cuerpo,$headers);
/*$name=$_POST['name'];
$mail=$_POST['mail'];
$phone=$_POST['phone'];
$message=$_POST['message'];

$header='From '.$mail." \r\n";
$header="X-Mailer: PHP/".phpversion()." \r\n";
$header="Mime-Version: 1.0 \r\n";
$header="Content-Type text/plain";

$message="Este mensaje fue enviado por ".$name." \r\n";
$message="Su e-mail es: ".$mail." \r\n";
$message="Su telefono de contacto es: ".$phone." \r\n";
$message="Mensaje: ".$_POST['message']." \r\n";
$message="Enviado el: ".date('d/m/Y',time());


$para='fede.cabello.98@gmail.com';
$asunto='Asunto';
mail($para,$asunto,utf8_decode($message),$header);
header("Location:index.html");*/
?>