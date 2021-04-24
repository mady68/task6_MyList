package com.itmady;
import java.util.*;
import java.util.NoSuchElementException;
public class MyArrayList<T> implements Iterable<T> {

       private  T array[];
       private  int sizeSt = 0;
       private  int sizeR = 10;



       public MyArrayList(){
           array = (T[]) new Object[sizeR];
       }

       public MyArrayList(T a){
          sizeSt++;
          array = (T[]) new Object[sizeR];
          //array[sizeSt-1] = a;
           array[0] = a;
       }

       /*public MyArrayList(T[] array1){
           sizeSt=array1.length;
           sizeR = sizeSt;
           array = (T[]) new Object[sizeSt];
           for(int i=0; i<sizeSt;i++)
               array[i]=array1[i];
       }
       */
       public MyArrayList(T[] array1){
        sizeSt=array1.length;
        sizeR = sizeSt;
        array = (T[]) new Object[sizeSt];
        for(int i=0; i<sizeSt;i++)
            array[i]=array1[i];
    }


       public void resize(){
         if(sizeSt+1>sizeR-1){
             //sizeR = (sizeSt*3)/2 + 1;
             sizeR = sizeSt*2;
             T array1[] = (T[]) new Object[sizeR];
             for(int i = 0; i<array.length; i++)
                 array1[i]=array[i];
             array = (T[]) new Object[sizeR];
             array = array1;
         }
       }
       public void resize(int r){

            sizeR = sizeSt+r;
            T array1[] = (T[]) new Object[sizeR];
            for(int i = 0; i<sizeSt; i++)
                array1[i]=array[i];
            array = (T[]) new Object[sizeR];
            array = array1;
        }



       public void set(int index, T a){
           array[index] = a;
       }

       public T get(int index){
           if(index<0||index>sizeSt-1) throw new IndexOutOfBoundsException("index is out of boundary");

           else return array[index];
       }

       public void add(T a){
           resize();
           sizeSt++;
           array[sizeSt-1]= a;
       }
       public void add(T[] mas){
            //resize(sizeSt+mas.length);
           resize(mas.length);
            //sizeSt = sizeSt+mas.length ;
            //array = new int[sizeSt];
            for(int i=0; i<mas.length;i++)
                 array[i+sizeSt]=mas[i];
            sizeSt = sizeSt+mas.length;
    }


       public int getSize(){
           return sizeSt;
       }

       public String toString(){
           return Arrays.toString(array);
       }



       public void delete(int index){
           if (index<0||index>sizeSt-1) throw new IndexOutOfBoundsException("index is out of boundary");
           T del = array[index];

           for(int i = index; i<sizeSt-1; i++)
               array[i]=array[i+1];
           sizeSt--;
           array[sizeSt] = null;
           System.out.println("deleted element "+ "index: "+ index+ " value: "+ del);
       }

       public T[] toArray(){
           T[] array1= (T[]) new Object[sizeSt];
           for(int i = 0; i<sizeSt;i++){
               array1[i]=array[i];
           }
           return array1;
       }

       public void insert(int index, T a){
           if(index<0||index>sizeSt-1) throw new IndexOutOfBoundsException("index is out of boundary");
           resize();
           sizeSt++;
           for(int i = sizeSt-1; i>index; i--)
               array[i] = array[i-1];
           array[index]=a;
       }

       //@Override
       public boolean equals(MyArrayList a){
           if(this == a) return true;
           if(a instanceof MyArrayList){
               MyArrayList list1 = (MyArrayList) a;
               if(this.sizeSt!=list1.sizeSt) return false;
               else for (int i = 0; i<this.sizeSt;i++)
                   if (this.array[i]!=list1.array[i]) return false;
           }
           return true;
       }



        private void toSwap(int first, int second){
        T tempn = array[first];
        array[first] = array[second];
        array[second] = tempn;
         }

        public void sort(Comparator comparator){
        // bubble sort
        for (int j = sizeSt - 1; j >= 1; j--){
            for (int in = 0; in < j; in++){
                if(comparator.compare(array[in], array[in+1])>0)
                    toSwap(in, in + 1);
            }
        }
    }


       public Iterator<T> iterator() {
           return new Iterator() {
               int i = 0;

               public boolean hasNext() { return sizeSt != i; }

               public T next() {
                   if (hasNext()) {
                       return get(i++);
                   }
               else throw new NoSuchElementException("No elements in array");
           }
           public void remove(){
               delete(i);

           }
       };
       }

}
