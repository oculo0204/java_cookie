package panels;

import java.awt.Color;
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

public class EndArchivePanel extends JPanel {

    ImageIcon retryBtn = new ImageIcon("img/endArchive/button.png"); // 다시 시작 버튼
    ImageIcon homeBtn = new ImageIcon("img/endArchive/button.png"); // 메인 버튼
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
    private int resultScore; // 점수가 아닌 코인모음으로 출력해야함

    public EndArchivePanel(Object o) {
        // 레이아웃을 수동으로 관리
        setLayout(null);
        
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

        // 쿠키 이미지 라벨
        cookieImageLabel = new JLabel();
        cookieImageLabel.setBounds(100, 150, 200, 200); // 위치와 크기 조정
        add(cookieImageLabel);
        //운동 코인
        ImageIcon exerciseIcon = new ImageIcon("img/endArchive/exercise.png");
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
        ImageIcon gameIcon = new ImageIcon("img/endArchive/game.png");
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
        ImageIcon artIcon = new ImageIcon("img/endArchive/art.png");
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
        ImageIcon studyIcon = new ImageIcon("img/endArchive/study.png");
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
        retryButton.setName("다시 시작");
        retryButton.addMouseListener((MouseListener) o);
        retryButton.setBounds(520, 300, 250, 70);
        retryButton.setBorderPainted(false);
        retryButton.setFocusPainted(false);
        retryButton.setContentAreaFilled(false);
        add(retryButton);

        // 홈 버튼
        homeButton = new JButton(homeBtn);
        homeButton.setName("메인으로");
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

        // 실제론 필요 없는 부분이지만 현재 포함시키지 않으면 오류 발생
        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 49));
        scoreLabel.setBounds(413, 52, 459, 87);
        add(scoreLabel);

        // 엔딩 배경 이미지 (가장 마지막에 추가하여 가장 뒤에 표시되도록 함)
        ImageIcon backIcon = new ImageIcon("img/endArchive/background.jpg");
        Image backImage = backIcon.getImage();
        Image resizeBackImage = backImage.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        imageLabel = new JLabel(new ImageIcon(resizeBackImage));
        imageLabel.setBounds(0, 0, 1280, 720);
        add(imageLabel);
    }

    public void setResultScore(int resultScore) {
        // 코인 수에 따라 이름과 이미지, 설명 설정
        cookieNameLabel.setText("<html>백수 쿠키 </html>"); // 이름 설정 예시
        ImageIcon cookieIcon = new ImageIcon("img/endArchive/selectCh3.png"); //쿠키 이미지 설정 예시
        Image cookieImage = cookieIcon.getImage();
        Image resizeCookieImage = cookieImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // 크기 조정
        cookieImageLabel.setIcon(new ImageIcon(resizeCookieImage));
        contextLabel.setText("<html>어릴적부터 하고 싶은게 많았던 쿠키, 하지만 그것은 오래가지 못했다..<br>"
                + "재수와 삼수, 그리고 사수, 오수까지 거쳐 끝내 백수가 되다.</html>");
        //코인 수 업데이트
        exerciseNumberLabel.setText("X 3"); //운동 코인 수 설정 예시
        gameNumberLabel.setText("X 1"); //게임 코인 수 설정 예시
        artNumberLabel.setText("X 2"); //예술 코인 수 설정 예시
        studyNumberLabel.setText("X 3"); //공부 코인 수 설정 예시
        //새로 얻은 쿠키인지 확인
        newCookieLabel.setText("new");
        
        // 변경 사항 반영
        revalidate();
        repaint();
    }
}
