package garebnb.host.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service("hostService")
public interface HostService {
	
	//호스트회원정보보기
	Map<String, Object> selectHostDetail(Map<String, Object> map) throws Exception;
	
	//호스트회원정보수정
	void updateOneHost(Map<String,Object> map) throws Exception;
	 
	//호스트 전환 (레벨3으로 업데이트)
	void updateHostMem(Map<String,Object> map) throws Exception;
	
	//호스트회원등록요청리스트
	List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map);

	// 호스트 전환 
	void insertHostMem(Map<String, Object> map) throws Exception;
	
	
	//호스트회원탈퇴
	void updateOneMemberDelete(Map<String, Object> map);

	//관리자-호스트회원등록요청상세보기
	Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map);

	//관리자-호스트등록승인
	void updateHostConfirm(Map<String, Object> map);

	//관리자-호스트등록거절
	void updateHostDeny(Map<String, Object> map);
}
