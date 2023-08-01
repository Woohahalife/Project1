package member.data;


public interface MemberDAO {
	
	int insertMember(MemberDTO dto);// 회원가입
	MemberDTO selectMember(String m_id, String m_pass);// 로그인
	int editMemberInfo(MemberDTO dto);// 정보수정
	int deleteMember(String m_id);// 회원탈퇴
}
