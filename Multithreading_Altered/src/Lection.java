
public class Lection {
	
	/*
	 * 
	main - �����, ������� ��������� �������� �����
	��������� ������ ����� ����������� � ������ main
	� ���� ������� ���� ������
	������� - ������������� ��������
	
	������� �����������, ���� ���� ���� ����� ��� ���������
	
	������ - ����������� ��� ���������� ���������������
	� ����������� �������
	
	� Java ��������� ������ � JVM
	Thread Scheduler ��� ������������ ��� ��������� ������ ������� �� 
	������ ������ ��
	
	���������� ������ - ������
	��� ����� ������ ���������
	�� ����������� ��� ����������� ����� ����������
	
	���� ��������� ������
	�� 1 �� 10
	��� ������, ��� ����������� ������ ���� ������
	������ � ������� �����������
	
	10 - ��������
	1 - �������
	
	5 - default ��������
	
	�������� ������ ����� ������
	extends Thread   	��� 		implements Runnable
	�������� ������ ����� �� interface Runnable
	��-�� ����������� ������ ��������� �
	�������������� ������������ �� ���������� Runnable
	
	����� Thread ����� ����� run()
	�� �� ���������� ������
	
	����� ����� ����������� ������� start()
	
	����� interrupt ������������� �����
	�� ����� �� �����������, ������ Thread Scheduler 
	
	����� join(long millisec) - ���� ������ �����
	�������� ����� join() � ������� ������, �� ������
	����� ������������ �� ��� ���� ���� ������ ����� ��
	�������� ���� ������, ��� �� ������������� ����� �
	�������������
	
	���� ������ t1, main
	t1.join(50000);
	����� t1 �����������,
	� main ��� ����� ���������� t1
	
	���� ����� ������� Exception, �� ��� ������ ������
	
	Exception ����� ������ � ������ run() ������� ������
	
	����� ���������������� ������ ��� ����� ������ ����
	private void synchronized set() {}
	synchronized
	(this)
	
	������������������ ����� "�����" �� ������, ���
	������������������ ����
	
	synchorinized ����� �����������, ��� ���� �����
	�� ����� ����������� ����������� ��������
	� ������ �����
	�� � ������� ������ ���� ����
	
	� volatile �������� ���������� � ����� ������
	
	������ � ������ - ��������� ��������
	������ ����������� �� ���� ���,
	����� ��� ������ � ������ double, long
	�������� ����� ����� �������� �������� ����� volatile
	
	private volatile long value
	
	wait-notify ������ ������, ���
	synchronized ����� ������ ���� ���������� �� ������
	� ��� ������������ ���� �����
	� ��������� ������ ���������� ping �������
	��������� "�� ��� ��������? �� ��� ��������? � ������?"
	��� �������� �����
	
	wait()-notify() �������� ��� ���������
	wait() �������� �� ������ ������� ������, ������� �� ping'����
	����� ���� ���������� ����, �� notify() �������� �����
	��� ������ ��������
	
	notifyAll() ���������� ��� ������, ��� ���� ��������
	
	*/
}
