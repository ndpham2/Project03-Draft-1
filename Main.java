import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {
	private Person[] personData = null;
	private Account[] accountData = null;
	private Portfolio[] portfoliosData = null;
	private int rowCount = 0;

	private Scanner scanPersons = null;
	private Scanner scanAssets = null;
	private Scanner scanPortfolios = null;

	// constructor initializes all data
	public Main() {
		try {
			scanPersons = new Scanner(new File("data/Persons.dat"));
			scanAssets = new Scanner(new File("data/Assets.dat"));
			scanPortfolios = new Scanner(new File("data/Portfolios.dat"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				makePerson(scanPersons);
				break;
			case 1:
				makeAccount(scanAssets);
				break;
			case 2:
				makePortfolios(scanPortfolios);
				break;
			}
		}
	}

	private void makePerson(Scanner scanPersons) {
		if (scanPersons.hasNextInt()) {
			rowCount = scanPersons.nextInt();
			personData = new Person[rowCount];
			scanPersons.nextLine();
		} else {
			System.out.println("Bad file format, expected integer.");
			System.exit(-1);
		}

		// create person object
		String id = "";
		String broker = "";
		String firstName = "";
		String lastName = "";
		String street = "";
		String city = "";
		String state = "";
		String zipCode = "";
		String country = "";
		String[] emailAddress = null;

		for (int r = 0; r < personData.length; r++) {
			String row = scanPersons.nextLine();
			String[] column = row.split(";");
			boolean isBroker = (!column[1].isEmpty());
			String[] temp = null;

			// create client object
			for (int c = 0; c < column.length; c++) {
				switch (c) {
				case 0: // id
					id = column[0];
					break;
				case 1: // broker
					if (isBroker) {
						broker = column[1];
					}
					break;
				case 2: // full name
					temp = column[2].split(",");
					if (!temp[1].isEmpty()) {
						firstName = temp[1];
					}
					if (!temp[0].isEmpty()) {
						lastName = temp[0];
					}
					break;
				case 3: // address
					temp = column[3].split(",");
					if (!temp[0].isEmpty()) {
						street = temp[0];
					}
					if (!temp[1].isEmpty()) {
						city = temp[1];
					}
					if (!temp[2].isEmpty()) {
						state = temp[2];
					}
					if (!temp[3].isEmpty()) {
						zipCode = temp[3];
					}
					if (!temp[4].isEmpty()) {
						country = temp[4];
					}
					break;
				case 4: // email addresses
					temp = column[4].split(",");
					emailAddress = new String[temp.length];
					for (int f = 0; f < temp.length; f++) {
						emailAddress[f] = temp[f];
					}
					break;
				}
			}
			if (isBroker) {
				personData[r] = new Broker(id, firstName, lastName, street, city, state, zipCode, country, emailAddress,
						broker);
			} else {
				personData[r] = new Client(id, firstName, lastName, street, city, state, zipCode, country,
						emailAddress);
			}
		}
	}

	private void makeAccount(Scanner scanAssets) {
		if (scanAssets.hasNextInt()) {
			rowCount = scanAssets.nextInt();
			accountData = new Account[rowCount];
			scanAssets.nextLine();
		} else {
			System.out.println("Bad file format, expected integer.");
			System.exit(-1);
		}
		
		// create account objects
		String code = "";
		String label = "";
		double apr = 0.0;
		double quarterlyDividend = 0.0;
		double baseRateOfReturn = 0.0;
		double omegaMeasure = 0.0;
		double totalValue = 0.0;
		double betaMeasure = 0.0;
		String stockSymbol = "";
		double sharePrice = 0.0;

		for (int r = 0; r < accountData.length; r++) {
			String row = scanAssets.nextLine();
			String[] column = row.split(";");
			String accountType = column[1];

			// create client object
			for (int c = 0; c < column.length; c++) {
				// all classes need this
				code = column[0];
				label = column[2];

				switch (accountType) {
				case "D": // store the fields and create DepositAccount
					apr = Double.parseDouble(column[3]);
					accountData[r] = new DepositAccount(code, label, apr);
					break;
				case "S": // store the fields and create StockAccount
					quarterlyDividend = Double.parseDouble(column[3]);
					baseRateOfReturn = Double.parseDouble(column[4]);
					betaMeasure = Double.parseDouble(column[5]);
					stockSymbol = column[6];
					sharePrice = Double.parseDouble(column[7]);
					accountData[r] = new StockAccount(code, label, quarterlyDividend, baseRateOfReturn, betaMeasure,
							stockSymbol, sharePrice);
					break;
				case "P": // store the fields and create PrivateInvestmentAccount
					quarterlyDividend = Double.parseDouble(column[3]);
					baseRateOfReturn = Double.parseDouble(column[4]);
					omegaMeasure = Double.parseDouble(column[5]);
					totalValue = Double.parseDouble(column[6]);
					accountData[r] = new PrivateInvestmentAccount(code, label, quarterlyDividend, baseRateOfReturn,
							omegaMeasure, totalValue);
					break;
				}
			}
		}
	}

	private void makePortfolios(Scanner scanPortfolios) {
		if (scanPortfolios.hasNextInt()) {
			rowCount = scanPortfolios.nextInt();
			portfoliosData = new Portfolio[rowCount];
			scanPortfolios.nextLine();
		} else {
			System.out.println("Bad file format, expected integer.");
			System.exit(-1);
		}

		String portfolioCode = " ";
		String ownerCode = " ";
		String managerCode = " ";
		String beneficiaryCode = " ";
		Account[] accounts = null;

		for (int r = 0; r < portfoliosData.length; r++) {
			String row = scanPortfolios.nextLine();
			String[] column = row.split(";");
			String[] temp = null;

			for (int c = 0; c < column.length; c++) {
				switch (c) {
				case 0: // portfolio code
					portfolioCode = column[0];
					break;
				case 1: // owner code
					ownerCode = column[1];
					break;
				case 2: // manager code
					managerCode = column[2];
					break;
				case 3: // beneficiary code
					beneficiaryCode = column[3];
					break;
				case 4: // create accounts
					// this code is for the assets information
					temp = column[4].split(",");
					accounts = new Account[temp.length];
					// at this level, we are looping through the account:value pair
					// e.g. [stock:share quantity]
					for (int i = 0; i < temp.length; i++) {
						String[] temp2 = temp[i].split(":");
						String accountCode = temp2[0];
						for (int j = 0; j < accountData.length; j++) {
							if (accountCode.equalsIgnoreCase(accountData[j].getCode())) {
								// in here means we've found a match on the account code
								if (accountData[j] instanceof DepositAccount) {
									// then create a new deposit account and put it in our account array in our portfolio
									DepositAccount tempAccount = (DepositAccount) accountData[j];
									DepositAccount portfolioAccount = new DepositAccount(tempAccount.getCode(), tempAccount.getLabel(), tempAccount.getApr());
									portfolioAccount.setTotalBalance(Double.parseDouble(temp2[1]));
									accounts[i] = portfolioAccount;
								} else if (accountData[j] instanceof StockAccount) {
									StockAccount tempAccount = (StockAccount) accountData[j];
									StockAccount portfolioAccount = new StockAccount(tempAccount.getCode(), tempAccount.getLabel(), 
											tempAccount.getQuarterlyDividend(), tempAccount.getBaseRateOfReturn(), 
											tempAccount.getBetaMeasure(), tempAccount.getStockSymbol(), tempAccount.getSharePrice());
									portfolioAccount.setNumberOfShares(Double.parseDouble(temp2[1]));
									accounts[i] = portfolioAccount;
								} else if (accountData[j] instanceof PrivateInvestmentAccount) {
									PrivateInvestmentAccount tempAccount = (PrivateInvestmentAccount) accountData[j];
									PrivateInvestmentAccount portfolioAccount = new PrivateInvestmentAccount(tempAccount.getCode(), tempAccount.getLabel(),
											tempAccount.getQuarterlyDividend(), tempAccount.getBaseRateOfReturn(),
											tempAccount.getOmegaMeasure(), tempAccount.getTotalValue());
									portfolioAccount.setPercentage(Double.parseDouble(temp2[1]));
									accounts[i] = portfolioAccount;
								}
							}
						}
					}
					break;
				}
				
			}
			// Make the actual portfolio object and add it to the portfolio array 
			// each row will be one object. and you will put the 10 objects into the portfolio array
			portfoliosData[r] = new Portfolio(portfolioCode, ownerCode, managerCode, beneficiaryCode, accounts);	
		}
	}

	public static void main(String[] args) throws Exception {
		Main instance = new Main();
		printPersons(instance.getPersonsData());
		printAccounts(instance.getAccountData());

		FileWriter.writePersonsToXML(instance.getPersonsData());
		FileWriter.writeAccountsToXML(instance.getAccountData());

		FileWriter.writePersonsToJson(instance.getPersonsData());
		FileWriter.writeAccountsToJson(instance.getAccountData());
		
		PortfolioReportWriter.createSummaryReport(instance.getPortfoliosData());
		PortfolioReportWriter.createDetailReport(instance.getPortfoliosData());

	}

	private static void printAccounts(Account[] accountData) {
		for (int i = 0; i < accountData.length; i++) {
			
			// storing account types in account variable
			Account account = accountData[i]; 
			System.out.println(account.toString());
		}

	}

	private static void printPersons(Person[] personsData) {
		for (int i = 0; i < personsData.length; i++) {
			Person person = personsData[i]; //
			System.out.println(person.toString());
		}
	}
	
	public Person[] getPersonsData() {
		return personData;
	}

	public Account[] getAccountData() {
		return accountData;
	}

	public Portfolio[] getPortfoliosData() {
		return portfoliosData;
	}
}