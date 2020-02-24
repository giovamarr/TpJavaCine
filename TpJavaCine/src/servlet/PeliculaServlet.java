package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import entities.Sala;
import logic.PeliculaController;
/**
 * Servlet implementation class PeliculaServlet
 */
@WebServlet("/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeliculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		 String opcion = request.getParameter("opcion");
		int codPelicula = Integer.parseInt(request.getParameter("codPelicula"));
		String descripcionPelicula = request.getParameter("descripcionPelicula");
		String nombrePelicula = request.getParameter("nombrePelicula");
		PeliculaController peliCon = new PeliculaController();
		
		switch(opcion) {
		case("guardar"):		
		if(peliCon.GetOne(codPelicula)== null)
		{
			
		 peliCon.setPelicula(codPelicula, descripcionPelicula, nombrePelicula);
		 response(response,"Pelicula Cargada Correctamente","<a href=\"views/pelicula/menuPelicula.jsp\">Volver</a>");
		 
		}
		else { 
			response(response,"Ya exite una pelicula con ese codigo","<a href=\"views/pelicula/menuPelicula.jsp\">Volver</a>");}
		 break;
	
		case("modificar"):
			
			
		break;
		case("borrar"):
			
			Pelicula pel = peliCon.GetOne(codPelicula);
        if(pel!=null)	
        {
        	peliCon.Delete(pel);			      
        	response(response,"Pelicula Borrada","<a href=\"views/pelicula/menuPelicula.jsp\">Volver</a>");
        	}
        
		else {
	
			response(response,"No exite la Pelicula","<a href=\"views/pelicula/borrarPelicula.jsp\">Volver</a>");
		}
	
		break;

		}
		

}
	}
