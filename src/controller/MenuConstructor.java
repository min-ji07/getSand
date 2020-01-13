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
		bread[0] = new Bread("��� ��Ʈ", 2000);
		bread[1] = new Bread("��Ƽ", 2200);
		bread[2] = new Bread("��Ʈ", 1900);
		bread[3] = new Bread("�ĸ����������", 2400);
		bread[4] = new Bread("ȭ��Ʈ", 2200);
		bread[5] = new Bread("�÷��귡��", 2100);
	}
	
	public void addMain(Main[] main) {
		main[0] = new Main("Ǯ����ũ", 1800);
		main[1] = new Main("��Ʈ��", 1600);
		main[2] = new Main("������ũ/ġ��", 2300);
		main[3] = new Main("ġŲ�����߳�", 1900);
		main[4] = new Main("��ġ", 2000);	
		main[5] = new Main("������", 2500);
	}
	
	public void addTopping(Topping[]toppingArr) {
		toppingArr[0] = new Topping("������", 1000);
		toppingArr[1] = new Topping("���׸���", 500);
		toppingArr[2] = new Topping("�ƺ�ī��", 700);
		toppingArr[3] = new Topping("������", 900);
		toppingArr[4] = new Topping("���۷δ�", 600);
		toppingArr[5] = new Topping("����ġ��", 800);
		
	}
	
	public void addSauce(Sauce[] sauce) {
		sauce[0] = new Sauce("��ġ�巹��", 0);
		sauce[1] = new Sauce("����Ʈ��Ͼ�", 0);
		sauce[2] = new Sauce("��ϸӽ�Ÿ��", 0);
		sauce[3] = new Sauce("����Ʈĥ��", 0);
		sauce[4] = new Sauce("��ĥ��", 0);
		sauce[5] = new Sauce("��콺����Ʈ", 0);	
	}
	public void addSideMenu(SideMenu[] sideMenuArr) {
		sideMenuArr[0] = new SideMenu("������������", 1500);
		sideMenuArr[1] = new SideMenu("���׻�����", 2300);
		sideMenuArr[2] = new SideMenu("����Ĩ��Ű", 800);
		sideMenuArr[3] = new SideMenu("��������Ĩ", 1200);
		sideMenuArr[4] = new SideMenu("ź������", 500);
		sideMenuArr[5] = new SideMenu("�ؽ�����",1000);
	}
}
