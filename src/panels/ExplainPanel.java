package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class ExplainPanel extends JPanel {
	
    public ExplainPanel(Object o) {
        setLayout(new BorderLayout(0, 20)); // 상하 간격 설정


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

        // 여러 쿠키와 코인 정보를 담을 패널
        JPanel mainPanel = new JPanel(new GridLayout(10, 1, 0, 10)); // 총 10개의 행, 각 행 간격 10px

        // JScrollPane을 이용해 mainPanel을 감싸서 스크롤 기능 추가
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 항상 세로 스크롤바 보이기
        add(scrollPane, BorderLayout.CENTER);

        // 쿠키 추가
        addCookieRow(mainPanel, "옥황상제", "img/endings/옥황상제.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x100", ">= x50", ">= x100", ">= x100"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "프로게이머", "img/endings/프로게이머.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"< x30", ">= x50", "< x30", ">= x50"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "요리사", "img/endings/요리사.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= x50", "< x30", ">= x50", "< x30"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "백수", "img/endings/백수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"< x50", "< x50", "< x50", "< x50"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "교수", "img/endings/교수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", "anyway", ">= x80"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "프로그래머", "img/endings/프로그래머.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", "anyway", ">= x50"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "국가대표", "img/endings/국가대표.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= 80", "anyway", "anyway", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "아마추어 운동선수", "img/endings/아마추어 운동선수.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{">= 50", "anyway", "anyway", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "피아니스트", "img/endings/피아니스트.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", ">= 80", "anyway"},
                cookieRunBlack, cookieRunRegular);

        addCookieRow(mainPanel, "화가", "img/endings/화가.png",
                new String[]{"운동", "게임", "예술", "공부"},
                new String[]{"anyway", "anyway", ">= 50", "anyway"},
                cookieRunBlack, cookieRunRegular);
        

        // 개발자명 하단 오른쪽에 배치
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬
        JLabel personLabel = new JLabel("개발자: 자바 쿠키(장서원, 이주연, 박가연, 이하경)");
        personLabel.setFont(cookieRunRegular);
        bottomPanel.add(personLabel);

        // 스크롤의 하단에 개발자명 패널 추가
        add(bottomPanel, BorderLayout.SOUTH);
    	}
    

    	// 쿠키와 코인 정보 추가 메서드
    	private void addCookieRow(JPanel panel, String cookieName, String cookieImagePath,
                              String[] coinTypes, String[] coinCounts, Font nameFont, Font countFont) {
        JPanel rowPanel = new JPanel(new BorderLayout(10, 0)); // 좌우 간격 10px
        panel.add(rowPanel);

        // 왼쪽: 쿠키 이미지와 이름
        JPanel leftPanel = new JPanel(new GridLayout(2, 1, 0, 5)); // 쿠키 이미지와 이름 사이 간격 5px
        rowPanel.add(leftPanel, BorderLayout.WEST);

        // 쿠키 이미지 (크기 조정) + 왼쪽 여백 추가
        JPanel cookieImagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0)); // 왼쪽 간격 20px
        ImageIcon cookieIcon = new ImageIcon(cookieImagePath);
        Image cookieImg = cookieIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // 이미지 크기 100x100
        JLabel cookieImage = new JLabel(new ImageIcon(cookieImg));
        cookieImagePanel.add(cookieImage);
        leftPanel.add(cookieImagePanel);

        // 쿠키 이름
        JLabel cookieLabel = new JLabel(cookieName, JLabel.CENTER);
        cookieLabel.setFont(nameFont);
        leftPanel.add(cookieLabel);

        // 오른쪽: 코인과 수량
        JPanel rightPanel = new JPanel(new GridLayout(1, coinTypes.length, 5, 0)); // 코인 타입 개수만큼 열 생성, 간격 5px
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
} 