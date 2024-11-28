package panels;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IntroPanel extends JPanel {
	
	ImageIcon introIc = new ImageIcon("img/intro/intro.png"); // 인트로 이미지
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 화면을 비운다
		 Image resizedImage = resizeImageIcon(introIc, 0.98).getImage();
		// 인트로 화면을 그린다
		g.drawImage(resizedImage, 0, 0, /* this.getWidth(), this.getHeight(), */ null);

	}
	// 이미지 비율을 유지하면서 크기 조정
	private ImageIcon resizeImageIcon(ImageIcon originalIcon, double scale) {
		// 원본 이미지 가져오기
		Image originalImage = originalIcon.getImage();

		// 이미지 크기 조정 (비율을 유지하면서 크기 조정)
		int width = (int) (originalImage.getWidth(null) * scale);
		int height = (int) (originalImage.getHeight(null) * scale);

		// 이미지를 새 크기로 리사이징
		Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

		// 리사이징된 이미지를 새 ImageIcon으로 반환
		return new ImageIcon(resizedImage);
	}
}
