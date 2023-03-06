import java.util.Scanner;

class LibraryRecord {

	Scanner sc ;												// Scanner class object
	String name;
	String cms_id;
	String department;
	//int select;
//	String status;
	String book[];
	int book_q ;	
	int physics;
	int calculus;
	int precalculus;
	int oop;

	LibraryRecord() {
		this.sc = new Scanner(System.in);
		book = new String[5];
		book_q = 0;	
		physics = 5;
		calculus = 5;
		precalculus = 5;
		oop = 5;
	}
	
	public void getInfo(){
		System.out.print("\tEnter the name of the Student : ==> ");
		this.name = sc.nextLine();
		
		System.out.print("\tEnter the name of the CMS ID (abc-de-fghi ) : ==> ");
		this.cms_id = sc.nextLine();
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
		System.out.print("\t Press any number (1,2,3...) for Book Selection... : ==> ");
		int select_book = sc.nextInt();
	
		switch(select_book){
			case 1:
				this.book[book_q] = "Object Oriented Programming";
				oop--;
			break;
			case 2:
				this.book[book_q] = "Calculus";
				calculus--;
			break;
			case 3:
				this.book[book_q] = "Pre-Calculus";
				precalculus--;
			break;
		}
		
	}
	
		
		
}
class Library {
	public static void homePage(){								// homepage function
		System.out.println("\t\t\t  Welcome to Sukkur IBA University Library Portal");
		System.out.println("\t\t\t***************************************************");
		System.out.println("\t(1) : Issue new book ...");
		System.out.println("\t(2) : Display Students who have books ...");
		System.out.println("\t(3) : Serach Students...");
		System.out.println("\t(4) : Serach Books...");
		System.out.println("\t(5) : Issue new book to previous Students...");

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
	public static void books(LibraryRecord r[],String search)throws Exception{			// book function
		Scanner sc =new Scanner(System.in);
		cls();	
		for(int i =0 ; i>=0 ;i++){
			if(r[i].cms_id.equals(search) ){
				r[i].book_q++;
				System.out.println("\t Books List , Select any book ...");
				System.out.println("\t (1) : Object Oriented Programming");
				System.out.println("\t (2) : Calculus");
				System.out.println("\t (3) : Pre-Calculus");
				System.out.print("\t Press any number (1,2,3...) for Book Selection... : ==> ");
				int select_book = sc.nextInt();
	
				switch(select_book){
				case 1:
					r[i].book[r[i].book_q] = "Object Oriented Programming";
					r[i].oop--;
					break;
				case 2:
					r[i].book[r[i].book_q] = "Calculus";
					r[i].calculus--;
					break;
				case 3:
					r[i].book[r[i].book_q]= "Pre-Calculus";
					r[i].precalculus--;
				break;
				}
			break;
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
	
		 do{
			cls();	
			homePage();
	
			System.out.print("Press any digit (1,2,3...) : ==> ");
			int select = sc.nextInt();
	
			switch(select){
				case 1:{	
					scount++;
					r[scount] = new LibraryRecord();
					cls();	
					r[scount].getInfo();	
					r[scount].books();
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
					System.out.println("\tSearch Students who have Books....");
					System.out.println("\t**********************************");
					System.out.print("\tPlease enter the CMS ID of the Students, like [abc-cd-efgh] :==> ");
					sc.nextLine();
					String search = sc.nextLine();
					search(search,r,scount);

				}
				break;
				case 4:{
					cls();	
					System.out.println("\t        Search books....");
					System.out.println("\t*********************************");
				
				}
				case 5:{
					cls();	
					System.out.print("\tPlease enter the CMS ID of the Students, like [abc-cd-efgh] :==> ");
					System.out.println("\t**********************************");
					sc.nextLine();
					String search = sc.nextLine();
					books(r,search);

				}
				break;	
			}
			System.out.print("Do you want to go back press [b]...");
			backward = sc.next().charAt(0);
			
		}while(backward  == 'b' || backward  == 'B');
	}
}