package br.com.loja.produto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import br.com.loja.produto.Entity.Produto;
import br.com.loja.produto.Repository.ProdutoRepository;

@RestController
@RequestMapping("api/produto")

public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    @CrossOrigin
    @RequestMapping("/")
    public List<Produto> listarProdutos() {
        List<Produto> listaProdutos = produtoRepository.findAll();
        return listaProdutos;
    }

    @CrossOrigin
    @RequestMapping("/buscar")
    public ResponseEntity<Produto> buscarProdutoById(@RequestParam Long id) {
        Produto produto = produtoRepository.findById(id).get();
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    @CrossOrigin
    @RequestMapping("/salvar")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
 /*       if (produto.getId() != null) {
            produtoRepository.deleteById(produto.getId());
        }
        Produto p = new Produto();
        p.setNome(produto.getNome());
        p.setQuantidade(produto.getQuantidade());
*/
        produtoRepository.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @CrossOrigin
    @RequestMapping("/apagar")
    public ResponseEntity<String> apagarProdutoById(@RequestParam Long id) {
        String resp;
        try {
            produtoRepository.deleteById(id);
            resp = "Apagado com sucesso!";
        } catch (Exception erro) {
            System.out.println("--------------------------> ERROR " + erro);
            resp = "Erro ao apagar";
        }
        return ResponseEntity.ok().body(resp);
    }

}