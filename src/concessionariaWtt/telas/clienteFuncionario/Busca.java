/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.telas.clienteFuncionario;

import com.mysql.cj.xdevapi.Client;
import concessionariaWtt.controle.CarroControle;
import concessionariaWtt.controle.ClienteControle;
import concessionariaWtt.controle.FuncionarioControle;
import concessionariaWtt.controle.PedidoControle;
import concessionariaWtt.controle.PessoaControle;
import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.ClientePedido;
import concessionariaWtt.modelo.Contato;
import concessionariaWtt.modelo.Endereco;
import concessionariaWtt.modelo.Funcionario;
import concessionariaWtt.modelo.Pedido;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class Busca {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
         //buscar pessoa especifica chamada
         long idPess = 5;
         Pessoa pes = new Pessoa(idPess, null, null, null, null, null);
         Endereco ende = new Endereco();
         Contato conta = new Contato();

         PessoaControle pessCon = new PessoaControle();
         System.err.println(pes.getIdPessoa());

         try {
         pes = pessCon.buscaPessoa(pes);
         } catch (Exception e) {
         System.err.println(e);
         }

         if (pes != null) {
         try {
         ende.setPessoa(pes);
         ende = pessCon.buscaEndereco(pes);
         if (ende != null) {
         conta.setPessoa(pes);
         conta = pessCon.buscaContato(pes);
         if (conta != null) {
         System.out.println("Busca de pessoa bem sucedida + Valor: " + pes.toString() + " ende " + ende.toString() + " conta " + conta.toString());

         }
         }
         } catch (Exception e) {
         System.err.println(e);
         }
         }
         

        /*
         //busca fun
         long idFun = 1;
         
         Funcionario fun = new Funcionario(idFun, null, null);
         FuncionarioControle funCon = new FuncionarioControle();
         
         fun = funCon.buscaFuncionario(fun);
         
         if (fun != null) {
         System.err.println("Valor " + fun.toString() + " cargo " + fun.getFuncao());
         }
         */
        /*
         //busca cli
         long idCli = 2;
         
         Cliente cli = new Cliente(idCli, null, null);
         ClienteControle cliCon = new ClienteControle();
         
         cli = cliCon.buscaCliente(cli);
         
         if (cli != null) {
         System.err.println("Valor " + cli.toString() + " cargo " + cli.getNivelDesconto());
         }
         */
        /*
         //busca car
         long idCar = 1;
         
         Carro car = new Carro(idCar, null, null, null, null, null);
         CarroControle carCon = new CarroControle();
         
         car = carCon.buscaCarro(car);
         
         if (car != null) {
         System.err.println("Valor " + car.toString() + " cargo " + car.getModelo());
         }
         */
         /*
        //busca car
        long id = 1;

        Pedido ped = new Pedido(null, null, null, null, null, null, null);
        Funcionario fun = new Funcionario(id, null, null);
        Cliente cli = new Cliente(id, null, null);
        PedidoControle pedCon = new PedidoControle();

        //busca ped ou fun
        //ped = pedCon.buscaPedido(ped, fun);
        //busca ped ou cli
        ped = pedCon.buscaClientePedido(ped, cli);

        if (ped != null) {
            System.err.println("Valor " + ped.toString() + " cargo " + ped.getObservacao());
        }
                 */
        
                    long idPe = 2;

            Pedido pedSai = new Pedido();
            ClientePedido cliPedSai = new ClientePedido();
            Funcionario funSai = new Funcionario(idPe, null, null);
            Cliente cliSai = new Cliente(idPe, null, null);
            Carro carSai = new Carro();

            PedidoControle pedCon = new PedidoControle();

            pedSai = new Pedido(idPe, null, null, null, null, null, null);
                pedSai = new Pedido(idPe, null, null, null, null, null, null);
                //try {
                    pedSai = pedCon.buscaPedido(pedSai, funSai);
                    funSai = pedSai.getIdFuncionario();
                    carSai = pedSai.getIdCarro();
               // } catch (Exception e) {
                   // pedSai = null;
                    //System.err.println(e);
                //}

               // if (pedSai != null) {
                  //  try {
                        cliPedSai.setIdPedido(pedSai);
                        cliPedSai = pedCon.buscaClientePedido(pedSai, cliSai);

                        System.out.print(cliPedSai.getIdCliente());
    }
}
