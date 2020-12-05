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
import backPersistance.DaoEmploye;
import backPersistance.DaoEtape;

  public class ManagerEtapeInterface {
  
	  	    public static void main(String[] args){

	  	    	DaoEtape daoetape = new DaoEtape();
	  	    	DaoEmploye daoemploye = new DaoEmploye();
	  		    JTable table = new JTable(); 
	  	  	    DefaultTableModel model = new DefaultTableModel();
	  	    
	  	        // create JFrame and JTable
	  	        JFrame frame = new JFrame();
	  	        
	  	        // create a table model and set a Column Identifiers to this model 
	  	        Object[] columns = {"Id Etape","Nom Etape","Description Etape","Rapport Etape","Employe Etape","Processus Etape"};
	  	        model.setColumnIdentifiers(columns);
	  	        
	  	        // set the model to the table
	  	        table.setModel(model);
	  	        
	  	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	  	        table.setBackground(Color.LIGHT_GRAY);
	  	        table.setForeground(Color.black);
	  	        table.setRowHeight(30);
	  	        
	  	        // create JLabels
	  	    	JLabel JL1 = new JLabel("Id Etape :");
	  	    	JLabel JL2 = new JLabel("Nom Etape :");
	  	    	JLabel JL3 = new JLabel("Description :");
	  	    	JLabel JL4 = new JLabel("Rapport :");
	  	    	JLabel JL5 = new JLabel("Employe :");
	  	    	JLabel JL6 = new JLabel("Processus :");
	  	        

		        JTextField textidEtape = new JTextField();
		        JTextField textnomEtape = new JTextField();
		        JTextField textdescEtape = new JTextField();
		        JTextField textrappEtape = new JTextField();
		        JTextField textempEtape = new JTextField();
		        JTextField textpsEtape = new JTextField();
		        JTextField textsearchEmp = new JTextField("Search by ID Etape");
		        
	  	        // create JButtons
	  	        JButton btnAdd = new JButton("Add");
	  	        JButton btnDelete = new JButton("Delete");
	  	        JButton btnUpdate = new JButton("Update");     
	  	        JButton btnAffecter = new JButton("Affecter Etape");
		        JButton btnO = new JButton("O");     
		        JButton btnX = new JButton("X"); 
	  	        
	  	        JOptionPane JOP = new JOptionPane();


	  	        String items[] = new String[daoemploye.listEmployes().size()];
	  	        for (int i=0;i<daoemploye.listEmployes().size();i++)
	  			{
	  			items[i]= String.valueOf(daoemploye.listEmployes().get(i).getId_employe());
	  			}
	  	         JComboBox JCOMB = new JComboBox(items);
	  	         
	  	        JL1.setBounds(20, 220, 100, 25);
	  	        JL2.setBounds(20, 270, 100, 25);
	  	        JL3.setBounds(20, 320, 100, 25);
	  	        JL4.setBounds(230, 220, 100, 25);
	  	        JL5.setBounds(230, 270, 100, 25);
	  	        JL6.setBounds(230, 320, 100, 25);
	  	        
	  	        textidEtape.setBounds(110, 220, 100, 25);
	  	        textnomEtape.setBounds(110, 270, 100, 25);
	  	        textdescEtape.setBounds(110, 320, 100, 25);
	  	        textrappEtape.setBounds(315, 220, 100, 25);
	  	        textempEtape.setBounds(315, 270, 100, 25);
	  	        textpsEtape.setBounds(315, 320, 100, 25);
	  	        
	  	        btnAdd.setBounds(490, 250, 100, 25);
	  	        btnUpdate.setBounds(590, 250, 100, 25);
	  	        btnDelete.setBounds(690, 250, 100, 25);
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
	  	        frame.add(JL4);
	  	        frame.add(JL5);
	  	        frame.add(JL6);
	  	        // add JTextFields to the jframe
	  	        frame.add(textidEtape);
	  	        frame.add(textnomEtape);
	  	        frame.add(textdescEtape);
	  	        frame.add(textrappEtape);
	  	        frame.add(textempEtape);
	  	        frame.add(textpsEtape);
		        frame.add(textsearchEmp);
	  	    
	  	        // add JButtons to the jframe
	  	        frame.add(btnAdd);
	  	        frame.add(btnDelete);
	  	        frame.add(btnUpdate);
	  	        frame.add(JCOMB);
	  	        frame.add(btnAffecter);
		        frame.add(btnO);
		        frame.add(btnX);
	  	        
	  	        //Affichage de tableau :
	  	        
	  			for (int i=0;i<daoetape.listEtapes().size();i++)
	  			{
	  			int id = daoetape.listEtapes().get(i).getId_etape();
	  			String nom = daoetape.listEtapes().get(i).getNom_etape();
	  			String description = daoetape.listEtapes().get(i).getDescription_etape();
	  			String rapport = daoetape.listEtapes().get(i).getRapport_etape();
	  			int employe = daoetape.listEtapes().get(i).getEmploye_etape();
	  			int processus = daoetape.listEtapes().get(i).getProcessus_etape();
	  			 Object[] data = {id, nom, description, rapport, employe, processus};
	  			 model.addRow(data);
	  			}
	  			
	  	        
	  	        // create an array of objects to set the row data
	  	        String[] row = new String[6];
	  	        
	  	        
	  	        
	  	        // button add row
	  	        btnAdd.addActionListener(new ActionListener(){

	  	            @Override
	  	            public void actionPerformed(ActionEvent e) {
	  	             
	  	                row[0] = textidEtape.getText();
	  	                row[1] = textnomEtape.getText();
	  	                row[2] = textdescEtape.getText();
	  	                row[3] = textrappEtape.getText();
	  	                row[4] = textempEtape.getText();
	  	                row[5] = textpsEtape.getText();
	  	                
	  	                // add row to the model
	  	                model.addRow(row); 
	  	                int x = Integer.parseInt(row[0]);
	  	                int x2 = Integer.parseInt(row[4]);
	  	                int x3 = Integer.parseInt(row[5]);
	  	    	        Etape etape = new Etape(x,row[1],row[2],row[3],x2,x3);
	  	    	        daoetape.addEtape(etape);          }
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
	  	                    Etape etape = new Etape(x);
	  		    	        daoetape.deleteEtape(etape);
	  	                    
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
	  	            
	  	            textidEtape.setText(model.getValueAt(i, 0).toString());
	  	            textnomEtape.setText(model.getValueAt(i, 1).toString());
	  	            textdescEtape.setText(model.getValueAt(i, 2).toString());
	  	            textrappEtape.setText(model.getValueAt(i, 3).toString());
	  	            textempEtape.setText(model.getValueAt(i, 4).toString());
	  	            textpsEtape.setText(model.getValueAt(i, 5).toString());

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
	  	                   model.setValueAt(textidEtape.getText(), i, 0);
	  	                   model.setValueAt(textnomEtape.getText(), i, 1);
	  	                   model.setValueAt(textdescEtape.getText(), i, 2);
	  	                   model.setValueAt(textrappEtape.getText(), i, 3);
	  	                   model.setValueAt(textempEtape.getText(), i, 4);
	  	                   model.setValueAt(textpsEtape.getText(), i, 5);
	  	                    

	  	                    int x = Integer.parseInt(textidEtape.getText());
	  	                    String x1 = textnomEtape.getText();
	  		                String x2 = textdescEtape.getText();
	  		                String x3 = textrappEtape.getText();
	  		                int x4 = Integer.parseInt(textempEtape.getText());
	  		                int x5 = Integer.parseInt(textpsEtape.getText());

	  		                
	  	                    Etape etape = new Etape(x,x1,x2,x3,x4,x5);
	  		    	        daoetape.updateEtape(etape);
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

	  	                    int x = Integer.parseInt(textidEtape.getText());
	  	                    String x1 = textnomEtape.getText();
	  		                String x2 = textdescEtape.getText();
	  		                String x3 = textrappEtape.getText();
	  		                int x4 = Integer.parseInt((String)JCOMB.getSelectedItem());
	  		                int x5 = Integer.parseInt(textpsEtape.getText());
	  		                
	  	                    Etape etape = new Etape(x,x1,x2,x3,x4,x5);
	  		    	        daoetape.affecterEtape(etape);
	  		    	        textempEtape.setText((String)JCOMB.getSelectedItem());
	  		    	        
		  	                model.setValueAt(textidEtape.getText(), i, 0);
		  	                model.setValueAt(textnomEtape.getText(), i, 1);
		  	                model.setValueAt(textdescEtape.getText(), i, 2);
		  	                model.setValueAt(textrappEtape.getText(), i, 3);
		  	                model.setValueAt(textempEtape.getText(), i, 4);
		  	                model.setValueAt(textpsEtape.getText(), i, 5);
	  		    	        
	  	                }
	  	                else{
	  	                    System.out.println("Affectation Error");
	  	                }
	  	            	
	  	            }
	  	        });
	  	        
	  	        
		        btnO.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		             
		            	int searchid= Integer.parseInt(textsearchEmp.getText());

		    			int id = daoetape.getEtape(searchid).getId_etape();
		    			String nom_etape = daoetape.getEtape(searchid).getNom_etape();
		    			String description = daoetape.getEtape(searchid).getDescription_etape();
		    			String rapport = daoetape.getEtape(searchid).getRapport_etape();
		    			int employe_etape = daoetape.getEtape(searchid).getEmploye_etape();
		    			int processus_etape = daoetape.getEtape(searchid).getProcessus_etape();
		    			 Object[] dt = {id, nom_etape, description, rapport, employe_etape, processus_etape};
		    			 model.setRowCount(0);
		    			 model.addRow(dt);
		    			}
		        });
		        
		        btnX.addActionListener(new ActionListener(){

		            @Override
		            public void actionPerformed(ActionEvent e) {
		    			 model.removeRow(0);
			    			for (int i=0;i<daoetape.listEtapes().size();i++)
			    			{
			    			int id = daoetape.listEtapes().get(i).getId_etape();
			    			String nom_etape = daoetape.listEtapes().get(i).getNom_etape();
			    			String description = daoetape.listEtapes().get(i).getDescription_etape();
			    			String rapport = daoetape.listEtapes().get(i).getRapport_etape();
			    			int employe_etape = daoetape.listEtapes().get(i).getEmploye_etape();
			    			int processus_etape = daoetape.listEtapes().get(i).getProcessus_etape();
			    			 Object[] data = {id, nom_etape, description, rapport, employe_etape, processus_etape};
			    			 model.addRow(data);
			    			}
		    			}
		        });
		        
	  	        
	  	        frame.setSize(900,400);
	  	        frame.setLocationRelativeTo(null);
	  	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	        frame.setVisible(true);
	  	        frame.setTitle("Etape Manager");
	  	        
	  	    }
	  	    


}