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
import panels.EndArchivePanel;
import main.listenAdapter;

import java.awt.CardLayout;

public class Main extends listenAdapter {

//	각자 DB 아이디 및 패스워드 설정하고 실행하세요.
	static String id = "";
	static String passwd = "";
	
	// 기본 캐릭터 설정
	private CookieImg ci;

//	DB 커넥션
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/schema?serverTimezone=Asia/Seoul";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("데이터베이스 연결중 ...");
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다...");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			System.out.println(e.getMessage());
		}
		return con;
	}

	
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
		
//		
		Connection con = makeConnection();

		String sql = "SELECT * FROM cookie;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			if(rs.getInt(2)==0)
				ending.endings[rs.getInt(1)].isNew = false;
		}

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
		selectPanel = new SelectPanel(this);

		endArchivePanel = new EndArchivePanel(this, ending);
		
		endPanel = new EndPanel(this,ending);
		
		introPanel.setLayout(null);
		mainPanel.setLayout(null); // MainPanel 레이아웃 설정
		gamePanel.setLayout(null);
		selectPanel.setLayout(null);
		endPanel.setLayout(null);
//		endArchivePanel.setLayout(null);

		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(mainPanel, "main"); // MainPanel을 "main"으로 추가
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");
		frame.getContentPane().add(endArchivePanel, "endArchive");
	
	    // 새로 생성된 JFrame
	    selectFrame = new JFrame("Select Map");
	    selectFrame.setBounds(100, 100, 800, 500);  // 원하는 크기 설정
	    selectFrame.setLocationRelativeTo(null);  // 화면 중앙에 위치

	    // SelectPanel을 새로 만든 frame에 추가
	    SelectPanel selectPanel = new SelectPanel(this);  // SelectPanel 객체 생성
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
		}
		else if(e.getComponent().getName().equals("selectBtn")) {
			
			frame.setVisible(true);   // 화면에 표시
			selectFrame.setVisible(false);  // 기존 main frame 숨기기 (원하는 경우에만)
			getGamePanel().selectionon = false;
			frame.getContentPane().add(gamePanel, "gamePanel");
		    cl.show(frame.getContentPane(), "gamePanel");
		    gamePanel.requestFocus();
			
		}//
	}
}