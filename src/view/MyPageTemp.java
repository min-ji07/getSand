package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;

import controller.PointOutput;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;

public class MyPageTemp extends JFrame{
	private static JFrame frame;
	public static JLabel order;
	public static JLabel lblTimeLb;
	public static JLabel lblTime;
	public static int time = 11;
	public static TimerTask timerTask ;
	public static Timer timer;
	/**
	 * Launch the application.
	 */
	public static void  main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageTemp window = new MyPageTemp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if(BreadSelect.orderList.size() != 0) {
			timer  = new Timer();
			
			timerTask = new TimerTask() {
				@Override
				public void run() {
					if(time <=0) {
						timer.cancel();
					}else {
						time--;
					}
					lblTime.setText(time+"");
				}
			};
			
			
			timer.schedule(timerTask, 1000,1000); // task,delay,period
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public MyPageTemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();



		User lu = User.getLoginedUser();
		JLabel name = new JLabel(User.getLoginedUser().getUserName()+"님");
		name.setBounds(90, 160, 240, 20);
		name.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		frame.getContentPane().add(name);

		JLabel point = new JLabel("( " + lu.getPoint()+" )  Point");
		point.setFont(new Font("맑은 고딕", Font.BOLD, 29));
		point.setBounds(20, 240, 261, 66);
		frame.getContentPane().add(point);
		if(BreadSelect.orderList.size() == 0)	{
			order = new JLabel("현재 주문내역이 존재하지 않습니다.");
		}else {
			order = new JLabel(BreadSelect.orderList.get(1).getName() + " 샌드위치를 제조 중입니다.");
			
		}
		

		order.setForeground (new Color(255, 153, 0));
		order.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		order.setBounds(25, 291, 332, 20);
		frame.getContentPane().add(order);

		JLabel label = new JLabel("");
		label.setBounds(98, 423, 58, 58);
		frame.getContentPane().add(label);

		JButton btnname = new JButton("");
		btnname.setBounds(236, 129, 130, 40);
		btnname.setIcon(new ImageIcon("image/nick_bt.png"));
		btnname.setSelectedIcon(new ImageIcon("image/nick_bt.png"));
		btnname.setPressedIcon(new ImageIcon("image/nick_bt_Clicked.png"));
		btnname.setBorderPainted(false);
		btnname.setContentAreaFilled(false);
		btnname.setFocusPainted(false);
		btnname.setOpaque(false);
		
		lblTimeLb = new JLabel("주문취소시간: ");
		lblTimeLb.setBounds(25,311,140,100);
		lblTimeLb.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		frame.getContentPane().add(lblTimeLb);

		
		lblTime = new JLabel("");
		lblTime.setBounds(150,311,100,100);
		lblTime.setForeground (new Color(255, 153, 0));
		lblTime.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		frame.getContentPane().add(lblTime);
		
		
		JButton cancel_bt = new JButton("취소");
		cancel_bt.setBounds(280, 340, 130, 40);
		cancel_bt.setIcon(new ImageIcon("image/mini_cancle.png"));
		cancel_bt.setSelectedIcon(new ImageIcon("image/mini_cancle.png"));
		cancel_bt.setPressedIcon(new ImageIcon("image/mini_cancle_Clicked.png"));
		cancel_bt.setBorderPainted(false);
		cancel_bt.setContentAreaFilled(false);
		cancel_bt.setFocusPainted(false);
		cancel_bt.setOpaque(false);
		frame.getContentPane().add(cancel_bt);
		cancel_bt.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				if(time <=0) { // 시간초과
					JOptionPane.showMessageDialog(null, "이미 주문하신 샌드위치를 제조 중입니다..");
				}else { // 정상수행
					JOptionPane.showMessageDialog(null, "주문을 취소하였습니다.");
					order.setText("");
					lblTime.setText("");
					for(int i=0;i<SideMenuSelect.orderList.size();i++) {
						SideMenuSelect.orderList.clear();
					}
					for(int i=0;i<SideMenuSelect.arrayNum2.size();i++) {
						SideMenuSelect.arrayNum2.clear();
					}
					 lu.setPoint(lu.getPoint() + DiscountPayment.disTotalSum);
					 point.setText("( " + lu.getPoint()+" )  Point");
					 PointOutput po = new PointOutput();
					 po.pointWriter(lu.getPoint());
					 if(timerTask != null) {
						 timerTask.cancel();
					 }
				}
			}
		});
		
		
		frame.getContentPane().add(btnname);
		btnname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				ChangeName ch =new ChangeName();
				ch.ChangeNameLayOut();


				frame.dispose();

			}
		});

	
		




		JLabel[] coupons = new JLabel[5];
		Image blimg= new ImageIcon(this.getClass().getResource("/blackicon.png")).getImage();
		Image colorimg= new ImageIcon(this.getClass().getResource("/coloricon.png")).getImage();
		//User.getLoginedUser().getAccOder()




		coupons[0] = new JLabel(""); //쿠폰적립
		coupons[0].setBounds(14, 445, 80, 80);


		frame.getContentPane().add(coupons[0]);


		coupons[1] = new JLabel("");
		coupons[1].setBounds(86, 445, 80, 80);
		frame.getContentPane().add(coupons[1]);



		coupons[2] = new JLabel("");
		coupons[2].setBounds(158, 445, 80, 80);
		frame.getContentPane().add(coupons[2]);




		coupons[3] = new JLabel("");
		coupons[3].setBounds(236, 445, 80, 80);
		frame.getContentPane().add(coupons[3]);




		coupons[4] = new JLabel("");
		coupons[4].setBounds(312, 445, 80, 80);
		frame.getContentPane().add(coupons[4]);
		
		
		
		
		
//		JLabel lblStamp = new JLabel("스탬프");
//		lblStamp.setBounds(135, 358, 76, 23);
//		frame.getContentPane().add(lblStamp);
		
		JLabel lblHello = new JLabel("안녕하세요");
		lblHello.setForeground (new Color(255, 153, 0));
		lblHello.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblHello.setBounds(90, 130, 184, 18);
		frame.getContentPane().add(lblHello);

		
		// 조건에 따른 쿠폰 이미지 출력

		for(int i=0; i< coupons.length ;i++) {

			if(i<User.getLoginedUser().getAccOder()) {
				coupons[i].setIcon(new ImageIcon(colorimg));
			}else {
				coupons[i].setIcon(new ImageIcon(blimg));
			}
		}
		
		frame.add(new JLabel(new ImageIcon("image/myPageMain.png")));
//		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		
	}
		
}
