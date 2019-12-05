/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author renat
 */
@Entity
public class ClientePedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idClientePedido;
    private Cliente idCliente;
    private Pedido idPedido;
    
    public ClientePedido() {
    }
    
    public ClientePedido(Long idClientePedido, Long idCliente, Long idPedido) {
        this.idClientePedido = idClientePedido;
        Cliente cli = new Cliente();
        cli.setIdCliente(idCliente);
        this.setIdCliente(cli);
        Pedido ped = new Pedido();
        ped.setIdPedido(idPedido);
        this.idPedido = ped;
    }

    public Long getIdClientePedido() {
        return idClientePedido;
    }

    public void setIdClientePedido(Long idClientePedido) {
        this.idClientePedido = idClientePedido;
    }
    
    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientePedido != null ? idClientePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePedido)) {
            return false;
        }
        ClientePedido other = (ClientePedido) object;
        if ((this.idClientePedido == null && other.idClientePedido != null) || (this.idClientePedido != null && !this.idClientePedido.equals(other.idClientePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "concessionariaWtt.modelo.cliente_pedido[ id=" + idClientePedido + " ]";
    }
    
}
