package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import model.User;

public class PointOutput {

	public PointOutput() {

	}
	//����Ʈ ����ϴ� �޼ҵ�  , ����Ʈ ���������Ϸ� �������� -> ����Ʈ �����Ǵ� �޼ҵ帶�� ��������ٰ� , �׷��� ������ ����ؿü� ����
	public void pointWriter(int point) {

		try { // id ���� ������ ���� �����ؼ� ���� ����Ʈ�� �������ش�. ����,���� �� �������־����
			File file = new File(User.getLoginedUser().getUserid());

			BufferedWriter pointList = new BufferedWriter(new FileWriter(file,true));
			pointList.write(point+"\n");
			pointList.close();
			
			
			//JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");  //���� Ȯ�ο� , �ϼ��� �ּ�ó���Ұ�
		}catch(Exception e1) {   

			JOptionPane.showMessageDialog(null, "����Ʈ ���� ����");
		}

	}
	// ����Ʈ �о���� �޼ҵ�
	public void Pointgetter(String Userid) {
		
		
	try{
		

		String s ;
		String[] plArr;
		//id���� ������ �о�� 
		BufferedReader pointList = new BufferedReader(new FileReader(User.getLoginedUser().getUserid()));
		
		//  ���� �������� �迭�� ����ְ� ���� �������ٸ� static ��ü ����Ʈ�� ��ȯ����
		while((s=pointList.readLine()) !=null) {
			plArr =s.split("\n");
			
			
			
			User u =User.getLoginedUser();
			u.setPoint(Integer.parseInt(plArr[plArr.length-1]));
			User.setLoginedUser(u);
			//User. =Integer.parseInt(plArr[plArr.length-1]);
			
		}
		
		
		
		pointList.close();
	}catch(Exception e) {
		// ����Ʈ�� �����Ǿ����� ��쿡�� ������ ������ �����Ǳ� ������
		// id���� ������ ���� ��쿡�� �޼ҵ尡 ����ǰԲ� �ϰ� ������ ����� ã�� ����
		//����  �޼ҵ尡 ������� �ʾ������� ������ ���� �ʵ��� �ּ�ó���س��� 
		
		//JOptionPane.showMessageDialog(null, "����Ʈ ��ȯ ����");
	}
		
	}
	
		public void stampCalculator() { // ������ ���� �о ����Ƚ�� ������༭ �������� ��ȯ
		
		try {
			String s;
			String[]plArr=new String[10];
			int count=0;
			//id���� ������ �д´�.
			BufferedReader pointList = new BufferedReader(new FileReader(User.getLoginedUser().getUserid()));
			// ���� �������� �迭�� ����ش�
//			while((s=pointList.readLine()) !=null) {
//				plArr =s.split("\n");
//			
//				for(int i=0;i<plArr.length;i++) {
//					if(Integer.parseInt(plArr[i])<Integer.parseInt(plArr[i+1])) {
//						count++;
//					}
//						
//				}
//			}
			
			
			
				//�յ� ����Ʈ ���� ���ؼ� ����Ʈ�� ���� ����� ������� - �ֹ�1 �̱� ������ ������ ���� �ݿ�
				//ex) ���� ����� 2�������� �ֹ��� 2�� �� ��� �̹Ƿ� ������ 2��
				//������ ������ �� �����ϰ� ���� �ʾƼ� �� ������� �α��θ��� ����ϰԲ� ������.
			for(int i=0; ;i++) {
				s = pointList.readLine();
				if(s!=null) {
					plArr[i]=s;
				}else{

					break;
				}
			}
			for(int i=0; ;i++) {
				
				if(plArr[i+1]!=null) {
					if((Integer.parseInt(plArr[i]))>(Integer.parseInt(plArr[i+1]))){
						count++;
					}
				}else{

					break;
				}
			}
			
			
			
			
			
			
			
			
			pointList.close();
			
			//����� ���������� ���� �α��ε� ��ü�� ��ȯ
			User u =User.getLoginedUser();
			u.setAccOder(count);
			User.setLoginedUser(u);
			
		}catch(Exception e) {
			
			
			// ����Ʈ�� �����Ǿ����� ��쿡�� ������ ������ �����Ǳ� ������
			// id���� ������ ���� ��쿡�� �޼ҵ尡 ����ǰԲ� �ϰ� ������ ����� ã�� ����
			//����  �޼ҵ尡 ������� �ʾ������� ������ ���� �ʵ��� �ּ�ó���س��� 
			
			//JOptionPane.showMessageDialog(null, "������ ��� ����");
		}
			
		
		
	}
}