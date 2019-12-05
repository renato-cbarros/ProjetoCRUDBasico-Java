/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.dao;

import concessionariaWtt.modelo.Endereco;
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
public class EnderecoDao {
    
    private final Connection c;
    
    public EnderecoDao() throws SQLException, ClassNotFoundException {
        this.c = new ConexaoDB().getConnection();
    }
    
    public Endereco busca(Endereco end) throws SQLException {
        String sql = "select * from endereco WHERE id_pessoa = ? or id_endereco = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        Pessoa pes = new Pessoa();
        pes = end.getPessoa();
        stmt.setLong(1, pes.getIdPessoa());
        if (end.getIdEndereco() == null) {
            long id = 0;
            end.setIdEndereco(id);
        }
        stmt.setLong(2, end.getIdEndereco());
        // executa
        ResultSet rs = stmt.executeQuery();
        Endereco retorno = null;
        while (rs.next()) {
            // criando o objeto pessoa
            retorno = new Endereco(
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
    public Endereco altera(Endereco end) throws SQLException {
        String sql = "UPDATE endereco SET CEP = ?, numero = ?, complemento = ?, id_pessoa = ? WHERE id_pessoa = ? or id_endereco = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, end.getCep());
        stmt.setString(2, end.getNumero());
        stmt.setString(3, end.getComplemento());
        Pessoa pes = new Pessoa();
        pes = end.getPessoa();
        stmt.setLong(4, pes.getIdPessoa());
        if (pes.getIdPessoa() == null) {
            long id = 0;
            pes.setIdPessoa(id);
        }
        if (end.getIdEndereco() == null) {
            long id = 0;
            end.setIdEndereco(id);
        }        
        stmt.setLong(5, pes.getIdPessoa());
        stmt.setLong(6, end.getIdEndereco());        

        // executa
        stmt.execute();
        stmt.close();
        return end;
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
    public List<Endereco> lista(Endereco endFEnt) throws SQLException {
        // usus: array armazena a lista de registros

        List<Endereco> end = new ArrayList<>();
        
        String sql = "select * from endereco";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            // criando o objeto Usuario
            Endereco ende = new Endereco(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getLong(5));
            // adiciona o pes à lista de pess
            end.add(ende);
        }
        
        rs.close();
        stmt.close();
        return end;
        
    }
    
    public Endereco inseri(Endereco end) throws SQLException {
        String sql = "INSERT INTO `concessionaria_wtt`.`endereco` (`CEP`, `numero`, `complemento`, `id_pessoa`) VALUES (?, ?, ?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1, end.getCep());
        stmt.setString(2, end.getNumero());
        stmt.setString(3, end.getComplemento());
        Pessoa pes = new Pessoa();
        pes = end.getPessoa();
        stmt.setLong(4, pes.getIdPessoa());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            long id = rs.getLong(1);
            end.setIdEndereco(id);
        }
        stmt.close();
        return end;
    }
    
}
