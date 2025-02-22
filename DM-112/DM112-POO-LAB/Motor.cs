using Carros;

namespace Carros
{
    public class Motor
    {
        int potencia;
        int quantidadeCilindros;

        public Motor(int potencia)
        {
            this.potencia = potencia
        }

        string Ligar()
        {
            return "Motor Ligado";
        }

        string Desligar()
        {
            return "Motor desligado";
        }

        public int GetPotencia()
        {
            return potencia;       
        }
    }
}