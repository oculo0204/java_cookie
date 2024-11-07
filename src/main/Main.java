package main;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ingame.CookieImg;
import panels.EndPanel;
import panels.GamePanel;
import panels.SelectPanel;

public class Main extends listenAdapter {
    private JFrame frame;
    private SelectPanel selectPanel;
    private GamePanel gamePanel;
    private EndPanel endPanel;
    private CardLayout cl;
    private CookieImg ci;

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public EndPanel getEndPanel() {
        return endPanel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl = new CardLayout(0, 0);
        frame.getContentPane().setLayout(cl);

        // IntroPanel 코드 제거
        // introPanel = new IntroPanel();
        // introPanel.addMouseListener(this);

        selectPanel = new SelectPanel(this);
        gamePanel = new GamePanel(frame, cl, this);
        endPanel = new EndPanel(this);

        // 각 패널의 레이아웃 설정
        selectPanel.setLayout(null);
        gamePanel.setLayout(null);
        endPanel.setLayout(null);

        // Frame에 패널 추가
        frame.getContentPane().add(selectPanel, "select");
        frame.getContentPane().add(gamePanel, "game");
        frame.getContentPane().add(endPanel, "end");

        // 프로그램 시작 시 selectPanel로 전환
        cl.show(frame.getContentPane(), "select");
        selectPanel.requestFocus(); // selectPanel에 포커스 설정
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // IntroPanel 클릭 처리 제거
        // if (e.getComponent().toString().contains("IntroPanel")) { ... }

        // Start 버튼 클릭 시 처리
        if (e.getComponent().getName().equals("StartBtn")) {
            if (selectPanel.getCi() == null) {
                JOptionPane.showMessageDialog(null, "캐릭터를 선택해 주세요");
            } else {
                cl.show(frame.getContentPane(), "game");
                gamePanel.gameSet(selectPanel.getCi());
                gamePanel.gameStart();
                gamePanel.requestFocus();
            }
        } else if (e.getComponent().getName().equals("endAccept")) {
            frame.getContentPane().remove(gamePanel);
            gamePanel = new GamePanel(frame, cl, this);
            gamePanel.setLayout(null);
            frame.getContentPane().add(gamePanel, "game");

            frame.getContentPane().remove(selectPanel);
            selectPanel = new SelectPanel(this);
            selectPanel.setLayout(null);
            frame.getContentPane().add(selectPanel, "select");
            cl.show(frame.getContentPane(), "select");
            selectPanel.requestFocus();
        }
    }
}
