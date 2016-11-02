//
//Arjun Mangla (am4409)
//Intro To Java - COMS W1004
//Adam Cannon
//Spring 2016
//
//A program to guide a cashier in giving change
//
// Programming Project 1 - CashierProgram

// Importing Scanner to be able to use certain variables

import java.util.Scanner;

   public class Test {

	public static void main (String[] args)
	{

	// Initialising variables

	  int CashIn   = -1;
	  int CashDue  = -2;
	  int CashOut  = -3;
	  int pennies  = -4;
	  int dollars  = -5;
	  int quarters = -6;
	  int dimes    = -7;
	  int nickels  = -8;

	// Creating new scanner to accept input

	  Scanner scan = new Scanner (System.in);

	// To guide user for input

	  System.out.print ("Please enter the amount of money due in pennies: ");
	  CashDue = scan.nextInt();
	  System.out.print ("Please enter the amount of money recieved in pennies: ");
	  CashIn  = scan.nextInt();

	// Calculating amount to be given back

	  CashOut = (CashIn - CashDue);

	// Provision for invalid entries

	  if (CashIn<0 || CashDue<0)
	  {
		System.out.println("This is an invalid entry");
	  }
	  if (CashOut<0)
	  {
		System.out.println("This is not enough money. Please give me more money or give me the stuff back. You aren't rich enough. ");
	  }
	  else
	  {

	// Calculating values

	  dollars  = CashOut/100;
	  quarters = (CashOut - (dollars*100))/25;
	  dimes    = (CashOut - (dollars*100) - (quarters*25))/10;
	  nickels  = (CashOut- (dollars*100) - (quarters*25) - (dimes*10))/5;
	  pennies  = (CashOut - (dollars*100) - (quarters*25) - (dimes*10)-(nickels*5));


	// Printing calculated values

	  System.out.println(" Please give back " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels and " + pennies + " pennies ");
	    }
	  }
	}
