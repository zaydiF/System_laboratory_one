package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Первое число: ");
        int num1 = inputReader.nextInt();

        System.out.print("Второе число: ");
        int num2 = inputReader.nextInt();

        System.out.println("""
            Выберите способ вычисления:
            1. Математический способ
            2. Битовая арифметика
            3. С помощью BigInteger
            4. Через массивы
            5. Итерационный подход
            6. Рекурсивный метод
            """);

        int option = inputReader.nextInt();
        int result = 0;

        switch(option) {
            case 1 -> result = divisionMethod(num1, num2);
            case 2 -> result = bitwiseMultiply(num1, num2);
            case 3 -> result = bigIntegerMethod(num1, num2);
            case 4 -> result = arrayApproach(num1, num2);
            case 5 -> result = iterativeMultiply(num1, num2);
            case 6 -> result = recursiveMultiply(num1, num2);
            default -> System.out.println("Неверный выбор");
        }

        if(option >= 1 && option <= 6) {
            System.out.println("Результат: " + result);
        }
    }

    private static int divisionMethod(int x, int y) {
        if(y == 0) return 0;
        return (int) (x / (1.0 / y));
    }

    private static int bitwiseMultiply(int x, int y) {
        int product = 0;
        int a = x;
        int b = y;

        while(b != 0) {
            if((b & 1) == 1) {
                product = binaryAdd(product, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return product;
    }

    private static int binaryAdd(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    private static int bigIntegerMethod(int x, int y) {
        BigInteger bigX = BigInteger.valueOf(x);
        BigInteger bigY = BigInteger.valueOf(y);
        return bigX.multiply(bigY).intValue();
    }

    private static int arrayApproach(int x, int y) {
        if(y == 0) return 0;

        int size = Math.abs(y);
        int[] numbers = new int[size];
        Arrays.fill(numbers, Math.abs(x));

        int sum = Arrays.stream(numbers).sum();
        return (x < 0) ^ (y < 0) ? -sum : sum;
    }

    private static int iterativeMultiply(int x, int y) {
        int total = 0;
        if(y > 0) {
            for(int i = 0; i < y; i++) {
                total += x;
            }
        } else if(y < 0) {
            for(int i = 0; i > y; i--) {
                total -= x;
            }
        }
        return total;
    }

    private static int recursiveMultiply(int x, int y) {
        if(y > 0) {
            return x + recursiveMultiply(x, y - 1);
        } else if(y < 0) {
            return -x + recursiveMultiply(x, y + 1);
        }
        return 0;
    }
}