package QAlegendTestCases;

import org.testng.ITestResult;

public class RetryAnalyzer {
int counter=0;
int retrylimit=3;

public boolean retry(ITestResult result) {
	if(counter<retrylimit) {
		counter++;
		return true;
	}
	return false;
}
}
