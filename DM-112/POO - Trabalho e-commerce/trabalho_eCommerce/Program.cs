namespace eCommerce;

class Program
{
    static void Main(string[] args)
    {
        // Gerar produtos
        Produto produto1 = new Produto("Camiseta", 89.90m, "Vestuário");
        Produto produto2 = new Produto("Boné", 120m, "Acessório");

    /*    decimal preco = produto1.Getpreco();
        Console.WriteLine($"O preço do produto é {preco}"); */

        // Popular pedido   
        Pedido pedido = new Pedido();
        pedido.AdicionarProduto(produto1);
        pedido.AdicionarProduto(produto2);

        // Definindo forma de pagamento - crédito
        IPagamento pagamento = new noCredito();
        pedido.DefinirFormaPagamento(pagamento);

        // Finalizar pedido
        Fatura fatura = pedido.FinalizarPedido();
        fatura.ImprimirFatura();
    }
}
