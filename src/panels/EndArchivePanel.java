package panels;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import main.listenAdapter;

public class EndArchivePanel extends JScrollPane {
	
	private boolean[] isNew = new boolean[Endings.count];
	public Endings endings;
	public class collection extends JPanel{

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
		
		public void paintComponent(Graphics g) {
			g.drawImage(new ImageIcon("img/endArchive/frame.png").getImage(), 0,0,null);
		};
		
		JLabel name = new JLabel();
		JLabel image = new JLabel();
		
		public collection(Endings e, int i) throws SQLException {

			Font cookieRunBlack = loadCustomFont("fonts/CookieRun Regular.otf", 20f);
			this.name.setFont(cookieRunBlack);
			ImageIcon imgIcon = new ImageIcon(e.endings[i].imagePath);
			Image img = imgIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			
			
			if(isNew[i]) {
				this.name.setText("???");
				image.setIcon(new ImageIcon("img/endArchive/background.png"));
			}
			else {
				image.setIcon(new ImageIcon(img));
				this.name.setText(e.endings[i].name);
				
			}
			image.setHorizontalAlignment(JLabel.CENTER);
			name.setHorizontalAlignment(JLabel.CENTER);
			
			setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
			
			setPreferredSize(new Dimension(160,180));
			BorderLayout bl = new BorderLayout();
			setLayout(bl);
			add(image);
			add(this.name, "South");
		}
		
	}

	public class EndArchive extends JPanel{

		@Override
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		
		public EndArchive (Object o, Endings e) throws SQLException {
			
			
			setLayout(null);
			setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
			
			
			JPanel collections = new JPanel() {
				public void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0, 0, getWidth(), getHeight(), this);
			}
			};
		
			collections.setLayout(new FlowLayout());
			collection[] collectionArray = new collection[Endings.count];
			
			for(int i = 0; i<Endings.count; i++) {
				collectionArray[i] = new collection(e, i);
			}
			
			for(int i = 0; i < 13; i++) {
				collections.add(collectionArray[i]);
			}

		
			collections.setBounds(50,100,700,900);
			add(collections);
			
			
//			타이틀
			JLabel title= new JLabel();
			title.setIcon(new ImageIcon("img/endArchive/title.png"));
			title.setBounds(200,10,380,80);
			add(title);
			
//			뒤로가기 버튼
			JButton back = new JButton();
			ImageIcon backIcon = new ImageIcon("img/endArchive/back.png");
			Image backImg = backIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			
			back.setIcon(new ImageIcon(backImg));
			back.setBorderPainted(false);
			back.setContentAreaFilled(false);
			back.setName("backBtn");
			back.setBounds(20,20,50,50);
			back.addMouseListener((MouseListener)o);
			add(back);
			
			
		}	
	}
//	커스텀 스크롤바 디자인
	public class MyScrollBar extends JScrollBar {
		public MyScrollBar(Image track, Image thumb) {
			super(JScrollBar.VERTICAL);
			setUI(new BasicScrollBarUI() {
				@Override
				protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
					g.drawImage(track, r.x, r.y, r.width, r.height, null);
				}
				@Override
				protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
					g.drawImage(thumb, r.x, r.y, r.width, r.height, null);
				}
				@Override
				protected JButton createDecreaseButton(int orientation) {
					JButton btn = new JButton();
				    btn.setPreferredSize(new Dimension(0, 0));
					return btn;}
				@Override
				protected JButton createIncreaseButton(int orientation) {
					JButton btn = new JButton();
				    btn.setPreferredSize(new Dimension(0, 0));
					return btn;}
			});
		}
	}
	
	public void setIsNewArray(boolean[] array) {
		System.out.println("엔딩패널 업데이트");
		for(int i = 0; i < Endings.count; i++) {
			try {
				array[i] = DB.getIsNew(i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public EndArchivePanel(Object o, Endings endings){
		Endings e = endings;
		setIsNewArray(isNew);
        // 배열 요소 하나씩 출력
//        for (int i = 0; i < isNew.length; i++) {
//            System.out.println("isNew[" + i + "] = " + isNew[i]);
//        }
		EndArchive ea;
		try {
			ea = new EndArchive(o, e);
			setViewportView(ea);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Image track = new ImageIcon("img/endArchive/track.png").getImage();
		Image thumb = new ImageIcon("img/endArchive/thumb.png").getImage();
		setVerticalScrollBar(new MyScrollBar(track, thumb));
		

        revalidate();
        repaint();
	}


}