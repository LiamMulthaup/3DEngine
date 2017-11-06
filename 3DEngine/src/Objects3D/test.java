package Objects3D;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class test {

	public static void main(String[] args) 
	{
		JFrame Screen = new JFrame();
		Screen.setTitle("Conquer");
		Screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panel3D panel = new Panel3D();
		Screen.setSize(200, 200);
		panel.setBackground(new Color(0, 0, 0));
		Screen.setBackground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		Dot[] dots = new Dot[10001];//100001];
		
		for (double k = 0; k <= 10000; k+= 1)
		{
			//Dot a = new Dot(new Point3D(Math.abs((Math.abs(k) / k * k) % 30 - 15), k, 0));
			//dot b = new Dot(new Point3D(k, (Math.abs((Math.abs(k) / k * k) % 30 - 15) + (Math.abs((Math.abs(k) / k * k) % 30 - 15) / 3)), 0));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 10 * Math.sin(k / 100), k, Math.sin(k / 10 - Math.PI / 2) * 10 * Math.sin(k / 100)));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 10, k, Math.sin(k / 10 - Math.PI / 2) * 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k / 10, k, Math.sin(k / 10 - Math.PI / 2) * k / 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * 100, 0, Math.sin(k / 10 - Math.PI / 2) * 100));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, 0, Math.sin(k / 10 - Math.PI / 2) * k));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k / 10, k - 10000, Math.sin(k / 10 - Math.PI / 2) * k / 10));
			//Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, 0));
			//Dot a = new Dot(new Point3D(Math.sin(k * 10) * 100, k, Math.sin(k / 100) * 50));
			//Dot a = new Dot(new Point3D(Math.sin(k * 10) * 100, k, Math.sin(k / 100) * 50 * Math.cos((Math.sin(k * 10) * 100) * Math.PI / 200 )));
			Dot a = new Dot(new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, Math.cos(Math.sqrt((Math.sin(k / 10) * k) * (Math.sin(k / 10) * k) + (Math.sin(k / 10 - Math.PI / 2) * k) * (Math.sin(k / 10 - Math.PI / 2) * k)) / 100) * 2000 / Math.pow(k, 1 / 3.0) ));
			System.out.println(k);
			a.radius = 20;
			a.color = new Color((int) (255),(int) (255),(int) (255));
			//a.color = new Color((int) (Math.random() * 256),(int) (Math.random() * 256),(int) (Math.random() * 256));
			panel.addControl3D(a);
			dots[(int)k] = a;
		}
		new Timer().scheduleAtFixedRate(new TimerTask()
		{
			double radiusTurn = 0;
			public void run()
			{
				radiusTurn-= Math.PI / 300;
				for (double k = -0; k <= 10000; k+= 1)
				{
					//dots[(int)k].location = new Point3D(Math.sin(k / 10 + radiusTurn) * k / 10, k - 10000, Math.sin(k / 10 - Math.PI / 2 + radiusTurn) * k / 10);
					double xOffset = 0;
					double yOffset = 0;
					double distance = Math.sqrt((Math.sin(k / 10) * k - xOffset) * (Math.sin(k / 10) * k - xOffset) + (Math.sin(k / 10 - Math.PI / 2) * k - yOffset) * (Math.sin(k / 10 - Math.PI / 2) * k - yOffset));
					dots[(int)k].location = new Point3D(Math.sin(k / 10) * k, Math.sin(k / 10 - Math.PI / 2) * k, Math.cos(Math.sqrt((Math.sin(k / 10) * k - xOffset) * (Math.sin(k / 10) * k - xOffset) + (Math.sin(k / 10 - Math.PI / 2) * k - yOffset) * (Math.sin(k / 10 - Math.PI / 2) * k - yOffset)) / 400 + radiusTurn) * 800000 / Math.pow(distance, 1) );
					
				}
				Screen.repaint();
			}
		}
		, 10, 10);
		for (int y = -200; y < 200; y+=20)
		{
			for (int z = -200; z < 200; z+=20)
			{
				Dot a = new Dot(new Point3D(1000, y, z));
				a.color = new Color((int) (255),(int) (0),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		for (int x = 1000; x < 1400; x+=20)
		{
			for (int z = -200; z < 200; z+=20)
			{
				Dot a = new Dot(new Point3D(x, 200, z));
				a.color = new Color((int) (0),(int) (255),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		
		for (int x = 1000; x < 1400; x+=20)
		{
			for (int z = -200; z < 200; z+=20)
			{
				Dot a = new Dot(new Point3D(x, - 200, z));
				a.color = new Color((int) (0),(int) (0),(int) (255));
				panel.addControl3D(a);
			}
		}
		
		
		for (int y = -200; y < 200; y+=20)
		{
			for (int z = -200; z < 200; z+=20)
			{
				Dot a = new Dot(new Point3D(1400, y, z));
				a.color = new Color((int) (255),(int) (255),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		
		for (int x = 1000; x < 1400; x+=20)
		{
			for (int y = -200; y < 200; y+=20)
			{
				Dot a = new Dot(new Point3D(x, y, 200));
				a.color = new Color((int) (255),(int) (0),(int) (255));
				panel.addControl3D(a);
			}
		}
		
		
		for (int x = 1000; x < 1400; x+=20)
		{
			for (int y = -200; y < 200; y+=20)
			{
				Dot a = new Dot(new Point3D(x, y, - 200));
				a.color = new Color((int) (255),(int) (118),(int) (0));
				panel.addControl3D(a);
			}
		}
		
		System.out.println(new Point3D(10, 10, 10).getAngleTo(new Point3D(0, 0, 0)));
		
		Dot a = new Dot(new Point3D(100, 10, 10));
		a.radius = 50;
		Dot b = new Dot(new Point3D(200, - 10, - 10));
		b.radius = 30;
		Dot c = new Dot(new Point3D(400, 10, 10));
		Dot d = new Dot(new Point3D(- 200, 80, - 200));
		d.radius = 80;
		Dot e = new Dot(new Point3D(-1000, - 400, 30));
		e.radius = 30;
		Dot f = new Dot(new Point3D(200, 200, - 400));
		Dot g = new Dot(new Point3D(-1000, 400, 90));
		Dot h = new Dot(new Point3D(1000, - 10, - 10));
		Dot i = new Dot(new Point3D(2000, 80, 10));
		Dot j = new Dot(new Point3D(-3000, 60, - 10));
		Dot sun = new Dot(new Point3D(100000, 1000000, 0));
		CelestialObject earth = new CelestialObject(new Point3D(-20, -20, 0));
		earth.mass = 50000;
		earth.color = Color.green;
		panel.addControl3D(earth);
		earth.radius = 200;
		sun.color = new Color(255, 255, 0);
		sun.radius = 100000;
		KeyEventListener listener = new KeyEventListener();
		Screen.addKeyListener(listener);
		b.color = new Color(255, 0, 0);
		
		panel.addControl3D(a);
		panel.addControl3D(b);
		panel.addControl3D(c);
		panel.addControl3D(d);
		panel.addControl3D(e);
		panel.addControl3D(f);
		panel.addControl3D(g);
		panel.addControl3D(h);
		panel.addControl3D(i);
		panel.addControl3D(j);
		panel.addControl3D(sun);
		Screen.add(panel);
		Screen.setVisible(true);
		Screen.repaint();
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		Screen.getContentPane().setCursor(blankCursor);
		Timer tim = new Timer();
		tim.scheduleAtFixedRate(new TimerTask()
		{
			Point3D movementVector = new Point3D();
			boolean rocketMode = false;
			public void run()
			{
				final double distance;
				if (rocketMode)
				{
					distance = 0.1;
				}
				else
				{
					distance = 2;
				}
				boolean paint = false;
				Point3D addVector = new Point3D();
				Point3D vectorWorking;
				if (rocketMode == true)
				{
					vectorWorking = addVector;
				}
				else
				{
					vectorWorking = panel.perspectiveLocation;
				}
				paint = true;
				if (listener.wPressed)
				{
					vectorWorking.x+=Math.cos(panel.perspectiveAngle.horizontal) * distance;
					vectorWorking.y+=Math.sin(panel.perspectiveAngle.horizontal) * distance;
					paint = true;
				}
				if (listener.aPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal - Math.PI / 2) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal - Math.PI / 2) * distance;
					paint = true;
				}
				if (listener.sPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal) * distance;
					paint = true;
				}
				if (listener.dPressed)
				{
					vectorWorking.x-=Math.cos(panel.perspectiveAngle.horizontal + Math.PI / 2) * distance;
					vectorWorking.y-=Math.sin(panel.perspectiveAngle.horizontal + Math.PI / 2) * distance;
					paint = true;
				}
				if (listener.upPressed)
				{
					panel.perspectiveAngle.vertical+=0.005;
					paint = true;
				}
				if (listener.downPressed)
				{
					panel.perspectiveAngle.vertical-=0.005;
					paint = true;
				}
				if (listener.spacePressed)
				{
					paint = true;
					vectorWorking.z+=distance;
				}
				if (listener.shiftPressed)
				{
					paint = true;
					vectorWorking.z-=distance;
				}
				if (listener.rightPressed)
				{
					panel.perspectiveAngle.horizontal-=0.005;
					paint = true;
				}
				if (listener.leftPressed)
				{
					panel.perspectiveAngle.horizontal+=0.005;
					paint = true;
				}
				/*
				if (listener.gPressed)
				{
					panel.FOV-=5;
					paint = true;
				}
				*/
				if (listener.hPressed)
				{
					movementVector = new Point3D();
				}
				if (listener.rPressed)
				{
					listener.rPressed = false;
					if (rocketMode)
					{
						rocketMode = false;
					}
					else
					{
						rocketMode = true;
						movementVector = new Point3D();
					}
				}
				if (listener.exit)
				{
					if (panel.mouseLocked)
					{
						panel.mouseLocked = false;
						Screen.getContentPane().setCursor(Cursor.getDefaultCursor());
						listener.exit = false;
					}
					else
					{
						panel.mouseLocked = true;
						BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
						Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
						    cursorImg, new Point(0, 0), "blank cursor");
						Screen.getContentPane().setCursor(blankCursor);
						listener.exit = false;
					}
				}
				movementVector = movementVector.addPoint(addVector);
				panel.perspectiveLocation = panel.perspectiveLocation.addPoint(movementVector);
				if (paint)
				{
					Screen.repaint();
				}
			}
		}, 10, 10);
		ArrayList<CelestialObject> celestialObjects = new ArrayList<CelestialObject>();
		celestialObjects.add(earth);
		Timer tim2 = new Timer();
		tim2.scheduleAtFixedRate(new TimerTask()
		{
				public void run()
				{
					if (listener.gPressed)
					{
						CelestialObject newCelestialObject = new CelestialObject(panel.perspectiveLocation);
						newCelestialObject.movementVector = new Point3D(0, 0, 0).getPointAt(panel.perspectiveAngle, 3);
						newCelestialObject.radius = 40;
						panel.addControl3D(newCelestialObject);
						celestialObjects.add(newCelestialObject);
						listener.gPressed = false;
					}
					for (CelestialObject o : celestialObjects)
					{
						for (CelestialObject i : celestialObjects)
						{
							if (o != i)
							{
								double r = o.location.getDistanceTo(i.location);
								double force = (o.mass * i.mass) / (r * r) / 10;
								//System.out.println(force);
								o.movementVector = o.movementVector.addPoint(new Point3D().getPointAt(o.location.getAngleTo(i.location), force / o.mass));
							}
						}
					}
					for (CelestialObject o : celestialObjects)
					{
						o.location = o.location.addPoint(o.movementVector);
					}
					Screen.repaint();
				}
		}
				, 20, 20);
	}

}
