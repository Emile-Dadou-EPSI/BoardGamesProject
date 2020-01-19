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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static Servlets.InitServlet.CONTEXT_SESSIONS;

@WebServlet(name = "ModifySession")
public class ModifySession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("out0");
        String oldName = request.getParameter("oldname");
        String newname = request.getParameter("id");
        String date = request.getParameter("date");
        String horaireD = request.getParameter("HeureDeb");
        String horaireF = request.getParameter("HeureFin");
        try {
            System.out.println("out1");
            Date newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Session sessiontoupdate = new Session(newname, newDate, horaireD, horaireF);
            ListSessions Sessions = (ListSessions) request.getServletContext().getAttribute(CONTEXT_SESSIONS);
            Sessions.remove(Sessions.getSessionByName(oldName));
            System.out.println("out2");
            System.out.println(oldName);
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> writeResultApiFuture1 = db.collection("sessions").document(oldName).delete();
            System.out.println("out3");
            Map<String, Object> data = new HashMap<>();
            data.put("ID", sessiontoupdate.name);
            data.put("Date", sessiontoupdate.date);
            data.put("HeureDebut", sessiontoupdate.hD);
            data.put("HeureFin", sessiontoupdate.hF);

            ApiFuture<WriteResult> res = db.collection("sessions").document(sessiontoupdate.name).set(data);

            Sessions.add(sessiontoupdate);
            context.setAttribute(CONTEXT_SESSIONS, Sessions);
            request.getRequestDispatcher("LoggedPageAdmin.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
