package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ログイン画面用ビューにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String pass = request.getParameter("pass");

		Login login = new Login(userID, pass);

		LoginLogic loginLogic = new LoginLogic();

		boolean jd = loginLogic.execute(login);

		if (jd) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);

			// ログイン成功画面用ビューにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/TSUBUYAKI/LoginServlet");
		}

	}

}
