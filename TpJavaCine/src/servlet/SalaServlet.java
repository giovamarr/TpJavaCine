package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Sala;
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

			if (opcion.equals("Guardar")) {
				
				SalaController sCon = new SalaController();
		        
		        Sala sala = sCon.setSala(nroSala);
		    
		 		response.sendRedirect("index.jsp");
	}
			
			else if (opcion.equals("modificar")){
				
				SalaController sCon = new SalaController();
		        
		        Sala sala = sCon.GetOne(nroSala);
		    
		 		response.sendRedirect("datosSala.jsp");
				
				
			} 
			
				else if (opcion.equals("borrar")) {
					SalaController sCon = new SalaController();
			        
			        Sala sala = sCon.GetOne(nroSala);
			        if(sala!=null)
			        {
			        	sCon.SalaenMantenimiento(sala);
			}
			        
				}
			
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
