package panels;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Endings {
	

	public static int count = 13;		

	public Ending[] endings = new Ending[count];

	public Endings() {
		endings[0] = new Ending("옥황상제", "옥황상제 설명");
		endings[1] = new Ending("피아니스트", "피아니스트 설명");
		endings[2] = new Ending("화가", "화가 설명");
		endings[3] = new Ending("교수", "교수 설명");
		endings[4] = new Ending("의사", "의사 설명");
		endings[5] = new Ending("프로그래머", "프로그래머 설명");
		endings[6] = new Ending("프로게이머", "프로게이머 설명");
		endings[7] = new Ending("가수", "가수 설명");
		endings[8] = new Ending("아마추어 운동선수", "아마추어 운동선수 설명");
		endings[9] = new Ending("운동선수", "운동선수 설명");
		endings[10] = new Ending("국가대표", "국가대표 설명");
		endings[11] = new Ending("백수", "백수 설명");
		endings[12] = new Ending("요리사", "요리사 설명");
	}

	
	public class Ending{
		String name;
		String imagePath;
		String description;
		ImageIcon imageicon;
		public boolean isNew;
		
		public Ending(String n, String des) {
			name = n;
			imagePath = "img/endings/"+ n +".png";
			description = des;
			isNew = true;

			//ImageIcon img = new ImageIcon("imagePath");
			//imageicon = new ImageIcon(img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		}
	}
	
}
