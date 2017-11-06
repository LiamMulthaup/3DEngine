package Objects3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DotDrawing {
	Point location;
	int size;
	Color color;
	double radius;
	public DotDrawing(Point location, int size, Color color, double radius)
	{
		this.location = location;
		this.size = size;
		this.color = color;
		this.radius = radius;
	}
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillOval((int) (location.x - size / 2.0), (int) (location.y - size / 2.0), size, size);
	}
}
