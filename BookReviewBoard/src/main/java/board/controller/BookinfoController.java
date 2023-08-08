package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class EditBoardController
 */
@WebServlet("/controller/BookinfoController")
public class BookinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookinfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String bookname= request.getParameter("bookname");
		String authors= request.getParameter("authors");
		String publisher= request.getParameter("publisher");
		String isbn= request.getParameter("isbn");
		String thumbnail= request.getParameter("thumbnail");
		
		
		request.setAttribute("bookname", bookname);
		request.setAttribute("authors", authors);
		request.setAttribute("publisher", publisher);
		request.setAttribute("isbn", isbn);
		request.setAttribute("thumbnail", thumbnail);
		
		
		request.getRequestDispatcher("../board/write_review.jsp").forward(request, response);
		
	}

}
