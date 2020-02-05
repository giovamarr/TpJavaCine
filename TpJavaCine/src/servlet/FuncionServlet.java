package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Funcion;
import entities.Pelicula;
import entities.Sala;
import logic.FuncionController;
import logic.PeliculaController;
import logic.SalaController;

/**
 * Servlet implementation class FuncionServlet
 */
@WebServlet("/FuncionServlet")
public class FuncionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String opcion = request.getParameter("opcion");
		int nrofuncion = Integer.parseInt(request.getParameter("nrofuncion"));

			if (opcion.equals("Guardar")) {
				
				 Funcion func=new Funcion();
				 
				
				FuncionController sCon = new FuncionController();
				
				PeliculaController ConPeli = new PeliculaController();
		        
				Pelicula peli = ConPeli.GetOne(Integer.parseInt(request.getParameter("codpeli")));
						
				SalaController ConSala = new SalaController();
		        
		        Sala sala = ConSala.GetOne(Integer.parseInt(request.getParameter("nrosala")));		
						
		        if((peli!=null) && (sala!=null) && (sCon.GetOne(nrofuncion)== null)) {
				

		        	/*func.setDiaFuncion(request.getParameter("diafuncion"));
	 			func.setHoraFuncion(request.getParameter("horafuncion"));*/
	 			
	 			func.setId_codPelicula(peli.getCodPelicula());
	 			func.setId_nrosala(sala.getNroSala());
	 			func.setIdFuncion(nrofuncion);
	 			
	 			sCon.Insert(func);
		
		        }				response.sendRedirect("menu.jsp"); 
			
		 		
			}
			
			
					
			
			else if (opcion.equals("modificar")){
				
				FuncionController sCon = new FuncionController();
		        
				Funcion func = sCon.GetOne(nrofuncion);
		    
		 		if(func!=null)
			{
		 			response.sendRedirect("datosFuncion.jsp");
		 			
		 			PeliculaController ConPeli = new PeliculaController();
			        
					Pelicula peli = ConPeli.GetOne(Integer.parseInt(request.getParameter("codpeli")));
							
					SalaController ConSala = new SalaController();
			        
			        Sala sala = ConSala.GetOne(Integer.parseInt(request.getParameter("nrosala")));							
							
			        if((peli!=null) && (sala!=null)) {
		 			
			        	/*func.setDiaFuncion(request.getParameter("diafuncion"));
		 			func.setHoraFuncion(request.getParameter("horafuncion"));*/
		 			
		 			func.setId_codPelicula(peli.getCodPelicula());
		 			func.setId_nrosala(sala.getNroSala());
		 			func.setIdFuncion(nrofuncion);
		 			
		 	
		 			sCon.Update(func);;		}
			}	
				
			} 
			
			
			
			
			
				else if (opcion.equals("borrar")) 
					{
					FuncionController sCon = new FuncionController();
			        
					Funcion func = sCon.GetOne(nrofuncion);
			        if(func!=null)
			        {
			        	sCon.Delete(func);
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
