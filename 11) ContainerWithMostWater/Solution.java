/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two
 * endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */

public class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int len = height.length;

        int pon1 = 0, pon2 = len - 1;
        int width, heightAux, area;
        while (pon1 < pon2) {
            width = pon2 - pon1;
            heightAux = (height[pon1] <= height[pon2]) ? height[pon1] : height[pon2];
            area = width * heightAux;
            answer = (answer < area) ? area : answer;

            if (height[pon1] <= height[pon2]) pon1++;
            else pon2--;
        }

        return answer;
    }
}