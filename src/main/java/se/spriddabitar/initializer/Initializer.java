package se.spriddabitar.initializer;

import java.lang.reflect.Field;

public class Initializer<T>
{

	public InitializedClassAndValues<T> setValues(Class<T> clazz) throws InstantiationException, IllegalAccessException 
	{
		T result = clazz.newInstance();
		
		Field[] fields = clazz.getClass().getDeclaredFields();
		for(Field field : fields)
		{
			result = setField(result, field);
		}
		
		return new InitializedClassAndValues<T>( result, getValues());

	}

	private T setField(Object result, Field field) {
		return null;
	}
	
	private Values getValues()
	{
		return new Values();
	}
}
