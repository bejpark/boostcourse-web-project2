package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbConnect.ConnectionProvider;
import dto.TodoDto;

public class TodoDao {
	
	public int addTodo(TodoDto dto) {
		String query = "insert into todo(title,name,sequence) values(?,?,?)";
		
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement st = conn.prepareStatement(query)){
			st.setString(1, dto.getTitle());
			st.setString(2, dto.getName());
			st.setInt(3, dto.getSequence());
			return st.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public List<TodoDto> getTodos(){
		List<TodoDto> list = new ArrayList();
		String query = "select id, title, name, sequence, type, date_format(regdate,'%Y.%m.%d') as date from todo order by regdate";
		
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement st = conn.prepareStatement(query);
				ResultSet rs = st.executeQuery()){
			while(rs.next()) {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("date"));
				dto.setSequence(rs.getInt("sequence"));
				dto.setTitle(rs.getString("title"));
				dto.setType(rs.getString("type"));
				list.add(dto);
			}
			return list;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public int updateTodo(int id, String type) {
		String query = "update todo set type = ? where id = ?";
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement st = conn.prepareStatement(query)){
			st.setString(1, type);
			st.setLong(2, id);
			return st.executeUpdate();
		}catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}
}
