package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Pizza;
import be.vdab.repositories.PizzaRepository;
import be.vdab.util.StringUtils;

// enkele imports ...
@WebServlet("/pizzas/toevoegen.htm")
public class PizzaToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/toevoegen.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/JSP/pizzas.jsp";
	private final PizzaRepository pizzaRepository = new PizzaRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		if (!Pizza.isNaamValid(naam)) {
			fouten.put("naam", "verplicht");
		}
		String prijsString = request.getParameter("prijs");
		BigDecimal prijs = null;
		if (StringUtils.isBigDecimal(prijsString)) {
			prijs = new BigDecimal(prijsString);
			if (!Pizza.isPrijsValid(prijs)) {
				fouten.put("prijs", "tik een positief getal");
			}
		} else {
			fouten.put("prijs", "tik een getal");
		}
		if (fouten.isEmpty()) {
			boolean pikant = "pikant".equals(request.getParameter("pikant"));
			pizzaRepository.create(new Pizza(naam, prijs, pikant));
			request.setAttribute("pizzas", pizzaRepository.findAll());
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}
}