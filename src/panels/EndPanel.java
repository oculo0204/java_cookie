package panels;

import java.awt.Color;
import main.listenAdapter;
import panels.Endings.Ending;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    ImageIcon retryBtn = new ImageIcon("img/end/home-btn.png"); // 다시 시작 버튼
    ImageIcon homeBtn = new ImageIcon("img/end/collection.png"); // 메인 버튼
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

    public EndPanel(Object o) {
        // 레이아웃을 수동으로 관리
        setLayout(null);
        
        //Ending endings;
        //새로운 쿠키일때 
        newCookieLabel = new JLabel("");
        newCookieLabel.setFont(new Font("Gill Sans Ultra Bold", Font.ITALIC, 20));
        newCookieLabel.setBounds(100, 70, 400, 87);
        newCookieLabel.setForeground(Color.RED);
        add(newCookieLabel);
        // 쿠키 이름 라벨
        cookieNameLabel = new JLabel("");
        cookieNameLabel.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 45));
        cookieNameLabel.setBounds(115, 100, 400, 87);
        add(cookieNameLabel);
        
        // 옥황상제 쿠키 이미지 얻기
    	ImageIcon king_cookie = new ImageIcon(e.endings[0].imagePath);
    	Image kingCookieImage = king_cookie.getImage();
		Image resizeKingCookieImage = kingCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        // 교수 쿠키 이미지 얻기
    	ImageIcon professor_cookie = new ImageIcon(e.endings[3].imagePath);
    	Image professorCookieImage = professor_cookie.getImage();
		Image resizeProfessorCookieImage = professorCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 프로그래머 쿠키 이미지 얻기
	 	ImageIcon programmer_cookie = new ImageIcon(e.endings[5].imagePath);
    	Image programmerCookieImage = programmer_cookie.getImage();
		Image resizeProgrammerCookieImage = programmerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 피아니스트 쿠키 이미지 얻기
		ImageIcon pianist_cookie = new ImageIcon(e.endings[1].imagePath);
    	Image pianistCookieImage = pianist_cookie.getImage();
		Image resizePianistCookieImage = pianistCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 화가 쿠키 이미지 얻기
		ImageIcon painter_cookie = new ImageIcon(e.endings[2].imagePath);
    	Image painterCookieImage = painter_cookie.getImage();
		Image resizePainterCookieImage = painterCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 국가대표 쿠키 이미지 얻기
		ImageIcon national_cookie = new ImageIcon(e.endings[10].imagePath);
    	Image nationalCookieImage = national_cookie.getImage();
		Image resizeNatioanlCookieImage = nationalCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 운동선수 쿠키 이미지 얻기
		ImageIcon athlete_cookie = new ImageIcon(e.endings[8].imagePath);
    	Image athleteCookieImage = athlete_cookie.getImage();
		Image resizeAthleteCookieImage = athleteCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 프로게이머 쿠키 이미지 얻기
		ImageIcon progammer_cookie = new ImageIcon(e.endings[6].imagePath);
    	Image progammerCookieImage = progammer_cookie.getImage();
		Image resizeProgammerCookieImage = progammerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 요리사 쿠키 이미지 얻기
		ImageIcon cooker_cookie = new ImageIcon(e.endings[12].imagePath);
    	Image cookerCookieImage = cooker_cookie.getImage();
		Image resizeCookerCookieImage = cookerCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		// 백수 쿠키 이미지 얻기
		ImageIcon backsu_cookie = new ImageIcon(e.endings[11].imagePath);
		Image backsuCookieImage = backsu_cookie.getImage();
		Image resizeBacksuCookieImage = backsuCookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		//쿠키 이미지 라벨
        cookieImageLabel = new JLabel();
        cookieImageLabel.setBounds(100, 150, 200, 200); // 위치와 크기 조정
        add(cookieImageLabel);
        //운동 코인
        ImageIcon exerciseIcon = new ImageIcon("img/end/exercise.png");
        Image exerciseImage = exerciseIcon.getImage();
        Image resizeExerciseImage = exerciseImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        exerciseCoinLabel = new JLabel(new ImageIcon(resizeExerciseImage));
        exerciseCoinLabel.setBounds(380, 115, 67, 68);
        add(exerciseCoinLabel);
        //운동 코인 수
        exerciseNumberLabel = new JLabel();
        exerciseNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        exerciseNumberLabel.setBounds(460, 110, 300, 80);
        add(exerciseNumberLabel);
        //게임 코인
        ImageIcon gameIcon = new ImageIcon("img/end/game.png");
        Image gameImage = gameIcon.getImage();
        Image resizeGameImage = gameImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        gameCoinLabel = new JLabel(new ImageIcon(resizeGameImage));
        gameCoinLabel.setBounds(560, 115, 67, 68);
        add(gameCoinLabel);
        //게임 코인 수
        gameNumberLabel = new JLabel();
        gameNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        gameNumberLabel.setBounds(640, 110, 300, 80);
        add(gameNumberLabel);
        //예술 코인
        ImageIcon artIcon = new ImageIcon("img/end/art.png");
        Image artImage = artIcon.getImage();
        Image resizeArtImage = artImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        artCoinLabel = new JLabel(new ImageIcon(resizeArtImage));
        artCoinLabel.setBounds(380, 205, 67, 68);
        add(artCoinLabel);
        //예술 코인 수
        artNumberLabel = new JLabel();
        artNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        artNumberLabel.setBounds(460, 200, 300, 80);
        add(artNumberLabel);
        //공부 코인
        ImageIcon studyIcon = new ImageIcon("img/end/study.png");
        Image studyImage = studyIcon.getImage();
        Image resizeStudyImage = studyImage.getScaledInstance(67, 68, Image.SCALE_SMOOTH);
        studyCoinLabel = new JLabel(new ImageIcon(resizeStudyImage));
        studyCoinLabel.setBounds(560, 205, 67, 68);
        add(studyCoinLabel);
        //공부 코인 수
        studyNumberLabel = new JLabel();
        studyNumberLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
        studyNumberLabel.setBounds(640, 200, 300, 80);
        add(studyNumberLabel);
        //쿠키 설명
        contextLabel = new JLabel();
        contextLabel.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 15));
        contextLabel.setBounds(50, 350, 600, 80);
        add(contextLabel);
        // 다시 시작 버튼
        retryButton = new JButton(retryBtn);
        retryButton.setName("endAccept");
        retryButton.addMouseListener((MouseListener) o);
        retryButton.setBounds(520, 300, 250, 70);
        retryButton.setBorderPainted(false);
        retryButton.setFocusPainted(false);
        retryButton.setContentAreaFilled(false);
        add(retryButton);

        // 엔딩 모음 이동 버튼
        homeButton = new JButton(homeBtn);
        homeButton.setName("EndArchiveBtn");
        homeButton.addMouseListener((MouseListener) o);
        homeButton.setBounds(520, 370, 250, 70);
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
        scoreViewLabel.setBounds(360, 42, 400, 87);
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
        Image resizeBackImage = backImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(resizeBackImage));
        imageLabel.setBounds(0, 0, 1280, 720);
        add(imageLabel);
    }

    public void setResultScore(int exerciseCoin, int gameCoin, int artCoin, int studyCoin) {
        // 코인 수에 따라 이름과 이미지, 설명 설정
    	//종합 코인 (공부+예술+게임+운동) - 옥황상제 엔딩
     	if(studyCoin >= 20 && gameCoin >= 20 && artCoin >= 20 && exerciseCoin >= 20) {
    		cookieNameLabel.setText(e.endings[0].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeKingCookieImage));
    	    contextLabel.setText(e.endings[0].description);
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[0].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[0].isNew = true;
    	    }
    	}
    	//공부 코인 - 교수 엔딩
     	else if(studyCoin >= 30 && gameCoin < 20) {
    		cookieNameLabel.setText(e.endings[3].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeProfessorCookieImage));
    	    contextLabel.setText(e.endings[3].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[3].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[3].isNew = true;
    	    }
    	}
    	//공부 코인 - 프로그래머 엔딩
    	else if(studyCoin >= 20 && gameCoin < 20) {
    		cookieNameLabel.setText(e.endings[5].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeProgrammerCookieImage));
    	    contextLabel.setText(e.endings[5].description);
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[5].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[5].isNew = true;
    	    }
    	}
    	//에술 코인 - 피아니스트 엔딩
    	else if(artCoin >= 30 && exerciseCoin < 20) {
    		cookieNameLabel.setText(e.endings[1].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizePianistCookieImage));
    	    contextLabel.setText(e.endings[1].description);
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[1].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[1].isNew = true;
    	    }
    	}
    	//에술 코인 - 화가 엔딩
    	else if(artCoin >= 20 && exerciseCoin < 20) {
    		cookieNameLabel.setText(e.endings[2].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizePainterCookieImage));
    	    contextLabel.setText(e.endings[2].description);
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[2].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[2].isNew = true;
    	    }
    	}
    	//운동 코인 - 국가 대표 엔딩
    	else if(exerciseCoin >= 30 && artCoin < 20) {
    		cookieNameLabel.setText(e.endings[10].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeNationalCookieImage));
    	    contextLabel.setText(e.endings[10].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[10].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[10].isNew = true;
    	    }
    	}
    	//운동 코인 - 아마추어 운동 선수 엔딩
    	else if(exerciseCoin >= 20 && artCoin < 20) {
    		cookieNameLabel.setText(e.endings[8].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeAthleteCookieImage));
    	    contextLabel.setText(e.endings[8].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[8].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[8].isNew = true;
    	    }
    	}
    	// 종합 코인(공부 코인 + 게임 코인) - 프로게이머 엔딩
    	else if(studyCoin >= 20 && gameCoin >= 20) {
    		cookieNameLabel.setText(e.endings[6].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeProgammerCookieImage));
    	    contextLabel.setText(e.endings[6].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[6].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[6].isNew = true;
    	    }
    	}
    	// 종합 코인(예술 코인 + 운동 코인) - 요리사 엔딩
    	else if(artCoin >= 20 && exerciseCoin >= 20) {
    		cookieNameLabel.setText(e.endings[12].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeCookerCookieImage));
    	    contextLabel.setText(e.endings[12].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[12].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[12].isNew = true;
    	    }
    	}
     	// 백수 엔딩
    	else {
    		cookieNameLabel.setText(e.endings[11].name);
    	    cookieImageLabel.setIcon(new ImageIcon(resizeBacksuCookieImage));
    	    contextLabel.setText(e.endings[11].description);	
    	    //새로 얻은 쿠키인지 확인
    	    if(!e.endings[11].isNew) {
    	    	newCookieLabel.setText("new");
    	    	e.endings[11].isNew = true;
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
