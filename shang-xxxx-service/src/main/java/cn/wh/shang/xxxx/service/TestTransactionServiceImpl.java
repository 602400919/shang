package cn.wh.shang.xxxx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.wh.shang.common.User;
import cn.wh.shang.xxxx.mapper.UserMapper;

@Component("testTransactionService")
public class TestTransactionServiceImpl implements TestTransactionService {
	private static final Logger logger = LoggerFactory.getLogger(TestTransactionServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public void testHalfSuccess() throws Exception {
		userMapper.addUser(new User("success", 1));
		userMapper.addUser(new User("failure", 99999));
		logger.info("操作完成");
	}

}
