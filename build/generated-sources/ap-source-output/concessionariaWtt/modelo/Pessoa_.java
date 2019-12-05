package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Contato;
import concessionariaWtt.modelo.Endereco;
import concessionariaWtt.modelo.Funcionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, Long> idPessoa;
    public static volatile SingularAttribute<Pessoa, String> senha;
    public static volatile SingularAttribute<Pessoa, String> situacao;
    public static volatile CollectionAttribute<Pessoa, Contato> contatoCollection;
    public static volatile CollectionAttribute<Pessoa, Funcionario> funcionarioCollection;
    public static volatile CollectionAttribute<Pessoa, Endereco> enderecoCollection;
    public static volatile SingularAttribute<Pessoa, String> cpf;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, String> login;
    public static volatile CollectionAttribute<Pessoa, Cliente> clienteCollection;

}