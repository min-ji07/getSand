package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.CardOutput;
import controller.JTextFieldLimit;
import model.User;

public class PointCard extends PointMain{
   public JFrame frame3 = new JFrame("ī���� �޴��Դϴ�.");
   public JButton card = new JButton("ī�� ����ϱ�");      
   public JButton[] selectButton;
   public JLabel label_2;
   public JLabel label_3;
   public JLabel label_1;
   public ImageIcon mainIcon;
   public JPanel background;
   public JButton miniCheck_bt;
   public JButton card_bt;
   public static String card1;		// static �����ϱ� �������������ʳ�
   public static String card2;
   public static String card3;
   public static String card4;
   private static int count = 0;
   private static int count1 = 0;
   public static JButton cardButton2;
   
   public JTextField textField_1 = new JTextField(10);
   public JTextField textField_2 = new JTextField(10);
   public JTextField textField_3 = new JTextField(10);
   public JTextField textField_4 = new JTextField(10);
   
   public static String cardNumber = null;
   
   public static JRadioButton radio1;
   public static JRadioButton radio2;
   public static JRadioButton radio3;
   public static JRadioButton radio4;
   public static JRadioButton radio5;
   public static JRadioButton radio6;
   
   public static int radioA;
   public JScrollPane scroll;
   PointMain pointmain = new PointMain();
   public PointCard() {
      mainIcon = new ImageIcon("image/cardMain.png");
      background = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(mainIcon.getImage(), 0, 0, null);
            setOpaque(false);  // �����ϰ�
            super.paintComponent(g);
         }
      };

      scroll = new JScrollPane(background);
      setContentPane(scroll);


      background.setLayout(null);


      
      JLabel label = new JLabel("ī���ȣ�� �Է��ϼ���."); 
      label.setFont(new Font("���� ���", Font.BOLD, 12));
      label.setForeground (new Color(255, 153, 0));
      label.setBounds(214, 440, 200, 32);                     
      background.add(label);                    

      textField_1.setBounds(120, 482, 75, 24);     
      textField_1.setDocument(new JTextFieldLimit(4));
      background.add(textField_1);

      textField_2.setBounds(210, 482, 75, 24);
      textField_2.setDocument(new JTextFieldLimit(4));
      background.add(textField_2);
      
      textField_3.setBounds(300, 482, 75, 24);
      textField_3.setDocument(new JTextFieldLimit(4));
      background.add(textField_3);
      
      textField_4.setBounds(390, 482, 75, 24);
      textField_4.setDocument(new JTextFieldLimit(4));
      background.add(textField_4);          
      
      label_1 = new JLabel("-");
      label_1.setBounds(200, 482, 13, 24);                  // �� - ����
      background.add(label_1);
      
      label_2 = new JLabel("-");
      label_2.setBounds(290, 482, 13, 24);
      background.add(label_2);
      
      label_3 = new JLabel("-");
      label_3.setBounds(380, 482, 13, 24);
      background.add(label_3); 
      
      radio1 = new JRadioButton("");
      radio1.setBounds(80, 270, 70, 15);
      radio1.setBackground(Color.WHITE);
      background.add(radio1);  
      
      radio2 = new JRadioButton("");
      radio2.setBounds(280, 270, 70, 15);
      radio2.setBackground(Color.WHITE);
      background.add(radio2);
      
      radio3 = new JRadioButton("");
      radio3.setBounds(480, 270, 70, 15);
      radio3.setBackground(Color.WHITE);
      background.add(radio3);
      
      radio4 = new JRadioButton("");
      radio4.setBounds(80, 415, 70, 15);
      radio4.setBackground(Color.WHITE);
      background.add(radio4);
      
      radio5 = new JRadioButton("");
      radio5.setBounds(280, 415, 70, 15);
      radio5.setBackground(Color.WHITE);
      background.add(radio5);
      
      radio6 = new JRadioButton("");
      radio6.setBounds(480, 415, 70, 15);
      radio6.setBackground(Color.WHITE);
      background.add(radio6);                     





      selectButton = new JButton[6];

      // Bread ����
      for (int i = 0; i < selectButton.length; i++) {
         selectButton[i] = new JButton("");   
         if(i < 3) {
            selectButton[i].setBounds( 20 + i * 200, 135, 150, 150);
         }else {
            selectButton[i].setBounds( 20 + (i-3) * 200, 274, 150 ,150);
         }
         selectButton[i].setIcon(new ImageIcon("image/card/" + (i+1) +".png")); // ��ư�� �������� ����
         selectButton[i].setSelectedIcon(new ImageIcon("image/card/"+ (i+1) + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
         selectButton[i].setPressedIcon(new ImageIcon("image/card/" + (i+1)+ "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
         selectButton[i].setBorderPainted(false); // ��ư�� �ܰ���(�׵θ�)�� �����ش�.
         selectButton[i].setContentAreaFilled(false); // ��ư�� ���뿵�� ä��� ����
         selectButton[i].setFocusPainted(false); // ��ư�� ���õǾ����� ����� �׵θ� ������
         selectButton[i].setOpaque(false); // ��� ���� �ȼ��� ä���� �ʴ´�.
         background.add(selectButton[i]);

         int num = i;
         
         //radio1,radio2,radio3,radio4,radio5,radio6
         
         radio1.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +"_Clicked.png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +".png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +".png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +".png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +".png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +".png"));
            }
         });
         radio2.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +".png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +"_Clicked.png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +".png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +".png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +".png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +".png"));
            }
         });
         radio3.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +".png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +".png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +"_Clicked.png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +".png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +".png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +".png"));
            }
         });
         radio4.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +".png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +".png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +".png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +"_Clicked.png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +".png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +".png"));
            }
         });
         radio5.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +".png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +".png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +".png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +".png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +"_Clicked.png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +".png"));
            }
         });
         radio6.addActionListener(new ActionListener() {         
            @Override
            public void actionPerformed(ActionEvent e) {

               selectButton[0].setIcon(new ImageIcon("image/card/" + 1 +".png"));
               selectButton[1].setIcon(new ImageIcon("image/card/" + 2 +".png"));
               selectButton[2].setIcon(new ImageIcon("image/card/"+  3 +".png"));
               selectButton[3].setIcon(new ImageIcon("image/card/" + 4 +".png"));
               selectButton[4].setIcon(new ImageIcon("image/card/" + 5 +".png"));
               selectButton[5].setIcon(new ImageIcon("image/card/" + 6 +"_Clicked.png"));
            }
         });

      }

      ButtonGroup group = new ButtonGroup();                  // �׷��� ������ ���߼����� �ȵ�
      group.add(radio1);
      group.add(radio2);
      group.add(radio3);
      group.add(radio4);
      group.add(radio5);
      group.add(radio6);

      //Ŭ���� ����� ���� ��� ������ ������ JPanel
      JPanel resultPan = new JPanel();
      JLabel resultlb = new JLabel("ī�带 �����ϼ���.");
      resultlb.setBounds(210, 245, 175, 18);
      frame3.getContentPane().add(resultPan);
      frame3.getContentPane().add(resultlb);

      radio1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // ��ư�� Ŭ�� �Ǿ��� �� ������ ����
            resultlb.setText("");
            count++;
         }
      });
      radio2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            resultlb.setText("");
            count++;
         }
      });
      radio3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            resultlb.setText("");
            count++;
         }
      });   
      radio4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            resultlb.setText("");
            count++;
         }
      });
      radio5.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            resultlb.setText("");
            count++;
         }
      });
      radio6.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            resultlb.setText("");
            count++;
         }
      });
      
      
      card_bt = new JButton("");
      card_bt.setBounds( 70, 525, 203, 76);
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
            Object obj = e.getSource();
            if(count > 0) {               // count ���� 0���� Ŭ�� ī�� ��� �޼����� ��
               if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_4.getText().equals("") || textField_4.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "ī�� ��ȣ�� �Է����ּ���.");

               }else {
                  JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
                  setVisible(false);
                  
                  cardNumber = textField_1.getText() + " " + textField_2.getText() + " " + textField_3.getText() + " " + textField_4.getText();   
//                User.getLoginedUser().getCardNumber();               // user Ŭ������ �ִ� ȸ���������� ���ٳֱ�
//                User u = User.getLoginedUser();
//                u.setCardNumber(cardNumber);
                  new CardOutput().cardWriter(cardNumber);
                  new CardOutput().Cardgetter();
                  
                  new PointMain().PointMainLayout();                  
                  
                  if(radio1.isSelected()) {
                      cardButton.setIcon(new ImageIcon("image/card/" + 1 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 1 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 1 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 1;
                  }else if(radio2.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 2 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 2 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 2 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 2;
                  }else if(radio3.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 3 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 3 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 3 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 3;
                  }else if(radio4.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 4 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 4 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 4 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 4;
                  }else if(radio5.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 5 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 5 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 5 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 5;
                  }else {
                     cardButton.setIcon(new ImageIcon("image/card/" + 6 + ".png")); // ��ư�� �������� ����
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 6 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 6 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
                      radioA = 6;
                      
                  }
                  
                 // background.setVisible(false);
                  count = 0;

               }
            }else {
               JOptionPane.showMessageDialog(null, "ī�带 �������ּ���.");
            } 
         }
      });
      
		back_bt = new JButton("");
		back_bt.setBounds( 310, 525, 203, 76);
		back_bt.setIcon(new ImageIcon("image/back_bt.png"));
		back_bt.setSelectedIcon(new ImageIcon("image/back_bt.png"));
		back_bt.setPressedIcon(new ImageIcon("image/back_bt_Clicked.png"));
		back_bt.setBorderPainted(false);
		back_bt.setContentAreaFilled(false);
		back_bt.setFocusPainted(false);
		back_bt.setOpaque(false);
		background.add(back_bt);

		back_bt.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){

				setVisible(false); 
				new PointMain().PointMainLayout();

			}
		});

   }




