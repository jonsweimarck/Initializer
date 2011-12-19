package se.spriddabitar.initializer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SimpleClass;

public class InitializerTest 
{	
	@Test
	public void testsds() throws InstantiationException, IllegalAccessException
	{	
		InitializedClassAndValues<SimpleClass> initializedClassAndValues = new Initializer<SimpleClass>().setValues(SimpleClass.class);
		
		SimpleClass initialized = initializedClassAndValues.getInitializedClass();
		Values values = initializedClassAndValues.getValues();
		
		
		assertEquals(values.getInteger(), initialized.getInteger1());
		assertEquals(values.getInteger(), initialized.getInteger2());
		
	}
}
