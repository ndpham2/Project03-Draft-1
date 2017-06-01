
public class PrivateInvestmentAccount extends Investment {
	private double omegaMeasure;
	private double totalValue;
	private double percentage;
	
	public PrivateInvestmentAccount(String code, String label, double quarterlyDividend, double baseRateOfReturn, double omegaMeasure, double totalValue) {
		super(code, label, quarterlyDividend, baseRateOfReturn);
		this.omegaMeasure = omegaMeasure;
		this.totalValue = totalValue;

	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Private Investment Account***************** \n");
		sb.append("Code: " + getCode() + " \n");
		sb.append("Label: " + getLabel() + " \n");
		sb.append("Quarterly Dividend: " + getQuarterlyDividend() + " \n");
		sb.append("Base rate of return: " + getBaseRateOfReturn() + " \n");
		sb.append("Omega Measure: " + getOmegaMeasure() + " \n");
		sb.append("Total Value: " + getTotalValue() + " \n");
		sb.append("Percentage: " + getPercentage() + " \n");
		
		
		return sb.toString();
	}

	public double getOmegaMeasure() {
		return omegaMeasure;
	}
	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = omegaMeasure;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	

}
