package panels;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List; // Collections Framework의 List
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.*;

public class SelectPanel extends JPanel {

    // 버프 이미지 (선택 전)
    private ImageIcon speedUp = new ImageIcon("img/select/selectCh1.png");
    private ImageIcon noSkip = new ImageIcon("img/select/selectCh2.png");
    private ImageIcon smallCoin = new ImageIcon("img/select/selectCh3.png");
    private ImageIcon hurdleScale2 = new ImageIcon("img/select/selectCh4.png");
    private ImageIcon decreaseCoin = new ImageIcon("img/select/selectCh1.png");
    private ImageIcon coinScore2 = new ImageIcon("img/select/selectCh2.png");

    // 버프 이미지 (선택 후)
    private ImageIcon selectedSpeedUp = new ImageIcon("img/select/selectedCh1.png");
    private ImageIcon selectedNoSkip = new ImageIcon("img/select/selectedCh2.png");
    private ImageIcon selectedSmallCoin = new ImageIcon("img/select/selectedCh3.png");
    private ImageIcon selectedHurdleScale2 = new ImageIcon("img/select/selectedCh4.png");
    private ImageIcon selectedDecreaseCoin = new ImageIcon("img/select/selectedCh1.png");
    private ImageIcon selectedCoinScore2 = new ImageIcon("img/select/selectedCh2.png");

    // 선택된 버프를 저장하는 리스트
    private List<ImageIcon> selectedBuffs;

    // 선택된 버튼을 추적
    private Map<JButton, ImageIcon> buttonToSelectedIconMap;
    
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

    // 게임 시작 버튼
    private JButton startBtn;

    public SelectPanel(Object o) {
        setLayout(null);
        //폰트
        Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 24f);
        Font cookieRunRegular = loadCustomFont("fonts/CookieRun Regular.otf", 12f);

        // 랜덤으로 3개의 버프 선택
        selectedBuffs = getRandomBuffs();

        // 선택된 버튼의 매핑 관리
        buttonToSelectedIconMap = new HashMap<>();

        // 선택된 버프 배치
        arrangeBuffs();

        // 게임 시작 버튼
        startBtn = new JButton(new ImageIcon("img/select/GameStartBtn.png"));
        startBtn.setBounds(450, 370, 291, 81);
        startBtn.setBorderPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setFocusPainted(false);
        startBtn.addMouseListener((MouseListener) o);
        add(startBtn);

        // 배경 이미지
        JLabel selectBg = new JLabel(new ImageIcon("img/select/background.png"));
        selectBg.setBounds(0, 0, 784, 461);
        add(selectBg);
    }

    // 랜덤으로 3개의 버프 선택
    private List<ImageIcon> getRandomBuffs() {
        List<ImageIcon> allBuffs = new ArrayList<>(Arrays.asList(
                speedUp, noSkip, smallCoin, hurdleScale2, decreaseCoin, coinScore2));
        Collections.shuffle(allBuffs); // 랜덤으로 섞기
        return allBuffs.subList(0, 3); // 상위 3개 반환
    }

    // 선택된 버프를 화면에 배치
    private void arrangeBuffs() {
        int x = 80; // 초기 X 좌표
        int y = 90; // Y 좌표
        int width = 150; // 버튼 너비
        int height = 200; // 버튼 높이
        int gap = 20; // 간격
        Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 21f);

        // 선택된 3개의 버프를 화면에 배치
        for (ImageIcon buff : selectedBuffs) {
            JButton buffButton = new JButton(buff);
            buffButton.setBounds(x, y, width, height);
            buffButton.setBorderPainted(false);
            buffButton.setContentAreaFilled(false);
            buffButton.setFocusPainted(false);

            // 선택 후 이미지를 설정하기 위한 매핑
            ImageIcon selectedImage = getSelectedImageForBuff(buff);
            buttonToSelectedIconMap.put(buffButton, selectedImage);

            // 버튼 클릭 시 이미지 변경
            buffButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buffButton.setIcon(buttonToSelectedIconMap.get(buffButton));
                }
            });

            add(buffButton);

            // 버프 이름 라벨 추가
            JLabel buffLabel = new JLabel(getBuffName(buff));
            buffLabel.setFont(cookieRunBlack);
            buffLabel.setHorizontalAlignment(SwingConstants.CENTER);
            buffLabel.setBounds(x, y + height + 10, width, 40);
            add(buffLabel);

            x += width + 90; // 다음 버튼의 X 좌표로 이동
        }
    }

    // 선택 후 이미지를 반환하는 메서드
    private ImageIcon getSelectedImageForBuff(ImageIcon buff) {
        if (buff.equals(speedUp)) return selectedSpeedUp;
        if (buff.equals(noSkip)) return selectedNoSkip;
        if (buff.equals(smallCoin)) return selectedSmallCoin;
        if (buff.equals(hurdleScale2)) return selectedHurdleScale2;
        if (buff.equals(decreaseCoin)) return selectedDecreaseCoin;
        if (buff.equals(coinScore2)) return selectedCoinScore2;
        return null;
    }

    // 버프의 이름을 반환하는 메서드
    private String getBuffName(ImageIcon buff) {
        if (buff.equals(speedUp)) return "스피드 업";
        if (buff.equals(noSkip)) return "스킵 기능 무효";
        if (buff.equals(smallCoin)) return "코인 크기 감소";
        if (buff.equals(hurdleScale2)) return "장애물 크기 증가";
        if (buff.equals(decreaseCoin)) return "코인 수 감소";
        if (buff.equals(coinScore2)) return "코인 점수 두배";
        return "";
    }
}
