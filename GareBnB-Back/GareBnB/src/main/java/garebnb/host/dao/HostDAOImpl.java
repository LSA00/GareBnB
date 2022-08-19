package garebnb.host.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("hostDAO")
public class HostDAOImpl implements HostDAO {
	
	protected Log log = LogFactory.getLog(HostDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	 
	protected void printQueryId(String queryId) { 
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:  " + queryId);
		}
	}

	@Override
	public Map<String, Object> selectHostDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("host_member.selectHostDetail", map);
	}

	@Override
	public void updateOneHost(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("host_member.updateOneHost",map);
	}
	
	@Override
	public void updateHostMem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("host_member.updateHostMem",map);
	}
	
	@Override
	public void insertHostMem(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("host_member.insertHostMem", map);
	}

	@Override
	public List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("host_member.selectHostConfirmList", map);
	}

	@Override
	public void updateOneMemberDelete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("host_member.updateOneMemberDelete",map);
	}

	@Override
	public Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("host_member.selectConfirmMemberDetail", map);
	}

	@Override
	public void updateHostConfirm(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("host_member.updateHostConfirm",map);
	}

	@Override
	public void updateHostDeny(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("host_member.updateHostDeny",map);
	}

	
	
}
