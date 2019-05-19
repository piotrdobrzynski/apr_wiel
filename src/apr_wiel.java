public class apr_wiel {

    static double c[] = new double[3];
    static double l[] = new double[3];
    static double n,gr_a,gr_b,iii;

    public static double fun(double x) {
        return (Math.exp(x));
        // (Math.sqrt(6*(Math.pow(x,2))+7)) dobra funkcja
    }


    static double z;
    public static double funkcja(double xi) {

     //   z = Math.pow(xi,iii);
        z = Math.pow(leg(iii,xi),2);
        //   System.out.println(xi+" "+iii+" "+z);
        return z;
    }
    public static double calka(){
        double a, b, h, wyn, x, t, xi, xii, n;

        //granice calkowania
        a = gr_a;
        b = gr_b;

        //ilosc punktow
        n = 20;

        h = (b - a) / n;

        x = 0;
        t = 0;
        for (int i=1; i<n; i++) {
            xi = a + i*h;
            xii = a + (i-1)*h;
            t += funkcja((xi+xii)/2);
            x += funkcja(xi);
        }
        t+= funkcja(b - h /2);
        wyn = (h/6) * (funkcja(a) + funkcja(b) + 2*x + 4*t);
        return wyn;

    }

    static double o;
    public static double funkcja_b(double xi) {

        o = leg(iii,xi)*fun(xi);
        //   System.out.println(xi+" "+iii+" "+z);
        return o;
    }
    public static double calka_b(){
        double a, b, h, wyn, x, t, xi, xii, n;

        //granice calkowania
        a = gr_a;
        b = gr_b;

        //ilosc punktow
        n = 20;

        h = (b - a) / n;

        x = 0;
        t = 0;
        for (int i=1; i<n; i++) {
            xi = a + i*h;
            xii = a + (i-1)*h;
            t += funkcja_b((xi+xii)/2);
            x += funkcja_b(xi);
        }
        t+= funkcja_b(b - h /2);
        wyn = (h/6) * (funkcja_b(a) + funkcja_b(b) + 2*x + 4*t);
        return wyn;

    }

    public static void apr(){
        for (int i=0;i<n+1;i++){
            iii= i;
            l[i] = calka();
        }
        for (int i=0;i<n+1;i++){
            iii = i;
            c[i] = (1/l[i])*calka_b();
        }
    }

    public static void wyn(double x){
        double wyn=0;
        for (int i=0;i<n+1;i++){
            wyn+=c[i]*leg(i,x);
        }
        System.out.println(wyn);
    }

    public static double leg(double i, double x){
        double s=0;
        if(i==0){return 1;}
        if(i==1){return x;}
        s=(1/(i))*(((2*(i-1))+1)*x*leg(i-1,x)-((i-1)*leg(i-2,x)));
        return s;
    }

    public static void pokaz(){
        for (int i=0;i<n+1;i++){System.out.println(l[i]);}
        for (int i=0;i<n+1;i++){System.out.println(c[i]);}
    }


    public static void main(String[] args) {

        n = 2; // stopien wielomianu
        gr_a = -1; // granica dolna
        gr_b = 1; // granica gorna
        apr();
        wyn(1);
        pokaz();

    }


    }

