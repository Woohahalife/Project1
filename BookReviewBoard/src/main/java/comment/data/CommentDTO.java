package comment.data;

public class CommentDTO {
	private int c_idx;//글 번호
	private String c_id;// 댓글 작성자 아이디
	private int c_comnum;// 댓글 번호
	private String c_nickname;// 작성자 닉네임
	private String c_comment;// 댓글 내용
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(int c_idx, String c_id, int c_comnum, String c_nickname, String c_comment) {
		super();
		this.c_idx = c_idx;
		this.c_id = c_id;
		this.c_comnum = c_comnum;
		this.c_nickname = c_nickname;
		this.c_comment = c_comment;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public int getC_comnum() {
		return c_comnum;
	}

	public void setC_comnum(int c_comnum) {
		this.c_comnum = c_comnum;
	}

	public String getC_nickname() {
		return c_nickname;
	}

	public void setC_nickname(String c_nickname) {
		this.c_nickname = c_nickname;
	}

	public String getC_comment() {
		return c_comment;
	}

	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	
	
}
