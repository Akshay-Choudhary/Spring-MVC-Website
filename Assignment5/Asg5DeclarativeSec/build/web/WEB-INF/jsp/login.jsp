<%-- 
    Document   : login
    Created on : Mar 12, 2016, 5:21:02 PM
    Author     : gupta.abhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body style="background-color: #BFB5A3">
        Please Login First
        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <tr>
                    <td>Login User:</td>
                    <td> <INPUT TYPE="TEXT" NAME="j_username" ></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td> <INPUT TYPE="PASSWORD" NAME="j_password"></td>
                </tr>
                <tr><th><INPUT TYPE="SUBMIT" VALUE="Authenticate"></tr>
            </TABLE>
        </FORM>    
    </body>
</html>
