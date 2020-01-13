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
	// 변수 이름 헷갈려서 설정해봤어! 이것도 헷갈린다면 나중에 다같이 변수이름 정하자
	public JPanel background;
	public ImageIcon mainIcon;
	public JScrollPane scroll;
	public JLabel breadNameLb;	// 빵 이름 라벨
	public JLabel breadPriceLb; // 빵 가격 라벨
	public JLabel sumLb;  // "합계 :" 라벨
	public JLabel priceSumLb; // 총 가격 합계 라벨
	public JButton[] selectButton;
	public JButton check_bt;
	public JButton cancel_bt;
	public JButton back_bt;
	public int priceSum; // 총 가격 합계 변수
	public int arrayNum; // 배열의 인덱스를 저장할 변수
	public JLabel breadTop;
	
	public Bread[] breadArr = new Bread[6]; // 빵 객체 배열
	
	// controller에 있는 MenuConstructor 클래스 보면 빵,메인,토핑,소스,사이드메뉴 객체 배열을 초기화 시키는 함수가 있는데
	// 그 함수들을 쓰기 위해서 MenuConstructor 변수를 선언해줬어
	public MenuConstructor menuConstructor = new MenuConstructor(); 
	
	// 버튼을 클릭할 때 빵,메인,토핑,소스,사이드메뉴 객체를 저장할 ArryaList
	// 다형성을 이용해서 자료형을 Sandwich로 했어(빵,메인,토핑,소스,사이드메뉴는 샌드위치를 상속받으니까)
	public static ArrayList<Sandwich> orderList = new ArrayList<>();
	public BreadSelect() {	
		// 빵 객체 배열 초기화
		menuConstructor.addBread(breadArr);
		
		// 생성자 안에 배경 이미지 삽입 
		mainIcon = new ImageIcon("image/BreadSelect.png");
		background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mainIcon.getImage(), 0, 0, null);
				setOpaque(false);  // 투명하게
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
		
		breadNameLb = new JLabel("");
		breadNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		breadNameLb.setBounds(707, 220, 145, 15);
		background.add(breadNameLb);
		
		breadPriceLb = new JLabel("");
		breadPriceLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		breadPriceLb.setBounds(840, 220, 145, 15);
		background.add(breadPriceLb);
		
		sumLb = new JLabel("합계:");
		sumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sumLb.setBounds(707, 540, 145, 20);
		background.add(sumLb);
		
		priceSumLb = new JLabel("");
		priceSumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		priceSumLb.setBounds(840, 540, 104, 20);
		background.add(priceSumLb);
		
		selectButton = new JButton[breadArr.length];

		// Bread 선택
		for (int i = 0; i < selectButton.length; i++) {
			selectButton[i] = new JButton("");	
			if(i < 3) {
				selectButton[i].setBounds( 79 + i * 200, 135, 150, 150);
			}else {
				selectButton[i].setBounds( 76 + (i-3) * 200, 314, 150 ,150);
			}
			selectButton[i].setIcon(new ImageIcon("image/SelectBread/" + (i+1) +".png")); // 버튼에 아이콘을 셋팅
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectBread/"+ (i+1) + ".png")); // 선택된 버튼을 표시할 아이콘을 셋팅
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectBread/" + (i+1)+ "_Clicked.png")); // 버튼이 눌러졌을때 표시할 아이콘을 셋팅
			selectButton[i].setBorderPainted(false); // 버튼의 외곽선(테두리)을 없애준다.
			selectButton[i].setContentAreaFilled(false); // 버튼의 내용영역 채우기 안함
			selectButton[i].setFocusPainted(false); // 버튼이 선택되었을때 생기는 테두리 사용안함
			selectButton[i].setOpaque(false); // 경계 내의 픽셀은 채우지 않는다.
			background.add(selectButton[i]);
						
			int num = i;

			selectButton[i].addActionListener(new ActionListener(){    	
				public void actionPerformed(ActionEvent e){
					Object obj = e.getSource(); // 특정 라벨을 마우스로 클릭시, 그 라벨을 obj라는 라벨에 복사     	               
					if((JButton)obj == selectButton[num]) 
					{
						breadNameLb.setText(breadArr[num].getName());
						breadPriceLb.setText(Integer.toString(breadArr[num].getPrice()));
						priceSumLb.setText(Integer.toString(breadArr[num].getPrice()));
						// 밑에 확인 버튼 누를 때 ArrayList에 내가 선택한 객체를 저장하기 위해
						// arrayNum변수를 따로 만들어 인덱스 값을 넣었음
						// 굳이 따로 만든 이유는 num이 지역변수라서 for문을 벗어나면 쓰지 못하기 때문
						arrayNum = num; 
						
					}
				}
			});
		}
		
		
		//확인 버튼
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
				orderList.add(breadArr[arrayNum]); // ArrayList에 내가 선택한 메뉴의 객체를 추가
				new MainSelect().mainSelectLayOut();
				setVisible(false); 	
				}else {
					JOptionPane.showMessageDialog(null, "빵 종류를 선택해주세요");
				}
			}	
		});

		// 취소 버튼
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
	
	// 메서드명 첫글자 소문자로 시작해야 돼서 바꿈. 메뉴 선택 클래스 다른 메서드들도 다 바꿔줘!
	public void breadSelectLayOut() {
		BreadSelect breadSelect = new BreadSelect();
		//breadSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		breadSelect.setSize(900, 650);
		breadSelect.setVisible(true);
		breadSelect.setLocationRelativeTo(null);
		breadSelect.setResizable(false);
		breadSelect.getContentPane().setLayout(null);
	}
	
	// 총 가격 합계 구하는 메서드. 쓸일 많을거 같아서 따로 메서드로 뺐어
	public void totalPriceSum() {
		int sum = 0;
		for(int i = 0; i < orderList.size(); i++) {
			sum += orderList.get(i).getPrice();
		}
		priceSum = sum;
	}
}
