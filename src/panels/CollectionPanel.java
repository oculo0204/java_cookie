package test;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CollectionPanel extends JPanel {
	
//	엔딩 이름과 사진을 각각 하나씩 포함하는 flowlayout의 패널
	public class collection extends JPanel{
		JLabel name = new JLabel();
		JLabel image = new JLabel();
		Boolean isNew;
		
		public collection(String ImagePath, String name){
			ImageIcon imgIcon = new ImageIcon(ImagePath);
			Image img = imgIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			
			image.setIcon(new ImageIcon(img));
			this.name.setText(name);
			isNew = false;
			
			FlowLayout fl = new FlowLayout();
			setLayout(fl);
			add(this.name);
			add(image);
		}
	}
	
	
//	돌아가기 버튼과 수집목록(Collections)패널, 스크롤바를 포함하는 패널
	public CollectionPanel () {
		setLayout(null);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.white);
		
//		collections: collection개체를 포함하는 GridLayout 패널
		JPanel collections = new JPanel();
		GridLayout  gl = new GridLayout(4,4);
		collections.setLayout(gl);
		
		collection[] collectionArray = new collection[13];
		
		collectionArray[0] = new collection("img/end/1.png", "옥황상제");
		collectionArray[1] = new collection("img/end/2.png", "피아니스트");
		collectionArray[2] = new collection("img/end/3.png", "화가");
		collectionArray[3] = new collection("img/end/4.png", "아마추어 운동선수");
		collectionArray[4] = new collection("img/end/5.png", "운동선수");
		collectionArray[5] = new collection("img/end/6.png", "국가대표 운동선수");
		collectionArray[6] = new collection("img/end/7.png", "가수");
		collectionArray[7] = new collection("img/end/8.png", "프로그래머");
		collectionArray[8] = new collection("img/end/9.png", "요리사");
		collectionArray[9] = new collection("img/end/10.png", "백수");
		collectionArray[10] = new collection("img/end/11.png", "프로게이머");
		collectionArray[11] = new collection("img/end/12.png", "교수");
		collectionArray[12] = new collection("img/end/13.png", "의사");
		
		for(int i = 0; i < 13; i++) {
			collections.add(collectionArray[i]);
		}

//		isNew값이 true면 항목이 보이지않게 함
		for(int i = 0; i < 13; i++) {
			collections.add(collectionArray[i]);
			if(collectionArray[i].isNew) {
				collectionArray[i].setVisible(false);
			}
		}
		
		collections.setBounds(100,50,600,600);
		
//		돌아가기 버튼
		add(collections);
		Button back = new Button("←");
		back.setBounds(0,0,50,50);
		add(back);
	}
}
