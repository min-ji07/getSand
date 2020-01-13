package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import model.User;

public class CardOutput {
   public CardOutput() {

   }
   // ī���ȣ ����ϴ� �޼ҵ� - ������ ���Ϸ� ���� �� ī���ȣ�� �����Ǵ� �޼ҵ� ���� ��������ٰ�
   public void cardWriter(String cardNumber) {      		// ī���ȣ �ҷ��ö� String ������ �ҷ�����?
      try {
         File file = new File(User.getLoginedUser().getUserName()); 
         													// �ٵ� ī���ȣ�� 0���� ��ϵǾ��ִ°� ����������? -- �г��� �������°ŷ� ������( �г��� ���� ������ ������)
         BufferedWriter cardList = new BufferedWriter(new FileWriter(file,true));
         cardList.write(cardNumber); 						// ī�� ����Ʈ ���Ͽ� (ī���ȣ���� ����)�� ��
         cardList.newLine();							// ī�����Ҷ����� ������ �������°� ( ���پ��� �������� ��)
         cardList.close();
         //JOptionPane.showMessageDialog(null, "ī���ȣ�� ���� �Ǿ����ϴ�.");
      }catch(Exception e) {
         JOptionPane.showMessageDialog(null, "ī���ȣ ���� ����");
      }
   }
   
   // ī���ȣ �о���� �޼ҵ�
   public void Cardgetter() {
      try {
         String str;   												// String �迭 str ����
         String[] plArr;
         String cardNum = "";
         BufferedReader cardList = new BufferedReader(new FileReader(User.getLoginedUser().getUserName()));
         while((str = cardList.readLine()) != null) { 				// ���� str�� ī�帮��Ʈ ���ο��� �ҷ��°� �־���
            plArr = str.split("\n");       							//���ڿ� �����Լ�,split() �Լ��� �μ���  �����ڰ� �Ѿ�� �����Ͱ� ��� �迭�� ��Ƶ�
            User u = User.getLoginedUser();   						// user���� ȸ�������� �����ͼ� u�� ���
            u.setCardNumber(plArr[plArr.length-1]);					// �迭�� ���� 4��� 0~3������� �ֱ⋚���� length���� -1�� ����
            User.setLoginedUser(u);
         }
         cardList.close();
      }catch(Exception e) {
         //JOptionPane.showMessageDialog(null, "ī���ȣ ���� ����");
         //e.printStackTrace();
      }
   }
   
}
/*split �Լ� https://mainia.tistory.com/3950
 * Integer.parseInt - String ���� int �� ����ȯ ���ִ� �޼ҵ�
 * */