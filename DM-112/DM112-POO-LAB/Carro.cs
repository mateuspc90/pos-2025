namespace Carros
{
    public class Carro
    {
        string marca;
        string modelo;
        int ano;
        float valor;
        string cor;
        public Motor motor;

        public Carro(string marca, string modelo, int ano, int potencia)
        {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            motor = new Motor(potencia);
        }

        string Buzinar()
        {
            return "foooooooooom";
        }


    }
}