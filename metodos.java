import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos 
{
    public void opcionesMenu()
    {
        Stack<objBanco> pila = new Stack<>();
        int opc;
        do 
        {
            metodos m = new metodos();
            opc = m.Menu();
            switch (opc) 
            {
                case 1:
                    m.modifPrenda(pila);
                    break;
                case 2:
                    m.venderPren(pila);
                    break;
                case 3:
                    pila = m.elimiRep(pila);
                    break;
                case 4:
                    m.LlenarPila();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "BYE");
                    break;
            }
            
        } while (opc != 6);
    }
    public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("        MENU\n" +
                                                "1:  Actualizar\n" +
                                                "2:  Vender\n" +
                                                "3: Eliminar credito\n" + 
                                                "4. Solicitar credito\n"+
                                                "5: Salir\n");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 6) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public Stack<objBanco> LlenarPila() 
    {
        //este metodo solo es el objeto, el que hace el llenado es validarYactPrenda
        Stack<objBanco> pila = new Stack<>();//Declara variable pila de tipo obj, la pila es una coleccion de objeto
        boolean continuar = true;
        String agregar = "";
        String ingreso;
        while (continuar) 
        {
            objBanco o = new objBanco();
            o.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario"));
            //VALIDA CEDULA
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese la cedula del usuario");
            while (!ingreso.matches("\\d+(\\.\\d+)?")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese cedula valida");
            }
            o.setCedula(Integer.parseInt(ingreso));
            //VALIDA TELEFONO
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese el telefono del usuario");
            while (!ingreso.matches("\\d+")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese cedula valida");
            }
            o.setTelefono(Integer.parseInt(ingreso));
            o.setTipocred(JOptionPane.showInputDialog("Ingrese el tipo de credito"));
            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");
            if (agregar.equalsIgnoreCase("N"))
            {
                continuar = false;
            }
            pila =  validarYactPrenda(pila, o);
        }
        MostrarPila(pila);
        return pila;
    }
    public Stack<objBanco> validarYactPrenda(Stack<objBanco> pila, objBanco LlenarPila )
    {
        boolean encontrado = false;
        for(objBanco cred : pila)
        {
            if (cred.getCedula() == LlenarPila.getCedula()) 
            {
                cred.setTipocred(cred.getTipocred() + LlenarPila.getTipocred());
                encontrado = true;
                JOptionPane.showMessageDialog(null, "El usuario ya existe, se ha actualizado el nuevo tipo de credito");
                break;
            }
        }
        if(!encontrado)
        {
            pila.push(LlenarPila);
            JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
        }
        return pila; 
    }
    public void MostrarPila(Stack<objBanco> pila) 
    {
        for (objBanco cred : pila) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            JOptionPane.showMessageDialog(null, "LA PILA\n"+
                         "Nombre:" + cred.getNombre()+"\n" + "Cedula: " + cred.getCedula() +"\n" +
                         "Telefono: " + cred.getTelefono() + "\n" + "Tipo de credito: " + cred.getTipocred()); 
        }
    }
    public void modifPrenda(Stack<objBanco> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay usuarios ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        int refAMod = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del credito que desea modificar")));
        boolean amodif = false;
        for(objBanco cred : pila)
        {
            if(cred.getCedula() == refAMod)
            {
                    amodif = true;
                    int opc;
                    opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción\n" + "1: Nombre\n" + "2: Telefono\n" +
                                                                     "3: Tipo de credito\n"));
                    switch (opc) 
                    {
                        case 1:
                            String newmarca = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                            cred.setNombre(newmarca);
                        break;
                        case 2:
                            int newcant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo telefono"));
                            cred.setTelefono(newcant);
                        break;
                        case 3:
                            String credito = JOptionPane.showInputDialog("Ingrese el nuevo credito");
                            cred.setNombre(credito);
                        break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no disponible");
                        break;
                    }
                        JOptionPane.showMessageDialog(null, "Modificación realizada correctamente");
                        JOptionPane.showMessageDialog(null, "Datos del usuario modificado\n"+
                        "Nombre:" + cred.getNombre()+"\n" + "Telefono: " + cred.getTelefono() +"\n" +
                        "Tipo de credito: " + cred.getTipocred()); 
                        return;
            }
        }
        if(!amodif)//llega falso porque "como no entra al if de arriba el se comvierte en true" y por eso el !amodif(false)
        {
            JOptionPane.showMessageDialog(null, "Cedula no encontrada");
        }
    }
    public void venderPren(Stack<objBanco> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        int refBusc = 0;
        boolean encontrado = false;
        refBusc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del usuario a vender"));
        
        for(objBanco ropa : pila)
        {
                if(ropa.getCedula() == refBusc)
                {
                    encontrado = true;
                    String newcred = JOptionPane.showInputDialog(null, "Ingrese el nuevo credito");
                        if(newcred == ropa.getTipocred())
                        {
                            ropa.setTipocred(ropa.getTipocred() + newcred);
                            JOptionPane.showMessageDialog(null, "Venta realizada");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Credito insuficiente");
                        }
                    JOptionPane.showMessageDialog(null, "Datos del usario que se le vendio credito\n"+
                        "Nombre:" + ropa.getNombre()+"\n" + "Cedula: " + ropa.getCedula() +"\n" +
                        "Telefono: " + ropa.getTelefono() );  //+ "\n" + "Precio: " + ropa.getPrecio()
                        return;
                }
            
        }
        if(!encontrado)
        {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    }
    public Stack<objBanco> elimiRep (Stack<objBanco> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu 
            //return;
        }
        int refABusc = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del que desea eliminar credito")));
        for(objBanco bici : pila)
        {   
            if(bici.getCedula() == refABusc)
            {
                pila.remove(bici);
                JOptionPane.showMessageDialog(null, "Credito eliminado");
            }
        }
        return pila;
    }

    
    
}
