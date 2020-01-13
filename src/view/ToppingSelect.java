package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Sandwich;
import model.Topping;

public class ToppingSelect extends MainSelect {

   public JLabel toppingNameLb[] = new JLabel[6]; // 메인 메뉴 이름 라벨
   public JLabel toppingPriceLb[] = new JLabel[6]; // 메인 메뉴 가격 라벨
   //public JLabel toppingCountLb;
   public static int j = 0;
   public static int[] Topp_y = {290,290,290,290,290,290}; // Topp_y 좌표값
   public static int count[] = { 0, 0, 0, 0, 0, 0 };
   Topping[] toppingArr = new Topping[6]; // 메인 메뉴 객체 배열
   public static int Topp_count = 0;
   public static int Topp_total;
   public static int Topp_total2;
   public JLabel ToppingTop;

   public static List<Integer> arrayNum2 = new ArrayList<>(); // 배열의 인덱스를 저장할 변수
   //   public static ArrayList<String[]> toppNameList = new ArrayList<String[]>();
   //   public static ArrayList<int[]> toppPriceList = new ArrayList<int[]>();


   public ToppingSelect() {
      // 메인(고기)객체 배열 초기화
      menuConstructor.addTopping(toppingArr);

      // 생성자 안에 배경 이미지 삽입 
      mainIcon = new ImageIcon("image/ToppingSelect.png");   
      background = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(mainIcon.getImage(), 0, 0, null);
            setOpaque(false); 
            super.paintComponent(g);
         }
      };


      scroll = new JScrollPane(background);
      setContentPane(scroll);

      //패널 영역에서 버튼 위치 조절하는 경우 필요 옵션
      background.setLayout(null);

      breadTop = new JLabel("Bread");
      breadTop.setForeground (new Color(255, 153, 0));
      breadTop.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      breadTop.setBounds(707, 195, 145, 20);
      background.add(breadTop);

      breadNameLb= new JLabel(orderList.get(0).getName());
      breadNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      breadNameLb.setBounds(707, 220, 145, 15);
      background.add(breadNameLb);

      breadPriceLb= new JLabel(Integer.toString(orderList.get(0).getPrice()));
      breadPriceLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      breadPriceLb.setBounds(840, 220, 145, 15);
      background.add(breadPriceLb);

      mainTop = new JLabel("Main Topping");
      mainTop.setForeground (new Color(255, 153, 0));
      mainTop.setFont(new Font("맑은 고딕", Font.BOLD, 16));
      mainTop.setBounds(707, 240, 145, 22);
      background.add(mainTop);

      mainNameLb= new JLabel(orderList.get(1).getName());
      mainNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      mainNameLb.setBounds(707, 265, 145, 15);
      background.add(mainNameLb);

      mainPriceLb= new JLabel(Integer.toString(orderList.get(1).getPrice()));
      mainPriceLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      mainPriceLb.setBounds(840, 265, 145, 15);
      background.add(mainPriceLb);

		ToppingTop = new JLabel("Add Topping");
		ToppingTop.setForeground (new Color(255, 153, 0));
		ToppingTop.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		ToppingTop.setBounds(707, 285, 200, 22);
		background.add(ToppingTop);


      sumLb = new JLabel("합계:");
      sumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      sumLb.setBounds(707, 540, 145, 20);
      background.add(sumLb);

      totalPriceSum(); // 총합계 구하는 메소드 호출
      priceSumLb = new JLabel(Integer.toString(priceSum) );
      priceSumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
      priceSumLb.setBounds(840, 540, 104, 20);
      background.add(priceSumLb);

      selectButton = new JButton[toppingArr.length];

      //topping 선택 
      for (int i = 0; i < toppingArr.length; i++) {
         selectButton[i] = new JButton("");   
         if(i < 3) {
            selectButton[i].setBounds( 79 + i * 200, 135, 150, 150);
         }else {
            selectButton[i].setBounds( 76 + (i-3) * 200, 314, 150 ,150);
         }
         selectButton[i].setIcon(new ImageIcon("image/SelectTopping/" + (i+1) +".png"));
         selectButton[i].setSelectedIcon(new ImageIcon("image/SelectTopping/"+ (i+1) + ".png"));
         selectButton[i].setPressedIcon(new ImageIcon("image/SelectTopping/" + (i+1)+ "_Clicked.png"));
         selectButton[i].setBorderPainted(false);
         selectButton[i].setContentAreaFilled(false);
         selectButton[i].setFocusPainted(false);
         selectButton[i].setOpaque(false);
         background.add(selectButton[i]);

         int num = i;         
         toppingNameLb[num] = new JLabel("");
         //toppNameList.add();
         background.add(toppingNameLb[num]);

         toppingPriceLb[num]= new JLabel("");
         background.add(toppingPriceLb[num]);

         selectButton[num].addActionListener(new ActionListener(){       
            public void actionPerformed(ActionEvent e){

               String str = "";
               Object obj = e.getSource();                       
               if((JButton)obj == selectButton[num]) 
               {
                  int max = 0 ;
                  if(count[num] == 0) {  
                     Topp_count+=1;
                     for (int j = 0; j < Topp_y.length; j++) {
                        if(Topp_y[j] > max ) {   
                           max = Topp_y[j];                      
                        }
                     }      
                     Topp_y[num] = max+20; 
                  }
                  if(Topp_count <  4 ) {
                     count[num]++;
                     toppingNameLb[num].setFont(new Font("맑은 고딕", Font.BOLD, 14));
                     toppingPriceLb[num].setFont(new Font("맑은 고딕", Font.BOLD, 14));
                     toppingNameLb[num].setText("");
                     toppingNameLb[num].setText(toppingArr[num].getName() + "  X  " + count[num] + "      ");
                     toppingNameLb[num].setBounds(707, Topp_y[num], 145, 15); 
                     toppingPriceLb[num].setText(Integer.toString(toppingArr[num].getPrice()* count[num]));
                     //toppPriceList.add(nums);
                     toppingPriceLb[num].setBounds(840, Topp_y[num], 145, 15); 

                     
                     priceSum += toppingArr[num].getPrice();
                     Topp_total = toppingArr[num].getPrice() * count[num];
                     priceSumLb.setText(Integer.toString(priceSum));
                     Topp_total2 = Integer.parseInt(priceSumLb.getText()); 
                    
                  }else {
                     JOptionPane.showMessageDialog(null, "토핑은 3가지 이상 선택하실 수 없습니다 .");
                     Topp_count--;
                  }

                  //                  System.out.println(toppingNameLb.getText());
                  //                  System.out.println(toppingNameLb.getText() == toppingArr[num].getName());
               }

            }
         });
      }


      //확인 버튼
      check_bt = new JButton("");
      check_bt.setBounds( 480, 500, 203, 76);
      check_bt.setIcon(new ImageIcon("image/select_bt1.png"));
      check_bt.setSelectedIcon(new ImageIcon("image/select_bt1.png"));
      check_bt.setPressedIcon(new ImageIcon("image/select_bt1_Clicked.png"));
      check_bt.setBorderPainted(false);
      check_bt.setContentAreaFilled(false);
      check_bt.setFocusPainted(false);
      check_bt.setOpaque(false);
      background.add(check_bt);

      check_bt.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            if(Topp_count > 0) { 
               for (int i = 0; i < count.length; i++) {
                  if(count[i] != 0) {
                     orderList.add(toppingArr[i]);
                     arrayNum2.add(count[i]);
                  }
               }


               //}

               new SauceSelect().SauceSelectLayOut();
               setVisible(false); 
            }else {
               JOptionPane.showMessageDialog(null, "추가 토핑 종류를 선택해주세요");
            }
         }      
      });


      // 취소 버튼
      cancel_bt = new JButton("");
      cancel_bt.setBounds( 40, 500, 203, 76);
      background.setLayout(null);
      cancel_bt.setIcon(new ImageIcon("image/select_bt2.png"));
      cancel_bt.setSelectedIcon(new ImageIcon("image/select_bt2.png"));
      cancel_bt.setPressedIcon(new ImageIcon("image/select_bt2_Clicked.png"));
      cancel_bt.setBorderPainted(false);
      cancel_bt.setContentAreaFilled(false);
      cancel_bt.setFocusPainted(false);
      cancel_bt.setOpaque(false);
      background.add(cancel_bt);

