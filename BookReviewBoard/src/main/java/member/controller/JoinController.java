package member.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.data.MemberDAO;
import member.data.MemberDAOImpl;
import member.data.MemberDTO;
import utils.JSFunctions;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/controller/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문자 인코딩
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			ServletContext application = this.getServletContext();
			
			String m_id = request.getParameter("m_id");
			String m_pass = request.getParameter("m_pass");
			String m_name = request.getParameter("m_name");
			String m_email = request.getParameter("m_email");
			String m_nickname = request.getParameter("m_nickname");
			
			MemberDTO dto = new MemberDTO();
			
			dto.setM_id(m_id);
			dto.setM_pass(m_pass);
			dto.setM_name(m_name);
			dto.setM_email(m_email);
			dto.setM_nickname(m_nickname);
			
			MemberDAO dao = new MemberDAOImpl(application);
			
			int result = dao.insertMember(dto);
			
			if(result == 1) {
				JSFunctions.alertLocation(response, "회원가입을 축하합니다!", "../login/login.jsp");
			}else {
				JSFunctions.alertBack(response, "회원가입 오류입니다!");
			}
			
	}

}
