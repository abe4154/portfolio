package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterLogic {

	public List<Mutter> execute() {
		MutterDAO mutterDAO = new MutterDAO();
		List<Mutter> mutterList = mutterDAO.findAll();
		return mutterList;
	}
}
