//import java.util.ArrayList;

public class MyPets{
	public static void main(String[] args){
		Type type;
		Pet[] animal = new Pet[Integer.MAX_VALUE-1];
		
		animal[0] = new Pet("Fluffy", 10, Type.Dog);
		animal[1] = new Pet("Blessedone", 2, Type.Tiger);
		animal[2] = new Pet("Millie", 7, Type.Cat);
		animal[3] = new Pet("Enna", 8, Type.Eagle);
		
		for(int i=0; i<4 ; ++i){
			System.out.println(animal[i]);
			
		}
	}
}