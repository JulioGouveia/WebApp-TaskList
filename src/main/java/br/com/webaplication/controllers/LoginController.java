package br.com.webaplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.webaplication.DAO.CreateUserDAO;
import br.com.webaplication.model.User;

@Controller
public class LoginController {

	@Autowired
	private CreateUserDAO createUserDao;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("login/createuser")
	public String create() {
		return "createUser";
	}

	@RequestMapping(value = "/login/user", method = RequestMethod.POST)
	public String loginUser() {
		
		System.out.println("sassasa");
		return "taskList";
	}

	@RequestMapping("/create")
	public String createUser(User user) {
		try {

			createUserDao.createUser(user);
			createUserDao.UsuarioRole(user);

			return "redirect: taskList";

		} catch (Exception e) {

			e.printStackTrace();

		}

		return "login";

	}
}
