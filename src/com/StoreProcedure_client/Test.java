package com.StoreProcedure_client;

import java.util.Scanner;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.StoreProcedure_model.Hibernateutil;

public class Test
{
	Scanner sc=new Scanner(System.in);
	Session session=Hibernateutil.getsessionfactory().openSession();
	public void insertDeta()
	{
		StoredProcedureQuery sp=session.createStoredProcedureCall("insertdata");
		sp.registerStoredProcedureParameter("rn", Integer.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter("nm", String.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter("ad", String.class, ParameterMode.IN);
		System.out.println("Enter Roll No");
		String x=sc.next();//+" "+sc.nextLine();
		sp.setParameter("rn",x);
		System.out.println("Enter Name");
		sp.setParameter("nm", x);
		System.out.println("Enter Address");
		sp.setParameter("ad", x);
		Transaction tx=session.beginTransaction();
		sp.executeUpdate();
		tx.commit();
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Test t=new Test();
		while(true)
		{
			System.out.println("**** Select ****");
			System.out.println("Enter 1 for Insert Data");
			int x=sc.nextInt();
			switch (x) 
			{
			case 1: 
			 	{
			 		t.insertDeta();
			 	}
			}
		}
		
	}
}
