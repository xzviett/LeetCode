class Prob2125 {

    public static int numberOfBeams(String[] bank) {
        int result = 0;
        int prevLaserBeam = 0;
        int currLaserBeam = 0;
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    currLaserBeam++;
                }
            }
            System.out.println(prevLaserBeam);
            System.out.println(currLaserBeam);
            result += (prevLaserBeam * currLaserBeam);
            System.out.println(result);
            if (currLaserBeam != 0) {
                prevLaserBeam = currLaserBeam;
            }
            currLaserBeam = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[] {"011001","000000","010100","001000"}));
    }
}