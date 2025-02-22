namespace dm112_srp_cad;

class Program
{
    static void Main(string[] args)
    {
        Rectangle rectangle = new Rectangle(10,10,100,100);
        UIRectangle uirectangle = new UIRectangle(rectangle);

        Geometry geometry = new Geometry(rectangle);
        geometry.CalculateArea();

        Graphics graphics = new Graphics(rectangle);
        graphics.DrawRectangle();
    }
}
