package dao;

import dto.Member;

public interface MemberDao {
		
		//회원가입
		public int insertMember(Member member); // 암호화
		
		public int idCheck(String userid);
		
		public int loginCheck(String username, String password);
		
		public Member getMember(String uid);
		
		//회원수정
		public int updateMember(Member member); // 암호화
		
		// 마이페이지 비밀번호 확인
		public int passwordCheck(String userid, String password);

}
