package garebnb.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service("memberService")
public interface MemberService {
	
	int selectMemberDetail(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectMemDetail(Map<String, Object> map) throws Exception; // 일반 회원 상세보기 
	
	void insertMember(Map<String, Object> map) throws Exception;
	
	void updateOneMember(Map<String, Object> map) throws Exception;

	void updateOneMemberDelete(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map) throws Exception;

	void updateMemberDeny(Map<String, Object> map) throws Exception;
	
	void updateHostConfirm(Map<String, Object> map) throws Exception;
	
	void updateHostDeny(Map<String, Object> map) throws Exception;
	
	void insertHostMem(Map<String, Object> map) throws Exception;
	
	String PhoneNumberCheck(Map<String, Object> map) throws CoolsmsException;
	
}
