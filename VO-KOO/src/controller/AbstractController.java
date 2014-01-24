package controller;

import main.*;
import model.*;
import view.*;

import javax.swing.*;


/**
 * Abstracte klasse voor een controller. Deze klasse extends JPanel
 *
 */
public abstract class AbstractController extends JPanel {
        
        protected SimulatorView simView;
        
        /**
         * Super contructor voor een AbstractController. Stelt de simulator View in.
         * @param simView
         */
        public AbstractController(SimulatorView simView) {
                this.simView = simView;
        }
        
        /**
         * Getter voor de simulatorView
         * @return simView
         */
        public SimulatorView getSimulatorView() {
                return simView;
        }
}