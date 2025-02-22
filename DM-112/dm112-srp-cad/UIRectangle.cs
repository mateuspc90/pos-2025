public class UIRectangle
{
    Rectangle rectangle;
    public UIRectangle(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    public void Draw()
    {
        Consolde.WriteLine($"Draw a rectangle.{rectangle.Area()}");
    }
}