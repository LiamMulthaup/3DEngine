package Objects3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Dot extends Control3D
{
	double radius = 10;
	Color color = Color.white;
	public Dot(Point3D location) 
	{
		super(location);
	}

	public void paint(Graphics g)
	{
		double uI = location.x - panel.perspectiveLocation.x;
		double uJ = location.y - panel.perspectiveLocation.y;
		double uK = location.z - panel.perspectiveLocation.z;
		double distance = Math.sqrt(uI * uI + uJ * uJ + uK * uK);
		int size = (int) (6000 * (radius / 10) / distance);
		if (size != 0)
		{
			if (distance != 0)
			{
				uI/=distance;
				uJ/=distance;
				uK/=distance;
			}
			double intersectionZCoefficient;
			double intersectionZ;
			double intersectionX;
			double intersectionY;
			if (uK != 0)
			{
				intersectionZCoefficient = (panel.planeI * uI / uK) + (panel.planeJ * uJ / uK) + panel.planeK;
				intersectionZ = panel.planeTotal / intersectionZCoefficient;
				intersectionX = uI * intersectionZ / uK;
				intersectionY = uJ * intersectionZ / uK;
			}
			else
			{
				intersectionZ = 0;
				if (uI != 0)
				{
					double intersectionXCoefficient = (panel.planeJ * uJ / uI) + panel.planeI;
					intersectionX = panel.planeTotal / intersectionXCoefficient;
					intersectionY = uJ * intersectionX / uI;
				}	
				else
				{
					intersectionX = 0;
					if (uJ != 0)
					{
						double intersectionYCoefficient = panel.planeJ;
						intersectionY = panel.planeTotal / intersectionYCoefficient;
					}	
					else
					{
						intersectionY = 0;
					}		
				}
			}
			double newUI = intersectionX;
			double newUJ = intersectionY;
			double newUK = intersectionZ;
			double newDistance = Math.sqrt(newUI * newUI + newUJ * newUJ + newUK * newUK);
			newUI/=newDistance;
			newUJ/=newDistance;
			newUK/=newDistance;
			//System.out.println("Here:" + ((int) Math.round(newUI / uI)));
			
			if ((int) Math.round(newUI / uI) != -1 && size != 0)
			{
				double vX1 = panel.panelTopCenter.x - panel.panelTopLeft.x;
				double vY1 = panel.panelTopCenter.y - panel.panelTopLeft.y;
				double vZ1 = panel.panelTopCenter.z - panel.panelTopLeft.z;
				double v1Distance = Math.sqrt(vX1 * vX1 + vY1 * vY1 + vZ1 * vZ1);
				
				double vX2 = intersectionX - panel.panelTopLeft.x;
				double vY2 = intersectionY - panel.panelTopLeft.y;
				double vZ2 = intersectionZ - panel.panelTopLeft.z;
				double v2Distance = Math.sqrt(vX2 * vX2 + vY2 * vY2 + vZ2 * vZ2);
				
				double angleBetween = Math.acos(    (vX1 * vX2 + vY1 * vY2 + vZ1 * vZ2)/ (v1Distance * v2Distance)    );
				double xDrawing = Math.cos(angleBetween) * v2Distance;
				double yDrawing = Math.sin(angleBetween) * v2Distance;
				
				double vX3 = panel.panelBottomCenter.x - panel.panelBottomRight.x;
				double vY3 = panel.panelBottomCenter.y - panel.panelBottomRight.y;
				double vZ3 = panel.panelBottomCenter.z - panel.panelBottomRight.z;
				double v3Distance = Math.sqrt(vX3 * vX3 + vY3 * vY3 + vZ3 * vZ3);
			
				double vX4 = intersectionX - panel.panelBottomRight.x;
				double vY4 = intersectionY - panel.panelBottomRight.y;
				double vZ4 = intersectionZ - panel.panelBottomRight.z;
				double v4Distance = Math.sqrt(vX4 * vX4 + vY4 * vY4 + vZ4 * vZ4);
				
				double angleBetween2 = Math.acos(    (vX3 * vX4 + vY3 * vY4 + vZ3 * vZ4)/ (v3Distance * v4Distance)    );
				double altXDrawing = panel.getWidth() + Math.cos(angleBetween2 + Math.PI) * v4Distance;
				double altYDrawing = panel.getHeight() + Math.sin(angleBetween2 + Math.PI) * v4Distance;
				//System.out.println((Math.round(altXDrawing) == Math.round(xDrawing)));
				//System.out.println((Math.round(altYDrawing) - Math.round(yDrawing)));
				if (Math.round(xDrawing) == Math.round(altXDrawing) && Math.round(yDrawing) == Math.round(altYDrawing))
				{
					//g.setColor(color);
					//g.fillOval((int) (xDrawing - size / 2.0), (int) (yDrawing - size / 2.0), size, size);
					if (xDrawing + size / 2 > 0 && xDrawing - size / 2 < panel.getWidth() && yDrawing + size / 2 > 0 && yDrawing - size / 2 < panel.getHeight())
					{
						panel.addDotDrawing(new DotDrawing(new Point((int)xDrawing, (int)yDrawing), size, color, distance));
					}
				}
			}	
		}
	}
}