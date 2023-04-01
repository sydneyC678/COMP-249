package package6;

public class Ferry {

	private double maxSpeed;
	private double maxLoad;
	
	public Ferry()
	{
		maxSpeed=0.0;
		maxLoad=0.0;
	}

	public Ferry(double maxSpeed, double maxLoad) {
		
		this.maxSpeed = maxSpeed;
		this.maxLoad = maxLoad;
	}
	public Ferry(Ferry f)
	{
		this.maxSpeed=f.maxSpeed;
		this.maxLoad=f.maxLoad;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(double maxLoad) {
		this.maxLoad = maxLoad;
	}
	public String toString()
	{
		return "This Ferry has a maximum speed of " + maxSpeed + "km.h and the maximum load that it can carry is " + maxLoad + "kg.";
	}
	public boolean equals(Object x)
	{
		if(x==null)
		{
			return false;
		}
		else if(getClass()!=x.getClass())
		{
			return false;
		}
		else
		{
			Ferry f = (Ferry)x;
			return this.maxSpeed==f.maxSpeed && this.maxLoad==f.maxLoad;
		}
	}
}
