package kr.or.connect.todo.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import kr.or.connect.todo.domain.Todo;
import kr.or.connect.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoService service;
	
	@Autowired
	public TodoController(TodoService service) {
		this.service = service;
	}	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Todo insert(@RequestBody Todo todo) {	
		//date null 해결.
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datetime = sdf1.format(cal.getTime());
		todo.setDate(datetime);	
		return service.insert(todo);
	}
	@GetMapping
	Collection<Todo> readList() {
		return service.findAll();
	}
	@GetMapping("/active")
	Collection<Todo> readActiveList() {
		return service.findActiveAll();
	}
	@GetMapping("/completed")
	Collection<Todo> readCompletedList() {
		return service.findCompletedAll();
	}
	@GetMapping("/count")
	Integer countLeftedTasks() {
		return service.countTodos();
	}
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@RequestBody Todo todo) {
		service.update(todo);
	}
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	Todo delete(@RequestBody Todo todo) {
		return service.delete(todo);
	}
	@DeleteMapping("/clear")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCompletedTask() {
		service.deleteCompletedTask();
	}
}
