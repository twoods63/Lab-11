import java.util.*;
class Node {
    Node next;
    Node prev;
    public int release;
    public String title;
    public String director;
    public double cost;
    Node(String director, String title, int release, double cost) {
        this.director = director;
        this.title = title;
        this.release = release;
        this.cost = cost;
        this.next = null;
    }
}
public class BlueRayDisk {
    private Node head;
    private Node tail;
    private int release;
    private String title;
    private String director;
    private double cost;

    public BlueRayDisk() {}
    public BlueRayDisk(String director, String title, int release, double cost) {
        this.director = director;
        this.title = title;
        this.release = release;
        this.cost = cost;
    }
    public void add(String director, String title, int release, double cost) {
        Node node = new Node(director, title, release, cost);
            if(head ==null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }
        }
    @Override
    public String toString() {
        Node temp = head;
        String listData = "";
        while (temp != null) {
            String st = "$" + temp.cost + " " + temp.release + " " + temp.title + ", " + temp.director + "\n";
            temp = temp.next;
            listData += st;
        }
        return listData;
    }
    public void show_all() {
        System.out.println(this);
    }
    public void menu() {
        System.out.println("0. Quit\n1. Add BlueRay to collection\n2. See collection");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        BlueRayDisk blueRayDisk = new BlueRayDisk();
        blueRayDisk.menu();

        while (true) {
            choice = sc.nextInt();
            if(choice == 0) {
                System.exit(0);
            } else if (choice == 1) {
                System.out.println("What is the title?");
                sc.nextLine();
                String title = sc.nextLine();

                System.out.println("What is the director?");
                String director = sc.nextLine();

                System.out.println("What is the year of release?");
                int release = sc.nextInt();
                sc.nextLine();

                System.out.println("What is the cost?");
                double cost = sc.nextDouble();
                blueRayDisk.add(director, title, release, cost);
                System.out.print("\n");
                blueRayDisk.menu();
            } else if (choice == 2) {
                blueRayDisk.show_all();
                blueRayDisk.menu();
            }
        }
    }
}