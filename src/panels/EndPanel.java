package panels;

import main.listenAdapter;
import panels.Endings.Ending;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;
import main.listenAdapter;
import panels.Endings.Ending;

public class EndPanel extends JPanel {

	Endings e;
	ImageIcon retryBtn = new ImageIcon("img/end/restart-btn.png"); // 다시 시작 버튼
	ImageIcon homeBtn = new ImageIcon("img/end/collection-btn.png"); // 엔딩 모음 이동 버튼
	JButton retryButton;
	JButton homeButton;
	JLabel endLabel;
	JLabel scoreViewLabel;
	JLabel scoreLabel;
	JLabel imageLabel;
	JLabel cookieNameLabel;
	JLabel cookieImageLabel;
	JLabel newCookieLabel;
	JLabel exerciseCoinLabel;
	JLabel exerciseNumberLabel;
	JLabel gameCoinLabel;
	JLabel gameNumberLabel;
	JLabel studyCoinLabel;
	JLabel studyNumberLabel;
	JLabel artCoinLabel;
	JLabel artNumberLabel;
	JLabel contextLabel;

	private ImageIcon[] images = new ImageIcon[Endings.count];
	// private int resultScore;

	// 폰트 로딩 함수
	private Font loadCustomFont(String fontPath, float fontSize) {
		try {
			File fontFile = new File(fontPath);
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(fontSize);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			return font;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return new Font("Arial", Font.BOLD, 24); // 예외가 발생하면 기본 폰트 반환
		}
	}

	public EndPanel(Object o, Endings endings) {

		// 레이아웃을 수동으로 관리
		this.e = endings;
		setLayout(null);

		// 폰트
		Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 24f);
		Font cookieRunRegular = loadCustomFont("fonts/CookieRun Regular.otf", 12f);

