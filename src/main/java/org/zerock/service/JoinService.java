package org.zerock.service;

import org.zerock.command.JoinVO;

public interface JoinService {

	public void insertMember(JoinVO vo);
	public int membercheck(JoinVO vo);
	
}
