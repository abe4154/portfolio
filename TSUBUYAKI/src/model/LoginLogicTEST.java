package model;

public class LoginLogicTEST {

	public static void main(String[] args) {

		TEST1();
		TEST2();

	}

	public static void TEST1() {
		Login login = new Login("minatoon", "1234");
		LoginLogic loginLogic = new LoginLogic();

		boolean judge = loginLogic.execute(login);

		if (judge) {
			System.out.println("成功しました");
		} else {
			System.out.println("失敗しました");
		}

	}

	public static void TEST2() {
		Login login = new Login("minatoon", "123456");
		LoginLogic loginLogic = new LoginLogic();
		boolean judge = loginLogic.execute(login);

		if (!judge) {
			System.out.println("成功しました");
		} else {
			System.out.println("失敗しました");

		}

	}
}
