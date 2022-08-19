package garebnb.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import garebnb.member.dao.MemberDAO;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Repository("memberService")
public class MemberServiceImpl implements MemberService {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="memberDAO")
	private MemberDAO memberDAO;

	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.insertMember(map);
		
	}
	
	@Override
	public Map<String, Object> selectMemDetail(Map<String, Object> map) throws Exception { // 일반 회원 상세 보기 
		// TODO Auto-generated method stub
		return memberDAO.selectMemDetail(map);
	}


	@Override
	public int selectMemberDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.selectMemberDetail(map);
	}

	@Override
	public void updateOneMember(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateOneMember(map);
	}

	@Override
	public void updateOneMemberDelete(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateOneMemberDelete(map);
	}


	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.selectMemberList(map);
	}

	@Override
	public List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.selectHostConfirmList(map);
	}

	@Override
	public Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.selectConfirmMemberDetail(map);
	}

	@Override
	public void updateMemberDeny(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateMemberDeny(map);
	}


	@Override
	public void updateHostConfirm(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateHostConfirm(map);
	}


	@Override
	public void updateHostDeny(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.updateHostDeny(map);
	}
	
	@Override
	public void insertHostMem(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		memberDAO.insertHostMem(map);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String PhoneNumberCheck(Map<String, Object> map) throws CoolsmsException{
		String api_key = "NCSWHNPKBBLTIWD0";
		String api_secret = "9H10HPRT8SJXAAAJGLKCISBHRPWTOL7F";
		Message coolsms = new Message(api_key, api_secret);
			
		
		Random rand = new Random(); 
		String numStr = "";

		for(int i=0; i<4; i++) {
			String ran = Integer.toString(rand.nextInt(10)); 
			numStr += ran;
		}
		  
		HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", (String)map.get("to"));    // 수신전화번호 (ajax로 view 화면에서 받아온 값으로 넘김)
	    params.put("from", "01039578057");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	    params.put("type", "sms"); 
	    params.put("text", "[KOO] 인증번호는 [" + numStr + "] 입니다.");
	    System.out.println(map);
	    coolsms.send(params); // 메시지 전송
			  
			  
		return numStr;
		
		 
	}

}