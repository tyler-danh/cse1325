package gui;
import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons
import javax.swing.JComboBox;

import store.Customer;
import store.Store;
import store.Option;
import store.Order;
import store.Computer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

enum Record {CUSTOMER, OPTION, COMPUTER, ORDER};

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu     file       = new JMenu("File");
        JMenuItem newb       = new JMenuItem("New Store");
        JMenuItem save       = new JMenuItem("Save Store");
        JMenuItem saveAs     = new JMenuItem("Save As");
        JMenuItem load       = new JMenuItem("Load Store");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     insert     = new JMenu("Insert");
        JMenuItem customer   = new JMenuItem("Add Customer");
        JMenuItem option     = new JMenuItem("Add Option");
        JMenuItem computer   = new JMenuItem("Add Computer");
        JMenu     view       = new JMenu("View");
        JMenuItem customers  = new JMenuItem("View Customers");
        JMenuItem options    = new JMenuItem("View Options");
        JMenuItem computers  = new JMenuItem("View Computers");
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
  
        quit .addActionListener(event -> onQuitClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());
        newb.addActionListener(event -> onNewClick());
        load.addActionListener(event -> onLoadClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());

        
        //file.add(anew);
        file.add(newb);
        file.add(save);
        file.add(saveAs);
        file.add(load);
        file.add(quit);
        //help.add(rules);
        help.add(about);
        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        view.add(customers);
        view.add(options);
        view.add(computers);
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("ELSA Controls");

        // Create the 3 buttons using the icons provided
        JButton bAddCustomer = new JButton(new ImageIcon("gui/resources/add_customer.png"));
        bAddCustomer.setActionCommand("Insert Customer");
        bAddCustomer.setToolTipText("Insert Customer");
        toolbar.add(bAddCustomer);
        bAddCustomer.addActionListener(event ->onInsertCustomerClick());

        JButton bAddOption = new JButton(new ImageIcon("gui/resources/add_option.png"));
        bAddOption.setActionCommand("Insert Option");
        bAddOption.setToolTipText("Insert Option");
        toolbar.add(bAddOption);
        bAddOption.addActionListener(event -> onInsertOptionClick());

        JButton bAddComputer = new JButton(new ImageIcon("gui/resources/add_computer.png"));
        bAddComputer.setActionCommand("Insert Computer");
        bAddComputer.setToolTipText("Insert Computer");
        toolbar.add(bAddComputer);
        bAddComputer.addActionListener(event -> onInsertComputerClick());
        
        toolbar.add(Box.createHorizontalStrut(25));

        // Create the 3 buttons using the icons provided
        JButton bViewCustomers = new JButton(new ImageIcon("gui/resources/view_customers.png"));
        bViewCustomers.setActionCommand("View Customer");
        bViewCustomers.setToolTipText("View Customers");
        toolbar.add(bViewCustomers);
        bViewCustomers.addActionListener(event ->onViewClick(Record.CUSTOMER));

        JButton bViewOptions = new JButton(new ImageIcon("gui/resources/view_options.png"));
        bViewOptions.setActionCommand("View Options");
        bViewOptions.setToolTipText("View Options");
        toolbar.add(bViewOptions);
        bViewOptions.addActionListener(event -> onViewClick(Record.OPTION));

        JButton bViewComputers = new JButton(new ImageIcon("gui/resources/view_computers.png"));
        bViewComputers.setActionCommand("View Computers");
        bViewComputers.setToolTipText("View Computers");
        toolbar.add(bViewComputers);
        bViewComputers.addActionListener(event -> onViewClick(Record.COMPUTER));
        
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
       
        
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        
        // Make everything in the JFrame visible
        setVisible(true);
         
        store = new Store("ELSA");
    }
    
    // Listeners
    protected void onNewClick(){
        store = new Store("ELSA");
    }

    protected void onSaveClick(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            store.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to save " + filename + '\n' + e,
                "ERROR", JOptionPane.ERROR_MESSAGE); 
        }

    }

    protected void onSaveAsClick(){
        final JFileChooser fc = new JFileChooser(filename);  
        FileFilter elsaFiles = new FileNameExtensionFilter("ELSA files", "ELSA");
        fc.addChoosableFileFilter(elsaFiles);         
        fc.setFileFilter(elsaFiles);                  
        
        int result = fc.showSaveDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            filename = fc.getSelectedFile();         
            if(!filename.getAbsolutePath().endsWith(".elsa"))  
                filename = new File(filename.getAbsolutePath() + ".elsa");
            onSaveGameClick();                       
        }
    }

    protected void onLoadClick(){
        final JFileChooser fc = new JFileChooser(filename);  
        FileFilter elsaFiles = new FileNameExtensionFilter("ELSA files", "ELSA");
        fc.addChoosableFileFilter(elsaFiles);         
        fc.setFileFilter(elsaFiles);                  
        
        int result = fc.showOpenDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            filename = fc.getSelectedFile();        
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not an ELSA file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible ELSA file format");
                
                store = new Store(br);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "ERROR", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    protected void onInsertCustomerClick(){
        String name = JOptionPane.showInputDialog(this, "Enter Customer Name", "New Customer", JOptionPane.QUESTION_MESSAGE);
        String email = JOptionPane.showInputDialog(this, "Enter Customer Email", "New Customer", JOptionPane.QUESTION_MESSAGE);
        Customer customer = new Customer(name, email);
        try{
            store.add(customer);
            onViewClick(Record.CUSTOMER);
        }catch(NullPointerException e){}
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
        }

    }

    protected void onInsertOptionClick(){
        
        String name = JOptionPane.showInputDialog(this, "Enter Option", "Cost", JOptionPane.PLAIN_MESSAGE);
        String sCost = JOptionPane.showInputDialog(this, "Enter Cost", "Cost", JOptionPane.PLAIN_MESSAGE);
        int iCost = Integer.parseInt(sCost);
        double dCost = (double)iCost;
        dCost*=100;
        long lCost = (long)dCost;
        Option option = new Option(name, lCost);
        try{
            store.add(option);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertComputerClick(){
      try { 
        Computer c = new Computer(
            JOptionPane.showInputDialog(this, "Computer name", 
                "New Computer", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(this, "Computer model", 
                "New Computer", JOptionPane.QUESTION_MESSAGE)
        );
        JComboBox<Object> cb = new JComboBox<>(store.options());
        int optionsAdded = 0; // Don't add computers with no options
        while(true) {
            int button = JOptionPane.showConfirmDialog(this, cb, 
                "Another Option?", JOptionPane.YES_NO_OPTION);
            if(button != JOptionPane.YES_OPTION) break;
            c.addOption((Option) cb.getSelectedItem());
            ++optionsAdded;
        }
        if(optionsAdded > 0) {
            store.add(c);
            onViewClick(Record.COMPUTER);
        }
    } catch(NullPointerException e) {
    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, e, 
            "Computer Not Created", JOptionPane.ERROR_MESSAGE);
    }    

}

    
    protected void onViewClick(Record record) { 
      String header = null;
      Object[] list = null;
      if(record == Record.CUSTOMER) {
          header = "Our Beloved Customers";
          list = store.customers();
      }
      if(record == Record.OPTION) {
         header = "Options for our SuperComputers";
         list = store.options();
      }
      if(record == Record.COMPUTER) {
          header = "Computers for Sale - Cheap!";
          list = store.computers();
      }
      if(record == Record.ORDER) {
          header = "Orders Placed to Date";
          list = store.orders();
      }
      
      StringBuilder sb = new StringBuilder("<html><p><font size=+2>" 
                                + header + "</font></p><br/>\n<ol>\n");
      for(Object i : list) sb.append("<li>" + i.toString().replaceAll("<","&lt;")
                                                          .replaceAll(">", "&gt;")
                                                          .replaceAll("\n", "<br/>") + "</li>\n");
      sb.append("</ol></html>");
      display.setText(sb.toString());
    }
            
    protected void onAboutClick() { 
        Canvas canvas = new Canvas();                // Display About dialog
        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>ELSA</font></p>"
          + "<p>Version 0.69</p>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2023 by Tyler Danh</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          
          + "<br/><p>Add customer from mohamed_hassan per the Content License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/icon-shopping-people-consumer-4500650/</font></p>"

          + "<br/><p>View Customers icon based on work by Ilham Fitrotul Hayat per the Flaticon License</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/group_694642</font></p>"

          + "<br/><p>Add Option icon based on work by Freepik per the Flaticon License</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/quantum-computing_4103999</font></p>"

          + "<br/><p>View Options icon based on work by Freepik per the Flaticon License</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/edge_8002173</font></p>"

          + "<br/><p>Add computer from Clker-Free-Vector-Images per the Content License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/lcd-monitor-computer-32872/</font></p>"

          + "<br/><p>View Computers icon based on work by Futuer per the Flaticon License</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icon/computer-networks_9672993</font></p>"

          + "<br/><p>file_icon from janjf93 per the Content License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/folder-flat-design-icon-symbol-2103508/</font></p>"
 
          + "</html>");
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{canvas, logo, title, artists},
             "ELSA",
             JOptionPane.PLAIN_MESSAGE
         );
     }


    protected void onQuitClick() {System.exit(0);}   // Exit the game
    
    private Store store;
    private JLabel display;
    private File filename;
    private String MAGIC_COOKIE = "LETITGO";
    private String FILE_VERSION = "0.69";
}


