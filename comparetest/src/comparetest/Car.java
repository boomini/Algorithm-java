package comparetest;

public class Car implements Comparable<Car>{
	private int carNum;
	private String carName;
	private String maker;
	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "Car [carNum=" + carNum + ", carName=" + carName + ", maker=" + maker + "]";
	}
	//����ȣ�� compare�Ͽ� �����ϱ�
	@Override
	public int compareTo(Car car) {
		if(this.carNum > car.carNum) { //��������
//		if(this.carNum < car.carNum) {
			//��������
			return -1;
		}else if(this.carNum == car.carNum) {
			return 0;
		}else {
			return 1;
		}
	}
	//���̸����� compare�Ͽ� �����ϱ�
//	@Override
//	public int compareTo(Car car) {
//		if(this.carName.compareTo(car.carName) > 0) {
//			//return 1;//��������
//			return -1;//��������
//		}else if(this.carName.compareTo(car.carName) < 0) {
//			//return -1;//��������
//			return 1; //��������
//		}else {
//			return 0;
//		}
//		
//		//return this.carName.compareTo(car.carName);
//	}
	
}
