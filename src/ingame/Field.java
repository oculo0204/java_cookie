package ingame;

import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {

	private Image image; // ���� �̹���

	// ������ ��ǥ�� ���� ����
	private int x;
	private int y;
	private int width;
	private int height;
}
