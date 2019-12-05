/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Funcionario;
import concessionariaWtt.modelo.Pedido;
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
public class PedidoDao {
    
    private final Connection c;
    
    public PedidoDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }
    
    public Pedido busca(Pedido ped) throws SQLException {
        String sql = "select * from pedido WHERE id_pedido = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        if (ped.getIdPedido() == null) {
            long id = 0;
            ped.setIdPedido(id);
        }
        stmt.setLong(1, ped.getIdPedido()); 
        
        // executa
        ResultSet rs = stmt.executeQuery();
        Pedido retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new Pedido(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(6),
                    rs.getLong(7));
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
    public Pedido altera(Pedido ped) throws SQLException {
        String sql = "UPDATE pedido SET dt_compra = ?, valor = ?, observacao = ?, status = ?, id_funcionario = ?, id_carro = ? WHERE id_pedido = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, ped.getDtCompra());
        stmt.setString(2, ped.getValor());
        stmt.setString(3, ped.getObservacao());
        stmt.setString(4, ped.getStatus());
        Funcionario fun = new Funcionario();
        fun = ped.getIdFuncionario();
        stmt.setLong(5, fun.getIdFuncionario());
        Carro car = new Carro();
        car = ped.getIdCarro();
        stmt.setLong(6, car.getIdCarro());
        stmt.setLong(7, ped.getIdPedido());
        
        // executa
        stmt.execute();
        stmt.close();
        return ped;
    }

    public Pedido exclui(Pedido ped) throws SQLException {
        String sql = "delete from pedido WHERE id_pedido = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setLong(1, ped.getIdPedido());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return ped;
    }
     
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
    public List<Pedido> lista() throws SQLException {
        // usus: array armazena a lista de registros

        List<Pedido> pedi = new ArrayList<>();
        
        String sql = "select * from pedido";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // criando o objeto Usuario
            Pedido ped = new Pedido(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(6),
                    rs.getLong(7));
            // adiciona o pes à lista de pess
            pedi.add(ped);
        }
        
        rs.close();
        stmt.close();
        return pedi;
        
    }
    
    public Pedido inseri(Pedido ped) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`pedido` (`dt_compra`, `valor`, `observacao`, `status`, `id_funcionario`, `id_carro`) VALUES (?, ?, ?, ?, ?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, ped.getDtCompra());
        stmt.setString(2, ped.getValor());
        stmt.setString(3, ped.getObservacao());
        stmt.setString(4, ped.getStatus());
        Funcionario fun = new Funcionario();
        fun = ped.getIdFuncionario();
        stmt.setLong(5, fun.getIdFuncionario());
        Carro car = new Carro();
        car = ped.getIdCarro();
        stmt.setLong(6, car.getIdCarro());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            ped.setIdPedido(id);
        }
        stmt.close();
        return ped;
    }
    
}
