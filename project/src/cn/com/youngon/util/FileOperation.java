package cn.com.youngon.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class FileOperation {
	
	private String myfilesUrl;
	
	public  File config;

	public FileOperation(String filename) {
		super();
		javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 
		this.myfilesUrl = fsv.getDefaultDirectory().getPath();
		this.judeDirExists(new File(this.myfilesUrl + "/iYoungonConfig/"));
		this.config = new File(this.myfilesUrl + "/iYoungonConfig/" + filename);
		this.judeFileExists(this.config);
		
	}
	
	public String getMyfilesUrl() {
		return myfilesUrl;
	}
	
	public boolean writeToMyFiles(String content){
		boolean is = false;
		if(this.judeFileExists(this.config)){			
			String filein = content+"\r\n";
			File file = this.config;
	        try {	            
	            @SuppressWarnings("resource")
				PrintStream ps = new PrintStream(new FileOutputStream(file));
	            ps.println(filein);
	            is = true;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		}		
		return is;
	}
	
	public String readByBufferedReader() {  
        try {  
            File file = this.config;           
            BufferedReader bufread;           
            String res="";
            bufread = new BufferedReader(new FileReader(file));
            res = bufread.readLine();
            bufread.close();
            return res;
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();
            return "文件不存在";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "读取文件出错";
        }  
    }
	
	

    // 判断文件是否存在
    public boolean judeFileExists(File file) {
        if (!file.exists()){
            try {
                file.createNewFile();
                this.writeToMyFiles("[文件初始化]");
                return true;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    
    public void judeDirExists(File file) {
        if (!file.exists()){
            file.mkdir();
        }
    }    
    
}
