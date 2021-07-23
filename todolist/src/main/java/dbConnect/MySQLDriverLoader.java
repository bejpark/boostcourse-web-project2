package dbConnect;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class MySQLDriverLoader {
	public void init(ServletConfig config) throws ServletException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}
}