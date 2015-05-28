import java.util.LinkedList;
import java.util.ArrayList; 
import java.util.Random;
public class LLPractice {
/*LLPractice.java
 * Michael Schmidt Computer Science 201 homework 6
 * October 27, 2013
 * LinkedList versus ArrayList speed in nanoseconds
 * This class tests the speed of adding and removing from an arraylist
 * and adding and removing from a linkedlist.
 */
static ArrayList <Double> testlist1 = new ArrayList <Double>();
static LinkedList <Double> testlist2 = new LinkedList<Double>();

public static void main(String args[]){
	for(int j=0;j<1000000;j++){//makes arraylist have 1000000 empty slots
		testlist1.add(j,null);
		testlist2.add(j,null);
	}
	
	//declaration and instantiation of lists 
	 
	long starttime = System.nanoTime(); 
	//testlist 1 code 
	
	//testlist1 generation and removal
		Random rand = new Random();
		for(int i=0;i<1000;i++){//fills the testlist1
			double k = rand.nextDouble();
			int placetoadd = rand.nextInt(testlist1.size()-1)+0;
			while(testlist1.get(placetoadd)!=null){//makes sure the spots are eventually filled
			placetoadd = rand.nextInt(testlist1.size()-1)+0;
			}
			testlist1.add(placetoadd,k);
		}
		
		for (int h=0; h<250000;h++){//removes 250000 elements
			int placetoremove = rand.nextInt(testlist1.size()-1)+0;
			testlist1.remove(placetoremove);
		}
	
	long totaltime = System.nanoTime() - starttime; 
	System.out.println("ArrayList insertion and removal time: "+ totaltime + " ns"); 
	 
	starttime = System.nanoTime(); 
	//testlist 2 code 
	//testlist2 generation and removal
		
		
		
		Random rand1 = new Random();
		for(int i=0;i<1000;i++){//fills the testlist2
			double k = rand1.nextDouble();
			int placetoadd1 = rand1.nextInt(testlist2.size()-1)+0;
			while(testlist2.get(placetoadd1)!=null){//makes sure there are no empty slots
			placetoadd1 = rand1.nextInt(testlist2.size()-1)+0;
			}
			testlist2.add(placetoadd1,k);
			
		}
		
		for (int h=0; h<250000;h++){//removes 250000 elements
			int placetoremove1 = rand1.nextInt(testlist2.size()-1)+0;
			testlist2.remove(placetoremove1);
		}
	
	totaltime = System.nanoTime() - starttime; 
	System.out.println("LinkedList insertion and removal time: " + totaltime + " ns"); 

	
}


}
