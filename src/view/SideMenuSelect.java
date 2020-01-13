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

import model.Sauce;
import model.SideMenu;
import model.Topping;

public class SideMenuSelect extends SauceSelect {

	public JLabel sideMenuNameLb[] = new JLabel[6]; // ¸ÞÀÎ ¸Þ´º ÀÌ¸§ ¶óº§
	public JLabel sideMenuPriceLb[] = new JLabel[6]; // ¸ÞÀÎ ¸Þ´º °¡°Ý ¶óº§
	public JLabel sideMenuTop;
	public static int[] Side_y = {450,450,450,450,450,450};
	public static int count3[] = { 0, 0, 0, 0, 0, 0 };
	public static int Side_count=0;
	public static int priceSum2;
	public static int totalSum;
	SideMenu[] sideMenuArr = new  SideMenu[6]; // ¸ÞÀÎ ¸Þ´º °´Ã¼ ¹è¿­
	public SideMenuSelect() {

		menuConstructor.addSideMenu(sideMenuArr);

		// »ý¼ºÀÚ ¾È¿¡ ¹è°æ ÀÌ¹ÌÁö »ðÀÔ 
		mainIcon = new ImageIcon("image/SideMenuSelect.png");   
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainIcon.getImage(), 0, 0, null);
				setOpaque(false); 
				super.paintComponent(g);
			}
		};


		scroll = new JScrollPane(background);
		setContentPane(scroll);

		//ÆÐ³Î ¿µ¿ª¿¡¼­ ¹öÆ° À§Ä¡ Á¶ÀýÇÏ´Â °æ¿ì ÇÊ¿ä ¿É¼Ç
		background.setLayout(null);

		breadTop = new JLabel("Bread");
		breadTop.setForeground (new Color(255, 153, 0));
		breadTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		breadTop.setBounds(707, 195, 145, 20);
		background.add(breadTop);


		breadNameLb= new JLabel(orderList.get(0).getName());
		breadNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		breadNameLb.setBounds(707, 220, 145, 15);
		background.add(breadNameLb);

		breadPriceLb= new JLabel(Integer.toString(orderList.get(0).getPrice()));
		breadPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		breadPriceLb.setBounds(840, 220 , 145, 15);
		background.add(breadPriceLb);



		mainTop = new JLabel("Main Topping");
		mainTop.setForeground (new Color(255, 153, 0));
		mainTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		mainTop.setBounds(707, 240, 145, 22);
		background.add(mainTop);

		mainNameLb= new JLabel(orderList.get(1).getName());
		mainNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		mainNameLb.setBounds(707, 265, 145, 15);
		background.add(mainNameLb);

		mainPriceLb= new JLabel(Integer.toString(orderList.get(1).getPrice()));
		mainPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		mainPriceLb.setBounds(840, 265, 145, 15);
		background.add(mainPriceLb);

		ToppingTop = new JLabel("Add Topping");
		ToppingTop.setForeground (new Color(255, 153, 0));
		ToppingTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		ToppingTop.setBounds(707, 285, 200, 22);
		background.add(ToppingTop);

		SauceTop = new JLabel("Sauce");
		SauceTop.setForeground (new Color(255, 153, 0));
		SauceTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		SauceTop.setBounds(707, 365, 145, 22);
		background.add(SauceTop);

		sideMenuTop = new JLabel("SideMenu");
		sideMenuTop.setForeground (new Color(255, 153, 0));
		sideMenuTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		sideMenuTop.setBounds(707, 445, 145, 22);
		background.add(sideMenuTop);

		int y1 = ToppingTop.getY() + 5;
		int y2 = SauceTop.getY() + 5;
		for(int i=2;i<orderList.size();i++) {
			if(orderList.get(i) instanceof Topping) {
				y1+= 20;
				toppingNameLb[0]= new JLabel(orderList.get(i).getName() + "  X  " + arrayNum2.get(i-2));
				toppingPriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice() * arrayNum2.get(i-2)));
				toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingNameLb[0].setBounds(707, y1, 145, 15);
				toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingPriceLb[0].setBounds(840, y1, 145, 15);
				background.add(toppingNameLb[0]);
				background.add(toppingPriceLb[0]);
			}
			if(orderList.get(i) instanceof Sauce) {
				y2 += 20;
				toppingNameLb[0]= new JLabel(orderList.get(i).getName());
				toppingPriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice()));
				toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingNameLb[0].setBounds(707, y2, 145, 15);
				toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingPriceLb[0].setBounds(840, y2, 145, 15);
				background.add(toppingNameLb[0]);
				background.add(toppingPriceLb[0]);
			}
				
		}
