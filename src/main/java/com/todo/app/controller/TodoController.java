package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todo.app.entity.Todo;
import com.todo.app.dao.TodoDao;

@Controller
public class TodoController {

	@Autowired
	TodoDao todoDao;

	@RequestMapping(value="/")
	public String index(Model model) {

//		List<Todo> list = todoMapper.selectAll();

		List<Todo> list = todoDao.selectIncomplete();
		List<Todo> doneList = todoDao.selectComplete();
		model.addAttribute("todos",list);
		model.addAttribute("doneTodos",doneList);

		return "index";
	}

	@RequestMapping(value="/add")
	@ResponseBody
	public Todo add(Todo todo) {
		todoDao.add(todo);
		return todo;
	}

	@RequestMapping(value="/update")
	@ResponseBody
	public void update(Todo todo) {
		todoDao.update(todo);
	}

	@RequestMapping(value="/delete")
	@ResponseBody
	public void delete() {
		todoDao.delete();
	}

}
