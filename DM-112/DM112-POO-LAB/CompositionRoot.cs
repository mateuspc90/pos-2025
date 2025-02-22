using Carros;
using Microsoft.Win32.SafeHandles;

public class 

{
    public Carros CreateCar()
    {
        return new Carro("GM", "Cruze", 2013, 200);
    }   

    public XJet GetXJet()
    {
        if(xjet == null)
        {
            xjet = new XJet(new Motor(10000))
        }
        
        return xjet;
    }
}