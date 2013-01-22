public class RadarTest {
    public static void main(String[] args) {
        System.out.println("---- Creating a default Radar ----");
        Radar r1 = new Radar();
        System.out.println("---- Printing the default Radar ----");
        System.out.println(r1);

        System.out.println("\n---- Testing the markRadar method ----");
        System.out.println("---- Marking location -1, 5 m ----");
        System.out.println(r1.markRadar(-1, 5, 'm')); // should fail, invalid spot
        System.out.println("---- Marking location 1, 5 H ----");
        System.out.println(r1.markRadar(1, 5, 'M')); // should work
        System.out.println("---- Marking location 6, 9 h ----");
        System.out.println(r1.markRadar(6, 9, 'h')); // should work
        System.out.println("---- Marking location 0, 10 M ----");
        System.out.println(r1.markRadar(0, 10, 'M')); // should fail, invalid spot
        System.out.println("---- Marking location 10, 10 M ----");
        System.out.println(r1.markRadar(10, 10, 'M')); // should work
        System.out.println("---- Marking location 9, 2 v ----");
        System.out.println(r1.markRadar(9, 2, 'v')); // should fail, invalid hitOrMiss

        System.out.println("\n---- Printing board after marking values ----");
        System.out.println(r1);

        System.out.println("\n---- Testing the getLocation method ----");
        System.out.println("---- Getting location 0, 1 ----");
        System.out.println(r1.getLocation(0, 1));
        System.out.println("---- Getting location 1, 0 ----");
        System.out.println(r1.getLocation(1, 0));
        System.out.println("---- Getting location 11, 1 ----");
        System.out.println(r1.getLocation(11, 1));
        System.out.println("---- Getting location 1, -1 ----");
        System.out.println(r1.getLocation(1, -1));
        System.out.println("---- Getting location 1, 1 ----");
        System.out.println(r1.getLocation(1, 1));
        System.out.println("---- Getting location 5, 9 ----");
        System.out.println(r1.getLocation(5, 9));
        System.out.println("---- Getting location 10, 10 ----");
        System.out.println(r1.getLocation(10, 10));
        System.out.println("---- Getting location 1, 5 ----");
        System.out.println(r1.getLocation(1, 5));
        System.out.println("---- Getting location 6, 9 ----");
        System.out.println(r1.getLocation(6, 9));
    }
}
