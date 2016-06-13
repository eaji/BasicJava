import java.util.Scanner;
import java.util.Random;


public class MainClass{

public static void insertIntoArray(String arr [][], int insertIndexRow,int insertIndexCol) {

Random rnum = new Random();
   for(int row=0;row<insertIndexRow;row++){
     for(int col=0;col<insertIndexCol;col++) {
    String str;

    char x=(char)(rnum.nextInt(93)+33);
    char y=(char)(rnum.nextInt(93)+33);
    char z=(char)(rnum.nextInt(93)+33);
    //new StringBuilder().append(a).append(b).append(c).toString();
    StringBuilder sb = new StringBuilder();
    sb.append(x);
    sb.append(y);
    sb.append(z);
    str = sb.toString();           

    arr[row][col]=str;
     }
   }

}



public static void printArray(String arr [][], int insertIndexRow,int insertIndexCol){

   System.out.println("Random Array Table:");
   for(int row=0;row<insertIndexRow;row++){
     for(int col=0; col<insertIndexCol; col++) {
     System.out.print(arr[row][col]+" ");
     }
   System.out.println();
   }

}



public static void editArray(String arr [][],int arrRow, int arrCol,int toEditRow,int toEditCol,String insertData){

   arr[toEditRow][toEditCol]=insertData;

   System.out.println();
   System.out.println("The new table array:");

   for(int row=0;row<arrRow;row++){
     for(int col=0;col<arrCol;col++) {
       System.out.print(arr[row][col]+" ");
       System.out.print("");
     }
   System.out.println();
   }

}


public static void searchArray(String arr [][],int arrRow, int arrCol,String toSearch){

for(int row=0;row<arrRow;row++){
   for(int col=0;col<arrCol;col++){

      if(toSearch.length()>=2) {
	CharSequence toSearchChar = toSearch;
	boolean retVal = arr[row][col].contains(toSearchChar);
	System.out.println("Search Result:");
           if(retVal){  
           System.out.println("At array [" + row + "][" + col + "] --> 1 instance of \"" + toSearch + "\"");
           }
           else{
	   System.out.println("\"" + toSearch + "\" not found at array [" + row + "][" + col + "].");
           }
      }


      else if(toSearch.length()==1){
	String temp=arr[row][col];
	String newTemp=temp.replaceAll(toSearch,"");
	int count=temp.length()-newTemp.length();
	System.out.println(count + " instance(s) of " + toSearch + " at array [" + row + "][" + col + "]."); 
      }

   }
}

}



public static void main (String [] args) {

Scanner input = new Scanner(System.in);
String reset;
int menu;


//Array Dimensions
System.out.print("Enter length followed by width of an array:");
int arrRow = input.nextInt();
int arrCol = input.nextInt();

while(arrRow<=0 || arrCol<=0) {
System.out.println("Enter a valid Dimensions of an array!");
System.out.println("Enter length followed by width of an array:");
arrRow = input.nextInt();
arrCol = input.nextInt();

}

String [][] arr = new String [arrRow][arrCol];
System.out.println();

//Array insertion
insertIntoArray(arr,arrRow,arrCol);


do{

//MENU
System.out.println("ENTER the NUMBER of ACTION to perform:");
System.out.println("   1. Print");
System.out.println("   2. Edit");
System.out.println("   3. Search");
System.out.println("   4. Reset");
System.out.println("   5. Exit");
menu = input.nextInt();




switch (menu) {


case 1:									//CASE 1
//Array printing
printArray(arr,arrRow,arrCol);
System.out.println();
break;									//END CASE 1

case 2:									//CASE 2
//Array Editing
System.out.print("To Edit -- Enter row number followed by column number:");
int toEditRow = input.nextInt();
int toEditCol = input.nextInt();

while(toEditRow>(arrRow-1) || toEditCol>(arrCol-1)) {
  System.out.println("Enter a valid row and column!");
  System.out.print("To Edit -- Enter row number followed by column number:");
  toEditRow = input.nextInt();
  toEditCol = input.nextInt();
}    

System.out.println();

System.out.println("Enter the new (3) characters:");
String newChars = input.next();

while(newChars.length() != 3) {
  System.out.println("Input is not three(3) characters!");
  System.out.println("Enter the new (3) characters:");
  newChars = input.next();
}

//Array Editing Method Calling
editArray(arr,arrRow,arrCol,toEditRow,toEditCol,newChars);
System.out.println();
break;									//END CASE 3

case 3:									//CASE 3
//Array Searching
System.out.print("Enter string to search:");
String toSearch = input.next();
System.out.println();

searchArray(arr,arrRow,arrCol,toSearch);

System.out.println();
break;									//END CASE 3

case 4:									//CASE 4

//Array Dimensions
System.out.print("Enter length followed by width of an array:");
arrRow = input.nextInt();
arrCol = input.nextInt();

while(arrRow<=0 || arrCol<=0) {
System.out.println("Enter a valid Dimensions of an array!");
System.out.println("Enter length followed by width of an array:");
arrRow = input.nextInt();
arrCol = input.nextInt();

}

String arr2 [][] = new String [arrRow][arrCol];
System.out.println();
arr=arr2;

//Array insertion
insertIntoArray(arr,arrRow,arrCol);
break;									//END CASE 4


default: System.out.println("INVALID INPUT!");



}//End of switch

}while(menu!=5);

System.out.println("END!");



}


}


