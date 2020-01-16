import java.io.IOException;
import java.util.concurrent.ExecutionException;

@javax.servlet.annotation.WebServlet(name = "Login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //RequestDispatcher rd = null;
        String Login = request.getParameter("login");
        String mdp = request.getParameter("password");
        FireStore fireStore = new FireStore();
        try {
            User user = fireStore.getUserName(Login);
            if (user.username.equals(Login) && user.password.equals(mdp)) {
                request.getRequestDispatcher("LoggedPage.html").forward(request, response);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
