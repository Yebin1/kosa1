package kr.or.kosa.service.common;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import kr.or.kosa.dao.CommonDao;

public class VisitSessionListener implements HttpSessionListener {

	  @Override
	    public void sessionCreated(HttpSessionEvent sessionEve) {
	        
	        // 세션이 새로 생성되면 execute() 실행한다.
	        if(sessionEve.getSession().isNew()){
	            execute(sessionEve);
	        }
	    }
	 
	    private void execute(HttpSessionEvent sessionEve) 
	    {
	        CommonDao commondao = CommonDao.getInstance();
	        
	        try {
	            // 전체 방문자 수 증가
	            commondao.setTotalCount();
	            // 총 방문자 수
	            int totalCount = commondao.getTotalCount();
	            // 오늘 방문자 수
	            int todayCount = commondao.getTodayCount();
	            
	            HttpSession session = sessionEve.getSession();
	            
	            // 세션에 방문자 수를 담는다.
	            session.setAttribute("totalCount", totalCount); 
	            session.setAttribute("todayCount", todayCount);
	            
	        } catch (Exception e) {
	            System.out.println("===== 방문자 카운터 오류 =====\n");
	            e.printStackTrace();
	        }
	    }
	 
	    @Override
	    public void sessionDestroyed(HttpSessionEvent arg0) {}
	 
	}
