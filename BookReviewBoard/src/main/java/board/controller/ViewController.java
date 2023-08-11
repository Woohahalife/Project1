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


@WebServlet("/controller/ViewController")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		int idx = Integer.parseInt(request.getParameter("idx"));

		service.increaseViewCount(idx);
		
		BoardDTO dto = service.viewDetails(idx);
		dao.close();
		
		dto.setB_content(dto.getB_content().replaceAll("\r\n", "<br/>"));
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("../board/view_review.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
