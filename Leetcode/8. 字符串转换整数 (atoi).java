class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.equals("")) {
			return 0;
		}
        
        //判断开头是字母还是+/-号
        char first = str.charAt(0);
    	boolean flag = false;
    	
    	int sum = 0;
        int i = 0;
        if (first == '-') {
        	i++;
			flag = true;
		}else if (first == '+') {
			i++;
		}
        
        for (; i < str.length(); i++) {
        	char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                
                if (sum > (Integer.MAX_VALUE - (ch-'0')) / 10) {
                	System.out.println(sum);
                    // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                    // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                    return flag? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                sum = sum * 10 + (ch - '0');
            }else{
            	break;
            }
        }
       
        if (flag) {
			sum = -sum;
		}
        return sum;
    }
}