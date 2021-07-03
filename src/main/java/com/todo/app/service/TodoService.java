package com.todo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.app.dao.TodoDao;
import com.todo.app.entity.Todo;

@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;


    public Todo add(Todo todo){
        todoDao.add(todo);
		return todo;

    }
    

    
    

}
