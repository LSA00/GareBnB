package garebnb.host.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import garebnb.common.common.CommandMap;
import garebnb.host.service.HostService;

@Controller
public class HostController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="hostService")
	private HostService hostService;
	
	
	//일반-호스트회원정보보기
	@ResponseBody
	@RequestMapping(value="/myPage/hostDetail.do" )
    public Map<String, Object> hostDetail(CommandMap commandMap) throws Exception{
		
    	return hostService.selectHostDetail(commandMap.getMap());
    }
	
	
	//호스트-호스트회원정보보기
	@ResponseBody
	@RequestMapping(value="/host/myPage/hostInfo.do" )
    public Map<String, Object> selectHostDetail(CommandMap commandMap) throws Exception{
		return hostService.selectHostDetail(commandMap.getMap());
    }
	
	//호스트-회원정보수정
	@ResponseBody
	@RequestMapping(value="/host/myPage/hostModify.do" )
    public void updateOneHost(CommandMap commandMap) throws Exception{
		hostService.updateOneHost(commandMap.getMap());
    }
	 
	
	//호스트-회원탈퇴
	@ResponseBody
	@RequestMapping(value="/host/mypage/hostDelete.do" )
	public void hostDelete(CommandMap commandMap) throws Exception{
		hostService.updateOneMemberDelete(commandMap.getMap());
	}	
	
	// 호스트 전환하기 
	@ResponseBody
	@RequestMapping(value= "/mypage/memChange") 
	public void insertHostMem(CommandMap commandMap) throws Exception {
	hostService.insertHostMem(commandMap.getMap());
	}
	
	// 호스트 전환 (레벨 3으로 업데이트) 
	@ResponseBody
	@RequestMapping(value="/mypage/updateHostMem.do" )
	public void updateHostMem(CommandMap commandMap) throws Exception{
	hostService.updateHostMem(commandMap.getMap());
	}	
		
	
	//관리자-호스트회원등록요청리스트
	@ResponseBody
	@RequestMapping(value="/Admin/hostConfirmList")
	public List<Map<String,Object>> memberList(CommandMap commandMap) throws Exception{
		return hostService.selectHostConfirmList(commandMap.getMap());

	}
	
	//관리자-호스트회원등록요청상세보기
	@ResponseBody
	@RequestMapping(value="/Admin/hostConfirmMemberDetail.do" )
    public Map<String, Object> hostConfirmDetail(CommandMap commandMap) throws Exception{
		
    	return hostService.selectConfirmMemberDetail(commandMap.getMap());
    }

	
	//관리자-호스트등록승인
	@ResponseBody
	@RequestMapping(value="/Admin/HostConfirm.do" )
	public void hostConfirm(CommandMap commandMap) throws Exception{
		hostService.updateHostConfirm(commandMap.getMap());
	}	
	
	
	//관리자-호스트등록거절
	@ResponseBody
	@RequestMapping(value="/Admin/HostDeny.do" )
	public void hostDeny(CommandMap commandMap) throws Exception{
		hostService.updateHostDeny(commandMap.getMap());
	}	
	
	
	
	
	
}
