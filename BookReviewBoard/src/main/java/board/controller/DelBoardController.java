package board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.data.BoardDAO;
import board.data.BoardDAOImpl;
import board.data.BoardService;
import utils.JSFunctions;

/**
 * Servlet implementation class EditBoardController
 */
@WebServlet("/controller/DelBoardController")
public class DelBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		int result = service.postDelete(idx);
			
		if(result == 1) {
			JSFunctions.alertLocation(response, "게시물이 삭제되었습니다.", "../controller/ListController");
		}else {
			JSFunctions.alertBack(response, "오류가 발생하였습니다.");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
