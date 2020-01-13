
package view;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;

public class ChangeName extends JFrame  {





	public ChangeName() {

	}
	public void ChangeNameLayOut() {    

		JFrame f = new JFrame();        
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);             
		f.setSize(450,250);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.getContentPane().setLayout( null );


		JLabel changeName = new JLabel("´Ð³×ÀÓ");
		changeName.setForeground (new Color(255, 153, 0));
		changeName.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		changeName.setBounds(100, 40, 150, 50);
		f.getContentPane().add(changeName); 

		JTextField changeNfield = new JTextField();
		changeNfield.setBounds(220, 40, 150, 50);
		f.getContentPane().add(changeNfield);
		changeNfield.setColumns(10);



		//      JLabel TotalPrice = new JLabel(Integer.toString(totalSum) + "¿ø");
		//      TotalPrice.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		//      TotalPrice.setBounds(220, 40, 150, 50);
		//      f.getContentPane().add(TotalPrice); 

		JButton check_bt = new JButton(""); //
		check_bt.setIcon(new ImageIcon("image/select_bt1.png"));
		check_bt.setSelectedIcon(new ImageIcon("image/select_bt1.png"));
		check_bt.setPressedIcon(new ImageIcon("image/select_bt1_Clicked.png"));
		check_bt.setBorderPainted(false);
		check_bt.setContentAreaFilled(false);
		check_bt.setFocusPainted(false);
		check_bt.setOpaque(false);

		f.getContentPane().add(check_bt);   
		check_bt.setBounds( 5, 130, 241, 76);




		check_bt.addActionListener(new ActionListener(){ //È®ÀÎ ´©¸£¸é ¸¶ÀÌÆäÀÌÁö¸¦ ²°´Ù°¡ ÄÑ±â

			public void actionPerformed(ActionEvent e){
				if(!(changeNfield.getText().isEmpty())) {
					
				
				String result = changeNfield.getText();
				User lu = User.getLoginedUser(); 
				lu.setUserName(result);
				User.setLoginedUser(lu);
				
				
				
				new MyPageTemp().main(null);
				f.dispose();
				}else {
					new MyPageTemp().main(null);
					f.dispose();
				
				
				
				
			}

			}
		});
		

		JButton cancel_bt = new JButton("");
		cancel_bt.setIcon(new ImageIcon("image/select_bt2.png"));
		cancel_bt.setSelectedIcon(new ImageIcon("image/select_bt2.png"));
		cancel_bt.setPressedIcon(new ImageIcon("image/select_bt2_Clicked.png"));
		cancel_bt.setBorderPainted(false);
		cancel_bt.setContentAreaFilled(false);
		cancel_bt.setFocusPainted(false);
		cancel_bt.setOpaque(false);
		f.getContentPane().add(cancel_bt);   
		f.getContentPane().setLayout( null );
		cancel_bt.setBounds( 230, 130, 203, 76);



		cancel_bt.addActionListener(new ActionListener(){ //Äµ½½
			public void actionPerformed(ActionEvent e){  
				
				new MyPageTemp().main(null);
				f.dispose();
			}


		});











	} 
}