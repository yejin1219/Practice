package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;


public class EntrancServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EntrancServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String nickName = request.getParameter("nickname");
	String gender =  request.getParameter("gender");
	
	MemberVO vo = new MemberVO(id, password, name, nickName, gender);
	System.out.println("객체 생성,,");
	 
	MemberDAO dao = new MemberDAO();
	try {
		dao.insertMember(vo);
	} catch (SQLException e) {}
	
	
	response.sendRedirect("View");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
