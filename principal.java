import java.util.Stack;
//Alejandra Reyes, Keiner Alomia
public class principal 
{
    public static void main(String[] args) 
    {
        Stack<objBanco> pila = new Stack<>();
        metodos m = new metodos();
        m.LlenarPila();
        m.MostrarPila(pila);
        m.opcionesMenu();
        
    }
    
}