		// 이미지 초기화
		for (int i = 0; i < e.endings.length; i++) {
			String imagePath = e.endings[i].imagePath; // 이미지 경로
			ImageIcon cookieIcon = new ImageIcon(imagePath);
			Image cookieImage = cookieIcon.getImage();
			images[i] = new ImageIcon(cookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
		}

		// Ending endings;
		// 새로운 쿠키일때
		newCookieLabel = new JLabel("");
		newCookieLabel.setFont(cookieRunBlack);
		newCookieLabel.setBounds(80, 60, 400, 87);
		newCookieLabel.setForeground(Color.RED);
		add(newCookieLabel);
		// 쿠키 이름 라벨
		cookieNameLabel = new JLabel("");
		cookieNameLabel.setFont(cookieRunBlack);
		cookieNameLabel.setBounds(115, 100, 400, 87);
		add(cookieNameLabel);

//		//쿠키 이미지 라벨
		cookieImageLabel = new JLabel();
		cookieImageLabel.setBounds(100, 150, 200, 200); // 위치와 크기 조정
		add(cookieImageLabel);
		// 운동 코인
		ImageIcon exerciseIcon = new ImageIcon("img/end/exercise.png");
		Image exerciseImage = exerciseIcon.getImage();
		Image resizeExerciseImage = exerciseImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
		exerciseCoinLabel = new JLabel(new ImageIcon(resizeExerciseImage));
		exerciseCoinLabel.setBounds(405, 140, 67, 68);
		add(exerciseCoinLabel);
		// 운동 코인 수
		exerciseNumberLabel = new JLabel();
		exerciseNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		exerciseNumberLabel.setBounds(485, 135, 300, 80);
		add(exerciseNumberLabel);
		// 게임 코인
		ImageIcon gameIcon = new ImageIcon("img/end/game.png");
		Image gameImage = gameIcon.getImage();
		Image resizeGameImage = gameImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
		gameCoinLabel = new JLabel(new ImageIcon(resizeGameImage));
		gameCoinLabel.setBounds(570, 140, 67, 68);
		add(gameCoinLabel);
		// 게임 코인 수
		gameNumberLabel = new JLabel();
		gameNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		gameNumberLabel.setBounds(660, 135, 300, 80);
		add(gameNumberLabel);
		// 예술 코인
		ImageIcon artIcon = new ImageIcon("img/end/art.png");
		Image artImage = artIcon.getImage();
		Image resizeArtImage = artImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
		artCoinLabel = new JLabel(new ImageIcon(resizeArtImage));
		artCoinLabel.setBounds(405, 225, 67, 68);
		add(artCoinLabel);
		// 예술 코인 수
		artNumberLabel = new JLabel();
		artNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		artNumberLabel.setBounds(485, 220, 300, 80);
		add(artNumberLabel);
		// 공부 코인
		ImageIcon studyIcon = new ImageIcon("img/end/study.png");
		Image studyImage = studyIcon.getImage();
		Image resizeStudyImage = studyImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
		studyCoinLabel = new JLabel(new ImageIcon(resizeStudyImage));
		studyCoinLabel.setBounds(570, 225, 67, 68);
		add(studyCoinLabel);
		// 공부 코인 수
		studyNumberLabel = new JLabel();
		studyNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		studyNumberLabel.setBounds(660, 220, 300, 80);
		add(studyNumberLabel);
		// 쿠키 설명
		contextLabel = new JLabel();
		contextLabel.setFont(cookieRunRegular);
		contextLabel.setBounds(35, 370, 350, 80);
		contextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contextLabel.setVerticalAlignment(SwingConstants.CENTER);
		add(contextLabel);
		// 다시 시작 버튼
		retryButton = new JButton(retryBtn);
		retryButton.setName("endAccept");
		retryButton.addMouseListener((MouseListener) o);
		retryButton.setBounds(560, 350, 220, 70);
		retryButton.setBorderPainted(false);
		retryButton.setFocusPainted(false);
		retryButton.setContentAreaFilled(false);
		add(retryButton);

		// 엔딩 모음 이동 버튼
		homeButton = new JButton(homeBtn);
		homeButton.setName("EndArchiveBtn");
		homeButton.addMouseListener((MouseListener) o);
		homeButton.setBounds(360, 350, 220, 70);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		homeButton.setContentAreaFilled(false);
		add(homeButton);

		// End 라벨
		endLabel = new JLabel("The ends...");
		endLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 50));
		endLabel.setBounds(31, 10, 400, 55);
		add(endLabel);

		// Score 라벨
		scoreViewLabel = new JLabel("score");
		scoreViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreViewLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 49));
		scoreViewLabel.setBounds(360, 60, 400, 87);
		add(scoreViewLabel);

		// 엔딩 배경 이미지 (가장 마지막에 추가하여 가장 뒤에 표시되도록 함)
		ImageIcon backIcon = new ImageIcon("img/end/ending-bk.png");
		Image backImage = backIcon.getImage();
		Image resizeBackImage = backImage.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
		imageLabel = new JLabel(new ImageIcon(resizeBackImage));
		imageLabel.setBounds(0, 0, 800, 500);
		add(imageLabel);

	}

    public int setResultScore(int artCoin, int exerciseCoin , int studyCoin, int gameCoin) {
//    	코인 수 표시
    	exerciseNumberLabel.setText(Integer.toString(exerciseCoin));
    	studyNumberLabel.setText(Integer.toString(studyCoin));
    	gameNumberLabel.setText(Integer.toString(gameCoin));
        artNumberLabel.setText(Integer.toString(artCoin));  
    	int index;
      	// 코인 수에 따라 이름과 이미지, 설명 설정
      	//종합 코인 (공부+예술+게임+운동) - 옥황상제 엔딩
       	if(studyCoin >= 180 && gameCoin >= 30 && artCoin >= 180 && exerciseCoin >= 180) {
       	 index = 0;
      	}

      // 교수 엔딩
       	else if(studyCoin >= 180 && studyCoin >= artCoin && studyCoin > exerciseCoin) {
      	    index = 3;
      	}
      // 의사엔딩
//       	else if() {
//      	    index = 4;
//      	}
      // 프로그래머엔딩
       	else if(studyCoin >= 130 && studyCoin >= artCoin && studyCoin > exerciseCoin) {
       		index = 4;
      	}
	        // 프로게이머엔딩
	       	else if(studyCoin >= 130 && gameCoin >= 60 && artCoin < 50 && exerciseCoin < 50) {
	       		index = 5;
	      	}
        // 가수 엔딩
       	else if(artCoin >= 180 && exerciseCoin >= 180 && gameCoin < 50 && studyCoin < 50) {
       		index = 8;
      	}
      	//피아니스트 엔딩
       	else if(artCoin >= 180 && artCoin >= exerciseCoin && artCoin > studyCoin) {
      	    index = 1;
      	}
      // 화가 엔딩
       	else if(artCoin >= 130 && artCoin >= exerciseCoin && artCoin > studyCoin) {
      	    index = 2;
      	    
      	}
        // 국가대표 엔딩
       	else if(exerciseCoin >= 180 && exerciseCoin >= artCoin && exerciseCoin > studyCoin) {
       		index = 7;
      	}
        // 아마추어 엔딩
       	else if(exerciseCoin >= 130 && exerciseCoin >= artCoin && exerciseCoin > studyCoin) {
      	    index = 6;
      	}
//        // 운동선수 엔딩
//       	else if() {
//      	    index = 9;
//      	}

//        // 요기사 엔딩
//       	else if() {
//      	    index = 12;
//      	}
       	
      
       	// 백수 엔딩
      	else index = 9;
  	    setLabel(index);
          //코인 수 업데이트
          
          // 변경 사항 반영
          revalidate();
          repaint();
          return index;
    }


	public void setLabel(int index) {
		cookieNameLabel.setText(e.endings[index].name);
		contextLabel.setText(e.endings[index].description);
		cookieImageLabel.setIcon(images[index]);
//	    	new 라벨 갱신
			if (DB.getIsNew(index)) {
				newCookieLabel.setText("new");
				DB.changeIsNew(index);
			} else
				newCookieLabel.setText("");
	}

//    이미지 사이즈 조정
	public ImageIcon resizeImage(int index) {
		ImageIcon ii = new ImageIcon(e.endings[index].imagePath);
		Image i = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		return new ImageIcon(i);
	}
}