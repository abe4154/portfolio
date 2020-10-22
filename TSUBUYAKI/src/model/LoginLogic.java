package model;

import dao.AccountDAO;

public class LoginLogic {

	public boolean execute(Login login) {
		AccountDAO accountDAO = new AccountDAO();

		Account account = accountDAO.findAc(login);

		// アカウントがnullならばfalse,アカウントに情報があればtrue
		return account != null;
	}

}
