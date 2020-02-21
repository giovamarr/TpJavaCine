package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Pelicula;
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
		int nropeli = Integer.parseInt(request.getParameter("nropeli"));

			if (opcion.equals("Guardar")) {
		Pelicula peli=new Pelicula();
		peli.setCodPelicula(nropeli);
		peli.setDescPelicula(request.getParameter("descripcionPelicula"));
		peli.setNombrePelicula(request.getParameter("nombrePelicula"));
		
		PeliculaController sCon = new PeliculaController();
		 sCon.AgregarPeli(peli);
	
	}

}}
