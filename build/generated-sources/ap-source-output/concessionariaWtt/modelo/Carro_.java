package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile SingularAttribute<Carro, String> marca;
    public static volatile SingularAttribute<Carro, String> ano;
    public static volatile SingularAttribute<Carro, Long> idCarro;
    public static volatile SingularAttribute<Carro, String> cor;
    public static volatile SingularAttribute<Carro, String> valor;
    public static volatile CollectionAttribute<Carro, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Carro, String> modelo;

}