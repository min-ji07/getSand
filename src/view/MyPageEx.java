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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Sauce;
import model.SideMenu;
import model.Topping;

public class MyPageEx extends DiscountPayment{

   public JLabel totalSumNameTop;
   public JPanel background;
	public ImageIcon mainIcon;
	public JScrollPane scroll;
	public JLabel Totalmsg;
	public static String order1;
   public MyPageEx() {
	   mainIcon = new ImageIcon("image/ExMain.png");
      background = new JPanel() {
         public void paintComponent(Graphics g) {
        	 g.drawImage(mainIcon.getImage(), 0, 0, null);
				setOpaque(false);  // Åõ¸íÇÏ°Ô
				super.paintComponent(g);
         }
      };
      
      scroll = new JScrollPane(background);
      setContentPane(scroll);


      background.setLayout(null);
      
      // »§
      breadTop = new JLabel("Bread");
      breadTop.setForeground (new Color(255, 153, 0));
      breadTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      breadTop.setBounds(15, 350, 145, 22);
      background.add(breadTop);
      
      breadNameLb= new JLabel(orderList.get(0).getName());
      breadNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
      breadNameLb.setBounds(15, 380, 145, 15);
      background.add(breadNameLb);

      breadPriceLb= new JLabel(Integer.toString(orderList.get(0).getPrice()));
      breadPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
      breadPriceLb.setBounds(115, 380 , 145, 15);
      background.add(breadPriceLb);
      
      // ¸ÞÀÎ
      mainTop = new JLabel("Main Topping");
      mainTop.setForeground (new Color(255, 153, 0));
      mainTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      mainTop.setBounds(162, 350, 145, 22);
      background.add(mainTop);

      mainNameLb= new JLabel(orderList.get(1).getName());
      mainNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
      mainNameLb.setBounds(162, 380, 145, 15);
      background.add(mainNameLb);

      mainPriceLb= new JLabel(Integer.toString(orderList.get(1).getPrice()));
      mainPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
      mainPriceLb.setBounds(262, 380, 145, 15);
      background.add(mainPriceLb);
      
      ToppingTop = new JLabel("Add Topping");
      ToppingTop.setForeground (new Color(255, 153, 0));
      ToppingTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      ToppingTop.setBounds(315, 350, 200, 22);
      background.add(ToppingTop);

      SauceTop = new JLabel("Sauce");
      SauceTop.setForeground (new Color(255, 153, 0));
      SauceTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      SauceTop.setBounds(465, 350, 145, 22);
      background.add(SauceTop);

      sideMenuTop = new JLabel("SideMenu");
      sideMenuTop.setForeground (new Color(255, 153, 0));
      sideMenuTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      sideMenuTop.setBounds(595, 350, 145, 22);
      background.add(sideMenuTop);
      
      
      Totalmsg = new JLabel("ÁÖ¹® ¹× °áÁ¦°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
      //Totalmsg.setForeground (new Color(255, 153, 0));
      Totalmsg.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      Totalmsg.setBounds(250, 310, 250, 20);
      background.add(Totalmsg);
      
      totalSumNameTop = new JLabel("°áÁ¦ ±Ý¾×");
      //totalSumNameTop.setForeground (new Color(255, 153, 0));
      totalSumNameTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      totalSumNameTop.setBounds(25, 485, 145, 20);
      background.add(totalSumNameTop);

      JLabel totalSum = new JLabel((Integer.toString(disTotalSum)) + "¿ø");
      totalSum.setForeground (new Color(255, 153, 0));
      totalSum.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
      totalSum.setBounds(645, 485, 145, 20);
      background.add(totalSum);
  
      
      
      int y1 = ToppingTop.getY() + 10;
      int y2 = SauceTop.getY() + 10;
      int y3 = sideMenuTop.getY() + 10;
      
      for(int i=2;i<orderList.size();i++) {
         if(orderList.get(i) instanceof Topping) {
            y1+= 20;
            toppingNameLb[0]= new JLabel(orderList.get(i).getName() + "  X  " + arrayNum2.get(i-2));
            toppingPriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice() * arrayNum2.get(i-2)));
            toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
            toppingNameLb[0].setBounds(315, y1, 145, 15);
            toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
            toppingPriceLb[0].setBounds(415, y1, 145, 15);
            background.add(toppingNameLb[0]);
            background.add(toppingPriceLb[0]);
         }
      
     
         if(orderList.get(i) instanceof Sauce) {
            y2 += 20;
          toppingNameLb[0]= new JLabel(orderList.get(i).getName());
         toppingPriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice()));
         toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
         toppingNameLb[0].setBounds(465, y2, 145, 15);
         toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
         toppingPriceLb[0].setBounds(565, y2, 145, 15);
         background.add(toppingNameLb[0]);
         background.add(toppingPriceLb[0]);
         }
      
      
         if(orderList.get(i) instanceof SideMenu) {
            y3 += 20;
            toppingNameLb[0]= new JLabel(orderList.get(i).getName());
            toppingPriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice()));
            toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
            toppingNameLb[0].setBounds(595, y3, 145, 15);
            toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
            toppingPriceLb[0].setBounds(695, y3, 145, 15);
            background.add(toppingNameLb[0]);
            background.add(toppingPriceLb[0]);
         }
         
        
      
      }
      
      check_bt = new JButton("");
      check_bt.setBounds( 270, 500, 203, 76);
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
        	   
              
               setVisible(false); 
               new MainFrame().MainFrameLayOut();
               MyPageTemp temp = new MyPageTemp();
               if(orderList.get(0).getName() == null) {
            	   order1 ="";
               }else {
               order1 = orderList.get(0).getName();
               }
               temp.order.setText(order1);
         }      
      });
   }
   
   public void myPageExLayout() {
      MyPageEx myPageEx = new MyPageEx();
      //myPageEx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myPageEx.setSize(750, 620);
      myPageEx.setVisible(true);
      myPageEx.setLocationRelativeTo(null);
      myPageEx.setResizable(false);
      myPageEx.getContentPane().setLayout(null);
   }
}