/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author renat
 */
@MappedSuperclass
@Table(catalog = "concessionaria_wtt", schema = "")
@XmlRootElement
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;
    @Column(name = "nivel_desconto", length = 100)
    private String nivelDesconto;
    @JoinTable(name = "cliente_pedido", joinColumns = {
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false),
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false),
        @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)})
    @ManyToMany
    private Collection<Pedido> pedidoCollection;
    @JoinColumns({
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false),
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)})
    @ManyToOne(optional = false)
    private Pessoa idPessoa;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nivelDesconto, Long idPessoa) {
        this.idCliente = idCliente;
        this.nivelDesconto = nivelDesconto;
        Pessoa pes = new Pessoa();
        pes.setIdPessoa(idPessoa);
        this.idPessoa = pes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNivelDesconto() {
        return nivelDesconto;
    }

    public void setNivelDesconto(String nivelDesconto) {
        this.nivelDesconto = nivelDesconto;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "concessionariaWtt.modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
