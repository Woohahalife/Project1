package board.data;

import java.util.List;
import java.util.Map;

import member.data.MemberDTO;

public interface BoardDAO {
	int insertPost(BoardDTO dto);
	int selectCount(Map<String, Object> map);
	List<BoardDTO> selectPage(Map<String, Object> map);
	BoardDTO selectView(int b_idx);
	void updateVisitCount(int b_idx);
	List<BoardDTO> bestPost(BoardDTO dto);
	int updatePost(BoardDTO dto);
	int deletePost(int b_idx);
	void close();
}
