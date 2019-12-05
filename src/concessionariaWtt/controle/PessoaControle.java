/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.controle;

import concessionariaWtt.dao.ClienteDao;
import concessionariaWtt.dao.ContatoDao;
import concessionariaWtt.dao.EnderecoDao;
import concessionariaWtt.dao.FuncionarioDao;
import concessionariaWtt.dao.PessoaDao;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Contato;
import concessionariaWtt.modelo.Endereco;
import concessionariaWtt.modelo.Funcionario;
import concessionariaWtt.modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author renat
 */
public class PessoaControle {

    static PessoaDao pesDao;

    public Pessoa validaLogin(Pessoa pesEnt, String tipo) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();

        Pessoa pesSai = new Pessoa();

        pesSai = pesDao.validaLogin(pesEnt);
        if (pesSai != null && pesSai.getSituacao().equals("ATIVO")) {
            if (tipo.equals("F")) {
                Funcionario fun = new Funcionario();
                fun.setIdPessoa(pesSai);
                FuncionarioControle funCon = new FuncionarioControle();

                fun = funCon.buscaFuncionario(fun);
                if (fun != null) {
                    System.out.println("LOGIN fun encontrado");
                } else {
                    pesSai = null;
                    System.out.println("LOGIN INVALIDO PAE :(");
                }

            } else if (tipo.equals("C")) {
                Cliente cli = new Cliente();
                cli.setIdPessoa(pesSai);
                ClienteControle cliCon = new ClienteControle();

                cli = cliCon.buscaCliente(cli);
                if (cli != null) {
                    System.out.println("LOGIN cli encontrado");
                } else {
                    pesSai = null;
                    System.out.println("LOGIN INVALIDO PAE :(");
                }
            } else {
                pesSai = null;
                System.out.println("LOGIN INVALIDO PAE :(");
            }
        } else {
            pesSai = null;
            System.out.println("LOGIN INVALIDO PAE :(");
        }

        return pesSai;
    }

    public List<Pessoa> listaPesoa() throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();
        return pesDao.lista();
    }

    public Pessoa inseriPessoa(Pessoa pesEnt, Endereco endEnt, Contato contEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();
        EnderecoDao endDao = new EnderecoDao();
        ContatoDao contDao = new ContatoDao();
        FuncionarioDao funDao = new FuncionarioDao();
        ClienteDao cliDao = new ClienteDao();

        Pessoa pesSai = new Pessoa();
        Endereco endSai = new Endereco();
        Contato contSai = new Contato();
        Funcionario funSai = new Funcionario();
        Cliente cliSai = new Cliente();

        boolean valida = false;

        pesSai = pesDao.inseri(pesEnt);
        if (pesSai != null) {
            endEnt.setPessoa(pesSai);
            endSai = endDao.inseri(endEnt);
            if (endSai != null) {
                contEnt.setPessoa(pesSai);
                contSai = contDao.inseri(contEnt);
                if (contSai != null) {
                    valida = true;
                }
            }
        }

        if (valida) {
            System.out.println("Sucesso ao inseri pessoa");
        } else {
            System.out.println("Erro ao inseri pessoa");
        }

        return pesSai;
    }

    public Pessoa buscaPessoa(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();

        Pessoa pesSai = new Pessoa();

        boolean valida = false;

        pesSai = pesDao.busca(pesEnt);
        if (pesSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao buscar pessoa");
        } else {
            System.out.println("Erro ao buscar pessoa");
        }

        return pesSai;
    }

    public Endereco buscaEndereco(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();
        EnderecoDao endDao = new EnderecoDao();

        Pessoa pesSai = new Pessoa();
        Endereco endSai = new Endereco();

        boolean valida = false;

        pesSai = pesDao.busca(pesEnt);
        if (pesSai != null) {
            Endereco endEnt = new Endereco();
            endEnt.setPessoa(pesSai);
            endSai = endDao.busca(endEnt);
            if (endSai != null) {
                valida = true;
            }
        }

        if (valida) {
            System.out.println("Sucesso ao buscar pessoa");
        } else {
            System.out.println("Erro ao buscar pessoa");
        }

        return endSai;
    }

    public Contato buscaContato(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();
        ContatoDao contDao = new ContatoDao();

        Pessoa pesSai = new Pessoa();
        Contato contSai = new Contato();

        boolean valida = false;

        pesSai = pesDao.busca(pesEnt);
        if (pesSai != null) {
            Contato contEnt = new Contato();
            contEnt.setPessoa(pesSai);
            contSai = contDao.busca(contEnt);
            if (contSai != null) {
                valida = true;
            }
        }

        if (valida) {
            System.out.println("Sucesso ao buscar cont");
        } else {
            System.out.println("Erro ao buscar cont");
        }

        return contSai;
    }

    public Pessoa desativarPessoa(Pessoa pesEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();

        Pessoa pesSai = new Pessoa();

        boolean valida = false;

        pesSai = pesDao.desativar(pesEnt);
        if (pesSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao desativar pessoa");
        } else {
            System.out.println("Erro ao desativar pessoa");
        }

        return pesSai;
    }

    public Pessoa alteraPessoa(Pessoa pesEnt, Endereco endEnt, Contato contEnt) throws SQLException, ClassNotFoundException {
        pesDao = new PessoaDao();
        EnderecoDao endDao = new EnderecoDao();
        ContatoDao contDao = new ContatoDao();
        FuncionarioDao funDao = new FuncionarioDao();
        ClienteDao cliDao = new ClienteDao();

        Pessoa pesSai = new Pessoa();
        Endereco endSai = new Endereco();
        Contato contSai = new Contato();
        Funcionario funSai = new Funcionario();
        Cliente cliSai = new Cliente();

        boolean valida = false;

        pesSai = pesDao.altera(pesEnt);
        if (pesSai != null) {
            endEnt.setPessoa(pesSai);
            endSai = endDao.altera(endEnt);
            if (endSai != null) {
                contEnt.setPessoa(pesSai);
                contSai = contDao.altera(contEnt);
                if (contSai != null) {
                    valida = true;
                }
            }
        }

        if (valida) {
            System.out.println("Sucesso ao alterar pessoa");
        } else {
            System.out.println("Erro ao alterar pessoa");
        }

        return pesSai;
    }

}
