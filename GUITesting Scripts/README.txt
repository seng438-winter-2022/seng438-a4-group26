Due to the varied nature of the web browsers and operating systems used it may be somewhat 
difficult to get these tests to run perfectly on all platforms. Certain lines of code may need to be commented
or modified such as 
	 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
depending on if your browser driver is configured to system enviroment variables. Additionally, the size of
screen may affect test results as some tests are designed to maximize to a certain screen. 