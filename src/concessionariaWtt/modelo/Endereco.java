/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionariaWtt.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author renat
 */
@MappedSuperclass
@Table(catalog = "concessionaria_wtt", schema = "")
@XmlRootElement
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_endereco", nullable = false)
    private Long idEndereco;
    @Column(length = 100)
    private String cep;
    @Column(length = 100)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @JoinColumns({
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false),
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)})
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(Long idEndereco, String cep, String numero, String complemento, Long idPessoa) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        Pessoa pes = new Pessoa();
        pes.setIdPessoa(idPessoa);
        this.pessoa = pes;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "concessionariaWtt.modelo.Endereco[ idEndereco=" + idEndereco + " ]";
    }
    
}
