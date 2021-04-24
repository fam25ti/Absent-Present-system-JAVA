import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignInPage extends BaseOfPages{
	private JTextField pass_textfield;
	private JTextField user_textfield;
	private JTextField family_textfield;
	private JTextField name_textfield;

	public SignInPage(ArrayList<User>  users) {
		super();
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(99, 64, 60, 28);
		image_label.add(lblName);
		
		name_textfield = new JTextField();
		name_textfield.setBounds(201, 70, 126, 20);
		image_label.add(name_textfield);
		
		JLabel lblFamily = new JLabel("Family :");
		lblFamily.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFamily.setBounds(99, 137, 48, 19);
		image_label.add(lblFamily);
		
		family_textfield = new JTextField();
		family_textfield.setBounds(201, 136, 126, 20);
		image_label.add(family_textfield);
		
		JLabel lblUsername = new JLabel("User Name :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(99, 200, 88, 19);
		image_label.add(lblUsername);
		
		user_textfield = new JTextField();
		user_textfield.setBounds(201, 199, 126, 20);
		panel.add(user_textfield);
		
		JLabel lblPassWord = new JLabel("PassWord :");
		lblPassWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassWord.setBounds(99, 256, 88, 28);
		image_label.add(lblPassWord);
		
		pass_textfield = new JTextField();
		pass_textfield.setBounds(201, 262, 126, 20);
		image_label.add(pass_textfield);
		
		JButton clr_n = new JButton("clear");
		clr_n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name_textfield.setText("");
			}
		});
		clr_n.setBounds(354, 69, 89, 23);
		image_label.add(clr_n);
		
		JButton clr_f = new JButton("clear");
		clr_f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				family_textfield.setText("");
			}
		});
		clr_f.setBounds(354, 137, 89, 23);
		image_label.add(clr_f);
		
		JButton clr_u = new JButton("clear");
		clr_u.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				user_textfield.setText("");
			}
		});
		clr_u.setBounds(354, 200, 89, 23);
		image_label.add(clr_u);
		
		JButton clr_p = new JButton("clear");
		clr_p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pass_textfield.setText("");
			}
		});
		clr_p.setBounds(354, 261, 89, 23);
		image_label.add(clr_p);
		
		JButton clearAll_btn = new JButton("Clear All");
		clearAll_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name_textfield.setText("");
				family_textfield.setText("");
				user_textfield.setText("");
				pass_textfield.setText("");

			}
		});
		clearAll_btn.setBounds(354, 329, 89, 23);
		image_label.add(clearAll_btn);
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int found =0;//if username is repeated it will be 1
				if(name_textfield.getText().equals("") || family_textfield.getText().equals("")||
						user_textfield.getText().equals("")||pass_textfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Fields can not be empty!");
				}
				else {
					for(User user:users) {
						if (user.getUsername().equals(user_textfield.getText())) {
							found=1;
							JOptionPane.showMessageDialog(frame, "There is user with this username!please choose another username.");
							break;
						}
					}
					if(found==0) {
					
						try {
							BufferedWriter buff=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("login.txt",true)));
							buff.write(name_textfield.getText());
							buff.newLine();
							buff.write(family_textfield.getText());
							buff.newLine();
							buff.write(user_textfield.getText());
							buff.newLine();
							buff.write(pass_textfield.getText());
							buff.newLine();
							buff.close();
						} 
						catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(frame, "You have sign in successfully!");
						frame.dispose();
						Page2 p=new Page2();
					}
				}
			}
		});
		btn_Submit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Submit.setBounds(99, 327, 89, 23);
		image_label.add(btn_Submit);
		frame.setVisible(true);
	}
}
