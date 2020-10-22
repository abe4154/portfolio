package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String forwardPass = null;

		if (action == null) {

			// 新規会員登録画面へ戻る
			forwardPass = "/WEB-INF/jsp/registerForm.jsp";
		} else if (action.equals("done")) {

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			RegisterUserLogic rug = new RegisterUserLogic();

			if (rug.execute(user)) {
				// 登録完了画面へフォワード
				forwardPass = "/WEB-INF/jsp/registerDone.jsp";
			} else {
				forwardPass = "/WEB-INF/jsp/registerForm.jsp";
			}

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPass);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータ取得
		String userID = request.getParameter("userID");
		String pass = request.getParameter("pass");
		String email = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// ユーザー型userインスタンスの取得
		User user = new User(userID, pass, email, name, age);

		// セッションンスコープ取得
		HttpSession session = request.getSession();
		// セッションスコープにuserインスタンスを格納
		session.setAttribute("user", user);

		// 登録内容確認画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);

	}

}
