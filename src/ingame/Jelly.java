package ingame;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jelly {
	private Image image; // ���� �̹���

	// �������� ��ǥ�� ũ��
	private int x;
	private int y;
	private int width;
	private int height;

	// ������ ���� 0���� 255������
	private int alpha;

	// ������ ����
	private int score;
	private int type;

	public int getScore() {
		return this.score;
	}

	public int getType() {
		return this.type;
	}

}
