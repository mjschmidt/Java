import java.util.ArrayList;


public class Pizza {
	
String Size;
String Type;
ArrayList <String> Toppings;
int Number;
double Price;

public double getPrice(){
	return Price;
}

public void setPrice(double price){
	Price=price;
}

public String getSize() {
	return Size;
}

public void setSize(String size) {
	Size = size;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public ArrayList getToppings() {
	return Toppings;
}

public void setToppings(ArrayList<String> toppings) {
	if(toppings==null){
		
	}else{
		Toppings = new ArrayList<String>();
	for(String item : toppings){
		Toppings.add(item);
	}
	}
}

public int getNumber() {
	return Number;
}

public void setNumber(int number) {
	Number = number;
}
	
	public Pizza(String size, String type, ArrayList toppings, int number){
		setSize(size);
		setType(type);
		setToppings(toppings);
		setNumber(number);
	}
	
	
	
}
