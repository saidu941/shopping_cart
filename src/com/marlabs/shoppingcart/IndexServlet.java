package com.marlabs.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
				
		System.out.println(Username+"---"+Password);

		HttpSession session = request.getSession();
		session.setAttribute("Username", Username);

		
		Connection connection = DBUtil.getConnection();
		boolean regFlag = false;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			regFlag = DBUtil.regFlag(Username, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(regFlag) {
			out.println("<html><body><h1>Login Successful..! for the user: ");
			out.print(Username);
			out.println("</h1></body></html>");
			
			
			
			ArrayList<String> list1 = new ArrayList<>();
			list1 = DBUtil.getItemsList(Username);
			System.out.println(list1);
			session.setAttribute("itemsList",list1);
			
			request.getRequestDispatcher("itemsList.jsp").forward(request, response);
			
		}else {
			out.println("Nothing");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
		
	}

}
