package kr.or.kosa.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Member;

public class MemberActivateService implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      ActionForward forward = null;
            
      try {
         AdminDao adminDao = new AdminDao();
         Member member = new Member();
         String userid = request.getParameter("userid");
         int userStatus = Integer.parseInt(request.getParameter("status"));
         member.setStatus(userStatus);
         member.setUserid(userid);
         
         int status = adminDao.activationCheck(member);
         
      
         
         
        
        	int cnt = adminDao.activationUpdate(status, member);
        	
        	if(cnt > 0) {
        		if(userStatus == 1) {
        			userStatus = 0;
        		}
        		else {
        			userStatus = 1;
        		}
        	}
            request.setAttribute("userStatus", userStatus);        	
            request.setAttribute("userid", userid);
            
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("/WEB-INF/views/admin/admin_delete.jsp");
            
         
        } catch (Exception e50) {
            System.out.println("The error e50 is " + e50.getMessage());
            e50.printStackTrace();
         }
         
         
         return forward;
      }
      

   }