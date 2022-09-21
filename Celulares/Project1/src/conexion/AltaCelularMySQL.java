package conexion;


import java.awt.Panel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.LocalTime;

import java.util.Properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JOptionPane;


public class AltaCelularMySQL {
    public AltaCelularMySQL() {
        super();
        }
        private String ultimoMensajeMySQL="";

        public String altaCelular(String marca, String modelo, String problema, String monto, String dia, String mes, String ano, String dni, int tecnico, int estado) {
        String sql = "INSERT INTO celulares (marca, modelo, problema, fechaingreso, dni_cliente, idtecnico, estado, monto, fechaentrega) VALUES ('"+marca+"','"+modelo+"','"+problema+"',current_date(),'"+dni+"',"+tecnico+","+estado+",'"+monto+"',"+ano+mes+dia+");";
        try {
        Statement st = Conexion.getConexion().createStatement();
        st.executeUpdate(sql);

        ResultSet registro = st.executeQuery("SELECT celulares.cliente.email_cliente,celulares.cliente.nombre_cliente,celulares.cliente.apellido_cliente FROM celulares.cliente WHERE dni="+dni+";");
            if(registro.next()){
                Properties propiedad = new Properties();
                propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
                propiedad.setProperty("mail.smtp.starttls.enable", "true");
                propiedad.setProperty("mail.smtp.port", "587");
                
                Session sesion = Session.getDefaultInstance(propiedad);
                    
                String correoEnvia = "fede.cabello.98@gmail.com";
                String contrasena = "ulkliyonrdudvpga";
                String receptor = registro.getString("email_cliente");
                String asunto = "INGRESO DE UN DISPOSITIVO AL SISTEMA.";
                
                String nombredecliente = registro.getString("nombre_cliente");
                String apellidodecliente = registro.getString("apellido_cliente");
                String mensaje = "Bienvenid@ "+apellidodecliente+", "+nombredecliente+" al sistema de gestión de dispositivos.\nSu dispositivo ha sido ingresado al sistema con éxito el día "+LocalDate.now()+" a la hora "+LocalTime.now()+" con los siguientes datos:\nDNI del cliente: "+dni+".\nDISPOSITIVO:\nMarca: "+marca+".\nModelo: "+modelo+".\nCosto de reparación aproximado: $"+monto+".\nFecha de entrega estimada del dispositivo (puede variar): "+dia+"/"+mes+"/"+ano+".";
                    
                    MimeMessage mail = new MimeMessage(sesion);
                    try {
                        mail.setFrom(new InternetAddress (correoEnvia));
                        mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
                        mail.setSubject(asunto);
                        mail.setText(mensaje);
                        
                        Transport transportar = sesion.getTransport("smtp");
                        transportar.connect(correoEnvia,contrasena);
                        transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
                        transportar.close();
    
                        //JOptionPane.showMessageDialog(null, "Listo, revise su correo");                   
                        
                    } catch (AddressException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MessagingException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
        ultimoMensajeMySQL="Registro guardado.\nSe agregó con éxito un dispositivo al cliente DNI: "+dni+".";
        } catch (SQLException e) {
        ultimoMensajeMySQL="Error: " + e.getMessage();
        }
        return ultimoMensajeMySQL;
        }
        }
