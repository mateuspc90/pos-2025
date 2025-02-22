public class Rectangle
{
    float x;
    float y;
    float width;
    float height;

    public Rectangle(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float Area()
    {
        return width * height;
    }
}