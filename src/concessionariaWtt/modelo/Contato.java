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
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contato", nullable = false)
    private Long idContato;
    @Column(name = "tel_fixo", length = 100)
    private String telFixo;
    @Column(name = "tel_celular", length = 100)
    private String telCelular;
    @Column(length = 100)
    private String email;
    @JoinColumns({
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false),
        @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)})
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(Long idContato, String telFixo, String telCelular, String email, Long idPessoa) {
        this.idContato = idContato;
        this.telFixo = telFixo;
        this.telCelular = telCelular;
        this.email = email;
        Pessoa pes = new Pessoa();
        pes.setIdPessoa(idPessoa);
        this.pessoa = pes;
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idContato != null ? idContato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.idContato == null && other.idContato != null) || (this.idContato != null && !this.idContato.equals(other.idContato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "concessionariaWtt.modelo.Contato[ idContato=" + idContato + " ]";
    }
    
}
