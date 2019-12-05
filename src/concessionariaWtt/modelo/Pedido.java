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
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;
    @Column(name = "dt_compra", length = 100)
    private String dtCompra;
    @Column(length = 100)
    private String valor;
    @Column(length = 100)
    private String observacao;
    @Column(length = 100)
    private String status;
    @ManyToMany(mappedBy = "pedidoCollection")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "id_carro", referencedColumnName = "id_carro", nullable = false)
    @ManyToOne(optional = false)
    private Carro idCarro;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario", nullable = false)
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public Pedido() {
    }

    public Pedido(Long idPedido, String dtCompra, String valor, String observacao, String status, Long idCarro, Long idFuncionario) {
        this.idPedido = idPedido;
        this.dtCompra = dtCompra;
        this.valor = valor;
        this.observacao = observacao;
        this.status = status;
        Carro car = new Carro();
        car.setIdCarro(idCarro);
        this.idCarro = car;
        Funcionario fun = new Funcionario();
        fun.setIdFuncionario(idFuncionario);
        this.idFuncionario = fun;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Carro getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Carro idCarro) {
        this.idCarro = idCarro;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "concessionariaWtt.modelo.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
