package se.spriddabitar.initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ValueFactory<T> {

	   private static final int A_NUMBER = 42;
	   private static final int HALF_A_NUMBER = 21;
	 
	   private Map<Class<?>, Object> typeValues;
	 
	   public ValueFactory() 
	   {
	      typeValues = new HashMap<Class<?>, Object>();
	      typeValues.put(String.class, "test");
	      typeValues.put(Long.class, new Long(A_NUMBER));
	      typeValues.put(Long.TYPE, new Long(A_NUMBER));
	      typeValues.put(Integer.class, Integer.valueOf(HALF_A_NUMBER));
	      typeValues.put(Integer.TYPE, Integer.valueOf(HALF_A_NUMBER));
	      typeValues.put(Boolean.class, Boolean.TRUE);
	      typeValues.put(Boolean.TYPE, Boolean.TRUE);
	      typeValues.put(Long[].class, new Long[0]);
	      typeValues.put(Integer[].class, new Integer[0]);
	      typeValues.put(String[].class, new String[0]);
	      typeValues.put(Boolean[].class, new Boolean[0]);
	   }
	 
	   public Object getValueFor(Class<T> type) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException 
	   {
	      if(Modifier.isFinal(type.getModifiers())) 
	      {
	         return typeValues.get(type);
	      }
//		// TODO  
//	      if(type.equal(XmlGregorianCalendar))
	      
	      
	      return new Initializer<T>().setValues(type);
	      
	      
	   }

}
