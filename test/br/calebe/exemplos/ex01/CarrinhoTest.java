package br.calebe.exemplos.ex01;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(null, menor);
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(livro, menor);
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertEquals(livro, menor);
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertEquals(original, copia);
    }
	    @Test
    public void validarSeProdutosForamAdicionarios() throws CarrinhoVazioExpected{
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        assertEquals(2, carrinho.getProdutos().size());
    }
    @Test
    public void  excluirProduto() throws CarrinhoVazioExpected{
        Produto p = new Produto("A culpa e das estrelas", 20.0);
        carrinho.add(p);
//        carrinho.excluir(); 
    }
    @Test
    public void limparCarrinho() throws CarrinhoVazioExpected{
        Produto p = new Produto("A culpa e das estrelas", 20.0);
        carrinho.add(p);
        carrinho.getProdutos().clear();
        assertEquals(0, carrinho.getProdutos().size());
    }
}
