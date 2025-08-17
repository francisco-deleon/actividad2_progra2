/*	
 *  Actividad 2 del curso Programación II
 *	
 *  Universidad Mariano Gálvez de Guatemala
 *	
 *  Autor:
 *  Francisco Antonio De León Natareno
*/

package modelo;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Cliente extends Persona {
    private String nit;
    Conexion cn;

    public Cliente() {}

    public Cliente(String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    @Override
    public void agregar() {
      try {
        PreparedStatement parametro;
        cn = new Conexion();
        
        String campos = "(nit, nombres, apellidos, direccion, telefono, fecha_nacimiento)";
        String query = "INSERT INTO clientes" + campos + " VALUES(?, ?, ?, ?, ?, ?);";
        
        cn.abrir_conexion();
        parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
        parametro.setString(1, this.getNit());
        parametro.setString(2, this.getNombres());
        parametro.setString(3, this.getApellidos());
        parametro.setString(4, this.getDireccion());
        parametro.setString(5, this.getTelefono());
        parametro.setString(6, this.getFecha_nacimiento());
        
        int ejecutar = parametro.executeUpdate();
        cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null, Integer.toString(ejecutar) + " Registro Ingresado", "Agregar", JOptionPane.INFORMATION_MESSAGE);
      }
      catch (Exception ex) {
        System.out.println("Error..." + ex.getMessage());
      }
    }
}
