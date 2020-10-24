# portfolio

Twiiterのような簡易SNSを作成しました。

〇主な機能
・新規会員登録
・ログイン
・つぶやき投稿(時系列に各アカウントが投稿した文章を表示)

〇開発環境
エディタ、実行環境：Eclipse IDE for Java Developers (Version: 2020-09 (4.17.0))
WEBサーバー、Servletコンテナ：Apache Tomcat (v8.5)
RDBMS：MySQL (Ver 14.14 Distrib 5.7.31, for Win64)
<補助ツール>
A5:SQL Mk-2(Version 2.15.2)→データベース管理用

〇TSUBUYAKIフォルダに、作成したWEBアプリケーションのソースコードが保管されています。
　<ソースコードは下記のように保存されています>
　　・TSYBUYAKI---src---modelパッケージ、daoパッケージ、servletパッケージ
　　・TSYBUYAKI---WebContent---css
　　・TSYBUYAKI---WebContent---WEB-INF---jsp
  
  *ServletパッケージのWelcomeServlet.javaでアプリ起動
  
〇学べたこと
・WEBアプリの基本(画面遷移、スコープ、フォーム)
・jdbc、SQL文を用いた、データベースとのやりとりの方法
・HTML、CSSに関する基本知識(今回はバックエンド側に9割時間を使っていますが）
・簡単にでもアーキテクチャを作成し、イメージをアウトプットしてからコーディングにとりかかると
スムーズにコードが書けるという経験ができた。
・開発環境、ツールをそろえるところから始めてWEBアプリ形をにするまで一貫した制作ができたこと
で、プログラミングにおいて、自身のできることできないことが明確になった。
