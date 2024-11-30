package panels;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class SelectPanel extends JPanel {

    // 버프 이미지 (선택 전)
    private ImageIcon speedUp = new ImageIcon("img/select/speedUp.png");
    private ImageIcon noSkip = new ImageIcon("img/select/skipRemove.png");
    private ImageIcon smallCoin = new ImageIcon("img/select/heartUp.png");
    private ImageIcon hurdleScale2 = new ImageIcon("img/select/jumpUp.png");
    private ImageIcon decreaseCoin = new ImageIcon("img/select/slideCoinDrop.png");
    private ImageIcon coinScore2 = new ImageIcon("img/select/coinDouble.png");

    // 버프 이미지 (선택 후)
    private ImageIcon selectedSpeedUp = new ImageIcon("img/select/speedUp_selected.png");
    private ImageIcon selectedNoSkip = new ImageIcon("img/select/skipRemove_selected.png");
    private ImageIcon selectedSmallCoin = new ImageIcon("img/select/heartUp_selected.png");
    private ImageIcon selectedHurdleScale2 = new ImageIcon("img/select/jumpUp_selected.png");
    private ImageIcon selectedDecreaseCoin = new ImageIcon("img/select/slideCoinDrop_selected.png");
    private ImageIcon selectedCoinScore2 = new ImageIcon("img/select/coinDouble_selected.png");

    // 선택된 버프를 저장하는 리스트
    private List<ImageIcon> selectedBuffs;
    public void setSelectedBuffs(List<ImageIcon> buffs) {
        this.selectedBuffs = buffs;
        refreshBuffDisplay(); // 화면을 갱신
    }

    // 선택된 버프 추적 변수
    private ImageIcon selectedBuff = null;
    public String getSelectedBuff() {
        return getBuffName(selectedBuff);
    }
    private JLabel selectedBuffLabel;  // 선택된 버프 이름을 표시할 라벨

    // 선택된 버튼을 추적
    private Map<JButton, ImageIcon> buttonToSelectedIconMap;
    private JButton currentlySelectedButton;

    private boolean isCheckedBuff = false;
    public boolean getIsCheckedBuff() {
        return isCheckedBuff;
    }
    public void setIsCheckedBuff(boolean checked) {
        this.isCheckedBuff = checked;
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

    // 선택완료 버튼
    private JButton selectedBtn;

    public SelectPanel(Object o) {
        setLayout(null);
        // 폰트
        Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 24f);

        // 랜덤으로 3개의 버프 선택
        selectedBuffs = getRandomBuffs();

        // 선택된 버튼의 매핑 관리
        buttonToSelectedIconMap = new HashMap<>();

        // 선택된 버프 배치
        arrangeBuffs();

        // 선택완료 버튼
        selectedBtn = new JButton(new ImageIcon("img/select/GameStartBtn.png"));
        selectedBtn.setBounds(450, 370, 291, 81);
        selectedBtn.setBorderPainted(false);
        selectedBtn.setContentAreaFilled(false);
        selectedBtn.setFocusPainted(false);
        selectedBtn.addMouseListener((MouseListener) o);
        selectedBtn.setName("selectBtn");
        add(selectedBtn);
        selectedBtn.setEnabled(false);

        // 배경 이미지
        JLabel selectBg = new JLabel(new ImageIcon("img/select/selectBg.png"));
        selectBg.setBounds(0, 0, 800, 500);
        add(selectBg);

        // 선택된 버프 이름을 표시할 라벨 추가
        selectedBuffLabel = new JLabel("선택된 버프: ");
        selectedBuffLabel.setFont(cookieRunBlack);
        selectedBuffLabel.setBounds(20, 350, 300, 50);
        add(selectedBuffLabel);
    }

    // 랜덤으로 3개의 버프 선택
    public List<ImageIcon> getRandomBuffs() {
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
        int height = 200;
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
                    // 이전에 선택된 버튼이 있다면 기본 이미지로 되돌리기
                    if (currentlySelectedButton != null) {
                        ImageIcon originalImage = getOriginalImageForButton(currentlySelectedButton);
                        currentlySelectedButton.setIcon(originalImage);
                    }

                    // 클릭된 버튼을 선택된 상태로 전환
                    if (currentlySelectedButton != buffButton) {
                        buffButton.setIcon(buttonToSelectedIconMap.get(buffButton));
                        currentlySelectedButton = buffButton;
                        selectedBuff = buff;  // 선택된 버프 추적
                        selectedBuffLabel.setText("선택된 버프: " + getBuffName(selectedBuff));  // 선택된 버프 이름 업데이트
                        isCheckedBuff = true;
                        selectedBtn.setEnabled(true);
                    } else {
                        // 동일한 버튼을 다시 클릭하면 선택 해제
                        currentlySelectedButton = null;
                    }
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

    // 선택된 상태에서 원래 상태로 돌아가는 이미지를 반환하는 메서드
    private ImageIcon getOriginalImageForButton(JButton button) {
        for (Map.Entry<JButton, ImageIcon> entry : buttonToSelectedIconMap.entrySet()) {
            if (entry.getKey() == button) {
                for (ImageIcon buff : selectedBuffs) {
                    if (buttonToSelectedIconMap.get(button).equals(getSelectedImageForBuff(buff))) {
                        return buff;
                    }
                }
            }
        }
        return null;
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
        if (buff.equals(smallCoin)) return "무한 체력";
        if (buff.equals(hurdleScale2)) return "점프 1.5배";
        if (buff.equals(decreaseCoin)) return "코인 수 감소";
        if (buff.equals(coinScore2)) return "코인 점수 두배";
        return "";
    }

    // 화면 갱신
    private void refreshBuffDisplay() {
        removeAll(); // 기존 컴포넌트를 모두 제거
        arrangeBuffs(); // 버프를 다시 배치
        // 선택된 버튼과 배경을 다시 추가
        add(selectedBtn);
        selectedBtn.setEnabled(false);
        JLabel selectBg = new JLabel(new ImageIcon("img/select/selectBg.png"));
        selectBg.setBounds(0, 0, 800, 500);
        add(selectBg);
        revalidate(); // 화면 갱신
        repaint();
    }
}
