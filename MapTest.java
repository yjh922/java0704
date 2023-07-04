package org.sp.app0704.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;

/*
 * 자바의 컬렉션 프레임웍의 객체 중 key-value의 쌍으로 데이터를 모아서
 * 처리하는 Map을 학습한다.
 * */
public class MapTest {
	
	public static void main(String[] args) {
		Map<String, JButton> map = new HashMap<String, JButton>();
		
		map.put("b1", new JButton("버튼1"));
		map.put("b2", new JButton("버튼2"));
		map.put("b3", new JButton("버튼3"));
		
		//JButton obj=map.get("b3");
		//System.out.println(obj);
		
		//Map 또한 순서가 없기 때문에 모든 요소를 반복문으로 접근하려면 무언가
		//순서있는 객체의 도움을 받아야 하는데, 이미 순서없는 집합을 잘 지원해주고
		//있는 Set을 활용해보자.
		
		//맵에 들어있는 객체들을 대상으로, 모두 추출하는 것이 아니라, key만을
		//추출하여 Set으로 담아놓는다.
		Set keys=map.keySet();
		
		//Iterator 도구를 활용하여 일렬로 늘어지게 하자
		Iterator<String> it=keys.iterator();
		while(it.hasNext()) {//다음 요소가 존재하는 동안만..
			String key=it.next();
			
			//키를 이용하여 맵에서 개체를 꺼내기
			JButton bt=map.get(key);
			System.out.println(bt.getText());
		}
	}
}
