package br.com.pierredv.pagamento.entities;

import javax.persistence.*;

import org.modelmapper.ModelMapper;

import br.com.pierredv.pagamento.data.vo.ProdutoVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "estoque", nullable = false, length = 10)
	private Integer estoque;

	public static Produto create(ProdutoVO produtoVO) {
		return new ModelMapper().map(produtoVO, Produto.class);
	}
}