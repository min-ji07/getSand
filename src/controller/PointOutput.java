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
	//포인트 출력하는 메소드  , 포인트 데이터파일로 저장해줌 -> 포인트 변동되는 메소드마다 실행시켜줄것 , 그래야 스탬프 계산해올수 있음
	public void pointWriter(int point) {

		try { // id 명의 데이터 파일 생성해서 현재 포인트를 저장해준다. 충전,사용시 꼭 실행해주어야함
			File file = new File(User.getLoginedUser().getUserid());

			BufferedWriter pointList = new BufferedWriter(new FileWriter(file,true));
			pointList.write(point+"\n");
			pointList.close();
			
			
			//JOptionPane.showMessageDialog(null, "충전되었습니다.");  //충전 확인용 , 완성시 주석처리할것
		}catch(Exception e1) {   

			JOptionPane.showMessageDialog(null, "포인트 저장 실패");
		}

	}
	// 포인트 읽어오는 메소드
	public void Pointgetter(String Userid) {
		
		
	try{
		

		String s ;
		String[] plArr;
		//id명의 파일을 읽어옴 
		BufferedReader pointList = new BufferedReader(new FileReader(User.getLoginedUser().getUserid()));
		
		//  엔터 기준으로 배열에 담아주고 제일 마지막줄만 static 객체 포인트에 반환해줌
		while((s=pointList.readLine()) !=null) {
			plArr =s.split("\n");
			
			
			
			User u =User.getLoginedUser();
			u.setPoint(Integer.parseInt(plArr[plArr.length-1]));
			User.setLoginedUser(u);
			//User. =Integer.parseInt(plArr[plArr.length-1]);
			
		}
		
		
		
		pointList.close();
	}catch(Exception e) {
		// 포인트가 충전되어있을 경우에만 데이터 파일이 생성되기 때문에
		// id명의 파일이 있을 경우에만 메소드가 실행되게끔 하고 싶은데 방법을 찾지 못함
		//따라서  메소드가 실행되지 않았음에도 오류가 뜨지 않도록 주석처리해놓음 
		
		//JOptionPane.showMessageDialog(null, "포인트 소환 실패");
	}
		
	}
	
		public void stampCalculator() { // 데이터 파일 읽어서 결제횟수 계산해줘서 스탬프로 반환
		
		try {
			String s;
			String[]plArr=new String[10];
			int count=0;
			//id명의 파일을 읽는다.
			BufferedReader pointList = new BufferedReader(new FileReader(User.getLoginedUser().getUserid()));
			// 엔터 기준으로 배열에 담아준다
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
			
			
			
				//앞뒤 포인트 값을 비교해서 포인트가 깎인 기록이 있을경우 - 주문1 이기 때문에 스탬프 값에 반영
				//ex) 깎인 기록이 2번있으면 주문을 2번 한 경우 이므로 스탬프 2개
				//데이터 파일을 또 생성하고 싶지 않아서 위 방법으로 로그인마다 계산하게끔 구현함.
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
			
			//계산한 스탬프값을 상위 로그인된 객체에 반환
			User u =User.getLoginedUser();
			u.setAccOder(count);
			User.setLoginedUser(u);
			
		}catch(Exception e) {
			
			
			// 포인트가 충전되어있을 경우에만 데이터 파일이 생성되기 때문에
			// id명의 파일이 있을 경우에만 메소드가 실행되게끔 하고 싶은데 방법을 찾지 못함
			//따라서  메소드가 실행되지 않았음에도 오류가 뜨지 않도록 주석처리해놓음 
			
			//JOptionPane.showMessageDialog(null, "스탬프 계산 실패");
		}
			
		
		
	}
}