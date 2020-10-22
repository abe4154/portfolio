package dao;

import model.Account;
import model.Login;

public class AccountDAOTEST {

	public static void main(String[] args) {
		TestFindAccount1();
		TestFindAccount2();

	}

	public static void TestFindAccount1() {
		System.out.println("アカウントが見つかる場合のテスト実行");

		Login login = new Login("minatoon", "1234");

		
		AccountDAO accountDAO = new AccountDAO();

		Account account = accountDAO.findAc(login);

		if (account != null && account.getUserID().equals("minatoon") && account.getPass().equals("1234")
				&& account.getMail().equals("minato@sukkiri.com") && account.getName().equals("湊雄輔")
				&& account.getAge() == 23) {
			System.out.println("成功しました");

		} else {
			System.out.println("失敗です");
		}
	}

	public static void TestFindAccount2() {
		System.out.println("アカウントがみつからない場合のテスト実行");

		Login login = new Login("minatoon", "123456");

		AccountDAO accountDAO = new AccountDAO();

		Account account = accountDAO.findAc(login);
		if (account == null) {
			System.out.println("成功しました");
		} else {
			System.out.println("失敗しました");

		}

	}

}
