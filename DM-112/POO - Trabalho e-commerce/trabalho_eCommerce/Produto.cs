namespace eCommerce;

public class Produto
{
    string nome;
    decimal preco;
    string categoria;

    public Produto(string nome, decimal preco, string categoria)
    {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public decimal Getpreco()
    {
        return preco;
    }

    public string GetNome()
    {
        return nome;
    }

    public string GetCategoria()
    {
        return categoria;
    }
}
