package kr.or.connect.todo.persistence;

public class TodoSqls {
	static final String INSERT = 
			"INSERT INTO todo(todo, completed) values(:todo, :completed)";
	static final String SELECT_BY_ID =
			"SELECT id, todo FROM todo where id = :id";
	static final String SELECT_ALL =
			"SELECT id, todo, completed, date FROM todo";
	static final String SELECT_ACTIVE =
			"SELECT id, todo, completed, date FROM todo WHERE completed = 0";
	static final String SELECT_COMPLETED =
			"SELECT id, todo, completed, date FROM todo WHERE completed = 1";
	static final String UPDATE_COMPLETION =
			"UPDATE todo SET\n"
			+ "completed = :completed\n"
			+ "WHERE id = :id";
	static final String DELETE_BY_ID =
			"DELETE FROM todo WHERE id= :id";
	static final String DELETE_BY_COMPLETED_NUM =
			"DELETE FROM todo WHERE completed= 1";
	static final String COUNT_TODO = "SELECT COUNT(*) FROM todo WHERE completed = 0";
}
