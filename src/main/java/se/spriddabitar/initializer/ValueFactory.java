package se.spriddabitar.initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ValueFactory {

//	   private static final int A_NUMBER = 1;
	 
	
	   private Map<Class<?>, Randomizer> typeValues;
	 
	   public ValueFactory() 
	   {
//	      typeValues = new HashMap<Class<?>, Object>();
//	      typeValues.put(String.class, String.valueOf(A_NUMBER));
//	      typeValues.put(Long.class, new Long(A_NUMBER));
//	      typeValues.put(Long.TYPE, new Long(A_NUMBER));
//	      typeValues.put(Integer.class, Integer.valueOf(A_NUMBER));
//	      typeValues.put(Integer.TYPE, Integer.valueOf(A_NUMBER));
//	      typeValues.put(Boolean.class, Boolean.TRUE);
//	      typeValues.put(Boolean.TYPE, Boolean.TRUE);
//	      typeValues.put(Long[].class, new Long[0]);
//	      typeValues.put(Integer[].class, new Integer[0]);
//	      typeValues.put(String[].class, new String[0]);
//	      typeValues.put(Boolean[].class, new Boolean[0]);
	      
	      typeValues = new HashMap<Class<?>, Randomizer>();
	      typeValues.put(String.class, Randomizer.getStringRandomizer());
	      typeValues.put(Long.class, Randomizer.getLongRandomizer());
	      typeValues.put(Long.TYPE, Randomizer.getLongRandomizer());
	      typeValues.put(Integer.class, Randomizer.getIntegerRandomizer());
	      typeValues.put(Integer.TYPE, Randomizer.getIntegerRandomizer());
	      typeValues.put(Boolean.class, Randomizer.getBooleanRandomizer());
	      typeValues.put(Boolean.TYPE, Randomizer.getBooleanRandomizer());
	      typeValues.put(Long[].class, Randomizer.getLongArrayRandomizer());
	      typeValues.put(Integer[].class, Randomizer.getIntegerArrayRandomizer());
	      typeValues.put(String[].class, Randomizer.getStringArrayRandomizer());
	      typeValues.put(Boolean[].class, Randomizer.getBooleanArrayRandomizer());
	   }
	 
	   public Object getValueFor(Class<?> clazz) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException, ClassNotFoundException 
	   {
	      if(Modifier.isFinal(clazz.getModifiers())) 
	      {
	         return typeValues.get(clazz).getRandom();
	      }
//		// TODO  
//	      if(type.equal(XmlGregorianCalendar))
	      
	      return new Initializer().setValues(clazz);      
	   }

}
