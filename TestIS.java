import java.util.*;

public class TestIS {

    public static int[] RandomDistinct() {
        int[] values;

        ArrayList<Integer> generate = new ArrayList<Integer>();

        //Fill arraylist with random and distinct values between 1 and 9999
        while (generate.size() != 1024) {
            int rand = 1 + (int) (Math.random() * 9999);

            if (!generate.contains(rand)) {
                generate.add(rand);
            }
        }

        Collections.sort(generate);
        values = generate.stream().mapToInt(Integer::intValue).toArray();


        return values;
    }

    public static void RunIS(int[] arr, int size) {

        System.out.println("\tKey\t\t" + "  " + "Found\t\tIndex\tDivisions\n" +
                "-------------------------------------------");

        double divisions = 0;
        for (int i = 0; i < size; i++) {

            int key = 1 + (int) (Math.random() * 9999);

            InterpolationSearch obj = new InterpolationSearch(arr, key);

            divisions += obj.getDivisions();

            //System.out.println("\t" + key + "\t\t" + obj.getFound() + "\t\t" + obj.getIndex() + "\t\t\t" + obj.getDivisions());
            System.out.print("\t");
            System.out.printf("%-10d %-10s %-10d %-10d", key, obj.getFound(), obj.getIndex(), obj.getDivisions());
            System.out.println();
        }

        double avg = divisions / (double) size;


        System.out.println("Divisions average: " + String.format("%.3f", avg));
        System.out.println("Difference: " + String.format("%.3f", (3.322 - avg)));
    }

    public static void main(String[] args) {

        int in;

        Scanner scan = new Scanner(System.in);

        int[] values = {};
        int tableSize = 0;

        do {

            System.out.println("---------------MAIN MENU---------------\n" +
                    "1. Create and display array Values[]\n" +
                    "2. Read output table size\n" +
                    "3. Run algorithm and display outputs\n" +
                    "4. Exit program");

            in = scan.nextInt();
            scan.nextLine();


            switch (in) {

                //Execute proper functions according to user input
                case 1:
                    values = RandomDistinct();
                    for (int i = 0; i < values.length; i++) {
                        System.out.format("%-5d", values[i]);


                        if ((i + 1) % 30 == 0) {
                            System.out.println();
                        } else {
                            System.out.print("  ");
                        }

                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter size: ");
                    tableSize = scan.nextInt();
                    scan.nextLine();
                    break;

                case 3:
                    RunIS(values, tableSize);
                    break;

            }


        } while (in != 4);
    }
}
