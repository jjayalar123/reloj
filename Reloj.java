/*
Clases Java
Escribir una clase de Java para tratar con la hora del dia,
representado por la hora, los minutos y los segundos. La clase debe
tener los siguientes features:
* Tres instancias de variables: para las horas (rango 0-23), minutos
(rango 0-59) y los segundos (rango 0-59).
* Tres constructores:

** por defecto (sin parametros; inicializa la hora a las

12:00:00)

** un constructor con 3 parametros: horas, minutos y

segundos

** un constructor con 1 parametro: el valor del tiempo en
segundos desde la medianoche (debe ser convertido en los valores
horas, minutos y segundos)
* Metodos:

** meotodo setReloj() con un parametro, que es el valor del

tiempo en segundos desde la medianoche

** metodo getHoras(), getMinutos(), getSegundos(), que

retornan los valores correspondientes

** metodo setHoras(), setMinutos(), setSegundos(),reciben 1
parametro, que setean las correspondientes instancias de variables
** metodo tick(), este debe incrementar el tiempo de los

segundos en 1

** metodo addReloj() acepta un parametro del tipo Reloj. El
metodo debe agregar la hora representada por el objeto en la clase
actual.

** metodo toString(). Debe retornar un String representando
el objeto Reloj en el formato "[hh:mm:ss]", por ejemplo "[22:32:12]"
** metodo tickDecrement(), este debe decrementar el tiempo

de los segundos en 1

** metodo restaReloj() que toma un parametro tipo Reloj y
returna la diferencia de tiempo representada en el objeto de reloj
actual y el representado en el parametro.
Luego crear una clase separada RelojDemo con un metodo main(). El
programa debe:
* instanciar un objeto Reloj, con el constructor de segundos (que
pida al usuario ingresar por el teclado)
* utilizar las funcion tick 10 veces y mostrar la hora cada vez que
se ejecuta
* crear otro objeto reloj y restar la hora con el método
restaReloj()
* */




public class Reloj { //inicio de calse principal
    //variables
    int horas, minutos, segundos;

    // ******** definicion de constructores... ********
    // constructor (tiene el mismo nombre que mi clase y tiene que ser public) por defecto
    public Reloj(){ // contructor por defecto (sin parametros)
        horas=12;
        minutos=0;
        segundos=0;
    }

    public Reloj(int horas1, int minutos1, int segundos1){ // contructor con tres parametros horas, minutos, segundos
        horas=horas1;
        minutos=minutos1;
        segundos=segundos1;
    }

    public Reloj(int segundos){ // contructor por defecto sin parametros
        if (((this.segundos=segundos) >= 0) && ((this.segundos=segundos) <= 86400))
        {
            this.horas = (segundos/3600);
            segundos %= 3600;
            this.minutos=(segundos/60);
            segundos %= 60;
            this.segundos=segundos;
        }
        else
        {
            System.out.println(" Datos invalidos ");
            System.out.println("modifique archivo jajajajajjajaja");
        }
    }

    // ******** definicion de metodos set's ********
    public void setHoras(int horas) { // el set se usa para enviar un valor
        if (horas<=23 && horas>=0){
            this.horas = horas;
        }else {
            System.out.println("Valor incorrecto");
        }
    }

    public void setMinutos(int minutos) { // el set se usa para enviar un valor
        if (minutos<=59 && minutos>=0){
            this.minutos = minutos;
        }else {
            System.out.println("Valor incorrecto");
        }
    }

    public void setSegundos(int segundos) { // el set se usa para enviar un valor
        if (segundos<=59 && segundos>=0){
            this.segundos = segundos;
        }else {
            System.out.println("Valor incorrecto");
        }
    }

    // ******** definicion de metodos set's ********
    public int getHoras() { // el get se usa para retornar un valor
        return horas;
    }

    public int getMinutos() { // el get se usa para retornar un valor
        return minutos;
    }

    public int getSegundos() { // el get se usa para retornar un valor
        return segundos;
    }


    // ******** definicion de metodos ********
    public void setReloj(int segundos) { //86400 segundos maximo en un dia
        if (((this.segundos=segundos) >= 0) && ((this.segundos=segundos) <= 86400))
        {
            this.horas = (segundos/3600);
            segundos %= 3600;
            this.minutos=(segundos/60);
            segundos %= 60;
            this.segundos=segundos;
        }
        else
        {
            System.out.println(" Datos invalidos ");
        }
    }

    public void Tick (){ // INCREMENTA EL TIEMPO DE LOS SEGUNDOS EN 1
        if ((segundos<=59)&(segundos<=0)){
            this.segundos++;
        } else { System.out.println("valor incorrecto"); }
    }

    public void TickDecrement (){ // DECREMENTA EL TIEMPO DE LOS SEGUNDOS EN 1
        if ((segundos<=59)&(segundos<=0)){
            this.segundos--;
        } else { System.out.println("valor incorrecto"); }
    }

    public void addReloj(Reloj reloj){ // pasar a segundos y hacer la suma de las horas
        int seg1, seg2, suma;

        seg1 = (this.horas*3600);
        seg1 += (this.minutos*60);
        seg1 += this.segundos;

        seg2 = (reloj.horas*3600);
        seg2 += (reloj.minutos*60);
        seg2 += reloj.segundos;

        suma=(seg1+seg2);

        if (suma >= 86400-1) // 23h 59min 59seg
        {
            suma-=86400-1;
        }
        setReloj(suma);
    }

    public void restaReloj(Reloj reloj){ // pasar a segundos y hacer la resta de las horas
        int seg1, seg2, resta=0;

        seg1 = (this.horas*3600);
        seg1 += (this.minutos*60);
        seg1 += this.segundos;
        seg1 = (horas+minutos+segundos);

        seg2 = (reloj.horas*3600);
        seg2 += (reloj.minutos*60);
        seg2 += reloj.segundos;
        seg2 = (horas+minutos+segundos);

        if (seg1>=seg2) // 23h 59min 59seg
        {
            resta=(seg1-seg2);
        } if(seg1<=seg2)
          {
            resta=(seg1-seg2);
          }
        setReloj(resta);
    }

    public String toString (){
        return "[" + String.format("%02d", this.horas) + ":" + String.format("%02d",this.minutos) + ":" + String.format("%02d",this.segundos) + "]";
    }

    // ******** definicion de metodo principal ********
    public static void main(String []args){ //inicio del main
        //System.out.println(" Ingrese la hora: ");
        //Reloj reloj1 = new Reloj();
        //Reloj reloj2 = new Reloj(4,6,9);
        Reloj reloj3 = new Reloj(8);
        //reloj3.setSegundos(59);
        //reloj3.setMinutos(59);
        //reloj3.setHoras(9);
        //reloj3.setReloj(25000);
        //reloj3.setReloj(25000);
        //System.out.println(reloj1);
    }//fin del main
} //fin de calse principal

/*
ejemplo auto es un objeto y sus componentes son sus atributos
metodos son aciones que modifican los atributos como por ek cambiar color de pintura
 */ //comentarios
























