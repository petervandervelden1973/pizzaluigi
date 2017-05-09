package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headers.htm")
public class HeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/headers.jsp";
	private final Map<String, String> browsers = new HashMap<>();

	public HeadersServlet() {
		browsers.put("firefox", "Firefox");
		browsers.put("chrome", "Chrome");
		browsers.put("msie", "Internet Explorer");
		browsers.put("trident", "Internet Explorer");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userAgent = request.getHeader("user-agent").toLowerCase();
		browsers.entrySet().stream().filter(entry -> userAgent.contains(entry.getKey())).findFirst()
				.ifPresent(browser -> request.setAttribute("browser", browser));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}