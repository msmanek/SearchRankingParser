import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicFunctions {
	
	public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static boolean checkIfDuplicateInArray(int[] myArray, int position, int x) {
		for(int i = 0; i < position; i++)
			if(myArray[i] == x) { return true; }
		
		//else
		return false;
	}
	
	//prompts user for a fileName and returns the file Object if it exists
	//returns null if user chooses to cancel the process
	public static File getFile(String prompt) {
		
		String fileName;
		boolean done = false;
		File fileToReturn;
		
		do {
			fileName = BasicFunctions.getString(prompt + "(0 to cancel): ");
			if(fileName.equals("0")) {
				System.out.print("\nFile loading process canceled.\n\n");
				return null;
			}//end if
			
			fileToReturn = new File(fileName);
			
			if(fileToReturn.exists())
				done = true;
			else
				System.out.print("\nERROR: File not found!\n\n");
			
		}while(!done);
		
		return fileToReturn;

	}
		
	public static double getAverageOfArray (double[] D) {
		double sum = 0;
		int numElements = D.length;
		
		if(numElements == 0) {
			System.out.print("\nThe array is empty\n\n");
			return 0;
		}
		
		for(int i = 0; i < numElements; i++)
			sum += D[i];
		
		return (sum / numElements);
	}
	
	public static String getYesOrNo(String prompt) {
		String yesOrNo;
		
		do {
			
			yesOrNo = BasicFunctions.getString(prompt);
			
			if(yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("N")) { return yesOrNo; }
			
			System.out.print("ERROR: Choice must be 'y' or 'n'!\n");
			
		}while(true);//infinite loop because will only need to terminate if value returned
					 //(more memory efficient than boolean flag... i think)
		
	}//end getYesOrNo function
	
	public static String getString(String prompt) {
		String userStringInput = "";
		boolean done = false;
		
		do {
			System.out.print(prompt);
			
			try { 
				userStringInput = input.readLine();
				done = true;
			}//end try
			catch (IOException e) {System.out.print("\nERROR: Input must be a valid string!\n\n");}
			
		} while(!done);
		
		return userStringInput;
	}//end getString function
	
	public static int getInteger(String prompt, int LB, int UB) {
		int userIntInput = -1; //random number to satisfy compiler
		boolean done = false; //boolean flag
		
		do {
			System.out.print(prompt);
			
			//try catch to get correct input
			try {
				
				userIntInput = Integer.parseInt(input.readLine());
				done = true;
				
				//if statement to catch an int that is not in the correct bound
				if (LB > userIntInput || userIntInput > UB) {
					integerErrorMessage(LB, UB);
					done = false;
				}//end if
				
			}//end try
			catch (IOException|NumberFormatException e) {	
				integerErrorMessage(LB, UB);
			}
			
		} while(!done); //end of do-while loop
		
		return userIntInput;
		
	}//end getInteger function

	public static double getDouble(String prompt, double LB, double UB) {
		
		double userDoubleInput = -1.0; //random number to satisfy compiler
		boolean done = false; //boolean flag
		
		do {
			
			System.out.print(prompt);
			
			//try catch to get correct input
			try {
				
				userDoubleInput = Double.parseDouble(input.readLine());
				done = true;
				
				//if statement to catch a double that is not in the correct bound
				if (LB > userDoubleInput || userDoubleInput > UB) {
					realNumberErrorMessage(LB, UB);
					done = false;
				}//end if
				
			}//end try
			catch (IOException|NumberFormatException e) {
				realNumberErrorMessage(LB, UB);
			}	
		} while(!done); //end of do-while loop
		
		return userDoubleInput;

	}//end getDouble function
	
	public static void realNumberErrorMessage (double LB, double UB) {		
		//if statement to catch if LB/UB is max/min of double
		if (LB == Double.MAX_VALUE && UB == Double.MIN_VALUE)
			System.out.printf("\nERROR: Input must be a real number in [-infinity, infinity]!\n\n");
		else if (LB == Double.MAX_VALUE)
			System.out.printf("\nERROR: Input must be a real number in [-infinity, %.2f]!\n\n", UB);
		else if (UB == Double.MAX_VALUE)
			System.out.printf("\nERROR: Input must be a real number in [%.2f, infinity]!\n\n", LB);
		else
			System.out.printf("\nERROR: Input must be a real number in [%.2f, %.2f]!\n\n", LB, UB);
		
	}//end realNumberErrorMessage function
	
	public static void integerErrorMessage (int LB, int UB) {		
		//series of if statements to catch if LB/UB is max/min of int
		if (LB == Integer.MAX_VALUE && UB == Integer.MIN_VALUE)
			System.out.printf("\nERROR: Input must be an integer in [-infinity, infinity]!\n\n");
		else if (LB == Integer.MAX_VALUE)
			System.out.printf("\nERROR: Input must be an integer in [-infinity, %d]!\n\n", UB);
		else if (UB == Integer.MAX_VALUE)
			System.out.printf("\nERROR: Input must be an integer in [%d, infinity]!\n\n", LB);
		else
			System.out.printf("\nERROR: Input must be an integer in [%d, %d]!\n\n", LB, UB);
		
	}//end integerErrorMessage function

}//end BasicFunctions Class
