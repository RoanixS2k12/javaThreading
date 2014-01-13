/*___________________________________________________________________________*/
/**
 * Fichier : TestThreads.java
 *
 * Crée le 6 janv. 2014 à 09:11:33
 *
 * @author : EL FATTAKE Abdessamad
 */
package tests;

import def.BonjourPoto;

/*___________________________________________________________________________*/
/**
 *
 */
public class TestThreads
{
	
	
	public static void main(String[] args)
	{
		BonjourPoto jules = new BonjourPoto("Jules");
		
		jules.lancer();
	
		try 
		{
			Thread.sleep(500);
			jules.getThreadCourrant().interrupt();
		}
		catch(Exception e)
		{
			
		}
		
		
		System.out.println("end");
	}
}



/*___________________________________________________________________________*/
/*
/* Fin du fichier TestThreads.java */