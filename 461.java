class Solution {
    
    public int hammingDistance(int x, int y) {
        int times = 0;
        while(x>0 || y>0){
            if(x%2 != y%2){
                times++;
            }
            x/=2;
            y/=2;
            if(x==0 && y==0) break;
        }

        return times;
    }
}