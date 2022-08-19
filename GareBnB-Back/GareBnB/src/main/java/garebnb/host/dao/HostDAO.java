package garebnb.host.dao;

import java.util.List;
import java.util.Map;

public interface HostDAO { 
	
	public Map<String, Object> selectHostDetail(Map<String,Object> map) throws Exception;
	
	// 호스트 전환 
	public void insertHostMem (Map<String,Object> map) throws Exception;
	
	// 호스트 전환 (레벨3으로 업데이트)
	public void updateHostMem(Map<String, Object> map); 
	//호스트회원정보수정
	public void updateOneHost(Map<String,Object> map) throws Exception;
	
	//호스트회원등록요청리스트
	public List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map);


	public void updateOneMemberDelete(Map<String, Object> map);

	public Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map);

	public void updateHostConfirm(Map<String, Object> map);

	public void updateHostDeny(Map<String, Object> map);
}
