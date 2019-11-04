package org.quickstart.javase.jdk13;

public class SwitchExample {
    enum Week {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        arrowLabels(Week.MONDAY);
        arrowLabels(Week.THURSDAY);

        System.out.println(switchExpression(1));
        System.out.println(switchExpression(0));

        testYieldingValue(Week.MONDAY);
        testYieldingValue(Week.SUNDAY);
    }

    private static void arrowLabels(Week day) {
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
            default -> System.out.println(-1);
        }
    }

    private static String switchExpression(int k) {
        return switch (k) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "many";
        };
    }

    private static void testYieldingValue(Week day) {
        int j = switch (day) {
            case MONDAY -> 0;
            case TUESDAY -> 1;
            default -> {
                System.out.println(day);
                yield day.toString().length();
            }
        };
        System.out.println(j);

        int result = switch (day) {
            case WEDNESDAY:
                yield 1;
            case THURSDAY:
                yield 2;
            default:
                System.out.println("Neither all, hmmm...");
                yield 0;
        };
        System.out.println(result);
    }
}
