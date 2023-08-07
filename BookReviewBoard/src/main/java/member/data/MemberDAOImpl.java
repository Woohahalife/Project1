package member.data;

import javax.servlet.ServletContext;

import DB.DBconnect;

public class MemberDAOImpl extends DBconnect implements MemberDAO{
	
	public MemberDAOImpl(ServletContext application) {
		super(application);
	}

	@Override
	public int insertMember(MemberDTO dto) {//회원가입 처리 메서드
		int result = 0;
		String sql= "INSERT INTO member_info VALUES(?,?,?,?,?,sysdate)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getM_id());
			psmt.setString(2, dto.getM_pass());
			psmt.setString(3, dto.getM_name());
			psmt.setString(4, dto.getM_email());
			psmt.setString(5, dto.getM_nickname());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("회원가입 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public MemberDTO selectMember(String m_id, String m_pass) {// 로그인 처리 메서드
		MemberDTO dto = new MemberDTO();
		String query= "SELECT * FROM member_info WHERE m_id=? and m_pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, m_id);
			psmt.setString(2, m_pass);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setM_id(rs.getString(1));
				dto.setM_pass(rs.getString(2));
				dto.setM_name(rs.getString(3));
				dto.setM_email(rs.getString(4));
				dto.setM_nickname(rs.getString(5));
				dto.setM_Regidate(rs.getDate(6));
			}
			
		}catch(Exception e) {
			System.out.println("로그인 중 예외 발생");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int editMemberInfo(MemberDTO dto) {
		int result = 0;
		String query ="UPDATE member_info"
				+ " SET m_pass=?, m_email=?, m_nickname=? WHERE m_id=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(0, dto.getM_pass());
			psmt.setString(0, dto.getM_email());
			psmt.setString(0, dto.getM_nickname());
			psmt.setString(4, dto.getM_id());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("회원정보변경 중 예외발생");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteMember(String m_id) {
		int result = 0;
		String query = "delete from member_info where m_id=?";
		
		try {
			psmt =con.prepareStatement(query);
			psmt.setString(1, m_id);
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("삭제 처리 중 예외 발생");
			e.printStackTrace();
		}
		return result;//결과값 반환
	}

}
