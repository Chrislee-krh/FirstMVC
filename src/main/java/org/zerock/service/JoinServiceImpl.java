package org.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.zerock.command.JoinVO;

@Service("joinservice")
public class JoinServiceImpl implements JoinService {

	//회원 정보 저장 객체
	ArrayList<JoinVO> memberList = new ArrayList<>();
	
	//회원 가입 처리
	
	@Override
	public void insertMember(JoinVO vo) {
		memberList.add(vo);
	}
	
	@Override
	public int membercheck(JoinVO vo) {
		int result = 0;
		
		for(JoinVO dbvo : memberList) {
			if(dbvo.getId().equals(vo.getId())) {
				String dbPW = dbvo.getPw();
				String pw = vo.getPw();
				if(dbPW.equals(pw)) {
					result = 1; //로그인 성공
				}
			}
		}
		return result;
	}
}
