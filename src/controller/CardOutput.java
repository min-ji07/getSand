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
   // 카드번호 출력하는 메소드 - 데이터 파일로 저장 후 카드번호가 변동되는 메소드 마다 실행시켜줄것
   public void cardWriter(String cardNumber) {      		// 카드번호 불러올때 String 값으로 불러오기?
      try {
         File file = new File(User.getLoginedUser().getUserName()); 
         													// 근데 카드번호가 0으로 등록되어있는걸 가져오느것? -- 닉네임 가져오는거로 변경함( 닉네임 명의 파일을 만들음)
         BufferedWriter cardList = new BufferedWriter(new FileWriter(file,true));
         cardList.write(cardNumber); 						// 카드 리스트 파일에 (카드번호쓰고 공백)을 씀
         cardList.newLine();							// 카드등록할때마다 밑으로 내려가는것 ( 한줄쓰고 내려가는 것)
         cardList.close();
         //JOptionPane.showMessageDialog(null, "카드번호가 저장 되었습니다.");
      }catch(Exception e) {
         JOptionPane.showMessageDialog(null, "카드번호 저장 실패");
      }
   }
   
   // 카드번호 읽어오는 메소드
   public void Cardgetter() {
      try {
         String str;   												// String 배열 str 선언
         String[] plArr;
         String cardNum = "";
         BufferedReader cardList = new BufferedReader(new FileReader(User.getLoginedUser().getUserName()));
         while((str = cardList.readLine()) != null) { 				// 변수 str에 카드리스트 라인에서 불러온걸 넣어줌
            plArr = str.split("\n");       							//문자열 구분함수,split() 함수의 인수로  구분자가 넘어가며 데이터가 없어도 배열에 담아둠
            User u = User.getLoginedUser();   						// user에서 회원정보를 가져와서 u에 담기
            u.setCardNumber(plArr[plArr.length-1]);					// 배열이 만약 4라면 0~3번방까지 있기떄문에 length에서 -1을 해줌
            User.setLoginedUser(u);
         }
         cardList.close();
      }catch(Exception e) {
         //JOptionPane.showMessageDialog(null, "카드번호 연동 실패");
         //e.printStackTrace();
      }
   }
   
}
/*split 함수 https://mainia.tistory.com/3950
 * Integer.parseInt - String 에서 int 로 형변환 해주는 메소드
 * */