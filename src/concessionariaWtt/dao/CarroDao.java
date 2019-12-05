/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Carro;
import concessionariaWtt.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renat
 */
public class CarroDao {
    
   private final Connection c;
    
    public CarroDao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public Carro busca(Carro car) throws SQLException{
        String sql = "select * from carro WHERE id_carro = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setLong(1, car.getIdCarro());
            // executa
            ResultSet rs = stmt.executeQuery();
            Carro retorno = null;
            while (rs.next()) {      
            // criando o objeto pessoa
                retorno = new Carro(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o pes à lista de pes
            }
            stmt.close();
        return retorno;
   }
    
/*
    public Usuario valida(Usuario usu) throws SQLException{
        // cria o select para ser executado no banco de dados 
        System.out.println("TESTE X");
        System.out.println("TESTE XX " + usu.getLogin());
        System.out.println("TESTE XXX " + usu.getSenha());
        
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usu.getLogin());
        stmt.setString(2,usu.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Usuario retorno = null;
        System.out.println("TESTE XXXX ");

        while (rs.next()) {    
            // criando o objeto Usuario
            System.out.println("TESTE XXXXX ");
            System.out.println("TESTE XXXXXX " + rs.getInt(1));

            retorno = new Usuario(
                    ""+rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return retorno;
    }
*/

    public Carro altera(Carro car) throws SQLException{
        String sql = "UPDATE carro SET modelo = ?, marca = ?, ano = ?, cor = ?, valor = ? WHERE id_carro = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, car.getModelo());
        stmt.setString(2, car.getMarca());
        stmt.setString(3, car.getAno());
        stmt.setString(4, car.getCor());
        stmt.setString(5, car.getValor());
        stmt.setLong(6, car.getIdCarro());

        // executa
        stmt.execute();
        stmt.close();
        return car;
    }
    
/*
    public Usuario exclui(Usuario usu) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,Integer.parseInt(usu.getIdUsu()));
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usu;
    }
*/
/*
    public Usuario validaLogin(Usuario usu) throws SQLException{
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,usu.getLogin());
        stmt.setString(2,usu.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Usuario retorno = null;
        while (rs.next()) {      
            // criando o objeto Usuario
            retorno = new Usuario(
                    ""+rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return retorno;
    }
*/    
    public List<Carro> lista() throws SQLException{
         // usus: array armazena a lista de registros

        List<Carro> carr = new ArrayList<>();
        
        String sql = "select * from carro";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Carro car = new Carro(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o pes à lista de pess
            carr.add(car);
        }
        
        rs.close();
        stmt.close();
        return carr;
    
    }

    public Carro inseri(Carro car) throws SQLException{
        String sql = "INSERT INTO `concessionaria_wtt`.`carro` (`modelo`, `marca`, `ano`, `cor`, `valor`) VALUES (?, ?, ?, ?, ?);";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, car.getModelo());
        stmt.setString(2, car.getMarca());
        stmt.setString(3, car.getAno());
        stmt.setString(4, car.getCor());
        stmt.setString(5, car.getValor());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            car.setIdCarro(id);
        }
        stmt.close();
        return car;
    }
    
}
