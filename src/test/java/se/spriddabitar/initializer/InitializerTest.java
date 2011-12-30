package se.spriddabitar.initializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import se.spriddabitar.initializer.testclasses.SimpleClass;
import se.spriddabitar.initializer.testclasses.RootClass;
import se.spriddabitar.initializer.testclasses.WithSimpleList;

public class InitializerTest 
{	
	@Test
	public void withFinalTypes() throws Exception
	{	
		SimpleClass initialized = new Initializer().setValues(SimpleClass.class);	
		
		assertNotNull(initialized.getInteger1());
		assertNotNull(initialized.getInteger2());
		assertTrue(initialized.getInteger1().intValue() != initialized.getInteger2().intValue());
		assertNotNull(initialized.getString1());
	}
	
	@Test
	public void withReferencedClass() throws Exception
	{	
		RootClass initialized = new Initializer().setValues(RootClass.class);	
		
		assertNotNull(initialized.getInteger1());
		assertNotNull(initialized.getLeafclass().getInteger1());
		assertTrue(initialized.getInteger1().intValue() != initialized.getLeafclass().getInteger1().intValue());
	}
	
	@Test
	public void withSimpleList() throws Exception
	{
		WithSimpleList initialized = new Initializer().setValues(WithSimpleList.class);	
		
		assertNotNull(initialized.getInteger1());
		assertEquals(1, initialized.getSimples().size());
		assertNotNull(initialized.getSimples().get(0).getInteger1());
		assertTrue(initialized.getInteger1().intValue() != initialized.getSimples().get(0).getInteger1().intValue());
		
	}
}
