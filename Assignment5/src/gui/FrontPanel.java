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
public class FrontPanel extends JPanel implements ActionListener {
	private JLabel titleLabel;
	private JButton dictButton;
	private JButton editButton;
		public FrontPanel() {
			try {
				this.setLayout(null);
				this.setPreferredSize(new java.awt.Dimension(1000, 800));
				{
					titleLabel = new JLabel();
					this.add(titleLabel);
					titleLabel.setText("Choose option");
					titleLabel.setBounds(379, 12, 253, 56);
					titleLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
				}
				{
					editButton = new JButton();
					this.add(editButton);
					editButton.setText("Edit/Remove");
					editButton.setBounds(198, 360, 250, 109);
					editButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
					editButton.addActionListener(this);
				}
				{
					dictButton = new JButton();
					this.add(dictButton);
					dictButton.setText("Dictionary");
					dictButton.setBounds(555, 360, 250, 109);
					dictButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,36));
					dictButton.addActionListener(this);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public void actionPerformed(ActionEvent event)
		{
			if (event.getActionCommand().equals("Edit/Remove")){	
				MainFrame.editpanel();
			}
			if (event.getActionCommand().equals("Dictionary")){	
				MainFrame.dictionarypanel();
			}
			
		}
	}
