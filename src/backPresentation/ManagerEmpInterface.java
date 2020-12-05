package backPresentation;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.StyleConstants.ColorConstants;

import backMetier.Employe;
import backMetier.Etat;
import backPersistance.DaoEmploye;

	public class ManagerEmpInterface{

		
		static String etatemparchv;
		
        
        // create JFrame and JTable
        static JFrame frame = new JFrame();
        static JTable table = new JTable(); 
     
        static DaoEmploye daoemploye = new DaoEmploye();
    	
    	static DefaultTableModel model = new DefaultTableModel() {
        	@Override
			public boolean isCellEditable(int row, int column){
            	for(int i=0;i<=daoemploye.listEmployes().size();i++)
		        	{	
            			if(model.getValueAt(i, 6).toString().equals("ARCHIVE"))
		        		{
		        			for(int j=0;j<=6;j++)
		                	{if(row == i && column == j) 
		                	return false;}
		                }
            			if(model.getValueAt(i, 6).toString().equals("ARCHIVE")==false)
		        		{
		        			for(int j=0;j<=6;j++)
		                	{if(row == i && column == j) 
		                	return true;}
		                }
		        	}
                return true;
			  }
			};
		
			
	    public static void main(String[] args){

	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"Id Employe","Nom Employe","Prenom Employe","Password Employe","Mail Employe","Tel Employe","Etat Employe"};

	        model.setColumnIdentifiers(columns);
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        table.setRowHeight(30);
	        

	        /////////////////////table.setDefaultRenderer(Object.class, new MyTableCellRender());
	        
	        // create JLabels
	    	JLabel JL1 = new JLabel("Id Emp :");
	    	JLabel JL2 = new JLabel("Nom Emp :");
	    	JLabel JL3 = new JLabel("Prenom Emp :");
	    	JLabel JL4 = new JLabel("Password Emp :");
	    	JLabel JL5 = new JLabel("Mail Emp :");
	    	JLabel JL6 = new JLabel("Tel Emp :");
	        
	        // create JTextFields
	        JTextField textidEmp = new JTextField();
	        JTextField textnomEmp = new JTextField();
	        JTextField textprenomEmp = new JTextField();
	        JTextField textpasswordEmp = new JTextField();
	        JTextField textmailEmp = new JTextField();
	        JTextField texttelEmp = new JTextField();
	        JTextField textsearchEmp = new JTextField("Search by ID Employe");
	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        JButton btnArchive = new JButton("Archive");
	        JButton btnActive = new JButton("Active");
	        JButton btnO = new JButton("O");     
	        JButton btnX = new JButton("X");     

	        JL1.setBounds(20, 220, 100, 25);
	        JL2.setBounds(20, 270, 100, 25);
	        JL3.setBounds(20, 320, 100, 25);
	        JL4.setBounds(230, 220, 100, 25);
	        JL5.setBounds(230, 270, 100, 25);
	        JL6.setBounds(230, 320, 100, 25);
	        
	        textidEmp.setBounds(110, 220, 100, 25);
	        textnomEmp.setBounds(110, 270, 100, 25);
	        textprenomEmp.setBounds(110, 320, 100, 25);
	        textpasswordEmp.setBounds(330, 220, 100, 25);
	        textmailEmp.setBounds(330, 270, 100, 25);
	        texttelEmp.setBounds(330, 320, 100, 25);
	        
	        textsearchEmp.setBounds(499, 290, 240, 26);
	        btnO.setBounds(744, 290, 45, 25);
	        btnX.setBounds(794, 290, 45, 25);
	        
	        btnAdd.setBounds(460, 240, 100, 25);
	        btnUpdate.setBounds(560, 240, 100, 25);
	        btnDelete.setBounds(660, 240, 100, 25);
	        btnArchive.setBounds(760, 240, 100, 25);
	        btnActive.setBounds(760, 210, 100, 25);
	        
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
	        frame.add(textidEmp);
	        frame.add(textnomEmp);
	        frame.add(textprenomEmp);
	        frame.add(textpasswordEmp);
	        frame.add(textmailEmp);
	        frame.add(texttelEmp);
	        frame.add(textsearchEmp);
	    
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        frame.add(btnArchive);
	        frame.add(btnActive);
	        frame.add(btnO);
	        frame.add(btnX);
	        
	        //Affichage de tableau :
	        
			for (int i=0;i<daoemploye.listEmployes().size();i++)
			{
			int id = daoemploye.listEmployes().get(i).getId_employe();
			String nom = daoemploye.listEmployes().get(i).getNom_employe();
			String prenom = daoemploye.listEmployes().get(i).getPrenom_employe();
			String password = daoemploye.listEmployes().get(i).getPassword_employe();
			String mail = daoemploye.listEmployes().get(i).getMail_employe();
			String tel = daoemploye.listEmployes().get(i).getTel_employe();
			String etat = daoemploye.listEmployes().get(i).getEtat_employe().name();
			 Object[] data = {id, nom, prenom, password, mail, tel, etat};
			 model.addRow(data);
			}
			
			
			//blabla
			

	        // create an array of objects to set the row data
	        String[] row = new String[7];
	        
	        
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textidEmp.getText();
	                row[1] = textnomEmp.getText();
	                row[2] = textprenomEmp.getText();
	                row[3] = textpasswordEmp.getText();
	                row[4] = textmailEmp.getText();
	                row[5] = texttelEmp.getText();
	                
	                // add row to the model
	                model.addRow(row); 
	                int x = Integer.parseInt(row[0]);
	    	        Employe employe = new Employe(x,row[1],row[2],row[3],row[4],row[5],Etat.ACTIVE);
	    	        daoemploye.addEmploye(employe);    
	    	        
	    			 model.setRowCount(0);
	    	        
	    			for (int i=0;i<daoemploye.listEmployes().size();i++)
	    			{
	    			int id = daoemploye.listEmployes().get(i).getId_employe();
	    			String nom = daoemploye.listEmployes().get(i).getNom_employe();
	    			String prenom = daoemploye.listEmployes().get(i).getPrenom_employe();
	    			String password = daoemploye.listEmployes().get(i).getPassword_employe();
	    			String mail = daoemploye.listEmployes().get(i).getMail_employe();
	    			String tel = daoemploye.listEmployes().get(i).getTel_employe();
	    			String etat = daoemploye.listEmployes().get(i).getEtat_employe().name();
	    			 Object[] data = {id, nom, prenom, password, mail, tel, etat};
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
	                    Employe employe = new Employe(x);
		    	        daoemploye.deleteEmploye(employe);
	                    
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
	            
	            if(model.getValueAt(i, 6).toString().equals("ARCHIVE"))
		        {

	            	btnAdd.setEnabled(false);
	            	btnUpdate.setEnabled(false);
	            	btnDelete.setEnabled(false);
	            	btnArchive.setEnabled(false);
	            	btnActive.setEnabled(true);
	            	
	            	textidEmp.setText(model.getValueAt(i, 0).toString());
			        textnomEmp.setText(model.getValueAt(i, 1).toString());
		            textprenomEmp.setText(model.getValueAt(i, 2).toString());
		            textpasswordEmp.setText(model.getValueAt(i, 3).toString());
		            textmailEmp.setText(model.getValueAt(i, 4).toString());
		            texttelEmp.setText(model.getValueAt(i, 5).toString());
		        }
		        
	            if(model.getValueAt(i, 6).toString().equals("ARCHIVE")==false)
		        {
	            	
	            	btnAdd.setEnabled(true);
	            	btnUpdate.setEnabled(true);
	            	btnDelete.setEnabled(true);
	            	btnArchive.setEnabled(true);
	            	btnActive.setEnabled(false);
	            	
	            	textidEmp.setText(model.getValueAt(i, 0).toString());
			        textnomEmp.setText(model.getValueAt(i, 1).toString());
		            textprenomEmp.setText(model.getValueAt(i, 2).toString());
		            textpasswordEmp.setText(model.getValueAt(i, 3).toString());
		            textmailEmp.setText(model.getValueAt(i, 4).toString());
		            texttelEmp.setText(model.getValueAt(i, 5).toString());
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
	                   model.setValueAt(textidEmp.getText(), i, 0);
	                   model.setValueAt(textnomEmp.getText(), i, 1);
	                   model.setValueAt(textprenomEmp.getText(), i, 2);
	                   model.setValueAt(textpasswordEmp.getText(), i, 3);
	                   model.setValueAt(textmailEmp.getText(), i, 4);
	                   model.setValueAt(texttelEmp.getText(), i, 5);
	                    

	                    int x = Integer.parseInt(textidEmp.getText());
	                    String x1 = textnomEmp.getText();
		                String x2 = textprenomEmp.getText();
		                String x3 = textpasswordEmp.getText();
		                String x4 = textmailEmp.getText();
		                String x5 = texttelEmp.getText();
		                String x6 = model.getValueAt(i, 6).toString();
		                
	                    Employe employe = new Employe(x,x1,x2,x3,x4,x5);
	                    
	                    if(x6.equals("ACTIVE"))
						{
	                    	employe.setEtat_employe(Etat.ACTIVE);
						}
						else if(x6.equals("ARCHIVE"))
						{
							employe.setEtat_employe(Etat.ARCHIVE);	
						}
	                    
		    	        daoemploye.updateEmploye(employe);
	                }
	                else{
	                    System.out.println("Update Error");
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
		                   model.setValueAt(textidEmp.getText(), i, 0);
		                   model.setValueAt(textnomEmp.getText(), i, 1);
		                   model.setValueAt(textprenomEmp.getText(), i, 2);
		                   model.setValueAt(textpasswordEmp.getText(), i, 3);
		                   model.setValueAt(textmailEmp.getText(), i, 4);
		                   model.setValueAt(texttelEmp.getText(), i, 5);
		                    

		                    int x = Integer.parseInt(textidEmp.getText());
		                    String x1 = textnomEmp.getText();
			                String x2 = textprenomEmp.getText();
			                String x3 = textpasswordEmp.getText();
			                String x4 = textmailEmp.getText();
			                String x5 = texttelEmp.getText();
			                
		                    Employe employe = new Employe(x,x1,x2,x3,x4,x5,Etat.ARCHIVE);
			    	        daoemploye.updateEmploye(employe);
			    	        
			    	        
			    	        //clean jtable
			    	        model.setRowCount(0);
				    		
			    	        for (int i1=0;i1<daoemploye.listEmployes().size();i1++)
				    			{
				    			int id = daoemploye.listEmployes().get(i1).getId_employe();
				    			String nom = daoemploye.listEmployes().get(i1).getNom_employe();
				    			String prenom = daoemploye.listEmployes().get(i1).getPrenom_employe();
				    			String password = daoemploye.listEmployes().get(i1).getPassword_employe();
				    			String mail = daoemploye.listEmployes().get(i1).getMail_employe();
				    			String tel = daoemploye.listEmployes().get(i1).getTel_employe();
				    			String etat = daoemploye.listEmployes().get(i1).getEtat_employe().name();
				    			 Object[] data = {id, nom, prenom, password, mail, tel, etat};
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
		                   model.setValueAt(textidEmp.getText(), i, 0);
		                   model.setValueAt(textnomEmp.getText(), i, 1);
		                   model.setValueAt(textprenomEmp.getText(), i, 2);
		                   model.setValueAt(textpasswordEmp.getText(), i, 3);
		                   model.setValueAt(textmailEmp.getText(), i, 4);
		                   model.setValueAt(texttelEmp.getText(), i, 5);
		                    

		                    int x = Integer.parseInt(textidEmp.getText());
		                    String x1 = textnomEmp.getText();
			                String x2 = textprenomEmp.getText();
			                String x3 = textpasswordEmp.getText();
			                String x4 = textmailEmp.getText();
			                String x5 = texttelEmp.getText();
			                
		                    Employe employe = new Employe(x,x1,x2,x3,x4,x5,Etat.ACTIVE);
			    	        daoemploye.updateEmploye(employe);
			    	        
			    	        
			    	        //clean jtable
			    	        model.setRowCount(0);
				    		
			    	        for (int i1=0;i1<daoemploye.listEmployes().size();i1++)
				    			{
				    			int id = daoemploye.listEmployes().get(i1).getId_employe();
				    			String nom = daoemploye.listEmployes().get(i1).getNom_employe();
				    			String prenom = daoemploye.listEmployes().get(i1).getPrenom_employe();
				    			String password = daoemploye.listEmployes().get(i1).getPassword_employe();
				    			String mail = daoemploye.listEmployes().get(i1).getMail_employe();
				    			String tel = daoemploye.listEmployes().get(i1).getTel_employe();
				    			String etat = daoemploye.listEmployes().get(i1).getEtat_employe().name();
				    			 Object[] data = {id, nom, prenom, password, mail, tel, etat};
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

	    			int id = daoemploye.getEmploye(searchid).getId_employe();
	    			String nom = daoemploye.getEmploye(searchid).getNom_employe();
	    			String prenom = daoemploye.getEmploye(searchid).getPrenom_employe();
	    			String password = daoemploye.getEmploye(searchid).getPassword_employe();
	    			String mail = daoemploye.getEmploye(searchid).getMail_employe();
	    			String tel = daoemploye.getEmploye(searchid).getTel_employe();
	    			String etat = daoemploye.getEmploye(searchid).getEtat_employe().name();
	    			 Object[] dt = {id, nom, prenom, password, mail, tel, etat};
	    			 model.setRowCount(0);
	    			 model.addRow(dt);
	    			}
	        });
	        
	        btnX.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	    			 model.removeRow(0);
		    			for (int i=0;i<daoemploye.listEmployes().size();i++)
		    			{
		    			int id = daoemploye.listEmployes().get(i).getId_employe();
		    			String nom = daoemploye.listEmployes().get(i).getNom_employe();
		    			String prenom = daoemploye.listEmployes().get(i).getPrenom_employe();
		    			String password = daoemploye.listEmployes().get(i).getPassword_employe();
		    			String mail = daoemploye.listEmployes().get(i).getMail_employe();
		    			String tel = daoemploye.listEmployes().get(i).getTel_employe();
		    			String etat = daoemploye.listEmployes().get(i).getEtat_employe().name();
		    			 Object[] data = {id, nom, prenom, password, mail, tel, etat};
		    			 model.addRow(data);
		    			}
	    			}
	        });
	        frame.setSize(900,400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setTitle("Employe Manager");
	        
	    }


}