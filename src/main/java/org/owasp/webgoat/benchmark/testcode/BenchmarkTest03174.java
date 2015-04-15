package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03174")
public class BenchmarkTest03174 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a45926 = param; //assign
		StringBuilder b45926 = new StringBuilder(a45926);  // stick in stringbuilder
		b45926.append(" SafeStuff"); // append some safe content
		b45926.replace(b45926.length()-"Chars".length(),b45926.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map45926 = new java.util.HashMap<String,Object>();
		map45926.put("key45926", b45926.toString()); // put in a collection
		String c45926 = (String)map45926.get("key45926"); // get it back out
		String d45926 = c45926.substring(0,c45926.length()-1); // extract most of it
		String e45926 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d45926.getBytes() ) )); // B64 encode and decode it
		String f45926 = e45926.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g45926 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g45926); // reflection
		
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
		}
	}
}