package com.springbook.biz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


/*** Servlet implementation class DispatcherServelet */
public class DispatcherServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*** @see HttpServlet#HttpServlet()     */
    public DispatcherServelet() {
        super();
    }

    /**@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user		=	userDAO.getUser(vo);

			if(user != null){
				response.sendRedirect("getBoardList.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}

		}else if (path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
		}else if (path.equals("/insertBoard.do")) {
			System.out.println("�۵�� ó��");
		}else if (path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if (path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
		}else if (path.equals("/getBoard.do")) {
			System.out.println("�� �� ���� ó��");
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("�� ��� ���� ó��");
		}

	}

	/*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
