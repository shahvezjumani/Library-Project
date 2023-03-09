import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LibraryRecord {

	LocalDate currentDate = LocalDate.now();
	LocalDate tomorrowDate = LocalDate.now().plusDays(14);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String date = currentDate.format(formatter);
	String duedate = tomorrowDate.format(formatter);
	
	Scanner sc ;						// Scanner class object
	String name;
	String cms_id;
	String department;
	String book[];
	int book_q ;	
	char status;
	static int[] books = {2,1,1,1,1}; 
	static char call;		// variable for call book method from class
	String issuedate [];
	String duedate1 [];

	LibraryRecord() {
		this.sc = new Scanner(System.in);
		book = new String[2];
		issuedate= new String[2];
		duedate1= new String[2];
		book_q = 0;
		status = 'n';	
	}

	public void getInfo(String name , String cms){
		//System.out.print("\tEnter the name of the Student : ==> ");
		this.name = name;
		
		//System.out.print("\tEnter the name of the CMS ID (abc-de-fghi ) : ==> ");
		this.cms_id = cms;
		
		departments();
	}
	public void departments(){
		System.out.println("\t Enter the department of the Student ...");
		System.out.println("\t (1) : BS(CS) COMPUTER SCIENCE");
		System.out.println("\t (2) : BS(SE) SOFTWARE ENGINEERING");
		System.out.println("\t (3) : BBA BUSINESS ADMINISTRATION");
		System.out.print("\t Press any number (1,2,3...) for Department Selection... : ==> ");
		int select = sc.nextInt();
	
		switch(select){
			case 1:
				this.department = "BS(CS) COMPUTER SCIENCE";
			break;
			case 2:
				this.department = "BS(SE) SOFTWARE ENGINEERING";
			break;
			case 3:
				this.department = "BBA BUSINESS ADMINISTRATION";
			break;
		}
	}
	public void books(){
		System.out.println("\t Books List , Select any book ...");
		System.out.println("\t (1) : Object Oriented Programming");
		System.out.println("\t (2) : Calculus");
		System.out.println("\t (3) : Pre-Calculus");
		System.out.println("\t (4) : Physics");
		System.out.println("\t (5) : Discrete Structures");
		System.out.print("\t Press any number (1,2,3...) for Book Selection... : ==> ");
		int select_book = sc.nextInt();
	
		switch(select_book){
			
			case 1:
				if(books[0]>0){
					this.book[book_q] = "Object Oriented Programming";
					books[0]--;		// oop book
					status = 'n';
					issuedate[book_q] = date;
					duedate1[book_q] = duedate;
				}
				else{
					System.out.println("\t Sorry! This book is not available here ... ");
					System.out.print("\tDo you want to choose other book then press [y] , if not press any other key ... ");
					call = sc.next().charAt(0);
				}
			break;
			case 2:
				if(books[1]>0){
					this.book[book_q] = "Calculus";
					books[1]--;		// calculus book
					status = 'n';

					issuedate[book_q] = date;
					duedate1[book_q] = duedate;
				}

				else{
					System.out.println("\t Sorry! This book is not available here ... ");
					System.out.print("\tDo you want to choose other book then press [y] , if not press any other key ... ");
					call = sc.next().charAt(0);
				}
			break;
			case 3:
				if(books[2]>0){
					this.book[book_q] = "Pre-Calculus";
					books[2]--;		// precalculus book
					status = 'n';

					issuedate[book_q] = date;				
					duedate1[book_q] = duedate;
				}
				else{
					System.out.println("\t Sorry! This book is not available here ... ");
					System.out.print("\tDo you want to choose other book then press [y] , if not press any other key ... ");
					call = sc.next().charAt(0);
				}
			break;
			case 4:
				if(books[3]>0){
					this.book[book_q] = "Physics";
					books[3]--;		// physics book
					status = 'n';
					issuedate[book_q] = date;
					duedate1[book_q] = duedate;
				}
				else{
					System.out.println("\t Sorry! This book is not available here ... ");
					System.out.print("\tDo you want to choose other book then press [y] , if not press any other key ... ");
					call = sc.next().charAt(0);
				}
			break;
			case 5:
				if(books[4]>0){
					this.book[book_q] = "Discrete Structures";
					books[4]--;		// discrete book
					status = 'n';
					issuedate[book_q] = date;
					duedate1[book_q] = duedate;
				}
				else{
					System.out.println("\t Sorry! This book is not available here ... ");
					System.out.print("\tDo you want to choose other book then press [y] , if not press any other key ... ");
					call = sc.next().charAt(0);
				}
			}
		}
	}
