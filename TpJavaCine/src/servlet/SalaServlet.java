package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.javafx.scene.layout.region.Margins.Converter;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String opcion = request.getParameter("opcion");
		PrintWriter out =response.getWriter();
		SalaController sCon = new SalaController();
		
		int nroSala = Integer.parseInt(request.getParameter("nroSala"));
		switch(opcion) {
		
		case("guardar"):	
				  
				  if(sCon.GetOne(nroSala)== null) {
					
					  sCon.setSala(nroSala);
					//  RequestDispatcher rd= request.getRequestDispatcher("views/sala/menuSala.jsp");	//con esto funciona el msg pero rompe todo					 
					  //rd.include(request, response);		 			 
			 			//out.println("<script type=\"text/javascript\"> var msg = \"Sala cargada Correctamente\"; alert(msg); </script>"); 
			 		//response.sendRedirect("views/sala/menuSala.jsp");	
					  
					  response(response,"Sala Cargada Correctamente","<a href=\"views/sala/menuSala.jsp\">Volver</a>");
				  } else {
					
					  response(response,"Sala ya Existe","<a href=\"views/sala/crearSala.jsp\">Volver</a>");
					 
				  }
				  break;
		case("modificar"):
			
		        Sala sala = sCon.GetOne(nroSala);
		    
		 		if(sala!=null)
		 			{		 	
		 			RequestDispatcher rd= request.getRequestDispatcher("views/sala/datosSala.jsp");
		 			rd.forward(request, response);		 		
		 		//	sala.setEstadoSala(request.getParameter("estadoSala"));		 			
		 			 response(response,"Sala Modificada","<a href=\"views/sala/menuSala.jsp\">Volver</a>");
				}	else {		
				 response(response,"Sala No Existe","<a href=\"views/sala/modificarSala.jsp\">Volver</a>");
	 			
				} break;
		
		case("borrar"):		       
			        Sala sal = sCon.GetOne(nroSala);
			        if(sal!=null)	
			        {
			        	sCon.Delete(sal);			      
			        	response(response,"Sala Borrada","<a href=\"views/sala/menuSala.jsp\">Volver</a>");
			        	}
			       
					else {
				
						response(response,"Sala no Existe","<a href=\"views/sala/borrarSala.jsp\">Volver</a>");
					}
					 break;
				}
		//	}

	// response.getWriter().append("Served at: ").append(request.getContextPath());

}}
