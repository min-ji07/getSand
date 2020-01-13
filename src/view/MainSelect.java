package view;


import java.awt.event.*;
import javax.swing.*;
import model.Main;
import java.awt.*;
 
public class MainSelect extends BreadSelect {
	// MainSelect는 BreadSelect를 상속받기 때문에 BreadSelect에 있는 멤버 변수들을 쓸 수 있으니까
	// 변수를 굳이 다시 선언할 필요 없어서 코드 줄였어 나머지 ToppingSelect클래스나 SideMenu클래스 등도 같게 하면 될듯
	public JLabel mainNameLb; // 메인 메뉴 이름 라벨
	public JLabel mainPriceLb; // 메인 메뉴 가격 라벨
	Main[] mainArr = new Main[6]; // 메인 메뉴 객체 배열
	public JLabel mainTop;
	public MainSelect() {
		
		// 메인(고기)객체 배열 초기화
		menuConstructor.addMain(mainArr);
		
		// 생성자 안에 배경 이미지 삽입 
		mainIcon = new ImageIcon("image/MainSelect.png");   
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
		
		mainNameLb= new JLabel("");
		mainNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		mainNameLb.setBounds(707, 265, 145, 15);
		background.add(mainNameLb);

		mainPriceLb= new JLabel("");
		mainPriceLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		mainPriceLb.setBounds(840, 265, 145, 15);
		background.add(mainPriceLb);

		sumLb = new JLabel("합계:");
		sumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		sumLb.setBounds(707, 540, 145, 20);
		background.add(sumLb);
		
		totalPriceSum(); // 총합계 구하는 메소드 호출
		priceSumLb = new JLabel(Integer.toString(priceSum));
		priceSumLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		priceSumLb.setBounds(840, 540, 104, 20);
		background.add(priceSumLb);

		selectButton = new JButton[mainArr.length];
		
		//Main 선택 
		for (int i = 0; i < mainArr.length; i++) {
			selectButton[i] = new JButton("");	
			if(i < 3) {
				selectButton[i].setBounds( 79 + i * 200, 135, 150, 150);
			}else {
				selectButton[i].setBounds( 76 + (i-3) * 200, 314, 150 ,150);
			}
			selectButton[i].setIcon(new ImageIcon("image/SelectMain/" + (i+1) +".png"));
			selectButton[i].setSelectedIcon(new ImageIcon("image/SelectMain/"+ (i+1) + ".png"));
			selectButton[i].setPressedIcon(new ImageIcon("image/SelectMain/" + (i+1)+ "_Clicked.png"));
			selectButton[i].setBorderPainted(false);
			selectButton[i].setContentAreaFilled(false);
			selectButton[i].setFocusPainted(false);
			selectButton[i].setOpaque(false);
			background.add(selectButton[i]);
			
			int num = i;			
			selectButton[num].addActionListener(new ActionListener(){    	
				public void actionPerformed(ActionEvent e){
					Object obj = e.getSource();     	               
					if((JButton)obj == selectButton[num]) 
					{
						mainNameLb.setText(mainArr[num].getName());
						mainPriceLb.setText(Integer.toString(mainArr[num].getPrice()));
						priceSumLb.setText(Integer.toString(priceSum + mainArr[num].getPrice()));
						arrayNum = num;
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
				if(mainNameLb.getText() != "") { 
				orderList.add(mainArr[arrayNum]);
				new ToppingSelect().ToppingSelectLayOut();
				setVisible(false); 		
				}else {
					JOptionPane.showMessageDialog(null, "메인 토핑 종류를 선택해주세요");
				}
			}		
		});
        

//		back_bt = new JButton("");
//		back_bt.setBounds(260, 500, 203, 76);
//		back_bt.setIcon(new ImageIcon("image/back_bt.png"));
//		back_bt.setSelectedIcon(new ImageIcon("image/back_bt.png"));
//		back_bt.setPressedIcon(new ImageIcon("image/back_bt_Clicked.png"));
//		back_bt.setBorderPainted(false);
//		back_bt.setContentAreaFilled(false);
//		back_bt.setFocusPainted(false);
//		back_bt.setOpaque(false);
//		background.add(back_bt);
//
//		back_bt.addActionListener(new ActionListener(){ 
//			public void actionPerformed(ActionEvent e){
//				new BreadSelect2().breadSelectLayOut();
//				setVisible(false); 
//				priceSumLb.setText(Integer.toString(5000));
//			}
//		});

		
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
        
        cancel_bt.addActionListener(new ActionListener(){ 
           public void actionPerformed(ActionEvent e){
               Object obj = e.getSource();
               if((JButton)obj == cancel_bt) 
               {
            	   mainNameLb.setText("");
            	   mainPriceLb.setText("");
            	   // 취소 버튼을 누르면 금액 합계 중에서 내가 선택한 메인(고기)을 빼야되는데
            	   // 현재 priceSum에는 빵 금액만 남아있어서 그냥 priceSum만 써도 빵 가격만 뜸
            	   priceSumLb.setText(Integer.toString(priceSum));
               }
           }
        });
    }
 
    public void mainSelectLayOut() {   
        MainSelect mainSelect = new MainSelect();
       // mainSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainSelect.setSize(900, 650);
        mainSelect.setVisible(true);
        mainSelect.setLocationRelativeTo(null);
        mainSelect.setResizable(false);
        mainSelect.getContentPane().setLayout(null);
    }
}