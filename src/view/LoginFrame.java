package view;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.JoinFrameTemporary;
import controller.LoginController;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

public class LoginFrame extends JFrame{
   


   private JTextField username;
   private JPasswordField password;
   public JPanel background;
   public JScrollPane scroll;

   public LoginFrame() {
      background = new JPanel(); 
       background.setBackground(Color.WHITE);
       
       scroll = new JScrollPane(background);
      setContentPane(scroll);
      background.setLayout(null);
      
       JLabel lblNewLabel = new JLabel("ID :");
         lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));
         lblNewLabel.setBounds(303, 283, 37, 37);
         background.add(lblNewLabel); 
        
         JLabel lblPassword = new JLabel("PW :");
         lblPassword.setFont(new Font("Arial Narrow", Font.BOLD, 20));
         lblPassword.setBounds(303, 330, 50, 37);
        
         background.add(lblPassword);
         
         JButton b1 = new JButton(""); //
         b1.setIcon(new ImageIcon("image/login_bt.png"));
         b1.setSelectedIcon(new ImageIcon("image/login_bt.png"));
         b1.setPressedIcon(new ImageIcon("image/login_bt_Clicked.png"));
         b1.setBorderPainted(false);
         b1.setContentAreaFilled(false);
         b1.setFocusPainted(false);
         b1.setOpaque(false);

         background.add(b1);   
         b1.setBounds( 183, 428, 241, 76);
         
         

         
       b1.addActionListener(new ActionListener(){ //로그인버튼
       // 로그인 성공할 경우 MainFrame으로 이동
          public void actionPerformed(ActionEvent e){
             
             LoginController lc = new LoginController();
             
             if(lc.LoginController1(username.getText(),password.getText())) {
            	 setVisible(false);
                 new MainFrame().MainFrameLayOut();

             }else {
                
             }
             
            
             
             
             
          }


       });
       
         JButton b2 = new JButton("");
         b2.setIcon(new ImageIcon("image/sign_bt.png"));
         b2.setSelectedIcon(new ImageIcon("image/sign_bt.png"));
         b2.setPressedIcon(new ImageIcon("image/sign_bt_Clicked.png"));
         b2.setBorderPainted(false);
         b2.setContentAreaFilled(false);
         b2.setFocusPainted(false);
         b2.setOpaque(false);
         background.add(b2);   
         background.setLayout( null );
         b2.setBounds( 487, 428, 203, 76);
         
         
         
         b2.addActionListener(new ActionListener(){ //회원가입  (임시)
                public void actionPerformed(ActionEvent e){
                   
                	
                   new JoinFrameTemporary().main(null);
                   
                   
                   //new MainFrame().MainFrameLayOut();
                  // f.setVisible(false); 
                   
                   
                   
                }


             });
         
         JButton mainImage = new JButton("");
         mainImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
         });
         mainImage.setIcon(new ImageIcon("image/mainImage.png"));
         mainImage.setBounds(286, 27, 296, 262);
         mainImage.setBorderPainted(false);
         mainImage.setContentAreaFilled(false);
         mainImage.setFocusPainted(false);
         mainImage.setOpaque(false);
         background.add(mainImage);
         
         
         
         
         
         username = new JTextField();
         username.setBounds(357, 293, 225, 21);
         background.add(username);
         username.setColumns(10);
         
         password = new JPasswordField();
         password.setBounds(357, 340, 225, 21);
         background.add(password);
      
   }
    public void LoginFrameLayOut() {    
           LoginFrame loginframe = new LoginFrame();        
           //loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           loginframe.setSize(900, 600);
           loginframe.setVisible(true);
           loginframe.setLocationRelativeTo(null);
           loginframe.setResizable(false);
           loginframe.getContentPane().setLayout(null);
                            
       } 
}