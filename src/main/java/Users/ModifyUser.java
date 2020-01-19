package Users;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static Servlets.InitServlet.CONTEXT_USERS;

@WebServlet(name = "ModifyUser")
public class ModifyUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();

        // Recherche dans firebase de l'user
        ListUsers users = new ListUsers();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> futureuser = db.collection("users").get();
        List<QueryDocumentSnapshot> docsUsers = null;

        try {
            docsUsers = futureuser.get().getDocuments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (QueryDocumentSnapshot docuser : docsUsers) {
            String email = docuser.getData().get("Email").toString();
            String username = docuser.getData().get("UserName").toString();
            String password = docuser.getData().get("Password").toString();
            String mode = docuser.getData().get("Mode").toString();

            users.add(new User(email, username, password, mode));
        }

        User user = (User) request.getServletContext().getAttribute("user");

        String newEmail = request.getParameter("email");
        System.out.println(newEmail);
        String newUsername = request.getParameter("id");
        System.out.println(newUsername);
        String newPassword = request.getParameter("password");
        System.out.println(newPassword);
        String newMode = request.getParameter("mode");
        System.out.println(newMode);

        if (newEmail == null) {
            newEmail = user.email;
        }
        if (newUsername == null) {
            newUsername = user.username;
        }
        if (newPassword == null) {
            newPassword = user.password;
        }
        if (newMode == null) {
            newMode = user.type;
        }

        User updateUser = new User(newEmail, newUsername, newPassword, newMode);

        // Update firestore database
        ListUsers USERS = (ListUsers) request.getServletContext().getAttribute(CONTEXT_USERS);
        USERS.remove(user);
        USERS.add(updateUser);

        Map<String, Object> data = new HashMap<>();
        data.put("Email", updateUser.email);
        data.put("UserName", updateUser.username);
        data.put("Password", updateUser.password);
        data.put("Mode", updateUser.type);

        ApiFuture<WriteResult> res = db.collection("users").document(updateUser.username).set(data);
        ApiFuture<WriteResult> writeResultApiFuture = db.collection("users").document(user.username).delete();
        context.setAttribute(CONTEXT_USERS, USERS);
        context.setAttribute("USER", updateUser);
        if (updateUser.type == "admin") {
            request.getRequestDispatcher("LoggedPageAdmin.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("LoggedPage.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
