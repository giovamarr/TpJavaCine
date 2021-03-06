package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;
import logic.UsuarioController;

/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	//HttpSession sesion = request.getSession();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        
        UsuarioController usuCon = new UsuarioController();
        try {
        			Usuario us = usuCon.getByEmail(email);
        			if (us == null) {
        			usuCon.setUsuario(email,pass, apellido,nombre);
        	        response(response,"Usuario Creado","<a href=\"index.jsp\">Volver</a>");
        			}
        			else {
            	        response(response,"Usuario ya existente","<a href=\"registro.jsp\">Volver</a>");
        			}
        }
	  catch(Exception e) {response(response,"Error al crear usuario","<a href=\"index.jsp\">Volver</a>");}


        
      //HAY QUE VALIDAR QUE EL MAIL INGRESADO NO ESTE REGISTRADO YA
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
