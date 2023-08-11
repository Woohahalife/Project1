package board.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import DB.DBconnect;
import member.data.MemberDTO;

public class BoardDAOImpl extends DBconnect implements BoardDAO {
	
	public BoardDAOImpl(ServletContext application) {
		super(application);
	}

	@Override
	public int insertPost(BoardDTO dto) {//게시판 데이터 추가
		int result = 0;
		
		String query = "insert into board_info("
					 + "b_id, B_IDX, b_bookname, b_name, b_title, CONTENT, POSTDATE, AUTHORS, PUBLISHER, ISBN, THUMBNAIL) "
					 + "values(?, seq_board_info_num.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getB_id());
			psmt.setString(2, dto.getB_bookname());
			psmt.setString(3, dto.getB_name());
			psmt.setString(4, dto.getB_title());
			psmt.setString(5, dto.getB_content());
			psmt.setString(6, dto.getAuthors());
			psmt.setString(7, dto.getPublisher());
			psmt.setString(8, dto.getIsbn());
			psmt.setString(9, dto.getThumnail());
			
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
            System.out.println("게시물 입력 중 예외 발생");
            e.printStackTrace();
        }
		return result;
	}
	
	//검색 시 조건에 맞는 개시물 개수 반환
	@Override
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		String query = "select count(*) from board_info";
		
		if(map.get("searchWord") != null) {
			query += " where " + map.get("searchField") 
				  + " like '%" + map.get("searchWord") + "%' ";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			
			totalCount = rs.getInt(1);
			System.out.println("totalCount : " + totalCount);
			
		}catch(Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;
	}

	@Override//검색 조건에 맞는 게시물 목록 반환
	public List<BoardDTO> selectPage(Map<String, Object> map) {
		
		List<BoardDTO> board = new ArrayList<BoardDTO>();
		
		String query = "select * from ("
					 + "select Tb.*, rownum rNum from ("
					 + "select * from board_info ";
		
		if(map.get("searchWord") != null) {
			query += " where " + map.get("searchField") 
				  + " like '%" + map.get("searchWord") + "%' ";
		}
		
		query += " order by b_idx desc"
				+ ")Tb "
				+ " ) where rNum between ? and ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setB_idx(rs.getInt(1));
				dto.setB_id(rs.getString(2));
				dto.setB_bookname(rs.getString(3));
				dto.setB_name(rs.getString(4));
				dto.setB_title(rs.getString(5));
				dto.setB_content(rs.getString(6));
				dto.setB_postdate(rs.getDate(7));
				dto.setB_visitcount(rs.getInt(8));
				dto.setAuthors(rs.getString(9));
				dto.setPublisher(rs.getString(10));
				dto.setIsbn(rs.getString(11));
				dto.setThumnail(rs.getString(12));
				
				board.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}
	
	//게시물 상세보기
	@Override
	public BoardDTO selectView(int b_idx) {
		BoardDTO dto = new BoardDTO();
		String query = "select * from board_info where b_idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, b_idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setB_idx(rs.getInt(1));
				dto.setB_id(rs.getString(2));
				dto.setB_bookname(rs.getString(3));
				dto.setB_name(rs.getString(4));
				dto.setB_title(rs.getString(5));
				dto.setB_content(rs.getString(6));
				dto.setB_postdate(rs.getDate(7));
				dto.setB_visitcount(rs.getInt(8));
				dto.setAuthors(rs.getString(9));
				dto.setPublisher(rs.getString(10));
				dto.setIsbn(rs.getString(11));
				dto.setThumnail(rs.getString(12));
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	@Override//방문자 수가 높은 게시물 3개만 따로 출력
	public List<BoardDTO> bestPost() {
		List<BoardDTO> board = new ArrayList<BoardDTO>();
		String query = "select * from ("
				+ "select Tb.*, rownum rNum from ("
				+ "select * from board_info order by visitcount desc "
				+ ") Tb "
				+ ") where rNum between 1 and 3";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setB_idx(rs.getInt(1));
				dto.setB_id(rs.getString(2));
				dto.setB_bookname(rs.getString(3));
				dto.setB_name(rs.getString(4));
				dto.setB_title(rs.getString(5));
				dto.setB_content(rs.getString(6));
				dto.setB_postdate(rs.getDate(7));
				dto.setB_visitcount(rs.getInt(8));
				dto.setAuthors(rs.getString(9));
				dto.setPublisher(rs.getString(10));
				dto.setIsbn(rs.getString(11));
				dto.setThumnail(rs.getString(12));
				

				board.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("베스트 게시물 개시 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void updateVisitCount(int b_idx) {
		
		String quary = "update board_info set "
					 + "visitcount=visitcount+1 "
					  + "where b_idx=?";
		try {
			psmt = con.prepareStatement(quary);
			psmt.setInt(1, b_idx);
			psmt.executeQuery();
			
		}catch(Exception e) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
	}
	
	@Override
	public int updatePost(BoardDTO dto) {
		int result = 0;
		String query = "update board_info set "
					 + "b_name=?, b_title=?, content=? where b_idx=?";
		
		try {
			psmt=con.prepareStatement(query);
			
			psmt.setString(1, dto.getB_name());
			psmt.setString(2, dto.getB_title());
			psmt.setString(3, dto.getB_content());
			psmt.setInt(4, dto.getB_idx());//dto상 idx와 일치시키기 위함
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("게시물 수정 중 예외발생");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deletePost(int b_idx) {
		int result = 0;
		String query = "delete from board_info where b_idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, b_idx);
			
			result = psmt.executeUpdate();
			
		}catch (Exception e) {
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }
		return result;
	}
	
	public void close() {
		try {
			if (rs != null) rs.close(); 
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close(); 
			
			System.out.println("JDBC 자원 해제");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
