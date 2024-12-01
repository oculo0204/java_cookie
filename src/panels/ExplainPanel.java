package panels;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ExplainPanel extends JPanel {
	
    public ExplainPanel(Object o) {
        setLayout(new BorderLayout(0, 20)); // 상하 간격 설정

        setBackground(new Color(255, 197, 73));

        Font cookieRunBlack = loadCustomFont("fonts/CookieRun Black.otf", 26f);
        Font cookieRunRegular = loadCustomFont("fonts/CookieRun Regular.otf", 14f);
        
        // 뒤로가기 버튼
        JButton back = new JButton();
        ImageIcon backIcon = new ImageIcon("img/endArchive/back.png");
        Image backImg = backIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        back.setIcon(new ImageIcon(backImg));
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setName("Ex_backBtn");
        back.setBounds(20, 20, 50, 50);
        back.addMouseListener((MouseListener) o);

        // 상단 패널에 엔딩 설명서와 뒤로 가기 버튼을 배치
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); // 수평으로 배치
        topPanel.setBackground(new Color(255, 197, 73));
        // 왼쪽에는 빈 공간 (뒤로 가기 버튼을 오른쪽에 배치할 수 있도록 여백을 추가)
        topPanel.add(Box.createHorizontalGlue());

        // 가운데에는 엔딩 설명서 텍스트 추가
        JLabel descriptionLabel = new JLabel("엔딩 설명서", JLabel.CENTER);
        descriptionLabel.setFont(cookieRunBlack);
        topPanel.add(descriptionLabel);

        // 오른쪽에는 뒤로 가기 버튼 배치
        topPanel.add(Box.createHorizontalStrut(10)); // 버튼과 설명서 사이에 여백 추가
        topPanel.add(back); // 뒤로 가기 버튼 추가

        add(topPanel, BorderLayout.NORTH);
     // 이미지 로딩 예시
        // 여러 쿠키와 코인 정보를 담을 패널
        JPanel mainPanel = new JPanel(new GridLayout(10, 1, 0, 10)); // 총 10개의 행, 각 행 간격 10px
        mainPanel.setBackground(new Color(255, 197, 73));
        // JScrollPane을 이용해 mainPanel을 감싸서 스크롤 기능 추가
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Image track = new ImageIcon("img/endArchive/track.png").getImage();
		Image thumb = new ImageIcon("img/endArchive/thumb.png").getImage();
		 scrollPane.setVerticalScrollBar(new MyScrollBar(track, thumb));
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(230, 177, 66), 2));
        // 쿠키 추가
        addCookieRow(mainPanel, "옥황상제", "img/endings/옥황상제.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x180", ">= x30", ">= x180", ">= x180"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "프로게이머", "img/endings/프로게이머.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"< 50", ">= 60", "< 50", ">= 130"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "가수", "img/endings/가수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x180", "< x50", ">= x180", "< x50"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "백수", "img/endings/백수.png",
                new String[]{""},
                new String[]{" Not applicable"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "교수", "img/endings/교수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", "anyway", ">= x180"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "프로그래머", "img/endings/프로그래머.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", "anyway", ">= x130"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "국가대표", "img/endings/국가대표.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x180", "anyway", "anyway", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "아마추어 운동선수", "img/endings/아마추어 운동선수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x130", "anyway", "anyway", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "피아니스트", "img/endings/피아니스트.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", ">= x180", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "화가", "img/endings/화가.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", ">= x130", "anyway"},
                cookieRunBlack, cookieRunRegular);


        // 개발자명 하단 오른쪽에 배치
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬
        JLabel personLabel = new JLabel("개발자: 자바 쿠키(장서원, 이주연, 박가연, 이하경)");
        bottomPanel.setBackground(new Color(255, 197, 73));
        personLabel.setFont(cookieRunRegular);
        bottomPanel.add(personLabel);

        // 스크롤의 하단에 개발자명 패널 추가
        add(bottomPanel, BorderLayout.SOUTH);
    	}
    

    private void addCookieRow(JPanel panel, String cookieName, String cookieImagePath,
            String[] coinTypes, String[] coinCounts, Font nameFont, Font countFont) {
		JPanel rowPanel = new JPanel(new BorderLayout(10, 0)); // 좌우 간격 10px
		panel.add(rowPanel);
		
		// 왼쪽: 쿠키 이미지와 이름 (BoxLayout을 사용)
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // 수직으로 배치
		leftPanel.setPreferredSize(new Dimension(220, leftPanel.getPreferredSize().height));
		leftPanel.setPreferredSize(new Dimension(200, leftPanel.getPreferredSize().width));
		rowPanel.add(leftPanel, BorderLayout.WEST);
		
		// 쿠키 이미지 (크기 조정) + 왼쪽 여백 추가
		JPanel cookieImagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10)); // 왼쪽 간격 20px
		ImageIcon cookieIcon = new ImageIcon(cookieImagePath);
		Image cookieImg = cookieIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 이미지 크기 100x100
		JLabel cookieImage = new JLabel(new ImageIcon(cookieImg));
		cookieImagePanel.add(cookieImage);
		leftPanel.add(cookieImagePanel);
		
		//쿠키 이름
		JPanel cookieNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		cookieNamePanel.setLayout(null); // 위치를 설정할 수 있게 null 레이아웃 사용
		JLabel cookieLabel = new JLabel(cookieName, JLabel.CENTER);
		cookieLabel.setFont(nameFont);
		cookieLabel.setBounds(0, 5, 200, 30); // 위치와 크기 설정 (여기서 위치 조정 가능)
		cookieNamePanel.setBackground(new Color(255, 225, 145));
		cookieNamePanel.add(cookieLabel);
		leftPanel.add(cookieNamePanel);
		
		
		// 오른쪽: 코인과 수량 (GridLayout 대신 BoxLayout을 사용하여 수평으로 배치)
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS)); // 수평으로 배치
		rowPanel.add(rightPanel, BorderLayout.CENTER);
		
		for (int i = 0; i < coinTypes.length; i++) {
		// 코인 이미지 (크기 조정)
		JLabel coinLabel = createCoinLabel("img/end/" + getCoinImageName(coinTypes[i]) + ".png", 60, 60); // 이미지 크기 60x60
		rightPanel.add(coinLabel);
		
		// 코인 수량 (간격을 좁힘)
		JLabel countLabel = new JLabel(coinCounts[i], JLabel.CENTER);
		countLabel.setFont(countFont);
		rightPanel.add(countLabel);
		}
		
		rowPanel.setBackground(new Color(255, 225, 145));
		leftPanel.setBackground(new Color(255, 225, 145));
		rightPanel.setBackground(new Color(255, 240, 190));
		cookieImagePanel.setBackground(new Color(255, 225, 145));
}

    // 코인 이름을 매핑하는 함수
    private String getCoinImageName(String coinType) {
        switch (coinType) {
            case "운동":
                return "exercise";
            case "게임":
                return "game";
            case "예술":
                return "art";
            case "공부":
                return "study";
            default:
                return coinType.toLowerCase(); // 기본적으로 소문자로 반환
        }
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
            return new Font("Arial", Font.PLAIN, 24); // 기본 폰트 반환
        }
    }

    // 코인 이미지를 위한 헬퍼 메소드
    private JLabel createCoinLabel(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(img));
    }
 // 커스텀 스크롤바 UI
    class MyScrollBar extends JScrollBar {
        private Image trackImage;
        private Image thumbImage;

        public MyScrollBar(Image trackImage, Image thumbImage) {
            super();
            this.trackImage = trackImage;
            this.thumbImage = thumbImage;
            setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = new Color(255, 140, 0); // 오렌지 색상으로 설정
                    this.trackColor = new Color(255, 197, 73); // 밝은 노란색
                }

                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    if (thumbBounds.width > 0 && thumbBounds.height > 0) {
                        g.drawImage(thumbImage, thumbBounds.x, thumbBounds.y,
                                thumbBounds.width, thumbBounds.height, null);
                    }
                }
             // 위 화살표 버튼을 숨기기 위해 크기를 0, 0으로 설정
                @Override
                protected JButton createDecreaseButton(int orientation) {
                    JButton btn = new JButton();
                    btn.setPreferredSize(new Dimension(0, 0));
                    return btn;
                }

                // 아래 화살표 버튼을 숨기기 위해 크기를 0, 0으로 설정
                @Override
                protected JButton createIncreaseButton(int orientation) {
                    JButton btn = new JButton();
                    btn.setPreferredSize(new Dimension(0, 0));
                    return btn;
                }
                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                    g.drawImage(trackImage, trackBounds.x, trackBounds.y,
                            trackBounds.width, trackBounds.height, null);
                }
            });
        }
    }
} 