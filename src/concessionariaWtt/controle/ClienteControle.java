/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.controle;

import static concessionariaWtt.controle.PessoaControle.pesDao;
import concessionariaWtt.dao.ClienteDao;
import concessionariaWtt.dao.PessoaDao;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Funcionario;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author renat
 */
public class ClienteControle {

    static ClienteDao cliDao;
    /* 
     public Usuario validaLogin(Usuario usuEnt) throws SQLException, ClassNotFoundException {
     usuDao = new UsuarioDao();
     if (usuDao.valida(usuEnt) == null) {
     System.out.println("LOGIN INVALIDO PAE :(");
     }
     return usuDao.valida(usuEnt);
     }
     */
    /*
     public List<Usuario> listaUsuario(Usuario usuEnt) throws SQLException, ClassNotFoundException {
     usuDao = new UsuarioDao();
     return usuDao.lista(usuEnt);    
     }
     */

    public Cliente inseriCliente(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        cliDao = new ClienteDao();

        Cliente cliSai = new Cliente();

        boolean valida = false;

        cliSai = cliDao.inseri(cliEnt);
        if (cliSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao inseri cli");
        } else {
            System.out.println("Erro ao inseri cli");
        }

        return cliSai;
    }

    public Cliente buscaCliente(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        cliDao = new ClienteDao();

        Cliente cliSai = new Cliente();

        boolean valida = false;

        cliSai = cliDao.busca(cliEnt);
        if (cliSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao buscar cli");
        } else {
            System.out.println("Erro ao buscar cli");
        }

        return cliSai;
    }

    public List<Cliente> listaCliente() throws SQLException, ClassNotFoundException {
        cliDao = new ClienteDao();
        return cliDao.lista();
    }    
    
    public Cliente alterarCliente(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        cliDao = new ClienteDao();

        Cliente cliSai = new Cliente();

        boolean valida = false;

        cliSai = cliDao.altera(cliEnt);
        if (cliSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao alterar cli");
        } else {
            System.out.println("Erro ao alterar cli");
        }

        return cliSai;
    } 
    
    public Cliente excliurCliente(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        cliDao = new ClienteDao();

        Cliente cliSai = new Cliente();

        boolean valida = false;

        cliSai = cliDao.exclui(cliEnt);
        if (cliSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao excluir cli");
        } else {
            System.out.println("Erro ao excluir cli");
        }

        return cliSai;
    }    
    
    
}

