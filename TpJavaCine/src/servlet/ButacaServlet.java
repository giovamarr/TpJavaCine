package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Butaca;
import logic.ButacaController;

/**
 * Servlet implementation class ButacaServlet
 */
@WebServlet("/ButacaServlet")
public class ButacaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButacaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
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
		int nrosala = Integer.parseInt(request.getParameter("nrosala"));
		int nrobutaca = Integer.parseInt(request.getParameter("nroButaca"));
		int estado = Integer.parseInt(request.getParameter("estado"));
		ButacaController bc = new ButacaController(); 
switch(opcion) {
case("guardar"):
	if(bc.GetOne(nrobutaca, nrosala)==null) {
		bc.Insert(nrobutaca, nrosala);
	}
	
	
	break;
case("modificar"):
	Butaca but = bc.GetOne(nrobutaca, nrosala);
	if (but != null) {
		but.setEstadoButaca(estado);
		but.setId_sala(nrosala);
		but.setNroButaca(nrobutaca);
		bc.upd(but);
			 response(response,"Butaca Modificada","<a href=\"views/butaca/menuButaca.jsp\">Volver</a>");
			}	
			else {		
	 response(response,"Butaca No Existe","<a href=\"views/butaca/modificarButaca.jsp\">Volver</a>");
		
	}
	break;
case("borrar"):
	
	break;
	}

}
	
}
