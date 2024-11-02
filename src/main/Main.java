package main;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ingame.CookieImg;
import panels.EndPanel;
import panels.GamePanel;
import panels.IntroPanel;
import panels.SelectPanel;

// windowBuilder �� �����Ӹ� �����ϰ� �������� �Է�

public class Main extends listenAdapter {

	private JFrame frame; // â�� ���� ���� ������

	private IntroPanel introPanel; // ��Ʈ��

	private SelectPanel selectPanel; // ĳ���� ����

	private GamePanel gamePanel; // ��������

	private EndPanel endPanel; // ���Ӱ��

	private CardLayout cl; // ī�� �����̿� ������Ʈ

	private CookieImg ci; // ��Ű�̹���

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public EndPanel getEndPanel() {
		return endPanel;
	}

	/**
	 * Launch the application.
	 */
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
		frame.setBounds(100, 100, 800, 500); // â ������ (100,100��ǥ�� �Ʒ��� frame.setLocationRelativeTo(null) ������
												// �ǹ̰� ��������)
		frame.setLocationRelativeTo(null); // â�� ȭ�� �߾ӿ� ��ġ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ư�� ������ ����
		cl = new CardLayout(0, 0); // ī�巹�̾ƿ� ��ü ����
		frame.getContentPane().setLayout(cl); // �������� ī�巹�̾ƿ����� ����

		introPanel = new IntroPanel();
		introPanel.addMouseListener(this); // intro�г��� ���⼭ �ٷ� �ִ� ������� ���콺�����ʸ� �߰���.

		selectPanel = new SelectPanel(this); // Main�� �����ʸ� �ֱ����� this
		gamePanel = new GamePanel(frame, cl, this); // Main�� ������ �� ī�巹�̾ƿ��� �̿��ϰ� �����ʸ� �ֱ����� this
		endPanel = new EndPanel(this); // Main�� �����ʸ� �ֱ����� this

		// ��� �г��� ���̾ƿ��� null�� ��ȯ
		introPanel.setLayout(null);
		selectPanel.setLayout(null);
		gamePanel.setLayout(null);
		endPanel.setLayout(null);

		// �����ӿ� �гε��� �߰��Ѵ�.(ī�� ���̾ƿ��� ���� �гε�)
		frame.getContentPane().add(introPanel, "intro");
		frame.getContentPane().add(selectPanel, "select");
		frame.getContentPane().add(gamePanel, "game");
		frame.getContentPane().add(endPanel, "end");

	}

	@Override
	public void mousePressed(MouseEvent e) { // mouseClicked�� ���氡��
		if (e.getComponent().toString().contains("IntroPanel")) { // IntroPanel���� ���콺�� �����ٸ�
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			cl.show(frame.getContentPane(), "select"); // select�г��� ī�巹�̾ƿ� �ֻ������ ����
			selectPanel.requestFocus(); // �����ʸ� select�гο� ������ ��

		} else if (e.getComponent().getName().equals("StartBtn")) { // StartBtn�̶�� �̸��� ���� ��ư�� �����ٸ�
			if (selectPanel.getCi() == null) {
				JOptionPane.showMessageDialog(null, "ĳ���͸� ����ּ���"); // ĳ���͸� �Ȱ������� �˾�
			} else {
				cl.show(frame.getContentPane(), "game"); // ĳ���͸� ����ٸ� �����г��� ī�巹�̾ƿ� �ֻ������ ����
				gamePanel.gameSet(selectPanel.getCi()); // ��Ű�̹����� �Ѱ��ְ� �����г� ����
				gamePanel.gameStart(); // ���ӽ���
				gamePanel.requestFocus(); // �����ʸ� game�гο� ������ ��
			}

		} else if (e.getComponent().getName().equals("endAccept")) { // endAccept �̶�� �̸��� ���� ��ư�� �����ٸ�
			frame.getContentPane().remove(gamePanel); // ��� �ߴ� ���� �г��� �����ӿ��� ����
			gamePanel = new GamePanel(frame, cl, this); // �����г��� �� �гη� ��ü
			gamePanel.setLayout(null);
			frame.getContentPane().add(gamePanel, "game"); // �����ӿ� �� �����г� �߰�(ī�巹�̾ƿ� �ϴ�)

			frame.getContentPane().remove(selectPanel); // ��� �����ߴ� select�г��� ����
			selectPanel = new SelectPanel(this); // select �г��� �� �гη� ��ü
			selectPanel.setLayout(null);
			frame.getContentPane().add(selectPanel, "select"); // �����ӿ� �� select�г� �߰�(ī�巹�̾ƿ� �ϴ�)
			cl.show(frame.getContentPane(), "select"); // �� select�г��� ī�巹�̾ƿ� �ֻ������ �̵� (ȭ�鿡 ����)
			selectPanel.requestFocus(); // �����ʸ� select�гο� ������ ��
		}
	}
}
