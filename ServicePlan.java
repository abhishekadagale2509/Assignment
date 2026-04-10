
package cms;

public enum ServicePlan {
    SILVER(1000), GOLD(2000), PLATINUM(5000), DIAMOND(10000);

    private double cost;

    ServicePlan(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
/*
public enum ServicePlan
{
	SILVER(1000),GOLD(2000),PLATINUM(5000),DIAMOND(10000);
	
	private double plancost;
	
	ServicePlan(double plancost)
	{
		this.plancost=plancost;
	}
	
	public double getplancost()
	{
		return plancost;
	}
}
*/

