package com.css.ds.practice.datastructers.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Created by Kishore Routhu on 17/6/17 2:05 PM.
 *
 * Our monk loves food.
 * Hence,he took up position of a manager at Sagar,a restaurant that serves people with delicious food packages.
 * It is a very famous place and people are always queuing up to have one of those packages.
 * Each package has a cost associated with it.
 * The packages are kept as a pile. The job of a manager is very difficult.
 *
 * He needs to handle two types of queries:
 *
 * 1) Customer Query:
 * When a customer demands a package, the food package on the top of the pile is given and the customer is charged according to the cost of the package. This reduces the height of the pile by 1.
 * In case the pile is empty, the customer goes away empty-handed.
 *
 * 2) Chef Query:
 * The chef prepares a food package and adds it on top of the pile. And reports the cost of the package to the Manager.
 * Help him manage the process.
 *
 * Input:
 * First line contains an integer Q, the number of queries. Q lines follow.
 * A Type-1 ( Customer) Query, is indicated by a single integer 1 in the line.
 * A Type-2 ( Chef) Query, is indicated by two space separated integers 2 and C (cost of the package prepared) .
 *
 * Output:
 * For each Type-1 Query, output the price that customer has to pay i.e. cost of the package given to the customer in a new line. If the pile is empty, print "No Food" (without the quotes).
 *
 * Constraints:
 * 1 ≤ Q ≤ 105
 * 1 ≤ C ≤ 107
 *
 * SAMPLE INPUT
 * 6
 * 1
 * 2 5
 * 2 7
 * 2 9
 * 1
 * 1
 *
 * SAMPLE OUTPUT
 * No Food
 * 9
 * 7
 *
 * Explanation
 * Initially, The pile is empty.
 * Chef adds a package with cost=5.
 * Chef adds a package with cost=7.
 * Chef adds a package with cost=9.
 * Customer takes the package on the top i.e. cost=9. Now package of cost=7 on top. Customer takes the package on the top i.e. cost=7.
 *
 */
public class MonkLoveFood {


    static int numChar;
    static int curChar;
    static byte[] buffer = new byte[1024];
    static InputStream stream;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {

        stream = System.in;
        out = new PrintWriter(System.out);

        int q = readInt();
        int a[] = new int[q];
        int top = -1;
        for (int i = 0; i < q; i++) {
            int qi = readInt();
            if (qi == 2)
                a[++top] = readInt();
            else
                out.println(top < 0 ? "No Food" : a[top--]);
        }

        out.flush();
        out.close();

    }

    private static int read() throws IOException {
        if (numChar <= curChar) {
            curChar = 0;
            numChar = stream.read(buffer);
            if (numChar <= 0) {
                return -1;
            }
        }
        return buffer[curChar++];
    }

    private static byte readByte() throws IOException {
        return (byte) readInt();
    }

    private static int readInt() throws IOException, InputMismatchException {
        return (int) readLong();
    }

    private static long readLong() throws IOException, InputMismatchException {
        int c = read();
        if (c == -1)
            throw new IOException();
        while (isSpaceChar(c)) {
            c = read();
        }
        boolean negative = false;
        if (c == '-') {
            negative = true;
            c = read();
        }
        long res = 0;
        while (!isSpaceChar(c)) {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += (c - '0');
            c = read();
        }
        if (negative)
            return -res;
        return res;
    }

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == -1;
    }
}