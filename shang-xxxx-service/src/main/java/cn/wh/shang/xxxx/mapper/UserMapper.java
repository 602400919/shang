package cn.wh.shang.xxxx.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.wh.shang.common.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM tbl_user WHERE id = #{id}")
	User findUser(@Param("id") Integer id);

	@Insert("INSERT INTO tbl_user(name,age) values (#{name}, #{age})")
	void addUser(User user);
	
	@Delete("DELETE FROM tbl_user where id=#{id}")
	int deleteUser(@Param("id") Integer id);
}
