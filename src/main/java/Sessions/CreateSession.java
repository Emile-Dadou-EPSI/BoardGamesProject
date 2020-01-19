package Sessions;

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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static Servlets.InitServlet.CONTEXT_SESSIONS;

@WebServlet(name = "Sessions.CreateSession")
public class CreateSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String target = request.getParameter("date");
        Date date = null;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = df.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = new Session(request.getParameter("id"), date, request.getParameter("hD"), request.getParameter("hF"));

        Firestore db = FirestoreClient.getFirestore();

        // Add document data with id "test"
        Map<String, Object> data = new HashMap<>();
        data.put("ID", session.name);
        data.put("Date", session.date);
        data.put("HeureDebut", session.hD);
        data.put("HeureFin", session.hF);

        ApiFuture<WriteResult> res = db.collection("sessions").document(session.name).set(data);
        ListSessions Sessions = (ListSessions) request.getServletContext().getAttribute(CONTEXT_SESSIONS);
        Sessions.add(session);
        context.setAttribute(CONTEXT_SESSIONS, Sessions);
        request.getRequestDispatcher("LoggedPageAdmin.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