//      back_bt = new JButton("");
//      back_bt.setBounds( 260, 500, 203, 76);
//      back_bt.setIcon(new ImageIcon("image/back_bt.png"));
//      back_bt.setSelectedIcon(new ImageIcon("image/back_bt.png"));
//      back_bt.setPressedIcon(new ImageIcon("image/back_bt_Clicked.png"));
//      back_bt.setBorderPainted(false);
//      back_bt.setContentAreaFilled(false);
//      back_bt.setFocusPainted(false);
//      back_bt.setOpaque(false);
//      background.add(back_bt);
//
//      back_bt.addActionListener(new ActionListener(){ 
//
//         public void actionPerformed(ActionEvent e){
//            Object obj = e.getSource();
//            if((JButton)obj == back_bt) {
//               for(int i=0;i<toppingNameLb.length;i++) {
//                  //                  orderList.remove(index)
//                  Topp_y[i]=290;
//                  count[i] = 0;         
//
//               }
//               for (int j = 1; j < orderList.size(); j++) {
//                  orderList.remove(j);
//               }
//               Topp_total = 0;
//               Topp_count = 0;
//            }
//            new MainSelect2().mainSelectLayOut();
//            setVisible(false); 
//         }
//      });


      cancel_bt.addActionListener(new ActionListener(){ 
         public void actionPerformed(ActionEvent e){
            Object obj = e.getSource();
            if((JButton)obj == cancel_bt) 
            {
               for(int i=0;i<toppingNameLb.length;i++) {
                  toppingNameLb[i].setText("");
                  toppingPriceLb[i].setText("");
                  Topp_y[i]=290;
                  count[i] = 0;

               }         
               priceSum = Integer.parseInt(breadPriceLb.getText()) + Integer.parseInt(mainPriceLb.getText());
               Topp_total2 = 0;
               Topp_count = 0;
               priceSumLb.setText(Integer.toString(priceSum));
               

            }
         }
      });
   }




   public void ToppingSelectLayOut() {   
      ToppingSelect toppingSelect = new ToppingSelect();
      //toppingSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      toppingSelect.setSize(900, 650);
      toppingSelect.setVisible(true);
      toppingSelect.setLocationRelativeTo(null);
      toppingSelect.setResizable(false);
      toppingSelect.getContentPane().setLayout(null);
   }
}