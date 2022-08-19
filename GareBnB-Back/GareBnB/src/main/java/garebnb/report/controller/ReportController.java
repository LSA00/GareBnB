package garebnb.report.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import garebnb.common.common.CommandMap;
import garebnb.report.service.ReportService;

@Controller
public class ReportController {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="reportService")
	private ReportService reportService;
	
	
	//1. 일반회원 + 호스트
	//신고내역 - 일반회원
	@ResponseBody 
	@RequestMapping(value="/mypage/memReportList.do")
	public List<Map<String, Object>> memReportList(CommandMap commandMap) throws Exception{
		System.out.println("컨트롤러 확인");
        return reportService.selectOneReportList(commandMap.getMap());
	}
	
	//신고내역 - 호스트
	@ResponseBody 
	@RequestMapping(value="/host/mypage/hostReportList.do")
	public List<Map<String, Object>> hostReportList(CommandMap commandMap, HttpServletRequest request) throws Exception{
		
        return reportService.selectOneReportList(commandMap.getMap());

	}
	
	
	//신고내역 - 상세보기
	@RequestMapping(value="mypage/memDetailReport.do")
	@ResponseBody 
	public Map<String, Object> memDetailReport(CommandMap commandMap) throws Exception{

        return reportService.selectDetailReport(commandMap.getMap());
	}
	
	
	//신고내역 - 호스트    ---- 호스트랑 중복이라 빼기 
	@RequestMapping(value="/host/mypage/hostDetailReport.do")
	@ResponseBody 
	public Map<String, Object> hostDetailReport(CommandMap commandMap) throws Exception{

        return reportService.selectDetailReport(commandMap.getMap());
	}
	
	
	
	//일반회원 -> 호스트회원 신고 - 입력
	@RequestMapping(value="/mypage/memReportInsert.do")
	@ResponseBody
	public void memReportInsert(CommandMap commandMap) throws Exception{
		
	reportService.insertReport(commandMap.getMap());

	}
	
	
	//호스트회원 -> 일반회원 신고 - 입력
	@RequestMapping(value="host/mypage/hostReportInsert.do")
	@ResponseBody
	public void hostReportInsert(CommandMap commandMap) throws Exception{

		reportService.insertHostReport(commandMap.getMap());

	}
	
	
	//2.관리자
	//신고 내역 리스트
	@ResponseBody 
	@RequestMapping(value="/Admin/reportList.do")
	public List<Map<String, Object>> reportList(CommandMap commandMap) throws Exception{
		
        return reportService.selectAdminReportList(commandMap.getMap());
        
	}
	
	//신고 내역 디테일
	@ResponseBody 
	@RequestMapping(value="/Admin/reportDetail.do")
	public Map<String, Object> reportDetail(CommandMap commandMap) throws Exception{
		
        return reportService.selectAdminOneReport(commandMap.getMap());  
	}
	
	
	//신고 답변
		@RequestMapping(value="/Admin/reportComment.do")
		@ResponseBody 
		public void reportComment(CommandMap commandMap) throws Exception{
			
	        reportService.updateReportComment(commandMap.getMap());
			}
		
		
	//신고하기 삭제 - 일반회원 매핑
		@RequestMapping(value="/mypage/deleteReport.do")
		@ResponseBody 
		public void memDeleteReport(CommandMap commandMap) throws Exception{
			
			reportService.deleteReport(commandMap.getMap());
			
		}
		
	//신고하기 삭제 - 호스트회원 매핑
		@RequestMapping(value="/host/mypage/deleteReport.do")
		@ResponseBody 
		public void hostDeleteReport(CommandMap commandMap) throws Exception{
			
			reportService.deleteReport(commandMap.getMap());
			
		}
}
