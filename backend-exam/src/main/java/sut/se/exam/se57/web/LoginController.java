package sut.se.exam.se57.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sut.se.exam.se57.domain.User;
import sut.se.exam.se57.repository.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/login/{user}/{pass}", method = RequestMethod.GET)
	@ResponseBody
	public User login(@PathVariable("user") String userName, @PathVariable("pass") String passWord) {
		//@PathVariable("user") String userName เป็นการเอาค่าที่ได้จาก {user} ใน path มาเก็บไว้ในตัวแปร userName
		//@PathVariable("pass") String passWord เป็นการเอาค่าที่ได้จาก {pass} ใน path มาเก็บไว้ในตัวแปร passWord
		
		/* userRepository.findOneByUserNameAndPassWord(userName, passWord);
		 * เป็นการค้นหา User จาก userName และ passWord 
		 * ถ้าเจอใน database จะ return เป็น Object ของ User
		 * ถ้าไม่เจอจะ return กลับเป็น NULL */
		return userRepository.findOneByUserNameAndPassWord(userName, passWord);
	}
}
