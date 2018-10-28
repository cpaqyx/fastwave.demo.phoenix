package fastwave.demo.phoenix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fastwave.demo.phoenix.entity.ResultEntity;
import fastwave.demo.phoenix.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @autor cp
 * @Date 2018/10/28
 */
@RequestMapping(value = {"/user/"}, produces="application/json;charset=UTF-8")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/createtable")
	public String createtable() {
		 userService.createtable();
		 return "创建成功";
	}

	@GetMapping(value = "/query")
	public List<Map<String, Object>> query() {
		List<Map<String, Object>> list = userService.query();
		return list;
	}

	@GetMapping(value = "/update")
	public ResultEntity update() {
		return userService.update();
	}

	@GetMapping(value = "/add")
	public ResultEntity add() {
		return userService.add();
	}

	@GetMapping(value = "/delete")
	public ResultEntity delete() {
		return userService.delete();
	}
}
