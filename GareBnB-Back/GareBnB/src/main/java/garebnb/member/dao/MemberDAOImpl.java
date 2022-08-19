package garebnb.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	protected Log log = LogFactory.getLog(MemberDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:  " + queryId);
		}
	}
	
	@Override // 일반 회원 상세 보기 
	public int selectMemberDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.selectMemberDetail", map); 
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectMemDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("member.selectMemDetail", map);
	}

	@Override
	public void insertMember(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember", map);
	}

	@Override
	public void updateOneMember(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateOneMember", map);
	}


	@Override
	public void updateOneMemberDelete(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateOneMemberDelete", map);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.selectMemberList", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectHostConfirmList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("member.selectHostConfirmList", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectConfirmMemberDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectList("member.selectConfirmMemberDetail", map);
	}

	@Override
	public void updateMemberDeny(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateMemberDeny", map);
	}


	@Override
	public void updateHostConfirm(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateHostConfirm", map);
	}


	@Override
	public void updateHostDeny(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateHostDeny", map);
	}
	
	@Override
	public void insertHostMem(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertHostMem", map);
	}

}
	
	
