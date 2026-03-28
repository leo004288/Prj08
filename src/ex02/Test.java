package ex02;

import java.time.LocalDateTime;
import java.util.Scanner;
//입력 1줄 -> 결과 1줄
//입력data : 사번,이름,입사일,월급,부서번호
//출력     : 사번,이름,입사일,월급,보너스,수령액,부서명

//금액은 소수이하 두자리로 반올림
//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
//수령액   =  월급 + 보너스
//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스

//모든기능은 class에 구현한다.
//입력data
//사번,이름,입사일,월급,부서번호
/*
100,사나,20110101,300.0,10      
200,모모,20120301,270.0,20      
300,정연,20091003,250.0,30      
400,나연,20110105,220.0,40      
500,미나,20180401,170.0,60      
600,쯔위,20150801,200.0,50      
*/

interface Ipo {
	void input();
	void process();
	void output();	
}

class Company {
//	 field
	private int    num;
	private String name;
	private String date;
	private double money;
	private String id;
	
	private double bouns;
	private double rmoney;
	private String iname;
	
	
//	constructor
	public Company(int num, String name, String date, double money, String id) {
		this.num = num;
		this.name = name;
		this.date = date;
		this.money = money;
		this.id = id;
//		this.bouns = bouns;	
//		this.rmoney = rmoney;
//		this.iname = iname;
		}
		
//	method
	@Override
	public String toString() {
		return "Company [num=" + num + ", name=" + name + ", date=" + date + ", money=" + money + ", id=" + id
				+ ", bouns=" + bouns + ", rmoney=" + rmoney + ", iname=" + iname + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}

	public double getRmoney() {
		return rmoney;
	}

	public void setRmoney(double rmoney) {
		this.rmoney = rmoney;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}
	
	
} //


class Comp implements Ipo {

	private Company c;
	
	@Override
	public void input() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("입력data:사번,이름,입사일,월급,부서번호");
		String line  = in.nextLine();
		String [] li = line.trim().split(",");
		int    num   = Integer.parseInt(li[0].trim());
		String name  = li[1].trim();
		String date  = (li[2].trim());
		double money = Double.parseDouble(li[3].trim());
		String id    = li[4].trim();
		
		c			  = new Company( num, name, date, money, id);
	}

	@Override
	public void process() {
		int year  = Integer.parseInt(c.getDate().substring(0,4));
		int tYear = LocalDateTime.now().getYear();
		int wYear = tYear - year;
		
		double bouns = c.getMoney() * (wYear * 0.005);
		c.setBouns(bouns);
		
		c.setRmoney(c.getMoney() + bouns);
		
		String id    = c.getId();
		String iname = "";
		switch (id) {
		case "10": iname = "인사"; break;
		case "20": iname = "자재"; break;
		case "30": iname = "총무"; break;
		case "40": iname = "연구개발"; break;
		case "50": iname = "생산"; break;
		case "60": iname = "서비스"; break;
		}
		c.setIname(iname);
	}

	@Override
	public void output() {
		System.out.println(c);
		String title = "사번,이름,입사일,월급,보너스,수령액,부서명";
		String fmt   = "%d, %s, %s, %.2f, %.2f, %.2f, %s";	
		
		System.out.println(title);
		System.out.printf(fmt,
				c.getNum(), c.getName(), c.getDate(), c.getMoney(), c.getBouns(), c.getRmoney(), c.getIname());
	}
	
} //

public class Test {

	public static void main(String[] args) {
		Comp c = new Comp();
		c.input();
		c.process();
		c.output();
		
	} // 

} //
