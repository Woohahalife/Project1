package board.data;

import java.util.Date;

public class BoardDTO {
	private String b_id;// 작성자 아이디
	private int b_idx;// 글번호
	private String b_bookname;// 도서명
	private String b_name;// 작성자명(닉네임)
	private String b_title;// 글제목
	private String b_content;// 글내용
	private Date b_postdate;// 작성날짜
	private int b_visitcount;// 방문자수
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(String b_id, int b_idx, String b_bookname, String b_name, String b_title, String b_content,
			Date b_postdate, int b_visitcount) {
		super();
		this.b_id = b_id;
		this.b_idx = b_idx;
		this.b_bookname = b_bookname;
		this.b_name = b_name;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_postdate = b_postdate;
		this.b_visitcount = b_visitcount;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public int getB_idx() {
		return b_idx;
	}

	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}

	public String getB_bookname() {
		return b_bookname;
	}

	public void setB_bookname(String b_bookname) {
		this.b_bookname = b_bookname;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_postdate() {
		return b_postdate;
	}

	public void setB_postdate(Date b_postdate) {
		this.b_postdate = b_postdate;
	}

	public int getB_visitcount() {
		return b_visitcount;
	}

	public void setB_visitcount(int b_visitcount) {
		this.b_visitcount = b_visitcount;
	}
	
	
}
