package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
import concessionariaWtt.modelo.Funcionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> dtCompra;
    public static volatile SingularAttribute<Pedido, String> observacao;
    public static volatile SingularAttribute<Pedido, Carro> idCarro;
    public static volatile SingularAttribute<Pedido, String> valor;
    public static volatile SingularAttribute<Pedido, Long> idPedido;
    public static volatile SingularAttribute<Pedido, Funcionario> idFuncionario;
    public static volatile SingularAttribute<Pedido, String> status;
    public static volatile CollectionAttribute<Pedido, Cliente> clienteCollection;

}