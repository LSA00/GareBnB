package garebnb.comment.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import garebnb.comment.dao.CommentDAO;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="commentDAO")
	private CommentDAO commentDAO;
}
