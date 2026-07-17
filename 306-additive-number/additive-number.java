class Solution{
    public boolean isAdditiveNumber(String num){
        int n = num.length();

        for (int i = 1; i <= n / 2; i++){
            if (num.charAt(0) == '0' && i > 1) break;

            for (int j = 1; Math.max(i, j) <= n - i - j; j++){
                if (num.charAt(i) == '0' && j > 1) break;

                if (isValid(num, 0, i, i, i + j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String num, int s1, int e1, int s2, int e2){
        while (e2 < num.length()){
            long a = Long.parseLong(num.substring(s1, e1));
            long b = Long.parseLong(num.substring(s2, e2));
            long sum = a + b;

            String sumStr = String.valueOf(sum);

            if (!num.startsWith(sumStr, e2)){
                return false;
            }

            s1 = s2;
            e1 = e2;
            s2 = e2;
            e2 += sumStr.length();
        }

        return true;
    }
}