
public class Investment extends Account{
	private double quarterlyDividend;
	private double baseRateOfReturn;
	
	public Investment(String code, String label, double quarterlyDividend, double baseRateOfReturn) {
		super(code, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
	}
	
	
	public double getQuarterlyDividend() {
		return quarterlyDividend;
	}
	public void setQuarterlyDividend(double quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		this.baseRateOfReturn = baseRateOfReturn;
	}
	
}
