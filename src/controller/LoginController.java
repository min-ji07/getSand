package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import model.User;

public class LoginController {


	
	

	public LoginController() {

	}


	public Boolean LoginController1(String uId,String psd) {


		try {
			String s ;
			String[] ulArr;

			BufferedReader boulist= new BufferedReader(new FileReader("userlist.txt"));
			while((s=boulist.readLine())!= null) { //데이터파일 한줄씩 읽어옴
				ulArr = s.split("/");  // 슬래쉬 기준으로 배열에 저장
				/*
				 * 0-닉네임
				 * 1-아이디
				 * 2-패스워드
				 * 3-포인트
				 * 4-카드번호
				 * 5-누적 주문횟수
				 */



				if(uId.equals(ulArr[1]) && psd.equals(ulArr[2])) {  

					// 로그인 성공한 회원 객체 !!! 야호
					
					
					User loginedUser = new User(ulArr[0],ulArr[1],ulArr[2],
							(Integer.parseInt(ulArr[3])),ulArr[4],(Integer.parseInt(ulArr[5])));
					User.setLoginedUser(loginedUser);
					
					
					//포인트 읽어오는 메소드 실행

						PointOutput po = new PointOutput();
						po.Pointgetter(uId);
						po.stampCalculator();
						CardOutput co = new CardOutput();
						co.Cardgetter();
	
					//로그인 성공 출력
					JOptionPane.showMessageDialog(null, "로그인 되었습니다.");

					//frame.dispose();   // 프레임 종료
					boulist.close();
					return true;

				}			

			}

			//로그인 실패 출력

			JOptionPane.showMessageDialog(null, "아이디 또는 패스워드를 확인하세요");




			boulist.close();
			//dispose(); // 
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}


}

