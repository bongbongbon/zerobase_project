package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import dao.HistroyDAO;
import dto.DistanceDTO;
import dto.HistoryDTO;


@WebServlet("/HistoryList")
public class HistoryController extends HttpServlet{
	
		HistroyDAO dao = new HistroyDAO();
		
	
	  @Override
	    protected void service(HttpServletRequest request , HttpServletResponse response) throws
	            IOException, HTTPException, ServletException {

		  	
		  List<HistoryDTO> list = dao.HistoryselectAll();
		  		System.out.println(list);
		  		
		  		request.setAttribute("selectAll", list);
	        RequestDispatcher requestDispatcher = request.getRequestDispatcher("historyList.jsp");// 보내야함
	        requestDispatcher.forward(request,response);

	    }
}
