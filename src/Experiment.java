import java.util.Arrays;
import java.util.Random;

public class Experiment {
    private Searcher searcher;
    private Sorter sorter;

    public Experiment(Searcher searcher, Sorter sorter){
        this.searcher = searcher;
        this.sorter = sorter;
    }

    public long measureSortTime(int[] arr, String type){
        long startTime = System.nanoTime();
        if(type.equalsIgnoreCase("basic")){
            sorter.basicSort(arr);
        }
        else if(type.equalsIgnoreCase("advanced")){
            sorter.advancedSort(arr);
        }
        else{
            System.out.println("Invalid sort type");
        }
        return System.nanoTime() - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - startTime;
    }

    public void runAllExperiments(){
        int[] sizes = {10, 100, 1488};

        System.out.println("ALGORITHM PERFORMANCE ANALYSIS\n");
        for(int size : sizes){
            System.out.println("Testing Array Size: " + size);

            int[] randomArr = sorter.generateRandomArray(size);

            int[] arrForBasic = Arrays.copyOf(randomArr, randomArr.length);
            int[] arrForAdvanced = Arrays.copyOf(randomArr, randomArr.length);

            long basicRandomTime = measureSortTime(arrForBasic, "basic");
            long advancedRandomTime = measureSortTime(arrForAdvanced, "advanced");

            long basicSortedTime = measureSortTime(arrForBasic, "basic");
            long advancedSortedTime = measureSortTime(arrForAdvanced, "advanced");

            Random random = new Random();
            int randomIndex = random.nextInt(size);
            int target =arrForBasic[randomIndex];
            long searchTime = measureSearchTime(arrForBasic, target);

            System.out.printf("Insertion Sort (Random generated) : %10d ns\n", basicRandomTime);
            System.out.printf("Merge Sort     (Random generated) : %10d ns\n", advancedRandomTime);
            System.out.printf("Insertion Sort (Already sorted) : %10d ns\n", basicSortedTime);
            System.out.printf("Merge Sort     (Already sorted) : %10d ns\n", advancedSortedTime);
            System.out.printf("Binary Search (find %-4d): %10d ns\n", target, searchTime);
        }
    }
}
