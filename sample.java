class Solution {
    public int calculate(String s) {
        int num=0;
        int calc=0;
        int tail=0;
        char lastsign = '+';
        for (int i=0;i<s.length();i++) {
            Character c= s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c-'0';
            }
            if ( (!Character.isDigit(c) && c!= ' ') || (i == s.length()-1) ) {
                if (lastsign == '+') {
                    calc = calc + num;
                    tail = +num;
                }
                if (lastsign == '-') {
                    calc = calc - num;
                    tail = -num;
                }
                if (lastsign == '*') {
                    calc = calc - tail + tail * num;
                    tail = tail*num;
                }
                if (lastsign == '/') {
                    calc = calc - tail + tail/num;
                    tail = tail/num;
                }
                lastsign = c;
                num=0;
            }
        }
        return calc;
    }
}
