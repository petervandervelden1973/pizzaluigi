package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.repositories.PizzaRepository;
import be.vdab.util.StringUtils;

@WebServlet("/pizzas/detail.htm")
public class PizzaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
	private final transient PizzaRepository pizzaRepository = new PizzaRepository();

	@Resource(name = PizzaRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		pizzaRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		if (StringUtils.isLong(idString)) {
			pizzaRepository.read(Long.parseLong(idString)).ifPresent(pizza -> request.setAttribute("pizza", pizza));
		} else {
			request.setAttribute("fout", "id niet correct");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
