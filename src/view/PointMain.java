package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.CardOutput;
import model.User;

public class PointMain extends JFrame{ // ������ ������ JFrame�� ������ ��� �޾ƾ���! // �̺�Ʈ�����ʸ� ������ ActionListener�� �޾ƾ���
   //PointManager pm = new PointManager();                           // ����� ����� ����Ʈ ���������� ���� �� ���� �� �ݾ� ���� �����ӵ� ���� ����
   //public User loginedUser;
   //Pointcard_bt pcard_bt = new Pointcard_bt();
   public JPanel background;
   public ImageIcon mainIcon;
   public JScrollPane scroll;

   public JFrame frame1 = new JFrame("����Ʈ ���� �޴��Դϴ�.");                     // ����
   JLabel label = new JLabel("( " + User.getLoginedUser().getUserName() + " ) ���� ���� ����Ʈ�� " + User.getLoginedUser().getPoint() + " �� �Դϴ�.");   
   public static JLabel card_btNum1;              
   public static JLabel card_btNum2;
   public static JLabel card_btNum3;
   public static JLabel card_btNum4;
   public static JButton cardButton;
   public JButton card_bt;
   public JButton pay_bt;
   public JButton back_bt;
   public JLabel label_1;
   public JLabel label_2;
   public JLabel label_3;
  
