package genric;

public interface IAutoConst {
	public static final String CHROME_KEY="webdriver.gecko.driver";
	public static final String CHROME_VALUE="./drivers/geckodriver.exe";
	
	public static final String FIREFOX_KEY="webdriver.chrome.driver";
	public static final String FIREFOX_VALUE="./drivers/chromedriver.exe";
	
	String CONFIG_PATH="./config.properties";
	String SUMMARY_PATH="./result/Summary.xlsx";
	
	String INPUT_PATH="./data/input.xlsx";
	String PHOTO_PATH="./photo";
	

}
