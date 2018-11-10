import java.util.ArrayList;
import java.util.List;

/**
 * Implements a Map using immutable Twoples.
 */
public class GenericMap <E, S> implements MapInterface <E, S>{
   /**
    * A List of Twoples.
    * The first element in the Twople represents the key.
    * The second element represent the value associate with the key.
    */
   private ArrayList< GenericTwople<E, S> > pairs =
        new ArrayList<  >( );

   /**
    * Associates a key with a value and stores the association
    * as a Twople.
    * @param key an unique object acting as an identifier
    * @param value a value to be associated with the key
    */
   public void put( E key, S value ) {
      GenericTwople<E, S> kvp = find( key );
      if ( kvp != null ) {
         pairs.remove( kvp );
      }
      pairs.add( new GenericTwople( key, value ) );
   }

   /**
    * @param key an unique object acting as an identifier
    * @return the value associated with the key
    *         or null if not found
    */
   public S get( E key ) {
      GenericTwople<E, S> kvp = find( key );
      if ( kvp != null ) {
         return kvp.getSecond( );
      }
      return null;
   }

   /**
    * @param key an unique object acting as an identifier
    * @return the Twople containing the key as its first element.
    */
   private GenericTwople<E, S> find( E key ) {
      for ( GenericTwople<E, S> kvp : pairs ) {
         if ( kvp.getFirst( ).equals( key ) ) {
            return kvp;
         }
      }
      return null;
   }

   /**
    * Removes the Twople whose first element is key,
    * if such a tuple exists in the map
    * @param key an unique object acting as an identifier
    * @return the value of the Twople removed
    *         or null if not found
    */
   public S remove( E key ) {
      GenericTwople<E, S> kvp = find( key );
      if ( kvp != null ) {
         pairs.remove( kvp );
         return kvp.getSecond( );
      }
      return null;
   }

   /**
    * @return the number of Twoples in the map.
    */
   public int size( ) { return pairs.size( ); }

   /**
    * @return true if no Twoples exist in the map, otherwise false
    */
   public boolean isEmpty( ) { return size( ) == 0; }

   /**
    * @return A list of all keys in the map
    */
   public List<E> keySet( ) {
      ArrayList<E> keys = new ArrayList( );
      for ( GenericTwople<E, S> kvp : pairs ) {
         keys.add( kvp.getFirst( ) );
      }
      return keys;
   }
}