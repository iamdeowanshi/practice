package com.example.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorImpl implements Iterator<String> {

    private BufferedReader br = null;
    private String line = null;
    public static void main(String[] args) throws IOException {


        IteratorImpl itr = new IteratorImpl("");
        List<String> res = new ArrayList<>();

        if( itr.hasNext()) {
             res.add(itr.next());
        }

    }

    public IteratorImpl(String path) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(path));
    }


    @Override
    public boolean hasNext() {
        try {
            line = br.readLine();
             return (br.readLine() == null) ? false : true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String next() {
        return line;
    }

    @Override
    public void remove() {

    }

    interface NestedInteger
    {
    boolean isInteger();


    Integer getInteger();

    List<NestedInteger> getList();

}
}
