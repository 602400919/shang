package cn.wh.shang.xxxx.service;

/**
 * 该类用于测试事物
 * @author Administrator
 *
 */
public interface TestTransactionService {

	/**
	 * 两个DB操作，先成功，再失败
	 */
	void testHalfSuccess() throws Exception;
	
}
