
import javax.swing.*;
import javax.swing.border.Border;

import java.io.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;



public class Frontend extends JFrame implements ActionListener
{

    File f1;
    File f2;
    JButton fileText1;
    JButton fileText2;
    Frontend(String s)
    {
        super(s);
        setLayout(null);
        setSize(700,500);

        JLabel heading = new JLabel("FileUtils: File Merger And Comparator ");
        heading.setBackground(Color.WHITE);
        heading.setBounds(120,10,500,70);
        heading.setForeground(Color.RED);;
        heading.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(heading);


        JLabel file1= new JLabel("File 1:");
       file1.setBounds(120,100,80,50);
       file1.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(file1); 

        fileText1= new JButton("choose file");
        fileText1.setBounds(190, 100, 100, 50);
        add(fileText1);

       

        fileText1.addActionListener(this);

        JLabel file2= new JLabel("File 2:");
        file2.setBounds(120,200,80,50);
        file2.setFont(new Font("Times New Roman",Font.BOLD,20));
       add(file2); 

        fileText2= new JButton("choose file");
        fileText2.setBounds(190, 200, 100, 50);
        add(fileText2);

        fileText2.addActionListener(this);


        JButton perform=new JButton("Perform");
        perform.setBounds(100, 300,160, 50);
        
        add(perform);

        JLabel action = new JLabel("Action To Perform");
        action.setBounds(300,50,160,50);
        action.setForeground(Color.BLUE);;
        action.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(action);

        JRadioButton merge = new JRadioButton("Merge Files");
        merge.setBounds(300, 150, 160, 50);

        JRadioButton compare = new JRadioButton("Compare Files");
        compare.setBounds(300, 250, 160, 50);

        JPanel p =new JPanel();
        p.setBounds(400, 100, 180, 100);
        p.setBackground(Color.WHITE);
        
         ButtonGroup bg =  new ButtonGroup();
        bg.add(merge);
        bg.add(compare);

        p.add(action);
        p.add(merge);
        p.add(compare);
        

        add(p);

        JLabel result = new JLabel("Result ");
        result.setBackground(Color.WHITE);
        result.setBounds(470,200,150,50);
        result.setFont(new Font("Times New Roman",Font.BOLD,20));
        result.setForeground(Color.BLUE);;
        add(result);


        
        JLabel outcome1 = new JLabel("Result will be shown here");
        outcome1.setBackground(Color.WHITE);
        outcome1.setBounds(400,300,150,50);
        add(outcome1);

        JLabel outcome2 = new JLabel("");
        outcome2.setBackground(Color.WHITE);
        outcome2.setBounds(400,350,150,50);
        add(outcome2);

        JPanel p2 =new JPanel();
        p2.setBounds(400, 250, 180, 100);
        p2.setBackground(Color.WHITE);

        p2.add(result);
        p2.add(outcome1);
        p2.add(outcome2);

        add(p2);

        perform.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    //String f1= fileText1.getText();
                    // String f2= fileText2.getText();

                    
                

                if(merge.isSelected())
                {
                    
                    outcome1.setText("File merged to");
                    outcome2.setText( Backend.merge(f1,f2));
                }

                if(compare.isSelected())
                {
                    Integer c1=Backend.countChar(f1);
                    Integer c2=Backend.countChar(f2);
                    Integer lcs=Backend.compareFiles(f1, f2);
                    outcome1.setText("File1= "+c1.toString()+" and File2="+c2.toString()+" char");
                    outcome2.setText("LCS:"+lcs.toString());

                    
                }
            }
                catch (Exception ex) 
                {
                    outcome1.setText("Internal Error");
                }
            }
        });


        

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
        {
                if(e.getSource()==fileText1)
                {
                    JFileChooser fc= new JFileChooser();
                    if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                    {
                        f1=fc.getSelectedFile();
                    };
                }

                if(e.getSource()==fileText2)
                {
                    JFileChooser fc= new JFileChooser();
                    if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                    {
                        f2=fc.getSelectedFile();
                    };
                }
        }
                
        }
    
