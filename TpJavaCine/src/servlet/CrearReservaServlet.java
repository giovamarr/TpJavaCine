package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataFuncion;
import entities.Butaca;
import entities.Funcion;
import entities.Reserva;
import logic.ButacaController;
import logic.FuncionController;
import logic.ReservaController;



/**
 * Servlet implementation class CrearReservaServlet
 */
@WebServlet("/CrearReservaServlet")
public class CrearReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//FALTA: agregar que se pueda hacer x cantidad
		//		 fechahora y idcliente
		
		int idfunc = Integer.parseInt(request.getParameter("idfunc"));
		//int cant = Integer.parseInt(request.getParameter("cantentradas"));

		FuncionController fCon = new FuncionController();
		Funcion func = fCon.GetOne(idfunc);
		if(func != null ) {
			ButacaController bCon = new ButacaController();
			ArrayList<Butaca> butacas = bCon.ButacasVacias();
			
			if(butacas.size() > 0) {
				try {
					Butaca b = butacas.get(0);
					bCon.RegistraOcupado(b.getNroButaca(), func.getId_nrosala());
					Reserva reserva = new Reserva();
					reserva.setIdbutaca(b.getNroButaca());
					reserva.setIdFuncion(func.getIdFuncion());
					//reserva.setFechaHoraCompra();
					//reserva.setId_cliente();
					ReservaController rCon = new ReservaController();
					rCon.Insert(reserva);
					response(response,"Reserva generada correctamente","<a href=\"views/venta.jsp\">Volver</a>");
				}
				catch(Exception e) {
					response(response,"Ha ocurrido un error al generar la reserva","<a href=\"views/venta.jsp\">Volver</a>");
				}		
			}else {
				response(response,"No hay esa cantidad de butacas disponible","<a href=\"views/venta.jsp\">Volver</a>");
			}			
		}else {
			response(response,"No existe esa funcion","<a href=\"views/venta.jsp\">Volver</a>");
		}	
	}

}
