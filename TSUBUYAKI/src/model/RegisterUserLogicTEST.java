package model;

public class RegisterUserLogicTEST {

	public static void main(String[] args) {
		TEST1();
		TEST2();
	}

	// もれなくユーザー情報が記入されている場合
	public static void TEST1() {
		User user = new User("eref", "kinniku", "kinniku@gmail.com", "中山きんにくん", 37);
		RegisterUserLogic rul = new RegisterUserLogic();

		boolean result = rul.execute(user);

		if (result) {
			System.out.println("成功しています");
		} else {
			System.out.println("失敗です");
		}
	}

	// 入力漏れ、同じユーザーIDを用いた場合、文字制限を超えた入力があった場合(データベースに情報を登録できなかった場合)
	public static void TEST2() {
		User user = new User("eref", "kinniku", "kinniku@gmail.com", null, 37);
		RegisterUserLogic rul = new RegisterUserLogic();

		boolean result = rul.execute(user);

		if (!result) {
			System.out.println("成功しています");
		} else {
			System.out.println("失敗です");
		}
	}

}
