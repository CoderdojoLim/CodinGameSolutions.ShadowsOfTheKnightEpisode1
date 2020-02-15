import java.util.Scanner;

/**
 @author Mark Crowe
 @see https://www.codingame.com/ide/puzzle/shadows-of-the-knight-episode-1
 */
class Player
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int buildingWidth = scanner.nextInt(); // width of the building.
		int buildingHeight = scanner.nextInt(); // height of the building.

		Point endPoint = new Point(buildingWidth - 1, buildingHeight - 1);
		Point startPoint = new Point(0, 0);

		int gameTurns = scanner.nextInt();

		Point batmanPositionPoint = new Point(scanner.nextInt(), scanner.nextInt());

		// game loop
		while(true)
		{
			String bombDirectionReading = scanner.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

			if(bombDirectionReading.contains("U"))
			{
				endPoint.setY(batmanPositionPoint.getY() - 1);
			}
			else if(bombDirectionReading.contains("D"))
			{
				startPoint.setY(batmanPositionPoint.getY() + 1);
			}
			//else don't move y

			if(bombDirectionReading.contains("L"))
			{
				endPoint.setX(batmanPositionPoint.getX() - 1);
			}
			else if(bombDirectionReading.contains("R"))
			{
				startPoint.setX(batmanPositionPoint.getX() + 1);
			}
			//else don't move x

			batmanPositionPoint = Point.MidPointCeiled(startPoint, endPoint);

			System.out.println(batmanPositionPoint);
		}
	}
}

class Point
{
	public Point()
	{
	}
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	//
	//	Public Properties
	//
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	//
	//	Public Methods
	//
	@Override
	public String toString()
	{
		return String.format("%1$d %2$d", this.x, this.y);
	}
	//
	//	Fields
	//
	public int x, y;
	//
	//	Public Static Methods
	//
	public static Point MidPoint(Point point1, Point point2)
	{
		return new Point(MidPoint(point1.getX(), point2.getX()), MidPoint(point1.getY(), point2.getY()));
	}
	public static Point MidPointCeiled(Point point1, Point point2)
	{
		return new Point(MidPointCeiled(point1.getX(), point2.getX()), MidPointCeiled(point1.getY(), point2.getY()));
	}
	public static int MidPoint(int point1, int point2)
	{
		return (point1 + point2) / 2;
	}
	public static int MidPointCeiled(int point1, int point2)
	{
		Double midPoint = (point1 + point2) / 2.0;
		return (int) Math.ceil(midPoint);
	}
}
