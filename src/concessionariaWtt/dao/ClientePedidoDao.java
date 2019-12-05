/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.ClientePedido;
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
public class ClientePedidoDao {

    private final Connection c;

    public ClientePedidoDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public ClientePedido busca(ClientePedido cliP) throws SQLException {
        String sql = "select * from cliente_pedido WHERE id_pedido = ? or id_cliente = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        Pedido ped = new Pedido();
        ped = cliP.getIdPedido();
        if (ped.getIdPedido() == null) {
            long id = 0;
            ped.setIdPedido(id);
        }
        stmt.setLong(1, ped.getIdPedido());
        Cliente cli = new Cliente();
        cli = cliP.getIdCliente();
        if (cliP.getIdCliente() == null) {
            long id = 0;
            cli.setIdCliente(id);
        }
        stmt.setLong(2, cli.getIdCliente());
        
        // executa
        ResultSet rs = stmt.executeQuery();
        ClientePedido retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new ClientePedido(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3));
            // adiciona o pes à lista de pes
        }
        stmt.close();
        return retorno;
    }
    
     public Pedido exclui(Pedido ped) throws SQLException{
     String sql = "delete from cliente_pedido WHERE id_pedido = ?";
     // prepared statement para inserção
     PreparedStatement stmt = c.prepareStatement(sql);
     // seta os valores
     stmt.setLong(1,ped.getIdPedido());
     // executa
     stmt.execute();
     stmt.close();
     c.close();
     return ped;
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
    public ClientePedido altera(ClientePedido cliP) throws SQLException {
        String sql = "UPDATE cliente_pedido SET id_cliente = ?, id_pedido = ? WHERE id_cliente_pedido = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        Cliente cli = new Cliente();
        cli = cliP.getIdCliente();
        stmt.setLong(1, cli.getIdCliente());
        Pedido ped = new Pedido();
        ped = cliP.getIdPedido();
        stmt.setLong(2, ped.getIdPedido());
        stmt.setLong(3, cliP.getIdClientePedido());

        // executa
        stmt.execute();
        stmt.close();
        return cliP;
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
    public List<ClientePedido> lista(ClientePedido cliPEnt) throws SQLException {
        // usus: array armazena a lista de registros

        List<ClientePedido> cliPed = new ArrayList<>();

        String sql = "select * from cliente_pedido";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            ClientePedido cliP = new ClientePedido(
                    rs.getLong(1),
                    rs.getLong(2),
                    rs.getLong(3));
            // adiciona o pes à lista de pess
            cliPed.add(cliP);
        }

        rs.close();
        stmt.close();
        return cliPed;

    }

    public ClientePedido inseri(ClientePedido cliP) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`cliente_pedido` (`id_cliente`, `id_pedido`) VALUES (?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        Cliente cli = new Cliente();
        cli = cliP.getIdCliente();
        stmt.setLong(1, cli.getIdCliente());
        Pedido ped = new Pedido();
        ped = cliP.getIdPedido();
        stmt.setLong(2, ped.getIdPedido());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            cliP.setIdClientePedido(id);
        }
        stmt.close();
        return cliP;
    }

}
