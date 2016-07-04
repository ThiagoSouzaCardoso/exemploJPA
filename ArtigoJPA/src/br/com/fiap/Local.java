package br.com.fiap;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Cacheable(value=false)
@Entity
@Table(name="locais")
public class Local implements Serializable{

	private static final long serialVersionUID = -5467833617050918010L;

	@Id
	@Column(name="ID", length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade={PERSIST,MERGE},fetch=LAZY)
	@JoinColumn(name="IDCINEMA")
	private Cinema cinema;
	
	@Column(name="LOCAL", length=45)
	private String local;
	
	@Column(name="NUMSALAS", length=11)
	private Integer numeroSalas;
	
	@Version
	@Column(name="version", length=11)
	private Integer version;
	
	@OneToMany(mappedBy="local",cascade={PERSIST,MERGE},fetch=LAZY)
	private Set<Filme> filmes = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getNumeroSalas() {
		return numeroSalas;
	}

	public void setNumeroSalas(Integer numeroSalas) {
		this.numeroSalas = numeroSalas;
	}

	public Set<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
}
