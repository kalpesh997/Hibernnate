package com.db.controller;


import java.io.IOException;
/*import java.util.List;*/

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.Dao.*;
import com.db.model.*;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String LIST_USER = "/allUser.jsp";
	String INSERT_OR_EDIT = "/newUser.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		Dao d = new Dao();				
		
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("listUser"))
		{
			forward = LIST_USER;
			request.setAttribute("allusers",d.getAlluser());
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			int id = Integer.parseInt(request.getParameter("userId"));
			d.daleteUser(id);
			forward = LIST_USER;
			request.setAttribute("allusers",d.getAlluser());
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("userId"));
			User u = d.getByIduser(id);
			request.setAttribute("user",u);
		}
		else 
		{
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
		
        
        /*String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");		
		String email = request.getParameter("email");		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;
		try {
			date1 = sf.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(date1.getTime()); */
        
        	//insert data
      	//d.insert(fname, lname, date, email);
        
			//select data
		/*List<User> list = d.getAlluser();
		for(User u : list)
		{
			PrintWriter out = response.getWriter();
			out.println("First Name : "+u.getFname());
			out.println("Last Name : "+u.getLname());
			out.println("Date : "+u.getDate());
			out.println("Email : "+u.getEmail()+"\n\n");
			
		} */
		
			// update user
		//d.updateUser(1,"kalpesh321");
		
			// delete user
		//d.daleteUser(5);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		User u1 = new User();
		Dao d1 = new Dao();
		
		u1.setFname(request.getParameter("fname"));
		u1.setLname(request.getParameter("lname"));		
		u1.setEmail(request.getParameter("email"));		
		String id = request.getParameter("userid");
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date1 = null;
		try {
			date1 = sf.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(date1.getTime());
		u1.setDate(date);
			
		if(id == null || id.isEmpty())
        {
			d1.insert(u1);
        }
		else 
		{
			u1.setId(Integer.parseInt(request.getParameter("userid")));
			d1.updateUser(u1);
		}
		RequestDispatcher rd1 = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("allusers",d1.getAlluser());
		rd1.forward(request, response);
	}
	
}



