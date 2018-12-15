
import java.util.Scanner;

public class Challenge1 {
	
	public static String solution(String S) {
        // write your code in Java SE 8
		int musicB=0,imageB=0,movieB=0,otherB=0;
		
		Scanner sc = new Scanner(S);
		
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			int bytes = Integer.parseInt(line[1].replace("b", ""));
			String[] name = line[0].split("\\.");
			String type = name[name.length-1];
			
			if (type.equals("mp3") || type.equals("aac") || type.equals("flac")) {
				musicB += bytes;
			}else if(type.equals("jpg") || type.equals("bmp") || type.equals("gif")) {
				imageB += bytes;
			}else if(type.equals("mp4") || type.equals("avi") || type.equals("mkv")) {
				movieB += bytes;
			}else {
				otherB += bytes;
			}
		}
		
		return "music " + musicB + "b\nimages " + imageB + "b\nmovies " + movieB + "b\nother " + otherB + "b";
    }
}
