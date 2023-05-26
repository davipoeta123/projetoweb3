<%-- 
    Document   : lista
    Created on : 23 de mai. de 2023, 20:10:44
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Venda" %>
<%@page import="model.VendaDAO" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Minhas vendas</title>
  <link rel="stylesheet" href="formulário.css">
</head>

<body>
  <div class="box">
      <fieldset>
        <legend><b>Listagem de Vendas</b></legend>
        <br>
        <table border="1" style="width: 100%;">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Nascimento</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Endereço</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    VendaDAO venDao = new VendaDAO();
                    
                    for(Venda v : venDao.listVenda()) {
                %>
                <tr>
                    <td><%= v.getNome() %></td>
                    <td><%= v.getEmail() %></td>
                    <td><%= v.getTelefone() %></td>
                    <td><%= v.getNascimento() %></td>
                    <td><%= v.getCidade() %></td>
                    <td><%= v.getEstado() %></td>
                    <td><%= v.getEndereco() %></td>
                    <td>📝</td>
                    <td>❌</td>
                </tr>
                <% } %>
            </tbody>
        </table>
      </fieldset>
      
    </form>
  </div>
</body>

</html>