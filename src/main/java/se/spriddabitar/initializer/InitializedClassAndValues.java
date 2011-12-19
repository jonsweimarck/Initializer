package se.spriddabitar.initializer;


public class InitializedClassAndValues<T> 
{
	private T initializedClass;
	private Values values;
	
	public InitializedClassAndValues(T initializedClass, Values values) {
		this.initializedClass = initializedClass;
		this.values = values;
	}

	public T getInitializedClass() 
	{
		return initializedClass;
	}
	
	public Values getValues()
	{
		return values;
	}

}
