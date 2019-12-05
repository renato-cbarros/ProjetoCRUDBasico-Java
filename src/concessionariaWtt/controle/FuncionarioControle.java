/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.controle;

import static concessionariaWtt.controle.ClienteControle.cliDao;
import concessionariaWtt.dao.ClienteDao;
import concessionariaWtt.dao.FuncionarioDao;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author renat
 */
public class FuncionarioControle {

    static FuncionarioDao funDao;
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

    public Funcionario inseriFuncionario(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        funDao = new FuncionarioDao();

        FuncionarioDao funDao = new FuncionarioDao();

        Funcionario funSai = new Funcionario();

        boolean valida = false;

        funSai = funDao.inseri(funEnt);
        if (funSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao inseri fun");
        } else {
            System.out.println("Erro ao inseri fun");
        }

        return funSai;
    }

    public Funcionario buscaFuncionario(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        funDao = new FuncionarioDao();

        Funcionario funSai = new Funcionario();

        boolean valida = false;

        funSai = funDao.busca(funEnt);
        if (funSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao buscar fun");
        } else {
            System.out.println("Erro ao buscar fun");
        }

        return funSai;
    }
    
    public List<Funcionario> listaFuncionario() throws SQLException, ClassNotFoundException {
        funDao = new FuncionarioDao();
        return funDao.lista();
    }    
    
    public Funcionario alterarFuncionario(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        funDao = new FuncionarioDao();

        Funcionario funSai = new Funcionario();

        boolean valida = false;

        funSai = funDao.altera(funEnt);
        if (funSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao alterar cli");
        } else {
            System.out.println("Erro ao alterar cli");
        }

        return funSai;
    } 
    
    /*
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
*/
}
