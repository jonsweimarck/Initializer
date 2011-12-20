package se.spriddabitar.initializer;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SimpleClass;

public class InitializerTest 
{	
	@Test
	public void testsds() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		InitializedClassAndValues<SimpleClass> initializedClassAndValues = new Initializer<SimpleClass>().setValues(SimpleClass.class);
		
		SimpleClass initialized = initializedClassAndValues.getInitializedClass();
		Values values = initializedClassAndValues.getValues();
		
		
		assertEquals(values.getInteger(), initialized.getInteger1());
		assertEquals(values.getInteger(), initialized.getInteger2());
		
	}
	
	@Test
	public void asdas() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
	{
		Map<String, Method> methodMap = Util.getSetterMethods(SimpleClass.class);
		
		SimpleClass simple = new SimpleClass();
		
		for(Method method : methodMap.values())
		{
	     	Class<?> parameter = method.getParameterTypes()[0];
	    	if (parameter.equals(Integer.class))
	    	{
	    		method.invoke(simple, new Integer(42));
	        }
		}
		
		assertEquals(new Integer(42), simple.getInteger1());
		assertEquals(new Integer(42), simple.getInteger2());
	}
}
