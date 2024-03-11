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

import api.ApiJsonService;

@WebServlet("/TotalCountController")
public class TotalCountController extends HttpServlet {
	
	ApiJsonService service = new ApiJsonService();
	
	
	   @Override
	    protected void service(HttpServletRequest request, HttpServletResponse respons) throws
	            IOException, HTTPException {

		   ApiJsonService service = new ApiJsonService();
		   
	        try {




	            request.setAttribute("totalCount",service.getTotalCount());// 데이터담기

	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("totalCount.jsp");// 보내야함
	            requestDispatcher.forward(request,respons);

	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }


}
}
