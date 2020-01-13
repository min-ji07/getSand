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

import controller.JTextFieldLimit;
import controller.PointOutput;
import model.User;


public class DiscountPayment extends SideMenuSelect {

	public JPanel background;
	public ImageIcon mainIcon;
	public JScrollPane scroll;
	public JButton[] selectButton;
	public JButton pay_bt;
	public JButton cancel_bt;
	public JRadioButton btn1;
	public JRadioButton btn2;
	public JRadioButton btn3;
	public ButtonGroup sizeGp = new ButtonGroup();
	public JTextField cardNum1, cardNum2, cardNum3, cardNum4;
	public JLabel memberDetail;  // �� ������ ����
	public JLabel orderSumName; // �ֹ��ݾ�
	public JLabel disSumName;  // ���αݾ� 
	public JLabel totalSumName;  // �ѱݾ�
	public JButton miniCheck_bt;
	public static int disTotalSum;

	public DiscountPayment() {   
		// �� ��ü �迭 �ʱ�ȭ


		// ������ �ȿ� ��� �̹��� ���� 
		mainIcon = new ImageIcon("image/Payment.png");
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
		btn1 = new JRadioButton("");
		btn2 = new JRadioButton("");
		btn3 = new JRadioButton("");

		// ���� �׷�
		sizeGp = new ButtonGroup();
		btn1.setBackground(Color.WHITE);
		btn1.setBounds( 160, 280, 100, 20);
		sizeGp.add(btn1);
		btn2.setBackground(Color.WHITE);
		btn2.setBounds( 360, 280, 100, 20);
		sizeGp.add(btn2);
		btn3.setBackground(Color.WHITE);
		btn3.setBounds( 570, 280, 100, 20);
		sizeGp.add(btn3);

		background.add(btn1);
		background.add(btn2);
		background.add(btn3);

		selectButton = new JButton[3];





		// Bread ����
		for (int i = 0; i < selectButton.length; i++) {
			selectButton[i] = new JButton("");   
			selectButton[i].setBounds( 90 + i * 200, 135, 180, 150);
			selectButton[i].setIcon(new ImageIcon("image/SelectMembership/membership" + (i+1) +".png")); // ��ư�� �������� ����
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectMembership/membership"+ (i+1) + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectMembership/membership" + (i+1)+ "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
			selectButton[i].setBorderPainted(false); // ��ư�� �ܰ���(�׵θ�)�� �����ش�.
			selectButton[i].setContentAreaFilled(false); // ��ư�� ���뿵�� ä��� ����
			selectButton[i].setFocusPainted(false); // ��ư�� ���õǾ����� ����� �׵θ� ������
			selectButton[i].setOpaque(false); // ��� ���� �ȼ��� ä���� �ʴ´�.
			background.add(selectButton[i]);

			int num = i;

			selectButton[i].addActionListener(new ActionListener(){       
				public void actionPerformed(ActionEvent e){
					Object obj = e.getSource(); // Ư�� ���� ���콺�� Ŭ����, �� ���� obj��� �󺧿� ����                       
					if((JButton)obj == selectButton[num]) 
					{

					}
				}
			});


			btn1.addActionListener(new ActionListener() {         
				@Override
				public void actionPerformed(ActionEvent e) {
					memberDetail.setText("�� �������� 10%�Դϴ�.");
					memberDetail.setForeground (new Color(255, 153, 0));
					selectButton[0].setIcon(new ImageIcon("image/SelectMembership/membership" + 1 +"_Clicked.png"));
					selectButton[1].setIcon(new ImageIcon("image/SelectMembership/membership" + 2 +".png"));
					selectButton[2].setIcon(new ImageIcon("image/SelectMembership/membership" + 3 +".png"));
				}
			});


			btn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//					btn2.setForeground(new Color(255, 153, 0));
					memberDetail.setText("�� �������� 5%�Դϴ�.");
					memberDetail.setForeground (new Color(255, 153, 0));
					//					btn1.setForeground(Color.BLACK);
					//					btn3.setForeground(Color.BLACK);
					selectButton[0].setIcon(new ImageIcon("image/SelectMembership/membership" + 1 +".png"));
					selectButton[1].setIcon(new ImageIcon("image/SelectMembership/membership" + 2 +"_Clicked.png"));
					selectButton[2].setIcon(new ImageIcon("image/SelectMembership/membership" + 3 +".png"));
				}
			});

			btn3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					memberDetail.setText("�� �������� 15%�Դϴ�.");
					memberDetail.setForeground (new Color(255, 153, 0));
					selectButton[0].setIcon(new ImageIcon("image/SelectMembership/membership" + 1 +".png"));
					selectButton[1].setIcon(new ImageIcon("image/SelectMembership/membership" + 2 +".png"));
					selectButton[2].setIcon(new ImageIcon("image/SelectMembership/membership" + 3 +"_Clicked.png"));
				}
			});
		}

		// ī���ȣ �Է�â
		cardNum1= new JTextField(3);
		cardNum2= new JTextField(3);
		cardNum3= new JTextField(3);
		cardNum4= new JTextField(3);

		cardNum1.setBackground(Color.WHITE);
		cardNum1.setBounds( 220, 312, 70, 20);
		cardNum1.setDocument(new JTextFieldLimit(4));
		background.add(cardNum1);

		cardNum2.setBackground(Color.WHITE);
		cardNum2.setBounds( 310, 312, 70, 20);
		cardNum2.setDocument(new JTextFieldLimit(4));
		background.add(cardNum2);

		cardNum3.setBackground(Color.WHITE);
		cardNum3.setBounds( 400, 312, 70, 20);
		cardNum3.setDocument(new JTextFieldLimit(4));
		background.add(cardNum3);

		cardNum4.setBackground(Color.WHITE);
		cardNum4.setBounds( 490, 312, 70, 20);
		cardNum4.setDocument(new JTextFieldLimit(4));
		background.add(cardNum4);

		memberDetail = new JLabel("");
		memberDetail.setFont(new Font("���� ���", Font.BOLD, 14));
		memberDetail.setBounds(327, 345, 200, 20);
		background.add(memberDetail);


		orderSumName = new JLabel(Integer.toString(totalSum));
		orderSumName.setFont(new Font("���� ���", Font.BOLD, 14));
		orderSumName.setBounds(657, 365, 145, 20);
		background.add(orderSumName);

		disSumName = new JLabel("");
		disSumName.setFont(new Font("���� ���", Font.BOLD, 14));
		disSumName.setBounds(657, 390, 145, 20);
		background.add(disSumName);





		totalSumName = new JLabel("");
		totalSumName.setForeground (new Color(255, 153, 0));
		totalSumName.setFont(new Font("���� ���", Font.BOLD, 16));
		totalSumName.setBounds(657, 440, 145, 20);
		background.add(totalSumName);

		miniCheck_bt = new JButton("");
		miniCheck_bt.setBounds( 540, 284, 203, 76);
		miniCheck_bt.setIcon(new ImageIcon("image/miniCheck_bt.png"));
		miniCheck_bt.setSelectedIcon(new ImageIcon("image/miniCheck_bt.png"));
		miniCheck_bt.setPressedIcon(new ImageIcon("image/miniCheck_bt_Clicked.png"));
		miniCheck_bt.setBorderPainted(false);
		miniCheck_bt.setContentAreaFilled(false);
		miniCheck_bt.setFocusPainted(false);
		miniCheck_bt.setOpaque(false);
		background.add(miniCheck_bt);

		miniCheck_bt.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				Object obj = e.getSource();
				if (cardNum1.getText().equals("") || cardNum2.getText().equals("") || cardNum3.getText().equals("") || cardNum4.getText().equals("")){
					 JOptionPane.showMessageDialog(null, "ī�� ��ȣ�� �Է����ּ���.");
				}else {  	 
					if(btn1.isSelected()) {
						disSumName.setText(Integer.toString((int) (totalSum *0.1)));
						totalSumName.setText(Integer.toString(Integer.parseInt(orderSumName.getText()) - Integer.parseInt(disSumName.getText())));
					}else if(btn2.isSelected()) {
						disSumName.setText(Integer.toString((int) (totalSum *0.05)));
						totalSumName.setText(Integer.toString(Integer.parseInt(orderSumName.getText()) - Integer.parseInt(disSumName.getText())));
					}else if(btn3.isSelected()) {
						disSumName.setText(Integer.toString((int) (totalSum *0.15)));
						totalSumName.setText(Integer.toString(Integer.parseInt(orderSumName.getText()) - Integer.parseInt(disSumName.getText())));
					}
					disTotalSum = Integer.parseInt(totalSumName.getText());
				}



			}   
		});


		//���� ��ư
		pay_bt = new JButton("");
		pay_bt.setBounds( 480, 500, 203, 76);
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
				Object obj = e.getSource();
				if((JButton)obj == pay_bt) 
				{
					
					User lu = User.getLoginedUser();
					if(lu.getPoint() < disTotalSum ) {
						JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�. ������ ���ּ���.");
						new PointMain().PointMainLayout();
					}else {
					//lu.setAccOder(lu.getAccOder() + 1);
					lu.setPoint(lu.getPoint() - disTotalSum);
					User.setLoginedUser(lu);
					setVisible(false);
					
					new PointOutput().pointWriter(User.getLoginedUser().getPoint());
					new PointOutput().stampCalculator();
					new MyPageEx().myPageExLayout();
					}
				}
			}
		});

		// ��� ��ư
		cancel_bt = new JButton("");
		cancel_bt.setBounds( 80, 500, 203, 76);
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
				for (int i = 0; i < orderList.size(); i++) {
						orderList.clear();
					}	
				setVisible(false);
				new BreadSelect().breadSelectLayOut();
				
			}
		});
	}

	// �޼���� ù���� �ҹ��ڷ� �����ؾ� �ż� �ٲ�. �޴� ���� Ŭ���� �ٸ� �޼���鵵 �� �ٲ���!
	public void discountPaymentLayOut() {
		DiscountPayment discountPayment = new DiscountPayment();
		//discountPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		discountPayment.setSize(750, 620);
		discountPayment.setVisible(true);
		discountPayment.setLocationRelativeTo(null);
		discountPayment.setResizable(false);
		discountPayment.getContentPane().setLayout(null);
	}


}