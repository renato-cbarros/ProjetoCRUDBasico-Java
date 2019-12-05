/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.controle;

import static concessionariaWtt.controle.PessoaControle.pesDao;
import concessionariaWtt.dao.CarroDao;
import concessionariaWtt.dao.ClienteDao;
import concessionariaWtt.dao.ClientePedidoDao;
import concessionariaWtt.dao.ContatoDao;
import concessionariaWtt.dao.EnderecoDao;
import concessionariaWtt.dao.FuncionarioDao;
import concessionariaWtt.dao.PedidoDao;
import concessionariaWtt.dao.PessoaDao;
import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.ClientePedido;
import concessionariaWtt.modelo.Contato;
import concessionariaWtt.modelo.Endereco;
import concessionariaWtt.modelo.Funcionario;
import concessionariaWtt.modelo.Pedido;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author renat
 */
public class PedidoControle {

    static PedidoDao pedDao;
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

    public Pedido inseriPedido(Pedido pedEnt, Cliente cliEnt, Funcionario funEnt, Carro carEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        ClientePedidoDao cliPedDao = new ClientePedidoDao();

        Pedido pedSai = new Pedido();
        ClientePedido cliPedSai = new ClientePedido();

        boolean valida = false;

        pedEnt.setIdFuncionario(funEnt);
        pedEnt.setIdCarro(carEnt);

        pedSai = pedDao.inseri(pedEnt);
        if (pedSai != null) {
            ClientePedido cliPedEnt = new ClientePedido();
            cliPedEnt.setIdPedido(pedSai);
            cliPedEnt.setIdCliente(cliEnt);

            cliPedSai = cliPedDao.inseri(cliPedEnt);
            if (cliPedSai != null) {
                valida = true;
            }
        }

        if (valida) {
            System.out.println("Sucesso ao inseri pessoa");
        } else {
            System.out.println("Erro ao inseri pessoa");
        }

        return pedSai;
    }

    public Pedido buscaPedido(Pedido pedEnt, Funcionario funEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();

        Pedido pedSai = new Pedido();
        Funcionario funSai = new Funcionario();

        boolean valida = false;

        pedEnt.setIdFuncionario(funEnt);

        pedSai = pedDao.busca(pedEnt);
        if (pedSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao buscar pessoa");
        } else {
            System.out.println("Erro ao buscar pessoa");
        }

        return pedSai;
    }

    public ClientePedido buscaClientePedido(Pedido pedEnt, Cliente cliEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        ClientePedidoDao cliPedDao = new ClientePedidoDao();

        ClientePedido cliPedEnt = new ClientePedido();

        Pedido pedSai = new Pedido();
        ClientePedido cliPedSai = new ClientePedido();

        boolean valida = false;

        cliPedEnt.setIdPedido(pedEnt);
        cliPedEnt.setIdCliente(cliEnt);

        cliPedSai = cliPedDao.busca(cliPedEnt);
        System.out.print(cliPedSai.getIdCliente());
        if (cliPedSai != null) {
            pedSai = buscaPedido(cliPedSai.getIdPedido(), null);
            if (pedSai != null) {
                valida = true;
            }
        }

        if (valida) {
            System.out.println("Sucesso ao buscar cliPed");
        } else {
            System.out.println("Erro ao buscar cliPed");
        }

        return cliPedSai;
    }

    public List<Pedido> listaPedido() throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        return pedDao.lista();
    }

    public Pedido alteraPedido(Pedido pedEnt, Cliente cliEnt, Funcionario funEnt, Carro carEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        ClientePedidoDao cliPedDao = new ClientePedidoDao();

        Pedido pedSai = new Pedido();
        ClientePedido cliPedSai = new ClientePedido();

        boolean valida = false;

        pedEnt.setIdFuncionario(funEnt);
        pedEnt.setIdCarro(carEnt);

        pedSai = pedDao.altera(pedEnt);
        if (pedSai != null) {
            ClientePedido cliPedEnt = new ClientePedido();
            cliPedEnt = buscaClientePedido(pedEnt, cliEnt);

            cliPedEnt.setIdCliente(cliEnt);
            cliPedEnt.setIdPedido(pedSai);

            cliPedSai = cliPedDao.altera(cliPedEnt);
            if (cliPedSai != null) {
                valida = true;
            }
        }

        if (valida) {
            System.out.println("Sucesso ao alterar ped");
        } else {
            System.out.println("Erro ao alterar ped");
        }

        return pedSai;
    }

    public Pedido excluiPedido(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        
        ClientePedidoDao cliPedDao = new ClientePedidoDao();
        Pedido pedSai = new Pedido();
        
        pedSai = cliPedDao.exclui(pedEnt);
        if (pedSai != null) {
            pedDao.exclui(pedEnt);
        }
        
        return pedSai;
    }

    /*
     public Usuario alteraUsuario(Usuario usuEnt) throws SQLException, ClassNotFoundException {
     usuDao = new UsuarioDao();
     return usuDao.altera(usuEnt);
     }
     */
}
