import java.io.*;
import java.util.*;
/**
 * 
 * @author sydneycampbell
 * COMP 249 Assignment 3
 * Section QQ
 *
 */
public class Main {

	
	static int num_errors = 0;
	static int missingerrors = 0;
	static int fewerrors = 0;
	static int manyerrors = 0;
	static int genreerrors = 0;
	static int ccbfiles =0;
	static int hcbfiles =0;
	static int mtvfiles =0;
	static int mrbfiles =0;
	static int nebfiles =0;
	static int otrfiles =0;
	static int ssmfiles =0;
	static int tpafiles =0;
	static int semanticerror = 0;
	static int currentIndex = 0;

	
	/**
	 * 
	 * @param args
	 * Main method that includes parts 1, 2, 3 that each correspond to their own tasks, all in correlation with each other.
	 * 
	 */
	public static void main(String[] args){
		
		
		do_part1();
		do_part2();
		//System.out.println("comic" +comicsCount+"\n"+hobbiesCount+"\n" + moviesCount+ "\n" + musicCount + "\n" + nostalgiaCount+"\n" + oldCount + "\n" + sportsCount+"\n" + trainsCount);
		
		try {
			do_part3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	/**
	 * Void Method that is in charge of the first part of the assignment
	 * It declares a scanner, as well as 9 print writer objects
	 * This method includes opening and reading a file and printing the syntax errors to another files, while printing the good files
	 * to their corresponding names files
	 */
	public static void do_part1(){
		
		//Step 1: Read through part1_input_file_names.txt
		Scanner sc = null;
		PrintWriter pw = null;
		PrintWriter ccb = null;
		PrintWriter hcb = null;
		PrintWriter mtv = null;
		PrintWriter mrb = null;
		PrintWriter neb = null;
		PrintWriter otr = null;
		PrintWriter ssm = null;
		PrintWriter tpa = null;
		
		try {
			sc = new Scanner(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/part1_input_file_names.txt"));
			//first number of the document is the amount of file names in that file
			ccb = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Cartoons_Comics.csv.txt"));
			hcb = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Hobbies_Collectibles.csv.txt"));
			mtv = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Movies_TV_Books.csv.txt"));
			mrb = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Music_Radio_Books.csv.txt"));
			neb = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Nostalgia_Eclectic_Books.csv.txt"));
			otr = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Old_Time_Radio_Books.csv.txt"));
			ssm = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Sports_Sports_Memorabilla.csv.txt"));
			tpa = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/Trains_Planes_Automobiles.csv.txt"));
			String num = sc.nextLine();
			int num_files = Integer.parseInt(num.trim());
			//for loop that goes through the number of files
			String[] book_records = new String[num_files];
			
			for(int i = 0; i<num_files;i++) {
				 book_records[i] = sc.nextLine();
			}
			pw = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/syntax_error_file.txt"));
		
			for(int i = 0; i<book_records.length;i++) {
				
				syntaxChecker(book_records[i],pw, ccb, hcb, mtv, mrb, neb, otr, ssm, tpa);
					
	            
	        }
			
				
		}catch(FileNotFoundException e) { //catching a file not found exception
			System.out.println("Error with opening file.");
		} catch (TooManyFieldsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TooFewFieldsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (UnknownGenreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if(sc!=null) {
			sc.close();
			
			}
			if(pw!=null) {
				pw.close();
			}
			ccb.close();
			hcb.close();
			mtv.close();
			mrb.close();
			neb.close();
			otr.close();
			ssm.close();
			tpa.close();
		}
		
	}

	/**
	 * Method that takes in all these parameters and scans through each file accordingly, the files are being viewed from the part_1 for loop
	 * that loops through and checks for syntax errors through the chosen file as it reads through it line by line
	 * @param file
	 * @param pw
	 * @param ccb
	 * @param hcb
	 * @param mtv
	 * @param mrb
	 * @param neb
	 * @param otr
	 * @param ssm
	 * @param tpa
	 * @throws TooManyFieldsException
	 * @throws TooFewFieldsException
	 * @throws MissingFieldException
	 * @throws UnknownGenreException
	 */
	public static void syntaxChecker(String file, PrintWriter pw,PrintWriter ccb,PrintWriter hcb,PrintWriter mtv,PrintWriter mrb,PrintWriter neb, PrintWriter otr, PrintWriter ssm, PrintWriter tpa) throws TooManyFieldsException, TooFewFieldsException, MissingFieldException, UnknownGenreException {
		 Scanner sc2 = null;
		int num_lines = 0;
		
		
			try {
				
				
					sc2 = new Scanner(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+ file));
					
					
				while(sc2.hasNextLine()) {
					sc2.nextLine();
					num_lines++;
				}
				
				sc2 = new Scanner(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+ file));
				for(int i = 0; i<num_lines;i++) {
					String test = sc2.nextLine();
					String[] books = test.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
					try {
					
					
					if(books.length>6) {
						//too many fields exception
						
						throw new TooManyFieldsException();
						
						
					}
					if(books.length<6) {
						
						throw new TooFewFieldsException();
						
					}
					
					for(int k =0; k<books.length;k++) {
						if(books[k]=="") {
						switch(k) {
						case 0:
						{
							throw new MissingFieldException("title");
						}
						case 1:
						{
							throw new MissingFieldException("author");
						}
						case 2:
						{
							throw new MissingFieldException("price");
				
						}
						case 3: 
						{
							throw new MissingFieldException("isbn");
						}
						case 4: 
						{
							throw new MissingFieldException("genre");
						}
						case 5:
						{
							throw new MissingFieldException("year");
						}
						default:
							break;
						}
							
					}
					}
					
						String chosengenre = books[4].trim();
						switch(chosengenre) {
						case "CCB":
							ccb.println(test);
							ccbfiles++;
							break;
						case "HCB":
							hcb.println(test);
							hcbfiles++;
							break;
						case "MTV":
							mtv.println(test);
							mtvfiles++;
							break;
						case "MRB":
							mrb.println(test);
							mrbfiles++;
							break;
						case "NEB":
							neb.println(test);
							nebfiles++;
							break;
						case "OTR":
							otr.println(test);
							otrfiles++;
							break;
						case "SSM":
							ssm.println(test);
							ssmfiles++;
							break;
						case "TPA":
							tpa.println(test);
							tpafiles++;
							break;
						case "":
							break;
						default:
							// unknown genre exception
						{
							pw.println("Syntax error in file: " + file);
							pw.println("=================================");
							pw.println("Error: Unknown genre");
							pw.println("Record: " + test);
							throw new UnknownGenreException();
						}
					}
						
					
						
					
					}catch(TooManyFieldsException e) {
						 pw.println("Syntax error in file: " + file);
			                pw.println("=================================");
			                pw.println("Error: Too many fields");
			                pw.println("Record: " + test);
			                num_errors++;
			                manyerrors++;
			                
			               
			                
			            } catch (TooFewFieldsException e) {
			                pw.println("Syntax error in file: " + file);
			                pw.println("=================================");
			                pw.println("Error: Too few fields");
			                pw.println("Record: " + test);
			               num_errors++;
			               fewerrors++;
			                
			                
			              
			                
			            } catch (UnknownGenreException e) {
			                pw.println("Syntax error in file: " + file);
			                pw.println("=================================");
			                pw.println("Error: unknown genre");
			                pw.println("Record: " + test);
			                num_errors++;
			                genreerrors++;
			                 
			                
			            }catch (MissingFieldException e) {
			                pw.println("Syntax error in file: " + file);
			                pw.println("=================================");
			                pw.println("Error: missing " + e.getMessage());
			                pw.println("Record: " + test);
			                num_errors++;
			                missingerrors++;
			                
			                
			            } 
			
				}
				
	                
	            }catch(FileNotFoundException e) {
				System.out.println("File not found exception");
			} finally {
			
				if (sc2 != null) {
					sc2.close();
				}
				
			
				
				
				
			}
			
		 
			}
	/**
	 * Static void method that corresponds to the task asked for part_2
	 * Similarily to part_1, it is writer to a semantic error file as it scans through all the syntatically valid books
	 * and throws multiple exceptions according to what errors are found per book record.
	 */
	public static void do_part2() {
		//Write a method called do_part2() that reads the genre-based CVS-formatted input text files produced in Part 1, 
		//one file at a time, creating an array of valid Book objects out of all the semantically valid book records in each input file. A line in an 
		//input file, which is already valid syntactically, is processed as follows depending on whether the line contains a semantic error:
	
		PrintWriter pw2 = null;
		String[] csvfiles = {"Cartoons_Comics.csv.txt","Hobbies_Collectibles.csv.txt","Movies_TV_Books.csv.txt",
				"Music_Radio_Books.csv.txt","Nostalgia_Eclectic_Books.csv.txt", "Old_Time_Radio_Books.csv.txt",
				"Sports_Sports_Memorabilla.csv.txt", "Trains_Planes_Automobiles.csv.txt"};
		
		try {
			//print the semantic error books into the semantic error file
		
			pw2 = new PrintWriter(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/semantic_error_file.txt"));
			int count = 0;
			for(int i = 0; i<csvfiles.length;i++) {
				semanticChecker(csvfiles[i],pw2);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}finally {
			pw2.close();
		}
		System.out.println(semanticerror);

	
	}
	/**
	 * This method aids part_2 in checking for the semantic errors
	 * It takes in a filename and a printwriter and reads through the file and storing all the objects of the file into
	 * an aray of book objects
	 * @param filename
	 * @param pw2
	 */
	public static void semanticChecker(String filename, PrintWriter pw2) {
		int num_lines = 0;
		int count = 0;
		Book[] ccbarray = null;
		Book[] hcbarray = null;
		Book[] mtvarray = null;
		Book[] array = null;
		Book[] mrbarray = null;
		Book[] nebarray = null;
		Book[] otrarray = null;
		Book[] ssmarray = null;
		Book[] tpaarray = null;
		Scanner sc3 = null;
		
		
		try {
			
			
				sc3 = new Scanner(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+ filename));
				
				
			while(sc3.hasNextLine()) {
				sc3.nextLine();
				num_lines++;
			}
			array = new Book[num_lines];
			
			sc3 = new Scanner(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+ filename));
			
			
			for(int i = 0; i<num_lines;i++) {
				String test = sc3.nextLine();
				String[] books = test.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
				String title = books[0];
				String authors = books[1];
				double price = Double.parseDouble(books[2]);
				int year = Integer.parseInt(books[5]);
				String isbn = books[3];
				String genre = books[4];
				int[] isbnarr = new int[13];
				int sum=0;
				int sum2 = 0;
				
				
				try {
					
					if(price<0) {
						pw2.println("Semantic error in file: " + filename);
						pw2.println("=====================================");
						pw2.println("Error: Bad price");
						pw2.println("Record: " + test);
						semanticerror++;
						throw new BadPriceException();
					}
					if(!(year>=1995&&year<=2010)) {
						pw2.println("Semantic error in file: " + filename);
						pw2.println("=====================================");
						pw2.println("Error: Bad year");
						pw2.println("Record: " + test);
						semanticerror++;
						throw new BadYearException();
					}
					if(isbn.length() == 10) {
						for(int j = 0,k=10; j<isbn.length();j++,k--) {
							
							sum += (k*Character.getNumericValue(isbn.charAt(j)));
						}
						if(sum%11!=0) {
							pw2.println("Semantic error in file: " + filename);
							pw2.println("=====================================");
							pw2.println("Error: Bad isbn 10");
							pw2.println("Record: " + test);
							semanticerror++;
							
							throw new BadIsbn10Exception();
						}
						
					}
					if(isbn.length()==13) {
						for(int h = 0; h<isbn.length();h++) {
							isbnarr[h]= Character.getNumericValue(isbn.charAt(h));
							
						}
						
						sum2 = isbnarr[0] + 3*isbnarr[1] + isbnarr[2] + + 3*isbnarr[3] + isbnarr[4] + + 3*isbnarr[5] + isbnarr[6] + + 3*isbnarr[7] + isbnarr[8] + 
								+ 3*isbnarr[9] + isbnarr[10] + + 3*isbnarr[11] + isbnarr[12];
						if(sum2%10!=0) {
							pw2.println("Semantic error in file: " + filename);
							pw2.println("=====================================");
							pw2.println("Error: Bad isbn 13");
							pw2.println("Record: " + test);
							semanticerror++;
							
							throw new BadIsbn13Exception();
						}
						
					}
					
					array[i]= new Book(title,authors,price,isbn,genre,year);
					
					
				}catch(BadPriceException e) {
					System.out.println("bad price");
				}catch(BadYearException e) {
					System.out.println("bad year");
				}catch(BadIsbn10Exception e) {
					System.out.println("bad isbn 10");
				}catch(BadIsbn13Exception e) {
					System.out.println("bad isbn 13");
				}
			
			}
			if (filename.equals("Cartoons_Comics.csv.txt")) {
		        ccbarray = array;
		        
		    } else if (filename.equals("Hobbies_Collectibles.csv.txt")) {
		        hcbarray = array;
		        
		    } else if (filename.equals("Movies_TV_Books.csv.txt")) {
		        mtvarray = array;
		       
		    } else if (filename.equals("Music_Radio_Books.csv.txt")) {
		        mrbarray = array;
		        
		    } else if (filename.equals("Nostalgia_Eclectic_Books.csv.txt")) {
		       nebarray = array;
		   		
		    } else if (filename.equals("Old_Time_Radio_Books.csv.txt")) {
		        otrarray = array;
		        
		    } else if (filename.equals("Sports_Sports_Memorabilla.csv.txt")) {
		        ssmarray = array;
		        
		    } else if (filename.equals("Trains_Planes_Automobiles.csv.txt")) {
		        tpaarray = array;
		        
		    }
			toBinary(array,filename);
			
			
			 
			 
			
			
			}catch(FileNotFoundException e) {
				System.out.println("File not found");
			}finally {
				if(sc3!=null) {
					sc3.close();
					}
			}
	
		 
}
	/**
	 * 
	 * @param books (String array)
	 * @param filename
	 * 
	 * Method that takes in two paramaters (one of the String array of books and the other the String of the file name)
	 * It then creates an ObjectOutputStream object to then print the entered book and whichever file name associates 
	 * with it to the serialized binary file.
	 */
	public static void toBinary(Book[] obj, String filename) {
		
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+ filename + ".ser"));
			oos.writeObject(obj);
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}catch(EOFException e) {
			System.out.println("End of file reached");
		}catch(IOException e) {
			System.out.println("IOException");
		}
	}
	public static void do_part3() throws Exception {
		
		
		ObjectInputStream ois = null;
		String[] csvfiles = {"Cartoons_Comics.csv.txt.ser","Hobbies_Collectibles.csv.txt.ser","Movies_TV_Books.csv.txt.ser",
				"Music_Radio_Books.csv.txt.ser","Nostalgia_Eclectic_Books.csv.txt.ser", "Old_Time_Radio_Books.csv.txt.ser",
				"Sports_Sports_Memorabilla.csv.txt.ser", "Trains_Planes_Automobiles.csv.txt.ser"};
		/**
		 *  two-dimensional array to hold the arrays of Book objects that will be read from the binary files.
		 *   The code then loops through each filename, 
		 *  opens the corresponding binary file using an ObjectInputStream,
		 *   and deserializes the object into an array of Book objects. 
		 */
		Book[][] bookarray = new Book[csvfiles.length][];
		for(int i = 0; i<bookarray.length;i++) {
			try {
				ois = new ObjectInputStream(new FileInputStream("/Users/sydneycampbell/eclipse-workspace/Assignment3_Trial/src/"+csvfiles[i]));
				try {
				bookarray[i] = (Book[]) ois.readObject();
				}catch(EOFException e) {
					System.out.println("EOFE Exception");
				}
			}catch(IOException e) {
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int currentIndex = 0;
		
		Scanner in = new Scanner(System.in);
		//default page
		printMenu(csvfiles[0],bookarray[0]);
		
		//This is using boolean and while loop to navigate through the array objects
		boolean progress = true;
		boolean viewing = true;
		while(progress == true) {
		//switch statements to navigate through the program depending on what was chosen, as well as
		//the multiple different possible outcomes
			System.out.print("Enter your choice: ");
			String choice = in.nextLine();
			switch(choice) {
			case "v":
			case "V":
				int n = 0;
				int pointer = 0;
				System.out.println("viewing: " + csvfiles[currentIndex] + "		(" + bookarray[currentIndex].length + " records)");
				while(viewing==true) {
					System.out.println("Enter an integer that specifies a range to be viewed: ");
					n = in.nextInt();
					if(n==0) {
						//print menu
						printMenu(csvfiles[currentIndex],bookarray[currentIndex]);
						
						break;
					}else if (n == -1 || n == 1) {
						System.out.println(bookarray[currentIndex][pointer].toString());
					}else if (n>0) {
						for(int i = pointer + (n-1);i >=pointer;i--) {
							if(i==bookarray[currentIndex].length){
							throw new EOFException("EOF has reached end");
							}else if(bookarray[currentIndex][i]!=null) {
								System.out.println(bookarray[currentIndex][i].toString());
							}
						}
						pointer = pointer + (n-1);
						
					}
					else if (n<0) {
						for(int i = pointer - (Math.abs(n)-1);i <=pointer;i++) {
							if(i<0){
							System.out.println(bookarray[currentIndex][pointer]);
							throw new Exception("BOF has reached end");
							}
						}
						pointer = pointer -(Math.abs(n)-1);
					}
				}
			   
			break;
			case "s":
			case "S":
			String menu = "------------------------------\n"
					+ "        File Sub-Menu\n"
					+ "------------------------------\n"
					+ "1  Cartoons_Comics_Books.csv.ser		(" +  bookarray[0].length + " records)\n"
					+"2  Hobbies_Collectibles_Books.csv.ser		(" + bookarray[1].length+ " records)\n"
					+"3  Movies_TV.csv.ser				(" + bookarray[2].length + " records)\n"
					+"4  Music_Radio_Books.csv.ser			(" + bookarray[3].length+ " records)\n"
					+"5  Nostalgia_Eclectic_Books.csv.ser		(" + bookarray[4].length+ " records)\n"
					+"6  Old_Time_Radio.csv.ser			(" + bookarray[5].length + " records)\n"
					+"7  Sports_Sports_Memorabilia.csv.ser		(" + bookarray[6].length+ " records)\n"
					+"8  Trains_Planes_Automobiles.csv.ser		("+ bookarray[7].length+ " records)\n"
					+"9  Exit";
			System.out.println(menu);
			System.out.print("Enter your choice: ");
			String choice2 = in.nextLine();
			
			switch(choice2) {
			case "1":
				currentIndex = 0;
				break;
			case "2":
				currentIndex = 1;
				break;
			case "3":
				currentIndex = 2;
				break;
			case "4":
				currentIndex = 3;
				break;
			case "5":
				currentIndex = 4;
				break;
			case "6": 
				currentIndex = 5;
				break;
			case "7": 
				currentIndex = 6;
				break;
			case "8":
				currentIndex = 7;
				break;
			case "9":
				System.exit(0);
			}
			break;
			case "X":
			System.exit(0);
			break;
			
		}
		}
	}
		
/**
 * Method that when called prints out the interactive menu
 * @param filename
 * @param book
 */
	public static void printMenu(String filename, Book[] book) {
		System.out.println("==========================================" + "\nMain Menu " + "\n==========================================");
		System.out.println("V View the selected file: " + filename + "( " + book.length + " records)");
		System.out.println("S Select a file to view");
		System.out.println("X Exit");
		System.out.println("-------------------------------------------");
	}
	

}
	
		
		
	


