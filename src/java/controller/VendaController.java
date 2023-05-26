package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Venda;
import model.VendaDAO;

@WebServlet(name = "VendaController", urlPatterns = {"/VendaController"})
public class VendaController extends HttpServlet {

    private int cod;
    private String nome;
    private String email;
    private String telefone;
    private String genero;
    private String nascimento;
    private String cidade;
    private String estado;
    private String endereco;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Verificando a existência de um código
        if (request.getParameter("cod") != null) {
            this.cod = Integer.parseInt(request.getParameter("cod"));
        }

        //Recebendo dados do formulário de cadastro
        this.nome = request.getParameter("nome");
        this.email = request.getParameter("email");
        this.telefone = request.getParameter("telefone");
        this.genero = request.getParameter("genero");
        this.nascimento = request.getParameter("nascimento");
        this.cidade = request.getParameter("cidade");
        this.estado = request.getParameter("estado");
        this.endereco = request.getParameter("endereco");
        

        try {
            VendaDAO exDao = new VendaDAO();
            
            if (request.getParameter("cod") == null) {
                Venda venda = new Venda(
                        this.nome,
                        this.email,
                        this.telefone,
                        this.genero,
                        this.nascimento,
                        this.cidade,
                        this.estado,
                        this.endereco
                );

                exDao.insertVenda(venda);
                
            } else {
                Venda venda = new Venda(
                        this.cod,
                        this.nome,
                        this.email,
                        this.telefone,
                        this.genero,
                        this.nascimento,
                        this.cidade,
                        this.estado,
                        this.endereco
                );

                exDao.updateVenda(venda);
                
            }
            
            response.sendRedirect("lista.jsp");
            
        } catch (SQLException | ClassNotFoundException erro) {

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Vendas</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Ocorreu um erro :( " + erro + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}