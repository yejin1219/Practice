package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = null;
		try {
			vo = dao.findByPasswordMember(password);
			
			request.setAttribute("vo", vo);
		} catch (SQLException e) {}
		
		if(null!=vo) {
			request.getRequestDispatcher("Search.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Fail.jsp").forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
