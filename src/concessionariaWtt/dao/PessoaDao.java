/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

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
public class PessoaDao {

    private final Connection c;

    public PessoaDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }

    public Pessoa busca(Pessoa pes) throws SQLException {
        String sql = "select * from pessoa WHERE id_pessoa = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setLong(1, pes.getIdPessoa());
        // executa
        ResultSet rs = stmt.executeQuery();
        Pessoa retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new Pessoa(
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
     public Pessoa valida(Pessoa pes) throws SQLException{
     // cria o select para ser executado no banco de dados 
     System.out.println("TESTE X");
     System.out.println("TESTE XX " + pes.getLogin());
     System.out.println("TESTE XXX " + pes.getSenha());
        
     String sql = "select * from pessoa WHERE login = ? AND senha = ?";
     // prepared statement para seleção
     PreparedStatement stmt = this.c.prepareStatement(sql);
     // seta os valores
     stmt.setString(1,pes.getLogin());
     stmt.setString(2,pes.getSenha());
     // executa
     ResultSet rs = stmt.executeQuery();
     // percorrendo o rs
     Pessoa retorno = null;
     System.out.println("TESTE XXXX ");

     while (rs.next()) {    
     // criando o objeto Usuario
     System.out.println("TESTE XXXXX ");
     System.out.println("TESTE XXXXXX " + rs.getInt(1));

     retorno = new Pessoa(
     rs.getLong(1),
     rs.getString(2),
     rs.getString(3),
     rs.getString(4),
     rs.getString(5),
     rs.getString(6));
     // adiciona o usu à lista de usus
     }
     stmt.close();
     return retorno;
     }
     */
    public Pessoa altera(Pessoa pes) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, CPF = ?, login = ?, senha = ?, situacao = ? WHERE id_pessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, pes.getNome());
        stmt.setString(2, pes.getCpf());
        stmt.setString(3, pes.getLogin());
        stmt.setString(4, pes.getSenha());
        stmt.setString(5, pes.getSituacao());
        stmt.setLong(6, pes.getIdPessoa());

        // executa
        stmt.execute();
        stmt.close();
        return pes;
    }

    public Pessoa desativar(Pessoa pes) throws SQLException {
        String sql = "UPDATE pessoa SET situacao = ? WHERE id_pessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, pes.getSituacao());
        stmt.setLong(2, pes.getIdPessoa());

        // executa
        stmt.execute();
        stmt.close();
        return pes;
    }

    public Pessoa validaLogin(Pessoa pes) throws SQLException {
        // cria o select para ser executado no banco de dados 
        String sql = "select * from pessoa WHERE login = ? AND senha = ?";
        // prepared statement para seleção
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, pes.getLogin());
        stmt.setString(2, pes.getSenha());
        // executa
        ResultSet rs = stmt.executeQuery();
        // percorrendo o rs
        Pessoa retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new Pessoa(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return retorno;
    }

    public List<Pessoa> lista() throws SQLException {
        // usus: array armazena a lista de registros

        List<Pessoa> pess = new ArrayList<>();

        String sql = "select * from pessoa";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            Pessoa pes = new Pessoa(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o pes à lista de pess
            pess.add(pes);
        }

        rs.close();
        stmt.close();
        return pess;

    }

    public Pessoa inseri(Pessoa pes) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`pessoa` (`nome`, `CPF`, `login`, `senha`, `situacao`) VALUES (?, ?, ?, ?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, pes.getNome());
        stmt.setString(2, pes.getCpf());
        stmt.setString(3, pes.getLogin());
        stmt.setString(4, pes.getSenha());
        stmt.setString(5, pes.getSituacao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            pes.setIdPessoa(id);
        }
        stmt.close();
        return pes;
    }

}
