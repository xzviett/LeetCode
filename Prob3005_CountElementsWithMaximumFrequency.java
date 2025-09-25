public class Prob3005_CountElementsWithMaximumFrequency {

    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            if (freq[nums[i]] > maxFreq) {
                maxFreq = freq[nums[i]];
            }
        }
        int result = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == maxFreq) 
                result += freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1}));
    
    }
}
