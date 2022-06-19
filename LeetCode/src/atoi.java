public class atoi {


}

class Solution {
    public static boolean validUtf8(int[] data) {
        int len = data.length;
//        for (int i = 0; i < len; i++) {
////            if (data[i] > Byte.MAX_VALUE || data[i] < Byte.MIN_VALUE)
////                return false;
////        }
        switch (len) {
            case 1:
                return headOnes(data[0]) == 0;
            case 2:
                return headOnes(data[0]) == 2 && headOnes(data[1]) == 1;
            case 3:
                return headOnes(data[0]) == 3 && headOnes(data[1]) == 1 && headOnes(data[2]) == 1;
            case 4:
                return headOnes(data[0]) == 4 && headOnes(data[1]) == 1 && headOnes(data[2]) == 1 && headOnes(data[3]) == 1;
            default:
                return false;
        }
    }
    public static int headOnes(int data){

        if(data>=1<<7+1<<6+1<<5+1<<4+1<<3)
            return 5;
        if(data>=1<<7+1<<6+1<<5+1<<4)
            return 4;
        if(data>=1<<7+1<<6+1<<5)
            return 3;
        if(data>=1<<7+1<<6)
            return 2;
        if(data>=1<<7)
            return 1;

        return 0;

    }

    public static void main(String[] args) {
        int[] a={197,130,1};
        System.out.println(validUtf8(a));

        String str="abcdada";
        System.out.println(str.substring(1));

    }
}


/*

class Solution {
    public boolean validUtf8(int[] data) {

        // Number of bytes in the current UTF-8 character
        int numberOfBytesToProcess = 0;

        // For each integer in the data array.
        for (int i = 0; i < data.length; i++) {

            // Get the binary representation. We only need the least significant 8 bits
            // for any given number.
            String binRep = Integer.toBinaryString(data[i]);
            binRep =
                    binRep.length() >= 8
                            ? binRep.substring(binRep.length() - 8)
                            : "00000000".substring(binRep.length() % 8) + binRep;

            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfBytesToProcess == 0) {

                // Get the number of 1s in the beginning of the string.
                for (int j = 0; j < binRep.length(); j++) {
                    if (binRep.charAt(j) == '0') {
                        break;
                    }

                    numberOfBytesToProcess += 1;
                }

                // 1 byte characters
                if (numberOfBytesToProcess == 0) {
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {

                // Else, we are processing integers which represent bytes which are a part of
                // a UTF-8 character. So, they must adhere to the pattern `10xxxxxx`.
                if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) {
                    return false;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numberOfBytesToProcess -= 1;
        }

        // This is for the case where we might not have the complete data for
        // a particular UTF-8 character.
        return numberOfBytesToProcess == 0;
    }
}

*/
