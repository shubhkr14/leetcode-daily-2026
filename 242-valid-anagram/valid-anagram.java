class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        StringBuilder sb=new StringBuilder(t);
        for(int i=0;i<t.length();i++){
            char ch=s.charAt(i);
            int index=sb.indexOf(String.valueOf(ch));
            if(index==-1) return false;
            sb.deleteCharAt(index);
        }
        return true;
    }
}