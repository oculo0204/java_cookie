package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ingame.CookieImg;
import panels.EndPanel;
import panels.Endings;
import panels.GamePanel;
import panels.IntroPanel;
import panels.MainPanel; 
import panels.SelectPanel;
import panels.DB;
import panels.EndArchivePanel;
import panels.ExplainPanel;
import main.listenAdapter;

import java.awt.CardLayout;

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
	private ExplainPanel explainPanel;
	private CardLayout cl;
	private EndArchivePanel endArchivePanel;
	private SelectPanel selectPanel; // 맵 변경시 디버프 선택
	
	public JFrame selectFrame;
	
	public Endings ending = new Endings();

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

public Main() throws SQLException {
		
		initialize();
	}

private void initialize() throws SQLException {
		DB.connectionTest();
		
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
		selectPanel = new SelectPanel(this);
		explainPanel = new ExplainPanel(this);

		endArchivePanel = new EndArchivePanel(this, ending);
		
		endPanel = new EndPanel(this,ending);
		
		introPanel.setLayout(null);
		mainPanel.setLayout(null); // MainPanel 레이아웃 설정
		explainPanel.setLayout(null); 
		gamePanel.setLayout(null);
		selectPanel.setLayout(null);
		endPanel.setLayout(null);
//		endArchivePanel.setLayout(null);

		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(mainPanel, "main"); // MainPanel을 "main"으로 추가
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");
		frame.getContentPane().add(endArchivePanel, "endArchive");
		frame.getContentPane().add(explainPanel, "explain");
		
	    // 새로 생성된 JFrame
	    selectFrame = new JFrame("Select Map");
	    selectFrame.setBounds(100, 100, 800, 500);  // 원하는 크기 설정
	    selectFrame.setLocationRelativeTo(null);  // 화면 중앙에 위치

	    // SelectPanel을 새로 만든 frame에 추가
	    selectPanel = new SelectPanel(this);  // SelectPanel 객체 생성
	    selectFrame.getContentPane().add(selectPanel);  // 새 frame에 패널 추가
	    selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창 닫을 때 종료 설정
		
	}

	public JFrame getFrame() {
	    return frame;
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
				frame.getContentPane().remove(endArchivePanel);
			    endArchivePanel = new EndArchivePanel(this, ending);
//			    endArchivePanel.setLayout(null);
			    frame.getContentPane().add(endArchivePanel, "endArchive");

				cl.show(frame.getContentPane(), "endArchive");
				endArchivePanel.requestFocus();
			}

		} else if (e.getComponent().getName().equals("endAccept")) {
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
//		엔딩수집 돌아가기 버튼
		else if (e.getComponent().getName().equals("backBtn")) {
			
		    cl.show(frame.getContentPane(), "main");
		    mainPanel.requestFocus();
		}
		//설명 창으로 가기
		else if (e.getComponent().getName().equals("ExplainBtn")){
			cl.show(frame.getContentPane(), "explain");
			explainPanel.requestFocus();
		}
		else if(e.getComponent().getName().equals("selectBtn")&&selectPanel.getIsCheckedBuff()) {

			selectPanel.setIsCheckedBuff(true);
			frame.setVisible(true);   // 화면에 표시
			selectFrame.setVisible(false);  // 기존 main frame 숨기기 (원하는 경우에만)
			getGamePanel().selectionon = false;
			getGamePanel().setGameSpeed(getGamePanel().normalSpeed);
			frame.getContentPane().add(gamePanel, "gamePanel");
		    cl.show(frame.getContentPane(), "gamePanel");
		    gamePanel.requestFocus();
		    
			System.out.println(selectPanel.getSelectedBuff());
			if(selectPanel.getSelectedBuff().equals("스피드 업")) {
				getGamePanel().setGameSpeed(10);
			}
			if(selectPanel.getSelectedBuff().equals("스킵 기능 무효")) {
				getGamePanel().setGameSpeed(10);
			}
			if(selectPanel.getSelectedBuff().equals("코인 크기 감소")) { //현재 구현 불가
				getGamePanel().setGameSpeed(10);
			}
			if(selectPanel.getSelectedBuff().equals("장애물 크기 증가")) {//현재 구현 불가
				getGamePanel().setGameSpeed(10);
			}
			if(selectPanel.getSelectedBuff().equals("코인 수 감소")) { //슬라이딩으로 먹는 코인수 감소
				getGamePanel().setIsSliding(true);
			}
			if(selectPanel.getSelectedBuff().equals("코인 점수 두배")) {
				getGamePanel().setGameSpeed(10);
			}
			
		}
	
	}
}