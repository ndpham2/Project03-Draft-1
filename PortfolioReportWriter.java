
public class PortfolioReportWriter {

	public static void createSummaryReport(Portfolio[] portfoliosData) {
		System.out.println();
		System.out.println("*****************SUMMARY REPORT*****************");
		for (int i = 0; i < portfoliosData.length; i++) {
			System.out.println();
			System.out.println("Portfolio Code: " + portfoliosData[i].getPortfolioCode());
			System.out.println("Portfolio Owner: " + portfoliosData[i].getOwnerCode());
			System.out.println("Portfolio Manager: " + portfoliosData[i].getManagerCode());

		}
	}

	public static void createDetailReport(Portfolio[] portfoliosData) {
		System.out.println();
		System.out.println("*****************DETAIL REPORT*****************");
		for (int i = 0; i < portfoliosData.length; i++) {
			System.out.println();
			System.out.println("Portfolio Code: " + portfoliosData[i].getPortfolioCode());
			System.out.println("Portfolio Owner: " + portfoliosData[i].getOwnerCode());
			System.out.println("Portfolio Manager: " + portfoliosData[i].getManagerCode());

			Account[] accounts = portfoliosData[i].getAccounts();
			for (int j = 0; j < accounts.length; j++) {
				if (accounts[j] instanceof DepositAccount) {

					// makes a copy of what's already in the accounts array
					DepositAccount depositAccount = (DepositAccount) accounts[j];
					System.out.println("Code: " + depositAccount.getCode());
					System.out.println("Label: " + depositAccount.getLabel());
					System.out.println("APR: " + depositAccount.getApr());
					System.out.println("Total Balance: " + depositAccount.getTotalBalance());
					System.out.println();

				} else if (accounts[j] instanceof StockAccount) {
					StockAccount stockAccount = (StockAccount) accounts[j];
					System.out.println("Code: " + stockAccount.getCode());
					System.out.println("Label: " + stockAccount.getLabel());
					System.out.println("Quarterly Dividend: " + stockAccount.getQuarterlyDividend());
					System.out.println("Base Rate of Return: " + stockAccount.getBaseRateOfReturn());
					System.out.println("Beta Measure: " + stockAccount.getBetaMeasure());
					System.out.println("Stock Symbol: " + stockAccount.getStockSymbol());
					System.out.println("Share Price: " + stockAccount.getSharePrice());
					System.out.println("Number of Shares: " + stockAccount.getNumberOfShares());
					System.out.println();

				} else if (accounts[j] instanceof PrivateInvestmentAccount) {
					PrivateInvestmentAccount privateInvestmentAccount = (PrivateInvestmentAccount) accounts[j];
					System.out.println("Code: " + privateInvestmentAccount.getCode());
					System.out.println("Label: " + privateInvestmentAccount.getLabel());
					System.out.println("Quarterly Dividend: " + privateInvestmentAccount.getQuarterlyDividend());
					System.out.println("Base Rate of Return: " + privateInvestmentAccount.getBaseRateOfReturn());
					System.out.println("Omega Measure: " + privateInvestmentAccount.getOmegaMeasure());
					System.out.println("Total Value: " + privateInvestmentAccount.getTotalValue());
					System.out.println("Percentage: " + privateInvestmentAccount.getPercentage());
					System.out.println();

				}

			}
		}
	}
}
