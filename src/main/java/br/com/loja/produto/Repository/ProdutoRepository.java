package br.com.loja.produto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja.produto.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}