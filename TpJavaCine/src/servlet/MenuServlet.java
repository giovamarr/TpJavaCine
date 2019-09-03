package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String opcion = request.getParameter("opcion");
		
			if (opcion.equals("funcion")) {
		//RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/.jsp");
			//requestDispatcher.forward(request, response);
				System.out.println("funcion");}
			
			else if (opcion.equals("sala")){
				RequestDispatcher requestDispatcher= request.getRequestDispatcher("/views/menuSala.jsp");
			requestDispatcher.forward(request, response);} 
			
				else if (opcion.equals("pelicula")) {
					System.out.println("pelicula");}
				else if (opcion.equals("butaca")) {
					System.out.println("butaca");
					
				}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
