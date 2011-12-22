package se.spriddabitar.initializer;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SubClass;
import se.spriddabitar.initializer.testclasses.SuperClass;

public class InitializerTest 
{	
	@Test
	public void simpleClassWithFinalTypes() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		SubClass initialized = new Initializer().setValues(SubClass.class);	
		
		assertEquals(new Integer(1), initialized.getInteger1());
		assertEquals(new Integer(1), initialized.getInteger2());
		assertEquals(new String("1"), initialized.getString1());
	}
	
	@Test
	public void classWithSubclassWithFinalTypes() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{	
		SuperClass initialized = new Initializer().setValues(SuperClass.class);	
		
		assertEquals(new Integer(1), initialized.getInteger1());

		assertEquals(new Integer(1), initialized.getSubclass().getInteger1());
	}
	
	@Test
	public void class
}
