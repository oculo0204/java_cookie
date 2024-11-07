package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ingame.CookieImg;
import panels.EndPanel;
import panels.GamePanel;
import panels.IntroPanel;
import panels.SelectPanel;
import main.listenAdapter;

import java.awt.CardLayout;

public class Main extends listenAdapter {

	private JFrame frame;
	private IntroPanel introPanel;
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

		introPanel = new IntroPanel();
		introPanel.addMouseListener(this);
		
		selectPanel = new SelectPanel(this);
		gamePanel = new GamePanel(frame, cl, this);
		endPanel = new EndPanel(this);

		introPanel.setLayout(null);
		selectPanel.setLayout(null);
		gamePanel.setLayout(null);
		endPanel.setLayout(null);

		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(selectPanel, "select");
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent().toString().contains("IntroPanel")) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			cl.show(frame.getContentPane(), "select");
			selectPanel.requestFocus();
			
		} else if (e.getComponent().getName().equals("StartBtn")) {
			if (selectPanel.getCi() == null) {
				JOptionPane.showMessageDialog(null, "Please select a character.");
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
