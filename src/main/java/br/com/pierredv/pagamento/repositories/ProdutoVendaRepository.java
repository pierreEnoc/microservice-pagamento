package br.com.pierredv.pagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pierredv.pagamento.entities.ProdutoVenda;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long> {

}
