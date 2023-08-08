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
import board.data.BoardDTO;
import board.data.BoardService;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("/controller/WriteController")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		String b_id = request.getParameter("b_id");
		String b_title = request.getParameter("b_title");
		String b_name = request.getParameter("b_name");
		String b_bookname = request.getParameter("bookname");
		String b_content = request.getParameter("b_content");
		
		String authors= request.getParameter("authors");
		String publisher= request.getParameter("publisher");
		String isbn= request.getParameter("isbn");
		String thumbnail= request.getParameter("thumbnail");
		
		System.out.println(b_name);
		System.out.println(b_bookname);
		System.out.println(authors);
		System.out.println(publisher);
		System.out.println(isbn);
		System.out.println(thumbnail);
		
		BoardDTO dto= new BoardDTO();
		
		dto.setB_id(b_id);
		dto.setB_title(b_title);
		dto.setB_name(b_name);
		dto.setB_bookname(b_bookname);
		dto.setB_content(b_content);
		dto.setAuthors(authors);
		dto.setPublisher(publisher);
		dto.setIsbn(isbn);
		dto.setThumnail(thumbnail);
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		int result = service.addPost(dto);
		dao.close();
		
		request.getRequestDispatcher("../board/home.jsp").forward(request, response);
	
	
	}

}