//		int y= 400;
//		for(int i=5;i<orderList.size();i++) {
//			sauceNameLb[0]= new JLabel(orderList.get(i).getName());
//			saucePriceLb[0]= new JLabel(Integer.toString(orderList.get(i).getPrice()));
//			sauceNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
//			sauceNameLb[0].setBounds(707, y, 145, 15);
//			saucePriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
//			saucePriceLb[0].setBounds(840, y, 145, 15);
//			background.add(sauceNameLb[0]);
//			background.add(saucePriceLb[0]);
//			y+=20;
//		}



		sumLb = new JLabel("ÇÕ°è:");
		sumLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		sumLb.setBounds(707, 560, 145, 20);
		background.add(sumLb);

		totalPriceSum(); // ÃÑÇÕ°è ±¸ÇÏ´Â ¸Þ¼Òµå È£Ãâ
		priceSumLb = new JLabel(Integer.toString(Topp_total2));
		priceSumLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		priceSumLb.setBounds(840, 560, 104, 20);
		background.add(priceSumLb);

		selectButton = new JButton[sideMenuArr.length];

		// sideMenu ¼±ÅÃ 
		for (int i = 0; i < sideMenuArr.length; i++) {
			selectButton[i] = new JButton("");   
			if(i < 3) {
				selectButton[i].setBounds( 79 + i * 200, 135, 150, 150);
			}else {
				selectButton[i].setBounds( 76 + (i-3) * 200, 314, 150 ,150);
			}
			selectButton[i].setIcon(new ImageIcon("image/SelectSideMenu/" + (i+1) +".png"));
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectSideMenu/"+ (i+1) + ".png"));
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectSideMenu/" + (i+1)+ "_Clicked.png"));
			selectButton[i].setBorderPainted(false);
			selectButton[i].setContentAreaFilled(false);
			selectButton[i].setFocusPainted(false);
			selectButton[i].setOpaque(false);
			background.add(selectButton[i]);

			int num = i;    
			sideMenuNameLb[num]= new JLabel("");
			background.add(sideMenuNameLb[num]);

			sideMenuPriceLb[num]= new JLabel("");
			background.add(sideMenuPriceLb[num]);

			selectButton[num].addActionListener(new ActionListener(){       
				public void actionPerformed(ActionEvent e){
					Object obj = e.getSource();                       
					if((JButton)obj == selectButton[num]) 
					{
					
						
						int max3 = 0 ;
						if(count3[num] == 0) {  		
							Side_count+=1;
							for (int j = 0; j < Side_y.length; j++) {
								if(Side_y[j] > max3 ) {   
									max3 = Side_y[j];                      
								}
							}      
							Side_y[num] = max3+20; 
						}
						if(Side_count <  4 ) {
							
							
							sideMenuNameLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
							sideMenuPriceLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
							sideMenuNameLb[num].setText("");
							sideMenuNameLb[num].setText(sideMenuArr[num].getName());
							sideMenuNameLb[num].setBounds(707, Side_y[num], 145, 15); 
							sideMenuPriceLb[num].setText(Integer.toString(sideMenuArr[num].getPrice()));
							sideMenuPriceLb[num].setBounds(840, Side_y[num], 145, 15); 
//				               priceSum = Topp_total2;
//				               priceSumLb.setText(Integer.toString(priceSum));
							
							if(count3[num] == 0 ) {
								 //priceSumLb = new JLabel(Integer.toString(Topp_total2));
								 priceSum = Topp_total2;
								
								 priceSum2 += sideMenuArr[num].getPrice();
			                     priceSumLb.setText(Integer.toString(priceSum + priceSum2));
			                     totalSum = Integer.parseInt(priceSumLb.getText());
			                     
							}
							count3[num]++;
						}else {
							JOptionPane.showMessageDialog(null, "»çÀÌµå ¸Þ´º´Â 3°¡Áö ÀÌ»ó ¼±ÅÃÇÏ½Ç ¼ö ¾ø½À´Ï´Ù .");
							Side_count--;
						}
					}
				}
			});
		}


		//È®ÀÎ ¹öÆ°
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
		    	 //JOptionPane.showMessageDialog(null, "»çÀÌµå ¸Þ´º´Â 3°¡Áö ÀÌ»ó ¼±ÅÃÇÏ½Ç ¼ö ¾ø½À´Ï´Ù .");
		    	  if(Side_count > 0) {
		    		  for (int i = 0; i < count3.length; i++) {
		    			  if(count3[i] != 0) {
		    				  orderList.add(sideMenuArr[i]);
		    			  }
		    		  }
		    		  setVisible(false);
		    		  new Payment().paymentSelectLayOut();
		    	  }else {
		    		  JOptionPane.showMessageDialog(null, "»çÀÌµå ¸Þ´º¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.");
		    	  }
		    	    


		      }      
		   });


		// Ãë¼Ò ¹öÆ°
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

		cancel_bt.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				Object obj = e.getSource();
				if((JButton)obj == cancel_bt) 
				{
					 for(int i=0;i<sideMenuNameLb.length;i++) {
						 sideMenuNameLb[i].setText("");
						 sideMenuPriceLb[i].setText("");
						  Side_y[i]=445;
		                  count3[i] = 0;             
		               }         
					   Side_count = 0;
		               priceSum = Topp_total2;
		               priceSum2 = 0;
		               //Topp_total2 = 0;
		               Topp_count = 0;
		               priceSumLb.setText(Integer.toString(priceSum));
		               //priceSumLb.setText(Integer.toString(Topp_total2));
				}
			}
		});
	}




	public void SideMenuSelectLayOut() {   
		SideMenuSelect sideMenuSelect = new SideMenuSelect();
		//sideMenuSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sideMenuSelect.setSize(900, 650);
		sideMenuSelect.setVisible(true);
		sideMenuSelect.setLocationRelativeTo(null);
		sideMenuSelect.setResizable(false);
		sideMenuSelect.getContentPane().setLayout(null);

	}
}