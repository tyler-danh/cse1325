
public class Pet{
	private String name;
	private double age;
	private Type type;
	
	public final double humanLifeSpan = 80;
	public double humanAge;
	
	public double humanAge(){
		return humanAge = (humanLifeSpan * age / type.lifespan());
	}
	
	public Pet(String name, double age, Type type){
		this.name = name;
		this.age = age;
		this.type = type;
	}
	
	@Override
	public String toString(){
		return name + " is a " + type + " age: " + age + " or " + humanAge() + " in human equivalent years.";
	}
}