/*import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import static org.junit.Assert.*;*/
/*
class TestClient {
	
	public static void main (String argv[]) throws Exception
	{
		//ConcertInfo [] concerts = new ConcertInfo [100];
		
		boolean wrtieToFile = false; // boolean which will be true if -v in command line 
		boolean disFile = false; // bollean which will be true if -V is command line 
		if (argv.length == 0) // checking if user put an arugment -v or -V
		{
			System.out.println ("Client running, No option slected. Acitivity will not be logged in file or display.");
		}import java.io.*;
		import java.net.*;
		import java.util.ArrayList;
		import java.util.Collections;
		import java.util.Scanner;
		//import static org.junit.Assert.*;

		class TestClient {
			
			public static void main (String argv[]) throws Exception
			{
				//ConcertInfo [] concerts = new ConcertInfo [100];
				
				boolean wrtieToFile = false; // boolean which will be true if -v in command line 
				boolean disFile = false; // bollean which will be true if -V is command line 
				if (argv.length == 0) // checking if user put an arugment -v or -V
				{
					System.out.println ("Client running, No option slected. Acitivity will not be logged in file or display.");
				}
				else if (argv[0].equals("-v")) // checking if user enters -v in command line
				{
					wrtieToFile = true;
					System.out.println ("-v Selected : All data logged clientLog.txt.");
				}
				else if (argv[0].equals("-V")) // checking if user enters -V in command line 
				{
					disFile = true;
					System.out.println ("-V Selected : All data logged clientLog.txt and Display.");
				}
				
				//Socket client_sock = new Socket ("134.124.30.128", 13030);
				Socket client_sock = new Socket ("localhost", 13030);
				DataOutputStream toServer = 
					new DataOutputStream (client_sock.getOutputStream ());
				BufferedReader fromServer =
					new BufferedReader (new InputStreamReader (
						client_sock.getInputStream ()));


				java.io.File file = new java.io.File ("clientLog.txt");
				Scanner fileInput = new Scanner (file);
				java.io.PrintWriter fileOutput = new java.io.PrintWriter (file);


				BufferedReader fromKeybd =
					new BufferedReader (new InputStreamReader (System.in));

				
				String inLine, changedLine;
				int inputType = 0;

				try 
				{
					while (true) 
					{
						if (wrtieToFile || disFile) // if users enters -v or -V will print to file 
						{
							fileOutput.println("\n*******  Please Insert  *******");
							fileOutput.println("*  Day of the Week (Ex. Mon)  *");
							fileOutput.println("*        Band name            *");
							fileOutput.println("*  Money Amount (without $)   *");
							fileOutput.println("*    Type Bye to Exit         *");
							fileOutput.println("*******************************\n");
						}

						if (disFile) // if users enters -v or -V will print to file 
						{
							System.out.print("\n*******  Please Insert  *******\n");
							System.out.print("*  Day of the Week (Ex. Mon)  *\n");
							System.out.print("*        Band name            *\n");
							System.out.print("*  Money Amount (without $)   *\n");
							System.out.print("*    Type Bye to Exit         *\n");
							System.out.print("*******************************\n");
							System.out.print("input :");
						}
						
						inLine = fromKeybd.readLine (); // reading from the keyboard 
						
						if (wrtieToFile || disFile) // display whatt input it is 
						{
							fileOutput.println("input :" + inLine);
						}
						
						inputType = check (inLine); // sending to check function to see what type of input 
						// input 1 = day of the week, input 2 = Currenct , input 3 = band name / random mistake typed 

						if (inLine.equalsIgnoreCase("Bye")) // if the user wants to exit
						{
							toServer.writeBytes ("\n"); // lets the server know goodbye 
							break;
						}

						String intInput = inputType + ""; // modified to send to the server 
						
						if (wrtieToFile || disFile) // printing what sent server 
						{
							fileOutput.println ("Message to Server: " + inLine + "  || Input type: " + inputType);
						}
						
				
						inLine += (", " + intInput);
				 
						toServer.writeBytes (inLine + "\n"); // Sending message to server 
						
						int entries = 0; // to know how many different concerts i'm recinving 
						int entries2 = 0; // for the money algorithm to know the amount of entires 
						int entries3 = 0;
						String servOutput = " "; // to take server output into one file 
						
		             //-------- Reading from the Server --------
						do // getting message form server 
						{
							changedLine = fromServer.readLine();
							servOutput += (String.valueOf(changedLine)); // adding to the one string 
							
							if (!changedLine.equals("End"))
							{
								servOutput += " "; // adding space to string 
								entries++; // to know how many concerts are coming to the client side 
							}
							if (changedLine.equals("OPEnd"))
							{
								entries2++; // to know how many concerts are coming to the client side 
							}
						} while (!changedLine.equals("End")); // server will send End to indicate stop of message 
						
						
						if (wrtieToFile || disFile) // Writing server output too txt file
						{
							fileOutput.println ("From Server: " + servOutput);
						}
						
						String parts [] = null;
						parts = servOutput.split(" ");
						parts[0] = null;
						// System.out.println (parts[1]);
						
						ArrayList<ConcertPrint> Concerts = new ArrayList<ConcertPrint>(); // to keep track of all the concerts to order them 
						
								//System.out.println(servOutput);
						if(inputType == 3 || inputType == 1)
						{
							// System.out.println("ServOutPUt: " + servOutput);
							for (int i = 1; i <= parts.length; i++)
							{
								// System.out.println("part[i]=" + parts[i]);
								if (parts[i].equals("End")) 
								{
									break; // breaking array if 
								}
								else
								{ 
									ConcertPrint concert  = new ConcertPrint(parts[i],parts[i+1],parts[i+2],parts[i+3],parts[i+4],parts[i+5],parts[i+6]);	
									Concerts.add(concert);
								}
								i +=6;
							}
						}
						//int [][] disp = new int [entries][3];
						if (inputType == 1) // User has inputed the day of the week 
						{
							Collections.sort(Concerts); // sorting venue names if the user inputs Day of the week 
						}
						else if (inputType == 3)
						{
							Collections.sort(Concerts, ConcertPrint.getdayOfConcert1());
						}
						else if (inputType == 2)
						{
							// System.out.println("Entires :" + entries2);
							// System.out.println("Entires :" + entries3);
							int op = 1;
							for (int i =1; i <= parts.length ; i++)
							{
								if (i == 1)
								{
									System.out.println("Option: " + op +"\n");
									op++;
								}
								else if (parts[i+1].equals("End")) 
								{
									break; // breaking array if 
								}
								else if (parts[i].equals("OPEnd"))
								{
									System.out.println("Option: " + op +"\n");
									i++; op++;
								}
								System.out.println(parts[i] + " " + parts[i+1]+ " " + parts[i+2]+ " " +parts[i+3]+ " " +parts[i+4]+ " " +parts[i+5]+ " " +parts[i+6]);
								i +=6;
								
								if (parts[i+1].equals("End")) 
								{
									break; // breaking array if 
								}
							}
						}
						
						if(inputType == 3 || inputType == 1)
						{
							if (wrtieToFile || disFile) //writing to client log / screen 
							{
								String toFile;
								ConcertPrint display = new ConcertPrint();
								for (int i =0; i < Concerts.size(); i++)
								{
									display = Concerts.get(i);
									//toFile = display.Display(); // printing the Concerts form the display function in concertPrint 
									if (disFile) 
									{ 
										if (inputType == 1) // display different if band name entered 
										{
											toFile = display.DisplayDay();
											System.out.println(toFile);
											fileOutput.print("To Screen: ");
											fileOutput.println(toFile);
										}
										else if (inputType == 3) // display different if Day of the week entered 
										{
											toFile = display.Display();
											System.out.println(toFile);
											fileOutput.print("To Screen: ");
											fileOutput.println(toFile);
										}	
									}
									else if (wrtieToFile)
									{
										if (inputType == 1) // display different if band name entered 
										{
											toFile = display.DisplayDay();
											//System.out.println(toFile);
											fileOutput.print("To Screen: ");
											fileOutput.println(toFile);
										}
										else if (inputType == 3) // display different if Day of the week entered 
										{
											toFile = display.Display();
											//System.out.println(toFile);
											fileOutput.print("To Screen: ");
											fileOutput.println(toFile);
										}
									}
									
								}	
							
							
							}
						}
					
					}
				}
					finally
					{
						client_sock.close();
						fileOutput.close();
						fileInput.close();
					}
			
				
			}
			public static int check (String input) // Checks user's input 
			{
				// System.out.println("input: " + input);
				// checking if user entered day of the week || money || Band 
				if (input.equalsIgnoreCase("Mon") || input.equalsIgnoreCase("Tue")|| input.equalsIgnoreCase("Wed")
						|| input.equalsIgnoreCase("Thu") || input.equalsIgnoreCase("Fri") || input.equalsIgnoreCase("Sat")
						|| input.equalsIgnoreCase("Sun"))
				{
					//System.out.println("Day fo the Week");
					return 1; //returning 1 for the server know its day of the week 
				}
				else if (isNumeric(input)){ // checking if user inputed Money Amount 
					//System.out.println("number");
					return 2; // returning 2 to let the server know its a dollar amount 
				}
				else 
				{
					return 3; // returning 3 to let the server know it is a band name or something random 
				}
				
			}
			public static boolean isNumeric (String input){ // this checks of the input is a number 
				try{
					double d = Double.parseDouble(input);
				}
				catch (NumberFormatException nfe){
					return false; // returns false if it is not a number 
				}
				return true;
			}
			

		}



		 
		else if (argv[0].equals("-v")) // checking if user enters -v in command line
		{
			wrtieToFile = true;
			System.out.println ("-v Selected : All data logged clientLog.txt.");
		}
		else if (argv[0].equals("-V")) // checking if user enters -V in command line 
		{
			disFile = true;
			System.out.println ("-V Selected : All data logged clientLog.txt and Display.");
		}
		
		//Socket client_sock = new Socket ("134.124.30.128", 13030);
		Socket client_sock = new Socket ("localhost", 13030);
		DataOutputStream toServer = 
			new DataOutputStream (client_sock.getOutputStream ());
		BufferedReader fromServer =
			new BufferedReader (new InputStreamReader (
				client_sock.getInputStream ()));


		java.io.File file = new java.io.File ("clientLog.txt");
		Scanner fileInput = new Scanner (file);
		java.io.PrintWriter fileOutput = new java.io.PrintWriter (file);


		BufferedReader fromKeybd =
			new BufferedReader (new InputStreamReader (System.in));

		
		String inLine, changedLine;
		int inputType = 0;

		try 
		{
			while (true) 
			{
				if (wrtieToFile || disFile) // if users enters -v or -V will print to file 
				{
					fileOutput.println("\n*******  Please Insert  *******");
					fileOutput.println("*  Day of the Week (Ex. Mon)  *");
					fileOutput.println("*        Band name            *");
					fileOutput.println("*  Money Amount (without $)   *");
					fileOutput.println("*    Type Bye to Exit         *");
					fileOutput.println("*******************************\n");
				}

				if (disFile) // if users enters -v or -V will print to file 
				{
					System.out.print("\n*******  Please Insert  *******\n");
					System.out.print("*  Day of the Week (Ex. Mon)  *\n");
					System.out.print("*        Band name            *\n");
					System.out.print("*  Money Amount (without $)   *\n");
					System.out.print("*    Type Bye to Exit         *\n");
					System.out.print("*******************************\n");
					System.out.print("input :");
				}
				
				inLine = fromKeybd.readLine (); // reading from the keyboard 
				
				if (wrtieToFile || disFile) // display whatt input it is 
				{
					fileOutput.println("input :" + inLine);
				}
				
				inputType = check (inLine); // sending to check function to see what type of input 
				// input 1 = day of the week, input 2 = Currenct , input 3 = band name / random mistake typed 

				if (inLine.equalsIgnoreCase("Bye")) // if the user wants to exit
				{
					toServer.writeBytes ("\n"); // lets the server know goodbye 
					break;
				}

				String intInput = inputType + ""; // modified to send to the server 
				
				if (wrtieToFile || disFile) // printing what sent server 
				{
					fileOutput.println ("Message to Server: " + inLine + "  || Input type: " + inputType);
				}
				
		
				inLine += (", " + intInput);
		 
				toServer.writeBytes (inLine + "\n"); // Sending message to server 
				
				int entries = 0; // to know how many different concerts i'm recinving 
				
				String servOutput = " "; // to take server output into one file 
				do // getting message form server 
				{
					changedLine = fromServer.readLine();
					servOutput += (String.valueOf(changedLine)); // adding to the one string 
					
					
					if (!changedLine.equals("End"))
					{
						servOutput += " "; // adding space to string 
						entries++; // to know how many concerts are coming to the client side 
					}
				} while (!changedLine.equals("End")); // server will send End to indicate stop of message 
				
				if (wrtieToFile || disFile) // Writing server output too txt file
				{
					fileOutput.println ("From Server: " + servOutput);
				}
				
				String parts [] = null;
				if(inputType == 3 || inputType == 1) // splitting up string for if the user enters 
				{
					parts = servOutput.split(" ");
					 parts[0] = null;
					// System.out.println (parts[1]);
				}
				else // this is for the printing the Money ammount optimized options 
				{
					System.out.println(servOutput);
				}
				
				ArrayList<ConcertPrint> Concerts = new ArrayList<ConcertPrint>(); // to keep track of all the concerts to order them 
				
						//System.out.println(servOutput);
				if(inputType == 3 || inputType == 1)
				{
					// System.out.println("ServOutPUt: " + servOutput);
					for (int i = 1; i <= parts.length; i++)
					{
						// System.out.println("part[i]=" + parts[i]);
						if (parts[i].equals("End")) 
						{
							break; // breaking array if 
						}
						else
						{ 
							ConcertPrint concert  = new ConcertPrint(parts[i],parts[i+1],parts[i+2],parts[i+3],parts[i+4],parts[i+5],parts[i+6]);	
							Concerts.add(concert);
						}
						i +=6;
					}
				}
				if (inputType == 1) // User has inputed the day of the week 
				{
					Collections.sort(Concerts); // sorting venue names if the user inputs Day of the week 
				}
				else if (inputType == 3)
				{
					Collections.sort(Concerts, ConcertPrint.getdayOfConcert1());
				}
				if (wrtieToFile || disFile) //writing to client log / screen 
				{
					String toFile;
					ConcertPrint display = new ConcertPrint();
					for (int i =0; i < Concerts.size(); i++)
					{
						display = Concerts.get(i);
						//toFile = display.Display(); // printing the Concerts form the display function in concertPrint 
						if (disFile) 
						{ 
							if (inputType == 1) // display different if band name entered 
							{
								toFile = display.DisplayDay();
								System.out.println(toFile);
								fileOutput.print("To Screen: ");
								fileOutput.println(toFile);
							}
							else if (inputType == 3) // display different if Day of the week entered 
							{
								toFile = display.Display();
								System.out.println(toFile);
								fileOutput.print("To Screen: ");
								fileOutput.println(toFile);
							}	
						}
						else if (wrtieToFile)
						{
							if (inputType == 1) // display different if band name entered 
							{
								toFile = display.DisplayDay();
								//System.out.println(toFile);
								fileOutput.print("To Screen: ");
								fileOutput.println(toFile);
							}
							else if (inputType == 3) // display different if Day of the week entered 
							{
								toFile = display.Display();
								//System.out.println(toFile);
								fileOutput.print("To Screen: ");
								fileOutput.println(toFile);
							}
						}
							
					}
					
					
					
				}
			
			}
		}
			finally
			{
				client_sock.close();
				fileOutput.close();
				fileInput.close();
			}
	
		
	}
	public static int check (String input) // Checks user's input 
	{
		// System.out.println("input: " + input);
		// checking if user entered day of the week || money || Band 
		if (input.equalsIgnoreCase("Mon") || input.equalsIgnoreCase("Tue")|| input.equalsIgnoreCase("Wed")
				|| input.equalsIgnoreCase("Thu") || input.equalsIgnoreCase("Fri") || input.equalsIgnoreCase("Sat")
				|| input.equalsIgnoreCase("Sun"))
		{
			//System.out.println("Day fo the Week");
			return 1; //returning 1 for the server know its day of the week 
		}
		else if (isNumeric(input)){ // checking if user inputed Money Amount 
			//System.out.println("number");
			return 2; // returning 2 to let the server know its a dollar amount 
		}
		else 
		{
			return 3; // returning 3 to let the server know it is a band name or something random 
		}
		
	}
	public static boolean isNumeric (String input){ // this checks of the input is a number 
		try{
			double d = Double.parseDouble(input);
		}
		catch (NumberFormatException nfe){
			return false; // returns false if it is not a number 
		}
		return true;
	}
	

}
*/


 