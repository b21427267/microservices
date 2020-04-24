import learnmicorservice.registration.EurekaServer;
import learnmicorservice.rest.phonenumber.PhoneNumberServer;
import learnmicorservice.rest.user.UserServer;
import learnmicorservice.web.WebServer;


public class Main {
	public static void main(String[] args) {

		String serverName = "";

		switch (args.length) {
		case 2:
			System.setProperty("server.port", args[1]);
		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			return;
		}

		if (serverName.equals("eureka")) {
			EurekaServer.main(args);
		} else if (serverName.equals("user")) {
			UserServer.main(args);
		} else if (serverName.equals("phonenumber")) {
			PhoneNumberServer.main(args);
		} else if (serverName.equals("web")) {
			WebServer.main(args);
		} else {
			System.out.println("Unknown server type: " + serverName);
		}
	}
}
