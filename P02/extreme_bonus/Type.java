public enum Type{
	Dog(13), Tiger(10), Cat(14), Eagle(20);
	
	private double lifespan;
	
	private Type(double lifespan){
		this.lifespan = lifespan;
	}
	
	public double lifespan(){
		return lifespan;
	}
}