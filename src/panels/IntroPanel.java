package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
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
import javax.swing.JTextField;

import main.listenAdapter;

public class IntroPanel extends JPanel {

	public JLabel introIc = new JLabel(new ImageIcon("img/intro/intro.jpg")); // 인트로 이미지
	public JTextField id = new JTextField();
	public JTextField pw = new JTextField();
	public JLabel login = new JLabel(new ImageIcon("img/intro/login.png"));
	public JLabel join = new JLabel(new ImageIcon("img/intro/join.png"));
	public JLabel confirm = new JLabel(new ImageIcon("img/intro/confirm.png"));
	public JLabel cancel = new JLabel(new ImageIcon("img/intro/cancel.png"));
	public JLabel alert = new JLabel("알림창");
	MouseListener o;
	public LoginPanel lp;
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g); // 화면을 비운다
//		g.drawImage(introIc.getImage(), 0, 0, 790, 470, this);
//	}

	public class LoginPanel extends JPanel {

//		폰트 설정
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
		
		public LoginPanel(MouseListener o) {
			setLayout(null);

			id.setName("id");
			pw.setName("pw");
			login.setName("login");
			join.setName("join");
			alert.setName("alert");
			confirm.setName("confirm");
			cancel.setName("cancel");

			id.setBounds(350,150, 200, 20);
			pw.setBounds(350,210, 200, 20);
			login.setBounds(250,320, 100, 50);
			join.setBounds(390, 320, 150, 50);
			alert.setBounds(200,280, 400, 30);
			confirm.setBounds(270,320, 100, 50);
			cancel.setBounds(410,320, 100, 50);
			
			id.setBackground(new Color(241,137,100));
			id.setBorder(null);

			pw.setBackground(new Color(241,137,100));
			pw.setBorder(null);
			
			Font cookieRunBlack = loadCustomFont("fonts/CookieRun Regular.otf", 20f);
			alert.setForeground(new Color(250,0,0));
			alert.setHorizontalAlignment(JLabel.CENTER);
			alert.setFont(cookieRunBlack);
			
			login.addMouseListener((MouseListener) o);
			join.addMouseListener((MouseListener) o);
			confirm.addMouseListener((MouseListener) o);
			cancel.addMouseListener((MouseListener) o);

			confirm.setVisible(false);
			cancel.setVisible(false);

			setOpaque(false);

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