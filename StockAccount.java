
public class StockAccount extends Investment {
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	private double numberOfShares;
	
	public StockAccount(String code, String label, double quarterlyDividend, double baseRateOfReturn, double betaMeasure, String stockSymbol, double sharePrice) {
		super(code, label, quarterlyDividend, baseRateOfReturn);
			this.betaMeasure = betaMeasure;
			this.stockSymbol = stockSymbol;
			this.sharePrice = sharePrice;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Stock Account***************** \n");
		sb.append("Code: " + getCode() + " \n");
		sb.append("Label: " + getLabel() + " \n");
		sb.append("Quarterly Dividend: " + getQuarterlyDividend() + " \n");
		sb.append("Base rate of return: " + getBaseRateOfReturn() + " \n");
		sb.append("Beta Measure: " + getBetaMeasure() + " \n");
		sb.append("Stock Symbol: " + getStockSymbol() + " \n");
		sb.append("Share Price: " + getSharePrice() + " \n");
		sb.append("Number of Shares: " + getNumberOfShares() + " \n");

		return sb.toString();
	}
	
	public double getBetaMeasure() {
		return betaMeasure;
	}
	public void setBetaMeasure(double betaMeasure) {
		this.betaMeasure = betaMeasure;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public double getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(double numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	

}
