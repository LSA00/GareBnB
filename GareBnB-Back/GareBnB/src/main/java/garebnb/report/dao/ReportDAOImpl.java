package garebnb.report.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("reportDAO")
public class ReportDAOImpl implements ReportDAO{
	
	protected Log log = LogFactory.getLog(ReportDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:  " + queryId);
		}
	}

	//개인 신고 내역
	@Override
	public List<Map<String, Object>> selectOneReportList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("report.selectOneReportList", map);
	}

	//일반회원 -> 호스트 신고 입력
	@Override
	public void insertReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("report.insertReport", map);		
	}	
	
	//호스트 -> 일반회원 신고입력
	@Override
	public void insertHostReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("report.insertHostReport", map);
	}
	
	//관리자 - 신고 리스트
	@Override
	public List<Map<String, Object>> selectAdminReportList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("report.selectAdminReportList", map);
	}

	//관리자 - 신고 디테일
	@Override
	public Map<String, Object> selectAdminOneReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("report.selectAdminOneReport", map);
	}

	//관리자 - 신고 답글
	@Override
	public void updateReportComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("report.updateReportComment", map);
	}

	//일반, 호스트 신고 상세보기
	@Override
	public Map<String, Object> selectDetailReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("report.selectDetailReport", map);
	}

	//일반, 호스트 신고글 삭제하기
	@Override
	public void deleteReport(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("report.deleteReport",map);
	}


}
