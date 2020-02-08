
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class myFunc {
    
     public ImageIcon resizePic(String picPath,byte[] BLOBpic,int width,int height){
         ImageIcon myImg;
         if(picPath!=null)
         {
             myImg=new ImageIcon(picPath);
         }else{
             
             myImg=new ImageIcon(BLOBpic);
         }
         
     Image img=myImg.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
    ImageIcon myPicture=new ImageIcon(img);
   return myPicture;
     }
public String browseImage(JLabel lbl)
{
    String path=" ";
    
     JFileChooser filec=new JFileChooser();
     filec.setCurrentDirectory(new File(System.getProperty("user.home")));
     FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("*.images","jpg","png","gif","jpeg");
     filec.addChoosableFileFilter(fileFilter);
     int fileState=filec.showSaveDialog(null);
     //if a user selects a file.
     if(fileState==JFileChooser.APPROVE_OPTION){
     File selectedFile=filec.getSelectedFile();
      path=selectedFile.getAbsolutePath();
     
     //display the image in Jlabel
     lbl.setIcon( resizePic(path,null,lbl.getWidth(),lbl.getHeight()));
     
         
     }
    // If the user cancels the picture
     else if(fileState==JFileChooser.CANCEL_OPTION){
     System.out.println("No image is selected");
     }
         return path;
        
}
    
} 
