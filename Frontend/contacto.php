<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'Exception.php';
require 'PHPMailer.php';
require 'SMTP.php';

$nombre=strtolower($_POST['name']);
$nombre2=ucfirst($nombre);
$correo=strtolower($_POST['mail']);
$celu=$_POST['subject'];
$mensaje=strtolower($_POST['message']);
$mensaje2=ucfirst($mensaje);
$nombre3=strtoupper($nombre);
$dni=$_POST['dni'];

//Create an instance; passing `true` enables exceptions
$mail = new PHPMailer(true);

try {
    //Server settings
    $mail->SMTPDebug = 0;//SMTP::DEBUG_SERVER;                      //Enable verbose debug output
    $mail->isSMTP();                                            //Send using SMTP
    $mail->Host       = 'smtp.gmail.com';                     //Set the SMTP server to send through
    $mail->SMTPAuth   = true;                                   //Enable SMTP authentication
    $mail->Username   = 'fede.cabello.98@gmail.com';                     //SMTP username
    $mail->Password   = 'ulkliyonrdudvpga';                               //SMTP password
    $mail->SMTPSecure = 'tls';//PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
    $mail->Port       = 587;//465;                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`

    // Remitente
    $mail->setFrom('fede.cabello.98@gmail.com', 'GESTIÓN DE DISPOSITIVOS - FORMULARIO DE CONTACTO');
    // Destinatario, opcionalmente también se puede especificar el nombre
    $mail->addAddress('fede.cabello.98@gmail.com');
    // Copia
    $mail->addCC($correo,$nombre3);
    // Copia oculta
    //$mail->addBCC('info@example.com', 'name');

    $mail->CharSet = 'UTF-8';
    $mail->Encoding = 'base64';

    $mail->isHTML(true);
    // Asunto
    $mail->Subject = 'CONTACTO - GESTIÓN DE DISPOSITIVOS';
    // Contenido HTML
    $mail->Body = 'Gracias '.$nombre2.' por contactarte! Nos pondremos en contacto pronto. Los datos de contacto son:'."<br>".'DNI: '.$dni."<br>".'Correo electrónico: '.$correo."<br>".'Teléfono: '.$celu."<br>"."<b>El mensaje es:</b>"."<br>".$mensaje2.'.'."<br>"."<br>".'Nos pondremos en contacto. Muchas gracias.';
    //$mail->AltBody = 'El texto como elemento de texto simple';

    //Recipients
    //$mail->setFrom('cadpotorneos@gmail.com', 'Mailer');
    //$mail->addAddress('fede.cabello@hotmail.com', 'Joe User');     //Add a recipient
    //$mail->addAddress('ellen@example.com');               //Name is optional
    //$mail->addReplyTo('info@example.com', 'Information');
    //$mail->addCC('cc@example.com');
    //$mail->addBCC('bcc@example.com');

    //Attachments
    //$mail->addAttachment('/var/tmp/file.tar.gz');         //Add attachments
    //$mail->addAttachment('/tmp/image.jpg', 'new.jpg');    //Optional name
    $mail->send();
    ?>
    <script>
        alert("Gracias <?php echo $nombre3;?> tu mensaje fue enviado con éxito. Recibirás una copia al correo <?php echo $correo;?>");
        window.location.href="index.html";
    </script>
    <?php
    /*echo '<script type="text/javascript">
    var nombre3 = document.getElementById(name);
    alert("Gracias "+nombre3+"! El mensaje fue enviado con éxito.");
    window.location.href="index.html";
    </script>';*/
} catch (Exception $e) {
    /*echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
    echo '<script type="text/javascript">
    alert("El mensaje NO fue enviado. Error: ".{$mail->ErrorInfo});
    </script>';*/
    ?>
    <script>
        alert("El mensaje NO fue enviado. Por favor reintente. Error: <?php echo $mail->ErrorInfo;?>");
        //window.location.href="contacto.html";
        history.back();
    </script>
    <?php
}
?>