package com.abc.bankingapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	private String name;
	private int balance;
	private String email;
	private String custid;
	private String pwd;
	private String accno;
	private String Raccno;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRaccno() {
		return Raccno;
	}
	public void setRaccno(String raccno) {
		Raccno = raccno;
	}


	private Connection con = null;
	private PreparedStatement pstm=null;
	private ResultSet res = null;
	private ArrayList<Integer> arraylist;
	private ArrayList<String> arraylist1;
	
	
	
	
	
	public ArrayList<String> getArraylist1() {
		return arraylist1;
	}
	public void setArraylist1(ArrayList<String> arraylist1) {
		this.arraylist1 = arraylist1;
	}
	public ArrayList<Integer> getArraylist() {
		return arraylist;
	}
	public void setArraylist(ArrayList<Integer> arraylist) {
		this.arraylist = arraylist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}


	Model() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	public boolean login()
	{
		try {
			pstm = con.prepareStatement("select * from SWISS_BANK where custid = ? and pwd=?");
			pstm.setString(1, custid);
			pstm.setString(2, pwd);
			res = pstm.executeQuery();

			if (res.next()) {
				accno = res.getString("ACCNO");
				name=res.getString("NAME");
				balance=res.getInt("BALANCE");
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {
				if(res!=null)
					res.close();
				if(pstm!=null)
					pstm.close();
				if (con!=null) 
					con.close();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return false;
	}



	
	
	
	public boolean checkBalance()
	{
		try {
			pstm = con.prepareStatement("select * from SWISS_BANK where ACCNO = ?");
			pstm.setString(1, accno);
			res = pstm.executeQuery();

			if (res.next()) {
				balance = res.getInt("BALANCE");
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {
				if(res!=null)
					res.close();
				if(pstm!=null)
					pstm.close();
				if (con!=null) 
					con.close();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
return false;
	}

	
	public boolean changePwd()
	{
		try {
			pstm = con.prepareStatement("update SWISS_BANK set PWD=? where ACCNO=?");
			pstm.setString(1, pwd);
			pstm.setString(2, accno);
		int	res = pstm.executeUpdate();

			if (res==1) {
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {
				if(pstm!=null)
					pstm.close();
				if (con!=null) 
					con.close();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return false;
	}


	
	public boolean transfer()
	{
		try {
			pstm = con.prepareStatement("update SWISS_BANK set BALANCE=BALANCE-? where ACCNO=?");
			pstm.setInt(1, balance);
			pstm.setString(2, accno);
			int	res = pstm.executeUpdate();

			if (res==1) {
				
				pstm = con.prepareStatement("update SWISS_BANK set BALANCE=BALANCE+? where ACCNO=?");	
				
				pstm.setInt(1, balance);
				pstm.setString(2, Raccno);
				int	res2 = pstm.executeUpdate();
				
				if(res2==1)
				{
					pstm = con.prepareStatement("insert into statement values(?,?,?,?)");	
					
					pstm.setString(1, accno);
					pstm.setInt(2, (balance*-1));
					pstm.setString(3, time);
					pstm.setString(4, Raccno);
					int	res3 = pstm.executeUpdate();
					if(res3==1) {
						pstm = con.prepareStatement("insert into statement values(?,?,?,?)");	
						
						pstm.setString(1, Raccno);
						pstm.setInt(2, balance);
						pstm.setString(3, time);
						pstm.setString(4, accno);
						int	res4 = pstm.executeUpdate();
						
						if(res4==1) {
							return true;
						}
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {

			try {
				if(pstm!=null)
					pstm.close();
				if (con!=null) 
					con.close();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return false;
	}
	void getStatement()
	{
		try {
			pstm = con.prepareStatement("select * from statement where ACCNO=?");	
			
			pstm.setString(1, accno);
			res = pstm.executeQuery();
			arraylist=new ArrayList<Integer>();
			arraylist1=new ArrayList<String>();
			while(res.next())
			{
				arraylist.add(res.getInt("BALANCE"));
				arraylist1.add(res.getString("ACCNO"));
			}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}
