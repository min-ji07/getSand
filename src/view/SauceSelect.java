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
import model.Topping;

public class SauceSelect extends ToppingSelect {

	public JLabel sauceNameLb[] = new JLabel[6]; // ¸ÞÀÎ ¸Þ´º ÀÌ¸§ ¶óº§
	public JLabel saucePriceLb[] = new JLabel[6]; // ¸ÞÀÎ ¸Þ´º °¡°Ý ¶óº§
	public JLabel SauceTop;
	public static int[] Sauce_y = { 365, 365, 365, 365, 365, 365 };
	public static int count2[] = { 0, 0, 0, 0, 0, 0 };
	public static int Sauce_count = 0;
	// public int count2 = 0;

	Sauce[] sauceArr = new Sauce[6]; // ¸ÞÀÎ ¸Þ´º °´Ã¼ ¹è¿­

	public SauceSelect() {
		// ¸ÞÀÎ(°í±â)°´Ã¼ ¹è¿­ ÃÊ±âÈ­
		menuConstructor.addSauce(sauceArr);

		// »ý¼ºÀÚ ¾È¿¡ ¹è°æ ÀÌ¹ÌÁö »ðÀÔ
		mainIcon = new ImageIcon("image/SauceSelect.png");
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		scroll = new JScrollPane(background);
		setContentPane(scroll);

		// ÆÐ³Î ¿µ¿ª¿¡¼­ ¹öÆ° À§Ä¡ Á¶ÀýÇÏ´Â °æ¿ì ÇÊ¿ä ¿É¼Ç
		background.setLayout(null);

		breadTop = new JLabel("Bread");
		breadTop.setForeground(new Color(255, 153, 0));
		breadTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		breadTop.setBounds(707, 195, 145, 20);
		background.add(breadTop);

		breadNameLb = new JLabel(orderList.get(0).getName());
		breadNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		breadNameLb.setBounds(707, 220, 145, 15);
		background.add(breadNameLb);

		breadPriceLb = new JLabel(Integer.toString(orderList.get(0).getPrice()));
		breadPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		breadPriceLb.setBounds(840, 220, 145, 15);
		background.add(breadPriceLb);

		mainTop = new JLabel("Main Topping");
		mainTop.setForeground(new Color(255, 153, 0));
		mainTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		mainTop.setBounds(707, 240, 145, 22);
		background.add(mainTop);

		mainNameLb = new JLabel(orderList.get(1).getName());
		mainNameLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		mainNameLb.setBounds(707, 265, 145, 15);
		background.add(mainNameLb);

		mainPriceLb = new JLabel(Integer.toString(orderList.get(1).getPrice()));
		mainPriceLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		mainPriceLb.setBounds(840, 265, 145, 15);
		background.add(mainPriceLb);

		ToppingTop = new JLabel("Add Topping");
		ToppingTop.setForeground(new Color(255, 153, 0));
		ToppingTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		ToppingTop.setBounds(707, 285, 200, 22);
		background.add(ToppingTop);

		SauceTop = new JLabel("Sauce");
		SauceTop.setForeground(new Color(255, 153, 0));
		SauceTop.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		SauceTop.setBounds(707, 360, 145, 22);
		background.add(SauceTop);

		int y1 = ToppingTop.getY() + 5;
		int y2 = SauceTop.getY() + 5;
		for (int i = 2; i < orderList.size(); i++) {
			if (orderList.get(i) instanceof Topping) {
				y1 += 20;
				toppingNameLb[0] = new JLabel(orderList.get(i).getName() + "  X  " + arrayNum2.get(i - 2));
				toppingPriceLb[0] = new JLabel(Integer.toString(orderList.get(i).getPrice() * arrayNum2.get(i - 2)));
				toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingNameLb[0].setBounds(707,y1, 145, 15);
				toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingPriceLb[0].setBounds(840, y1, 145, 15);
				background.add(toppingNameLb[0]);
				background.add(toppingPriceLb[0]);
			} else {
				y2 += 20;
				toppingNameLb[0] = new JLabel(orderList.get(i).getName());
				toppingPriceLb[0] = new JLabel(Integer.toString(orderList.get(i).getPrice()));
				toppingNameLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingNameLb[0].setBounds(707, y2, 145, 15);
				toppingPriceLb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
				toppingPriceLb[0].setBounds(840, y2, 145, 15);
				background.add(toppingNameLb[0]);
				background.add(toppingPriceLb[0]);
				
			}
		}

		sumLb = new JLabel("ÇÕ°è:");
		sumLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		sumLb.setBounds(707, 540, 145, 20);
		background.add(sumLb);

		// totalPriceSum(); // ÃÑÇÕ°è ±¸ÇÏ´Â ¸Þ¼Òµå È£Ãâ
		priceSumLb = new JLabel(Integer.toString(Topp_total2));
		priceSumLb.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		priceSumLb.setBounds(840, 540, 104, 20);
		background.add(priceSumLb);

		selectButton = new JButton[sauceArr.length];

		// sauce ¼±ÅÃ
		for (int i = 0; i < sauceArr.length; i++) {
			selectButton[i] = new JButton("");
			if (i < 3) {
				selectButton[i].setBounds(79 + i * 200, 135, 150, 150);
			} else {
				selectButton[i].setBounds(76 + (i - 3) * 200, 314, 150, 150);
			}
			selectButton[i].setIcon(new ImageIcon("image/SelectSauce/" + (i + 1) + ".png"));
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectSauce/" + (i + 1) + ".png"));
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectSauce/" + (i + 1) + "_Clicked.png"));
			selectButton[i].setBorderPainted(false);
			selectButton[i].setContentAreaFilled(false);
			selectButton[i].setFocusPainted(false);
			selectButton[i].setOpaque(false);
			background.add(selectButton[i]);

			int num = i;
			sauceNameLb[num] = new JLabel("");
			// sauceNameLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			// sauceNameLb[num].setBounds(707, y[i] , 145, 15);
			background.add(sauceNameLb[num]);

			saucePriceLb[num] = new JLabel("");
			// saucePriceLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
			// saucePriceLb[num].setBounds(840, y[i] , 145, 15);
			background.add(saucePriceLb[num]);

			selectButton[num].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object obj = e.getSource();
					if ((JButton) obj == selectButton[num]) {
						int max2 = 0;
						if (count2[num] == 0) {
							Sauce_count += 1;
							for (int j = 0; j < Sauce_y.length; j++) {
								if (Sauce_y[j] > max2) {
									max2 = Sauce_y[j];
								}
							}
							Sauce_y[num] = max2 + 20;
						}
						if (Sauce_count < 4) {

							count2[num]++;
							sauceNameLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
							saucePriceLb[num].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
							sauceNameLb[num].setText("");
							sauceNameLb[num].setText(sauceArr[num].getName());
							sauceNameLb[num].setBounds(707, Sauce_y[num], 145, 15);
							saucePriceLb[num].setText(Integer.toString(sauceArr[num].getPrice()));
							saucePriceLb[num].setBounds(840, Sauce_y[num], 145, 15);

						} else {
							JOptionPane.showMessageDialog(null, "¼Ò½º´Â 3°¡Áö ÀÌ»ó ¼±ÅÃÇÏ½Ç ¼ö ¾ø½À´Ï´Ù .");
							Sauce_count--;
						}
						// sauceNameLb.setText(sauceArr[num].getName());
						// saucePriceLb.setText(Integer.toString(sauceArr[num].getPrice()));
						// priceSumLb.setText(Integer.toString(priceSum + sauceArr[num].getPrice()));
						// arrayNum = num;
					}
				}
			});
		}

		// È®ÀÎ ¹öÆ°
		check_bt = new JButton("");
		check_bt.setBounds(480, 500, 203, 76);
		check_bt.setIcon(new ImageIcon("image/select_bt1.png"));
		check_bt.setSelectedIcon(new ImageIcon("image/select_bt1.png"));
		check_bt.setPressedIcon(new ImageIcon("image/select_bt1_Clicked.png"));
		check_bt.setBorderPainted(false);
		check_bt.setContentAreaFilled(false);
		check_bt.setFocusPainted(false);
		check_bt.setOpaque(false);
		background.add(check_bt);

		check_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Sauce_count > 0) {
					for (int i = 0; i < count2.length; i++) {
						if (count2[i] != 0) {
							orderList.add(sauceArr[i]);
						}
					}
					
					new SideMenuSelect().SideMenuSelectLayOut();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "¼Ò½º Á¾·ù¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä");
				}

			}
		});

		// ÀÌÀü ¹öÆ°
		// back_bt = new JButton("");
		// back_bt.setBounds( 260, 500, 203, 76);
		// back_bt.setIcon(new ImageIcon("image/back_bt.png"));
		// back_bt.setSelectedIcon(new ImageIcon("image/back_bt.png"));
		// back_bt.setPressedIcon(new ImageIcon("image/back_bt_Clicked.png"));
		// back_bt.setBorderPainted(false);
		// back_bt.setContentAreaFilled(false);
		// back_bt.setFocusPainted(false);
		// back_bt.setOpaque(false);
		// background.add(back_bt);

		// back_bt.addActionListener(new ActionListener(){
		//
		// public void actionPerformed(ActionEvent e){
		// Object obj = e.getSource();
		// if((JButton)obj == back_bt) {
		// for (int j = 1; j < orderList.size(); j++) {
		// orderList.remove(j);
		// }
		// Sauce_count=0;
		// for(int i=0;i<sauceNameLb.length;i++) {
		// // orderList.remove(index)
		// Sauce_y[i]=380;
		// count2[i] = 0;
		// }
		// }
		// new ToppingSelect2().ToppingSelectLayOut();
		// setVisible(false);
		// }
		// });

		// Ãë¼Ò ¹öÆ°
		cancel_bt = new JButton("");
		cancel_bt.setBounds(40, 500, 203, 76);
		background.setLayout(null);
		cancel_bt.setIcon(new ImageIcon("image/select_bt2.png"));
		cancel_bt.setSelectedIcon(new ImageIcon("image/select_bt2.png"));
		cancel_bt.setPressedIcon(new ImageIcon("image/select_bt2_Clicked.png"));
		cancel_bt.setBorderPainted(false);
		cancel_bt.setContentAreaFilled(false);
		cancel_bt.setFocusPainted(false);
		cancel_bt.setOpaque(false);
		background.add(cancel_bt);

		cancel_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((JButton) obj == cancel_bt) {

					for (int i = 0; i < sauceNameLb.length; i++) {
						sauceNameLb[i].setText("");
						saucePriceLb[i].setText("");
						Sauce_y[i] = 380;
						count2[i] = 0;
					}
					Sauce_count = 0;
					priceSumLb = new JLabel(Integer.toString(Topp_total2));
				}
			}
		});
	}

	public void SauceSelectLayOut() {
		SauceSelect sauceSelect = new SauceSelect();
		//sauceSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sauceSelect.setSize(900, 650);
		sauceSelect.setVisible(true);
		sauceSelect.setLocationRelativeTo(null);
		sauceSelect.setResizable(false);
		sauceSelect.getContentPane().setLayout(null);
	}
}