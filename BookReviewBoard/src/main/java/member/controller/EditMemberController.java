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

@WebServlet("/controller/EditMemberController")
public class EditMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext application = this.getServletContext();
		
		String m_id = request.getParameter("m_id");
		String m_pass = request.getParameter("m_pass");
		String m_email = request.getParameter("m_email");
		String m_nickname = request.getParameter("m_nickname");
		
		MemberDTO dto= new MemberDTO();
		dto.setM_id(m_id);
		dto.setM_pass(m_pass);
		dto.setM_email(m_email);
		dto.setM_nickname(m_nickname);
		
		MemberDAO dao = new MemberDAOImpl(application);
		int result = dao.editMemberInfo(dto);
		
		if(result == 1) {
			JSFunctions.alertLocation(response, "회원 정보가 수정되었습니다.\n다시 로그인 해주세요", "../login/loginView.jsp");
		}else {
			
		}
	}

}
