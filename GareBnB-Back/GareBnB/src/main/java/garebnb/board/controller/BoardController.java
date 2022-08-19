package garebnb.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import garebnb.board.service.BoardService;
import garebnb.common.common.CommandMap;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="boardService")
	private BoardService boardService;
	
	
	//호스트 나의게시글 리스트
	@ResponseBody
	@RequestMapping(value="/host/mypage/myboardList")
	public List<Map<String,Object>> myboardList(CommandMap commandMap) throws Exception{
		return boardService.selectOneBoardList(commandMap.getMap());

	}
	
	//호스트 나의 게시글 삭제
	@ResponseBody
    @RequestMapping(value= "/host/mypage/myboardDelete") 
    public void updateOneMember(CommandMap commandMap) throws Exception {
        boardService.updateOneBoardDelete(commandMap.getMap());
    }
	
	
	//호스트 나의 게시글 등록
	@ResponseBody
    @RequestMapping(value= "/host/mypage/myboardPut") 
    public Map<String, Object> myboardPut(CommandMap commandMap) throws Exception {
     
        return boardService.insertOneBoard(commandMap.getMap());
    }
	
	//호스트 나의게시글 상세보기(삭제 안된것만 보여주기)
	@ResponseBody
	@RequestMapping(value="/host/mypage/myboardModifyForm")
	public Map<String, Object> myboardModifyForm(CommandMap commandMap) throws Exception{
		
    	return boardService.selectOneBoard(commandMap.getMap());
	}

	
	//호스트 나의게시글 수정 입력
	@ResponseBody
	@RequestMapping(value="/host/mypage/myboardModify")
	public Map<String, Object> myboardModify(CommandMap commandMap) throws Exception{
		
	 	return boardService.insertOneBoardModify(commandMap.getMap());
	}
	 
	@ResponseBody
	@RequestMapping(value="/host/mypage/myboardmodifyCancel")
	public void myboardModifyCancel(CommandMap commandMap) throws Exception{
		
		boardService.updateOneBoardModifyCancel(commandMap.getMap());
	}
	
	//전체 게시글 리스트(등록완료 글만)
	@ResponseBody
	@RequestMapping(value="/board/boardList")
	public List<Map<String,Object>> boardList(CommandMap commandMap) throws Exception{
		
        return boardService.selectBoardList(commandMap.getMap());
	}

	//게시글 상세보기
	@ResponseBody
	@RequestMapping(value="/board/boardDetail")
	public Map<String, Object> openboardDetail(CommandMap commandMap) throws Exception{
		
    	return boardService.selectBoardDetail(commandMap.getMap());
	}
	
	
	//관리자-호스트 게시글 리스트(삭제된것도 뜸)
	@ResponseBody
	@RequestMapping(value="/Admin/hostBoardList")
	public List<Map<String,Object>> boardList_ad(CommandMap commandMap) throws Exception{
		
        return boardService.selectHostBoardList(commandMap.getMap());
	}
	
	/*
	 * //관리자-게시글 상세보기
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/Admin/boardDetail") public Map<String, Object>
	 * openboardDetail_ad(CommandMap commandMap) throws Exception{ return
	 * boardService.selectBoardDetail(commandMap.getMap()); }
	 */
	
	
	//관리자-호스트 글 등록 승인
	@ResponseBody
    @RequestMapping(value="/Admin/hostBoardConfirm")
    public void boardConfirm(CommandMap commandMap) throws Exception {
        boardService.updateHostBoardConfirm(commandMap.getMap());
    }	
	
	
	//관리자-호스트 글 등록 거절
		@ResponseBody
	    @RequestMapping(value="/Admin/hostBoardDeny")
	    public void boardDeny(CommandMap commandMap) throws Exception {
	        boardService.updateHostBoardDeny(commandMap.getMap());
	    }	

}
