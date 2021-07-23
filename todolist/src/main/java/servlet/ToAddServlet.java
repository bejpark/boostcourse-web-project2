package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class ToAddServlet
 */
@WebServlet("/ToAddServlet")
public class ToAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TodoDao dao = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddServlet() {
        super();
        dao = new TodoDao();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDto dto = new TodoDto();
		System.out.print("ccc");

		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		System.out.print("ccc");

		String name = request.getParameter("name");
		System.out.print("ccc");

		System.out.print(name);
		System.out.print(title);

		System.out.print("ddd");
		int sequence = Integer.parseInt(request.getParameter("priority"));
		System.out.print(sequence);

		dto.setTitle(title);
		dto.setName(name);
		dto.setSequence(sequence);
		dao.addTodo(dto);
		System.out.print("eee");

		response.sendRedirect("./MainServlet");
	}

}
