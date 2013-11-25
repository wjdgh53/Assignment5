package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dictionary.FoodInfo;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class EditPanel extends JPanel implements ActionListener{
	private JTextField nameField;
	private JTextField descriptionField;
	private JLabel titleLabel;
	private JButton searchButton;
	private JButton mainButton;
	private JLabel statusLabel;
	private JButton removeButton;
	private JButton editButton;
	String name;
	public EditPanel() {
		try {
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(1000, 800));
			{
				nameField = new JTextField();
				this.add(nameField);
				nameField.setBounds(68, 157, 406, 49);
			}
			{
				descriptionField = new JTextField();
				this.add(descriptionField);
				descriptionField.setBounds(68, 311, 416, 133);
			}
			{
				titleLabel = new JLabel();
				this.add(titleLabel);
				titleLabel.setText("Edit/Remove");
				titleLabel.setBounds(411, 12, 215, 68);
				titleLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
			}
			{
				searchButton = new JButton();
				this.add(searchButton);
				searchButton.setText("Search");
				searchButton.setBounds(494, 157, 94, 49);
				searchButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				searchButton.addActionListener(this);
			}
			{
				editButton = new JButton();
				this.add(editButton);
				editButton.setText("Edit");
				editButton.setBounds(178, 528, 233, 106);
				editButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
				editButton.addActionListener(this);
			}
			{
				removeButton = new JButton();
				this.add(removeButton);
				removeButton.setText("Remove");
				removeButton.setBounds(626, 528, 233, 106);
				removeButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
				removeButton.addActionListener(this);
			}
			{
				statusLabel = new JLabel();
				this.add(statusLabel);
				statusLabel.setBounds(583, 294, 350, 124);
				statusLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,24));
			}
			{
				mainButton = new JButton();
				this.add(mainButton);
				mainButton.setText("Main Page");
				mainButton.setBounds(725, 690, 195, 75);
				mainButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,22));
				mainButton.addActionListener(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("Search"))
		{
			name = nameField.getText();
			FoodInfo fi = new FoodInfo(name);
			if(MainFrame.dict.food.contains(fi)){
				nameField.setText(MainFrame.dict.food.get(fi).getFoodName());
				descriptionField.setText(MainFrame.dict.food.get(fi).getFoodName());
				statusLabel.setText("");
			}else{
				nameField.setText("");
				statusLabel.setText("food is not found in dictionary please type again");
			}
		}
		if (event.getActionCommand().equals("Edit")){	
			FoodInfo fi = new FoodInfo(name);
			
			MainFrame.dict.food.get(fi).setFoodName(nameField.getText());
			MainFrame.dict.food.get(fi).setDescription(descriptionField.getText());
			statusLabel.setText("food information edited");
		}
		if (event.getActionCommand().equals("Remove")){	
			FoodInfo fi = new FoodInfo(name);
			MainFrame.dict.food.remove(fi);
			statusLabel.setText("Removed");
		}
		if(event.getActionCommand().equals("Main Page")){
			MainFrame.frontpanel();
		}
		
	}
}
