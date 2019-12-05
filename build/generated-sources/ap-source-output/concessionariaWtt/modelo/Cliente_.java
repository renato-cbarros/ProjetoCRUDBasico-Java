package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Pedido;
import concessionariaWtt.modelo.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Pessoa> idPessoa;
    public static volatile SingularAttribute<Cliente, Long> idCliente;
    public static volatile SingularAttribute<Cliente, String> nivelDesconto;
    public static volatile CollectionAttribute<Cliente, Pedido> pedidoCollection;

}