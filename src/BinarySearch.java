public class BinarySearch {
    public int binarySearch(Term[] arr, String x) {

        int leftHand = 0;
        int rightHand = arr.length - 1;
        while (leftHand <= rightHand) {
            int mid = leftHand + (rightHand - leftHand) / 2;
            String midWord = arr[mid].word;

            // Check if x is present at mid
            if (arr[mid].word.startsWith(x)){
                return mid;}

            // If x greater, ignore left half
            if (x.compareTo(arr[mid].word) > 0)
                leftHand = mid + 1;

            // If x is smaller, ignore right half
            else
                rightHand = mid - 1;
        }
        return -1;
    }
}
