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
public class Exclui {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        /*
        //DESATIVA PESSOA
        long idPess = 5;
        String situacao = "DESATIVO";
        Pessoa pes = new Pessoa(idPess, null, null, null, null, situacao);

        PessoaControle pessCon = new PessoaControle();
        System.err.println(pes.getIdPessoa());

        try {
            pes = pessCon.desativarPessoa(pes);
        } catch (Exception e) {
            System.err.println(e);
        }
                */
        
        //EXCLUIR CLIENTE
        long idCli = 5;
        
        Cliente cli = new Cliente(idCli, null, null);
        
        ClienteControle cliCon = new ClienteControle();
        System.err.println(cli.getIdCliente());

        try {
            cli = cliCon.excliurCliente(cli);
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
        
    }

}
