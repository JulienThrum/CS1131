public class Lab3Problem2{
	public static void main(String[]args){
		//int [8] myArray;
		int [] myArray = new int[6];
		int foo = myArray.length-1;
		int temp = 0;
		for(int i=0; i<6; i++){
			myArray[i] = (int) Math.pow(2,i);
		}
		
		while(foo > 0){
			System.out.println(myArray[foo]);
			foo--;
		}
		
	}
}