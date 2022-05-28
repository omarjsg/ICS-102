
public class SandwitchStand {
	private int standID=0;
	private int totalSandwitchSoldAtStand=0;
	private static int totalSandwitchSoldAllStands=0;
	public SandwitchStand(int standID,int totalSandwitchSoldAtStand)throws IllegalArgumentException {
		if (totalSandwitchSoldAtStand<0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		this.standID = standID;
		this.totalSandwitchSoldAtStand = totalSandwitchSoldAtStand;
		totalSandwitchSoldAllStands += totalSandwitchSoldAtStand;
		}
	}
	public SandwitchStand() {
		// TODO Auto-generated constructor stub
	}
	public int getStandID()
	{
		return this.standID;
	}
	public int  getNumSandwitchSoldAtStand()
	{
		return this.totalSandwitchSoldAtStand;
	}
	public void sellSandwitch(int numberOfSandwiches) throws IllegalArgumentException
	{
		if (numberOfSandwiches<0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			totalSandwitchSoldAllStands+= numberOfSandwiches;
			this.totalSandwitchSoldAtStand = numberOfSandwiches;
		}
	}
	public static int getNumSandwitchSoldAllStands() 
	{
		return totalSandwitchSoldAllStands;
	}



}
