public class Prob165_CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        int[] ver1 = new int[s1.length];
        String[] s2 = version2.split("\\.");
        int[] ver2 = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            ver1[i] = Integer.parseInt(s1[i]);
        }

        for (int i = 0; i < s2.length; i++) {
            ver2[i] = Integer.parseInt(s2[i]);
        }
        
        //System.out.println(Arrays.toString(ver1));
        //System.out.println(Arrays.toString(ver2));
        int i = 0, j = 0;
        while (i < ver1.length && j < ver2.length) {
            if (ver1[i] > ver2[j]) {
                return 1;
            } 
            if (ver1[i] < ver2[j]) {
                return -1;
            }
            i++; j++;
        }
    
        while (i < ver1.length) {
            if (ver1[i] != 0) {
                return 1;
            }
            i++;
        }
        

        while (j < ver2.length) {
            if (ver2[j] != 0) {
                return -1;
            }
            j++;
        }

        return 0;
        
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1"));
        
    }
}