import java.util.List;

/**
 * Test driver for the ObjectPair class.
 */
public class GenericDriver {

   /**
    * Create several stadium associations,
    * then print the name of the stadium
    * with the largest capacity.
    *
    * @param args Not used.
    */
   public static void main(String[] args) {
      GenericMap<String, Integer> stadiums = new GenericMap<>();
      stadiums.put("Bridgeforth Stadium", 25000);
      stadiums.put("Michigan Stadium", 109901);
      stadiums.put("Lane Stadium", 66233);

      System.out.println("Bridgeforth Stadium: " +
           stadiums.get( "Bridgeforth Stadium" ));

      String largestStadium = largestStadium( stadiums );
      System.out.println(largestStadium + ": " +
           stadiums.get( largestStadium ));
   }

   /**
    * Returns the name of the stadium with the largest capacity.
    *
    * @param stadiumsMap A map of GenericTwoples where each Twople
    *                    contains a stadium name followed by an
    *                    integer capacity
    * @return The name of the stadium with the largest capacity
    */
   public static String largestStadium( GenericMap<String, Integer> stadiumsMap ) {
      List<String> names = stadiumsMap.keySet();

      int largest = stadiumsMap.get(names.get(0));
      int largestIndex = 0;
      int temp = Integer.MIN_VALUE;

      for(int i = 0; i < stadiumsMap.size(); i++) {
         temp = stadiumsMap.get(names.get(i));

         if(temp > largest) {
            largest = temp;
            largestIndex = i;
         }
      }

      return names.get(largestIndex);
   }

}