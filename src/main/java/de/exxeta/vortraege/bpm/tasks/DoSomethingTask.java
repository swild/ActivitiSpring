package de.exxeta.vortraege.bpm.tasks;

public class DoSomethingTask {

	
	private boolean didSomething = false;
	
	
	public void reset(){
		didSomething = false;
	}
	
	public void doSomething(){
		didSomething = true;
	}
	
	public boolean hasSomethingBeenDone(){
		return didSomething;
	}
	
}
