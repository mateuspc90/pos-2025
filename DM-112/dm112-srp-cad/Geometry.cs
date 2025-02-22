public class Geometry
{
    Rectangle rectangle;

    public Geometry(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    public void CalculateArea()
    {
        Console.WriteLine($"Rectangle Area: {rectangle.Area()});
    }
}