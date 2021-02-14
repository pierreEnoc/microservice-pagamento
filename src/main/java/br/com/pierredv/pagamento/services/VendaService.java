package br.com.pierredv.pagamento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pierredv.pagamento.data.vo.VendaVO;
import br.com.pierredv.pagamento.entities.ProdutoVenda;
import br.com.pierredv.pagamento.entities.Venda;
import br.com.pierredv.pagamento.exception.ResourceNotFoundException;
import br.com.pierredv.pagamento.repositories.ProdutoVendaRepository;
import br.com.pierredv.pagamento.repositories.VendaRepository;

@Service
public class VendaService {

	private final VendaRepository vendaRepository;
	private final ProdutoVendaRepository produtoVendaRepository;
	
	@Autowired
	public VendaService(VendaRepository vendaRepository, ProdutoVendaRepository produtoVendaRepository ) {
		this.vendaRepository = vendaRepository;
		this.produtoVendaRepository = produtoVendaRepository;
	}
	
	public VendaVO create(VendaVO vendaVO) {
		Venda venda = vendaRepository.save(Venda.create(vendaVO));
		
		List<ProdutoVenda> produtosSalvos = new ArrayList<>();
		vendaVO.getProdutos().forEach(p -> {
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(venda);
			produtosSalvos.add(produtoVendaRepository.save(pv));
		});
		
		venda.setProdutos(produtosSalvos);
		return VendaVO.create(venda);
	}
	
	public Page<VendaVO> findAll(Pageable pageble) {
		var page = vendaRepository.findAll(pageble);
		return page.map(this::convertToProdutov0);
		
	}
	
	private VendaVO convertToProdutov0(Venda venda) {
		return VendaVO.create(venda);
	}
	
	public VendaVO findById(Long id) {
		var entity = vendaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this Id"));
		return VendaVO.create(entity);		
	}
}
