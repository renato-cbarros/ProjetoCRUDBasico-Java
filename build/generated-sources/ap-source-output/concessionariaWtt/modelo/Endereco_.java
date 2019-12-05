package concessionariaWtt.modelo;

import concessionariaWtt.modelo.Pessoa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-03T03:26:37")
@StaticMetamodel(Endereco.class)
public class Endereco_ { 

    public static volatile SingularAttribute<Endereco, String> complemento;
    public static volatile SingularAttribute<Endereco, Pessoa> pessoa;
    public static volatile SingularAttribute<Endereco, String> numero;
    public static volatile SingularAttribute<Endereco, Long> idEndereco;
    public static volatile SingularAttribute<Endereco, String> cep;

}