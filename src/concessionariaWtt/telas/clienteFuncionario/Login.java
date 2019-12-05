/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.telas.clienteFuncionario;

import concessionariaWtt.controle.PessoaControle;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ProfAlexandre
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String login = "login";
        String senha = "senha";
        String tipo = "C";

        Pessoa pesEnt = new Pessoa(null, null, null, login, senha, null);
        PessoaControle pesCon = new PessoaControle();

        Pessoa pesSai = new Pessoa();

        pesSai = pesCon.validaLogin(pesEnt, tipo);

        if (pesSai != null) {
            JOptionPane.showMessageDialog(null, "Login sucesso = " + pesSai.toString());
        }

    }

}
