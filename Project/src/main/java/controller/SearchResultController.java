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

import dao.DAO;
import dao.HistroyDAO;
import dto.DistanceDTO;


@WebServlet("/SearchResult")
public class SearchResultController extends HttpServlet {

    private static final long serialVersionUID = -5080455709742675731L;
	private final DAO dao;    // 메모리에 한번에올려놓고 사용하려고
    private final HistroyDAO historyDAO;

    public SearchResultController(){
        this.dao = new DAO();
        this.historyDAO = new HistroyDAO();
    }

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response) throws
            IOException, HTTPException, ServletException {

     


        Double latDouble = Double.valueOf( request.getParameter("latitude-input"));
        Double lntDouble = Double.valueOf( request.getParameter("longitude-input"));

        System.out.println(latDouble);
        System.out.println(lntDouble);



       List<DistanceDTO> searchList =  dao.nearSearch(latDouble,lntDouble); // 20개가져오고
        System.out.println(searchList);


        historyDAO.saveHistory(latDouble, lntDouble);

        // jsp에서 사용
        request.setAttribute("searchList",searchList);// 데이터담기

        /**
         * 포워드
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");// 보내야함
        requestDispatcher.forward(request,response);




    }




}