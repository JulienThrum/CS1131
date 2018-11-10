public class Lab3Problem4 {
	public static void pack(int[] array) {
		
		int temp = 0;		

		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) {
				for(int j = i; j < array.length; j++) {
					
					if(i == j) {
						temp = array[j];
					}
					
					if(j != array.length - 1) {
						array[j] = array[j + 1];
					}
					
				}
			
			array[array.length - 1] = temp;
			
			}
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		pack(new int[] {5, 2, 9, 0, 6, 8, 0, 2});
	}
}