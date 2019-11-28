package cn.wh.shang.xxxx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.wh.shang.common.User;
import cn.wh.shang.xxxx.mapper.UserMapper;
import cn.wh.shang.xxxx.service.TestTransactionService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private TestTransactionService testTransactionService; 
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/find")
	public String findUser(@RequestParam("id") Integer id) {
		User user = userMapper.findUser(id);
		logger.debug("查找到对象, id={},user={}", id, user);
		return user==null?"对象不存在":user.toString();
	}

	@RequestMapping("/add")
	public String addUser(@RequestParam("name") String name, @RequestParam("age") int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		userMapper.addUser(user);
		logger.info("新增对象. name={}, age={}， user={}",name, age, user);
		return user.toString();
	}
	
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer id) {
		int rows = userMapper.deleteUser(id);
		logger.warn("删除对象, id={}", id);
		return rows==1? "删除成功":"删除失败";
	}
	
	@RequestMapping("/txtest")
	public String txtest() {
		try {
			testTransactionService.testHalfSuccess();			
		} catch (Exception e) {
			logger.error("DB操作发生异常", e);
		}
		logger.info("txtest over!");
		return "txtest";
	}
	
}
