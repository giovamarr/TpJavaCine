package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		out.println(link);}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String opcion = request.getParameter("opcion");
		int nrofuncion = Integer.parseInt(request.getParameter("nrofuncion"));
		FuncionController sCon = new FuncionController();
		PeliculaController ConPeli = new PeliculaController();
		SalaController ConSala = new SalaController();
		
		switch(opcion) {		
		case("guardar"):// falla el date
				
						
				 Funcion func=new Funcion();
				Pelicula peli = ConPeli.GetOne(Integer.parseInt(request.getParameter("codpeli")));
						
		        Sala sala = ConSala.GetOne(Integer.parseInt(request.getParameter("nrosala")));		
						
		        if((peli!=null) && (sala!=null) && (sCon.GetOne(nrofuncion)== null))
		        {		
		        //func.setDiaFuncion(request.getParameter("diafuncion"));
	 			//func.setHoraFuncion(request.getParameter("horafuncion"));	 			
	 			func.setId_codPelicula(peli.getCodPelicula());
	 			func.setId_nrosala(sala.getNroSala());
	 			func.setIdFuncion(nrofuncion);	 			
	 			sCon.Insert(func);
	 			response(response,"Funcion Creada","<a href=\"views/funcion/menufuncion.jsp\">Volver</a>");
		        }else {
		        	response(response,"Funcion ya Existe","<a href=\"views/funcion/crearfuncion.jsp\">Volver</a>");
		        }			
			
		 	
			
			
			break;
					
			
		case("modificar")://no anda
				
				Funcion funcion = sCon.GetOne(nrofuncion);
		    
		 		if(funcion!=null)
			{
		 			response.sendRedirect("datosFuncion.jsp");		
			        
					Pelicula pelis = ConPeli.GetOne(Integer.parseInt(request.getParameter("codpeli")));							
					
			        Sala salas = ConSala.GetOne(Integer.parseInt(request.getParameter("nrosala")));							
							
			        if((pelis!=null) && (salas!=null)) {
		 			
			        	/*func.setDiaFuncion(request.getParameter("diafuncion"));
		 			func.setHoraFuncion(request.getParameter("horafuncion"));*/
		 			
			        	funcion.setId_codPelicula(pelis.getCodPelicula());
			        	funcion.setId_nrosala(salas.getNroSala());
			        	funcion.setIdFuncion(nrofuncion);
		 			
		 	
		 			sCon.Update(funcion);		}
			}	
				
		 		break;
		case("borrar"):									
			        
					Funcion funci = sCon.GetOne(nrofuncion);
			        if(funci!=null)
			        {
			        	sCon.Delete(funci);
			        	response(response,"Funcion Borrada","<a href=\"views/funcion/menufuncion.jsp\">Volver</a>");
		        	}
		        
				else {
			
					response(response,"No exite la Funcion","<a href=\"views/funcion/borrarFuncion.jsp\">Volver</a>");
				}
			        
			        break;
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
