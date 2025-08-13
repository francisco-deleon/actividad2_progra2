/*	
 *  Actividad 2 del curso Programación II
 *	
 *  Universidad Mariano Gálvez de Guatemala
 *	
 *  Autor:
 *  Francisco Antonio De León Natareno
*/

package modelo;

public class Cliente extends Persona {
    private String nit;

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
        System.out.println("Nit: " + this.getNit());
        System.out.println("Nombres: " + this.getNombres());
        System.out.println("Apellidos: " + this.getApellidos());
        System.out.println("Direccion: " + this.getDireccion());
        System.out.println("Telefono: " + this.getTelefono());
        System.out.println("Fecha Nacimiento: " + this.getFecha_nacimiento());
        System.out.println("_______________________________________________");
    }
}
