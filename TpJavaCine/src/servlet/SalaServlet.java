package servlet;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import entities.Sala;
//import entities.Usuario;
import logic.SalaController;

/**
 * Servlet implementation class SalaServlet
 */
@WebServlet("/SalaServlet")
public class SalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		int nroSala = Integer.parseInt(request.getParameter("nroSala"));

		response.sendRedirect("index.jsp");
			if (opcion.equals("guardar")) {
				response.sendRedirect("index.jsp");
				SalaController sCon = new SalaController();
				if(sCon.GetOne(nroSala)== null) {
					
			// crear sala
					  sCon.setSala(nroSala);
					  response.sendRedirect("index.jsp");
				}		        
		    
		 		response.sendRedirect("menu.jsp");
		 		
			}
			
			
			
	/*		
			
			else if (opcion.equals("modificar")){
				
				SalaController sCon = new SalaController();
		        
		        Sala sala = sCon.GetOne(nroSala);
		    
		 		if(sala!=null)
			{
		 			response.sendRedirect("datosSala.jsp");
		 			
		 			sala.setEstadoSala(Integer.parseInt(request.getParameter("estadoSala")));
		 	sCon.Insert(sala);		
			}	
				
			} 
			
			
			
			
			
				else if (opcion.equals("borrar")) //poner sala en mantenimiento
					{
					SalaController sCon = new SalaController();
			        
			        Sala sala = sCon.GetOne(nroSala);
			        if(sala!=null)
			        {
			        	sCon.SalaenMantenimiento(sala);
			}
			        
				}*/
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		//doGet(request, response);
	}

}
