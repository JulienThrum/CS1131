import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

   @Test
   public void testToString( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      String expected = "<Queue:[]>";
      String result = queue.toString( );
      if ( !expected.equals( result ) ) {
         fail( String.format( "toString( ) returned \"%s\", expected \"%s\"", result, expected ) );
      }
      for(int i = 1; i < 6; i++) {
         queue.enqueue( i );
      }
      expected = "<Queue:[1, 2, 3, 4, 5]>";
      result = queue.toString( );
      if ( !expected.equals( result ) ) {
         fail( String.format( "toString( ) returned \"%s\", expected \"%s\"", result, expected ) );
      }
   }

   @Test
   public void testString( ) {
      Queue< String > queue = new Queue< String >( );
      for(int i = 1; i < 6; i++) {
         queue.enqueue( "" + i );
      }
      for(int i = 1; i < 7; i++) {
      String expected = "" + i;
      try{
      String result = queue.dequeue( );
      if ( !expected.equals( result ) ) {
         fail( String.format( "dequeue( ) returned \"%s\", expected \"%s\"", result, expected ) );
      }
      } catch ( QueueEmptyException e )  {
         if ( i != 6 ) {
            throw(e);
         }
      }
      }
   }

   @Test
   public void testIsEmpty( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      boolean expected = true;
      boolean result = queue.isEmpty( );
      if ( result != expected ) {
         fail( "new Queue( ) is not empty." );
      }
   }

   @Test
   public void testIsNotEmpty( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      queue.enqueue( 1 );
      boolean expected = false;
      boolean result = queue.isEmpty( );
      if ( result != expected ) {
         fail( "Populated Queue is empty." );
      }
      if ( queue.size( ) != 1 ) {
         fail( String.format( "Populated Queue has size=%s, expected 1.",
               queue.size( ) ) );
      }
   }

   @Test
   public void testPeek( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      try {
         queue.peek( );
         fail( "peek( ) did not throw error when queue is empty." );
      } catch ( QueueEmptyException e ) {
         
      }
      queue.enqueue( 1 );
      int expected = 1;
      int result = queue.peek( );
      if ( result != expected ) {
         fail( String.format( "After enqueue( 1 ), peek( ) returned %s, expected %s.", result, expected ) );
      }
   }

   @Test
   public void testDequeue( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      try {
         queue.dequeue( );
         fail( "dequeue( ) did not throw error when queue is empty." );
      } catch ( QueueEmptyException e ) {
         
      }
      queue.enqueue( 1 );
      int expected = 1;
      int result = queue.dequeue( );
      if ( result != expected ) {
         fail( String.format( "After enqueue( 1 ), dequeue( ) returned %s, expected %s.", result, expected ) );
      }
   }

   @Test
   public void testEnqueueDequeue( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      queue.enqueue( 1 );
      int expected = 1;
      int result = queue.dequeue( );
      if ( result != expected ) {
         fail( String.format(
               "After enqueue(1) Dequeue( ) returned %s, expected %s.", result,
               expected ) );
      }
      if ( !queue.isEmpty( ) ) {
         fail( String.format(
               "After enqueue(1) dequeue( ), Queue is not empty. Queue is %s",
               queue ) );
      }
      if ( queue.size( ) != 0 ) {
         fail( String.format(
               "After enqueue(1) dequeue( ), size is not 0. size is %s Queue is %s",
               queue.size( ), queue ) );
      }
   }

   @Test
   public void testEnqueueDequeueEnqueueDequeue( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      queue.enqueue( 1 );
      queue.dequeue( );
      queue.enqueue( 2 );
      if ( queue.isEmpty( ) ) {
         fail( String.format(
               "After enqueue(1) dequeue( ) enqueue(2), Queue is empty. Queue is %s",
               queue ) );
      }
      if ( queue.size( ) != 1 ) {
         fail( String.format(
               "After enqueue(1) dequeue( ) enqueue(2), size is not 1. size is %s Queue is %s",
               queue.size( ), queue ) );
      }
      int expected = 2;
      int result = queue.dequeue( );
      if ( result != expected ) {
         fail( String.format(
               "After enqueue(1) dequeue( ) enqueue(2), dequeue( ) returned %s, expected %s.",
               result, expected ) );
      }
      if ( !queue.isEmpty( ) ) {
         fail( String.format(
               "After enqueue(1) dequeue( ) enqueue(2) dequeue( ), Queue is not empty. Queue is %s",
               queue ) );
      }
      if ( queue.size( ) != 0 ) {
         fail( String.format(
               "After enqueue(1) dequeue( ) enqueue(2) dequeue( ), size is not 0. size is %s Queue is %s",
               queue.size( ), queue ) );
      }
   }

   @Test
   public void testMultipleEnqueueDequeue( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      for ( int i = 0; i < 10000; i++ ) {
         queue.enqueue( i );
         if ( queue.isEmpty( ) ) {
            fail( String.format(
                  "After enqueue(%d), Queue is empty. Queue is %s", i,
                  queue ) );
         }
         if ( queue.size( ) != 1 ) {
            fail( String.format(
                  "After enqueue(%d), size is not 1. size is %s Queue is %s", i,
                  queue.size( ), queue ) );
         }
         int expected = i;
         int result = queue.dequeue( );
         if ( result != expected ) {
            fail( String.format(
                  "After enqueue(%d), dequeue( ) returned %s, expected %s.", i,
                  result, expected ) );
         }
         if ( !queue.isEmpty( ) ) {
            fail( String.format(
                  "After enqueue(%d) dequeue( ), Queue is not empty. Queue is %s",
                  i, queue ) );
         }
         if ( queue.size( ) != 0 ) {
            fail( String.format(
                  "After enqueue(%d) dequeue( ), size is not 0. size is %s Queue is %s",
                  i, queue.size( ), queue ) );
         }
      }
   }

   @Test
   public void testMultipleEnqueueMultipleDequeue( ) {
      Queue< Integer > queue = new Queue< Integer >( );
      for ( int i = 0; i < 10000; i++ ) {
         queue.enqueue( i );
         if ( queue.isEmpty( ) ) {
            fail( String.format(
                  "After enqueue(%d), Queue is empty. Queue is %s", i,
                  queue ) );
         }
         if ( queue.size( ) != i + 1 ) {
            fail( String.format(
                  "After enqueue(%d), size is not %d. size is %s Queue is %s",
                  i, i + 1, queue.size( ), queue ) );
         }
      }
      for ( int i = 0; i < 10000; i++ ) {
         int expected = i;
         int result = queue.peek( );
         if ( result != expected ) {
            fail( String.format(
                  "After multiple enqueue( ) multiple dequeu( ), peek( ) returned %s, expected %s.", i,
                  result, expected ) );
         }
         result = queue.dequeue( );
         if ( result != expected ) {
            fail( String.format(
                  "After enqueue(%d), dequeue( ) returned %s, expected %s.", i,
                  result, expected ) );
         }
         if ( queue.size( ) != 10000 - ( i + 1 ) ) {
            fail( String.format(
                  "After multiple enqueue( ) multiple dequeue( ), size is not %d. size is %s Queue is %s",
                  10000 - (i + 1), queue.size( ), queue ) );
         }
      }
      if ( !queue.isEmpty( ) ) {
         fail( String.format(
               "After multiple enqueue( ) and multiple dequeue( ), Queue is not empty. Queue is %s",
                queue ) );
      }
   }

}
