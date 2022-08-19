package garebnb.login.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import garebnb.login.loginDAO.LoginDAO;
import garebnb.qna.dao.QnaDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	

	@Override
	public Map<String, Object> selectOneId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectOneId(map);
	}
	
	public Map<String, Object> selectOnePw(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectOnePw(map);
	}
	
	@Override
	public void updateOnePw(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		loginDAO.updateOnePw(map);
	}
	
	@Override
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectId(map);
	}
	
	@Override
	public Map<String, Object> selectAuth(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectAuth(map);
	}
	
	@Override
	public Map<String, Object> selectIDCheck(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDAO.selectIDCheck(map);
	}
	
	


}
