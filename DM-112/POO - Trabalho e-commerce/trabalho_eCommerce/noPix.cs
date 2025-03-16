namespace eCommerce;

class noPix : IPagamento
{
    public void ProcessarPagamento(decimal valor)
    {
        Console.WriteLine($"Pagamento de R${valor} a ser realizado via Pix.");
    }

    public string GetStringMetodo()
    {
        return "Pix";
    }
}