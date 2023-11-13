package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Time;

@WebServlet("/AdicionarTimeServlet")
public class AdicionarTimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String nome = request.getParameter("nome");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        String tecnico = request.getParameter("tecnico");
       
        try {
            // Converta a data de nascimento de uma string para um objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataNascimento = dateFormat.parse(dataNascimentoStr);

            // Crie um novo objeto Time com os dados recebidos
            Time novoTime = new Time(nome, tecnico, dataNascimento);

            // Adicione o novo time ao banco de dados ou à lista de times
            // Implemente a lógica de adição de acordo com o seu sistema de persistência
            // (JPA, Hibernate, JDBC, etc.)

            // Redirecione de volta para a página de listagem de times
            response.sendRedirect("ListarTimesServlet");
        } catch (ParseException e) {
            // Lide com exceções de conversão de dados ou qualquer outro erro de validação
            // Pode redirecionar de volta à página de cadastro com uma mensagem de erro, se necessário
            // response.sendRedirect("CadastroTime.jsp?erro=true");
        }
    }
}
