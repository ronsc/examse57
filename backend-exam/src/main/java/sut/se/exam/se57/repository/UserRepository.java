package sut.se.exam.se57.repository;

import org.springframework.data.repository.CrudRepository;

import sut.se.exam.se57.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	//method สำหรับ ค้นหา User ด้วย userName และ passWord
	public User findOneByUserNameAndPassWord(String userName, String passWord);
	
}
