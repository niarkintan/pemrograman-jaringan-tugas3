package praktikum1;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Asus
 */
public class PraktikumController {
     private Praktikum view;
     private List<Integer> list = new ArrayList<>();

     public PraktikumController(Praktikum view) {
         this.view = view;
         this.view.getBtBaca().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 proses();
             }
         });
          
     }
     private void proses() {
         JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
         if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
             BufferedReader reader = null;
            try{
                reader = new BufferedReader(new FileReader(loadFile.getSelectedFile()));
                String data = null;
                doc.insertString(0, "", null);
                while((data = reader.readLine()) != null){
                    doc.insertString(doc.getLength(), data, null);
                    doc.insertString(doc.getLength(),"", null);
                }

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(PraktikumController.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException | BadLocationException ex) {
                 Logger.getLogger(PraktikumController.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
//                 if (inputStream != null) {
//                     try {
//                         inputStream.close();
//                     } catch (IOException ex) {
//                         Logger.getLogger(PraktikumController.class.getName()).log(Level.SEVERE, null, ex);
//                     }
//                 }
             }
         }
     }
     
}
