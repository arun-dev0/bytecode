public class Problem_3{

/* 
        Algorithm 
Start with the x=2250
Have x be the variable, and keep adding a number to it to check throughout the sequence
Divide it by 11
If it has a reminder of 0, keep going
Divide it by 12
If it has a reminder of 0, keep going
Continue until it reaches 20
If it reaches 20 and had a reminder of 0
Print the number
*/


    public static long optimizedFunction() {
        long startTime = System.currentTimeMillis();

        long target_number = 0;
        for (long i = 2530; ; i = i + 20) {
            if (i % 11 == 0) {
                if (i % 13 == 0) {
                    if (i % 14 == 0) {
                        if (i % 16 == 0) {
                            if (i % 17 == 0) {
                                if (i % 18 == 0) {
                                    if (i % 19 == 0) {
                                        if (i % 20 == 0) {
                                            target_number = i;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("optimizedFunction time taken: " + duration + " ms");
        return target_number;
    }

    public static long not_optimizedFunction() {
        long startTime = System.currentTimeMillis();

        long target_number = 0;
        for (long i = 1; ; i = i + 1) {
            if (i % 1 == 0) {
                if (i % 2 == 0) {
                    if (i % 3 == 0) {
                        if (i % 4 == 0) {
                            if (i % 5 == 0) {
                                if (i % 6 == 0) {
                                    if (i % 7 == 0) {
                                        if (i % 8 == 0) {
                                            if (i % 9 == 0) {
                                                if (i % 10 == 0) {
                                                    if (i % 11 == 0) {
                                                        if (i % 12 == 0) {
                                                            if (i % 13 == 0) {
                                                                if (i % 14 == 0) {
                                                                    if (i % 15 == 0) {
                                                                        if (i % 16 == 0) {
                                                                            if (i % 17 == 0) {
                                                                                if (i % 18 == 0) {
                                                                                    if (i % 19 == 0) {
                                                                                        if (i % 20 == 0) {
                                                                                            target_number = i;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("not_optimizedFunction time taken: " + duration + " ms");
        return target_number;
    }

    public static void main(String[] args) throws Exception {
        long optimizedResult = optimizedFunction();
        System.out.println("Optimized result: " + optimizedResult);

        long notOptimizedResult = not_optimizedFunction();
        System.out.println("Not optimized result: " + notOptimizedResult);
    }
}