//   //@Override
//   //public void actionPerformed(ActionEvent e) {
//      /*   Object obj = e.getSource();
//      if(radio1.isSelected() || radio2.isSelected() || radio3.isSelected() || radio4.isSelected() || radio5.isSelected() || radio6.isSelected()) {
//         if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_4.getText().equals("") || textField_4.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "ī���ȣ�� �Է����ּ���.");
//         }else {
//            JOptionPane.showMessageDialog(this, "��ϵǾ����ϴ�.");
//            frame3.setVisible(false);
//         }
//      }else {
//         JOptionPane.showMessageDialog(this, "ī�带 �������ּ���");
//      } �ο찡 ¥��*/
//
//
//      if(e.getSource().equals(card)) {
//         if(count > 0) {               // count ���� 0���� Ŭ�� ī�� ��� �޼����� ��
//            if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_4.getText().equals("") || textField_4.getText().equals("")) {
//               JOptionPane.showMessageDialog(this, "ī�� ��ȣ�� �Է����ּ���.");
//               // �Է��� ī���ȣ�� ���� �����ؼ� ��������
//            }else {
//               JOptionPane.showMessageDialog(this, "��ϵǾ����ϴ�.");
//               frame3.setVisible(false);
//               System.out.println(card1);
//               count = 0;   
//            }
//         }else {
//            JOptionPane.showMessageDialog(this, "ī�带 �������ּ���.");
//				���� ���������� ���� §��.. �ڵ�ٸ���Ȯ��   
//         } // �̰� ������
//         // ���Ⱑ ������..
//         // ī���ȣ 16�ڸ��� �Է±��� �� ���Ŀ� ��ϵǾ����ϴ� �˸��� ������
//         // ī�� ��ȣ �Է� �� �޸��忡 ������ ������Ѿ� ��, ī���ȣ ����Ǵ� �������ϵ� ��������
//         //String textFieldValue = TextField.getText();         // String Ÿ�� textFileldValue������ �Է��� ���� ����
//         // �׸��� count�� �ٽ� 0���� �ʱ�ȭ ������!
//
//      }
// }
   public void PointCardLayout() {
      PointCard pointcard = new PointCard();
     // pointcard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pointcard.setSize(600, 700);
      pointcard.setVisible(true);
      pointcard.setLocationRelativeTo(null);
      pointcard.setResizable(false);
      pointcard.getContentPane().setLayout(null);
   }
}