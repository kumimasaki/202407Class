// 必要なライブラリを導入
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// HttpServlet クラスを継承
public class HelloWorld extends HttpServlet {
	
	private String message;
	
	public void init() throws ServletException {
		// 初期化処理
		message = "Hello World";
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リスポンスのタイプを設定
		response.setContentType("text/html");

		// println() メソッドで HTML を出力
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}

	public void destroy() {
		// 終了時の処理
	}
}
