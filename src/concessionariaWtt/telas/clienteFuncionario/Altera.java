/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.telas.clienteFuncionario;

import concessionariaWtt.controle.ClienteControle;
import concessionariaWtt.controle.PessoaControle;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Contato;
import concessionariaWtt.modelo.Endereco;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class Altera {
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        
        //ALTERAR PESSOA
        long idPessoa = 10;
         String nome = "João Paulo";
         String cpf = "123456710";
         String login = "joao";
         String senha = "1210";
         String situacao = "ATIVO";

         String cep = "04950011";
         String numero = "2";
         String complemento = "c10";

         String telFixo = "11 5656-6565";
         String telCelular = "11 91010-1010";
         String email = "joao@joao.com";
         
         Pessoa pes = new Pessoa(idPessoa, nome, cpf, login, senha, situacao);
         Endereco ende = new Endereco(null, cep, numero, complemento, idPessoa);
         Contato conta = new Contato(null, telFixo, telCelular, email, idPessoa);

         PessoaControle pesCon = new PessoaControle();
         Pessoa p = pesCon.alteraPessoa(pes, ende, conta);
        
         JOptionPane.showMessageDialog(null, "Valor = " + p.toString());
         */
        
        // inseri cliente
        String nivelDesc = "1";
        long idCli = 2;
        long idPess = 5;
        
        Cliente cli = new Cliente(idCli, nivelDesc, idPess);
        ClienteControle cliCon = new ClienteControle();

        cli = cliCon.alterarCliente(cli);

        JOptionPane.showMessageDialog(null, "Valor = " + cli.toString());        
    }
}
