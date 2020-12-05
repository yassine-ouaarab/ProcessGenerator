package backPresentation;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import backMetier.Etape;
import backMetier.Etat;
import backMetier.Processus;
import backPersistance.DaoChefDivision;
import backPersistance.DaoEmploye;
import backPersistance.DaoProcessus;


  public class ManagerPsInterface {
  
    	static DaoProcessus daoproc = new DaoProcessus();
    	static DaoChefDivision daochefDivision = new DaoChefDivision();
    
        // create JFrame and JTable
    	static JFrame frame = new JFrame();
    	static JTable table = new JTable();
    	
    	static DefaultTableModel model = new DefaultTableModel() {
        	@Override
			public boolean isCellEditable(int row, int column){
            	for(int i=0;i<=daoproc.listProcessus().size();i++)
		        	{	
            			if(model.getValueAt(i, 3).toString().equals("ARCHIVE"))
		        		{
		        			for(int j=0;j<=4;j++)
		                	{if(row == i && column == j) 
		                	return false;}
		                }
            			if(model.getValueAt(i, 3).toString().equals("ARCHIVE")==false)
		        		{
		        			for(int j=0;j<=4;j++)
		                	{if(row == i && column == j) 
		                	return true;}
		                }
		        	}
                return true;
			  }
			};
	  
	  	    public static void main(String[] args){
	  	        // create a table model and set a Column Identifiers to this model 
	  	        Object[] columns = {"Id Processus","Nom Processus","Description Processus","Etat Processus","Chef Division"};
	  	        model.setColumnIdentifiers(columns);
	  	        
	  	        // set the model to the table
	  	        table.setModel(model);
	  	        
	  	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	  	        table.setBackground(Color.LIGHT_GRAY);
	  	        table.setForeground(Color.black);
	  	        table.setRowHeight(30);
	  	        
	  	        // create JLabels
	  	    	JLabel JL1 = new JLabel("Id Proc :");
	  	    	JLabel JL2 = new JLabel("Nom Proc :");
	  	    	JLabel JL3 = new JLabel("Description :");
	  	    	JLabel JL5 = new JLabel("Chef Division :");
	  	        
	  	        // create JTextFields
	  	        JTextField textidProc = new JTextField();
	  	        JTextField textnomProc = new JTextField();
	  	        JTextField textdescProc = new JTextField();
	  	        JTextField textchefDivProc = new JTextField();
		        JTextField textsearchEmp = new JTextField("Search by ID Processus");
	  	        
	  	        // create JButtons
	  	        JButton btnAdd = new JButton("Add");
	  	        JButton btnDelete = new JButton("Delete");
	  	        JButton btnUpdate = new JButton("Update"); 
	  	        JButton btnArchive = new JButton("Archive"); 
	  	        JButton btnActive = new JButton("Active"); 
	  	        JButton btnAffecter = new JButton("Affecter Process"); 
		        JButton btnO = new JButton("O");     
		        JButton btnX = new JButton("X"); 
	  	        
	  	        String items[] = new String[daochefDivision.listChefDivisions().size()];
	  	        for (int i=0;i<daochefDivision.listChefDivisions().size();i++)
	  			{
	  			items[i]= String.valueOf(daochefDivision.listChefDivisions().get(i).getId_chefDivision());
	  			}
	  	         JComboBox JCOMB = new JComboBox(items);

	  	        JL1.setBounds(20, 220, 100, 25);
	  	        JL2.setBounds(20, 270, 100, 25);
	  	        JL3.setBounds(20, 320, 100, 25);
	  	        JL5.setBounds(230, 220, 100, 25);
	  	        
	  	        textidProc.setBounds(110, 220, 100, 25);
	  	        textnomProc.setBounds(110, 270, 100, 25);
	  	        textdescProc.setBounds(110, 320, 100, 25);
	  	        textchefDivProc.setBounds(330, 220, 100, 25);
	  	        
		        btnAdd.setBounds(460, 250, 100, 25);
		        btnUpdate.setBounds(560, 250, 100, 25);
		        btnDelete.setBounds(660, 250, 100, 25);
		        btnArchive.setBounds(760, 250, 100, 25);
		        btnActive.setBounds(760, 210, 100, 25);
		        
	  	        JCOMB.setBounds(505, 280, 100, 25);
	  	        btnAffecter.setBounds(610, 280, 170, 25);

		        textsearchEmp.setBounds(499, 310, 240, 26);
		        btnO.setBounds(744, 310, 45, 25);
		        btnX.setBounds(794, 310, 45, 25);
		        
	  	        // create JScrollPane
	  	        JScrollPane pane = new JScrollPane(table);
	  	        pane.setBounds(0, 0, 880, 200);
	  	        
	  	        frame.setLayout(null);
	  	        
	  	        frame.add(pane);
	  	        
	  	        frame.add(JL1);
	  	        frame.add(JL2);
	  	        frame.add(JL3);
	  	        frame.add(JL5);
	  	        
	  	        // add JTextFields to the jframe
	  	        frame.add(textidProc);
	  	        frame.add(textnomProc);
	  	        frame.add(textdescProc);
	  	        frame.add(textchefDivProc);
		        frame.add(textsearchEmp);
	  	        
	  	        // add JButtons to the jframe
	  	        frame.add(btnAdd);
	  	        frame.add(btnDelete);
	  	        frame.add(btnUpdate);
	  	        frame.add(btnArchive);
	  	        frame.add(btnActive);
	  	        
	  	        frame.add(JCOMB);
	  	        frame.add(btnAffecter);
		        frame.add(btnO);
		        frame.add(btnX);
	  	        
	  	        //Affichage de tableau :
	  	        
	  			for (int i=0;i<daoproc.listProcessus().size();i++)
	  			{
	  			int id_Ps = daoproc.listProcessus().get(i).getId_processus();
	  			String nom = daoproc.listProcessus().get(i).getNom_processus();
	  			String description = daoproc.listProcessus().get(i).getDescription_processus();
	  			String etat = daoproc.listProcessus().get(i).getEtat_processus().name();
	  			int id_chefDiv = daoproc.listProcessus().get(i).getId_chefDivision();
	  			 Object[] data = {id_Ps, nom, description, etat, id_chefDiv};
	  			 model.addRow(data);
	  			}
	  			
	  	        
	  	        // create an array of objects to set the row data
	  	        String[] row = new String[5];
	  	        
	  	        
	  	        
	  	        // button add row
	  	        btnAdd.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	                row[0] = textidProc.getText();
	  	                row[1] = textnomProc.getText();
	  	                row[2] = textdescProc.getText();
	  	                row[4] = textchefDivProc.getText();
	  	                
	  	                // add row to the model
	  	                model.addRow(row); 
	  	                int x = Integer.parseInt(row[0]);
	  	                int x2 = Integer.parseInt(row[4]);
	  	                
	  	    	        Processus proc = new Processus(x,row[1],row[2],Etat.ACTIVE,x2);
						
	  	    	        daoproc.addProcessus(proc);          
	  	    	    
		    			 model.setRowCount(0);
		    			 
	  		  			for (int i=0;i<daoproc.listProcessus().size();i++)
	  		  			{
	  		  			int id_Ps = daoproc.listProcessus().get(i).getId_processus();
	  		  			String nom = daoproc.listProcessus().get(i).getNom_processus();
	  		  			String description = daoproc.listProcessus().get(i).getDescription_processus();
	  		  			String etat = daoproc.listProcessus().get(i).getEtat_processus().name();
	  		  			int id_chefDiv = daoproc.listProcessus().get(i).getId_chefDivision();
	  		  			 Object[] data = {id_Ps, nom, description, etat, id_chefDiv};
	  		  			 model.addRow(data);
	  		  			}
	  		  			
	  	            
	  	            }
	  	        });
	  	        
	  	        // button remove row
	  	        btnDelete.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	            
	  	                // i = the index of the selected row
	  	                int i = table.getSelectedRow();

	                      int x = Integer.parseInt(model.getValueAt(i, 0).toString());
	                      
	  	                if(i >= 0){
	  	                    // remove a row from jtable
	  	                    model.removeRow(i);
	  	                    Processus proc = new Processus(x);
	  		    	        daoproc.deleteProcessus(proc);
	  	                    
	  	                }
	  	                else{
	  	                    System.out.println("Delete Error");
	  	                }
	  	            }
	  	        });
	  	        
	  	        // get selected row data From table to textfields 
	  	        table.addMouseListener(new MouseAdapter(){
	  	        
	  	        @Override
	  	        public void mouseClicked(MouseEvent e){
	  	            
	  	            // i = the index of the selected row
	  	            int i = table.getSelectedRow();
	  	          if(model.getValueAt(i, 3).toString().equals("ARCHIVE"))
	  	          {
	            	btnAdd.setEnabled(false);
	            	btnUpdate.setEnabled(false);
	            	btnDelete.setEnabled(false);
	            	btnAffecter.setEnabled(false);
	            	btnArchive.setEnabled(false);
	            	btnActive.setEnabled(true);
	            	JCOMB.setEnabled(false);
	            	
	  	            textidProc.setText(model.getValueAt(i, 0).toString());
	  	            textnomProc.setText(model.getValueAt(i, 1).toString());
	  	            textdescProc.setText(model.getValueAt(i, 2).toString());
	  	            textchefDivProc.setText(model.getValueAt(i, 4).toString());
	  	          }
	  	          if(model.getValueAt(i, 3).toString().equals("ARCHIVE")==false)
	  	          {
		            	btnAdd.setEnabled(true);
		            	btnUpdate.setEnabled(true);
		            	btnDelete.setEnabled(true);
		            	btnAffecter.setEnabled(true);
		            	JCOMB.setEnabled(true);
		            	btnArchive.setEnabled(true);
		            	btnActive.setEnabled(false);
		            	
	  	            textidProc.setText(model.getValueAt(i, 0).toString());
	  	            textnomProc.setText(model.getValueAt(i, 1).toString());
	  	            textdescProc.setText(model.getValueAt(i, 2).toString());
	  	            textchefDivProc.setText(model.getValueAt(i, 4).toString());
	  	          }

	  	        }
	  	        });
	  	        
	  	        // button update row
	  	        btnUpdate.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	                // i = the index of the selected row
	  	                int i = table.getSelectedRow();
	  	                  
	  	                if(i >= 0) 
	  	                {
	  	                   model.setValueAt(textidProc.getText(), i, 0);
	  	                   model.setValueAt(textnomProc.getText(), i, 1);
	  	                   model.setValueAt(textdescProc.getText(), i, 2);
	  	                   model.setValueAt(textchefDivProc.getText(), i, 4);
	  	                    

	  	                    int x = Integer.parseInt(textidProc.getText());
	  	                    String x1 = textnomProc.getText();
	  		                String x2 = textdescProc.getText();
	  		                String x3 = model.getValueAt(i, 3).toString();
	  		                int x4 = Integer.parseInt(textchefDivProc.getText());

	  		                
	  	                    Processus proc = new Processus(x,x1,x2,x4);

							if(x3.equals("ACTIVE"))
							{
								proc.setEtat_processus(Etat.ACTIVE);
							}
							else if(x3.equals("ARCHIVE"))
							{
									proc.setEtat_processus(Etat.ARCHIVE);	
							}
							
	  		    	        daoproc.updateProcessus(proc);
	  	                }
	  	                else{
	  	                    System.out.println("Update Error");
	  	                }
	  	            }
	  	        });
	  	        
	  	        btnAffecter.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	           // i = the index of the selected row
	  	                int i = table.getSelectedRow();
	  	                  
	  	                if(i >= 0) 
	  	                {

	  	                    int x = Integer.parseInt(textidProc.getText());
	  	                    String x1 = textnomProc.getText();
	  		                String x2 = textdescProc.getText();
	  		                String x3 = model.getValueAt(i, 3).toString();
	  		                int x4 = Integer.parseInt((String)JCOMB.getSelectedItem());
	  		                
	  		                Processus proc = new Processus(x,x1,x2,x4);

							if(x3.equals("ACTIVE"))
							{
								proc.setEtat_processus(Etat.ACTIVE);
							}
							else if(x3.equals("ARCHIVE"))
							{
									proc.setEtat_processus(Etat.ARCHIVE);	
							}
							
	  		    	        daoproc.affecterProcessus(proc);
	  		    	        textchefDivProc.setText((String)JCOMB.getSelectedItem());
	  		    	        
		  	                model.setValueAt(textidProc.getText(), i, 0);
		  	                model.setValueAt(textnomProc.getText(), i, 1);
		  	                model.setValueAt(textdescProc.getText(), i, 2);
		  	                model.setValueAt(textchefDivProc.getText(), i, 4);
	  	                }
	  	                else{
	  	                    System.out.println("Affectation Error");
	  	                }
	  	            	
	  	            }
	  	        });
	  	        
	  	        
	  	        // button update row
	  	        btnArchive.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	                // i = the index of the selected row
	  	                int i = table.getSelectedRow();
	  	                  
	  	                if(i >= 0) 
	  	                {
	  	                   model.setValueAt(textidProc.getText(), i, 0);
	  	                   model.setValueAt(textnomProc.getText(), i, 1);
	  	                   model.setValueAt(textdescProc.getText(), i, 2);
	  	                   model.setValueAt(textchefDivProc.getText(), i, 4);
	  	                    

	  	                    int x = Integer.parseInt(textidProc.getText());
	  	                    String x1 = textnomProc.getText();
	  		                String x2 = textdescProc.getText();
	  		                int x4 = Integer.parseInt(textchefDivProc.getText());

	  		                
	  	                    Processus proc = new Processus(x,x1,x2,Etat.ARCHIVE,x4);

							
	  		    	        daoproc.updateProcessus(proc);
	  		    	        
			    	        //clean jtable
			    	        model.setRowCount(0);
			    	        
				  			for (int i1=0;i1<daoproc.listProcessus().size();i1++)
				  			{
				  			int id_Ps = daoproc.listProcessus().get(i1).getId_processus();
				  			String nom = daoproc.listProcessus().get(i1).getNom_processus();
				  			String description = daoproc.listProcessus().get(i1).getDescription_processus();
				  			String etat = daoproc.listProcessus().get(i1).getEtat_processus().name();
				  			int id_chefDiv = daoproc.listProcessus().get(i1).getId_chefDivision();
				  			 Object[] data = {id_Ps, nom, description, etat, id_chefDiv};
				  			 model.addRow(data);
				  			}
				  			
	  	                }
	  	                else{
	  	                    System.out.println("Update Error");
	  	                }
	  	            }
	  	        });
	  	        
	  	   // button update row
	  	        btnActive.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	                // i = the index of the selected row
	  	                int i = table.getSelectedRow();
	  	                  
	  	                if(i >= 0) 
	  	                {
	  	                   model.setValueAt(textidProc.getText(), i, 0);
	  	                   model.setValueAt(textnomProc.getText(), i, 1);
	  	                   model.setValueAt(textdescProc.getText(), i, 2);
	  	                   model.setValueAt(textchefDivProc.getText(), i, 4);
	  	                    

	  	                    int x = Integer.parseInt(textidProc.getText());
	  	                    String x1 = textnomProc.getText();
	  		                String x2 = textdescProc.getText();
	  		                int x4 = Integer.parseInt(textchefDivProc.getText());

	  		                
	  	                    Processus proc = new Processus(x,x1,x2,Etat.ACTIVE,x4);

							
	  		    	        daoproc.updateProcessus(proc);
	  		    	        
			    	        //clean jtable
			    	        model.setRowCount(0);
			    	        
				  			for (int i1=0;i1<daoproc.listProcessus().size();i1++)
				  			{
				  			int id_Ps = daoproc.listProcessus().get(i1).getId_processus();
				  			String nom = daoproc.listProcessus().get(i1).getNom_processus();
				  			String description = daoproc.listProcessus().get(i1).getDescription_processus();
				  			String etat = daoproc.listProcessus().get(i1).getEtat_processus().name();
				  			int id_chefDiv = daoproc.listProcessus().get(i1).getId_chefDivision();
				  			 Object[] data = {id_Ps, nom, description, etat, id_chefDiv};
				  			 model.addRow(data);
				  			}
				  			
	  	                }
	  	                else{
	  	                    System.out.println("Update Error");
	  	                }
	  	            }
	  	        });
	  	        
	  	      btnO.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		             
		            	int searchid= Integer.parseInt(textsearchEmp.getText());

		    			int id = daoproc.getProcessus(searchid).getId_processus();
		    			String nom_processus = daoproc.getProcessus(searchid).getNom_processus();
		    			String description = daoproc.getProcessus(searchid).getDescription_processus();
		    			String etat_processus = daoproc.getProcessus(searchid).getEtat_processus().name();
		    			int chef_processus = daoproc.getProcessus(searchid).getId_chefDivision();
		    			 Object[] dt = {id, nom_processus, description, etat_processus, chef_processus};
		    			 model.setRowCount(0);
		    			 model.addRow(dt);
		    			}
		        });
		        
		        btnX.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		    			 model.removeRow(0);
			    			for (int i=0;i<daoproc.listProcessus().size();i++)
			    			{
			    			int id = daoproc.listProcessus().get(i).getId_processus();
			    			String nom_processus = daoproc.listProcessus().get(i).getNom_processus();
			    			String description = daoproc.listProcessus().get(i).getDescription_processus();
			    			String etat_processus = daoproc.listProcessus().get(i).getEtat_processus().name();
			    			int chef_processus = daoproc.listProcessus().get(i).getId_chefDivision();
			    			 Object[] data = {id, nom_processus, description, etat_processus, etat_processus};
			    			 model.addRow(data);
			    			}
		    			}
		        });
	  	        
	  	        frame.setSize(900,400);
	  	        frame.setLocationRelativeTo(null);
	  	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	        frame.setVisible(true);
	  	        frame.setTitle("Processus Manager");
	  	        
	  	    }
}