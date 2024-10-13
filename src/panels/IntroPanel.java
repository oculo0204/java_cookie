package panels;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IntroPanel extends JPanel {

	ImageIcon introIc = new ImageIcon("img/intro/intro.png"); // ��Ʈ�� �̹���

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // ȭ���� ����

		// ��Ʈ�� ȭ���� �׸���
//		g.drawImage(introIc.getImage(), -60, 0, /* this.getWidth(), this.getHeight(), */ null);

	}

}
