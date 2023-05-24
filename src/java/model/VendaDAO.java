package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDAO {
    private static Connection conn;
    
    public VendaDAO() throws ClassNotFoundException, SQLException {
        conn = MyConnection.getConnection();
    }
    
    //Métodos CRUD para a tabela "vendas" do BD
    public void insertVenda(Venda ex) {
        //Query genérica
        String sql = "INSERT INTO vendas(nome, email, telefone, sexo, nascimento, cidade, estado, endereco)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        //Objeto que preparará a query para enviar ao BD
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, ex.getNome());
            prep.setString(2, ex.getEmail());
            prep.setString(3, ex.getTelefone());
            prep.setString(4, ex.getSexo());
            prep.setString(5, ex.getNascimento());
            prep.setString(6, ex.getCidade());
            prep.setString(7, ex.getEstado());
            prep.setString(8, ex.getEndereco());
            
            prep.execute();
            prep.close();
            
        } catch(SQLException erro) {
            System.out.println("Erro no insert :(" + erro);
        }
    }//Fim do insert
    
    
    //Listar os registros do BD
    public ArrayList<Venda> listVenda() throws SQLException{
       ArrayList<Venda> list = new ArrayList<>();
       
       String sql = "select * from vendas"; 
       
       PreparedStatement prep = conn.prepareStatement(sql);
       ResultSet result =  prep.executeQuery();
       
       while(result.next()){
           Venda ex = new Venda();
           
           ex.setCodVenda(result.getInt("cod_venda"));
           ex.setNome(result.getString("nome"));
           ex.setEmail(result.getString("email"));
           ex.setTelefone(result.getString("telefone"));
           ex.setSexo(result.getString("sexo"));
           ex.setNascimento(result.getString("nascimento"));
           ex.setCidade(result.getString("cidade"));
           ex.setEstado(result.getString("estado"));
           ex.setEndereco(result.getString("endereco"));
           
           list.add(ex);
       }
       
       return list;
    }//Fim do método list
    
    
    //Excluir registros do BD
    public void deleteVenda(int id) throws SQLException{
        String sql = "delete from vendas where cod_venda = " + id;
        
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.execute();
        prep.close();
    }
    
    
    //Atualizar registros no BD
    public void updateVenda(Venda ex) throws SQLException {
        //Query genérica
        String query = "UPDATE vendas SET nome = ?, email = ?, telefone = ?, sexo = ?, nascimento = ?, cidade = ?, estado = ?, endereco = ? WHERE cod_venda = ?";
        
        //Preparando a query para ser executada no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Trocando as interrogações por seus respectivos valores
        prep.setString(1, ex.getNome());
        prep.setString(2, ex.getEmail());
        prep.setString(3, ex.getTelefone());
        prep.setString(4, ex.getSexo());
        prep.setString(5, ex.getNascimento());
        prep.setString(6, ex.getCidade());
        prep.setString(7, ex.getEstado());
        prep.setString(8, ex.getEndereco());
        prep.setInt(9, ex.getCodVenda());
        
        //Executando a query pronta no BD
        prep.execute();
        prep.close();
    }
    
    
    //Selecionar um registro apenas
    public Venda listOneVenda(int i) throws SQLException {
        //Query para selecionar apenas um registro
        String query = "SELECT * FROM vendas "
                + "WHERE cod_venda = " + i ;
        
        //Preparando a query para executar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        //Executando a query e lançando o resultado
        //no objeto result, da classe ResultSet
        ResultSet result = prep.executeQuery();
        
        //Criando um objeto vazio da classe Venda
        Venda ex = new Venda();
        //Caso obtenha algum registro do BD, o objeto "ex"
        //será preenchido com os respectivos valores
        if(result.next()){
           ex.setCodVenda(result.getInt("cod_venda"));
           ex.setNome(result.getString("nome"));
           ex.setEmail(result.getString("email"));
           ex.setTelefone(result.getString("telefone"));
           ex.setSexo(result.getString("sexo"));
           ex.setNascimento(result.getString("nascimento"));
           ex.setCidade(result.getString("cidade"));
           ex.setEstado(result.getString("estado"));
           ex.setEndereco(result.getString("endereco"));
        }
        //Retornando o objeto da classe Venda
        return ex;
    }
    
}//Fim da classe
