package logic;

import data.DataUsuario;
import entities.Usuario;


public class UsuarioController {

	public Usuario loginUsuario(String email, String pass) 
	{
		DataUsuario dusu = new DataUsuario();
		Usuario usu = new Usuario();
        usu=null;
        	
        if(dusu.validarUsuario(email, pass))
        {
        	usu = dusu.getByEmail(email);
   	        	
        }
        
        
        return usu;

	}
	
	public void setUsuario(String email, String pass, String apellido, String nombre) {
		
		DataUsuario dusu = new DataUsuario();
		Usuario usu = new Usuario();
    
        
    	usu.setEmail(email);
        usu.setPass(pass);
		usu.setNombre(nombre); 
		usu.setApellido(apellido); 
	
		dusu.IngresarUsuario(usu);
		
		
	}
	
	
	public Usuario getByEmail(String email) 
	{
		DataUsuario dusu = new DataUsuario();
		Usuario usu = new Usuario();
       
        usu = dusu.getByEmail(email);    
        
        return usu;
	}


}


