package panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public Endings endings;
	public class collection extends JPanel{
		
		public void paintComponent(Graphics g) {
			g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0,0,null);
		};
		
		JLabel name = new JLabel();
		JLabel image = new JLabel();
		Boolean isNew;
		
		public collection(Endings e, int i) {
			
			
			ImageIcon imgIcon = new ImageIcon(e.endings[i].imagePath);
			Image img = imgIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			
			image.setIcon(new ImageIcon(img));
			this.name.setText(e.endings[i].name);
			isNew = e.endings[i].isNew;
			
			FlowLayout fl = new FlowLayout();
			setLayout(fl);
			add(this.name);
			add(image);
		}
		
	}

	public class EndArchive extends JPanel{

		@Override
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		
		public EndArchive (Object o, Endings e) {
			
			
			setLayout(null);
			setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
			
			
			JPanel collections = new JPanel() {@Override
				public void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0, 0, getWidth(), getHeight(), this);
			}
			};
			GridLayout  gl = new GridLayout(4,4);
			collections.setLayout(gl);
			collection[] collectionArray = new collection[Endings.count];
			
			for(int i = 0; i<Endings.count; i++) {
				collectionArray[i] = new collection(e, i);
			}
			
			for(int i = 0; i < 13; i++) {
				collections.add(collectionArray[i]);
			}

			for(int i = 0; i < 13; i++) {
				collections.add(collectionArray[i]);
				if(collectionArray[i].isNew) {
					collectionArray[i].setVisible(false);
				}
			}
			
			collections.setBounds(100,150,600,600);
			add(collections);
			
//			뒤로가기 버튼
			JButton back = new JButton("←");
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
	
	
//	스크롤설정
	public EndArchivePanel(Object o, Endings endings) {
		Endings e = endings;
		
		EndArchive ea = new EndArchive(o, e);
		setViewportView(ea);		
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Image track = new ImageIcon("img/endArchive/track.png").getImage();
		Image thumb = new ImageIcon("img/endArchive/thumb.png").getImage();
		setVerticalScrollBar(new MyScrollBar(track, thumb));
	}


}
