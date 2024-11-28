package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.listenAdapter;

public class IntroPanel extends JPanel {

	public JLabel introIc = new JLabel(new ImageIcon("img/intro/intro.jpg")); // 인트로 이미지
	public JTextArea id = new JTextArea();
	public JTextArea pw = new JTextArea();
	public JButton login = new JButton("로그인");
	public JButton join = new JButton("회원가입");
	public JButton confirm = new JButton("확인");
	public JButton cancel = new JButton("취소");
	public JLabel alert = new JLabel("알림창");
	MouseListener o;
	public LoginPanel lp;
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g); // 화면을 비운다
//		g.drawImage(introIc.getImage(), 0, 0, 790, 470, this);
//	}

	public class LoginPanel extends JPanel {

		public LoginPanel(MouseListener o) {
			setLayout(null);

			id.setName("id");
			pw.setName("pw");
			login.setName("login");
			join.setName("join");
			alert.setName("alert");
			confirm.setName("confirm");
			cancel.setName("cancel");

			id.setBounds(0,0, 200, 20);
			pw.setBounds(0,20, 200, 20);
			login.setBounds(0,40, 100, 20);
			join.setBounds(100,40, 100, 20);
			alert.setBounds(0,60, 200, 20);
			confirm.setBounds(0,40, 100, 20);
			cancel.setBounds(100,40, 100, 20);

			login.addMouseListener((MouseListener) o);
			join.addMouseListener((MouseListener) o);
			confirm.addMouseListener((MouseListener) o);
			cancel.addMouseListener((MouseListener) o);

			confirm.setVisible(false);
			cancel.setVisible(false);

			setOpaque(false);
//			setBackground(new Color(0,0,0,122));

			setBounds(0, 0, 800, 500);
			add(confirm);
			add(cancel);
			add(alert);
			add(id);
			add(pw);
			add(login);
			add(join);
		}

	}

	public IntroPanel(Object o) {
		this.o = (MouseListener)o;
		lp = new LoginPanel((MouseListener)o);
		introIc.setName("introIc");
		introIc.addMouseListener((MouseListener)o);
		introIc.setBounds(0,0,790,495);
		add(lp);
		add(introIc);
		lp.setVisible(false);
	}

	private Component lp(MouseListener o2) {
		// TODO Auto-generated method stub
		return null;
	}
}