class Library {
	public static void homePage(){								// homepage function
		System.out.println("\t\t\t  Welcome to Sukkur IBA University Library Portal");
		System.out.println("\t\t\t***************************************************");
		System.out.println("\t(1) : Issue new book ...");
		System.out.println("\t(2) : History of Students who issued Books  ...");
		System.out.println("\t(3) : Search Students for renew books ...");
		System.out.println("\t(4) : Display students who did not Renew books ...");	
		System.out.println("\t(5) : Return books...");	
	}
	public static void cls() throws Exception{							// cls Fuunction
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();   
	}
	public static void search(String search,LibraryRecord r[],int scount) throws Exception{			// search function
		cls();	
		int s_match=0;

		for( int i=0 ; i<= scount ; i++){
			if(r[i].cms_id.equals(search) ){
				System.out.println("\tName :: "+r[i].name);
				System.out.println("\tCMS ID :: "+r[i].cms_id);
				System.out.println("\tDepartment :: "+r[i].department);
				for(int j =0 ; j<=r[i].book_q ; j++){
					System.out.println("\tBook name :: "+r[i].book[j]);
				}

			s_match++;
			System.out.println();
			}
		}
		 if(s_match == 0)
			System.out.println("\t*This CMS ID holder Student is not took Book...");
	}
	public static void renewBook(LibraryRecord r[] , String search ,int scount )throws Exception{		// renew method
		cls();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<= scount ; i++){
			if(r[i].cms_id.equals(search)){
				System.out.println("\tName :: "+r[i].name);
				System.out.println("\tCMS ID :: "+r[i].cms_id);
				System.out.println("\tDepartment :: "+r[i].department);
				for(int j =0 ; j<=r[i].book_q ; j++){
				System.out.println("\tBook name :: "+r[i].book[j]);
				System.out.println("\tBook issuence date :: "+r[i].issuedate[j]);
				System.out.println("\tBook due date for renew :: "+r[i].duedate1[j]);
				}
			System.out.print("\t If you want to renew, then [enter] [r] for Renew Books ....  ");
			r[i].status  = sc.next().charAt(0);
			}
		}
	}
	public static void displayNotRenew(LibraryRecord r[],int scount )throws Exception{	// did not renew
		cls();
		 int j = 0;
		System.out.println("\t Students list ..... ");
		System.out.println("\t ================= ");
		for(int i =0 ; i<= scount ; i++){
			if(r[i].status == 'n'){
				j++;
				System.out.println("\t("+j+")   "+r[i].name);
			}
		}
		if(j==0){
			System.out.println("\tAll Students renewed their books ....  ");	
		}
		j=0;
	}
	public static void returnBook(LibraryRecord r[] , int scount)throws Exception{
		Scanner sc = new Scanner(System.in);
		String cms;
		int bookO;
		cls();
		System.out.println("\t    This page is for returning books");
		System.out.println("\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.print("\t Enter the CMS ID of the Student : : like [abc-ab-abcd] :  ");
		cms = sc.nextLine();
		for( int i = 0 ; i<=scount ; i++){
			if(r[i].cms_id.equals(cms)){
				cls();
				System.out.println("\tName :: "+r[i].name);
				System.out.println("\tCMS-ID :: "+r[i].cms_id);
				for(int j = 0 ; j<=r[i].book_q ; j++){
					System.out.println("\t"+(j+1)+" - Book name :: "+r[i].book[j]);
				}
				if((r[i].book_q+1) == 0){
					break;
				}
				System.out.print("\tWhich book you want to return, For returning press [ 1, 2 ] :  ");
				bookO = sc.nextInt();
				if(r[i].book[bookO-1].equals("Object Oriented Programming")){
					LibraryRecord.books[0]++;
					r[i].book_q--;
					r[i].status = 'r';
					if(bookO == 1){
						r[i].book[bookO-1] = r[i].book[bookO];
					}
				}
				else if(r[i].book[bookO-1].equals("Calculus")){
					LibraryRecord.books[1]++;
					r[i].book_q--;
					r[i].status = 'r';
					if(bookO == 1){
						r[i].book[bookO-1] = r[i].book[bookO];
					}
				}
				else if(r[i].book[bookO-1].equals("Pre-Calculus")){
					LibraryRecord.books[2]++;
					r[i].book_q--;
					r[i].status = 'r';
					if(bookO == 1){
						r[i].book[bookO-1] = r[i].book[bookO];
					}
				}
				else if(r[i].book[bookO-1].equals("Physics")){
					LibraryRecord.books[3]++;
					r[i].book_q--;
					r[i].status = 'r';
					if(bookO == 1){
						r[i].book[bookO-1] = r[i].book[bookO];
					}
				}
				else if(r[i].book[bookO-1].equals("Discrete Structures")){
					LibraryRecord.books[4]++;
					r[i].book_q--;
					r[i].status = 'r';
					if(bookO == 1){
						r[i].book[bookO-1] = r[i].book[bookO];
					}
				}
			}
		}
	}
	public static void main (String [] args) throws Exception{							// main function
		
		char backward ;
		int scount = 0 ;
		Scanner sc = new Scanner(System.in);
		LibraryRecord r[] = new LibraryRecord[20];

		r[0] = new LibraryRecord();
		r[0].name = "Shahvez";
		r[0].cms_id = "023-22-0110";
		r[0].department = "BS(CS) COMPUTER SCIENCE";
		int count = 0;
	
		 do{
			cls();	

			homePage();
			System.out.print("Press any digit (1,2,3...) : ==> ");
			int select = sc.nextInt();
			String name,cms;
	
			switch(select){
				case 1:{
					cls();
					System.out.print("\tEnter the name of the Student : ==> ");
					sc.nextLine();
					name = sc.nextLine();
		
					System.out.print("\tEnter the name of the CMS ID (abc-de-fghi ) : ==> ");
					cms = sc.nextLine();
					
					for(int i = 0 ; i<=scount ; i++){
						count = 0;
						if(r[i].cms_id.equals(cms)){
							count++;
							cls();
							r[i].book_q++;
							if(r[i].book_q > 1){
								System.out.println("\t Sorry! your limit is over.");
								break;
							}
							LibraryRecord.call = 'n';
							r[i].books();
							if(LibraryRecord.call == 'y' || LibraryRecord.call == 'Y'){
								cls();	
								r[scount].books();
							}
						}
					}
					
					
					if(count == 0){
					
						scount++;
						r[scount] = new LibraryRecord();
						cls();	
						r[scount].getInfo(name,cms);	
						LibraryRecord.call = 'n';
						r[scount].books();
						if(LibraryRecord.call == 'y' || LibraryRecord.call == 'Y'){
							cls();	
							r[scount].books();
						}
					}
				}
				break;
				case 2:{
					cls();	
					System.out.println("\t    Students who issued books....");
					System.out.println("\t*********************************");
					for(int i =0 ; i<=scount ;i++){
						System.out.println("\t"+(i+1)+" - "+r[i].name);
					}
				}	
				break;
				case 3:{
					cls();	
					System.out.println("\tSearch Students for renew Books....");
					System.out.println("\t**********************************");
					System.out.print("\tPlease enter the CMS ID of the Students, like [abc-cd-efgh] :==> ");
					sc.nextLine();
					String search = sc.nextLine();
					search(search,r,scount);
					renewBook(r,search,scount);

				}
				break;
				case 4:{
					cls();	
					System.out.println("\t   List of Students who did not Renew Books  ....");
					System.out.println("\t***********************************************");
					displayNotRenew(r,scount);
				}
				break;
				case 5:{
					returnBook(r,scount);	
					
				}	
			}
			System.out.print("Do you want to go back press [b]...");
			backward = sc.next().charAt(0);
			
		}while(backward  == 'b' || backward  == 'B');
	}
}