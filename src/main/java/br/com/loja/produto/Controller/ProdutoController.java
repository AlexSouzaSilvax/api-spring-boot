package br.com.loja.produto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import br.com.loja.produto.Entity.Produto;
import br.com.loja.produto.Repository.ProdutoRepository;

@RestController
@RequestMapping("api/produto")

public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    @CrossOrigin
    @RequestMapping("/salvar")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    @CrossOrigin
    @RequestMapping("/")
    public List<Produto> listarProdutos() {
        List<Produto> listaProdutos = produtoRepository.findAll();
        return listaProdutos;
    }
}