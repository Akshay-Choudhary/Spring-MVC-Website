import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHeaders extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 Enumeration<String> headerNames = req.getHeaderNames();
			while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println(headerName);
			out.println("<br>");

			/*Enumeration<String> headers = req.getHeaders(headerName);
			while (headers.hasMoreElements()) {
			String headerValue = headers.nextElement();
			out.println("t" + headerValue);
			out.println("n");
			}*/
		}
		out.close();
	}

}
