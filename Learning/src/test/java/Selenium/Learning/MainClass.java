package Selenium.Learning;


public class MainClass {
	
	int[] data = new int[10];
	
	public void Array() {
        for(int i = 0; i < data.length; i++) {
            data[i] = i*10;
        }
    }
	public static void main(String[] args) {
		MainClass m = new MainClass();
		
		for (int i=0; i<3; i++) {
		
		m.data[i]=i;
		System.out.println(m.data[i]);
		
		

	}

}
}
