package org.jboss.classloading;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jboss.classloadingtest.Util;

public class DemoServlet extends HttpServlet {


  private static final Log log = LogFactory.getLog(DemoServlet.class);
  

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  log.info("Processing request");
    
	response.setContentType("text/html");
    
	PrintWriter writer = response.getWriter();
	writer.append("<html><body>");
    writer.append("You are running in the " + System.getProperty("env") + " environment.");
    writer.append("<br>");
    writer.append("Msg 1 = " + Util.getInstance().getMsg("msg1"));
    writer.append("</body></html>");

  }
}
