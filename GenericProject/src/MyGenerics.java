import java.util.ArrayList;


public class MyGenerics <E>{

	
	//finds the minimum element
	public static <E extends Comparable<? super E>>//if the types are comparable
	E findMin( E [ ] a ){
		int minIndex = 0;
		for( int i = 1; i < a.length; i++ )
			if( a[ i ].compareTo( a[ minIndex ] ) < 0 )//sees if element at spot i is less than the one at spot minIndex
				minIndex = i;//if so saves minIndex since it is the new smallest
		System.out.println(a[minIndex]);//prints minimum element
		return a[ minIndex ];//returns minimum element
	}
	
	//finds the 2 maximum elements
	public static <E extends Comparable<? super E>>//if the types are comparable
	ArrayList findMax2( E[] a ){
		int maxIndex = 0;//saves one max element
		int maxIndex2 =0;//saves the other max element
		for( int i = 1; i < a.length; i++ )
			if( a[i].compareTo(a[maxIndex] ) > 0 ){//finds a bigger element then save the previous big element then saves the new biggest element
				maxIndex2 = maxIndex;
				maxIndex = i;
				}
				ArrayList<E> Q= new ArrayList();//makes an arraylist to save the 2 max elements
				Q.add(0,a[maxIndex]);
				Q.add(1,a[maxIndex2]);//adds the two to the arraylist
		System.out.println(a[maxIndex]+" " + a[maxIndex2]);//prints to double check
		return Q;//returns the array list
	}
	
	
	public static void main(String args[]){
		//tests the methods
		Integer b[]={1,2,3,4,5};
		findMin(b);
		findMax2(b);
		
		String p[] ={"car", "catastrophe","pokemon"};
		findMax2(p);
		findMin(p);
	}
	
	
	
}
