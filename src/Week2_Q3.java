class Superr {
    int num=20;
    public void display()
    {
        System.out.println("super class method");
    }
}

public class Week2_Q3 extends Superr {
    int num;

    public Week2_Q3(int num) {
        this.num=num;
    }

    public void display() {
        System.out.println("display method");
    }

    public void show() {
        this.display();
        display();
        System.out.println(this.num);
        System.out.println(num);
    }
    public static void main(String[]args)
    {
        Week2_Q3 o = new Week2_Q3(10);
        o.show();
    }
}
