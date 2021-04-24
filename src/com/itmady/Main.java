package com.itmady;

import com.itmady.MyArrayList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here



        MyArrayList<Integer> arrayList = new MyArrayList<Integer>(45);



        System.out.println(arrayList);
        arrayList.add(65);
        arrayList.add(95);
        arrayList.add(44);
        arrayList.add(23);
        arrayList.add(63);

        System.out.println(arrayList);

        ASCcomparator asCcomparator = new ASCcomparator();
        arrayList.sort(asCcomparator);
        System.out.println(arrayList);
        System.out.println("==============================");

        /*Double[] mas3 = new Double[]{78.45, 233.43, 21233.545, 3444.21};
        MyArrayList<Double> arrayList3 = new MyArrayList<Double>(mas3);
        System.out.println(arrayList3);
        arrayList3.sort(ASCcomparator);
        */

        MyArrayList<String> arrayList1 = new MyArrayList<String>("Chi");
        arrayList1.add("Ford");
        arrayList1.add("Jaguar");
        arrayList1.add("Astra");
        System.out.println(arrayList1);

        ASCcomparSTR asCcomparSTR = new ASCcomparSTR();
        arrayList1.sort(asCcomparSTR);
        System.out.println(arrayList1);

        DESCcomparSTR desCcomparSTR = new DESCcomparSTR();
        arrayList1.sort(desCcomparSTR);
        System.out.println(arrayList1);


        System.out.println("===================================");


        Integer[] mas = new Integer[]{1,2,3,4,5,6,7};
        MyArrayList arrayList2 = new MyArrayList(mas);
        System.out.println(arrayList2);

        arrayList2.add(mas);
        System.out.println(arrayList2);
        DESCcomparator desCcomparator = new DESCcomparator();
        arrayList2.sort(desCcomparator);
        System.out.println(arrayList2);

        ASCcomparator ascComparator = new ASCcomparator();
        arrayList2.sort(ascComparator);
        System.out.println(arrayList2);


        arrayList1.insert(0, "Ferarri");
        System.out.println(arrayList1);
        arrayList1.delete(2);
        System.out.println(arrayList1);


    }
}
