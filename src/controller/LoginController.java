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
			while((s=boulist.readLine())!= null) { //���������� ���پ� �о��
				ulArr = s.split("/");  // ������ �������� �迭�� ����
				/*
				 * 0-�г���
				 * 1-���̵�
				 * 2-�н�����
				 * 3-����Ʈ
				 * 4-ī���ȣ
				 * 5-���� �ֹ�Ƚ��
				 */



				if(uId.equals(ulArr[1]) && psd.equals(ulArr[2])) {  

					// �α��� ������ ȸ�� ��ü !!! ��ȣ
					
					
					User loginedUser = new User(ulArr[0],ulArr[1],ulArr[2],
							(Integer.parseInt(ulArr[3])),ulArr[4],(Integer.parseInt(ulArr[5])));
					User.setLoginedUser(loginedUser);
					
					
					//����Ʈ �о���� �޼ҵ� ����

						PointOutput po = new PointOutput();
						po.Pointgetter(uId);
						po.stampCalculator();
						CardOutput co = new CardOutput();
						co.Cardgetter();
	
					//�α��� ���� ���
					JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�.");

					//frame.dispose();   // ������ ����
					boulist.close();
					return true;

				}			

			}

			//�α��� ���� ���

			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� �н����带 Ȯ���ϼ���");




			boulist.close();
			//dispose(); // 
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}


}

