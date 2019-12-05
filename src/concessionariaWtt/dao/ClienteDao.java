/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Pessoa;
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
public class ClienteDao {

    private final Connection c;

    public ClienteDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Cliente busca(Cliente cli) throws SQLException {
        String sql = "select * from cliente WHERE id_pessoa = ? or id_cliente = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        Pessoa pes = new Pessoa();
        pes = cli.getIdPessoa();
        if (pes.getIdPessoa() == null) {
            long id = 0;
            pes.setIdPessoa(id);
        }
        stmt.setLong(1, pes.getIdPessoa());
        if (cli.getIdCliente() == null) {
            long id = 0;
            cli.setIdCliente(id);
        }
        stmt.setLong(2, cli.getIdCliente());
        // executa
        ResultSet rs = stmt.executeQuery();
        Cliente retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new Cliente(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getLong(3));
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
    public Cliente altera(Cliente cli) throws SQLException {
        String sql = "UPDATE cliente SET nivel_desconto = ?, id_pessoa = ? WHERE id_cliente = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, cli.getNivelDesconto());
        Pessoa pes = new Pessoa();
        pes = cli.getIdPessoa();
        stmt.setLong(2, pes.getIdPessoa());
        stmt.setLong(3, cli.getIdCliente());

        // executa
        stmt.execute();
        stmt.close();
        return cli;
    }

    public Cliente exclui(Cliente cli) throws SQLException {
        String sql = "delete from cliente WHERE id_pessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setLong(1, cli.getIdCliente());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return cli;
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
    public List<Cliente> lista() throws SQLException {
        // usus: array armazena a lista de registros

        List<Cliente> clie = new ArrayList<>();

        String sql = "select * from cliente";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Cliente cli = new Cliente(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getLong(3));
            // adiciona o pes à lista de pess
            clie.add(cli);
        }

        rs.close();
        stmt.close();
        return clie;

    }

    public Cliente inseri(Cliente cli) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`cliente` (`nivel_desconto`, `id_pessoa`) VALUES (?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, cli.getNivelDesconto());
        Pessoa pes = new Pessoa();
        pes = cli.getIdPessoa();
        stmt.setLong(2, pes.getIdPessoa());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            cli.setIdCliente(id);
        }
        stmt.close();
        return cli;
    }

}
