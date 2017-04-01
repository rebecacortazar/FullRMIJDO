package es.deusto.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;


import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for RMI and JDO - includes JUNIT, Cobertura and Contiperf
 */
@SuppressWarnings("unused")
@PerfTest(invocations = 50, threads=10)
@Required(max = 22000, average = 5000)
//
//@PerfTest(duration = 20000)
//@Required(max = 3335, average = 660)



public class RMITest {

	final static Logger logger = LoggerFactory.getLogger(RMITest.class);
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(RMITest.class);
	}
	@Rule public ContiPerfRule rule = new ContiPerfRule();

	@BeforeClass static public void setUp() {
		// Launch the RMI registry
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			logger.info("RMI registry ready.");
		} catch (Exception e) {
			logger.error("Exception starting RMI registry:");
			e.printStackTrace();
		}	
		
		logger.info("This is a test to showcase a server remoteness test; JVM properties by program");
		
		String cwd = RMITest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		logger.info("Codebase at: " + cwd);
		System.setProperty("java.rmi.server.codebase", "file:" + cwd);
		System.setProperty("java.security.policy", "target\\classes\\security\\java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//127.0.0.1:1099/Collector";
		logger.info(" * TestServer name: " + name);
		
		try {
			IServer theServer = new Server();
			Naming.rebind(name, theServer);
			logger.info("1. Server started and linked to RMIRegistry");
		} catch (RemoteException re) {
			logger.error(" # Collector RemoteException: " + re.getMessage());
			re.printStackTrace();
			System.exit(-1);
		} catch (MalformedURLException murle) {
			logger.error(" # Collector MalformedURLException: " + murle.getMessage());
			murle.printStackTrace();
			System.exit(-1);
		}
	}


	@Test public void testRMIApp() {
		try {
			String name = "//127.0.0.1:1099/Collector";
			IServer theServer = (IServer) java.rmi.Naming.lookup(name);
			// Register to be allowed to send messages
			theServer.registerUser("dipina", "dipina");
			logger.info("* Message coming from the server: '" + theServer.sayMessage("dipina", "dipina", "This is a test!") + "'" + "\n" + "\n");
			
		} catch (Exception re) {
			logger.error(" # Collector Exception: " + re.getMessage());
			re.printStackTrace();
			System.exit(-1);

		assertTrue( true );
	}
	}

	@AfterClass static public void tearDown() {
		//System.exit(0);
	}
}
