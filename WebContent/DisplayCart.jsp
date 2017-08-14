<%@ page import="test.*" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   Cart cart=(Cart)session.getAttribute("cart");
   ArrayList cartItems=cart.getCartItems();
   Iterator itr=cartItems.iterator();
%>
<table width="100%" height="100%" bgcolor="red">

   <tr>
       <td width="100%" height="100%" bgcolor="blue">&nbsp;</td>
   </tr>
   
   
   <tr>
       <td width="100%" height="100%" bgcolor="DarkCyan">
       <form action="decision" method="post">
       <table width="100%" cellpadding="10" cellspacing="0">
       <caption>Your cart</caption>
          
          <tr>
               <th>Item Purchased</th>
               <th>Quantity</th>
               <th>Rate</th>
               <th>Remove</th>
          </tr>
          <% while(itr.hasNext())
        	{
        	  CartItem cartItem=(CartItem)itr.next();
          %>  
          <tr>
              <td><%=cartItem.getItem().getDescription() %></td>
              <td>
                  <input type="text" name="t<%=cartItem.getCartItemId()%>" size="1"
                   value="<%=cartItem.getQuantity()%>">
              </td>
              <td>INR<%=cartItem.getItem().getPrice() %></td>
              <td>
                  <input type="checkbox" name="p<%=cartItem.getItem().getId() %>"
                  value="ON">
              </td>
          </tr>	
          <%} %>
          
          <tr>
              <td colspan="2">Total Amount</td>
              <td>INR<%=cart.getCartvaValue() %></td>
              <td>&nbsp;</td>
          </tr>
          
          <tr>
              <td colspan="4">
              <input type="submit" value="Update Cart" name="action">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="submit" value="shop more" name="action">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="submit" value="freeze cart" name="action">
              </td>
          </tr>
       </table>
       </td>
   </tr>
   <tr>
       <td width="100%" height="20%" bgcolor="orange">&nbsp;</td>
   </tr>
</table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  </form>
</body>
</html>












