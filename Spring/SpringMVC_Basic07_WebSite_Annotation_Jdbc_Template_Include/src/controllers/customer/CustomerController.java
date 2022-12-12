package controllers.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

/*
 *    
   Annotation변경
   
   @controller
   @RequestMapping
   
   하나의 컨트롤러를 만들라는 얘기 >> 이름 CustomerController로
게시판 목록보기, 게시판 상세보기를 함수 매핑을 이용해서 완성

@Controller
class Board{
   @RequestMapping("/list.do")
   void listBoard(){
   }
   
   @RequestMapping("/insert.do")
   void insertBoard(){
   }
 */
@Controller
public class CustomerController {
   private NoticeDao noticsdao;
   @Autowired
   public void setNoticsdao(NoticeDao noticsdao) {
      this.noticsdao = noticsdao;
   }
   
   //      <a href="customer/notice.htm">고객센터</a>
   
   @RequestMapping("/customer/notice.htm")
   public ModelAndView noticelist(@RequestParam(value="pg", defaultValue = "1") String pg,
                                                @RequestParam(value ="f", defaultValue = "TITLE") String f,
                                                @RequestParam(value="p", defaultValue="%%") String p) {
      System.out.println("테스트");
      
      String page = pg;
      String field = f;
      String query = p;

      List<Notice>  list = null;
      
      System.out.println("pg : " + pg + " / f : " + f + " / query : " + p);
      //DAO 작업
      try {
         list = noticsdao.getNotices(Integer.parseInt(page), field, query);
      } catch (NumberFormatException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      ModelAndView   mv = new ModelAndView();
      mv.addObject("list", list);
      mv.setViewName("notice");
      
      return  mv; //public String searchExternal()   view 주소
   }
   
   
   //   <a href="noticeDetail.htm?seq=${n.seq}"></a>
 //public Notice getNotice(String seq)
 	@RequestMapping("noticeDetail.htm")
 	public String noticesDetail(String seq  , Model model) {
 		
 	
 		Notice notice = null;
 		try {
 					notice = noticsdao.getNotice(seq);
 		} catch (ClassNotFoundException e) {
 						e.printStackTrace();
 		} catch (SQLException e) {
 						e.printStackTrace();
 		}
 		
 		/*
 		ModelAndView  mv = new ModelAndView();
 		
 		mv.addObject("notice", notice);
 		mv.setViewName("noticeDetail.jsp");
 		*/
 		model.addAttribute("notice", notice);
 		return "noticeDetail.jsp";
 	}
   
}