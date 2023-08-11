package board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.data.BoardDAO;
import board.data.BoardDAOImpl;
import board.data.BoardDTO;
import board.data.BoardService;
import utils.JSFunctions;

@WebServlet("/controller/EditBoardController")
public class EditBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		BoardDTO dto = service.viewDetails(idx);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("../board/edit_review.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int b_idx = Integer.parseInt(request.getParameter("idx"));
		String b_title = request.getParameter("title");
		String b_name = request.getParameter("name");
		String b_content = request.getParameter("content");
		
		BoardDTO dto = new BoardDTO();
		dto.setB_idx(b_idx);
		dto.setB_title(b_title);
		dto.setB_name(b_name);
		dto.setB_content(b_content);
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		int result = service.postUpdate(dto);
		dao.close();
		
		if(result == 1) {
			JSFunctions.alertLocation(response, "게시물이 수정되었습니다!", "../controller/ViewController?idx=" + b_idx);
		}else {
			JSFunctions.alertBack(response, "게시물 수정 오류");
		}
	}

}
