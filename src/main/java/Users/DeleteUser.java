package Users;

import Sessions.ListSessions;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Servlets.InitServlet.CONTEXT_SESSIONS;
import static Servlets.InitServlet.CONTEXT_USERS;

@WebServlet(name = "DeleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();


        ListUsers users = (ListUsers) request.getServletContext().getAttribute(CONTEXT_USERS);
        ListSessions updatedSessions = new ListSessions();

        String username = request.getParameter("name");
        System.out.print("Get Param");
        users.remove(users.getUserByName(username));
        context.setAttribute(CONTEXT_SESSIONS, users);


        // rajouter la suppression du cloud firestore
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = db.collection("users").document(username).delete();

        request.getRequestDispatcher("UserManagement.jsp").forward(request, response);
    }
}
