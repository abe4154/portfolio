package model;

import dao.RegisterUserDAO;

public class RegisterUserLogic {

	public boolean execute(User user) {
		RegisterUserDAO rud = new RegisterUserDAO();
		boolean result = rud.ResistUser(user);

		return result;
	}
}
