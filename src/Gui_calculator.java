import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

abstract class Gui_calculator extends JFrame implements ActionListener
{
    Container c;
    JTextField result;
    JPanel p = new JPanel();
    
    JButton b[] =new JButton[16];
    String s[]={"1","2","3","4","5","6","7","8","9","0","+","-","/","*","=","c",};
    
    String Screen="",monitor1="",monitor2="",OperationOnScreen="";
    boolean CommandEmpty=true,switcher=true;
    double R=Integer.MIN_VALUE,L=Integer.MIN_VALUE;
    
    public Gui_calculator()
    {
        super ("Calculator");

        c=getContentPane();
        result =new JTextField();
        result.setEditable(false);
        result.setBackground(Color.white);
       
        p.setLayout(new GridLayout(4,3));
        for(int i=0;i<16;i++)
        {
            b[i]= new JButton(s[i]);
            b[i].addActionListener(this);
            p.add(b[i]);
        }
        c.add(result,BorderLayout.NORTH);
        c.add(p);
        
        setSize(300,300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        }
    public static void main(String[] args)
    {
     new Calculator();   
    }
   public void actoionPerformed(ActionEvent event)
   {
       for(int i=0; i<=9; i++)
       {
           if(event.getSource()==b[i])
           {
               Screen+=i;
               result.setText("");
               result.setText(Screen);
           }
       }
       for(int i=10;i<=14;i++)
       {
           if(event.getSource()==b[i])
           {
             if(result.getText().lastIndexOf(OperationOnScreen)!=-1)
                     result.setText(result.getText().substring(0,result.getText().lastIndexOf(OperationOnScreen))+s[i]);
             else
                 result.setText(result.getText()+s[i]);
               OperationOnScreen = s[i];
               
             if(switcher)
             {monitor1=s[i];switcher=false;}
             else {monitor2=s[i];switcher=true;}
             
             if(monitor1!=monitor2 && monitor2!="")
             {
                if(switcher)
                    {Calc(event,monitor1.charAt(0),monitor2);}
               else {Calc(event,monitor1.charAt(0),monitor2);}
                }
             if(s[i]!="=")
                 Calc(event,s[i].charAt(0),s[i]);
           }
       }
       if(event.getSource()==b[15])
       {
        Screen="";monitor1="";monitor2="";
        switcher=true;CommandEmpty=true;
        result.setText("");
       }
   }  
       public void Calc(ActionEvent event,char OpType,String Operator)
       {            if (Operator=="=")
                        Operator="";
                   
                    if(CommandEmpty && Screen=="")
                    {
                        return;
                    }
                    else if(CommandEmpty && Screen!="")
                    {
                    R=Integer.parseInt(Screen);
                    result.setText(Screen+Operator);
                    Screen="";
                    CommandEmpty=false;
                    }
                    else if(CommandEmpty && Screen!="")
                    {
                    L=Integer.parseInt(Screen);
                    R=Operations(R,L,OpType);
                    Screen="";
                    result.setText("");
                    result.setText(R+Operator);
                    }
           }

    public static double Operations(double R, double L, char opa)
   {
       switch(opa)
       { case '+':
           return R+L;
         case '-':
           return R-L;
         case '*':
           return R*L;
         case '/':
           return R/L;
       }
       return 0;
    }
}

    class string {

        public string() {
        }
    }

    class Calculator {

        public Calculator() {
        }
    }

    

   
       

 