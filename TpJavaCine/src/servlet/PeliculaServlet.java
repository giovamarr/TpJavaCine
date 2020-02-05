package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Pelicula;
import entities.Sala;
import logic.PeliculaController;
import logic.SalaController;

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
		
		String opcion = request.getParameter("opcion");
		int nropeli = Integer.parseInt(request.getParameter("nropeli"));

			if (opcion.equals("Guardar")) {
		Pelicula peli=new Pelicula();
		peli.setCodPelicula(nropeli);
		peli.setDescPelicula(request.getParameter("descpeli"));
		peli.setNombrePelicula(request.getParameter("nombrepeli"));
		
		PeliculaController sCon = new PeliculaController();
				
				if(sCon.GetOne(nropeli)== null) {
		        
		        sCon.AgregarPeli(peli);
				}		        
		    
		 		response.sendRedirect("menu.jsp");
		 		
			}
			
			
			
			
			
			else if (opcion.equals("modificar")){
				
				PeliculaController sCon = new PeliculaController();
		        
				Pelicula peli = sCon.GetOne(nropeli);
		    
		 		if(peli!=null)
			{
		 			response.sendRedirect("datosPelicula.jsp");
		 			
		 			peli.setDescPelicula(request.getParameter("descpeli"));
		 			peli.setNombrePelicula(request.getParameter("nombrepeli"));;	
		 	
		 			sCon.Update(peli);;		
			}	
				
			} 
			
			
			
			
			
				else if (opcion.equals("borrar")) //poner sala en mantenimiento
					{
					PeliculaController sCon = new PeliculaController();
			        
					Pelicula peli = sCon.GetOne(nropeli);
			        if(peli!=null)
			        {
			        	sCon.Delete(peli);
			}
			        
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
