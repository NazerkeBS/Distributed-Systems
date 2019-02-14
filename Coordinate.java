public class Coordinate{
	private int x;
	private int y;

	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getDistanceOrigin(){
		return x*x + y*y;
	}

	public String getPoints(){
		return "("+ x + "," + y + ")"; 
	}
}