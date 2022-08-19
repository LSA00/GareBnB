package garebnb.report.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import garebnb.report.dao.ReportDAO;

@Service("reportService")
public class ReportServiceImpl implements ReportService{
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="reportDAO")
	private ReportDAO reportDAO;

	@Override
	public List<Map<String, Object>> selectOneReportList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.selectOneReportList(map);
	}
	
	
	@Override
	public void insertReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reportDAO.insertReport(map);
	}
	
	
	@Override
	public void insertHostReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reportDAO.insertHostReport(map);
	}

	@Override
	public List<Map<String, Object>> selectAdminReportList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.selectAdminReportList(map);
	}

	@Override
	public Map<String, Object> selectAdminOneReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.selectAdminOneReport(map);
	}

	@Override
	public void updateReportComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reportDAO.updateReportComment(map);
		
	}


	@Override
	public Map<String, Object> selectDetailReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.selectDetailReport(map);
	}


	@Override
	public void deleteReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reportDAO.deleteReport(map);
		
	}



}
