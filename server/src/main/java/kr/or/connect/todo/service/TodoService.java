package kr.or.connect.todo.service;

import java.util.Collection;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.persistence.TodoDao;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private TodoDao dao;
	
	public TodoService(TodoDao dao) {
		this.dao = dao;
	}
	public Todo insert(Todo todo) {
		int id = dao.insert(todo);
		todo.setId(id);
		return todo;
	}
	public Collection<Todo> findAll() {
		return dao.selectAll();
	}
	public Collection<Todo> findActiveAll() {
		return dao.selectActiveAll();
	}
	public Collection<Todo> findCompletedAll() {
		return dao.selectCompletedAll();
	}
	public Todo update(Todo todo) {
		int id = dao.update(todo);
		return todo;
	}
	public Todo delete(Todo todo) {
		int id = dao.deleteById(todo.getId());
		return todo;
	}
	public void deleteCompletedTask() {
		int id = dao.deleteByCompletedNum();
	}
	public int countTodos() {
		int countNum = dao.countTodos();
		return countNum;
	}
}
