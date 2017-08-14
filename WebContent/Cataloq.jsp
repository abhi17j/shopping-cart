<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.Item" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table width="100%" height="100%" >
  <tr>
     <td width="100%" height="60%" bgcolor="maroon">&nbsp;</td>
  </tr>
  <tr>
     <td width="100%" height="60%" bgcolor="pink">
     <form action="addItems" method="post" name="loginForm">
     <table align="center"  width="100%" >
     <caption>Cataloq</caption>
     <tr bgcolor="yellow" >
        <th>Image</th><th>Description</th><th>Rate</th><th>&nbsp;</th>
     </tr>
     
     <%
        HttpSession ht=request.getSession();
        
        ArrayList a=(ArrayList)ht.getAttribute("a1");
        Iterator<Item> it=a.iterator();
        
        while(it.hasNext())
        {
        	Item item=(Item)it.next();
        
        %>
        <tr>
         <td cellpadding="30"><img src="<%=item.getImagePath() %>" width="80"
           height="50"></td>
           
           <td cellpadding="30"><b><%=item.getDescription() %></b></td>
           <td cellpadding="30">INR <%=item.getPrice() %></td>
           <td>&nbsp;<input type="checkbox" name="item<%=item.getId() %>" value="ON">
           </td>
        </tr>
        <%} %>
        
        <tr>
             <td cellpadding="30" colspan="4" align="centre" bgcolor="cyan"><input type="submit"
             name="submit" value="Purchase"></td>
        </tr>
     
     </table>
     </form>
     </td>
  </tr>

<tr>
    <td width="100%" height="20%" bgcolor="blue">&nbsp;</td>
</tr>
</table>
</body>
</html>