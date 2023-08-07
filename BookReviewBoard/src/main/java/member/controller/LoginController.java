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


@WebServlet("/controller/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문자 인코딩
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//세션 생성
		HttpSession session = request.getSession();
		
		//로그인에 필요한 파라미터 값 get
		String m_id = request.getParameter("m_id");
		String m_pass = request.getParameter("m_pass");
		
		//DB연결 및 모델 객체 생성
		ServletContext application = this.getServletContext();
		MemberDAO dao = new MemberDAOImpl(application);
		
		//DTO에 값 저장
		MemberDTO dto = dao.selectMember(m_id, m_pass);
		
		if((m_id.equals(dto.getM_id()) && (m_pass.equals(dto.getM_pass())))) {
			//DTO통해 받은 데이터를 session에 저장
			session.setAttribute("m_id", dto.getM_id());
			session.setAttribute("m_pass", dto.getM_pass());
			session.setAttribute("m_name", dto.getM_name());
			session.setAttribute("m_email", dto.getM_email());
			session.setAttribute("m_nickname", dto.getM_nickname());
			session.setAttribute("m_pass", dto.getM_email());
			
			JSFunctions.alertLocation(response, "로그인 성공!", "../board/home.jsp");
		}else {
			JSFunctions.alertBack(response, "로그인 오류입니다!");
		}
	}

}
