package se.spriddabitar.initializer;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SimpleClass;

public class InitializerTest 
{	
	@Test
	public void testsds() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		SimpleClass initialized = new Initializer<SimpleClass>().setValues(SimpleClass.class);	
		
		assertEquals(new Integer(42), initialized.getInteger1());
		
	}
}
