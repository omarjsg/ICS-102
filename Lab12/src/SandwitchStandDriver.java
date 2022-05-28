public class SandwitchStandDriver {
	public static void main(String[] args) {
		int before = SandwitchStand.getNumSandwitchSoldAllStands();
		SandwitchStand[] sand = new SandwitchStand[10];
		try {
		sand[0]= new SandwitchStand(1234,0);
		sand[1]= new SandwitchStand(5678,3);
		sand[2]= new SandwitchStand(5234,1);
		sand[3]= new SandwitchStand(1267,0);
		sand[4]= new SandwitchStand(6454,0);
		sand[5]= new SandwitchStand(1004,0);
		System.out.printf("Total number of sandwitches sold before object creation = %d",before);
		System.out.printf("%nTotal number of sandwitches sold at stand %d before any sells = %d ",sand[0].getStandID(),sand[0].getNumSandwitchSoldAtStand());
		sand[0].sellSandwitch(2);
		System.out.printf("%nTotal number of sandwitches sold at stand %d = %d ",sand[0].getStandID(),sand[0].getNumSandwitchSoldAtStand());
		System.out.printf("%nTotal number of sandwitches sold at stand %d = %d ",sand[1].getStandID(),sand[1].getNumSandwitchSoldAtStand());
		System.out.printf("%nTotal number of sandwitches sold at stand %d = %d ",sand[2].getStandID(),sand[2].getNumSandwitchSoldAtStand());
		int after = SandwitchStand.getNumSandwitchSoldAllStands();
		System.out.printf("%nTotal number of sandwitches sold in all stands = %d",after);
		}catch(IllegalArgumentException e)
		{
			System.out.println("Error: number of sandwitches should not be zero");
		}
		}
}
