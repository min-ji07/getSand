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

// �̺�Ʈ : ���콺�� Ŭ���ϰų� Ű����� ������ �Ϸ��� ��� �۵�
// ������ : ����ڰ� ���콺�� Ŭ���ϰų� Ű���带 ���� ������ ��ٷ� �ִ� ��
// �̺�Ʈ ������ : �߻��Ǵ� �̺�Ʈ�� ó���ϴ� ��ü 
/*
������ ������

ī���ȣ�Է��� ���� �ѹ� �Է½� ������ �ȶ߰�
(��������� �����ؾ��� ,�׸��� �����Ҷ����� ī���ȣ�� �ҷ����� �ؾ���)

ī���ȣ �Է½� (ī���ȣ�� Ȯ���߽��ϴ�? ī�� ����� �Ϸ��߽��ϴ�?) â�� ����Ŀ�

�ݾ��� ������ �� ������ �ǰ��ϴ°���*/

public class PointManager extends PointCard{

   public JPanel background;
   public ImageIcon mainIcon;
   public JScrollPane scroll;

   //public static int balance = 0;      // �ܾ� -- ���߿� ���� 
   public static boolean exit = true;   // ����
   private static int count = 0;
   int money = 0;

   public JFrame frame2 = new JFrame("���� �� �ݾ��� �����ϼ���.");
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
            setOpaque(false);  // �����ϰ�
            super.paintComponent(g);
         }
      };
      scroll = new JScrollPane(background);
      setContentPane(scroll);

      background.setLayout(null); 

      //JFrame frame = new JFrame("���� �� �ݾ��� �����ϼ���.");
      // ���ֵ� �ߴµ� ���� ����
      //frame.setLocationRelativeTo(null);                  // ������ ��� ����


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


      point500 = new JButton("50,000��");
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
      lb2.setFont(new Font("���� ���", Font.BOLD, 16));

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
            lb2.setText("�����Ͻ� �ݾ��� 1,000 �� �Դϴ�.");
            count++;
         }
      });

      point50.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 5000;
            lb2.setText("�����Ͻ� �ݾ��� 5,000 �� �Դϴ�.");
            count++;
         }
      });

      point100.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 10000;
            lb2.setText("�����Ͻ� �ݾ��� 10,000 �� �Դϴ�.");
            count++;
         }
      });


      point500.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            money = 50000;
            lb2.setText("�����Ͻ� �ݾ��� 50,000 �� �Դϴ�.");
            count++;
         }
      });
      background.add(lb2);
      pointCharge.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            if(count > 0) {
               JOptionPane.showMessageDialog(null, "����Ʈ�� �����Ǿ����ϴ�."); 
               //               balance = money;
               //balance += money;
               count = 0;
               //User.getLoginedUser().getPoint();         // user���� logineduser�� point�� �ҷ���
               User u = User.getLoginedUser();
               u.setPoint(u.getPoint() + money);
               User.setLoginedUser(u);
               PointOutput pp = new PointOutput();
               pp.pointWriter(User.getLoginedUser().getPoint());
               //System.out.println("����Ʈ �ܾ� : " + balance);
               setVisible(false);     
               new PointMain().PointMainLayout();

               if(radioA == 1) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 1 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 1 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 1 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }else if(radioA == 2) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 2 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 2 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 2 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }else if(radioA == 3) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 3 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 3 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 3 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }else if(radioA == 4) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 4 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 4 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 4 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }else if(radioA == 5) {
                  cardButton.setIcon(new ImageIcon("image/card/" + 5 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 5 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 5 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }else {
                  cardButton.setIcon(new ImageIcon("image/card/" + 6 + ".png")); // ��ư�� �������� ����
                  cardButton.setSelectedIcon(new ImageIcon("image/card/"+ 6 + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
                  cardButton.setPressedIcon(new ImageIcon("image/card/" + 6 + "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
               }

               //System.out.println("����Ʈ �ܾ� : " + balance);
            } else {
               JOptionPane.showMessageDialog(null, "�ݾ��� �����ϼ���.");
            }
         }
      });


   }


   // ���� �ݾ��� ������ �� �ݾ��� �����ǰ� �ؾ� ��
   // ����� �Է±ݾ����� ���ֱ���Ԥ���..

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