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

	public Boolean Join1(String username, String userid,String password)  { // ȸ�������� �޾Ƽ� ���������Ϸ� ����
		
		if(username.isEmpty() || userid.isEmpty()|| password.isEmpty()) {

			JOptionPane.showMessageDialog(null, "��ĭ�� ä�켼��.");
			return false;   //ȸ������â ���� �ʱ� ���� �Ҹ��� ��ȯ
		}else {
			//ȸ�� ��ü����

			User u = new User(username,userid,password,0,null,0);




			try { //�����ͷ�
				BufferedWriter bouList = new BufferedWriter(new FileWriter("userlist.txt",true));  //true �� �ִ���?��
				bouList.write(u.getUserName()+"/");
				bouList.write(u.getUserid()+"/");
				bouList.write(u.getPassword()+"/");
				bouList.write(u.getPoint()+"/");
				bouList.write(u.getCardNumber()+"/");
				bouList.write(u.getAccOder()+"/\n");
				
				
				
				bouList.close();
				JOptionPane.showMessageDialog(null, "ȸ������ ����");
				

			}catch(Exception e1) {   

				JOptionPane.showMessageDialog(null, "���� ����");
			}
			
			return true;
		}

		

	}



}
