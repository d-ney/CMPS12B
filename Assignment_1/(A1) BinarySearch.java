//-----------------------------------------------------------------------------
// BinarySearch.java
//-----------------------------------------------------------------------------

class BinarySearch {

   // binarySearch()
   // pre: Array A[p..r] is sorted
   static int binarySearch(int[] A, int p, int r, int target){
      int q;
      if(p > r) {
         return -1;
      }else{
         q = (p+r)/2;
         if(target == A[q]){
            return q;
         }else if(target < A[q]){
            return binarySearch(A, p, q-1, target);
         }else{ // target > A[q]
            return binarySearch(A, q+1, r, target);
         }
      }
   }

   public static void main(String[] args) {
   
      int[] B = {1,2,3,4,5,6,7,8,9,10};

      System.out.println(binarySearch(B, 0, B.length-1, 7));
      System.out.println(binarySearch(B, 0, B.length-1, 2));
      System.out.println(binarySearch(B, 0, B.length-1, 11));
   }
}


            
      
