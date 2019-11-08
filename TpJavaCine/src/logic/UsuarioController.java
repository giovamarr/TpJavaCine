package logic;

import data.DataUsuario;
import entities.Usuario;


public class UsuarioController {

	public Usuario loginUsuario(String email, String pass) 
	{
		DataUsuario dusu = new DataUsuario();
		Usuario usu = new Usuario();
        
        
        if(dusu.validarUsuario(email, pass))
        {
        	usu = dusu.getByEmail(email);
   	        	
        }
        
        
        return usu;

	}
	
	public Usuario getByEmail(String email) 
	{
		DataUsuario dusu = new DataUsuario();
		Usuario usu = new Usuario();
       
        usu = dusu.getByEmail(email);    
        
        return usu;
	}


}


