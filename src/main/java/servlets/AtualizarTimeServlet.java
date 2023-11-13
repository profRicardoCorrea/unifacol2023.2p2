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

@WebServlet("/AtualizarTimeServlet")
public class AtualizarTimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String codigoStr = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String dataNascimentoStr = request.getParameter("dataNascimento");
        String tecnico = request.getParameter("tecnico");

        try {
            // Converta o código para um long (ou use outro tipo apropriado)
            long codigo = Long.parseLong(codigoStr);

            // Converta a data de nascimento de uma string para um objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataNascimento = dateFormat.parse(dataNascimentoStr);

            // Atualize os dados do objeto Time no banco de dados ou na lista de times
            // Implemente a lógica de atualização de acordo com o seu sistema de persistência
            // (JPA, Hibernate, JDBC, etc.)

            // Redirecione de volta para a página de listagem de times
            response.sendRedirect("ListarTimesServlet");
        } catch (NumberFormatException | ParseException e) {
            // Lide com exceções de conversão de dados ou qualquer outro erro de validação
            // Pode redirecionar de volta à página de edição com uma mensagem de erro, se necessário
            // response.sendRedirect("EditarTimeServlet?codigo=" + codigoStr + "&erro=true");
        }
    }
}
