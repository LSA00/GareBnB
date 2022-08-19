package garebnb.report.dao;

import java.util.List;
import java.util.Map;

public interface ReportDAO {
	
	public List<Map<String, Object>> selectOneReportList(Map<String, Object> map) throws Exception;
	
	public void insertReport(Map<String, Object> map) throws Exception;
	
	public void insertHostReport(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> selectAdminReportList(Map<String, Object> map) throws Exception;

	public Map<String, Object> selectAdminOneReport(Map<String, Object> map) throws Exception;

	public void updateReportComment(Map<String, Object> map) throws Exception;

	public Map<String, Object> selectDetailReport(Map<String, Object> map) throws Exception;

	public void deleteReport(Map<String, Object> map) throws Exception;

}
