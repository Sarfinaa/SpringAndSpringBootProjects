package com.task1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class UserDataReader {
public static void main(String[] args) {
String str="";
	try(Scanner s=new Scanner(new File("src/com/task1/data.txt"));){
			UserBean bean = UserBean.getInstance();
			while(s.hasNextLine()) {
				str+=s.nextLine();
			}
			int fname="<first_name>".length();
			int lname="<last_name>".length();
			int fnsidx=str.indexOf("<first_name>");
			int fneidx=str.indexOf("</first_name>");
			int lnsidx=str.indexOf("<last_name>");
			int lneidx=str.indexOf("</last_name>");
			bean.setFirstName(str.substring(fnsidx+fname,fneidx).trim());
			bean.setLastName(str.substring(lnsidx+lname,lneidx).trim());	
			System.out.println(bean);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}