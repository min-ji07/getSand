package controller;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.User;

public class JoinController {


	public JoinController() {

	}

	public Boolean Join1(String username, String userid,String password)  { // 회원정보를 받아서 데이터파일로 저장
		
		if(username.isEmpty() || userid.isEmpty()|| password.isEmpty()) {

			JOptionPane.showMessageDialog(null, "빈칸을 채우세요.");
			return false;   //회원가입창 닫지 않기 위해 불리언 반환
		}else {
			//회원 객체생성

			User u = new User(username,userid,password,0,null,0);




			try { //데이터로
				BufferedWriter bouList = new BufferedWriter(new FileWriter("userlist.txt",true));  //true 왜 있는지?ㅜ
				bouList.write(u.getUserName()+"/");
				bouList.write(u.getUserid()+"/");
				bouList.write(u.getPassword()+"/");
				bouList.write(u.getPoint()+"/");
				bouList.write(u.getCardNumber()+"/");
				bouList.write(u.getAccOder()+"/\n");
				
				
				
				bouList.close();
				JOptionPane.showMessageDialog(null, "회원가입 성공");
				

			}catch(Exception e1) {   

				JOptionPane.showMessageDialog(null, "가입 실패");
			}
			
			return true;
		}

		

	}



}
