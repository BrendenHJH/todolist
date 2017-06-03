package kr.or.connect.todo.domain;

public class Todo {
	private int id;
	private String todo;
	private int completed;
	private String date;
	private int todoTotalNum;

	public Todo(){	
	}

	public Todo(String todo) {
		this.todo = todo;
	}
	public Todo(int id, String todo, int completed, String date) {
		this.id = id;
		this.todo = todo;
		this.completed = completed;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getTodoTotalNum() {
		return todoTotalNum;
	}

	public void setTodoTotalNum(int todoTotalNum) {
		this.todoTotalNum = todoTotalNum;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todo=" + todo + ", completed=" + completed
				+ ", date=" + date + ", todoTotalNum=" + todoTotalNum + "]";
	}

}
