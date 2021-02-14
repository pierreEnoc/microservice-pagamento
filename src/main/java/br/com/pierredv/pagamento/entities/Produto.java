package br.com.pierredv.pagamento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	private Long id;
	
	@Column(name = "estoque", nullable = false, length = 10)
	private Integer estoque;	 
}
