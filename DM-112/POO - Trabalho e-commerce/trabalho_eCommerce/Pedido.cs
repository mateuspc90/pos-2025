namespace eCommerce;

using System;
using System.Collections.Generic;

public class Pedido
{
    List<Produto> Produtos;
    IPagamento FormaPagamento;

    public Pedido()
    {
        Produtos = new List<Produto>();
    }

    public void AdicionarProduto(Produto produto)
    {
        Produtos.Add(produto);
    }

    public void DefinirFormaPagamento(IPagamento pagamento)
    {
        FormaPagamento = pagamento;
    }

    public decimal CalcularTotal()
    {
        decimal total = 0;
        foreach (var produto in Produtos)
        {
            total += produto.GetPreco();
        }
        return total;
    }

    public Fatura FinalizarPedido()
    {
        Console.WriteLine("\nFinalizando pedido...");
        Console.WriteLine("Produtos:");

         foreach (var produto in Produtos)
        {
            Console.WriteLine($"- {produto.GetNome()}, R${produto.GetPreco()}");
        }

        var total = CalcularTotal();
        FormaPagamento.ProcessarPagamento(total);

        return new Fatura(total, FormaPagamento.GetStringMetodo());
    }
}
