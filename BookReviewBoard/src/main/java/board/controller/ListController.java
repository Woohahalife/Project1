package board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import utils.BoardPage;

@WebServlet("/controller/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		
		
		BoardDTO dto = new BoardDTO();
		
		
		service.addPost(dto);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext application = this.getServletContext();
		BoardDAO dao = new BoardDAOImpl(application);
		BoardService service = new BoardService(dao);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String searchField = request.getParameter("searchField");
		String searchWord = request.getParameter("searchWord");
		
		map.put("searchField", searchField);
		map.put("searchWord", searchWord);
		
		int totalCount = service.boardCount(map);
		
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
	
		int pageNum = 1;//기본값
		String pageTemp = request.getParameter("pageNum");
		
		if(pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp);//요청받은 페이지로 수정
		}
		
		int start = (pageNum - 1) * pageSize + 1;//첫 게시물 번호
		int end = pageNum * pageSize;//마지막 게시물 번호
		map.put("start", start);
		map.put("end", end);
		
		List<BoardDTO> boardLists = service.postList(map);
		
		dao.close();
		
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, 
				blockPage, pageNum, "../board/write_review.jsp?", searchField, searchWord);//바로가기 영역의 HTML 문자열
		
		//뷰 전달용 맵에 저장
		map.put("pagingImg", pagingImg);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		
		//전달 데이터를 request영역에 저장 후 list.jsp로 포워드
		request.setAttribute("boardLists", boardLists);
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("../board/home.jsp").forward(request, response);
	
	}
	

}
