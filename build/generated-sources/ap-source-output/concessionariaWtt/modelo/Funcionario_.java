package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Pedido;
import concessionariaWtt.modelo.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> funcao;
    public static volatile SingularAttribute<Funcionario, Pessoa> idPessoa;
    public static volatile CollectionAttribute<Funcionario, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Funcionario, Long> idFuncionario;

}