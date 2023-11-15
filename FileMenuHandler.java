import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open"))
    	  openFile( ); 
      else if (menuName.equals("Quit"))
    	  System.exit(0); 
      else if(menuName.equals("Roman to Arabic")) {
    	  
    	  String inputSentence;
    	  int arabicNum = 0;
    	  inputSentence = JOptionPane.showInputDialog(null,"Type in a Roman Numeral:");
    	  
    	  for(int i = 0; i < inputSentence.length(); i++) {
				if(inputSentence.charAt(i) != 'I' && inputSentence.charAt(i) != 'V' && inputSentence.charAt(i) != 'X' && inputSentence.charAt(i) != 'L' && inputSentence.charAt(i) != 'C' && inputSentence.charAt(i) != 'D' && inputSentence.charAt(i) != 'M') {
					JOptionPane.showMessageDialog(null,"This contains a letter that's not a Roman Numeral! \nTry Again.");
					throw new IllegalRomanNumeralException("This letter is not a Roman Numeral!");
				}
			}
    	  
    	  for(int i = inputSentence.length() - 1; i >= 0; i--) {
  			if(inputSentence.charAt(i) == 'I') {
  				arabicNum += 1;
  			}
  			
  			if(inputSentence.charAt(i) == 'V') {
  				arabicNum += 5;
  			}
  			
  			if(inputSentence.charAt(i) == 'X') {
  				arabicNum += 10;
  			}
  			
  			if(inputSentence.charAt(i) == 'L') {
  				arabicNum += 50;
  			}
  			
  			if(inputSentence.charAt(i) == 'C') {
  				arabicNum += 100;
  			}
  			
  			if(inputSentence.charAt(i) == 'D') {
  				arabicNum += 500;
  			}
  			
  			if(inputSentence.charAt(i) == 'M') {
  				arabicNum += 1000;
  			}
  			
  			if(i <= inputSentence.length() - 2) {
  			
  				if((inputSentence.charAt(i) == 'I' && inputSentence.charAt(i + 1) == 'V') || (inputSentence.charAt(i) == 'I' && inputSentence.charAt(i + 1) == 'X')) {
  					arabicNum -= 2;
  				}
  			
  				if((inputSentence.charAt(i) == 'X' && inputSentence.charAt(i + 1) == 'L') || (inputSentence.charAt(i) == 'X' && inputSentence.charAt(i + 1) == 'C')) {
  					arabicNum -= 20;
  				}
  			
  				if((inputSentence.charAt(i) == 'C' && inputSentence.charAt(i + 1) == 'D') || (inputSentence.charAt(i) == 'C' && inputSentence.charAt(i + 1) == 'M')) {
  					arabicNum -= 200;
  				}
  				
  			}
  		}
    	  
    	JOptionPane.showMessageDialog(null,"Roman Numeral: " + inputSentence + "\nIs Equivalent to : " + arabicNum);
    	  
      }
      
      	  
   } 
   
   private void openFile( ) {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    }
   
   private void readSource(File chosenFile) {
       String chosenFileName = chosenFile.getAbsolutePath();
       TextFileInput inFile = new TextFileInput(chosenFileName);
       StringTokenizer myTokens;
       String[] numerals;
   	   String line = "";
       
       Container translatePanel = jframe.getContentPane();
	   translatePanel.setLayout(new GridLayout(1, 3));
	   JTextArea romanNum = new JTextArea();
	   JTextArea unsortedArabicNum = new JTextArea();
	   JTextArea sortedArabicNum = new JTextArea();
	   
	   translatePanel.add(romanNum);
	   translatePanel.add(unsortedArabicNum);
	   translatePanel.add(sortedArabicNum);
	   
	   for(int i = 0; i < 5; i++) {
			line += (inFile.readLine() + "\n");
		}
	    
	    myTokens = new StringTokenizer(line,",\n");
		numerals = new String[myTokens.countTokens()];
		
		UnsortedRomanNumeralList urnl = new UnsortedRomanNumeralList();
		SortedRomanNumeralList srnl = new SortedRomanNumeralList();
		RomanNumeral rn;
		RomanNumeral newrn;
		LinkedListIterator rnlli;
		
		int i = 0;
	    while (myTokens.hasMoreTokens()) {
	       numerals[i]=myTokens.nextToken();
	       i++;
	    }
	    
	     
	    for(int k = 0; k < numerals.length; k++) {
	         romanNum.append((numerals[k]) + "\n"); 
	    }
	    
	    
	    
	    for(int j = 0; j < numerals.length; j++) {
	    	rn = new RomanNumeral(numerals[j]);
	    	urnl.append(rn);
	    	unsortedArabicNum.append(String.valueOf(urnl.last.data.getArabicNumeral()) + "\n");
	    }
	    
	    
	    for(int l = 0; l < numerals.length; l++) {
	    	newrn = new RomanNumeral(numerals[l]);
	    	srnl.add(newrn);
	    	
	    }  
	    
	    rnlli = srnl.reset();
	    
	    while(rnlli.hasNext()) {
	    	sortedArabicNum.append(rnlli.next() + "\n");
	    }
	   
		
		
		jframe.setContentPane(translatePanel);
	    jframe.setVisible(true);
   }

    
       
}