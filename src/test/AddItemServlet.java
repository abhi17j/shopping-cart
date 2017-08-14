package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddItemServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		ItemDao dao=new ItemDao();
		HttpSession session=req.getSession();
		
		Cart cart=(Cart) session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		
		try 
		{
			int itemCount=dao.getItemCount();
			for(int i=1;i<=itemCount;i++)
			{
				String s=req.getParameter("item"+i);
				if(s!=null)
				{
					Item item=dao.getItem(i);
					CartItem cartItem=new CartItem("cartItem"+item.getId(),item,1);
					cart.addCartItems(cartItem);
				}
			}
			
			
		} catch (Exception e)
		{
			System.out.println("error in AdditemServlet");
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("DisplayCart.jsp");
		rd.forward(req, resp);
	}

}






