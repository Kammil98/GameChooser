package com.sample;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
		
            kSession.insert(new Interafce());
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Interafce {
        /*
         * Display message box to choose one of the given options
         * @param options texts displayed as a answers
         * @param questionMsg text displayed as a question
         * @return return String representing choosed answer
         **/
        public static String showMsgBox(String questionMsg, final String[] options) {//ArrayList<String> options
        	//String[] optionsList = new String[options.size()];
        	//optionsList = options.toArray(optionsList);
        	return (String) JOptionPane.showInputDialog(null, 
        			questionMsg,
        	        "Answer, please :)",
        	        JOptionPane.QUESTION_MESSAGE, 
        	        null, 
        	        options, 
        	        options[0]);
        }
        
        /*
         * Display message box to inform 
         * about selected game
	 * @param game text displayed as a selected game
         **/
        public static void showGame(String game) {
        	JOptionPane.showMessageDialog(null, game);
        }
        
        

    }

}
