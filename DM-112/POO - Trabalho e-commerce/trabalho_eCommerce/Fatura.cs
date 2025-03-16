namespace eCommerce;

public class Fatura
{
    decimal Valor;
    string MetodoPagamento;

    public Fatura(decimal valor, string metodoPagamento)
    {
        Valor = valor;
        MetodoPagamento = metodoPagamento;
    }

    public void ImprimirFatura()
    {   
        Console.WriteLine($"\nFatura: R${Valor}");
        Console.WriteLine($"Pagamento realizado via {MetodoPagamento}");
    }
}
