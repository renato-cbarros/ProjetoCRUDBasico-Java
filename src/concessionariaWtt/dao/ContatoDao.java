/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Contato;
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
public class ContatoDao {

    private final Connection c;

    public ContatoDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Contato busca(Contato cont) throws SQLException {
        String sql = "select * from contato WHERE id_pessoa = ? or id_contato = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        Pessoa pes = new Pessoa();
        pes = cont.getPessoa();
        stmt.setLong(1, pes.getIdPessoa());
        if (cont.getIdContato() == null) {
            long id = 0;
            cont.setIdContato(id);
        }
        stmt.setLong(2, cont.getIdContato());
        // executa
        ResultSet rs = stmt.executeQuery();
        Contato retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new Contato(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getLong(5));
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
    public Contato altera(Contato cont) throws SQLException {
        String sql = "UPDATE contato SET tel_fixo = ?, tel_celular = ?, email = ? WHERE id_pessoa = ? or id_contato = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, cont.getTelFixo());
        stmt.setString(2, cont.getTelCelular());
        stmt.setString(3, cont.getEmail());
        Pessoa pes = new Pessoa();
        pes = cont.getPessoa();
        stmt.setLong(4, pes.getIdPessoa());
        if (cont.getIdContato() == null) {
            long id = 0;
            cont.setIdContato(id);
        }
        stmt.setLong(5, cont.getIdContato());

        // executa
        stmt.execute();
        stmt.close();
        return cont;
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
    public List<Contato> lista(Contato contFEnt) throws SQLException {
        // usus: array armazena a lista de registros

        List<Contato> cont = new ArrayList<>();

        String sql = "select * from contato";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Contato conta = new Contato(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getLong(5));
            // adiciona o pes à lista de pess
            cont.add(conta);
        }

        rs.close();
        stmt.close();
        return cont;

    }

    public Contato inseri(Contato cont) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`contato` (`tel_fixo`, `tel_celular`, `email`, `id_pessoa`) VALUES (?, ?, ?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, cont.getTelFixo());
        stmt.setString(2, cont.getTelCelular());
        stmt.setString(3, cont.getEmail());
        Pessoa pes = new Pessoa();
        pes = cont.getPessoa();
        stmt.setLong(4, pes.getIdPessoa());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            cont.setIdContato(id);
        }
        stmt.close();
        return cont;
    }

}

