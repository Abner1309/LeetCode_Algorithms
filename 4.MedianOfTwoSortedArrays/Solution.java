/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;
        double med = 0.0;
        int[] nums3 = new int[len3];

        int a = 0, b = 0, i = 0;
        while (a < len1 && b < len2) {
            if (nums1[a] <= nums2[b]) {
                nums3[i] = nums1[a];
                a++;
                i++;
            }
            else {
                nums3[i] = nums2[b];
                b++;
                i++;
            }
        }

        while (a < len1) {
            nums3[i] = nums1[a];
            a++;
            i++;
        }

        while (b < len2) {
            nums3[i] = nums2[b];
            b++;
            i++;
        }

        if (len3 % 2 == 0) {
            med = (nums3[(len3 - 1) / 2] + nums3[((len3 - 1) / 2) + 1]) / 2.00;
        }
        else {
            med = (nums3[(len3 - 1) / 2]);
        }

        return med;
    }
}