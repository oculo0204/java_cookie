package panels;

public class Endings {
	public class Ending{
		String name;
		String imagePath;
		String description;
		boolean isNew;
		
		public Ending(String n, String des) {
			name = n;
			imagePath = "img/endings/"+" n "+".png";
			description = des;
			isNew = true;
		}
	}
	
	Ending 옥황상제 = new Ending("옥황상제", "옥황상제 설명");
	Ending 피아니스트 = new Ending("피아니스트", "피아니스트 설명");
	Ending 화가 = new Ending("화가", "화가 설명");
	Ending 교수 = new Ending("교수", "교수 설명");
	Ending 의사 = new Ending("의사", "의사 설명");
	Ending 프로그래머 = new Ending("프로그래머", "프로그래머 설명");
	Ending 프로게이머 = new Ending("프로게이머", "프로게이머 설명");
	Ending 가수 = new Ending("가수", "가수 설명");
	Ending 아마추어 = new Ending("아마추어 운동선수", "아마추어 운동선수 설명");
	Ending 운동선수 = new Ending("운동선수", "운동선수 설명");
	Ending 국가대표 = new Ending("국가대표", "국가대표 설명");
	Ending 백수 = new Ending("백수", "백수 설명");
	Ending 요리사 = new Ending("요리사", "요리사 설명");
	
	
}
