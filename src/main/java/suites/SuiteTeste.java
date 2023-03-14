package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bases.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
})

public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
