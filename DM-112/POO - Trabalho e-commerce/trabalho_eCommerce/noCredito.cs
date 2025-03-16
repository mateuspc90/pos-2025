namespace eCommerce;

class noCredito : IPagamento
{
    public void ProcessarPagamento(decimal valor)
    {
        Console.WriteLine($"Pagamento de R${valor} a ser realizado via Cartão de Crédito.");
    }

    public string GetStringMetodo()
    {
        return "Cartão de Crédito";
    }
}
