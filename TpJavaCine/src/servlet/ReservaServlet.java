package servlet;

import java.io.IOException;
import java.io.PrintWriter;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.PeliculaController;
//import entities.Usuario;
import entities.Pelicula;
//import logic.UsuarioController;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
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
		out.println(link);
		// out.println("<a href=\"views/sala/menuSala.jsp\">Volver</a>");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String pelicula = request.getParameter("pelicula");
		//String fecha = request.getParameter("fecha");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String pelicula = request.getParameter("pelicula");
		
		PeliculaController pCon = new PeliculaController();
        Pelicula pel = pCon.GetOne(pelicula);
        
		if (pel.getNombrePelicula() !=null) {
			
			//MOSTRAR LAS FUNCIONES CON EL METODO GETALL EN FUNCIONCONTROLLER EN muestraPeliculas.jsp
			
		} else 
   	 { 
	
			response(response,"No existe pelicula o no hay funciones hoy","<a href=\"views/venta.jsp\">Volver</a>");
 	}
   	 }	
		
		// SimpleDateFormat fo = new SimpleDateFormat("yyyy/MM/dd");
		// Date fecha = fo.parse(request.getParameter("fecha"));  
		//    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
		
		
		
		
	}


