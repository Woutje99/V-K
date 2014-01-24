package controller;

import main.*;
import model.*;
import view.*;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class SimulatorController extends AbstractController implements ActionListener {
	
	//private SimulatorView simview;
    private JButton oneStep;
    private JButton hundredSteps;
    private JButton start;
    private JButton stop;
    
    private Simulator simulator;
    
    // Buttonspanels maken
    private JPanel  panel;
    
	public SimulatorController (SimulatorView simview, Simulator simulator)
    {
		super(simview);
		
		this.simulator = simulator;
		
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
        
		panel = new JPanel();
      
        oneStep = new JButton("1 step");
        oneStep.setVerticalTextPosition(SwingConstants.BOTTOM); 
        oneStep.setHorizontalTextPosition(SwingConstants.CENTER);
        oneStep.setFont(new Font("sansserif",Font.BOLD,16));
        oneStep.setForeground(Color.blue);
        oneStep.setBackground(Color.lightGray);
        oneStep.setPreferredSize(new Dimension(150, 70));
        panel.add(oneStep);
        
        hundredSteps = new JButton("100 steps");
        hundredSteps.setVerticalTextPosition(SwingConstants.BOTTOM); 
        hundredSteps.setHorizontalTextPosition(SwingConstants.CENTER);
        hundredSteps.setFont(new Font("sansserif",Font.BOLD,16));
        hundredSteps.setForeground(Color.blue);
        hundredSteps.setBackground(Color.lightGray);
        hundredSteps.setPreferredSize(new Dimension(150, 70));
        panel.add(hundredSteps);
        
       
        start = new JButton("Start simulatie<br />");
        start.setVerticalTextPosition(SwingConstants.BOTTOM); 
        start.setHorizontalTextPosition(SwingConstants.CENTER);
        start.setFont(new Font("sansserif",Font.BOLD,16));
        start.setForeground(Color.blue);
        start.setBackground(Color.lightGray);
        start.setPreferredSize(new Dimension(150, 70));
        panel.add(start);
        
        stop = new JButton("Stop simulatie");
        stop.setVerticalTextPosition(SwingConstants.BOTTOM); 
        stop.setHorizontalTextPosition(SwingConstants.CENTER);
        stop.setFont(new Font("sansserif",Font.BOLD,16));
        stop.setForeground(Color.blue);
        stop.setBackground(Color.lightGray);
        stop.setPreferredSize(new Dimension(150, 70));
        panel.add(stop);
        
        // ActionListeners implementeren op de buttons. Omdat deze klasse
        // ActionListener implementeert geef je als parameter this
        oneStep.addActionListener(this);
        hundredSteps.addActionListener(this);
        start.addActionListener(this);
        stop.addActionListener(this);
        
        add(panel);
    }
	
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource().equals(oneStep)) {
            simulator.simulateOneStep();
	    }
	    
	    else if (e.getSource().equals(hundredSteps)) {
	    	simulator.simulate(100);
	    }
	   
	    else if (e.getSource().equals(start)) {
	    	simulator.start();
	    }
	    
	    else if (e.getSource().equals(stop)) {
	    	simulator.stop();
	    }
	    
	}
	
}
	


