/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.telas.clienteFuncionario;

import concessionariaWtt.controle.ClienteControle;
import concessionariaWtt.controle.PessoaControle;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class Lista {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        //lista pessoa
        PessoaControle pesCont = new PessoaControle();
        List<Pessoa> pessoas = pesCont.listaPesoa();
        for(Pessoa p : pessoas) {
            JOptionPane.showMessageDialog(null, "Valor = " + p.toString());
        }
        */
        
        //lista pessoa
        ClienteControle cliCont = new ClienteControle();
        List<Cliente> clientes =(cliCont.listaCliente());
        for(Cliente c : clientes) {
            JOptionPane.showMessageDialog(null, "Valor = " + c.toString());
        }
        
    }
}
