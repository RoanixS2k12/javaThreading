package def;
/*___________________________________________________________________________*/
/**
 * Fichier : Bonjour.java
 *
 * Crée le 6 janv. 2014 à 08:54:07
 *
 * @author : EL FATTAKE Abdessamad
 */

/*___________________________________________________________________________*/
/**
 *
 */
public class Bonjour extends Thread
{
	private String nom;
	
	private BonjourPoto poteau;
	
	private int compteur = 1;
	
	private boolean stop = false;
	
	public void stopThread()
	{
		stop = true;
	}
	
	public void restartThread()
	{
		stop = false;
		run();
	}
	
	
	/*___________________________________________________________________________*/
	/**
	 *
	 */
	public Bonjour(String nom, BonjourPoto poteau)
	{
		super();
		this.nom = nom;
		this.poteau = poteau;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		
			for (int i = 1; i < 101; i++, compteur++)
			{
				if(stop)
					break;
				
				System.out.println(compteur + " " + nom);
				try
				{
					Thread.sleep(10);
				} catch (InterruptedException e)
				{
				}
			}
	}

}


/*___________________________________________________________________________*/
/*
/* Fin du fichier Bonjour.java */