package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		
			if (opcion.equals("guardar")) {
		
		PeliculaController peliCon = new PeliculaController();
		 peliCon.setPelicula(codPelicula, descripcionPelicula, nombrePelicula);
		 response.sendRedirect("index.jsp");
	
	}

}}
