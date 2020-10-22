package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterLogic;
import model.Login;
import model.Mutter;
import model.PostMutterLogic;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// つぶやきリストを取得して、リクエストスコープに保存
		GetMutterLogic getMutterLogic = new GetMutterLogic();
		List<Mutter> mutterList = getMutterLogic.execute();
		request.setAttribute("mutterList", mutterList);

		// セッションスコープのユーザー情報を取得
		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");

		if (login != null) {
			// main画面(jsp)へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		} else if (login == null) {
			// Top画面へリダイレクト
			response.sendRedirect("/TSUBUYAKI/WelcomeServlet");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		if (text != null && text.length() != 0) {

			// セッションスコープから、ユーザー情報取得
			HttpSession session = request.getSession();
			Login login = (Login) session.getAttribute("login");

			// つぶやきリストにつぶやきを保存
			Mutter mutter = new Mutter(login.getUserID(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

		} else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		GetMutterLogic getMutterlogic = new GetMutterLogic();
		List<Mutter> mutterList = getMutterlogic.execute();
		request.setAttribute("mutterList", mutterList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
