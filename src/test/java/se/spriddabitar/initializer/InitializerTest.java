package se.spriddabitar.initializer;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SimpleClass;
import se.spriddabitar.initializer.testclasses.SuperClass;
import se.spriddabitar.initializer.testclasses.WithSimpleList;

public class InitializerTest 
{	
	@Test
	public void withFinalTypes() throws Exception
	{	
		SimpleClass initialized = new Initializer().setValues(SimpleClass.class);	
		
		assertEquals(new Integer(1), initialized.getInteger1());
		assertEquals(new Integer(1), initialized.getInteger2());
		assertEquals(new String("1"), initialized.getString1());
	}
	
	@Test
	public void withInheritance() throws Exception
	{	
		SuperClass initialized = new Initializer().setValues(SuperClass.class);	
		
		assertEquals(new Integer(1), initialized.getInteger1());

		assertEquals(new Integer(1), initialized.getSubclass().getInteger1());
	}
	
	@Test
	public void withSimpleList() throws Exception
	{
		WithSimpleList initialized = new Initializer().setValues(WithSimpleList.class);	
		
		assertEquals(new Integer(1), initialized.getInteger1());

		assertEquals(1, initialized.getSimples().size());
	}
}
