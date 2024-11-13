package ingame;

import javax.swing.ImageIcon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapObjectImg {

	// ��� �̹���
	private ImageIcon backIc; // ���� �� ���
	private ImageIcon secondBackIc; // 2��° ���

	// ���� �̹��� �����ܵ�
	private ImageIcon jelly1Ic;
	private ImageIcon jelly2Ic;
	private ImageIcon jelly3Ic;
	private ImageIcon jelly4Ic;
	private ImageIcon jellyHPIc;

	private ImageIcon jellyEffectIc;

	// ���� �̹��� �����ܵ�
	private ImageIcon field1Ic; // ����
	private ImageIcon field2Ic; // ���߹���

	// ��ֹ� �̹��� �����ܵ�
	private ImageIcon tacle10Ic; // 1ĭ ��ֹ�
	private ImageIcon tacle20Ic; // 2ĭ ��ֹ�
	private ImageIcon tacle30Ic; // 3ĭ ��ֹ�
	private ImageIcon tacle40Ic; // 4ĭ ��ֹ�

}
