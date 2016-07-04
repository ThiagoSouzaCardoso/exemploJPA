package br.com.fiap;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="cinemas")
public class Cinema implements Serializable{

	private static final long serialVersionUID = -1037134465391399351L;
	
	@Id
	@Column(name="ID", length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="DESCRICAO", length=45)
	private String descricao;
	
	@Version
	@Column(name="version", length=11)
	private Integer version;
	
	@Column(name="CONTATO", length=45)
	private String contato;
	
	@OneToMany(fetch=LAZY, cascade={PERSIST,PERSIST},mappedBy="cinema")
	private Set<Local> locais = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Set<Local> getLocais() {
		return locais;
	}

	public void setLocais(Set<Local> locais) {
		this.locais = locais;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
