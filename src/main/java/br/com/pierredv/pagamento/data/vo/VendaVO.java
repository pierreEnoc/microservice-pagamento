package br.com.pierredv.pagamento.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.pierredv.pagamento.entities.Venda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"id", "data", "produtos", "valorTotal"})
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("produtos")
	private List<ProdutoVendaVO> produtos;
	
	@JsonProperty("valorTotal")
	private Double valorTotal;
	
	public VendaVO() {
		
	}
	
	public VendaVO(Long id, Date data, List<ProdutoVendaVO> produtos, Double valorTotal) {
		super();
		this.id = id;
		this.data = data;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ProdutoVendaVO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVendaVO> produtos) {
		this.produtos = produtos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public static VendaVO create(Venda venda) {
		return new ModelMapper().map(venda, VendaVO.class);
		
	}
	
}
