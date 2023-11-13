package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Time;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TimeServlet")
public class TimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simulando um banco de dados temporário
    private List<Time> times = new ArrayList<>();

    public TimeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("listar".equals(acao)) {
            listarTimes(request, response);
        } else if ("editar".equals(acao)) {
            editarTime(request, response);
        } else {
            // Trate outros casos conforme necessário
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("cadastrar".equals(acao)) {
            cadastrarTime(request, response);
        } else if ("alterar".equals(acao)) {
            alterarTime(request, response);
        } else {
            // Trate outros casos conforme necessário
        }
    }

    private void cadastrarTime(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        Date dataNascimento = null; // Converta a string em Date conforme necessário

        // Crie um novo time com os dados fornecidos
        Time time = new Time(nome, dataNascimento);

        // Adicione o time à lista simulada do banco de dados
        times.add(time);

        // Redirecione de volta à lista de times
        response.sendRedirect("TimeServlet?acao=listar");
    }

    private void alterarTime(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        Date dataNascimento = null; // Converta a string em Date conforme necessário

        // Recupere o índice do time a ser alterado
        int indice = Integer.parseInt(request.getParameter("indice"));

        // Atualize os dados do time
        Time time = times.get(indice);
        time.setNome(nome);
        time.setDataNascimento(dataNascimento);

        // Redirecione de volta à lista de times
        response.sendRedirect("TimeServlet?acao=listar");
    }

    private void listarTimes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("times", times);
        request.getRequestDispatcher("listar_times.jsp").forward(request, response);
    }

    private void editarTime(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int indice = Integer.parseInt(request.getParameter("indice"));
        Time time = times.get(indice);
        request.setAttribute("time", time);
        request.setAttribute("indice", indice);
        request.getRequestDispatcher("editar_time.jsp").forward(request, response);
    }
}
