package board.data;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	int insertBoard(BoardDTO dto);
	int selectCount(Map<String, Object> map);
	List<BoardDTO> selectPage(Map<String, Object> map);
	BoardDTO selectView(int idx);
	void updateVisitCount(int idx);
}
