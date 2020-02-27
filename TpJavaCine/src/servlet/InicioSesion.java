package servlet;

import logic.UsuarioController;
import entities.Usuario;

import java.io.IOException;
import java.io.PrintWriter;

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
    private void response(HttpServletResponse resp, String msg, String link)// para enviar mensajes
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\""
				+ " \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; " + "charset=ISO-8859-1\">");
		out.println("<title>Login result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<H3>" + msg + "</H3>");// <H2> Texto de prueba (H2)</H2>
		out.println("</body>");
		out.println("</html>");
		out.println("<br><br>");
		out.println(link);}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		HttpSession sesion = request.getSession();

		

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        UsuarioController usuCon = new UsuarioController();
       
        Usuario usu = usuCon.loginUsuario(email, pass);
  
 try {
    	if(usu.getEmail()!=null) 
    	{
      
    	sesion.setAttribute("usuarioActual", usu);
    	
    	response.sendRedirect("views/menu.jsp");	
        	
		}
    	 else 
    	 { 
    	
 		 request.getSession().setAttribute("errorLogin", "Usuario y/o contraseï¿½a incorrecta");	
 		
 		 response.sendRedirect("index.jsp");	
    	 }	} catch(Exception e) {response(response,"Usuario o Contraseña Incorrecto","<a href=\"index.jsp\">Volver</a>");}
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	

	
	}

}
