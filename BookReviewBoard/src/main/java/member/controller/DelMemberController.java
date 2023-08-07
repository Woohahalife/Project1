package member.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.data.MemberDAO;
import member.data.MemberDAOImpl;
import member.data.MemberDTO;
import utils.JSFunctions;

@WebServlet("/controller/DelMemberController")
public class DelMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelMemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		
		int result = 0;
		
		String m_id = (String)session.getAttribute("m_id");
		String Cormessage = request.getParameter("Cormessage");
		
		MemberDTO dto = new MemberDTO();
		dto.setM_id(m_id);
		
		MemberDAO dao = new MemberDAOImpl(application);
		
		if(Cormessage.equals("계정을 삭제하겠습니다.") && dto.getM_id().equals((String)session.getAttribute("m_id"))) {
			result = dao.deleteMember(m_id);
			
			if(result == 1) {
				JSFunctions.alertLocation(response, "회원 정보가 삭제되었습니다!", "../login/login.jsp");
			}else {
				JSFunctions.alertBack(response, "오류입니다!!");
			}
			
		}else {
			JSFunctions.alertBack(response, "다시 입력해주세요!");
		}
		
	}

}
