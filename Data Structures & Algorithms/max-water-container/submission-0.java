class Solution {
    public int maxArea(int[] height) {
        int area=0,farea=0;
        int l=0;
        int r=height.length-1;
        while(l<r)
        {
             area=Math.min(height[l],height[r])*(r-l);
             farea=Math.max(area,farea);
            if(height[l]<height[r])
            l++;
            else
            r--;
         }
        
       return farea; 
    }
}