   //Pointcard_bt pc = new Pointcard_bt();
   public PointMain() {
      mainIcon = new ImageIcon("image/pointMain.png");
      background = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(mainIcon.getImage(), 0, 0, null);
            setOpaque(false);  															// �����ϰ�
            super.paintComponent(g);
         }
      };
      scroll = new JScrollPane(background);
      setContentPane(scroll);

      background.setLayout(null);  
      
      label.setFont(new Font("Serif", Font.TYPE1_FONT, 17));
      label.setForeground(Color.BLACK);
      label.setFont(new Font("���� ���", Font.BOLD, 16));
      label.setBounds(149, 345, 360, 57);                      
      background.add(label);   
      
      cardButton = new JButton("");   
      cardButton.setBounds( 220, 135, 150, 150);

      //if(User.getLoginedUser().)
      
      if(User.getLoginedUser().getCardNumber().equals("null")) {
    	  cardButton.setIcon(new ImageIcon("image/card/card0.png")); 						// ��ư�� �������� ����
          cardButton.setSelectedIcon(new ImageIcon("image/card/card0.png")); 				// ���õ� ��ư�� ǥ���� �������� ����
          cardButton.setPressedIcon(new ImageIcon("image/card/card0.png")); 				// ��ư�� ���������� ǥ���� �������� ����
          cardButton.setBorderPainted(false); 												// ��ư�� �ܰ���(�׵θ�)�� �����ش�.
          cardButton.setContentAreaFilled(false); 											// ��ư�� ���뿵�� ä��� ����
          cardButton.setFocusPainted(false); 												// ��ư�� ���õǾ����� ����� �׵θ� ������
          cardButton.setOpaque(false); 														// ��� ���� �ȼ��� ä���� �ʴ´�.
          background.add(cardButton);
    	  card_btNum1 = new JLabel("ī�带 ������ּ���.");
          card_btNum1.setBounds(210, 310, 200, 20);
          card_btNum1.setFont(new Font("���� ���", Font.BOLD, 18));
          card_btNum1.setForeground(new Color(255, 153, 0));
          background.add(card_btNum1);
          //card_btNum2 = new JLabel("****");
          //card_btNum2.setBounds(225, 310, 40, 20);
          //card_btNum2.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          //card_btNum2.setForeground(Color.BLACK);
          //background.add(card_btNum2);
      } else {
    	  if(PointCard.radioA == 1) {
              cardButton.setIcon(new ImageIcon("image/card/" + 1 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 1 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 1 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }else if(PointCard.radioA == 2) {
              cardButton.setIcon(new ImageIcon("image/card/" + 2 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 2 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 2 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }else if(PointCard.radioA == 3) {
              cardButton.setIcon(new ImageIcon("image/card/" + 3 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 3 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 3 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }else if(PointCard.radioA == 4) {
              cardButton.setIcon(new ImageIcon("image/card/" + 4 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 4 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 4 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }else if(PointCard.radioA == 5) {
              cardButton.setIcon(new ImageIcon("image/card/" + 5 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 5 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 5 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }else {
              cardButton.setIcon(new ImageIcon("image/card/" + 6 + ".png")); // ��ư�� �������� ����
              cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 6 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
              cardButton.setPressedIcon(new ImageIcon("image/card/" + 6 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
           }
    	  
    	  //cardButton.setIcon(new ImageIcon("image/card/card0.png")); // ��ư�� �������� ����
          //cardButton.setSelectedIcon(new ImageIcon("image/card/card0.png")); // ���õ� ��ư�� ǥ���� �������� ����
          //cardButton.setPressedIcon(new ImageIcon("image/card/card0.png")); // ��ư�� ���������� ǥ���� �������� ����
          cardButton.setBorderPainted(false); // ��ư�� �ܰ���(�׵θ�)�� �����ش�.
          cardButton.setContentAreaFilled(false); // ��ư�� ���뿵�� ä��� ����
          cardButton.setFocusPainted(false); // ��ư�� ���õǾ����� ����� �׵θ� ������
          cardButton.setOpaque(false); // ��� ���� �ȼ��� ä���� �ʴ´�.
          background.add(cardButton); 	  
    	  
    	  card_btNum1 = new JLabel(User.getLoginedUser().getCardNumber().substring(0,4));
          card_btNum1.setBounds(155, 310, 40, 20);
          card_btNum1.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          card_btNum1.setForeground(Color.BLACK);
          background.add(card_btNum1);
          
          card_btNum2 = new JLabel(User.getLoginedUser().getCardNumber().substring(5,9));
          card_btNum2.setBounds(225, 310, 40, 20);
          card_btNum2.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          card_btNum2.setForeground(Color.BLACK);
          background.add(card_btNum2);
          card_btNum3 = new JLabel("****");								// �������� ��� **** �� ��
          card_btNum3.setBounds(295, 310, 40, 20);
          card_btNum3.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          card_btNum3.setForeground(Color.BLACK);
          background.add(card_btNum3);
          
          card_btNum4 = new JLabel("****");
          card_btNum4.setBounds(365, 310, 40, 20);
          card_btNum4.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          card_btNum4.setForeground(Color.BLACK);
          background.add(card_btNum4);
          
          label_1 = new JLabel("-");
          label_1.setBounds(203, 305, 17, 18);
          label_1.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          label_1.setForeground(Color.BLACK);
          background.add(label_1);
          
          label_2 = new JLabel("-");
          label_2.setBounds(275, 305, 17, 18);
          label_2.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          label_2.setForeground(Color.BLACK);
          background.add(label_2);
          
          label_3 = new JLabel("-");
          label_3.setBounds(345, 305, 17, 18);
          label_3.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
          label_3.setForeground(Color.BLACK);
          background.add(label_3);
      } // ū else�� ������ ����
      
      
      //frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      pay_bt = new JButton("");
      pay_bt.setBounds( 5, 570, 203, 76);
      pay_bt.setIcon(new ImageIcon("image/pay_bt.png"));
      pay_bt.setSelectedIcon(new ImageIcon("image/pay_bt.png"));
      pay_bt.setPressedIcon(new ImageIcon("image/pay_bt_Clicked.png"));
      pay_bt.setBorderPainted(false);
      pay_bt.setContentAreaFilled(false);
      pay_bt.setFocusPainted(false);
      pay_bt.setOpaque(false);
      background.add(pay_bt);
      pay_bt.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
//                if(card_btNum1.getText() == "****" && card_btNum2.getText() == "****" && card_btNum3.getText() == "****" && card_btNum4.getText() == "****") {
//                   JOptionPane.showMessageDialog(null, "ī���� �� �����ϼ���.");
//                 }else {
//                   
//            setVisible(false); 
//            new PointManager().PointManagerLayout();
//                 }
             if(User.getLoginedUser().getCardNumber().equals("null")) {
            	 JOptionPane.showMessageDialog(null, "ī���� �� �����ϼ���.");
             }else {        
            	 setVisible(false); 
            	 new PointManager().PointManagerLayout();
             }
         }
      });
      card_bt = new JButton("");
      card_bt.setBounds( 190, 570, 203, 76);
      card_bt.setIcon(new ImageIcon("image/card_bt.png"));
      card_bt.setSelectedIcon(new ImageIcon("image/card_bt.png"));
      card_bt.setPressedIcon(new ImageIcon("image/card_bt_Clicked.png"));
      card_bt.setBorderPainted(false);
      card_bt.setContentAreaFilled(false);
      card_bt.setFocusPainted(false);
      card_bt.setOpaque(false);
      background.add(card_bt);
      card_bt.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            setVisible(false); 
            new PointCard().PointCardLayout();  
         }
      });
      back_bt = new JButton("");
      back_bt.setBounds( 375, 570, 203, 76);
      back_bt.setIcon(new ImageIcon("image/back_bt.png"));
      back_bt.setSelectedIcon(new ImageIcon("image/back_bt.png"));
      back_bt.setPressedIcon(new ImageIcon("image/back_bt_Clicked.png"));
      back_bt.setBorderPainted(false);
      back_bt.setContentAreaFilled(false);
      back_bt.setFocusPainted(false);
      back_bt.setOpaque(false);
      background.add(back_bt);
      back_bt.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e) {
            setVisible(false); 
           //new MainFrame().MainFrameLayOut();
         }
      });
   }
   public void PointMainLayout() {
      PointMain pointmain = new PointMain();
      //pointmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pointmain.setSize(600, 700);
      pointmain.setVisible(true);
      pointmain.setLocationRelativeTo(null);
      pointmain.setResizable(false);
      pointmain.getContentPane().setLayout(null);
   }
}
