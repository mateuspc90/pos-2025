namespace eCommerce;

public interface IPagamento
{
    void ProcessarPagamento(decimal valor);
    public string GetStringMetodo();
}
