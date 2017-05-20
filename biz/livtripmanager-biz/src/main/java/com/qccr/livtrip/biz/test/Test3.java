package com.qccr.livtrip.biz.test;

/**
 * Created by xierongli on 17/5/8.
 */
public class Test3 {

    public static void main(String[] args) {
        String m = "www mm ooo ee";
        String pat ="mm";
        System.out.println(search(m,pat));
    }

    public static int search(String txt, String pat) {
        int N = txt.length();
        int M = pat.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
                if (j == M){
                    System.out.println("com ssasa");
                    return i;//匹配成功
                }
            }
        }
        return N;//匹配失败
    }
}
