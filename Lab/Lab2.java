
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.Cookie;
import java.util.Date;



public class Lab2 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookiesList = request.getCookies();
		String username = "";
		String comments = "";
		if(cookiesList!= null){
			for(int i = 0;i<cookiesList.length;i++){
				Cookie c = cookiesList[i];
				
				String name = c.getName();
				if(name.equals("cookieDate")){
					String value = c.getValue();
					out.println("The information was Submitted at"+value);
				}
				if(name.equals("username")){
					username = c.getValue();
				}
				if(name.equals("comments")){
					comments = c.getValue();
				
				}
					
			}
		}
		out.println("<html>");
		out.println("<head><title>Lab2</title></head>");
		out.println("<body>");
		out.println("<form action='Lab2' method='post'>");
		out.println("Name: <input type='text' name='username' value='"+username+"'/></br></br>");
		out.println("comments: <input type='text' name='comments' value='"+comments+"'/></br></br>");
		out.println("<input type='checkbox' name='rememberMe' value='yes'/>Remember Me</br>");
		out.println("<input type='submit' value='Submit'/>");
		out.println("</body></html>");
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Date date = new Date();
			out.println("<html>");
			out.println("<head><title> Lab2 form processed </title></head>");
			out.println("<body>");
			out.println("<h3> Thank you for providing your suggestions </h3>");
			out.println("Name:"+request.getParameter("username"));
			out.println("Comments:"+request.getParameter("comments"));
			
			if(request.getParameter("rememberMe").equals("yes")){
				Cookie cookieName = new Cookie("username",request.getParameter("username"));
				Cookie cookieComments = new Cookie("comments",request.getParameter("comments"));
				Cookie cookieDate = new Cookie("cookieDate",date.toString());
				
				response.addCookie(cookieName);
				response.addCookie(cookieComments);
				response.addCookie(cookieDate);
				
				
			}
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
}