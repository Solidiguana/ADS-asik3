public class Sorter {

    public void basicSort(int[] arr) { //insertion
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public void advancedSort(int[] arr) { //merge
        if(arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left_half = new int[mid];
        int[] right_half = new int[arr.length - mid];

        System.arraycopy(arr, 0, left_half, 0, mid);
        System.arraycopy(arr, mid, right_half, 0, arr.length - mid);

        advancedSort(left_half);
        advancedSort(right_half);

        merge(arr, left_half, right_half);

    }

    public void merge(int[] arr, int[] left_half, int[] right_half){
        int i = 0, j = 0, k = 0;
        while(i < left_half.length && j < right_half.length){
            if(left_half[i] <= right_half[j]){
                arr[k++] = left_half[i++];
            }
            else{
                arr[k++] = right_half[j++];
            }
        }
        while(i < left_half.length){
            arr[k++] = left_half[i++];
        }
        while(j < right_half.length){
            arr[k++] = right_half[j++];
        }
    }
}
