package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18022")
public class BenchmarkTest18022 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map32078 = new java.util.HashMap<String,Object>();
		map32078.put("keyA-32078", "a_Value"); // put some stuff in the collection
		map32078.put("keyB-32078", param.toString()); // put it in a collection
		map32078.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map32078.get("keyB-32078"); // get it back out
		bar = (String)map32078.get("keyA-32078"); // get safe value back out
	
		return bar;	
	}
}