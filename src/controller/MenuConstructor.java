package controller;

import java.util.ArrayList;

import model.Bread;
import model.Main;
import model.Sandwich;
import model.SideMenu;
import model.Sauce;
import model.Topping;

public class MenuConstructor {	
	public void addBread(Bread[] bread) {
		bread[0] = new Bread("허니 오트", 2000);
		bread[1] = new Bread("하티", 2200);
		bread[2] = new Bread("위트", 1900);
		bread[3] = new Bread("파마산오레가노", 2400);
		bread[4] = new Bread("화이트", 2200);
		bread[5] = new Bread("플랫브래드", 2100);
	}
	
	public void addMain(Main[] main) {
		main[0] = new Main("풀드포크", 1800);
		main[1] = new Main("미트볼", 1600);
		main[2] = new Main("스테이크/치즈", 2300);
		main[3] = new Main("치킨데리야끼", 1900);
		main[4] = new Main("참치", 2000);	
		main[5] = new Main("쉬림프", 2500);
	}
	
	public void addTopping(Topping[]toppingArr) {
		toppingArr[0] = new Topping("쉬림프", 1000);
		toppingArr[1] = new Topping("에그마요", 500);
		toppingArr[2] = new Topping("아보카도", 700);
		toppingArr[3] = new Topping("베이컨", 900);
		toppingArr[4] = new Topping("페퍼로니", 600);
		toppingArr[5] = new Topping("더블치즈", 800);
		
	}
	
	public void addSauce(Sauce[] sauce) {
		sauce[0] = new Sauce("렌치드레싱", 0);
		sauce[1] = new Sauce("스위트어니언", 0);
		sauce[2] = new Sauce("허니머스타드", 0);
		sauce[3] = new Sauce("스위트칠리", 0);
		sauce[4] = new Sauce("핫칠리", 0);
		sauce[5] = new Sauce("사우스웨스트", 0);	
	}
	public void addSideMenu(SideMenu[] sideMenuArr) {
		sideMenuArr[0] = new SideMenu("웨지포테이토", 1500);
		sideMenuArr[1] = new SideMenu("에그샐러드", 2300);
		sideMenuArr[2] = new SideMenu("초코칩쿠키", 800);
		sideMenuArr[3] = new SideMenu("포테이토칩", 1200);
		sideMenuArr[4] = new SideMenu("탄산음료", 500);
		sideMenuArr[5] = new SideMenu("해쉬브라운",1000);
	}
}
