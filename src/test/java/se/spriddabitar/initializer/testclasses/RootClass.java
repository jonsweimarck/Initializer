package se.spriddabitar.initializer.testclasses;

public class RootClass {
	private SimpleClass leafClass;
	private Integer integer1;



	public Integer getInteger1() {
		return integer1;
	}

	public void setInteger1(Integer integer1) {
		this.integer1 = integer1;
	}

	public SimpleClass getLeafclass() {
		return leafClass;
	}

	public void setLeafclass(SimpleClass subclass) {
		this.leafClass = subclass;
	}
	
	
}
