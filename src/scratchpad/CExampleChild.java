package scratchpad;

public class CExampleChild extends CExampleParent{

	public CExampleChild(){
		System.out.println("Child constuctor invoked.");
	}
	
	@Override
	public void foo(){
		super.foo();
		System.out.println("The pizza belongs to me!");
	}
}
