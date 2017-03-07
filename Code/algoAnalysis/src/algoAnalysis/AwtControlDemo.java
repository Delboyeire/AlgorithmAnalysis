package algoAnalysis;

import java.awt.*;
import java.awt.event.*;

public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;
   private Panel controlPanel2;
   private Panel controlPanel3;
   private TextArea commentTextArea;
   private TextArea commentTextArea2;
   private int[] initialElements;
   private int[] initialElementsForSystemSort;
   private String sortTypeSelected;
   private String elementNoSelected;
   private String quick, bubble, heap, small, med, large;
   
   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      AwtControlDemo  awtControlDemo = new AwtControlDemo();
      awtControlDemo.showEventDemo();
   }

   private void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(1000,600);
      mainFrame.setLayout(new GridLayout(6, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(500,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());
      
      controlPanel2 = new Panel();
      controlPanel2.setLayout(new FlowLayout());
      
      controlPanel3 = new Panel();
      controlPanel3.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(controlPanel2);
      mainFrame.add(controlPanel3);
      mainFrame.add(statusLabel);
      
      mainFrame.setVisible(true);  
   }

   private void showEventDemo(){
      headerLabel.setText("Choose Sort type and Number Of Elements"); 
      
      Button sortButton = new Button("Quicksort");
      Button resetButton = new Button("Reset");
      

      sortButton.setActionCommand("Sort");
      resetButton.setActionCommand("Reset");
     

      sortButton.addActionListener(new ButtonClickListener()); 
      resetButton.addActionListener(new ButtonClickListener()); 
     
      
      CheckboxGroup cbg1 = new CheckboxGroup();  
      Checkbox quickSortCheck = new Checkbox("QuickSort", cbg1,true);  
      quickSortCheck.setBounds(100,100, 50,50); 
      quick = quickSortCheck.getLabel();
      Checkbox bubbleSortCheck = new Checkbox("BubbleSort", cbg1, false);  
      bubbleSortCheck.setBounds(100,100, 50,50); 
      bubble = bubbleSortCheck.getLabel();
      Checkbox heapSortCheck = new Checkbox("HeapSort", cbg1, false);  
      heapSortCheck.setBounds(100,100, 50,50); 
      heap = heapSortCheck.getLabel();
      
      bubbleSortCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
             sortTypeSelected = bubbleSortCheck.getLabel();
             
          }
       });
      quickSortCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
        	  
             sortTypeSelected = quickSortCheck.getLabel();
          }
       });
      heapSortCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
             sortTypeSelected = heapSortCheck.getLabel();
          }
       });
      
      
      CheckboxGroup cbg2 = new CheckboxGroup(); 
      Checkbox smallElementsCheck = new Checkbox("Small Element Set(500)", cbg2, true);  
      smallElementsCheck.setBounds(100,100, 50,50); 
      small = smallElementsCheck.getLabel();
      Checkbox medElementsCheck = new Checkbox("Medium Elements Set(1000)", cbg2,false);  
      medElementsCheck.setBounds(100,100, 50,50); 
      med = medElementsCheck.getLabel();
      Checkbox largeElementsCheck = new Checkbox("Large Elements Set(2000)", cbg2, false);  
      largeElementsCheck.setBounds(100,100, 50,50); 
      large = largeElementsCheck.getLabel();
      
      smallElementsCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
        	  
             elementNoSelected = smallElementsCheck.getLabel();
          }
       });
      medElementsCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
             elementNoSelected = medElementsCheck.getLabel();
          }
       });
      largeElementsCheck.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
             elementNoSelected = largeElementsCheck.getLabel();
          }
       });
      commentTextArea = new TextArea("",5,50);
      commentTextArea2 = new TextArea("",5,50);

      controlPanel.add(quickSortCheck);
      controlPanel.add(bubbleSortCheck);
      controlPanel.add(heapSortCheck);
      
      controlPanel2.add(smallElementsCheck);
      controlPanel2.add(medElementsCheck);
      controlPanel2.add(largeElementsCheck);
      controlPanel3.add(commentTextArea);
      controlPanel3.add(commentTextArea2);
      controlPanel3.add(sortButton);
      controlPanel3.add(resetButton);
      

      mainFrame.setVisible(true); 
      sortTypeSelected = cbg1.getSelectedCheckbox().getLabel();
      elementNoSelected = cbg2.getSelectedCheckbox().getLabel();
      
      
      
   }

   private class ButtonClickListener implements ActionListener{
	   
	   @SuppressWarnings("unused")
	String initialElsString = "";
	  
      
	   public void actionPerformed(ActionEvent e) {
		   System.out.println(sortTypeSelected);
		   System.out.println(elementNoSelected);
    	  String command = e.getActionCommand();  
    	  System.out.println(command);
        
    	  if( command.equals( "Sort" ))  {
    		  ////////If small quick \\\\\\\\\\\\\\\\\
    		 if(sortTypeSelected == quick && elementNoSelected == small ){
    			  
	        	 QuickSortRunner runner = new QuickSortRunner();
	        	 SystemSortRunner sysrunner = new SystemSortRunner();
	        	 try {
	        		 
					initialElements = runner.setUpForQuickSmall();
					initialElementsForSystemSort = initialElements;
					for (int j = 0; j < initialElements.length; j++) {
						initialElsString += initialElements[j] + ", ";
		            }
					runner.testQuickSortSmall();
					sysrunner.testSystemSortSmall(initialElementsForSystemSort);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        	 commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
	        			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
	        	 commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
	        			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
        	 
            
    		 }
    		///////if med quick \\\\\\\\\\\\\\\\\\\\\\\
    		 if(sortTypeSelected == quick && elementNoSelected == med ){
    			   
    			 QuickSortRunner runner = new QuickSortRunner();
    			 SystemSortRunner sysrunner = new SystemSortRunner();
             	 try {
             		 
     				initialElements = runner.setUpForQuickMed();
     				for (int j = 0; j < initialElements.length; j++) {
     					initialElsString += initialElements[j] + ", ";
     	            }
     				
     				runner.testQuickSortMedium();
     				initialElementsForSystemSort = initialElements;
     				sysrunner.testSystemSortMedium(initialElementsForSystemSort);
             	 } catch (Exception e1) {
     				e1.printStackTrace();
             	 }
             	 commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
		 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
             	 commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
		 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
              }
    		 ///////////if large quick\\\\\\\\\\\\\\\\\\\
    		 if(sortTypeSelected == quick && elementNoSelected == large ){
    			   
    			 QuickSortRunner runner = new QuickSortRunner();
    			 SystemSortRunner sysrunner = new SystemSortRunner();
              	 try {
              		 
      				initialElements = runner.setUpForQuickLarge();
      				for (int j = 0; j < initialElements.length; j++) {
      					initialElsString += initialElements[j] + ", ";
      	            }
      				runner.testQuickSortLarge();
      				initialElementsForSystemSort = initialElements;
     				sysrunner.testSystemSortMedium(initialElementsForSystemSort);
              	 } catch (Exception e1) {
      				e1.printStackTrace();
              	 }
              	 commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
		 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
              	 commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
		 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
              }
    		 			////////If small heap \\\\\\\\\\\\\\\\\
    		 if(sortTypeSelected == heap && elementNoSelected == small ){
    	    			 		  
    			 HeapSortRunner runner = new HeapSortRunner();
    			 SystemSortRunner sysrunner = new SystemSortRunner();
    			 try { 
    				 initialElements = runner.setUpForHeapSmall();
    				 initialElementsForSystemSort = initialElements;
    				 for (int j = 0; j < initialElements.length; j++) {
    					 initialElsString += initialElements[j] + ", ";
    		         }
    				 runner.testHeapSortSmall();
    				 sysrunner.testSystemSortSmall(initialElementsForSystemSort);
    			} catch (Exception e1) {
    				e1.printStackTrace();
    			}
    	        commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
    	        			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
    	        commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
    	        			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
    	    }
    	    		///////if med heap \\\\\\\\\\\\\\\\\\\\\\\
    	    if(sortTypeSelected == heap && elementNoSelected == med ){
    	    			    		  
    	    	HeapSortRunner runner = new HeapSortRunner();
    	    	SystemSortRunner sysrunner = new SystemSortRunner();
    	        try { 		 
    	     		initialElements = runner.setUpForHeapMedium();
    	     		for (int j = 0; j < initialElements.length; j++) {
    	     			initialElsString += initialElements[j] + ", ";
    	     	    }		
    	     		runner.testHeapSortMedium();
    	     		initialElementsForSystemSort = initialElements;
    	     		sysrunner.testSystemSortMedium(initialElementsForSystemSort);
    	     	} catch (Exception e1) {
    	     		e1.printStackTrace();
    	     	}
    	        commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
    			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
    	        commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
    			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
    	    }
    	    		 	///////if Large heap \\\\\\\\\\\\\\\\\\\\\\\
    	    if(sortTypeSelected == heap && elementNoSelected == large ){
    	    			    		  
    	    	HeapSortRunner runner = new HeapSortRunner();
    	    	SystemSortRunner sysrunner = new SystemSortRunner();
    	        try {		 
    	     		initialElements = runner.setUpForHeapLarge();
    	     		for (int j = 0; j < initialElements.length; j++) {
    	     			initialElsString += initialElements[j] + ", ";
    	     	    }		
    	     		runner.testHeapSortLarge();
    	     		initialElementsForSystemSort = initialElements;
    	     		sysrunner.testSystemSortLarge(initialElementsForSystemSort);
    	     	} catch (Exception e1) {
    	     		e1.printStackTrace();
    	     	}
    	        commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
    			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
    	        commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
    			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
    	    }
    	    	////////If small bubble \\\\\\\\\\\\\\\\\
    	    if(sortTypeSelected == bubble && elementNoSelected == small ){
        	    			 		  
        		 BubbleSortTestRunner runner = new BubbleSortTestRunner();
        		 SystemSortRunner sysrunner = new SystemSortRunner();
        		 try { 
        			 initialElements = runner.setUpForBubbleSmall();
        			 initialElementsForSystemSort = initialElements;
        			 for (int j = 0; j < initialElements.length; j++) {
        				 initialElsString += initialElements[j] + ", ";
        	         }
        			 runner.testBubbleSortSmall();
        			 sysrunner.testSystemSortSmall(initialElementsForSystemSort);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
                commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
                			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
                commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
       	        			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
      	   }
    		////////If Medium bubble \\\\\\\\\\\\\\\\\
    	    if(sortTypeSelected == bubble && elementNoSelected == med ){
        	    			 		  
        		 BubbleSortTestRunner runner = new BubbleSortTestRunner();
        		 SystemSortRunner sysrunner = new SystemSortRunner();
        		 try { 
        			 initialElements = runner.setUpForBubbleMedium();
        			 initialElementsForSystemSort = initialElements;
        			 for (int j = 0; j < initialElements.length; j++) {
        				 initialElsString += initialElements[j] + ", ";
        	         }
        			 runner.testBubbleSortMedium();
        			 sysrunner.testSystemSortMedium(initialElementsForSystemSort);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
                commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
                			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
                commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
       	        			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
      	   }
    ////////If Large bubble \\\\\\\\\\\\\\\\\
    	    if(sortTypeSelected == bubble && elementNoSelected == large ){
        	    			 		  
        		 BubbleSortTestRunner runner = new BubbleSortTestRunner();
        		 SystemSortRunner sysrunner = new SystemSortRunner();
        		 try { 
        			 initialElements = runner.setUpForBubbleLarge();
        			 initialElementsForSystemSort = initialElements;
        			 for (int j = 0; j < initialElements.length; j++) {
        				 initialElsString += initialElements[j] + ", ";
        	         }
        			 runner.testBubbleSortLarge();
        			 sysrunner.testSystemSortLarge(initialElementsForSystemSort);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
                commentTextArea.setText("Quick Sort time taken: " + runner.elapsedTime + "ns, memory used : " + runner.memory + "\n" + 
                			 				"System Sort Time Taken: " + sysrunner.elapsedTime + "ns, memory used : " + sysrunner.memory );
                commentTextArea2.setText("Difference in time taken: " + ((runner.elapsedTime - sysrunner.elapsedTime)/1000) + "ms" + "\n" +
       	        			 					"Difference  in memory used: " + (runner.memory- sysrunner.memory));
      	   }
    		 
    	  }
    	  
    	 
         else if( command.equals( "Reset" ) )  {
            statusLabel.setText("Reset button pressed"); 
         }
         	
      }	
	   
   }
   
}
