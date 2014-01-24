package view;


import model.*;

import java.util.HashMap;
import java.awt.*;

import javax.swing.JPanel;


public class CircleStats extends JPanel
{
       
	private Field field;
	private FieldStats stats;
	private HashMap <Class, Counter> counters;
	
	
	public CircleStats(FieldStats stats)
	{
		// Instantievariabelen initialiseren met de waarden van de parameters
		this.stats = stats;
		counters = new HashMap<Class, Counter>();
        counters = stats.getPopulationStats(field);
	}
	
	public void paintComponent(Graphics g)
	{		
		double total = 0.0;
		double rabbits = 0.0;
		double foxes = 0.0;
		double bears = 0.0;
		
		System.out.println(counters.size());
		
        for(Class key : counters.keySet())
        {
            // Zet het eerste element uit de iteratie van het objecttype Counter in een variabele
        	Counter info = counters.get(key);
        	
        	System.out.println(info.getName() +" "+info.getCount());
        	
        	// Totaal aantal foxes and rabbits
        	total += info.getCount();

        	if(info.getName().equals("model.Rabbit"))
        	{
        		rabbits = info.getCount();
        		//System.out.println(info.get);
        	}
        	if(info.getName().equals("model.Fox"))
        	{
        		foxes = info.getCount();
        	}
        	if(info.getName().equals("model.Bear"))
        	{
        		bears = info.getCount();
        	}
        }
        
        double oneperc = total / 100;
    	double rabbitperc = rabbits / oneperc;
    	double foxesperc = foxes / oneperc;
    	double bearsperc = bears / oneperc;
    	
    	double rabbitpie = 3.6 * rabbitperc;
    	double foxpie = 3.6 * foxesperc;
    	double bearpie = 3.6 * bearsperc;
    	
    	g.drawArc(10,10, 100, 100, 90, 360);
		g.setColor(Color.orange);
    	g.fillArc(10, 10,100, 100, 90, (int) rabbitpie);
		g.setColor(Color.blue);
    	g.fillArc(10, 10,100, 100, 90 + (int) rabbitpie, (int) foxpie);
    	g.setColor(Color.red);
    	g.fillArc(10, 10,100, 100, 90 + (int) rabbitpie + (int) foxpie, (int) bearpie);
	}
	
}
