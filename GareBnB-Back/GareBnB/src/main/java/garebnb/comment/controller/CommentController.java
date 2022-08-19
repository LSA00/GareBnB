package garebnb.comment.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import garebnb.comment.service.CommentService;

@Controller
public class CommentController {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="commentService")
	private CommentService commentservice;
}
