package panels;

import main.listenAdapter;
import panels.Endings.Ending;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;

import main.listenAdapter;


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
    private Image resizeKingCookieImage;
    private Image resizeProfessorCookieImage;
    private Image resizeProgrammerCookieImage;
    private Image resizePianistCookieImage;
    private Image resizePainterCookieImage;
    private Image resizeNationalCookieImage;
    private Image resizeAthleteCookieImage;
    private Image resizeProgammerCookieImage;
    private Image resizeCookerCookieImage;
    private Image resizeBacksuCookieImage;
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
        
        //폰트
        Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 24f);
        Font cookieRunRegular = loadCustomFont("fonts/CookieRun Regular.otf", 12f);
        
        //Ending endings;
        //새로운 쿠키일때 
        newCookieLabel = new JLabel("");
        newCookieLabel.setFont(cookieRunBlack);
        newCookieLabel.setBounds(80, 60, 400, 87);
        newCookieLabel.setForeground(Color.RED);
        add(newCookieLabel);
        // 쿠키 이름 라벨
        cookieNameLabel = new JLabel("");
        cookieNameLabel.setFont(cookieRunBlack);
        cookieNameLabel.setBounds(145, 90, 400, 87);
        add(cookieNameLabel);
        
        // 옥황상제 쿠키 이미지 얻기
    	ImageIcon king_cookie = new ImageIcon(e.endings[0].imagePath);
    	Image kingCookieImage = king_cookie.getImage();
		resizeKingCookieImage = kingCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        // 교수 쿠키 이미지 얻기
    	ImageIcon professor_cookie = new ImageIcon(e.endings[3].imagePath);
    	Image professorCookieImage = professor_cookie.getImage();
		resizeProfessorCookieImage = professorCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 프로그래머 쿠키 이미지 얻기
	 	ImageIcon programmer_cookie = new ImageIcon(e.endings[5].imagePath);
    	Image programmerCookieImage = programmer_cookie.getImage();
		resizeProgrammerCookieImage = programmerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 피아니스트 쿠키 이미지 얻기
		ImageIcon pianist_cookie = new ImageIcon(e.endings[1].imagePath);
    	Image pianistCookieImage = pianist_cookie.getImage();
		resizePianistCookieImage = pianistCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 화가 쿠키 이미지 얻기
		ImageIcon painter_cookie = new ImageIcon(e.endings[2].imagePath);
    	Image painterCookieImage = painter_cookie.getImage();
		resizePainterCookieImage = painterCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 국가대표 쿠키 이미지 얻기
		ImageIcon national_cookie = new ImageIcon(e.endings[10].imagePath);
    	Image nationalCookieImage = national_cookie.getImage();
		resizeNationalCookieImage = nationalCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 운동선수 쿠키 이미지 얻기
		ImageIcon athlete_cookie = new ImageIcon(e.endings[8].imagePath);
    	Image athleteCookieImage = athlete_cookie.getImage();
		resizeAthleteCookieImage = athleteCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 프로게이머 쿠키 이미지 얻기
		ImageIcon progammer_cookie = new ImageIcon(e.endings[6].imagePath);
    	Image progammerCookieImage = progammer_cookie.getImage();
		resizeProgammerCookieImage = progammerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 요리사 쿠키 이미지 얻기
		ImageIcon cooker_cookie = new ImageIcon(e.endings[12].imagePath);
    	Image cookerCookieImage = cooker_cookie.getImage();
		resizeCookerCookieImage = cookerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 백수 쿠키 이미지 얻기
		ImageIcon backsu_cookie = new ImageIcon(e.endings[11].imagePath);
		Image backsuCookieImage = backsu_cookie.getImage();
		resizeBacksuCookieImage = backsuCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		//쿠키 이미지 라벨
        cookieImageLabel = new JLabel();
        cookieImageLabel.setBounds(100, 150, 200, 200); // 위치와 크기 조정
        add(cookieImageLabel);
        //운동 코인
        ImageIcon exerciseIcon = new ImageIcon("img/end/exercise.png");
        Image exerciseImage = exerciseIcon.getImage();
        Image resizeExerciseImage = exerciseImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        exerciseCoinLabel = new JLabel(new ImageIcon(resizeExerciseImage));
        exerciseCoinLabel.setBounds(405, 140, 67, 68);
        add(exerciseCoinLabel);
        //운동 코인 수
        exerciseNumberLabel = new JLabel();
        exerciseNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        exerciseNumberLabel.setBounds(485, 135, 300, 80);
        add(exerciseNumberLabel);
        //게임 코인
        ImageIcon gameIcon = new ImageIcon("img/end/game.png");
        Image gameImage = gameIcon.getImage();
        Image resizeGameImage = gameImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        gameCoinLabel = new JLabel(new ImageIcon(resizeGameImage));
        gameCoinLabel.setBounds(570, 140, 67, 68);
        add(gameCoinLabel);
        //게임 코인 수
        gameNumberLabel = new JLabel();
        gameNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        gameNumberLabel.setBounds(660, 135, 300, 80);
        add(gameNumberLabel);
        //예술 코인
        ImageIcon artIcon = new ImageIcon("img/end/art.png");
        Image artImage = artIcon.getImage();
        Image resizeArtImage = artImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        artCoinLabel = new JLabel(new ImageIcon(resizeArtImage));
        artCoinLabel.setBounds(405, 225, 67, 68);
        add(artCoinLabel);
        //예술 코인 수
        artNumberLabel = new JLabel();
        artNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        artNumberLabel.setBounds(485, 220, 300, 80);
        add(artNumberLabel);
        //공부 코인
        ImageIcon studyIcon = new ImageIcon("img/end/study.png");
        Image studyImage = studyIcon.getImage();
        Image resizeStudyImage = studyImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        studyCoinLabel = new JLabel(new ImageIcon(resizeStudyImage));
        studyCoinLabel.setBounds(570, 225, 67, 68);
        add(studyCoinLabel);
        //공부 코인 수
        studyNumberLabel = new JLabel();
        studyNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        studyNumberLabel.setBounds(660, 220, 300, 80);
        add(studyNumberLabel);
        //쿠키 설명
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

        /*
        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 49));
        scoreLabel.setBounds(413, 52, 459, 87);
        add(scoreLabel);*/

        // 엔딩 배경 이미지 (가장 마지막에 추가하여 가장 뒤에 표시되도록 함)
        ImageIcon backIcon = new ImageIcon("img/end/ending-bk.png");
        Image backImage = backIcon.getImage();
        Image resizeBackImage = backImage.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(resizeBackImage));
        imageLabel.setBounds(0, 0, 800, 500);
        add(imageLabel);
    }

    public void setResultScore(int artCoin, int exerciseCoin , int studyCoin, int gameCoin) {
        // 코인 수에 따라 이름과 이미지, 설명 설정
    	//종합 코인 (공부+예술+게임+운동) - 옥황상제 엔딩
     	if(studyCoin >= 100 && gameCoin >= 50 && artCoin >= 100 && exerciseCoin >= 100) {
    		cookieNameLabel.setText(e.endings[0].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeKingCookieImage));
    	    contextLabel.setText(e.endings[0].description);
    	    //새로 얻은 쿠키인지 확인
    	    if(e.endings[0].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[0].isNew =false;
    	    }
    	}
     	
     	// 종합 코인(공부 코인 + 게임 코인) - 프로게이머 엔딩
    	else if(studyCoin >= 50 && gameCoin >= 50 && artCoin < 30 && exerciseCoin < 30) {
    		cookieNameLabel.setText(e.endings[6].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeProgammerCookieImage));
    	    contextLabel.setText(e.endings[6].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(e.endings[6].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[6].isNew = false;
    	    }
    	}
     	
     	// 종합 코인(예술 코인 + 운동 코인) - 요리사 엔딩
    	else if(artCoin >= 50 && exerciseCoin >= 50 && gameCoin < 30 && studyCoin < 30) {
    		cookieNameLabel.setText(e.endings[12].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeCookerCookieImage));
    	    contextLabel.setText(e.endings[12].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(e.endings[12].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[12].isNew = false;
    	    }
    	}

     	// 백수 엔딩
    	else if(studyCoin < 50 && artCoin < 50 && exerciseCoin < 50 && gameCoin < 50) {
    		cookieNameLabel.setText(e.endings[11].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeBacksuCookieImage));
    	    contextLabel.setText(e.endings[11].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(e.endings[11].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[11].isNew = false;
    	    }
    	}
     	//최다 코인 엔딩 로직
    	else if(studyCoin >= artCoin) { //코인의 우선순위는 공부 > 예술 > 운동
     		if(studyCoin > exerciseCoin) { //최다 코인이 공부 코인인 경우 
     			//공부 코인 - 교수 엔딩
     	    	if(studyCoin >= 80) {
     	    		cookieNameLabel.setText(e.endings[3].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeProfessorCookieImage));
     	    	    contextLabel.setText(e.endings[3].description);	
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[3].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[3].isNew =false;
     	    	    }
     	    	}
  
     			//공부 코인 - 프로그래머 엔딩
     	    	else if(studyCoin >= 50) {
     	    		cookieNameLabel.setText(e.endings[5].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeProgrammerCookieImage));
     	    	    contextLabel.setText(e.endings[5].description);
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[5].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[5].isNew =false;
     	    	    }
     	    	}
     		}
     	     else { //최다 코인이 운동 코인인 경우
     	    	 
     	    	//운동 코인 - 국가 대표 엔딩
     	    	if(exerciseCoin >= 80) {
     	    		cookieNameLabel.setText(e.endings[10].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeNationalCookieImage));
     	    	    contextLabel.setText(e.endings[10].description);	
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[10].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[10].isNew = false;
     	    	    }
     	    	}
     	    	//운동 코인 - 아마추어 운동 선수 엔딩
     	    	else if(exerciseCoin >= 50) {
     	    		cookieNameLabel.setText(e.endings[8].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeAthleteCookieImage));
     	    	    contextLabel.setText(e.endings[8].description);	
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[8].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[8].isNew =false;
     	    	    }
     	    	}
     	    }
        }
     		
     	else { 
     		if(artCoin >= exerciseCoin) { //최다 코인이 예술 코인인 경우
     			//에술 코인 - 피아니스트 엔딩
     	    	if(artCoin >= 80) {
     	    		cookieNameLabel.setText(e.endings[1].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizePianistCookieImage));
     	    	    contextLabel.setText(e.endings[1].description);
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[1].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[1].isNew = false;
     	    	    }
     	    	}
     	    	//에술 코인 - 화가 엔딩
     	    	else if(artCoin >= 50) {
     	    		cookieNameLabel.setText(e.endings[2].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizePainterCookieImage));
     	    	    contextLabel.setText(e.endings[2].description);
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[2].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[2].isNew =false;
     	    	}
     		}
     	}
     		else { //최다 코인이 운동 코인인 경우
     			//운동 코인 - 국가 대표 엔딩
     	    	if(exerciseCoin >= 80) {
     	    		cookieNameLabel.setText(e.endings[10].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeNationalCookieImage));
     	    	    contextLabel.setText(e.endings[10].description);	
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[10].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[10].isNew = false;
     	    	    }
     	    	}
     	    	//운동 코인 - 아마추어 운동 선수 엔딩
     	    	else if(exerciseCoin >= 50) {
     	    		cookieNameLabel.setText(e.endings[8].name);
     	    	    cookieImageLabel.setIcon(new ImageIcon(resizeAthleteCookieImage));
     	    	    contextLabel.setText(e.endings[8].description);	
     	    	    //새로 얻은 쿠키인지 확인
     	    	    if(e.endings[8].isNew) {
     	    	    	newCookieLabel.setText("new");
     	    	    	e.endings[8].isNew =false;
     	    	    }
     	    	}
     		}
     }
        //코인 수 업데이트
        exerciseNumberLabel.setText(String.valueOf(exerciseCoin));
        gameNumberLabel.setText(String.valueOf(gameCoin));
        artNumberLabel.setText(String.valueOf(artCoin)); 
        studyNumberLabel.setText(String.valueOf(studyCoin));
        
        
        // 변경 사항 반영
        revalidate();
        repaint();
    }
}