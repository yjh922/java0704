package org.sp.app0704.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 1. 배열의 사용목적
 * 일반적으로 배열을 사용하게 되면, 메모리에 올려진 데이터에 순서를 적용할 수 있으므로,
 * 규칙을 이용한 프로그래밍에 사용된다. 또한 규칙을 이용하다 보니 반복문과 친숙하다.
 * 
 * 2.선언상 특징
 * 	1) 반드시 생성할 때 그 크기를 명시해야 한다.
 * 2) 이미 정해진 크기는 변경될 수 없다.
 * 결론) 유연한 처리를 하기엔 불리함
 * 
 * 3. 해결책
 * java의 Collection Framework을 이용하면, 배열보다 더욱 다양하면서 유연한
 * 객체를 모아서 처리하는 기술을 지원해줌
 * 
 * 4.Collection Framework
 * -객체를 모아서 처리할 때 유용한 기능을 지원하는 기술이며, 자바에서는 java.util
 *  패키지에서 지원함
 * */

public class Test1 extends JFrame implements ActionListener{
	
	JPanel p_north;
	JButton bt_create;
	JButton bt_bg;
	JPanel p_center;
	int n;
	//js는 배열의 크기가 동적으로 변할수 있지만, 일반적인 프로그래밍 언어(c,c#...)에서는
	//배열은 최초 생성시 그 크기가 고정된다.. 또한 반드시 사용전에는 크기가 정해져 있어야 한다.
	//JButton[] btArray;
	ArrayList<JButton> btArray;
	
	public Test1() {
		p_north = new JPanel();
		bt_create = new JButton("버튼생성");
		bt_bg = new JButton("색상적용");
		p_center = new JPanel();
		p_center.setBackground(Color.blue);
		
		btArray =new ArrayList<JButton>();//버튼을 10개 담을 수 있는 크기의 배열선언
		//주의) 버튼을 10개 생성한 것이 아니라, 장차 버튼 10개가 들어갈 공간을 확보
		//결론 ) 버튼이 아직 만들어진 적이 없다.
		
		//북쪽 패널에 버튼2개 추가
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		add(p_north, BorderLayout.NORTH);//패널을 북쪽에 추가
		
		add(p_center, BorderLayout.CENTER);//센터에 패널 추가
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//버튼과 리스너 연결
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
		
	}
	
	public void createButton() {
		JButton bt = new JButton("버튼"+n);
		btArray.add(bt);
		System.out.println("현재까지 채워진 버튼 수는"+btArray.size());
		
		p_center.add(bt);
		
		//java로 하여금 현재 화면을 갱신, 컴포넌트 새로고침
		p_center.updateUI();
		//n++;
	}
	
	//현재 화면에 생성되어 있는 버튼들의 색상을 노란색으로 바꾸자
	//그 수가 많으므로 for문으로 처리해보자.
	public void setBg() {
		//첫번째 버튼의 색상 변경
		for(int i=0; i<btArray.size();i++) {
			JButton obj=btArray.get(i);
			obj.setBackground(Color.yellow);
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		//어떤 버튼이 눌렸는지에 따라서 구현 내용이 틀려져야 한다
		if(e.getSource()==bt_create) {
			createButton();
		
		}else {
			setBg();
		}
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
