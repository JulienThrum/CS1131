/**
 * Immutable 2-tuple type.
 */
public class GenericTwople <E, S> {

   private final E first;
   private final S second;

   /**
    * Create an KeyValuePair with the provided objects.
    *
    * @param first The first object.
    * @param second The second object.
    */
   public GenericTwople(E first, S second ) {
      this.first = first;
      this.second = second;
   }

   /**
    * @return the first
    */
   public E getFirst() {
      return first;
   }

   /**
    * @return the second
    */
   public S getSecond() {
      return second;
   }

   /**
    * @return Stringified representation of the KeyValuePair instance
    */
   @Override
   public String toString() {
      return "<" + first.toString() +
           ", " + second.toString() + ">";
   }

}