package def;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*___________________________________________________________________________*/
/**
 * Fichier : BonjourPoto.java
 *
 * Crée le 6 janv. 2014 à 09:08:40
 *
 * @author : EL FATTAKE Abdessamad
 */

/*___________________________________________________________________________*/
/**
 *
 */
public class BonjourPoto implements Runnable
{
	public String nom;
	
	private boolean actifeu = true;
	
	private int compteur;
	
	private Thread threadCourant;
	
	public Thread getThreadCourrant()
	{
		return threadCourant;
	}
	
	/*___________________________________________________________________________*/
	/**
	 *
	 */
	public BonjourPoto(String nom)
	{
		super();
		this.nom = nom;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		
		String interuption = "";
		
			while(actifeu)
			{
				System.out.println(compteur + " " + nom);
				
				
				interuption = threadCourant.isInterrupted() ? "est interompu" : "non interrompu";
				if(interuption.startsWith("est"))
					sauvegarder(interuption);
				compteur++;
			}		
	}
	
	/*_________________________________________________________________*/
	/**
	 * @param interuption
	 */
	private void sauvegarder(String interuption) {
		File fich = new File("save/interruption.txt") ;
		fich.getParentFile().mkdirs() ;
		try
		{
			PrintStream sortie = new PrintStream(new FileOutputStream(fich)) ;
			sortie.println(interuption) ;
			sortie.close() ;
		} catch (FileNotFoundException e){}

	}

	public void lancer()
	{
		actifeu = true;
		threadCourant = new Thread(this);
		if(!nom.equals("Jim"))
			threadCourant.setDaemon(true);
		threadCourant.start();
	}
	
	public void arreter()
	{
		actifeu = false;
	}
}


/*___________________________________________________________________________*/
/*
/* Fin du fichier BonjourPoto.java */