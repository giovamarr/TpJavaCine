package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Reserva;
import entities.Sala;
import logic.ReservaController;
import logic.SalaController;

/**
 * Servlet implementation class Devolucion
 */
@WebServlet("/Devolucion")
public class Devolucion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Devolucion() {
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
			out.println(link);
			// out.println("<a href=\"views/sala/menuSala.jsp\">Volver</a>");

		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ReservaController resCon = new ReservaController();			
		int reserva = Integer.parseInt(request.getParameter("nrores"));
		Reserva res = resCon.GetOne(reserva);
	        if(res!=null)	
	        {
	        	resCon.Delete(res);				        	
	       	response(response,"Reserva Borrada","<a href=\"views/menu.jsp\">Volver</a>");
	        	}
	       
			else {
		
				response(response,"Reserva no Existe","<a href=\"views/devolucion.jsp\">Volver</a>");
			}
	}

}
