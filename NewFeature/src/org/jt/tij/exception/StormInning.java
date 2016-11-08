package org.jt.tij.exception;


class BaseballException extends Exception {};
class Foul extends BaseballException {};
class Strike extends BaseballException {};


abstract class Inning {
	public Inning() throws BaseballException {}
	public void event() throws BaseballException{
		
	}
	
	public abstract void atBat() throws Strike,Foul;
	public void walk(){}
		
}


class StormException extends Exception  {}
class RainedOut extends Exception {}
class PopFoul extends Foul {}

interface Storm {
	public void event() throws BaseballException;
	public void rainHard()throws RainedOut;
	
}

public class StormInning extends Inning implements Storm {
	public StormInning() throws RainedOut,BaseballException {}
	
	public  StormInning(String s) throws Foul,BaseballException {}
	
   // public void walk() throws PopFoul {};
    
 // public void event() throws BaseballException,RainedOut{}
	public  void atBat() throws Foul {}
	
	public void rainHard()throws RainedOut {}
	

}
