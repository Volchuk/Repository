public class testcircle{
    public static void main(String[] args) {
        // ������ ������ (���������� ������ Circle), � �� ����� �������
        // ������ � ����� � (0.0;0.0), ��������� ��� �������� �������
        // �������� �� ���������
        Circle o1 = new Circle();
        // ������� �� ����� ��������� ����������
        o1.printCircle();
        // ������ �������� ������, ���������� � �������� x
        o1.x = 3;
        // ������ ������, ���������� � �������� r
        o1.r = 12.3;
        // ������� �� ����� ���������� ��������� ����������
        o1.printCircle();
        // ������ ������ ������ ���� �� ������
        Circle o2 = new Circle();
        o2.r = 3.14;
        o2.zoomCircle(1.66);
        o2.printCircle(); // ���������� � ������� (0.0;0.0) � �������� 5.2124
    }
}