package panels;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Endings {
	

	public static int count = 13;		

	public Ending[] endings = new Ending[count];

	public Endings() {
		endings[0] = new Ending("옥황상제", "코인 모으기에 신이 된 쿠키, 옥황상제로 거듭나다!"); 
		endings[1] = new Ending("피아니스트", "뛰어난 예술가 쿠키, 사람들에게 감동을 주는 피아니스트가 되다!");
		endings[2] = new Ending("화가", "뛰어난 그림 실력을 가진 쿠키, 화가가 되다!");
		endings[3] = new Ending("교수", "공부광 쿠키, 자신의 지식으로 세상을 이롭게 바꿀 교수가 되다!");
		endings[4] = new Ending("의사", "의사 설명");
		endings[5] = new Ending("프로그래머", "공부를 열심히 한 쿠키, 프로그래머가 되다!");
		endings[6] = new Ending("프로게이머", "게임의 재능을 가진 쿠키..프로게이머가 되어 억대 연봉을 받다…");
		endings[7] = new Ending("가수", "가수 설명");
		endings[8] = new Ending("아마추어 운동선수", "운동에 흥미를 느낀 쿠키, 아마추어 운동선수가 되다!");
		endings[9] = new Ending("운동선수", "운동선수 설명");
		endings[10] = new Ending("국가대표", "상위 0.1%의 운동선수가 되어 국가대표로서의 자격을 얻다!");
		endings[11] = new Ending("백수", "어릴적부터 하고 싶은게 많았던 쿠키, 하지만 그것은 오래가지 못했다..");
		endings[12] = new Ending("요리사", "예술과 운동 두 분야에서 모두 뛰어난 쿠키..요리사가 되다!");
	}

	public class Ending{
		String name;
		String imagePath;
		String description;
		ImageIcon imageicon;
		public Ending(String n, String des) {
			name = n;
			imagePath = "img/endings/"+ n +".png";
			description = des;
	
		}
	}
	
}
