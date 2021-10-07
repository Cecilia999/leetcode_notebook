//分为less than 20
//每10：tens
//每1000：thousands
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "TEN", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        String res = "";
        int i=0;
        
        while(num>0){
            if(num%1000 != 0){
                //calculate num % 1000的余数
                res = calculate(num%1000) + THOUSANDS[i] + " " + res;
            }
            num/=1000;
            i++;
        }
        
        return res.trim();   //String.trim() 除掉string前后的space
    }
    
    //0<=num<1000
    public String calculate(int num){
        if(num==0){
            return "";
        }
        else if(num<20){
            return LESS_THAN_20[num] + " ";
        }
        else if(num<100){
            return TENS[num/10] + " " + calculate(num%10);
        }
        else{ //1000>num>100
            return LESS_THAN_20[num/100] + " Hundred " + calculate(num%100);
        }
    }
}