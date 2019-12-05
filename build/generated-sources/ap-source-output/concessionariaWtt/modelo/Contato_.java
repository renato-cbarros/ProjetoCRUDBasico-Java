package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Contato.class)
public class Contato_ { 

    public static volatile SingularAttribute<Contato, Pessoa> pessoa;
    public static volatile SingularAttribute<Contato, Long> idContato;
    public static volatile SingularAttribute<Contato, String> telFixo;
    public static volatile SingularAttribute<Contato, String> telCelular;
    public static volatile SingularAttribute<Contato, String> email;

}