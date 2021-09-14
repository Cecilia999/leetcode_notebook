import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] nums) {
        if(nums.length==0) return "";
        
        String[] snum = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            snum[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(snum, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                
                //accending order
                return str1.compareTo(str2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;     //用例中有leading zero的edge case
        for (int i = 0; i < snum.length; i++) {
            if(!snum[i].equals("0"))
                leadingZero=false;
            sb.append(snum[i]);
        }
        
        if(leadingZero)
            return "0";
        return sb.toString();
    }
}