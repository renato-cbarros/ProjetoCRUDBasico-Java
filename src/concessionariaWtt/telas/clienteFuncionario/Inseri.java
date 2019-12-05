/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.telas.clienteFuncionario;

import concessionariaWtt.controle.CarroControle;
import concessionariaWtt.controle.ClienteControle;
import concessionariaWtt.controle.FuncionarioControle;
import concessionariaWtt.controle.PedidoControle;
import concessionariaWtt.controle.PessoaControle;
import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
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
public class Inseri {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
         String login = JOptionPane.showInputDialog("Informe o Login: ");
         String senha = JOptionPane.showInputDialog("Informe o Senha: ");
         String status = JOptionPane.showInputDialog("Informe o Status: ");
         String tipo = JOptionPane.showInputDialog("Informe o Tipo: ");
         */

        /*
         //inseri pessoa
         String nome = "nome";
         String cpf = "12345678";
         String login = "login";
         String senha = "senha";
         String situacao = "situação";

         String cep = "04450010";
         String numero = "numero";
         String complemento = "complemento";

         String telFixo = "tel fixo";
         String telCelular = "tel celular";
         String email = "email";

         Pessoa pes = new Pessoa(null, nome, cpf, login, senha, situacao);
         long idPessoa = 0;
         Endereco ende = new Endereco(null, cep, numero, complemento, idPessoa);
         Contato conta = new Contato(null, telFixo, telCelular, email, idPessoa);

         PessoaControle pesCon = new PessoaControle();
         Pessoa p = pesCon.inseriPessoa(pes, ende, conta);
        
         JOptionPane.showMessageDialog(null, "Valor = " + p.toString());
         */
        
        /*
        // inseri funcionario
        String funcao = "funcao";
        long idPessoa = 5;
        
        Funcionario fun = new Funcionario(null, funcao, idPessoa);
        FuncionarioControle funCon = new FuncionarioControle();

        fun = funCon.inseriFuncionario(fun);

        JOptionPane.showMessageDialog(null, "Valor = " + fun.toString());
        */
        
        /*
        // inseri cliente
        String nivelDesc = "3";
        long idPessoa = 5;
        
        Cliente cli = new Cliente(null, nivelDesc, idPessoa);
        ClienteControle cliCon = new ClienteControle();

        cli = cliCon.inseriCliente(cli);

        JOptionPane.showMessageDialog(null, "Valor = " + cli.toString());
        */

        /*
         // inseri carro
         String modelo = "model";
         String marca = "marca";
         String ano = "ano";
         String cor = "cor";
         String valor = "valor";
        
         Carro car = new Carro(null, modelo, marca, ano, cor, valor);
         CarroControle carCon = new CarroControle();
        
         car = carCon.inseriCarro(car);
        
         JOptionPane.showMessageDialog(null, "Valor = " + car.toString());
        */
         
        /*
         //inseri pedido
         long idPedido = 0;
         String dtCompra = "dtCompra";
         String valor = "valor";
         String observacao = "observacao";
         String status = "status";

         long idFun = 2;
         long idCli = 2;
         long idCar = 4;

         Pedido ped = new Pedido(null, dtCompra, valor, observacao, status, idCar, idFun);
         PedidoControle pedCon = new PedidoControle();
         Funcionario fun = new Funcionario();
         Cliente cli = new Cliente();
         Carro car = new Carro();

         fun.setIdFuncionario(idFun);
         cli.setIdCliente(idCli);
         car.setIdCarro(idCar);

         ped = pedCon.inseriPedido(ped, cli, fun, car);

         JOptionPane.showMessageDialog(null, "Valor = " + ped.toString());
                */

         
    }

}
