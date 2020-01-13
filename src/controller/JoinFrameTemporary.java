package controller;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.MainFrame;

public class JoinFrameTemporary extends JFrame {   // 임시 회원가입 프레임

	private JFrame frame;
	private JTextField userid;
	private JPasswordField password;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrameTemporary window = new JoinFrameTemporary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JoinFrameTemporary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		
		frame = new JFrame();
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground (new Color(255, 153, 0));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblId.setBounds(40, 75, 57, 15);
		frame.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("PW :");
		lblPassword.setForeground (new Color(255, 153, 0));
		lblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPassword.setBounds(40, 124, 140, 15);
		frame.getContentPane().add(lblPassword);
		
		
		JLabel lblName = new JLabel("NICKNAME :");
		lblName.setForeground (new Color(255, 153, 0));
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblName.setBounds(40, 188, 100, 15);
		frame.getContentPane().add(lblName);
		
		userid = new JTextField();
		userid.setBounds(147, 75, 140, 21);
		frame.getContentPane().add(userid);

		

		
		password = new JPasswordField();
		password.setBounds(147, 124, 140, 21);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		username = new JTextField();
		username.setBounds(147, 188, 140, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		JButton btnJoin = new JButton("");
		
		
		
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    //회원가입 버튼

				JoinController j= new JoinController();
				if(j.Join1(username.getText(),userid.getText(),password.getText()))  // 입력창을 통한 회원가입메소드
				frame.dispose(); 
			}
		});
		btnJoin.setBounds(35, 254, 140, 60);
		btnJoin.setIcon(new ImageIcon("image/mini_bt1.png"));
		btnJoin.setSelectedIcon(new ImageIcon("image/mini_bt1.png"));
		btnJoin.setPressedIcon(new ImageIcon("image/mini_bt1_Clicked.png"));
		btnJoin.setBorderPainted(false);
		btnJoin.setContentAreaFilled(false);
		btnJoin.setFocusPainted(false);
		btnJoin.setOpaque(false);
		frame.getContentPane().add(btnJoin);
		
		
		
		
		JButton btnCancle = new JButton(""); 
		btnCancle.setBounds(218, 254, 140, 60);	
		btnCancle.setIcon(new ImageIcon("image/mini_bt2.png"));
		btnCancle.setSelectedIcon(new ImageIcon("image/mini_bt2.png"));
		btnCancle.setPressedIcon(new ImageIcon("image/mini_bt2_Clicked.png"));
		btnCancle.setBorderPainted(false);
		btnCancle.setContentAreaFilled(false);
		btnCancle.setFocusPainted(false);
		btnCancle.setOpaque(false);
		frame.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		
		
		
	
		
		
		
		frame.add(new JLabel(new ImageIcon("image/signupMain.png")));
//		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
	}
		
		


		

	

}
