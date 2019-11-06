package servlet;

import logic.UsuarioController;
import entities.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		HttpSession sesion = request.getSession();

		

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        UsuarioController usuCon = new UsuarioController();
       
        Usuario usu = usuCon.loginUsuario(email, pass);
    	
    	if(usu.getEmail()!=null) //debe andar mal este get o el login pero llega hasta el servlet y fuera de este if si lo redirecciona
    	{
        
    	sesion.setAttribute("usuarioActual", usu);
    	
    	response.sendRedirect("index.jsp");	
        	
		}
    	 else 
    	 { 
 		 request.getSession().setAttribute("errorLogin", "Usuario y/o contraseña incorrecta");	
		 
 		 response.sendRedirect("index.jsp");	
    	 }	
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
	}

}
