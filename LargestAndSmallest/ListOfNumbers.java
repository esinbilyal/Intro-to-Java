package com.adastragrp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListOfNumbers {
    private Integer largest = Integer.MIN_VALUE;
    private Integer smallest = Integer.MAX_VALUE;

    public void addNumber(int number) {
        largest = Math.max(number, largest);
        smallest = Math.min(number, smallest);
    }

    public int findLargest() {
        return largest;
    }

    public int findSmallest() {
        return smallest;
    }
}
