import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogIn extends BaseOfPages{
	private JTextField textField_username;
	private JTextField textField_pass;
	private ArrayList<User> users=new ArrayList<User>();
	public LogIn() {
		super();
		load_users();
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setBounds(76, 70, 89, 29);
		image_label.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(76, 124, 89, 29);
		image_label.add(lblPassword);
		
		textField_username = new JTextField("");
		textField_username.setBounds(175, 76, 151, 20);
		image_label.add(textField_username);
		
		textField_pass = new JTextField("");
		textField_pass.setBounds(175, 130, 148, 20);
		image_label.add(textField_pass);
		
		JButton clrUser = new JButton("clear");
		clrUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_username.setText(null);
			}
		});
		clrUser.setBounds(346, 75, 67, 23);
		image_label.add(clrUser);
		
		JButton clrPass = new JButton("clear");
		clrPass.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_pass.setText("");
			}
		});
		clrPass.setBounds(346, 129, 67, 23);
		image_label.add(clrPass);
		
		JButton log_btn = new JButton("Submit & Login");
		log_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		log_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName=textField_username.getText();
				String passWord=textField_pass.getText();
				int  found=0;
				if(userName.equals("") || passWord.equals("")) {
					JOptionPane.showMessageDialog(frame, "Fields should not be empty");
				}
				else {
				for(User user:users) {
					if(userName.equals(user.getUsername())) {
						if(passWord.equals(user.getPassword())) {
							JOptionPane.showMessageDialog(frame, "Welcome "+user.getName()+" "+user.getFamily());
							found=1;
						}
					}
				}
				if(found==0) {
					JOptionPane.showMessageDialog(frame, "User not found!");
				}
				else {
					frame.dispose();
					Page2 p=new Page2();
				}
			}
			}
		});
		log_btn.setBounds(76, 174, 159, 29);
		image_label.add(log_btn);
		
		JButton sign_btn = new JButton("Sign in");
		sign_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SignInPage sign=new SignInPage(users);
			}
		});
		sign_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sign_btn.setBounds(76, 225, 159, 29);
		image_label.add(sign_btn);
		
		JLabel exp_lbl = new JLabel("(If you have not sign in yet sign in now )");
		exp_lbl.setBounds(245, 234, 252, 14);
		image_label.add(exp_lbl);
		frame.setVisible(true);
	}
	public void load_users() {
		String name;
		String family;
		String username;
		String password;
		String s="";
		try {
			FileInputStream fi = new FileInputStream("login.txt");
			InputStreamReader is = new InputStreamReader(fi, "UTF-8");
			BufferedReader bf = new BufferedReader(is);
			while((s=bf.readLine())!=null) {
				name=s;
				family=bf.readLine();
				username=bf.readLine();
				password=bf.readLine();
				User user=new User(name, family, username, password);
				users.add(user);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
