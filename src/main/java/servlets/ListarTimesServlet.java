package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Time;

@WebServlet("/ListarTimesServlet")
public class ListarTimesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Simule a obtenção da lista de times do banco de dados ou de qualquer outra fonte de dados
        ArrayList<Time> listaTimes = obterListaDeTimes();

        // Armazene a lista de times no escopo da solicitação para acessá-la na página JSP
        request.setAttribute("listaTimes", listaTimes);

        // Encaminhe a solicitação para a página JSP de listagem de times
        request.getRequestDispatcher("ListarTimes.jsp").forward(request, response);
    }

    private ArrayList<Time> obterListaDeTimes() {
        // Implemente a lógica para obter a lista de times do seu sistema de persistência (JPA, Hibernate, JDBC, etc.)
        // Neste exemplo, apenas uma lista fictícia é retornada
        ArrayList<Time> listaTimes = new ArrayList<>();
        listaTimes.add(new Time("Time A", "Técnico A", new Date()));
        listaTimes.add(new Time("Time B", "Técnico B", new Date()));
        listaTimes.add(new Time("Time C", "Técnico C", new Date()));
        return listaTimes;
    }
}

