package garebnb.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import garebnb.common.common.CommandMap;
import garebnb.member.service.MemberService;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class MemberController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="memberService")
	private MemberService memberService;
	
	@ResponseBody
    @RequestMapping(value="/confirmId") // 아이디 중복 확인 
    public String selectMemberDetail(CommandMap commandMap) throws Exception{
	
		System.out.println(commandMap.getMap());
		
		String idCheck = String.valueOf(memberService.selectMemberDetail(commandMap.getMap()));
		
		System.out.println(idCheck);
		
        return idCheck; // idCheck = 1이면 id 중복 있음. 0이면 id 중복 없음 

    }
	
	// 마이 페이지의 회원 상세 보기, 관리자 페이지의 회원 상세 보기  
	@ResponseBody 
	@RequestMapping(value= {"/mypage/MemDetail", "/Admin/MemDetail"}) 
	public Map<String, Object> selectMemDetail(CommandMap commandMap) throws Exception {
	    return memberService.selectMemDetail(commandMap.getMap());
		}
	
	
	@ResponseBody
	@RequestMapping(value= "/joinSuccess") // 회원가입 성공 
	public String insertMember(CommandMap commandMap) throws Exception {
    	memberService.insertMember(commandMap.getMap());
    	return "1"; 
	}
	
	@ResponseBody
	@RequestMapping(value= "/mypage/memModify") // 회원정보 수정 
	public void updateOneMember(CommandMap commandMap) throws Exception {
    	memberService.updateOneMember(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/mypage/memDelete") // 회원 탈퇴 
	public void updateOneMemberDelete(CommandMap commandMap) throws Exception {
    	memberService.updateOneMemberDelete(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/memberDeny") // 회원 정지 확인 
	public void updateMemberDeny(CommandMap commandMap) throws Exception {
    	memberService.updateMemberDeny(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/hostConfirm") // 호스트 등록 승인 
	public void updateHostConfirm(CommandMap commandMap) throws Exception {
    	memberService.updateHostConfirm(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/hostDeny") // 호스트 등록 거절 
	public void updateHostDeny(CommandMap commandMap) throws Exception {
    	memberService.updateHostDeny(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/memberList") // 전체 회원 리스트 
	public List<Map<String, Object>> selectMemberList(CommandMap commandMap) throws Exception {
    	return memberService.selectMemberList(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/HostConfirmList") // 호스트 등록 요청 리스트 
	public List<Map<String, Object>> selectHostConfirmList(CommandMap commandMap) throws Exception {
    	return memberService.selectHostConfirmList(commandMap.getMap());
	}
	
	@ResponseBody
	@RequestMapping(value= "/Admin/HostConfirmMemberDetail") // 호스트 회원 등록 요청 상세 
	public Map<String, Object> selectConfirmMemberDetail(CommandMap commandMap) throws Exception {
    	return memberService.selectConfirmMemberDetail(commandMap.getMap());
	}
	
	
	@ResponseBody
	@RequestMapping(value= "/PhoneNumberCheck") // 호스트 회원 등록 요청 상세 
	public String PhoneNumberCheck(CommandMap commandMap) throws Exception {
    	return memberService.PhoneNumberCheck(commandMap.getMap());
	}    

}
