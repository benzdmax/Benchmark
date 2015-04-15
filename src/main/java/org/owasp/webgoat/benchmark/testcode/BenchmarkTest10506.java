package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10506")
public class BenchmarkTest10506 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a58951 = param; //assign
		StringBuilder b58951 = new StringBuilder(a58951);  // stick in stringbuilder
		b58951.append(" SafeStuff"); // append some safe content
		b58951.replace(b58951.length()-"Chars".length(),b58951.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58951 = new java.util.HashMap<String,Object>();
		map58951.put("key58951", b58951.toString()); // put in a collection
		String c58951 = (String)map58951.get("key58951"); // get it back out
		String d58951 = c58951.substring(0,c58951.length()-1); // extract most of it
		String e58951 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58951.getBytes() ) )); // B64 encode and decode it
		String f58951 = e58951.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f58951); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass