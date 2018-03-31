package com.example.aula;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.aula.domain.manytomany.Categoria;
import com.example.aula.domain.manytomany.Produto;
import com.example.aula.domain.onetomany.Artigo;
import com.example.aula.domain.onetomany.Autor;
import com.example.aula.domain.onetoone.NotaFiscal;
import com.example.aula.domain.onetoone.Pagamento;
import com.example.aula.domain.onetoone.Pedido;
import com.example.aula.repository.ArtigoRepository;
import com.example.aula.repository.AutorRepository;
import com.example.aula.repository.CategoriaRepository;
import com.example.aula.repository.NotaFiscalRepository;
import com.example.aula.repository.PagamentoRepository;
import com.example.aula.repository.PedidoRepository;
import com.example.aula.repository.ProdutoRepository;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired	
	private PedidoRepository pedidoRepository;
	
	@Autowired	
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ArtigoRepository artigoRepository;
	
	@Autowired	
	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		// CATEGORIA X PRODUTO
		Categoria cat1 = new Categoria(null,"Telefone");
		Categoria cat2 = new Categoria(null,"Informática");
		
		Produto p1 = new Produto(null,"Computador",2,2000.00);
		Produto p2 = new Produto(null,"Mouse",2,15.00);
		Produto p3 = new Produto(null,"Celular Samsung",2,1000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p3));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2));
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat2);
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		
		// PEDIDO X PAGAMENTO X NOTAFISCAL		
		Pedido ped1 = new Pedido(null,new Date());
		Pedido ped2 = new Pedido(null,new Date());

		Pagamento pag1 = new Pagamento(null, new Date(), "1234123412341234", 1000, ped1);
		Pagamento pag2 = new Pagamento(null, new Date(), "1234123412341234", 500, ped2);
		ped1.setPagamento(pag1);
		ped2.setPagamento(pag2);	
		
		NotaFiscal not1 = new NotaFiscal(null,new Date(),2131323L,ped1);
		NotaFiscal not2 = new NotaFiscal(null,new Date(),2131323L,ped2);
		ped1.setNotaFiscal(not1);
		ped2.setNotaFiscal(not2);		
		

		pedidoRepository.save(Arrays.asList(ped1,ped2));
		pagamentoRepository.save(Arrays.asList(pag1,pag2));
		notaFiscalRepository.save(Arrays.asList(not1,not2));

		
		// AUTOR X ARTIGO
		Autor aut1 = new Autor(null,"Marcelo Souza");
		Autor aut2 = new Autor(null,"Patricia Aguiar");
		
		Artigo art1 = new Artigo(null, "Título 1", "Conteúdo 1");
		art1.setAutor(aut1);
		Artigo art2 = new Artigo(null, "Título 2", "Conteúdo 2");
		art2.setAutor(aut2);
		
		autorRepository.save(Arrays.asList(aut1,aut2));
		artigoRepository.save(Arrays.asList(art1,art2));
		
		
	}
}
