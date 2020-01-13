package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.User;

public class MainFrame extends JFrame{     

   public JPanel background;
   public JScrollPane scroll;

   public MainFrame() {
      background = new JPanel(); 
      background.setBackground(Color.WHITE);

      scroll = new JScrollPane(background);
      setContentPane(scroll);
      background.setLayout(null);

      JLabel f2=new JLabel(new ImageIcon("image/BreadSelect.png"));

      JButton b1 = new JButton("");
      b1.setIcon(new ImageIcon("image/bt1.png"));
      b1.setSelectedIcon(new ImageIcon("image/bt1.png"));
      b1.setPressedIcon(new ImageIcon("image/bt1_clicked.png"));
      b1.setBorderPainted(false);
      b1.setContentAreaFilled(false);
      b1.setFocusPainted(false);
      b1.setOpaque(false);
      background.add(b1);   
      background.setLayout( null );
      b1.setBounds( 85, 409, 203, 76);

      b1.addActionListener(new ActionListener(){ 
         // 로그인 성공할 경우 MainFrame으로 이동
         public void actionPerformed(ActionEvent e){
        	setVisible(false); 
            new BreadSelect().breadSelectLayOut();
         }
      });

      JButton b2 = new JButton("");
      b2.setIcon(new ImageIcon("image/bt2.png"));
      b2.setSelectedIcon(new ImageIcon("image/bt2.png"));
      b2.setPressedIcon(new ImageIcon("image/bt2_clicked.png"));

      b2.addActionListener(new ActionListener(){ 
         // 로그인 성공할 경우 MainFrame으로 이동
         public void actionPerformed(ActionEvent e){
            //setVisible(false); 
            new PointMain().PointMainLayout();
         }
      });


      b2.setBorderPainted(false);
      b2.setContentAreaFilled(false);
      b2.setFocusPainted(false);
      b2.setOpaque(false);
      background.add(b2);   
      background.setLayout( null );
      b2.setBounds( 334, 409, 203, 76);

      JButton b3 = new JButton("");
      b3.setIcon(new ImageIcon("image/bt3.png"));
      b3.setSelectedIcon(new ImageIcon("image/bt3.png"));
      b3.setPressedIcon(new ImageIcon("image/bt3_clicked.png"));
      b3.setBorderPainted(false);
      b3.setContentAreaFilled(false);
      b3.setFocusPainted(false);
      b3.setOpaque(false);
      background.add(b3);   
      background.setLayout( null );
      b3.setBounds( 579, 409, 203, 76);

      b3.addActionListener(new ActionListener(){ 
         // 로그인 성공할 경우 MainFrame으로 이동
         public void actionPerformed(ActionEvent e){
            if(User.getLoginedUser()==null) {
            	setVisible(false);
               new LoginFrame().LoginFrameLayOut();
            }else {
               new MyPageTemp().main(null);
            }
         }
      });


      JButton mainImage = new JButton("");      
      mainImage.setIcon(new ImageIcon("image/mainImage.png"));
      mainImage.setBounds(286, 27, 296, 262);
      mainImage.setBorderPainted(false);
      mainImage.setContentAreaFilled(false);
      mainImage.setFocusPainted(false);
      mainImage.setOpaque(false);
      background.add(mainImage);




   }
   public void MainFrameLayOut() {    
      MainFrame mainframe = new MainFrame();        
      //mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainframe.setSize(900, 600);
      mainframe.setVisible(true);
      mainframe.setLocationRelativeTo(null);
      mainframe.setResizable(false);
      mainframe.getContentPane().setLayout(null);

   }
}




