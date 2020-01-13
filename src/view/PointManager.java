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

import controller.PointOutput;
import model.User;

// 이벤트 : 마우스로 클릭하거나 키보드로 누르는 일련의 모든 작동
// 리스너 : 사용자가 마우스를 클릭하거나 키보드를 누를 때까지 기다려 주는 것
// 이벤트 리스너 : 발생되는 이벤트를 처리하는 객체 
/*
충전을 누르면

카드번호입력을 띄우고 한번 입력시 다음에 안뜨게
(멤버변수에 저장해야함 ,그리고 충전할때마다 카드번호를 불러오게 해야함)

카드번호 입력시 (카드번호를 확인했습니다? 카드 등록을 완료했습니다?) 창을 띄운후에

금액을 눌렀을 때 충전이 되게하는거임*/

public class PointManager extends PointCard{

   public JPanel background;
   public ImageIcon mainIcon;
   public JScrollPane scroll;

   //public static int balance = 0;      // 잔액 -- 나중에 없앨 
   public static boolean exit = true;   // 종료
   private static int count = 0;
   int money = 0;

   public JFrame frame2 = new JFrame("충전 할 금액을 선택하세요.");
   public JButton point10;                  
   public JButton point50;
   public JButton point100;
   public JButton point500;
   public JButton pointCharge;
   public JPanel jp2 = new JPanel();   
   public JLabel lb2 = new JLabel("");
   PointCard pc = new PointCard();
   PointMain pm = new PointMain();
   public PointManager() {

      mainIcon = new ImageIcon("image/MoneyMain.png");
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

      //JFrame frame = new JFrame("충전 할 금액을 선택하세요.");
      // 없애도 뜨는데 문제 없음
      //frame.setLocationRelativeTo(null);                  // 프레임 가운데 띄우기


      point10 = new JButton("");
      point10.setBounds(60, 130, 250, 150); 
      point10.setIcon(new ImageIcon("image/money/money1.png"));
      point10.setSelectedIcon(new ImageIcon("image/money/money1.png"));
      point10.setPressedIcon(new ImageIcon("image/money/money1_Clicked.png"));
      point10.setBorderPainted(false);
      point10.setContentAreaFilled(false);
      point10.setFocusPainted(false);
      point10.setOpaque(false);
      background.add(point10);

      point50 = new JButton("");
      point50.setBounds(300, 130, 250, 150); 
      point50.setIcon(new ImageIcon("image/money/money2.png"));
      point50.setSelectedIcon(new ImageIcon("image/money/money2.png"));
      point50.setPressedIcon(new ImageIcon("image/money/money2_Clicked.png"));
      point50.setBorderPainted(false);
      point50.setContentAreaFilled(false);
      point50.setFocusPainted(false);
      point50.setOpaque(false);
      background.add(point50);                        


      point100 = new JButton("");
      point100.setBounds(60, 270, 250, 150);
      point100.setIcon(new ImageIcon("image/money/money3.png"));
      point100.setSelectedIcon(new ImageIcon("image/money/money3.png"));
      point100.setPressedIcon(new ImageIcon("image/money/money3_Clicked.png"));
      point100.setBorderPainted(false);
      point100.setContentAreaFilled(false);
      point100.setFocusPainted(false);
      point100.setOpaque(false);
      background.add(point100);


      point500 = new JButton("50,000원");
      point500.setBounds(300, 270, 250, 150);
      point500.setIcon(new ImageIcon("image/money/money4.png"));
      point500.setSelectedIcon(new ImageIcon("image/money/money4.png"));
      point500.setPressedIcon(new ImageIcon("image/money/money4_Clicked.png"));
      point500.setBorderPainted(false);
      point500.setContentAreaFilled(false);
      point500.setFocusPainted(false);
      point500.setOpaque(false);
      background.add(point500);


      pointCharge  = new JButton("");
      pointCharge.setBounds(70, 540, 241, 76);
      pointCharge.setIcon(new ImageIcon("image/bt2.png"));
      pointCharge.setSelectedIcon(new ImageIcon("image/b2.png"));
      pointCharge.setPressedIcon(new ImageIcon("image/bt2_Clicked.png"));
      pointCharge.setBorderPainted(false);
      pointCharge.setContentAreaFilled(false);
      pointCharge.setFocusPainted(false);
      background.add(pointCharge);
      lb2.setBounds(180,400,280,30);
      lb2.setForeground(new Color(255, 153, 0));
      lb2.setFont(new Font("맑은 고딕", Font.BOLD, 16));

      back_bt = new JButton("");
      back_bt.setBounds( 310, 545, 203, 76);
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


      point10.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 1000;
            lb2.setText("충전하실 금액은 1,000 원 입니다.");
            count++;
         }
      });

      point50.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 5000;
            lb2.setText("충전하실 금액은 5,000 원 입니다.");
            count++;
         }
      });

      point100.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 10000;
            lb2.setText("충전하실 금액은 10,000 원 입니다.");
            count++;
         }
      });


      point500.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 50000;
            lb2.setText("충전하실 금액은 50,000 원 입니다.");
            count++;
         }
      });
      background.add(lb2);
      pointCharge.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            if(count > 0) {
               JOptionPane.showMessageDialog(null, "포인트가 충전되었습니다."); 
               //               balance = money;
               //balance += money;
               count = 0;
               //User.getLoginedUser().getPoint();         // user에서 logineduser의 point를 불러옴
               User u = User.getLoginedUser();
               u.setPoint(u.getPoint() + money);
               User.setLoginedUser(u);
               PointOutput pp = new PointOutput();
               pp.pointWriter(User.getLoginedUser().getPoint());
               //System.out.println("포인트 잔액 : " + balance);
               setVisible(false);     
               new PointMain().PointMainLayout();

               if(radioA == 1) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 1 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 1 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 1 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }else if(radioA == 2) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 2 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 2 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 2 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }else if(radioA == 3) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 3 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 3 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 3 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }else if(radioA == 4) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 4 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 4 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 4 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }else if(radioA == 5) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 5 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 5 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 5 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }else {
                  cardButton.setIcon(new ImageIcon("image/card/" + 6 + ".png")); // 버튼에 아이콘을 셋팅
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 6 + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 6 + "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
               }

               //System.out.println("포인트 잔액 : " + balance);
            } else {
               JOptionPane.showMessageDialog(null, "금액을 선택하세요.");
            }
         }
      });


   }


   // 위에 금액을 눌렀을 때 금액이 연동되게 해야 함
   // 사용자 입력금액충전 없애기로함ㅎㅎ..

   public void PointManagerLayout() {
      PointManager pointmanager = new PointManager();
      //pointmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pointmanager.setSize(600, 700);
      pointmanager.setVisible(true);
      pointmanager.setLocationRelativeTo(null);
      pointmanager.setResizable(false);
      pointmanager.getContentPane().setLayout(null);
   }
}