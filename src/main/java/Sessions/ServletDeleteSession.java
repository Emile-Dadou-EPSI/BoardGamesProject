package Sessions;

import BDD.FireStore;
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
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static Servlets.InitServlet.CONTEXT_SESSIONS;

@WebServlet(name = "ServletDeleteSession")
public class ServletDeleteSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        FireStore fireStore = new FireStore();
        try {
            List<Session> sessions = fireStore.getSessions();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ListSessions Sessions = (ListSessions) request.getServletContext().getAttribute(CONTEXT_SESSIONS);
        ListSessions updatedSessions = new ListSessions();

        String name = request.getParameter("name");
        System.out.print("Get Param");
        System.out.print(name);
        Sessions.remove(Sessions.getSessionByName(name));
        context.setAttribute(CONTEXT_SESSIONS, Sessions);


        // rajouter la suppression du cloud firestore
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = db.collection("sessions").document(name).delete();

        request.getRequestDispatcher("LoggedPageAdmin.jsp").forward(request, response);
    }
}
