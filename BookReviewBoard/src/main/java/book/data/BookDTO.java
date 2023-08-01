package book.data;

public class BookDTO {
	private int bo_num; // 일련번호
	private String bo_bookname;// 도서명
	private String bo_author;// 저자
	private String bo_publish;// 출판사
	private String bo_ofile;// 원본파일명
	private String bo_sfile;// 저장용 파일명
	
	public BookDTO() {
		super();
	}

	public BookDTO(int bo_num, String bo_bookname, String bo_author, String bo_publish, String bo_ofile,
			String bo_sfile) {
		super();
		this.bo_num = bo_num;
		this.bo_bookname = bo_bookname;
		this.bo_author = bo_author;
		this.bo_publish = bo_publish;
		this.bo_ofile = bo_ofile;
		this.bo_sfile = bo_sfile;
	}

	public int getBo_num() {
		return bo_num;
	}

	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}

	public String getBo_bookname() {
		return bo_bookname;
	}

	public void setBo_bookname(String bo_bookname) {
		this.bo_bookname = bo_bookname;
	}

	public String getBo_author() {
		return bo_author;
	}

	public void setBo_author(String bo_author) {
		this.bo_author = bo_author;
	}

	public String getBo_publish() {
		return bo_publish;
	}

	public void setBo_publish(String bo_publish) {
		this.bo_publish = bo_publish;
	}

	public String getBo_ofile() {
		return bo_ofile;
	}

	public void setBo_ofile(String bo_ofile) {
		this.bo_ofile = bo_ofile;
	}

	public String getBo_sfile() {
		return bo_sfile;
	}

	public void setBo_sfile(String bo_sfile) {
		this.bo_sfile = bo_sfile;
	}
	
	
}
