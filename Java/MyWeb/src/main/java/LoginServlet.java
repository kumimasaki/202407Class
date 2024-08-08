import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(
            HttpServletRequest request, 
            HttpServletResponse response
    ) throws SecurityException, IOException {
        // login.html -> <form> -> <input> の name 属性で指定されたデータを獲得
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html");
        out.println("<html><body><p>");
        
        // ユーザーネームとパスワードの正当性をチェック
        if("admin".equals(username) && "admin".equals(password)) {
        	out.println("ログインしました。お帰りなさい、" + username + "。");
        } else {
            out.println("ユーザー名またはパスワードが正しくありません。");
        }
        out.println("</p></body></html>");
    }
}