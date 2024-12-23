package panels;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {

	// 이미지 아이콘
	ImageIcon backgroundImg = new ImageIcon("img/main/main_bk.png");
	ImageIcon trophyIcon = new ImageIcon("img/main/trophy.png");
	ImageIcon optionsIcon = new ImageIcon("img/main/options.png");
	ImageIcon startButtonImg = new ImageIcon("img/main/start_button.png");
	ImageIcon easyButtonImg = new ImageIcon("img/main/easy_button.png");
	ImageIcon hardButtonImg = new ImageIcon("img/main/hard_button.png");
	// 이미지 아이콘 (GIF 파일 추가)
	ImageIcon artCoinGif = new ImageIcon("img/main/art_coin.gif");
	ImageIcon studyCoinGif = new ImageIcon("img/main/study_coin.gif");
	ImageIcon gymCoinGif = new ImageIcon("img/main/gym_coin.gif");

	// 버튼과 레이블
	JButton btnStart;
	JButton btnEasy;
	JButton btnTrophy;
	JButton btnOptions;
	JLabel lblBackground;
	// GIF 이미지를 표시할 레이블
	JLabel lblArtCoin;
	JLabel lblStudyCoin;
	JLabel lblGymCoin;

	// 난이도 변수
	int difficulty = 1; // 1 = Easy, 2 = Hard

	public MainPanel(Object o) {
		// 레이아웃과 패널 크기 설정
		setLayout(null);
		setSize(800,500);

		// 폰트 로드
		Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 24f);

		// GIF 레이블 생성 및 위치 설정
		lblArtCoin = new JLabel(resizeImageIcon(artCoinGif, 0.4));
		lblArtCoin.setBounds(350, 80, 160, 160); // 위치와 크기는 필요에 맞게 조정
		add(lblArtCoin);

		lblStudyCoin = new JLabel(resizeImageIcon(studyCoinGif, 0.5));
		lblStudyCoin.setBounds(420, 120, 160, 160);
		add(lblStudyCoin);

		lblGymCoin = new JLabel(resizeImageIcon(gymCoinGif, 0.6));
		lblGymCoin.setBounds(350, 200, 140, 160);
		add(lblGymCoin);

		// 트로피 버튼
		btnTrophy = new JButton(resizeImageIconAb(trophyIcon, 80, 80));
		btnTrophy.setBounds(570, 20, 80, 80);
		btnTrophy.setBorderPainted(false);
		btnTrophy.setFocusPainted(false);
		btnTrophy.setContentAreaFilled(false);
		btnTrophy.addMouseListener((MouseListener) o);
		btnTrophy.setName("EndArchiveBtn"); 
		add(btnTrophy);

		// 옵션 버튼
		btnOptions = new JButton(resizeImageIconAb(optionsIcon, 80,80));
		btnOptions.setBounds(670, 20, 80, 80);
		btnOptions.setBorderPainted(false);
		btnOptions.setFocusPainted(false);
		btnOptions.setContentAreaFilled(false);
		btnOptions.addMouseListener((MouseListener) o);
		btnOptions.setName("ExplainBtn"); 
		add(btnOptions);

		// START 버튼
		btnStart = new JButton("", resizeImageIcon(startButtonImg, 0.6));
		btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStart.setBounds(530, 320, 210, 112);
		btnStart.setBorderPainted(false);
		btnStart.setFocusPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setName("StartBtn");
		btnStart.addMouseListener((MouseListener) o);
		add(btnStart);

		// 배경 이미지
		lblBackground = new JLabel(backgroundImg);
		lblBackground.setBounds(0, 0, 785, 460);
		add(lblBackground, BorderLayout.CENTER);
	}

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

	// 이미지 비율을 유지하면서 크기 조정
	private ImageIcon resizeImageIcon(ImageIcon originalIcon, double scale) {
		// 원본 이미지 가져오기
		Image originalImage = originalIcon.getImage();

		// 이미지 크기 조정 (비율을 유지하면서 크기 조정)
		int width = (int) (originalImage.getWidth(null) * scale);
		int height = (int) (originalImage.getHeight(null) * scale);

		// 이미지를 새 크기로 리사이징
		Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

		// 리사이징된 이미지를 새 ImageIcon으로 반환
		return new ImageIcon(resizedImage);
	}
	
	private ImageIcon resizeImageIconAb(ImageIcon originalIcon, int w, int h) {
		// 원본 이미지 가져오기
		Image originalImage = originalIcon.getImage();

		// 이미지를 새 크기로 리사이징
		Image resizedImage = originalImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);

		// 리사이징된 이미지를 새 ImageIcon으로 반환
		return new ImageIcon(resizedImage);
	}

	// 난이도 전환 함수 (버튼 이미지 및 난이도 값 변경)
	private void toggleDifficulty() {
		if (difficulty == 1) {
			// 난이도 1 (Easy) -> 난이도 2 (Hard)
			btnEasy.setIcon(resizeImageIcon(hardButtonImg, 0.5)); // 버튼 이미지를 하드로 변경
			difficulty = 2; // 난이도 값을 하드로 변경
		} else {
			// 난이도 2 (Hard) -> 난이도 1 (Easy)
			btnEasy.setIcon(resizeImageIcon(easyButtonImg, 0.5)); // 버튼 이미지를 이지로 변경
			difficulty = 1; // 난이도 값을 이지로 변경
		}
	}
}