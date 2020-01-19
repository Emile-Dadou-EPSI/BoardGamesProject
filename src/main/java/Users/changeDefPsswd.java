package Users;

import BDD.FireStore;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "Users.changeDefPsswd")
public class changeDefPsswd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String mdp = request.getParameter("password");
        String newPassword = request.getParameter("Npassword");

        Firestore db = FirestoreClient.getFirestore();

        DocumentReference docref = db.collection("users").document(username);
        ApiFuture<DocumentSnapshot> future = docref.get();
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            User user = FireStore.getUserName(username);

            if (document.exists()) {
                if (user.username.equals(username) && user.password.equals(mdp)) {
                    user.setPassword(newPassword);
                    Map<String, Object> data = new HashMap<>();
                    data.put("UserName", user.username);
                    data.put("Password", user.password);
                    data.put("Mode", user.type);

                    ApiFuture<WriteResult> res = db.collection("users").document(user.username).set(data);
                }
            }


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/LoggedPage.html").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
