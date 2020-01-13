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
   public JFrame frame3 = new JFrame("카드등록 메뉴입니다.");
   public JButton card = new JButton("카드 등록하기");      
   public JButton[] selectButton;
   public JLabel label_2;
   public JLabel label_3;
   public JLabel label_1;
   public ImageIcon mainIcon;
   public JPanel background;
   public JButton miniCheck_bt;
   public JButton card_bt;
   public static String card1;		// static 변수니까 가져갈수있지않나
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
            setOpaque(false);  // 투명하게
            super.paintComponent(g);
         }
      };

      scroll = new JScrollPane(background);
      setContentPane(scroll);


      background.setLayout(null);


      
      JLabel label = new JLabel("카드번호를 입력하세요."); 
      label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
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
      label_1.setBounds(200, 482, 13, 24);                  // 라벨 - 설정
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

      // Bread 선택
      for (int i = 0; i < selectButton.length; i++) {
         selectButton[i] = new JButton("");   
         if(i < 3) {
            selectButton[i].setBounds( 20 + i * 200, 135, 150, 150);
         }else {
            selectButton[i].setBounds( 20 + (i-3) * 200, 274, 150 ,150);
         }
         selectButton[i].setIcon(new ImageIcon("image/card/" + (i+1) +".png")); // 버튼에 아이콘을 셋팅
         selectButton[i].setSelectedIcon(new ImageIcon("image/card/"+ (i+1) + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
         selectButton[i].setPressedIcon(new ImageIcon("image/card/" + (i+1)+ "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
         selectButton[i].setBorderPainted(false); // 버튼의 외곽선(테두리)을 없애준다.
         selectButton[i].setContentAreaFilled(false); // 버튼의 내용영역 채우기 안함
         selectButton[i].setFocusPainted(false); // 버튼이 선택되었을때 생기는 테두리 사용안함
         selectButton[i].setOpaque(false); // 경계 내의 픽셀은 채우지 않는다.
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

      ButtonGroup group = new ButtonGroup();                  // 그룹을 만들어야 다중선택이 안됨
      group.add(radio1);
      group.add(radio2);
      group.add(radio3);
      group.add(radio4);
      group.add(radio5);
      group.add(radio6);

      //클릭한 결과에 따른 결과 내용을 보여줄 JPanel
      JPanel resultPan = new JPanel();
      JLabel resultlb = new JLabel("카드를 선택하세요.");
      resultlb.setBounds(210, 245, 175, 18);
      frame3.getContentPane().add(resultPan);
      frame3.getContentPane().add(resultlb);

      radio1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 버튼이 클릭 되었을 때 동작할 내용
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
            if(count > 0) {               // count 값이 0보다 클때 카드 등록 메세지가 뜸
               if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_4.getText().equals("") || textField_4.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "카드 번호를 입력해주세요.");

               }else {
                  JOptionPane.showMessageDialog(null, "등록되었습니다.");
                  setVisible(false);
                  
                  cardNumber = textField_1.getText() + " " + textField_2.getText() + " " + textField_3.getText() + " " + textField_4.getText();   
//                User.getLoginedUser().getCardNumber();               // user 클래스에 있는 회원정보란에 갖다넣기
//                User u = User.getLoginedUser();
//                u.setCardNumber(cardNumber);
                  new CardOutput().cardWriter(cardNumber);
                  new CardOutput().Cardgetter();
                  
                  new PointMain().PointMainLayout();                  
                  
                  if(radio1.isSelected()) {
                      cardButton.setIcon(new ImageIcon("image/card/" + 1 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 1 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 1 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 1;
                  }else if(radio2.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 2 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 2 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 2 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 2;
                  }else if(radio3.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 3 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 3 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 3 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 3;
                  }else if(radio4.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 4 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 4 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 4 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 4;
                  }else if(radio5.isSelected()) {
                     cardButton.setIcon(new ImageIcon("image/card/" + 5 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 5 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 5 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 5;
                  }else {
                     cardButton.setIcon(new ImageIcon("image/card/" + 6 + ".png")); // 버튼에 아이콘을 셋팅
                      cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 6 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                      cardButton.setPressedIcon(new ImageIcon("image/card/" + 6 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
                      radioA = 6;
                      
                  }
                  
                 // background.setVisible(false);
                  count = 0;

               }
            }else {
               JOptionPane.showMessageDialog(null, "카드를 선택해주세요.");
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
//            JOptionPane.showMessageDialog(this, "카드번호를 입력해주세요.");
//         }else {
//            JOptionPane.showMessageDialog(this, "등록되었습니다.");
//            frame3.setVisible(false);
//         }
//      }else {
//         JOptionPane.showMessageDialog(this, "카드를 선택해주세요");
//      } 민우가 짜줌*/
//
//
//      if(e.getSource().equals(card)) {
//         if(count > 0) {               // count 값이 0보다 클때 카드 등록 메세지가 뜸
//            if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_4.getText().equals("") || textField_4.getText().equals("")) {
//               JOptionPane.showMessageDialog(this, "카드 번호를 입력해주세요.");
//               // 입력한 카드번호를 따로 저장해서 보내야함
//            }else {
//               JOptionPane.showMessageDialog(this, "등록되었습니다.");
//               frame3.setVisible(false);
//               System.out.println(card1);
//               count = 0;   
//            }
//         }else {
//            JOptionPane.showMessageDialog(this, "카드를 선택해주세요.");
//				위랑 같은거지만 내가 짠거.. 코드다른거확인   
//         } // 이게 문제임
//         // 여기가 문제네..
//         // 카드번호 16자리를 입력까지 다 된후에 등록되었습니다 알림이 떠야함
//         // 카드 번호 입력 후 메모장에 보내서 저장시켜야 함, 카드번호 저장되는 문서파일도 만들어야함
//         //String textFieldValue = TextField.getText();         // String 타입 textFileldValue변수에 입력한 값에 저장
//         // 그리고 count는 다시 0으로 초기화 시켜줌!
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