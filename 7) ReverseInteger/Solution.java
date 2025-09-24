public class Solution {
    public int reverse(int x) {
        int answer = 0;
        int len;
        String num_str = Integer.toString(x);
        StringBuilder num_sb = new StringBuilder(num_str);
        len = num_sb.length();
        num_sb = num_sb.reverse();

        if (num_sb.charAt(len-1) == '-') {
            num_sb.deleteCharAt(len-1);
            num_sb.insert(0, '-');            
            len = num_sb.length();
        }

        long min = (long) -Math.pow(2, 31);
        long max = (long) Math.pow(2, 31) - 1;
        long aux = Long.parseLong(num_sb.toString());
        if (aux < min || aux > max) {
            return 0;
        }

        answer = Integer.parseInt(num_sb.toString());
        return answer;
    }
}
