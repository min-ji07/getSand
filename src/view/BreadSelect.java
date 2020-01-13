package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MenuConstructor;
import model.Bread;
import model.Sandwich;
import java.awt.Color;

public class BreadSelect extends JFrame {
	// ���� �̸� �򰥷��� �����غþ�! �̰͵� �򰥸��ٸ� ���߿� �ٰ��� �����̸� ������
	public JPanel background;
	public ImageIcon mainIcon;
	public JScrollPane scroll;
	public JLabel breadNameLb;	// �� �̸� ��
	public JLabel breadPriceLb; // �� ���� ��
	public JLabel sumLb;  // "�հ� :" ��
	public JLabel priceSumLb; // �� ���� �հ� ��
	public JButton[] selectButton;
	public JButton check_bt;
	public JButton cancel_bt;
	public JButton back_bt;
	public int priceSum; // �� ���� �հ� ����
	public int arrayNum; // �迭�� �ε����� ������ ����
	public JLabel breadTop;
	
	public Bread[] breadArr = new Bread[6]; // �� ��ü �迭
	
	// controller�� �ִ� MenuConstructor Ŭ���� ���� ��,����,����,�ҽ�,���̵�޴� ��ü �迭�� �ʱ�ȭ ��Ű�� �Լ��� �ִµ�
	// �� �Լ����� ���� ���ؼ� MenuConstructor ������ ���������
	public MenuConstructor menuConstructor = new MenuConstructor(); 
	
	// ��ư�� Ŭ���� �� ��,����,����,�ҽ�,���̵�޴� ��ü�� ������ ArryaList
	// �������� �̿��ؼ� �ڷ����� Sandwich�� �߾�(��,����,����,�ҽ�,���̵�޴��� ������ġ�� ��ӹ����ϱ�)
	public static ArrayList<Sandwich> orderList = new ArrayList<>();
	public BreadSelect() {	
		// �� ��ü �迭 �ʱ�ȭ
		menuConstructor.addBread(breadArr);
		
		// ������ �ȿ� ��� �̹��� ���� 
		mainIcon = new ImageIcon("image/BreadSelect.png");
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainIcon.getImage(), 0, 0, null);
				setOpaque(false);  // �����ϰ�
				super.paintComponent(g);
			}
		};
		
		scroll = new JScrollPane(background);
		setContentPane(scroll);
		
		//�г� �������� ��ư ��ġ �����ϴ� ��� �ʿ� �ɼ�		
		background.setLayout(null);
		
		breadTop = new JLabel("Bread");
		breadTop.setForeground (new Color(255, 153, 0));
		breadTop.setFont(new Font("���� ���", Font.BOLD, 16));
		breadTop.setBounds(707, 195, 145, 20);
		background.add(breadTop);
		
		breadNameLb = new JLabel("");
		breadNameLb.setFont(new Font("���� ���", Font.BOLD, 14));
		breadNameLb.setBounds(707, 220, 145, 15);
		background.add(breadNameLb);
		
		breadPriceLb = new JLabel("");
		breadPriceLb.setFont(new Font("���� ���", Font.BOLD, 14));
		breadPriceLb.setBounds(840, 220, 145, 15);
		background.add(breadPriceLb);
		
		sumLb = new JLabel("�հ�:");
		sumLb.setFont(new Font("���� ���", Font.BOLD, 14));
		sumLb.setBounds(707, 540, 145, 20);
		background.add(sumLb);
		
		priceSumLb = new JLabel("");
		priceSumLb.setFont(new Font("���� ���", Font.BOLD, 14));
		priceSumLb.setBounds(840, 540, 104, 20);
		background.add(priceSumLb);
		
		selectButton = new JButton[breadArr.length];

		// Bread ����
		for (int i = 0; i < selectButton.length; i++) {
			selectButton[i] = new JButton("");	
			if(i < 3) {
				selectButton[i].setBounds( 79 + i * 200, 135, 150, 150);
			}else {
				selectButton[i].setBounds( 76 + (i-3) * 200, 314, 150 ,150);
			}
			selectButton[i].setIcon(new ImageIcon("image/SelectBread/" + (i+1) +".png")); // ��ư�� �������� ����
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectBread/"+ (i+1) + ".png")); // ���õ� ��ư�� ǥ���� �������� ����
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectBread/" + (i+1)+ "_Clicked.png")); // ��ư�� ���������� ǥ���� �������� ����
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
						breadNameLb.setText(breadArr[num].getName());
						breadPriceLb.setText(Integer.toString(breadArr[num].getPrice()));
						priceSumLb.setText(Integer.toString(breadArr[num].getPrice()));
						// �ؿ� Ȯ�� ��ư ���� �� ArrayList�� ���� ������ ��ü�� �����ϱ� ����
						// arrayNum������ ���� ����� �ε��� ���� �־���
						// ���� ���� ���� ������ num�� ���������� for���� ����� ���� ���ϱ� ����
						arrayNum = num; 
						
					}
				}
			});
		}
		
		
		//Ȯ�� ��ư
		check_bt = new JButton("");
		check_bt.setBounds( 420, 500, 203, 76);
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
				if(breadNameLb.getText() != "") {
				orderList.add(breadArr[arrayNum]); // ArrayList�� ���� ������ �޴��� ��ü�� �߰�
				new MainSelect().mainSelectLayOut();
				setVisible(false); 	
				}else {
					JOptionPane.showMessageDialog(null, "�� ������ �������ּ���");
				}
			}	
		});

		// ��� ��ư
		cancel_bt = new JButton("");
		cancel_bt.setBounds( 60, 500, 203, 76);
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
					breadNameLb.setText("");
					breadPriceLb.setText("");
					priceSumLb.setText("");
				}
			}
		});
	}
	
	// �޼���� ù���� �ҹ��ڷ� �����ؾ� �ż� �ٲ�. �޴� ���� Ŭ���� �ٸ� �޼���鵵 �� �ٲ���!
	public void breadSelectLayOut() {
		BreadSelect breadSelect = new BreadSelect();
		//breadSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		breadSelect.setSize(900, 650);
		breadSelect.setVisible(true);
		breadSelect.setLocationRelativeTo(null);
		breadSelect.setResizable(false);
		breadSelect.getContentPane().setLayout(null);
	}
	
	// �� ���� �հ� ���ϴ� �޼���. ���� ������ ���Ƽ� ���� �޼���� ����
	public void totalPriceSum() {
		int sum = 0;
		for(int i = 0; i < orderList.size(); i++) {
			sum += orderList.get(i).getPrice();
		}
		priceSum = sum;
	}
}
