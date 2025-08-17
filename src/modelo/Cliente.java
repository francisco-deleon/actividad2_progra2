/*	
 *  Actividad 2 del curso Programación II
 *	
 *  Universidad Mariano Gálvez de Guatemala
 *	
 *  Autor:
 *  Francisco Antonio De León Natareno
*/

package modelo;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    public DefaultTableModel leer() {
      DefaultTableModel tabla = new DefaultTableModel();
      
      try {
        cn = new Conexion();
        cn.abrir_conexion();
        
        String campos = "id_cliente AS id, nit, nombres, apellidos, direccion, telefono, fecha_nacimiento";
        String query = "SELECT " + campos + " FROM clientes;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        
        String encabezados[] = {"Id", "Nit", "Nombres", "Apellidos", "Direccion", "Telefono", "Nacimiento"};
        tabla.setColumnIdentifiers(encabezados);
        
        String datos[] = new String[7];
        
        while(consulta.next()) {
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("nit");
          datos[2] = consulta.getString("nombres");
          datos[3] = consulta.getString("apellidos");
          datos[4] = consulta.getString("direccion");
          datos[5] = consulta.getString("telefono");
          datos[6] = consulta.getString("fecha_nacimiento");
          tabla.addRow(datos);
        }
        
        cn.cerrar_conexion();
      }
      catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
      }
      
      return tabla;
    }
}
