package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static Connection conn;
    
    public UserDAO() throws ClassNotFoundException, SQLException {
        conn = MyConnection.getConnection();
    }
    
    public User listOneUser(String nome) throws SQLException {
        String query = "SELECT * FROM usuarios "
                + "WHERE nome = ?";
        
        //Preparando a query para executar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, nome);
        
        ResultSet result = prep.executeQuery();
        
        User user = new User();
        
        if(result.next()){
            user.setUserCod(result.getInt("cod_usuario"));
            user.setUserName(result.getString("nome"));
            user.setUserPass(result.getString("senha"));
        }
        
        return user;
    }
}
