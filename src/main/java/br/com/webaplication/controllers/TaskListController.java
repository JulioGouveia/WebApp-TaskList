package br.com.webaplication.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.webaplication.DAO.CreateUserDAO;
import br.com.webaplication.DAO.TaskDAO;
import br.com.webaplication.model.Task;
import br.com.webaplication.model.User;

@Controller
@RequestMapping("/taskList")
public class TaskListController {

	@Autowired
	private TaskDAO taskDao;

	@Autowired
	private CreateUserDAO createUserDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(String email) throws Exception {
		ModelAndView modelAndView = new ModelAndView("taskList");

		email = "julio@gouveia.com";
		User user = createUserDao.find(email);

			List<Task> list = taskDao.list(user.getEmail());

			if (!list.isEmpty()) {
				modelAndView.addObject("allTasks", list);
				
				return new ModelAndView("taskList");
			}

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createNewTask(String taskName, String email) {
		ModelAndView modelAndView = new ModelAndView("redirect:taskList");

		Calendar calendar = Calendar.getInstance();
		String formatedDate = new SimpleDateFormat("dd/MM/yyyy : HH:mm").format(calendar.getTime());

		email = "julio@gouveia.com";
		User user = createUserDao.find(email);

		Task task = new Task();
		task.setTaskName(taskName);
		task.setUser(user);
		task.setDate(formatedDate);

		taskDao.createNewTask(task);

		return modelAndView;
	}

}
