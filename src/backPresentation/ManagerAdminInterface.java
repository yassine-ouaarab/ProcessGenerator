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

import backMetier.Administrateur;
import backMetier.Employe;
import backMetier.Etat;
import backPersistance.DaoAdministrateur;
import backPersistance.DaoEmploye;

	public class ManagerAdminInterface{

		
		static String etatemparchv;
		
        
        // create JFrame and JTable
        static JFrame frame = new JFrame();
        static JTable table = new JTable(); 
     
        static DaoAdministrateur daoadmin = new DaoAdministrateur();
    	
    	static DefaultTableModel model = new DefaultTableModel();
		
			
	    public static void main(String[] args){

	        // create a table model and set a Column Identifiers to this model 
	        Object[] columns = {"Id Admin","Nom Admin","Prenom Admin","Password Admin","Mail Admin","Tel Admin"};

	        model.setColumnIdentifiers(columns);
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        table.setRowHeight(30);
	        

	        /////////////////////table.setDefaultRenderer(Object.class, new MyTableCellRender());
	        
	        // create JLabels
	    	JLabel JL1 = new JLabel("Id Admin :");
	    	JLabel JL2 = new JLabel("Nom Admin :");
	    	JLabel JL3 = new JLabel("Prenom Admin :");
	    	JLabel JL4 = new JLabel("Password Admin :");
	    	JLabel JL5 = new JLabel("Mail Admin :");
	    	JLabel JL6 = new JLabel("Tel Admin :");
	        
	        // create JTextFields
	        JTextField textidEmp = new JTextField();
	        JTextField textnomEmp = new JTextField();
	        JTextField textprenomEmp = new JTextField();
	        JTextField textpasswordEmp = new JTextField();
	        JTextField textmailEmp = new JTextField();
	        JTextField texttelEmp = new JTextField();
	        JTextField textsearchEmp = new JTextField("Search by ID Admin");
	        // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");
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
	        frame.add(btnO);
	        frame.add(btnX);
	        
	        //Affichage de tableau :
	        
			for (int i=0;i<daoadmin.listAdmins().size();i++)
			{
			int id = daoadmin.listAdmins().get(i).getId_admin();
			String nom = daoadmin.listAdmins().get(i).getNom_admin();
			String prenom = daoadmin.listAdmins().get(i).getPrenom_admin();
			String password = daoadmin.listAdmins().get(i).getPassword_admin();
			String mail = daoadmin.listAdmins().get(i).getMail_admin();
			String tel = daoadmin.listAdmins().get(i).getTel_admin();
			 Object[] data = {id, nom, prenom, password, mail, tel};
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
	    	        Administrateur admin = new Administrateur(x,row[1],row[2],row[3],row[4],row[5]);
	    	        daoadmin.addAdmin(admin);    
	    	        
	    			 model.setRowCount(0);
	    	        
	    			for (int i=0;i<daoadmin.listAdmins().size();i++)
	    			{
	    			int id = daoadmin.listAdmins().get(i).getId_admin();
	    			String nom = daoadmin.listAdmins().get(i).getNom_admin();
	    			String prenom = daoadmin.listAdmins().get(i).getPrenom_admin();
	    			String password = daoadmin.listAdmins().get(i).getPassword_admin();
	    			String mail = daoadmin.listAdmins().get(i).getMail_admin();
	    			String tel = daoadmin.listAdmins().get(i).getTel_admin();
	    			 Object[] data = {id, nom, prenom, password, mail, tel};
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
	                    Administrateur admin = new Administrateur(x);
		    	        daoadmin.deleteAdmin(admin);
	                    
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
	            

	            	textidEmp.setText(model.getValueAt(i, 0).toString());
			        textnomEmp.setText(model.getValueAt(i, 1).toString());
		            textprenomEmp.setText(model.getValueAt(i, 2).toString());
		            textpasswordEmp.setText(model.getValueAt(i, 3).toString());
		            textmailEmp.setText(model.getValueAt(i, 4).toString());
		            texttelEmp.setText(model.getValueAt(i, 5).toString());
		       
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
		                
	                    Administrateur admin = new Administrateur(x,x1,x2,x3,x4,x5);
	                    
	                    daoadmin.updateAdmin(admin);
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

	    			int id = daoadmin.getAdmin(searchid).getId_admin();
	    			String nom = daoadmin.getAdmin(searchid).getNom_admin();
	    			String prenom = daoadmin.getAdmin(searchid).getPrenom_admin();
	    			String password = daoadmin.getAdmin(searchid).getPassword_admin();
	    			String mail = daoadmin.getAdmin(searchid).getMail_admin();
	    			String tel = daoadmin.getAdmin(searchid).getTel_admin();
	    			 Object[] dt = {id, nom, prenom, password, mail, tel};
	    			 model.setRowCount(0);
	    			 model.addRow(dt);
	    			}
	        });
	        
	        btnX.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	    			 model.removeRow(0);
		    			for (int i=0;i<daoadmin.listAdmins().size();i++)
		    			{
		    			int id = daoadmin.listAdmins().get(i).getId_admin();
		    			String nom = daoadmin.listAdmins().get(i).getNom_admin();
		    			String prenom = daoadmin.listAdmins().get(i).getPrenom_admin();
		    			String password = daoadmin.listAdmins().get(i).getPassword_admin();
		    			String mail = daoadmin.listAdmins().get(i).getMail_admin();
		    			String tel = daoadmin.listAdmins().get(i).getTel_admin();
		    			 Object[] data = {id, nom, prenom, password, mail, tel};
		    			 model.addRow(data);
		    			}
	    			}
	        });
	        frame.setSize(900,400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setTitle("Admin Manager");
	        
	    }


}
