package main;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ingame.CookieImg;
import panels.EndPanel;
import panels.GamePanel;
import panels.IntroPanel;
import panels.MainPanel; // 새로운 패널 추가
import panels.EndArchivePanel;

public class Main extends listenAdapter {

	// 기본 캐릭터 설정
	private CookieImg ci;

	public CookieImg getCi() {
		return ci;
	}

	private JFrame frame;
	private IntroPanel introPanel;
	private GamePanel gamePanel;
	private EndPanel endPanel;
	private MainPanel mainPanel; // MainPanel 변수 추가
	private CardLayout cl;
	private EndArchivePanel endArchivePanel;

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public EndPanel getEndPanel() {
		return endPanel;
	}
	public EndArchivePanel getEndArchivePanel() {
		return endArchivePanel;
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
		ci = new CookieImg(new ImageIcon("img/cookieimg/cookie1/player_origin.gif"),
				new ImageIcon("img/cookieimg/cookie1/player_up.gif"),
				new ImageIcon("img/cookieimg/cookie1/player_doubleup.gif"),
				new ImageIcon("img/cookieimg/cookie1/player_jumpend.png"),
				new ImageIcon("img/cookieimg/cookie1/player_down.gif"),
				new ImageIcon("img/cookieimg/cookie1/player_attack.png"));
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500); // 화면 크기를 1280x720으로 설정

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl = new CardLayout(0, 0);
		frame.getContentPane().setLayout(cl);

		introPanel = new IntroPanel();
		introPanel.addMouseListener(this);

		mainPanel = new MainPanel(this); // MainPanel 인스턴스 생성
		gamePanel = new GamePanel(frame, cl, this);
		endPanel = new EndPanel(this);
		endArchivePanel = new EndArchivePanel(this);

		introPanel.setLayout(null);
		mainPanel.setLayout(null); // MainPanel 레이아웃 설정
		gamePanel.setLayout(null);
		endPanel.setLayout(null);
		endArchivePanel.setLayout(null);

		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(mainPanel, "main"); // MainPanel을 "main"으로 추가
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");
		frame.getContentPane().add(endArchivePanel, "endArchive");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent().toString().contains("IntroPanel")) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			cl.show(frame.getContentPane(), "main"); // "select" 대신 "main"으로 변경
			mainPanel.requestFocus(); // mainPanel에 포커스 요청

		} else if (e.getComponent().getName().equals("StartBtn")||e.getComponent().getName().equals("EndArchiveBtn")) {
			if(e.getComponent().getName().equals("StartBtn")) {
			cl.show(frame.getContentPane(), "game");
			gamePanel.gameSet(getCi());
			gamePanel.gameStart();
			gamePanel.requestFocus();
			}
			else {
				cl.show(frame.getContentPane(), "endArchive");
				endArchivePanel.requestFocus();
			}

		}else if (e.getComponent().getName().equals("endAccept")) {
			frame.getContentPane().remove(gamePanel);
			gamePanel = new GamePanel(frame, cl, this);
			gamePanel.setLayout(null);
			frame.getContentPane().add(gamePanel, "game");

			mainPanel = new MainPanel(this);
			mainPanel.setLayout(null);
			frame.getContentPane().add(mainPanel, "main");
			cl.show(frame.getContentPane(), "main");
			mainPanel.requestFocus();
		}
	}
}