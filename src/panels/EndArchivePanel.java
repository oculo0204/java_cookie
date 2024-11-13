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
	
	public class collection extends JPanel{

		public void paintComponent(Graphics g) {
			g.drawImage(new ImageIcon("img/endArchive/background.png").getImage(), 0,0,null);
		};
		
		JLabel name = new JLabel();
		JLabel image = new JLabel();
		Boolean isNew;
		
		public collection(String ImagePath, String name){
			ImageIcon imgIcon = new ImageIcon(ImagePath);
			Image img = imgIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
			
			image.setIcon(new ImageIcon(img));
			this.name.setText(name);
			isNew = false;
			
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
		
		public EndArchive (Object o) {
			
			
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
			collection[] collectionArray = new collection[13];
			
			collectionArray[0] = new collection("img/endings/1.png", "옥황상제");
			collectionArray[1] = new collection("img/endings/2.png", "피아니스트");
			collectionArray[2] = new collection("img/endings/3.png", "화가");
			collectionArray[3] = new collection("img/endings/4.png", "아마추어 운동선수");
			collectionArray[4] = new collection("img/endings/5.png", "운동선수");
			collectionArray[5] = new collection("img/endings/6.png", "국가대표 운동선수");
			collectionArray[6] = new collection("img/endings/7.png", "가수");
			collectionArray[7] = new collection("img/endings/8.png", "프로그래머");
			collectionArray[8] = new collection("img/endings/9.png", "요리사");
			collectionArray[9] = new collection("img/endings/10.png", "백수");
			collectionArray[10] = new collection("img/endings/11.png", "프로게이머");
			collectionArray[11] = new collection("img/endings/12.png", "교수");
			collectionArray[12] = new collection("img/endings/13.png", "의사");
			
			for(int i = 0; i < 13; i++) {
				collections.add(collectionArray[i]);
			}

			for(int i = 0; i < 13; i++) {
				collections.add(collectionArray[i]);
				if(collectionArray[i].isNew) {
					collectionArray[i].setVisible(false);
				}
			}
			
			collections.setBounds(100,50,600,600);
			add(collections);
			
//			뒤로가기 버튼
			Button back = new Button("←");
			back.setName("backBtn");
			back.setBounds(0,0,50,50);
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
	public EndArchivePanel(Object o) {
		
		EndArchive ea = new EndArchive(o);
		setViewportView(ea);		
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Image track = new ImageIcon("img/endArchive/track.png").getImage();
		Image thumb = new ImageIcon("img/endArchive/thumb.png").getImage();
		setVerticalScrollBar(new MyScrollBar(track, thumb));
	}


}

