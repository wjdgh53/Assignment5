package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dictionary.FoodInfo;
import support.Dictionary;
import support.ReadDictionary;

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
public class DictionaryPanel extends JPanel implements ActionListener{
	private JLabel titleLabel;
	private JButton searchButton;
	private JButton addButton;
	private JTextArea descriptionArea;
	private JTextArea nameArea;
	private JTextField entryField;
	
	private JButton mainButton;
	
	private JLabel errorLabel;
	String name;
	String description;
	public DictionaryPanel() {
		System.out.println("hul");
		/*for(int i = 0; i <MainFrame.dict.food.size();i++)
		{
			System.out.println(MainFrame.dict.food.getNext("INORDER"));
		}*/
		try {
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(1000, 800));
			{
				titleLabel = new JLabel();
				this.add(titleLabel);
				titleLabel.setText("Food Dictionary");
				titleLabel.setBounds(396, 20, 271, 90);
				titleLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
			}
			{
				entryField = new JTextField();
				this.add(entryField);
				entryField.setBounds(199, 685, 398, 54);
			}
			{
				searchButton = new JButton();
				this.add(searchButton);
				searchButton.setText("Search");
				searchButton.setBounds(603, 685, 94, 56);
				searchButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				searchButton.addActionListener(this);
			}
			{
				nameArea = new JTextArea();
				this.add(nameArea);
				nameArea.setBounds(85, 137, 334, 418);
			}
			{
				descriptionArea = new JTextArea();
				this.add(descriptionArea);
				descriptionArea.setBounds(513, 137, 335, 418);
			}
			{
				addButton = new JButton();
				this.add(addButton);
				addButton.setText("Add");
				addButton.setBounds(603, 686, 99, 53);
				addButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				addButton.setVisible(false);
				addButton.addActionListener(this);
			}
			{
				errorLabel = new JLabel();
				this.add(errorLabel);
				errorLabel.setBounds(261, 589, 398, 60);
				errorLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,28));
			}
			{
				mainButton = new JButton();
				this.add(mainButton);
				mainButton.setText("Main Page");
				mainButton.setBounds(816, 686, 145, 72);
				mainButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,26));
				mainButton.addActionListener(this);
			}
			{

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Search")){	
			name = entryField.getText();
			FoodInfo fi = new FoodInfo(name);
			System.out.println(name);
			System.out.println(fi);
			System.out.println(MainFrame.dict.food.contains(MainFrame.dict.food.get(fi)));
			System.out.println(MainFrame.dict.food.get(fi));
			System.out.println(MainFrame.dict.food.contains(MainFrame.dict.food.get(fi)));
			if(MainFrame.dict.food.contains(fi))
			{
				nameArea.setText(MainFrame.dict.food.get(fi).getFoodName());
				descriptionArea.setText(MainFrame.dict.food.get(fi).getFoodName());
			}else{
				searchButton.setVisible(false);
				errorLabel.setText("It is not found in Dictionary type description and click add please");
				addButton.setVisible(true);
			}			
		}
		if (event.getActionCommand().equals("Add")){	
			description = entryField.getText();
			FoodInfo fi = new FoodInfo(name,description);
			MainFrame.dict.food.add(fi);
			MainFrame.rd.flist.add(fi);
			MainFrame.dict.food.reset("INORDER");
			MainFrame.rd.writeBackToFile("result.txt");
			nameArea.setText(MainFrame.dict.food.get(fi).getFoodName());
			descriptionArea.setText(MainFrame.dict.food.get(fi).getFoodName());
			errorLabel.setText("Item is added");
			entryField.setText("");
			addButton.setVisible(false);
			searchButton.setVisible(true);
		}
		if(event.getActionCommand().equals("Main Page"))
		{
			MainFrame.frontpanel();
		}
	}

}

