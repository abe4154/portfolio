package model;

import java.util.List;

import dao.MutterDAO;

@SuppressWarnings("unused")
public class PostMutterLogic {

	public void execute(Mutter mutter) {
		MutterDAO mutterDAO = new MutterDAO();

		mutterDAO.create(mutter);
	}
}
