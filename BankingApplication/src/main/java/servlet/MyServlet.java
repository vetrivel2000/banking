package servlet;
import javax.servlet.http.*;

import dbtask.databasemanagement.DataBase;
import dbtask.logical.LogicalLayer;
import dbtask.account.AccountInfo;
import dbtask.customer.CustomerInfo;
import javax.servlet.*;  
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;  
public class MyServlet extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{  
res.setContentType("text/html");//setting the content type  
String choice = req.getParameter("users");
DataBase db = new DataBase();
LogicalLayer logical = new LogicalLayer();

ArrayList<CustomerInfo> customerList=null;
ArrayList<AccountInfo> accountList=null;

if(choice.equals("Customer"))
{
	try {
		customerList = logical.getCustomers();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("output", customerList);
	RequestDispatcher  rd=req.getRequestDispatcher("Customers.jsp");
	rd.forward(req, res);
}
else if(choice.equals("Account"))
{
	try {
		accountList = logical.getAccounts();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("account", accountList);
	RequestDispatcher rd=req.getRequestDispatcher("Accounts.jsp");
	rd.forward(req, res);
}
else if(choice.equals("AddAccount"))
{
	RequestDispatcher rd=req.getRequestDispatcher("AddAccount.jsp");
	rd.forward(req, res);
}
else if(choice.equals("AddCustomer"))
{
	RequestDispatcher rd=req.getRequestDispatcher("AddCustomer.jsp");
	rd.forward(req, res);
}
else if(choice.equals("DeleteAccount"))
{
	int accountNumber=Integer.parseInt(req.getParameter("accountNum"));
	int customerId=Integer.parseInt(req.getParameter("customerId"));
	System.out.print(accountNumber);
	System.out.print(customerId);
	
	try {
		logical.deleteAccount(accountNumber, customerId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PrintWriter pw = res.getWriter();
	pw.println("Your account deleted successfully");
}
else if(choice.equals("DeleteCustomer"))
{
	int customerId=Integer.parseInt(req.getParameter("customerId"));
	try {
		logical.deleteCustomer(customerId);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	PrintWriter pw = res.getWriter();
	pw.println("Your accounts deleted successfully");
}
else if(choice.equals("SubmitNewAccount"))
{
	int customerId=Integer.parseInt(req.getParameter("id"));
	double balance=Double.parseDouble(req.getParameter("balance"));
	AccountInfo accountObject = LogicalLayer.getAccountObject(customerId,balance);
	AccountInfo object=null;
	try {
		object= LogicalLayer.getInstance().setAccount(accountObject);
	} catch (Exception e) {
		e.printStackTrace();
	}
	PrintWriter pw = res.getWriter();
	pw.println("Your new account details are:" +object);
}
else if(choice.equals("SubmitNewCustomer"))
{
	String name=req.getParameter("name");
	double balance=Double.parseDouble(req.getParameter("balance"));
	long mobileNumber=Long.parseLong(req.getParameter("mobile"));
	  CustomerInfo customerDetails = LogicalLayer.getCustomerObject(name,mobileNumber);
      CustomerInfo object=null;
      try {
    	  object=LogicalLayer.getInstance().setCustomer(customerDetails);
      }
      catch(Exception e){
    	  e.printStackTrace();
      }
      int customerId=object.getCustomerId();
      AccountInfo accountDetails = LogicalLayer.getAccountObject(customerId,balance);
      AccountInfo object1=null;
  	try {
  		object1= LogicalLayer.getInstance().setAccount(accountDetails);
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	PrintWriter pw = res.getWriter();
	pw.println("Your new customer details are:" +object);
	pw.println("Your new account details are:" +object1);
}
else if(choice.equals("Transaction"))
{
	try {
		accountList = logical.getAccounts();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	req.setAttribute("transaction", accountList);
	RequestDispatcher rd=req.getRequestDispatcher("Transactions.jsp");
	rd.forward(req, res);
}

//closing the stream  
}
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	doPost(req,res);
}
}  