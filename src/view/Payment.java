package view;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import controller.LoginController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;

public class Payment extends SideMenuSelect{




	public Payment() {
		
	}
	public void paymentSelectLayOut() {    

		JFrame f = new JFrame();        
		f.getContentPane().setBackground(Color.WHITE);
		f.setVisible(true);             
		f.setSize(450,250);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.getContentPane().setLayout( null );


		JLabel TotalName = new JLabel("Total:");
		TotalName.setForeground (new Color(255, 153, 0));
		TotalName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		TotalName.setBounds(100, 40, 150, 50);
		f.getContentPane().add(TotalName); 
		JLabel TotalPrice = new JLabel(Integer.toString(totalSum) + "원");
		TotalPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		TotalPrice.setBounds(220, 40, 150, 50);
		f.getContentPane().add(TotalPrice); 

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




		check_bt.addActionListener(new ActionListener(){ //로그인버튼
			// 로그인 성공할 경우 MainFrame으로 이동
			public void actionPerformed(ActionEvent e){
				   f.setVisible(false); 
	               new DiscountPayment().discountPaymentLayOut();
	               
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
		cancel_bt.setBounds( 230, 130, 203, 76);
		f.getContentPane().add(cancel_bt);   
		f.getContentPane().setLayout( null );


		cancel_bt.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){            
				Object obj = e.getSource();
				if((JButton)obj == cancel_bt) 
				{ 

					f.setVisible(false);
					
				}
			}


		});











	} 
}