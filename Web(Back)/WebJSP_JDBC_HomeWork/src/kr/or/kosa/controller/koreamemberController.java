package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import kr.or.kosa.dao.koreamemberDao;
import kr.or.kosa.dto.koreamemberDto;


@WebServlet("*.do")
public class koreamemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public koreamemberController() {
        super();
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 request.setCharacterEncoding("UTF-8");
    	 response.setContentType("text/html; charset=utf-8");
    	 HttpSession session = request.getSession();
    	 koreamemberDto dto = new koreamemberDto();
    	 koreamemberDao dao = new koreamemberDao();
    	 List<koreamemberDto> dtolist;
    	 
         boolean success =  false;
         int check = 0;
         
         
      	 String requestURI = request.getRequestURI();
         String contextPath = request.getContextPath();
         String urlcommand = requestURI.substring(contextPath.length());
         String viewpage="";
         
         PrintWriter out = response.getWriter();
         
          
        System.out.println("requestURI : " + requestURI);
        System.out.println("requestPath : " + contextPath);
        System.out.println("urlcommand : " + urlcommand);
        

        
        //파라미터값
        String id= "";
        String pwd = "";
        String name = ""; 
        int age = 0;
        String gender = "";
        String email = "";
        String ip = request.getRemoteAddr();
        
        
          
        if(urlcommand.equals("/main.do")) {
        	viewpage="/Main.jsp";        	
        }else if(urlcommand.equals("/login.do")) {
        	viewpage="/WEB-INF/views/login.jsp";
        }else if(urlcommand.equals("/loginok.do")) {
 		   id = request.getParameter("id");
 		   pwd = request.getParameter("pwd"); 		   
           dto.setId(id);
           dto.setPwd(pwd);

           success = dao.idCheck(id, pwd);   
            
            if(success==true) {
            	session.setAttribute("id", id);
     	
	            if(id.equals("admin")) {
	                viewpage="/Main.jsp";
	            }
	            else {
	                viewpage="/WEB-INF/views/web.jsp";
	            }
            }
            else {
            	viewpage="/Main.jsp";            
            }
            
	   }else if(urlcommand.equals("/register.do")) {
		   viewpage="/WEB-INF/views/register.jsp";
	   }else if(urlcommand.equals("/insert.do")) {
		   id = request.getParameter("id");
		   pwd = request.getParameter("pwd");
		   name = request.getParameter("name");
		   age = Integer.parseInt(request.getParameter("age"));
		   gender = request.getParameter("gender");
		   email = request.getParameter("email");
		   ip = request.getRemoteAddr();
		   
	       dto.setId(id);
		   dto.setPwd(pwd);
		   dto.setName(name);
		   dto.setAge(age);
		   dto.setGender(gender);
		   dto.setEmail(email);
		   dto.setIp(ip);
		   
		   dao.writeOk(dto);
		   
		   viewpage="/WEB-INF/views/register.jsp";
	   }
	   
	   else if(urlcommand.equals("/logout.do")) {
		   viewpage = "/WEB-INF/views/logout.jsp";
	   }else if(urlcommand.equals("/memberlist.do")) {
		   dtolist = dao.getAllTableList();
		   request.setAttribute("dtolist", dtolist);
		   viewpage="/WEB-INF/views/admin.jsp";
	   }
	   
	   else if(urlcommand.equals("/delete.do")) {
		   id = request.getParameter("id");
		   check = dao.delete(id);
		   dtolist = dao.getAllTableList();
       	   request.setAttribute("dtolist", dtolist);
		   if(check>0) {
			   viewpage="/WEB-INF/views/admin.jsp";
		   }else {
			   viewpage="/Main.jsp";
		   }
		   
		   
		   
	   }else if(urlcommand.equals("/edit.do")) {		   
		   
		   id = request.getParameter("id");
		   session.setAttribute("id", id);
		   dto = dao.getUpdateMember(id);
		   request.setAttribute("dao", dto);
			/* System.out.println(); */
		   viewpage="/WEB-INF/views/edit.jsp";
		   
	   }else if(urlcommand.equals("/update.do")) {
		   name = request.getParameter("name");
		   age = Integer.parseInt(request.getParameter("age"));
		   email = request.getParameter("email");
		   gender = request.getParameter("gender");
		   id = request.getParameter("id");
		   
		   if(check>0) {
			   viewpage="/WEB-INF/views/.jsp";
		   }else {
			   viewpage="/Main.jsp";
		   }
		   
	   }
        


        //5. view 설정하기
        RequestDispatcher dis = request.getRequestDispatcher(viewpage);
        
        //6. View forward 하기
        dis.forward(request, response);

    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
