import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
 

//The downalod Manager 
public class DownloadManger extends JFrame {
    private JTextField addTextField;
    private DownloadsTableModel tableModel;
    private JTable table;
    private JButton pauseButton,resumeButton;
    private JButton cancelButton,clearButton;
    private Download selectedDownalod;
    private boolean clearing; //flag for whther or not table selection is begin cleared
    

    public DownloadManger(){
        setTitle("DOwnalod Manager");
        setSize(640,480);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                // actionExit();
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit",
                KeyEvent.VK_X);
        fileExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // actionExit();
            }
        });
        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
         // Set up add panel.
        JPanel addPanel = new JPanel();
        addTextField = new JTextField(30);
         addPanel.add(addTextField);
         JButton addButton = new JButton("Add Download");
         addButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                //  actionAdd();
             }
         });
         addPanel.add(addButton);

         // Set up Downloads table.
        tableModel = new DownloadsTableModel();
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new
                ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
            }
        });
        // Allow only one row at a time to be selected.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
        
    }
       // Set up file menu.
      
  
}
