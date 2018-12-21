package BinarySearchTree.Misc;

public class FindConflictingAppointments {
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class IntervalNode {
        Interval interval;
        int max;
        IntervalNode left, right;
        public IntervalNode() {}
        public IntervalNode(Interval interval) {
            this.interval = interval;
        }

        public IntervalNode(Interval interval, int max) {
            this.interval = interval;
            this.max = max;
        }
    }
    public static void main(String[] args) {
        Interval appt[] = { new Interval(1, 5), new Interval(3, 7), new Interval(2, 6), new Interval(10, 15),
                new Interval(5, 6), new Interval(4, 100)};

        IntervalNode root = new IntervalNode(appt[0]);
        printAllConflictingAppointments(appt, root);
    }

    private static void printAllConflictingAppointments(Interval[] appt, IntervalNode root) {
        int size = appt.length;
        for(int i = 1; i < size; i++) {
            Interval query = appt[i];
            System.out.println("Searching for overlapping interval for [" + query.start + "," + query.end + "]");
            Interval result = findOverlappingInterval(root, query);
            if(result == null) {
                System.out.println("No overlapping interval in tree");
            } else {
                System.out.println("The overlapping interval is [" + result.start + "," + result.end + "]");
            }

            root = insert(appt[i], root);
        }
    }

    private static Interval findOverlappingInterval(IntervalNode root, Interval query) {
        if(root == null) {
            return null;
        }

        if(isOverlapping(root.interval, query)) {
            return root.interval;
        }

        if(root.left != null && query.end <= root.left.max) {
            return findOverlappingInterval(root.left, query);
        } else {
            return findOverlappingInterval(root.right, query);
        }

    }

    private static boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.start < interval2.end && interval2.start < interval1.end;
    }

    private static void inorder(IntervalNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        //process root
        System.out.println("[" + root.interval.start + "," + root.interval.end + "] with max of " + root.max );
        inorder(root.right);
    }

    private static IntervalNode insert(Interval interval, IntervalNode root) {
        if(root == null) {
            return new IntervalNode(interval, interval.end);
        }

        if(root.interval.start < interval.start) {
            root.right =  insert(interval, root.right);
        } else {
            root.left =  insert(interval, root.left);
        }

        if(root.max <= interval.end) {
            root.max = interval.end;
        }
        return root;
    }
}
