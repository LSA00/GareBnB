package garebnb.report.service;

import java.util.List;
import java.util.Map;

public interface ReportService {

	//report One list
	List<Map<String, Object>> selectOneReportList(Map<String, Object> map) throws Exception;
	
	//mem -> host report insert
	void insertReport(Map<String, Object> map) throws Exception;
	
	//host -> mem report insert
	void insertHostReport(Map<String, Object> map) throws Exception;
		
	//Admin report list
	List<Map<String, Object>> selectAdminReportList(Map<String, Object> map) throws Exception;
	
	//Admin report detail
	Map<String, Object> selectAdminOneReport(Map<String, Object> map) throws Exception;

	//Admin report comment
	void updateReportComment(Map<String, Object> map) throws Exception;

	//Detail report
	Map<String, Object> selectDetailReport(Map<String, Object> map) throws Exception;

	void deleteReport(Map<String, Object> map) throws Exception;

	



}
