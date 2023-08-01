package member.data;

import java.util.Date;

public class MemberDTO {
	private String m_id;// 아이디
	private String m_pass;// 비밀번호
	private String m_name;// 사용자 이름
	private String m_email;// 사용자 이메일
	private String m_nickname;// 사용자 닉네임
	private Date m_Regidate;// 날짜
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String m_id, String m_pass, String m_name, String m_email, String m_nickname, Date m_Regidate) {
		super();
		this.m_id = m_id;
		this.m_pass = m_pass;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_nickname = m_nickname;
		this.m_Regidate = m_Regidate;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pass() {
		return m_pass;
	}

	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public Date getM_Regidate() {
		return m_Regidate;
	}

	public void setM_Regidate(Date m_Regidate) {
		this.m_Regidate = m_Regidate;
	}
	
	
	
	
}
