/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.controle;

import static concessionariaWtt.controle.ClienteControle.cliDao;
import concessionariaWtt.dao.CarroDao;
import concessionariaWtt.dao.ClienteDao;
import concessionariaWtt.modelo.Carro;
import concessionariaWtt.modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author renat
 */
public class CarroControle {
    
    static CarroDao carDao;
    
/*
    public List<Usuario> listaUsuario(Usuario usuEnt) throws SQLException, ClassNotFoundException {
        usuDao = new UsuarioDao();
        return usuDao.lista(usuEnt);    
    }
*/
    public Carro inseriCarro(Carro carEnt) throws SQLException, ClassNotFoundException {
        carDao = new CarroDao();
        
        Carro carSai = new Carro();
        
        carSai = carDao.inseri(carEnt);
        
        if (carSai != null) {
            System.out.println("Sucesso ao inserir car");
        } else {
            System.out.println("Erro ao inserir car");
        }
 
        return carSai;
    }
    
    public Carro buscaCarro(Carro car) throws SQLException, ClassNotFoundException {
        carDao = new CarroDao();
        
        Carro carSai = new Carro();
        
        carSai = carDao.busca(car);
        
        if (carSai != null) {
            System.out.println("Sucesso ao inserir car");
        } else {
            System.out.println("Erro ao inserir car");
        }
 
        return carSai;
    }


    public List<Carro> listaCarro() throws SQLException, ClassNotFoundException {
        carDao = new CarroDao();
        return carDao.lista();
    }    
    
    public Carro alterarCarro(Carro carEnt) throws SQLException, ClassNotFoundException {
        carDao = new CarroDao();

        Carro carSai = new Carro();

        boolean valida = false;

        carSai = carDao.altera(carEnt);
        if (carSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao alterar car");
        } else {
            System.out.println("Erro ao alterar car");
        }

        return carSai;
    } 
    
   /*
    public Carro excliurCarro(Carro carEnt) throws SQLException, ClassNotFoundException {
        carDao = new CarroDao();

        Cliente cliSai = new Cliente();

        boolean valida = false;

        cliSai = carDao.exclui(carEnt);
        if (cliSai != null) {
            valida = true;
        }

        if (valida) {
            System.out.println("Sucesso ao excluir cli");
        } else {
            System.out.println("Erro ao excluir cli");
        }

        return cliSai;
    }      
    */
    
}
