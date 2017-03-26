package es.deusto.client;


import es.deusto.server.IServer;

public class Client {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("uso: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			IServer objHello = (IServer) java.rmi.Naming.lookup(name);
			// Register to be allowed to send messages
			objHello.registerUser("dipina", "1234");
			System.out.println("* Message coming from the server: '" + objHello.sayMessage("dipina", "1234", "This is a test!") + "'");
			// Let's make the exception to be launched
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}