package board.data;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

public class BoardService {
	
	private BoardDAO dao;//인터페이스 선언
	
	public BoardService(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	public int addPost (BoardDTO dto) {
		return dao.insertPost(dto);
	}
	
	public int boardCount(Map<String, Object> map) {
		return dao.selectCount(map);
	}
	
	public List<BoardDTO> postList(Map<String, Object> map) {
		return dao.selectPage(map);
	}
	
	public List<BoardDTO> bestPostList() {
		return dao.bestPost();
	}
	
	public BoardDTO viewDetails(int b_idx) {
		return dao.selectView(b_idx);
	}
	
	public void increaseViewCount(int b_idx) {
		dao.updateVisitCount(b_idx);
	}
	
	public List<BoardDTO> bestPost() {
		return dao.bestPost();
	}
	
	public int postUpdate(BoardDTO dto) {
		return dao.updatePost(dto);
	}
	
	public int postDelete(int b_idx) {
		return dao.deletePost(b_idx);
	}
}	
